<template>
  <el-card>
    <el-text tag="b" size="large">土壤流失方程(USLE)在线分析结果</el-text>
    <el-divider />
    <el-text tag="b" class="left-border">分析流程</el-text>
    <div class="step">
      <el-steps direction="vertical" :space="60" style="transform: scale(0.8)">
        <el-step title="数据源" description="用户输入" />
        <el-step title="算法配置" description="该方程的基本形式为：A=RKLSCP" />
        <el-step
          title="分析结果"
          description="USLE基于土壤侵蚀的主要驱动因素，包括降雨、土壤类型、地形、覆盖度和土地利用。"
        />
      </el-steps>
    </div>
    <el-text tag="b" class="left-border">详细结论</el-text>
    <el-descriptions
      class="margin-top"
      :column="5"
      border
      style="transform: scale(0.8)"
    >
      <el-descriptions-item label="降雨总动能">{{res.code}}</el-descriptions-item>
      <el-descriptions-item label="最大30分钟雨强">156</el-descriptions-item>
      <el-descriptions-item label="粉粒含量（%）">1.23</el-descriptions-item>
      <el-descriptions-item label="细粒含量">100</el-descriptions-item>
      <el-descriptions-item label="砂粒含量">134</el-descriptions-item>
      <el-descriptions-item label="有机物含量">102.1</el-descriptions-item>
      <el-descriptions-item label="平均聚团体">14.40</el-descriptions-item>
      <el-descriptions-item label="渗透性">12.0</el-descriptions-item>
      <el-descriptions-item label="坡长">100</el-descriptions-item>
      <el-descriptions-item label="坡度">4.3</el-descriptions-item>
      <el-descriptions-item label="有作物生长小区土壤流失量"
        >100</el-descriptions-item
      >
      <el-descriptions-item label="休闲地小区土壤流失量"
        >100</el-descriptions-item
      >
      <el-descriptions-item label="降雨与径流因子">13.0</el-descriptions-item>
      <el-descriptions-item label="土壤坡度(%)">32</el-descriptions-item>
      <el-descriptions-item label="耕作方式">等高耕作</el-descriptions-item>
    </el-descriptions>
    <el-row>
      <el-col :span="12">
        <el-statistic title="单位面积上的土壤流失量A" :value="res.data.soilLoss" />
      </el-col>
      <el-col :span="12">
        <el-statistic title="水力侵蚀强度分级" :value="res.data.erosionIntensity">
          <template #suffix>
            <el-icon style="vertical-align: -0.125em">
              <ChatLineRound />
            </el-icon>
          </template>
        </el-statistic>
      </el-col>
      <el-col>
        <el-text size="small" type="info">{{res.data.description}}</el-text>
      </el-col>
    </el-row>
  </el-card>
</template>

<script lang="ts" setup>
import {onMounted, reactive, ref} from "vue";
import { useTransition } from "@vueuse/core";
import { ChatLineRound, Male } from "@element-plus/icons-vue";
import { computed } from "vue";
import useStore from "element-plus/es/components/table/src/store";
import { getInputErosionResult } from "@/api/erosion";
import { useRoute } from "vue-router";
import {FormItemProps, FormProps} from "@/views/data-analysis/utils/types";

// 使用 computed 函数创建计算属性 result
const route = useRoute();

const source = ref(0);
const outputValue = useTransition(source, {
  duration: 1500
});
let res = ref({
  "code": 200,
  "message": "分析成功",
  "data": {
    "soilLoss": 454.4,
    "erosionIntensity": 3,
    "description": "根据您提供的数据，我们进行了深入的分析和评估，发现您所在地区的土壤侵蚀等级为轻度侵蚀。这意味着该地区的水土流失程度相对较轻，但仍然需要引起我们的关注和重视。因为未知侵蚀如果不加以控制，很可能会逐渐恶化，最终导致严重的土地退化和生态环境问题。因此，我们需要采取一系列措施来防控土壤侵蚀。\n通过植树造林、修建梯田、建设挡土墙等措施，可以有效地减少水土流失，保护土地资源。其次，我们需要合理使用化肥和农药，避免过量使用导致土壤污染和退化。此外，推广节水灌溉技术、加强土地管理等也是防控土壤侵蚀的有效手段。\n除了以上措施，我们还需要加强对土壤侵蚀的监测和评估。通过定期监测土壤侵蚀情况，及时发现和解决问题，确保土地资源的可持续利用。\n"
  }
})
let data = withDefaults(defineProps<FormProps>(),{
  formInline: () => ({
    Etotal: 0.0,
    I30: 0.0,
    siltContent: 0.0,
    fineSandContent: 0.0,
    sandContent: 0.0,
    organicMatterContent: 0.0,
    averageAggregate: 0.0,
    permeability: 0.0,
    slopeLength: 0.0,
    slopeSteepness: 0.0,
    cropGrowthAreaLoss: 0.0,
    fallowLandLoss: 0.0,
    rainfallAndRunoffFactor: 0.0,
    soilSlope: 0.0,
    cultivationMethod: "",
    erosionTypeArea: ""
  })
});
onMounted(async () => {
  let dd = JSON.parse(<string>route.query.formInline);
  res = await getInputErosionResult(dd);
  console.log(res);
});
source.value = 172000;
</script>

<style scoped>
.el-col {
  text-align: center;
}

.left-border {
  border-left: #3e6b27 5px solid;
  padding-left: 15px;
}

.step {
  margin-top: 20px;
}
</style>
