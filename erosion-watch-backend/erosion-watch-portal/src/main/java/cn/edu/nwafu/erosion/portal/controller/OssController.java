package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.erosion.portal.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * OSS 对象存储管理控制器。
 *
 * @author Huang Z.Y.
 */
@Controller
@Api(tags = "OssController")
@Tag(name = "OssController", description = "OSS对象存储管理")
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private OssService ossService;
}
    