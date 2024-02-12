package cn.edu.nwafu.api;

/**
 * API 返回码接口
 *
 * @author Huang Z.Y.
 */
public interface IErrorCode {
    /**
     * 返回码
     */
    long getCode();

    /**
     * 返回信息
     */
    String getMessage();
}
