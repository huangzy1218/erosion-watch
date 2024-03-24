package cn.edu.nwafu.erosion.portal.domain.vo;

/**
 * @author Huang Z.Y.
 */
public class ErosionInputResultVo {
    private Double soilLoss;
    private Integer erosionIntensity;
    private String description;

    public Double getSoilLoss() {
        return soilLoss;
    }

    public void setSoilLoss(Double soilLoss) {
        this.soilLoss = soilLoss;
    }

    public Integer getErosionIntensity() {
        return erosionIntensity;
    }

    public void setErosionIntensity(Integer erosionIntensity) {
        this.erosionIntensity = erosionIntensity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
    