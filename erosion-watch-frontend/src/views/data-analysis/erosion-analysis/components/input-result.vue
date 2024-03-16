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
      <el-descriptions-item label="降雨总动能">100</el-descriptions-item>
      <el-descriptions-item label="最大30分钟雨强">100</el-descriptions-item>
      <el-descriptions-item label="粉粒含量（%）">100</el-descriptions-item>
      <el-descriptions-item label="细粒含量">100</el-descriptions-item>
      <el-descriptions-item label="砂粒含量">100 </el-descriptions-item>
      <el-descriptions-item label="有机物含量">100</el-descriptions-item>
      <el-descriptions-item label="平均聚团体">100</el-descriptions-item>
      <el-descriptions-item label="渗透性">100</el-descriptions-item>
      <el-descriptions-item label="坡长">100</el-descriptions-item>
      <el-descriptions-item label="坡度">100 </el-descriptions-item>
      <el-descriptions-item label="有作物生长小区土壤流失量"
        >100</el-descriptions-item
      >
      <el-descriptions-item label="休闲地小区土壤流失量"
        >100</el-descriptions-item
      >
      <el-descriptions-item label="降雨与径流因子">100</el-descriptions-item>
      <el-descriptions-item label="土壤坡度(%)">100 </el-descriptions-item>
      <el-descriptions-item label="耕作方式">100</el-descriptions-item>
    </el-descriptions>
    <el-row>
      <el-col :span="6">
        <el-statistic title="Daily active users" :value="268500" />
      </el-col>
      <el-col :span="6">
        <el-statistic :value="138">
          <template #title>
            <div style="display: inline-flex; align-items: center">
              Ratio of men to women
              <el-icon style="margin-left: 4px" :size="12">
                <Male />
              </el-icon>
            </div>
          </template>
          <template #suffix>/100</template>
        </el-statistic>
      </el-col>
      <el-col :span="6">
        <el-statistic title="Total Transactions" :value="outputValue" />
      </el-col>
      <el-col :span="6">
        <el-statistic title="Feedback number" :value="562">
          <template #suffix>
            <el-icon style="vertical-align: -0.125em">
              <ChatLineRound />
            </el-icon>
          </template>
        </el-statistic>
      </el-col>
    </el-row>
  </el-card>
</template>

<script lang="ts" setup>
import { ref } from "vue";
import { useTransition } from "@vueuse/core";
import { ChatLineRound, Male } from "@element-plus/icons-vue";

const source = ref(0);
const outputValue = useTransition(source, {
  duration: 1500
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
