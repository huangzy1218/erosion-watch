package cn.edu.nwafu.erosion.portal.analysis.calculator;

/**
 * @author Huang Z.Y.
 */
public class PFactor {
    // 定义坡度区间对应的P值和耕作方式修正
    private static final double[][] P_VALUES = {
            {1, 2, 0.6, 0.30, 0.12},
            {3, 8, 0.5, 0.25, 0.10},
            {9, 12, 0.6, 0.30, 0.12},
            {13, 16, 0.7, 0.35, 0.14},
            {17, 20, 0.8, 0.40, 0.16},
            {21, 25, 0.9, 0.45, 0.18}
    };

    // 计算P因子的方法
    public static double calculatePFactor(double slope, TillageMethod tillageMethod) {
        for (double[] row : P_VALUES) {
            if (slope >= row[0] && slope <= row[1]) {
                // 根据耕作方式选择修正值
                switch (tillageMethod) {
                    case CONTOUR_FARMING:
                        return row[2];
                    case STRIP_CROPPING:
                        return row[3];
                    case TERRACING:
                        return row[4];
                }
            }
        }
        return 0.2;
    }

    public static void main(String[] args) {
        double slope = 9; // 坡度例子
        TillageMethod tillageMethod = TillageMethod.fromMethod("等高耕作"); // 耕作方式例子

        double pFactor = calculatePFactor(slope, tillageMethod);
        System.out.println("P factor: " + pFactor);
    }

    // 用于表示耕作方式的枚举
    public enum TillageMethod {
        CONTOUR_FARMING("等高耕作"), // 等高耕作
        STRIP_CROPPING("等高带状种植并开垅沟"),  // 条带耕作
        TERRACING("修梯田");       // 梯田耕作
        public String method;

        TillageMethod(String method) {
            this.method = method;
        }

        public static TillageMethod fromMethod(String method) {
            for (TillageMethod tillageMethod : TillageMethod.values()) {
                if (tillageMethod.method.equalsIgnoreCase(method)) {
                    return tillageMethod;
                }
            }
            throw new IllegalArgumentException("No constant with method " + method + " found");
        }
    }
}
