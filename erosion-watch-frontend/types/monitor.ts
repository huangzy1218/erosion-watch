export interface AreaInfoDto {
  areaName: string;
  administrativeCode: string;
  latitude: number;
  longitude: number;
  area: number;
  population: number;
  climateType: string;
  terrainFeature: string;
  landformFeature: string;
  landUse: string;
}

export interface AreaSearchDto {
  areaName?: string;
  administrativeCode?: string;
  minLatitude?: number;
  maxLatitude?: number;
  minLongitude?: number;
  maxLongitude?: number;
}

export interface LandManagementPlansDto {
  areaId: number;
  planDate: Date;
  planType: string;
  responsibleUnit: string;
  implementationDate: Date;
  planContent: string;
}

export interface LandManagementPlansSearchDto {
  areaId: number | null;
  planDate: Date | null;
  implementationDate: Date | null;
  planType: string | null;
}

export interface LandUseChangeHistoryDto {
  id: number;
  areaId: number;
  changeDate: Date;
  previousLandUse: string;
  currentLandUse: string;
  changeReason: string;
}

export interface LandManagementPlansSearchDto {
  areaId: number | null;
  planDate: Date | null;
  implementationDate: Date | null;
  planType: string | null;
}

export interface LandUseChangeHistorySearchDto {
  areaId: number | null;
  startDate: Date | null;
  endDate: Date | null;
  previousLandUse: string | null;
  currentLandUse: string | null;
}

export interface MonitoringDataDto {
  areaId: number | null;
  monitoringDate: Date | null;
  soilErosionRate: number | null;
  vegetationCoverageRate: number | null;
  rainfallAmount: number | null;
}

export interface MonitoringDataSearchDto {
  areaId: number | null;
  startDate: Date | null;
  endDate: Date | null;
  minSoilErosionRate: number | null;
  maxSoilErosionRate: number | null;
  minVegetationCoverageRate: number | null;
  maxVegetationCoverageRate: number | null;
  minRainfallAmount: number | null;
  maxRainfallAmount: number | null;
}

export interface SoilErosionGradeDto {
  areaId: number | null;
  erosionType: string;
  erosionGrade: string;
  erosionYears: number | null;
  riskLevel: string;
  erosionDescription: string;
  riskAssessmentResult: string;
  managementPractice: string;
}

export interface SoilErosionGradeSearchDto {
  areaId: number | null;
  erosionType: string;
  erosionGrade: string;
  erosionYears: number | null;
  riskLevel: string;
}

export interface SoilTypeDto {
  parentId: number | null;
  name: string;
  level: number;
  soilQuality: string;
  soilMoisture: string;
  description: string;
}

export interface SoilTypeSearchDto {
  name: string;
  soilQuality: string;
  soilMoisture: string;
}

export interface TerrainLandformDto {
  areaId: number;
  terrainType: string;
  landformType: string;
  elevation: number;
  slope: number;
  soilType: string;
  vegetationType: string;
  waterSystem: string;
}

export interface TerrainLandformSearchDto {
  areaId: number;
  terrainType: string;
  landformType: string;
  minElevation: number;
  maxElevation: number;
  minSlope: number;
  maxSlope: number;
  soilType: string;
  vegetationType: string;
  waterSystem: string;
}

export interface VegetationCoverageDto {
  areaId: number;
  vegetationType: string;
  coveragePercentage: number;
  density: string;
  status: number;
  remarks: string;
}

export interface VegetationCoverageSearchDto {
  areaId: number;
  vegetationType: string;
  minCoveragePercentage: number;
  maxCoveragePercentage: number;
  density: string;
  status: number;
}



