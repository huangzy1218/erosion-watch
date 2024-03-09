import {baseUrlApi} from "@/api/utils";

import {http} from "@/utils/http";

type Result = {
  success: boolean;
  data?: Array<any>;
};

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

export const getFileList = (data?: object) => {
  return http.request<ResultTable>(
    "get",
    baseUrlApi("my-data/list"),
    { data },
    {
      headers: {
        Authorization: "Bearer "
      }
    }
  );
};

export const deleteMyData = async id => {
  return http.request<any>(
    "delete",
    baseUrlApi(`my-data/delete/${id}`),
    {},
    {
      headers: {
        Authorization: "Bearer "
      }
    }
  );
};
