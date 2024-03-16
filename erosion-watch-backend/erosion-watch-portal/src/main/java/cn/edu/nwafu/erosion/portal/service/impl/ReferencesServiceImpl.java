package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.portal.domain.dto.ReferencesDto;
import cn.edu.nwafu.erosion.portal.domain.entity.ReferenceItem;
import cn.edu.nwafu.erosion.portal.domain.entity.ReferencePdf;
import cn.edu.nwafu.erosion.portal.domain.entity.ReferencePdfRelation;
import cn.edu.nwafu.erosion.portal.domain.vo.ReferencesListVo;
import cn.edu.nwafu.erosion.portal.enums.Bucket;
import cn.edu.nwafu.erosion.portal.es.utils.FileUtils;
import cn.edu.nwafu.erosion.portal.mapper.ReferencesMapper;
import cn.edu.nwafu.erosion.portal.mapper.ReferencesRelationMapper;
import cn.edu.nwafu.erosion.portal.service.MinioService;
import cn.edu.nwafu.erosion.portal.service.ReferencesService;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class ReferencesServiceImpl extends ServiceImpl<ReferencesMapper, ReferencePdf>
        implements ReferencesService {
    @Autowired
    private MinioService minioService;
    @Autowired
    private ReferencesMapper referencesMapper;
    @Autowired
    private ReferencesRelationMapper referencesRelationMapper;

    @Override
    public boolean add(MultipartFile file, ReferencesDto referencesDto) {
        String urlPath = upload(file);
        if (urlPath == null) {
            return false;
        }
        if (StrUtil.isEmpty(referencesDto.getLabel())) {
            referencesDto.setLabel(extractTitleFromOrigin(Objects.requireNonNull(file.getOriginalFilename())));
        }
        ReferencePdf pdf = new ReferencePdf();
        pdf.setAuthor(referencesDto.getAuthor());
        pdf.setPdfUrl(urlPath);
        pdf.setAbstractText(referencesDto.getAbstractText());
        pdf.setYear(referencesDto.getYear());
        pdf.setLabel(referencesDto.getLabel());
        pdf.setCreateTime(new Date());
        boolean success = referencesMapper.insert(pdf) != 0;
        if (referencesDto.getParentId() != null) {
            ReferencePdfRelation relation = new ReferencePdfRelation(referencesDto.getParentId(), pdf.getId());
            referencesRelationMapper.insert(relation);
        }
        return success;
    }

    private String upload(MultipartFile file) {
        return minioService.upload(file, Bucket.ref).getUrl();
    }

    @Override
    public ReferencesListVo listAll() {
        List<ReferencePdf> allPdfs = referencesMapper.selectList(null);
        List<ReferenceItem> nodes = allPdfs.stream()
                .filter(pdf -> isRootNode(pdf.getId(), referencesRelationMapper))
                .map(pdf -> convertToReferenceItem(pdf, allPdfs, referencesRelationMapper))
                .collect(Collectors.toList());

        return new ReferencesListVo(nodes);
    }

    @Override
    public List<String> search(String keyword) {
        try {
            return FileUtils.searchDocumentsByKeyword(keyword);
        } catch (IOException e) {
            log.info("查询出错");
        }
        return null;
    }

    public String extractTitleFromOrigin(String fileNameWithExtension) {
        int extensionIndex = fileNameWithExtension.lastIndexOf(".");
        if (extensionIndex == -1) {
            return null;
        }
        return fileNameWithExtension.substring(0, extensionIndex);
    }

    /**
     * 根据关系表判断是否是根节点
     */
    private boolean isRootNode(Long pdfId, ReferencesRelationMapper referencesRelationMapper) {
        return referencesRelationMapper.selectCount(
                new QueryWrapper<ReferencePdfRelation>().eq("child_id", pdfId)) == 0;
    }

    private ReferenceItem convertToReferenceItem(ReferencePdf pdf, List<ReferencePdf> allPdfs,
                                                 ReferencesRelationMapper referencesRelationMapper) {
        ReferenceItem referenceItem = new ReferenceItem();
        referenceItem.setId(pdf.getId());
        referenceItem.setLabel(pdf.getLabel());
        referenceItem.setPdfUrl(pdf.getPdfUrl());

        List<ReferenceItem> children = allPdfs.stream()
                .filter(childPdf -> hasParent(childPdf.getId(), pdf.getId(), referencesRelationMapper))
                .map(childPdf -> convertToReferenceItem(childPdf, allPdfs, referencesRelationMapper))
                .collect(Collectors.toList());

        referenceItem.setChildren(children);
        return referenceItem;
    }

    private boolean hasParent(Long childPdfId, Long parentId, ReferencesRelationMapper referencesRelationMapper) {
        return referencesRelationMapper.selectCount(
                new QueryWrapper<ReferencePdfRelation>()
                        .eq("child_id", childPdfId)
                        .eq("parent_id", parentId)) > 0;
    }
}
    