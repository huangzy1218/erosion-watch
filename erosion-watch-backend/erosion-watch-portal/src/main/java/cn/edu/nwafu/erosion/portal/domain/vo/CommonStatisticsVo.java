package cn.edu.nwafu.erosion.portal.domain.vo;

/**
 * @author Huang Z.Y.
 */
public class CommonStatisticsVo {
    private String headerName;
    private double mean;
    private double max;
    private double min;
    private double median;
    private double mode;
    private double standardDeviation;
    private double variance;

    public CommonStatisticsVo() {
    }

    public CommonStatisticsVo(double mean, double max, double min, double median, double mode, double standardDeviation, double variance) {
        this.mean = mean;
        this.max = max;
        this.min = min;
        this.median = median;
        this.mode = mode;
        this.standardDeviation = standardDeviation;
        this.variance = variance;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double getMode() {
        return mode;
    }

    public void setMode(double mode) {
        this.mode = mode;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public double getVariance() {
        return variance;
    }

    public void setVariance(double variance) {
        this.variance = variance;
    }
}
    