// 虽然字段很少 但是抽离出来 后续有扩展字段需求就很方便了

interface FormItemProps {
  id: number | null;
  areaId: number | null;
  monitoringDate: Date | null;
  soilErosionRate: number | null;
  vegetationCoverageRate: number | null;
  rainfallAmount: number | null;
}

interface FormProps {
  formInline: FormItemProps;
}

export type { FormItemProps, FormProps };
