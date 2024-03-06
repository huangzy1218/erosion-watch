import { http } from "@/utils/http";
import type {
  AreaInfoDto,
  LandManagementPlansDto,
  LandUseChangeHistoryDto,
  MonitoringDataDto, SoilErosionGradeDto, SoilTypeDto, TerrainLandformDto, VegetationCoverageDto
} from "../../types/monitor";
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


export const getLandManagementPlans = (data?: object) => {
  return http.request<ResultTable>(
    "get",
    baseUrlApi("land-management-plans/list"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const searchLandManagementPlans = (data?: object) => {
  return http.request<ResultTable>(
    "post",
    baseUrlApi("land-management-plans/search"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const deleteLandManagementPlan = async (id: number) => {
  return http.request<any>(
    "delete",
    baseUrlApi(`land-management-plans/delete/${id}`),
    {},
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const addLandManagementPlan = async (landManagementPlan: LandManagementPlansDto): Promise<any> => {
  try {
    let response = await http.post(baseUrlApi(`land-management-plans/add`), { data: landManagementPlan },
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

export const updateLandManagementPlan = async (id: number, landManagementPlan: LandManagementPlansDto): Promise<any> => {
  console.log(`更新土地管理计划信息：${landManagementPlan}`);
  try {
    return await http.post(
      baseUrlApi(`land-management-plans/update/${id}`),
      { data: landManagementPlan },
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

export const getLandUseChangeHistory = (data?: object) => {
  return http.request<ResultTable>(
    "get",
    baseUrlApi("land-use-change-history/list"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const searchLandUseChangeHistory = (data?: object) => {
  return http.request<ResultTable>(
    "post",
    baseUrlApi("land-use-change-history/search"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const deleteLandUseChangeHistory = async (id: number) => {
  return http.request<any>(
    "delete",
    baseUrlApi(`land-use-change-history/delete/${id}`),
    {},
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const addLandUseChangeHistory = async (landUseChangeHistory: LandUseChangeHistoryDto): Promise<any> => {
  try {
    let response = await http.post(baseUrlApi(`land-use-change-history/add`), { data: landUseChangeHistory },
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

export const updateLandUseChangeHistory = async (id: number, landUseChangeHistory: LandUseChangeHistoryDto): Promise<any> => {
  console.log(`更新土地利用变更历史信息：${landUseChangeHistory}`);
  try {
    return await http.post(
      baseUrlApi(`land-use-change-history/update/${id}`),
      { data: landUseChangeHistory },
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

export const getMonitoringData = (data?: object) => {
  return http.request<ResultTable>(
    "get",
    baseUrlApi("monitoring-data/list"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const searchMonitoringData = (data?: object) => {
  return http.request<ResultTable>(
    "post",
    baseUrlApi("monitoring-data/search"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const deleteMonitoringData = async (id: number) => {
  return http.request<any>(
    "delete",
    baseUrlApi(`monitoring-data/delete/${id}`),
    {},
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const addMonitoringData = async (monitoringDataDto: MonitoringDataDto): Promise<any> => {
  try {
    let response = await http.post(baseUrlApi(`monitoring-data/add`),
      { data: monitoringDataDto },
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

export const updateMonitoringData = async (id: number, monitoringData: MonitoringDataDto): Promise<any> => {
  console.log(`更新监测数据信息：${monitoringData}`);
  try {
    return await http.post(
      baseUrlApi(`monitoring-data/update/${id}`),
      { data: monitoringData },
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

export const getSoilErosionGrade = (data?: object) => {
  return http.request<ResultTable>(
    "get",
    baseUrlApi("soil-erosion-grade/list"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const searchSoilErosionGrade = (data?: object) => {
  return http.request<ResultTable>(
    "post",
    baseUrlApi("soil-erosion-grade/search"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const deleteSoilErosionGrade = async (id: number) => {
  return http.request<any>(
    "delete",
    baseUrlApi(`soil-erosion-grade/delete/${id}`),
    {},
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const addSoilErosionGrade = async (soilErosionGradeDto: SoilErosionGradeDto): Promise<any> => {
  try {
    let response = await http.post(baseUrlApi(`soil-erosion-grade/add`), { data: soilErosionGradeDto },
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

export const updateSoilErosionGrade = async (id: number, soilErosionGradeDto: SoilErosionGradeDto): Promise<any> => {
  console.log(`更新土壤侵蚀等级信息：${soilErosionGradeDto}`);
  try {
    return await http.post(
      baseUrlApi(`soil-erosion-grade/update/${id}`),
      { data: soilErosionGradeDto },
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

export const getSoilType = (data?: object) => {
  return http.request<ResultTable>(
    "get",
    baseUrlApi("soil-type/list"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const searchSoilType = (data?: object) => {
  return http.request<ResultTable>(
    "post",
    baseUrlApi("soil-type/search"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const deleteSoilType = async (id: number) => {
  return http.request<any>(
    "delete",
    baseUrlApi(`soil-type/delete/${id}`),
    {},
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const addSoilType = async (soilTypeDto: SoilTypeDto): Promise<any> => {
  try {
    let response = await http.post(baseUrlApi(`soil-type/add`), { data: soilTypeDto },
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

export const updateSoilType = async (id: number, soilTypeDto: SoilTypeDto): Promise<any> => {
  console.log(`更新土壤类型信息：${soilTypeDto}`);
  try {
    return await http.post(
      baseUrlApi(`soil-type/update/${id}`),
      { data: soilTypeDto },
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

export const getTerrainLandform = (data?: object) => {
  return http.request<ResultTable>(
    "get",
    baseUrlApi("terrain-landform/list"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const searchTerrainLandform = (data?: object) => {
  return http.request<ResultTable>(
    "post",
    baseUrlApi("terrain-landform/search"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const deleteTerrainLandform = async (id: number) => {
  return http.request<any>(
    "delete",
    baseUrlApi(`terrain-landform/delete/${id}`),
    {},
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const addTerrainLandform = async (terrainLandformDto: TerrainLandformDto): Promise<any> => {
  try {
    let response = await http.post(baseUrlApi(`terrain-landform/add`),
      { data: terrainLandformDto },
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

export const updateTerrainLandform = async (id: number, terrainLandformDto: TerrainLandformDto): Promise<any> => {
  console.log(`更新地形地貌信息：${terrainLandformDto}`);
  try {
    return await http.post(
      baseUrlApi(`terrain-landform/update/${id}`),
      { data: terrainLandformDto },
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

export const getVegetationCoverage = (data?: object) => {
  return http.request<ResultTable>(
    "get",
    baseUrlApi("vegetation-coverage/list"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const searchVegetationCoverage = (data?: object) => {
  return http.request<ResultTable>(
    "post",
    baseUrlApi("vegetation-coverage/search"),
    { data },
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const deleteVegetationCoverage = async (id: number) => {
  return http.request<any>(
    "delete",
    baseUrlApi(`vegetation-coverage/delete/${id}`),
    {},
    {
      headers: {
        Authorization: "Bearer"
      }
    }
  );
};

export const addVegetationCoverage = async (vegetationCoverageDto: VegetationCoverageDto): Promise<any> => {
  try {
    let response = await http.post(baseUrlApi(`vegetation-coverage/add`),
      { data: vegetationCoverageDto },
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

export const updateVegetationCoverage = async (id: number, vegetationCoverageDto: VegetationCoverageDto): Promise<any> => {
  console.log(`更新植被覆盖信息：${vegetationCoverageDto}`);
  try {
    return await http.post(
      baseUrlApi(`vegetation-coverage/update/${id}`),
      { data: vegetationCoverageDto },
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
