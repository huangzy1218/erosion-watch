package cn.edu.nwafu.erosion.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SoilType implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @ApiModelProperty(value = "上级分类的编号：0表示一级分类")
    private Long parentId;
    @ApiModelProperty(value = "土壤类型名称")
    private String name;
    @ApiModelProperty(value = "分类级别：0->1级；1->2级")
    private Integer level;
    @ApiModelProperty(value = "土壤质地")
    private String soilQuality;
    @ApiModelProperty(value = "土壤含水量")
    private String soilMoisture;
    @ApiModelProperty(value = "描述")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", soilQuality=").append(soilQuality);
        sb.append(", soilMoisture=").append(soilMoisture);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}