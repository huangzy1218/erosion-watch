package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.portal.domain.dto.ReferencesDto;
import cn.edu.nwafu.erosion.portal.domain.vo.ReferencesListVo;
import cn.edu.nwafu.erosion.portal.service.ReferencesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Null;

/**
 * @author Huang Z.Y.
 */
@Api(tags = "ReferencesController")
@Tag(name = "ReferencesController", description = "参考文献")
@RequestMapping("/references")
@Controller
public class ReferencesController {
    @Autowired
    private ReferencesService referencesService;

    @ApiOperation("新增文献")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<Null> add(@RequestPart("file") MultipartFile file,
                                  @RequestParam(required = false) String label,
                                  @RequestParam(required = false) String author,
                                  @RequestParam(required = false) Integer year,
                                  @RequestParam(required = false) String abstractText,
                                  @RequestParam(required = false) Long parentId) {
        ReferencesDto referencesDto = new ReferencesDto(label, author, year, abstractText, parentId);
        boolean success = referencesService.add(file, referencesDto);
        if (success) {
            return CommonResult.success("新增文献成功");
        }
        return CommonResult.success("新增文献失败");
    }

    @ApiOperation("列出所有文献")
    @PostMapping("/list")
    @ResponseBody
    public CommonResult<ReferencesListVo> list() {
        ReferencesListVo listVo = referencesService.listAll();
        return CommonResult.success(listVo);
    }
}
    