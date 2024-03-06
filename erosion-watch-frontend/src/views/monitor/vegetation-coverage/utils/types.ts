// 虽然字段很少 但是抽离出来 后续有扩展字段需求就很方便了

interface FormItemProps {
  id: number | null;
  areaId: number | null;
  vegetationType: string;
  coveragePercentage: number | null;
  density: string;
  status: number | null;
  remarks: string;
}
interface FormProps {
  formInline: FormItemProps;
}

export type { FormItemProps, FormProps };
