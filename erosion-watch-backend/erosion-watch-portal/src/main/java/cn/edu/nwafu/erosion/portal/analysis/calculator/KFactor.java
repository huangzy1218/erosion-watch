package cn.edu.nwafu.erosion.portal.analysis.calculator;

/**
 * @author Huang Z.Y.
 */
public class KFactor {

    // 定义土壤渗透率分类及其K值
    private static final double[] SOIL_PERMEABILITY_K_VALUES = {1, 2, 3, 4};

    // 定义土壤稠密度分类及其K值
    private static final double[] SOIL_COMPACTNESS_K_VALUES = {1, 2, 3, 4, 5, 6};

    // 根据土壤渗透率(mm)计算K值
    public static double calculateKValueForPermeability(double permeability) {
        if (permeability < 1) {
            return SOIL_PERMEABILITY_K_VALUES[0];
        } else if (permeability < 2) {
            return SOIL_PERMEABILITY_K_VALUES[1];
        } else if (permeability <= 10) {
            return SOIL_PERMEABILITY_K_VALUES[2];
        } else {
            return SOIL_PERMEABILITY_K_VALUES[3];
        }
    }

    // 根据土壤稠密度(mm/d)计算K值
    public static double calculateKValueForCompactness(double compactness) {
        if (compactness < 1) {
            return SOIL_COMPACTNESS_K_VALUES[0];
        } else if (compactness <= 10) {
            return SOIL_COMPACTNESS_K_VALUES[1];
        } else if (compactness <= 40) {
            return SOIL_COMPACTNESS_K_VALUES[2];
        } else if (compactness <= 100) {
            return SOIL_COMPACTNESS_K_VALUES[3];
        } else if (compactness <= 300) {
            return SOIL_COMPACTNESS_K_VALUES[4];
        } else {
            return SOIL_COMPACTNESS_K_VALUES[5];
        }
    }

    // 根据M值计算K值
    public static double calculateKValueFromM(double silt, double fineSand, double sand) {
        double M = (silt + fineSand) * (silt + sand) / 10000;
        // 这里你需要定义M值和K值之间的关系。目前只是简单返回M值。
        // 实际中，你可能需要根据M值查表或应用公式来确定K值。
        return M;
    }

    public static double calculateKFactor(double silt, double fineSand,
                                          double sand, double organicMatter,
                                          double permeability, double compactness) {
        double A = calculateKValueForCompactness(compactness);
        double D = calculateKValueForPermeability(permeability);
        double M = calculateKValueFromM(silt, fineSand, sand);
        double OM = organicMatter;
        double K = 2.77e-6 * Math.pow(M, 1.14) * (12 - OM) + 0.043 * (A - 2) + 0.033 * (4 - D);
        return K;
    }

    public static void main(String[] args) {
        // 示例用法
        double permeability = 5; // 土壤渗透率示例值
        double compactness = 50; // 土壤稠密度示例值
        double silt = 10; // 粉粒含量示例值 (%)
        double fineSand = 30; // 细砂含量示例值 (%)
        double sand = 40; // 砂粒含量示例值 (%)
        double organicMatter = 10;

        double kValueForPermeability = calculateKValueForPermeability(permeability);
        double kValueForCompactness = calculateKValueForCompactness(compactness);
        double kValueFromM = calculateKValueFromM(silt, fineSand, sand);
        double K = calculateKFactor(silt, fineSand, sand, organicMatter, permeability, compactness);

        System.out.println("K value for soil permeability: " + kValueForPermeability);
        System.out.println("K value for soil compactness: " + kValueForCompactness);
        System.out.println("K value from M: " + kValueFromM);
        System.out.println("K value: " + K);
    }
}
