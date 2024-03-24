package cn.edu.nwafu.erosion.portal.domain.dto;

/**
 * @author Huang Z.Y.
 */
public class USLEInputDto {
    private String erosionTypeArea;
    // R因子的输入参数
    private double Etotal; // 降雨总动能
    private double I30; // 最大30分钟雨强

    // K因子的输入参数
    private double siltContent; // 粉粒含量（%）
    private double fineSandContent; // 细粒含量
    private double sandContent; // 砂粒含量
    private double organicMatterContent; // 有机物含量
    private double averageAggregate; // 平均聚团体
    private double permeability; // 渗透性

    // LS因子的输入参数
    private double slopeLength; // 坡长
    private double slopeSteepness; // 坡度

    // C因子的输入参数
    private double cropGrowthAreaLoss; // 有作物生长小区土壤流失量
    private double fallowLandLoss; // 休闲地小区土壤流失量
    private double rainfallAndRunoffFactor; // 降雨与径流因子

    // P因子的输入参数
    private double soilSlope; // 土壤坡度(%)
    private String cultivationMethod; // 耕作方式

    public USLEInputDto(double etotal, double i30,
                        double siltContent, double fineSandContent,
                        double sandContent, double organicMatterContent, double averageAggregate,
                        double permeability, double slopeLength, double slopeSteepness,
                        double cropGrowthAreaLoss, double fallowLandLoss,
                        double rainfallAndRunoffFactor, double soilSlope, String cultivationMethod) {
        Etotal = etotal;
        I30 = i30;
        this.siltContent = siltContent;
        this.fineSandContent = fineSandContent;
        this.sandContent = sandContent;
        this.organicMatterContent = organicMatterContent;
        this.averageAggregate = averageAggregate;
        this.permeability = permeability;
        this.slopeLength = slopeLength;
        this.slopeSteepness = slopeSteepness;
        this.cropGrowthAreaLoss = cropGrowthAreaLoss;
        this.fallowLandLoss = fallowLandLoss;
        this.rainfallAndRunoffFactor = rainfallAndRunoffFactor;
        this.soilSlope = soilSlope;
        this.cultivationMethod = cultivationMethod;
    }

    public String getErosionTypeArea() {
        return erosionTypeArea;
    }

    public void setErosionTypeArea(String erosionTypeArea) {
        this.erosionTypeArea = erosionTypeArea;
    }

    public double getEtotal() {
        return Etotal;
    }

    public void setEtotal(double etotal) {
        Etotal = etotal;
    }

    public double getI30() {
        return I30;
    }

    public void setI30(double i30) {
        I30 = i30;
    }

    public double getSiltContent() {
        return siltContent;
    }

    public void setSiltContent(double siltContent) {
        this.siltContent = siltContent;
    }

    public double getFineSandContent() {
        return fineSandContent;
    }

    public void setFineSandContent(double fineSandContent) {
        this.fineSandContent = fineSandContent;
    }

    public double getSandContent() {
        return sandContent;
    }

    public void setSandContent(double sandContent) {
        this.sandContent = sandContent;
    }

    public double getOrganicMatterContent() {
        return organicMatterContent;
    }

    public void setOrganicMatterContent(double organicMatterContent) {
        this.organicMatterContent = organicMatterContent;
    }

    public double getAverageAggregate() {
        return averageAggregate;
    }

    public void setAverageAggregate(double averageAggregate) {
        this.averageAggregate = averageAggregate;
    }

    public double getPermeability() {
        return permeability;
    }

    public void setPermeability(double permeability) {
        this.permeability = permeability;
    }

    public double getSlopeLength() {
        return slopeLength;
    }

    public void setSlopeLength(double slopeLength) {
        this.slopeLength = slopeLength;
    }

    public double getSlopeSteepness() {
        return slopeSteepness;
    }

    public void setSlopeSteepness(double slopeSteepness) {
        this.slopeSteepness = slopeSteepness;
    }

    public double getCropGrowthAreaLoss() {
        return cropGrowthAreaLoss;
    }

    public void setCropGrowthAreaLoss(double cropGrowthAreaLoss) {
        this.cropGrowthAreaLoss = cropGrowthAreaLoss;
    }

    public double getFallowLandLoss() {
        return fallowLandLoss;
    }

    public void setFallowLandLoss(double fallowLandLoss) {
        this.fallowLandLoss = fallowLandLoss;
    }

    public double getRainfallAndRunoffFactor() {
        return rainfallAndRunoffFactor;
    }

    public void setRainfallAndRunoffFactor(double rainfallAndRunoffFactor) {
        this.rainfallAndRunoffFactor = rainfallAndRunoffFactor;
    }

    public double getSoilSlope() {
        return soilSlope;
    }

    public void setSoilSlope(double soilSlope) {
        this.soilSlope = soilSlope;
    }

    public String getCultivationMethod() {
        return cultivationMethod;
    }

    public void setCultivationMethod(String cultivationMethod) {
        this.cultivationMethod = cultivationMethod;
    }
}
    