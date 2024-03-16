package cn.edu.nwafu.erosion.portal.analysis.calculator;

/**
 * @author Huang Z.Y.
 */
public class LSFactor {
    public static double calculateLS(double slopeAngleDegrees, double slopeLength) {
        double beta = calculateBeta(slopeAngleDegrees);
        System.out.println("beta:" + beta);
        double m = beta / (1 + beta);
        double L = Math.pow(slopeLength / 22.1, m);
        double S = calculateS(slopeAngleDegrees);
        return L * S;
    }

    private static double calculateBeta(double thetaDegree) {
        return (Math.sin(Math.toRadians(thetaDegree) / 0.0896) /
                (3.0 * Math.pow(Math.sin(Math.toRadians(thetaDegree)), 0.8) + 0.56));
    }

    private static double calculateS(double thetaDegree) {
        if (thetaDegree < 5.14) {
            return 10.8 * Math.sin(Math.toRadians(thetaDegree)) + 0.03;
        } else {
            return Math.pow(Math.sin(Math.toRadians(thetaDegree)) / 0.0896, 0.6);
        }
    }

    public static void main(String[] args) {
        double slopeAngleDegrees = 5.14; // 坡度角度示例值
        double slopeLength = 22.1; // 坡长示例值（米）

        double lsFactor = calculateLS(slopeAngleDegrees, slopeLength);
        System.out.println("Calculated LS factor: " + lsFactor);
    }
}
    