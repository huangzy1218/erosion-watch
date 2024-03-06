import { http } from "@/utils/http";
import type { AreaInfoDto } from "../../types/monitor";
import { baseUrlApi } from "./utils";
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

export const getAreaInfoList = (data?: object) => {
  return http.request<ResultTable>(
    "get",
    baseUrlApi("area-info/list"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const searchAreaInfoList = (data?: object) => {
  return http.request<ResultTable>(
    "post",
    baseUrlApi("area-info/search"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const deleteAreaInfo = async id => {
  return http.request<any>(
    "delete",
    baseUrlApi(`area-info/delete/${id}`),
    {},
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const addAreaInfo = async (areaInfoDto: AreaInfoDto): Promise<any> => {
  console.log(`新增区域信息：${areaInfoDto}`);
  try {
    let response = await http.post(baseUrlApi(`area-info/add`), { data: areaInfoDto },
      {
        headers: {
          Authorization: "Bearer"
        }
      });
    return await response;
  } catch (error) {
    throw error;
  }
};

export const updateAreaInfo = async (
  id: number,
  areaInfoDto: AreaInfoDto
): Promise<any> => {
  console.log(`更新区域信息：${areaInfoDto}`);
  try {
    return await http.post(
      baseUrlApi(`area-info/update/${id}`),
      { data: areaInfoDto },
      {
        headers: {
          Authorization: "Bearer"
        }
      }
    );
  } catch (error) {
    throw error;
  }
};
