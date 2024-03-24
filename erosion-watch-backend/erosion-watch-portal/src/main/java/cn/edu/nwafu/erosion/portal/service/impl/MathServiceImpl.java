package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.portal.domain.dto.CommonDataDto;
import cn.edu.nwafu.erosion.portal.domain.vo.CommonStatisticsVo;
import cn.edu.nwafu.erosion.portal.domain.vo.HypothesisTestResultVo;
import cn.edu.nwafu.erosion.portal.domain.vo.LinearRegressionVo;
import cn.edu.nwafu.erosion.portal.service.MathService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.stat.inference.TestUtils;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class MathServiceImpl implements MathService {
    @Override
    public List<CommonStatisticsVo> descriptiveAnalysis(CommonDataDto commonDataDto) {
        List<CommonStatisticsVo> result = new ArrayList<>();
        List<List<Double>> data = commonDataDto.getData();
        List<String> headers = commonDataDto.getHeaders();
        int i = 0;
        for (List<Double> column : data) {
            CommonStatisticsVo vo = new CommonStatisticsVo();
            DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

            for (Double value : column) {
                descriptiveStatistics.addValue(value);
            }
            vo.setHeaderName(headers.get(i++));
            vo.setMean(descriptiveStatistics.getMean());
            vo.setMax(descriptiveStatistics.getMax());
            vo.setMin(descriptiveStatistics.getMin());
            vo.setMedian(descriptiveStatistics.getPercentile(50));
            vo.setStandardDeviation(descriptiveStatistics.getStandardDeviation());
            vo.setVariance(descriptiveStatistics.getVariance());

            result.add(vo);
        }
        return result;
    }

    @Override
    public LinearRegressionVo linearRegression(double[] xValues, double[] yValues) {
        SimpleRegression regression = new SimpleRegression();
        for (int i = 0; i < xValues.length; i++) {
            regression.addData(xValues[i], yValues[i]);
        }

        double slope = regression.getSlope();
        double intercept = regression.getIntercept();
        double correlationCoefficient = regression.getR();
        String regressionEquation = "y = " + slope + "x + " + intercept;
        double[] predictedValues = new double[xValues.length];
        for (int i = 0; i < xValues.length; i++) {
            predictedValues[i] = regression.predict(xValues[i]);
        }
        double goodnessOfFit = regression.getRSquare();

        // 计算残差
        double[] residuals = new double[yValues.length];
        for (int i = 0; i < yValues.length; i++) {
            residuals[i] = yValues[i] - predictedValues[i];
        }
        for (int i = 0; i < xValues.length; i++) {
            predictedValues[i] = regression.predict(xValues[i]);
        }

        return new LinearRegressionVo(slope, intercept, correlationCoefficient,
                residuals, regressionEquation, predictedValues, goodnessOfFit);
    }

    @Override
    public HypothesisTestResultVo performTTest(double[] sample1, double[] sample2) {
        HypothesisTestResultVo resultVo = new HypothesisTestResultVo();
        resultVo.setTStatistic(TestUtils.t(sample1, sample2));
        resultVo.setPValue(TestUtils.tTest(sample1, sample2));
        return resultVo;
    }

    @Override
    public HypothesisTestResultVo performChiSquareTest(double[] sample1, double[] sample2) {
        HypothesisTestResultVo resultVo = new HypothesisTestResultVo();
        int n = sample1.length;
        long[] longSample2 = convertDoubleArrayToLongArray(sample2);
        resultVo.setTStatistic(TestUtils.chiSquare(sample1, longSample2));
        resultVo.setPValue(TestUtils.chiSquareTest(sample1, longSample2));
        return resultVo;
    }

    @Override
    public HypothesisTestResultVo performFTest(double[] sample1, double[] sample2) {
        HypothesisTestResultVo resultVo = new HypothesisTestResultVo();

        // 计算 F 检验统计量和 p 值
        double fStatistic = testF(sample1, sample2);
        double pValue = testP(sample1, sample2, fStatistic);

        // 设置结果到 Vo 对象
        resultVo.setTStatistic(fStatistic);
        resultVo.setPValue(pValue);

        return resultVo;
    }

    private double testF(double[] sample1, double[] sample2) {
        SummaryStatistics stats1 = new SummaryStatistics();
        SummaryStatistics stats2 = new SummaryStatistics();

        // 计算两组数据的均值和方差
        for (double value : sample1) {
            stats1.addValue(value);
        }
        for (double value : sample2) {
            stats2.addValue(value);
        }

        double mean1 = stats1.getMean();
        double mean2 = stats2.getMean();
        double var1 = stats1.getVariance();
        double var2 = stats2.getVariance();

        // 计算 F 检验统计量
        double fStatistic = var1 / var2;

        return fStatistic;
    }

    public long[] convertDoubleArrayToLongArray(double[] doubleArray) {
        int n = doubleArray.length;
        long[] longArray = new long[n];
        for (int i = 0; i < n; i++) {
            longArray[i] = (long) doubleArray[i];
        }
        return longArray;
    }

    private double calculatePValue(double fStatistic, int df1, int df2) {
        // 计算自由度
        double numeratorDf = df1;
        double denominatorDf = df2;

        // 使用 F 分布来计算 p 值
        FDistribution fDistribution = new FDistribution(numeratorDf, denominatorDf);
        double pValue = 1.0 - fDistribution.cumulativeProbability(fStatistic);

        return pValue;
    }

    private double testP(double[] sample1, double[] sample2, double fStatistic) {
        // 计算自由度
        int df1 = sample1.length - 1;
        int df2 = sample2.length - 1;

        // 计算 p 值
        double pValue = calculatePValue(fStatistic, df1, df2);

        return pValue;
    }
}
    