package cn.edu.nwafu.erosion.portal.domain.dto;

/**
 * @author Huang Z.Y.
 */
public class SoilTypeDto {
    private Long parentId;
    private String name;
    private Integer level;
    private String soilQuality;
    private String soilMoisture;
    private String description;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
    