import {http} from "@/utils/http";
import {AreaInfoDto} from "../../types/monitor";

type Result = {
  success: boolean;
  data?: Array<any>;
};

type ResultTable = {
  success: boolean;
  data?: {
    /** 列表数据 */
    list: Array<any>;
    /** 总条目数 */
    total?: number;
    /** 每页显示条目个数 */
    pageSize?: number;
    /** 当前页数 */
    currentPage?: number;
  };
};

export const getAreaInfoList = (data?: object) => {
  return http.request<ResultTable>("post", "/land-info/list", { data });
};

export const deleteAreaInfo = async (id) => {
  return http.request<any>(
    "delete",
    `/land-info/delete/${id}`,
  );
};

export const addAreaInfo = async (areaInfoDto: AreaInfoDto): Promise<any> => {
  console.log(`新增区域信息：${areaInfoDto}`);
  try {
    let response = await http.post("/land-info/add", {data: areaInfoDto});
    return await response;
  } catch (error) {
    throw error;
  }
};

export const updateAreaInfo = async (id: number, areaInfoDto: AreaInfoDto): Promise<any> => {
  console.log(`更新区域信息：${areaInfoDto}`);
  try {
    return await http.post(`/land-info/update/${id}`, {data: areaInfoDto});
  } catch (error) {
    throw error;
  }
};
