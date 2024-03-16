package cn.edu.nwafu.erosion.portal.domain.entity;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
public class DailyUsageStats {
    /**
     * 日期
     */
    private Date date;
    /**
     * 注册用户数
     */
    private Long registeredUserCount;
    /**
     * 唯一访客数
     */
    private Long uniqueVisitorCount;
    /**
     * 总访问次数
     */
    private Integer totalVisitsCount;
    /**
     * 上传数据数目
     */
    private Integer uploadDataCount;
    /**
     * 处理数据数目
     */
    private Integer processDataCount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getRegisteredUserCount() {
        return registeredUserCount;
    }

    public void setRegisteredUserCount(Long registeredUserCount) {
        this.registeredUserCount = registeredUserCount;
    }

    public Long getUniqueVisitorCount() {
        return uniqueVisitorCount;
    }

    public void setUniqueVisitorCount(Long uniqueVisitorCount) {
        this.uniqueVisitorCount = uniqueVisitorCount;
    }

    public Integer getTotalVisitsCount() {
        return totalVisitsCount;
    }

    public void setTotalVisitsCount(Integer totalVisitsCount) {
        this.totalVisitsCount = totalVisitsCount;
    }

    public Integer getUploadDataCount() {
        return uploadDataCount;
    }

    public void setUploadDataCount(Integer uploadDataCount) {
        this.uploadDataCount = uploadDataCount;
    }

    public Integer getProcessDataCount() {
        return processDataCount;
    }

    public void setProcessDataCount(Integer processDataCount) {
        this.processDataCount = processDataCount;
    }

    @Override
    public String toString() {
        return "DailyUsageStats{" +
                "date=" + date +
                ", registeredUserCount=" + registeredUserCount +
                ", uniqueVisitorCount=" + uniqueVisitorCount +
                ", totalVisitsCount=" + totalVisitsCount +
                ", uploadDataCount=" + uploadDataCount +
                ", processDataCount=" + processDataCount +
                '}';
    }
}
    