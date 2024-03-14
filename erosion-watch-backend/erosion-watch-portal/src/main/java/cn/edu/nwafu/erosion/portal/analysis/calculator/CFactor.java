package cn.edu.nwafu.erosion.portal.analysis.calculator;

/**
 * @author Huang Z.Y.
 */
public class CFactor {
    public static double calculateCFactor(double cropAreaSoilLoss, double fallowAreaSoilLoss, double rainfallRunoffFactor) {
        return cropAreaSoilLoss * fallowAreaSoilLoss * rainfallRunoffFactor / 100;
    }

    public static void main(String[] args) {
        double cropAreaSoilLoss = 1; // 有作物生长小区土壤流失量示例值
        double fallowAreaSoilLoss = 2; // 休闲地小区土壤流失量示例值
        double rainfallRunoffFactor = 600; // 降雨与径流因子示例值

        double cFactor = calculateCFactor(cropAreaSoilLoss, fallowAreaSoilLoss, rainfallRunoffFactor);
        System.out.println("Calculated C factor: " + cFactor);
    }
}
    