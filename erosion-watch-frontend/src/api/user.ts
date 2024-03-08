import {http} from "@/utils/http";
import {baseUrlApi} from "./utils";

export type UserResult = {
  code: number;
  message: string;
  data: {
    /** 用户名 */
    username: string;
    /** `token` */
    accessToken: string;
    /** 用于调用刷新`accessToken`的接口时所需的`token` */
    refreshToken: string;
    /** `accessToken`的过期时间（格式'xxxx/xx/xx xx:xx:xx'） */
    expires: Date;
  };
};

export type RefreshTokenResult = {
  success: boolean;
  data: {
    /** `token` */
    accessToken: string;
    /** 用于调用刷新`accessToken`的接口时所需的`token` */
    refreshToken: string;
    /** `accessToken`的过期时间（格式'xxxx/xx/xx xx:xx:xx'） */
    expires: Date;
  };
};

/** 登录 */
export const getLogin = (data?: object) => {
  return http.request<UserResult>("post", baseUrlApi("auth/login"), { data },
    {
      headers: {
        Authorization: "Bearer "
      }
    });
};

/** 刷新token */
export const refreshTokenApi = (data?: object) => {
  return http.request<RefreshTokenResult>("post", "/refresh-token", { data });
};

/** 注册 */
export const getRegister = (data?: object) => {
  var promise = http.request<any>("post", baseUrlApi("auth/register"), { data },
    {
      headers: {
        Authorization: "Bearer "
      }
    });
  console.log(data);
  console.log(promise);
  return promise;
}
