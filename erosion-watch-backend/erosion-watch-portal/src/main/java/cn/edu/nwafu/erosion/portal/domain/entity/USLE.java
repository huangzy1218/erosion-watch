package cn.edu.nwafu.erosion.portal.domain.entity;

/**
 * @author Huang Z.Y.
 */
public class USLE {
    /**
     * 降雨与径流因子
     */
    private Double R;
    /**
     * 土壤可蚀性因子
     */
    private Double K;
    /**
     * 地形因子
     */
    private Double LS;
    /**
     * 植被与经营管理因子
     */
    private Double C;
    /**
     * 水土保持措施因子
     */
    private Double P;

    // 构造函数，初始化除R外的所有参数
    public USLE(Double K, Double LS, Double C, Double P) {
        this.K = K;
        this.LS = LS;
        this.C = C;
        this.P = P;
    }

    // 基于降雨总动能和最大30分钟雨强计算R因子的方法
    // 这里假设R的计算方法为简化公式：R = Etotal * I30，实际应用中请替换为准确计算方法
    public void setRFromRainfall(Double Etotal, Double I30) {
        this.R = Etotal * I30;
    }

    public void setKFromSoilType(Double clayPercentage) {
        this.K = 0.2 + 0.3 * (clayPercentage / 100);
    }

    public void setLS(Double slopeLength, Double slopeSteepness) {
        this.LS = (slopeLength / 22.13) * Math.pow((slopeSteepness / 9.0), 1.4);
    }

    public void setCFromVegetationCover(Double vegetationCoverPercentage) {
        this.C = 1 - vegetationCoverPercentage / 100;
    }

    public void setPFromConservationPractice(Double practiceEfficiency) {
        this.P = 1 - practiceEfficiency;
    }

    public double calculateSoilLoss() {
        return R * K * LS * C * P;
    }

    public void setK(double K) {
        this.K = K;
    }

    public void setLS(double LS) {
        this.LS = LS;
    }

    public void setC(double C) {
        this.C = C;
    }

    public void setP(double P) {
        this.P = P;
    }
}
    