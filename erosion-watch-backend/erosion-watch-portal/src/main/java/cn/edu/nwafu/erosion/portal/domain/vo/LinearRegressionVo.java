package cn.edu.nwafu.erosion.portal.domain.vo;

/**
 * @author Huang Z.Y.
 */
public class LinearRegressionVo {
    /**
     * 斜率
     */
    private double slope;
    /**
     * 截距
     */
    private double intercept;
    /**
     * 相关系数
     */
    private double correlationCoefficient;
    /**
     * 残差
     */
    private double[] residuals;
    /**
     * 回归方程
     */
    private String regressionEquation;
    /**
     * 预测值
     */
    private double[] predictedValues;
    /**
     * 拟合优度
     */
    private double goodnessOfFit;

    public LinearRegressionVo() {
    }

    public LinearRegressionVo(double slope, double intercept, double correlationCoefficient,
                              double[] residuals, String regressionEquation, double[] predictedValues,
                              double goodnessOfFit) {
        this.slope = slope;
        this.intercept = intercept;
        this.correlationCoefficient = correlationCoefficient;
        this.residuals = residuals;
        this.regressionEquation = regressionEquation;
        this.predictedValues = predictedValues;
        this.goodnessOfFit = goodnessOfFit;
    }

    // getter 和 setter 方法
    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public double getIntercept() {
        return intercept;
    }

    public void setIntercept(double intercept) {
        this.intercept = intercept;
    }

    public double getCorrelationCoefficient() {
        return correlationCoefficient;
    }

    public void setCorrelationCoefficient(double correlationCoefficient) {
        this.correlationCoefficient = correlationCoefficient;
    }

    public double[] getResiduals() {
        return residuals;
    }

    public void setResiduals(double[] residuals) {
        this.residuals = residuals;
    }

    public String getRegressionEquation() {
        return regressionEquation;
    }

    public void setRegressionEquation(String regressionEquation) {
        this.regressionEquation = regressionEquation;
    }

    public double[] getPredictedValues() {
        return predictedValues;
    }

    public void setPredictedValues(double[] predictedValues) {
        this.predictedValues = predictedValues;
    }

    public double getGoodnessOfFit() {
        return goodnessOfFit;
    }

    public void setGoodnessOfFit(double goodnessOfFit) {
        this.goodnessOfFit = goodnessOfFit;
    }
}
    