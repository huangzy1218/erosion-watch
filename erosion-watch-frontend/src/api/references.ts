import { http } from "@/utils/http";
import { baseUrlApi } from "@/api/utils";

type ResultTable = {
  code: number;
  message: string;
  data?: {
    /** 当前页数 */
    pageNum: number;
    /** 每页显示条目个数 */
    pageSize: number;
    /** 总页数 */
    totalPage: number;
    /** 总条目数 */
    total: number;
    /** 列表数据 */
    list: Array<any>;
  };
};

export const getReferencesList = (data?: object) => {
  return http.request<any>(
    "post",
    baseUrlApi("references/list"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

