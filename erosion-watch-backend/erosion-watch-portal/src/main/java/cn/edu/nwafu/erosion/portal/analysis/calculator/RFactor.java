package cn.edu.nwafu.erosion.portal.analysis.calculator;

/**
 * @author Huang Z.Y.
 */
public class RFactor {
    public static double calculateKFactor(double etotal, double i30) {
        return etotal * i30;
    }

    public static void main(String[] args) {
        double etotal = 30;
        double i30 = 20;
        System.out.println("Calculated K factor: " + calculateKFactor(etotal, i30));
    }
}
    