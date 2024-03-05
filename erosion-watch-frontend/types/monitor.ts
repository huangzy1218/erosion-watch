export interface AreaInfoDto {
  areaName: string;
  administrativeCode: string;
  latitude: number; // 注意：TypeScript中没有BigDecimal，通常使用number来处理浮点数
  longitude: number;
  area: number;
  population: number;
  climateType: string;
  terrainFeature: string;
  landformFeature: string;
  landUse: string;
}
