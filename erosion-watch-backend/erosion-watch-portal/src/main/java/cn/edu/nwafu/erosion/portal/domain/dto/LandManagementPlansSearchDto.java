package cn.edu.nwafu.erosion.portal.domain.dto;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
public class LandManagementPlansSearchDto {
    private Long areaId;
    private Date planDate;
    private Date implementationDate;
    private String planType;


    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Date getImplementationDate() {
        return implementationDate;
    }

    public void setImplementationDate(Date implementationDate) {
        this.implementationDate = implementationDate;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }
}
    