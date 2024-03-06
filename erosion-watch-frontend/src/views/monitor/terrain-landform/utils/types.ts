// 虽然字段很少 但是抽离出来 后续有扩展字段需求就很方便了

interface FormItemProps {
  id: number | null;
  areaId: number | null;
  terrainType: string;
  landformType: string;
  elevation: number | null;
  slope: number | null;
  soilType: string;
  vegetationType: string;
  waterSystem: string;
}

interface FormProps {
  formInline: FormItemProps;
}

export type { FormItemProps, FormProps };
