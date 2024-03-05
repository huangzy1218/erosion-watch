// 虽然字段很少 但是抽离出来 后续有扩展字段需求就很方便了

interface FormItemProps {
  id: number | null;
  areaName: string;
  administrativeCode: string;
  latitude: number | null;
  longitude: number | null;
  area: number | null;
  population: number | null;
  climateType: string;
  terrainFeature: string;
  landformFeature: string;
  landUse: string;
}
interface FormProps {
  formInline: FormItemProps;
}

export type { FormItemProps, FormProps };
