package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.mapper.LandUseChangeHistoryMapper;
import cn.edu.nwafu.erosion.model.LandUseChangeHistory;
import cn.edu.nwafu.erosion.model.LandUseChangeHistoryExample;
import cn.edu.nwafu.erosion.portal.domain.dto.LandUseChangeHistoryDto;
import cn.edu.nwafu.erosion.portal.domain.dto.LandUseChangeHistorySearchDto;
import cn.edu.nwafu.erosion.portal.service.LandUseChangeHistoryService;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class LandUseChangeHistoryServiceImpl implements LandUseChangeHistoryService {
    @Autowired
    private LandUseChangeHistoryMapper landUseChangeHistoryMapper;

    @Override
    public int add(LandUseChangeHistoryDto landUseChangeHistoryDto) {
        LandUseChangeHistory landUseChangeHistory = LandUseChangeHistory.builder()
                .areaId(landUseChangeHistoryDto.getAreaId())
                .changeDate(landUseChangeHistoryDto.getChangeDate())
                .previousLandUse(landUseChangeHistoryDto.getPreviousLandUse())
                .currentLandUse(landUseChangeHistoryDto.getCurrentLandUse())
                .changeReason(landUseChangeHistoryDto.getChangeReason())
                .build();

        return landUseChangeHistoryMapper.insert(landUseChangeHistory);
    }

    @Override
    public int update(Long id, LandUseChangeHistoryDto landUseChangeHistoryDto) {
        LandUseChangeHistory landUseChangeHistory = LandUseChangeHistory.builder()
                .id(id)
                .areaId(landUseChangeHistoryDto.getAreaId())
                .changeDate(landUseChangeHistoryDto.getChangeDate())
                .previousLandUse(landUseChangeHistoryDto.getPreviousLandUse())
                .currentLandUse(landUseChangeHistoryDto.getCurrentLandUse())
                .changeReason(landUseChangeHistoryDto.getChangeReason())
                .build();

        return landUseChangeHistoryMapper.updateByPrimaryKeySelective(landUseChangeHistory);
    }

    @Override
    public int delete(Long id) {
        return landUseChangeHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public LandUseChangeHistory getById(Long id) {
        return landUseChangeHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<LandUseChangeHistory> listAll() {
        return landUseChangeHistoryMapper.selectByExampleWithBLOBs(new LandUseChangeHistoryExample());
    }

    @Override
    public List<LandUseChangeHistory> search(LandUseChangeHistorySearchDto landUseChangeHistorySearchDto) {
        LandUseChangeHistoryExample example = new LandUseChangeHistoryExample();
        LandUseChangeHistoryExample.Criteria criteria = example.createCriteria();

        if (landUseChangeHistorySearchDto.getAreaId() != null) {
            criteria.andAreaIdEqualTo(landUseChangeHistorySearchDto.getAreaId());
        }
        if (landUseChangeHistorySearchDto.getStartDate() != null
                && landUseChangeHistorySearchDto.getEndDate() != null) {
            criteria.andChangeDateBetween(landUseChangeHistorySearchDto.getStartDate(),
                    landUseChangeHistorySearchDto.getEndDate());
        }
        if (StrUtil.isNotEmpty(landUseChangeHistorySearchDto.getPreviousLandUse())) {
            criteria.andPreviousLandUseEqualTo(landUseChangeHistorySearchDto.getPreviousLandUse());
        }
        if (StrUtil.isNotEmpty(landUseChangeHistorySearchDto.getCurrentLandUse())) {
            criteria.andCurrentLandUseEqualTo(landUseChangeHistorySearchDto.getCurrentLandUse());
        }

        return landUseChangeHistoryMapper.selectByExampleWithBLOBs(example);
    }
}
    