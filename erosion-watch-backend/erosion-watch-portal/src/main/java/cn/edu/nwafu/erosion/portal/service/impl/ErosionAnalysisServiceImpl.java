package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.portal.analysis.calculator.CFactor;
import cn.edu.nwafu.erosion.portal.analysis.calculator.KFactor;
import cn.edu.nwafu.erosion.portal.analysis.calculator.LSFactor;
import cn.edu.nwafu.erosion.portal.analysis.calculator.PFactor;
import cn.edu.nwafu.erosion.portal.domain.dto.USLEInputDto;
import cn.edu.nwafu.erosion.portal.domain.vo.ErosionInputResultVo;
import cn.edu.nwafu.erosion.portal.service.ErosionAnalysisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class ErosionAnalysisServiceImpl implements ErosionAnalysisService {
    public static final double[][] STRANDS = {
            {Double.MIN_VALUE, 200, 2500, 5000, 8000, 1500, Double.MAX_VALUE},
            {Double.MIN_VALUE, 200, 2500, 5000, 8000, 15000, Double.MAX_VALUE},
            {Double.MIN_VALUE, 200, 2500, 5000, 8000, 15000, Double.MAX_VALUE},
            {Double.MIN_VALUE, 1000, 2500, 5000, 8000, 1500, Double.MAX_VALUE},
            {Double.MIN_VALUE, 500, 2500, 5000, 8000, 1500, Double.MAX_VALUE},
            {Double.MIN_VALUE, 500, 2500, 5000, 8000, 1500, Double.MAX_VALUE},
            {Double.MIN_VALUE, 500, 2500, 5000, 8000, 1500, Double.MAX_VALUE},
            {Double.MIN_VALUE, 500, 2500, 5000, 8000, 1500, Double.MAX_VALUE}
    };

    public static final String[] CONCRETE_DEGREE = {"微度", "轻度", "中度", "强烈", "剧烈", "未知"};
    public static final String[] DESCRIBE_ADJ = {"较低", "很低", "一般", "较重", "严重", "未知"};
    public static final String[] BUT_STILL = {"但仍然", "但仍然", "但仍然", "", "", ""};

    public static HashMap<String, Integer> areaMap = new HashMap<>();

    static {
        areaMap.put("东北黑土区", 0);
        areaMap.put("北方风沙区", 1);
        areaMap.put("北方土石山区", 2);
        areaMap.put("西北黄土高原区", 3);
        areaMap.put("南方红壤区", 4);
        areaMap.put("西南紫色土区", 5);
        areaMap.put("西南岩溶区", 6);
        areaMap.put("青藏高原区", 7);
    }

    @Override
    public ErosionInputResultVo analysis(USLEInputDto usleInputDto) {
        double C = CFactor.calculateCFactor(usleInputDto.getCropGrowthAreaLoss(),
                usleInputDto.getFallowLandLoss(), usleInputDto.getRainfallAndRunoffFactor());
        double K = KFactor.calculateKFactor(usleInputDto.getSiltContent(),
                usleInputDto.getFineSandContent(),
                usleInputDto.getSandContent(),
                usleInputDto.getOrganicMatterContent(),
                usleInputDto.getPermeability(),
                usleInputDto.getAverageAggregate());
        double LS = LSFactor.calculateLS(usleInputDto.getSlopeLength(), usleInputDto.getSlopeSteepness());
        double P = PFactor.calculatePFactor(usleInputDto.getSlopeLength(),
                PFactor.TillageMethod.fromMethod(usleInputDto.getCultivationMethod()));
        double A = C * K * LS * P;
        ErosionInputResultVo erosionInputResultVo = new ErosionInputResultVo();
        erosionInputResultVo.setSoilLoss(A);
        int erosionIntensity = getErosionIntensity(A, areaMap.get(usleInputDto.getErosionTypeArea()));
        erosionInputResultVo.setErosionIntensity(erosionIntensity);
        String description = String.format("根据您提供的数据，我们进行了深入的分析和评估，发现您所在地区的土壤侵蚀等级为%s侵蚀。这意味着该地区的水土流失程度相对%s，%s需要引起我们的关注和重视。因为%s侵蚀如果不加以控制，很可能会逐渐恶化，最终导致严重的土地退化和生态环境问题。因此，我们需要采取一系列措施来防控土壤侵蚀。\n" +
                        "通过植树造林、修建梯田、建设挡土墙等措施，可以有效地减少水土流失，保护土地资源。其次，我们需要合理使用化肥和农药，避免过量使用导致土壤污染和退化。此外，推广节水灌溉技术、加强土地管理等也是防控土壤侵蚀的有效手段。\n" +
                        "除了以上措施，我们还需要加强对土壤侵蚀的监测和评估。通过定期监测土壤侵蚀情况，及时发现和解决问题，确保土地资源的可持续利用。\n", CONCRETE_DEGREE[erosionIntensity],
                DESCRIBE_ADJ[erosionIntensity], BUT_STILL[erosionIntensity],
                CONCRETE_DEGREE[erosionIntensity]);
        erosionInputResultVo.setDescription(description);
        erosionInputResultVo.setDescription(description);
        return erosionInputResultVo;
    }

    private int getErosionIntensity(double A, int index) {
        for (int i = 0; i < STRANDS[index].length - 1; i++) {
            if (A >= STRANDS[index][i] && A < STRANDS[index][i + 1]) {
                return i + 1;
            }
        }
        return 5;
    }
}
    