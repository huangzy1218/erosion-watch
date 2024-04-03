interface FormItemProps {
  Etotal: number;
  I30: number;
  siltContent: number;
  fineSandContent: number;
  sandContent: number;
  organicMatterContent: number;
  averageAggregate: number;
  permeability: number;
  slopeLength: number;
  slopeSteepness: number;
  cropGrowthAreaLoss: number;
  fallowLandLoss: number;
  rainfallAndRunoffFactor: number;
  soilSlope: number;
  cultivationMethod: string;
  erosionTypeArea: string;
}
interface FormProps {
  formInline: FormItemProps;
}

export type { FormItemProps, FormProps };
