package cn.edu.nwafu.common.exception;


import cn.edu.nwafu.common.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种 API 异常。
 *
 * @author Huang Z.Y.
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
