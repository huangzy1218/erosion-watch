package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.portal.domain.OssCallbackResult;
import cn.edu.nwafu.erosion.portal.domain.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Oss对象存储管理Service。
 *
 * @author Huang Z.Y.
 */
public interface OssService {
    /**
     * Oss上传策略生成。
     */
    OssPolicyResult policy();

    /**
     * Oss上传成功回调。
     */
    OssCallbackResult callback(HttpServletRequest request);
}
