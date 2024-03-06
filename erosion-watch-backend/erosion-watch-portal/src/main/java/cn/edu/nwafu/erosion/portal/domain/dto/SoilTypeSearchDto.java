package cn.edu.nwafu.erosion.portal.domain.dto;

/**
 * @author Huang Z.Y.
 */
public class SoilTypeSearchDto {
    private String name;
    private String soilQuality;
    private String soilMoisture;
    private Long parentId;

    private Integer level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoilQuality() {
        return soilQuality;
    }

    public void setSoilQuality(String soilQuality) {
        this.soilQuality = soilQuality;
    }

    public String getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(String soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
    