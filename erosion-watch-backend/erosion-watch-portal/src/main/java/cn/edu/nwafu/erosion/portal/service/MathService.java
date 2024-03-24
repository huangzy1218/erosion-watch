package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.portal.domain.dto.CommonDataDto;
import cn.edu.nwafu.erosion.portal.domain.vo.CommonStatisticsVo;
import cn.edu.nwafu.erosion.portal.domain.vo.HypothesisTestResultVo;
import cn.edu.nwafu.erosion.portal.domain.vo.LinearRegressionVo;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface MathService {
    List<CommonStatisticsVo> descriptiveAnalysis(CommonDataDto commonDataDto);

    LinearRegressionVo linearRegression(double[] xValues, double[] yValues);

    HypothesisTestResultVo performTTest(double[] sample1, double[] sample2);

    HypothesisTestResultVo performChiSquareTest(double[] sample1, double[] sample2);

    HypothesisTestResultVo performFTest(double[] sample1, double[] sample2);
}
