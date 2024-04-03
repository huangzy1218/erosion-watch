import { http } from "@/utils/http";
import {baseUrlApi} from "@/api/utils";

type Result = {
  success: boolean;
  data?: {
    /** 列表数据 */
    list: Array<any>;
  };
};

/** 卡片列表 */
export const getInputErosionResult = (data?: object) => {
  return http.request<any>(
    "post",
    baseUrlApi("/erosion-analysis/input"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};
