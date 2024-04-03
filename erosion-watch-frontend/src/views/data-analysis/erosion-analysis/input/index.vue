<template>
  <el-card>
    <div>
      <el-form
        ref="ruleFormRef"
        :model="newFormInline"
        :rules="formRules"
        label-width="200px"
        :label-position="'top'"
        :size="'small'"
      >
        <el-form-item label="侵蚀类型区" prop="erosionTypeArea">
          <el-select
            v-model="newFormInline.erosionTypeArea"
            placeholder="请选择"
            size="small"
            style="width: 240px"
          >
            <el-option
              v-for="item in types"
              :key="item.value"
              :label="item.label"
              :value="item.label"
            />
          </el-select>
        </el-form-item>
      </el-form>
      <el-collapse v-model="activeNames">
        <el-collapse-item name="1">
          <template #title>
            <el-icon class="icon-left"><Odometer /></el-icon>
            <el-text tag="b">降雨与径流因子</el-text>
          </template>
          <div class="description">
            <el-text size="small" type="info"
              >降雨径流是指雨水在地表流动形成的水流。</el-text
            >
          </div>
          <div>
            <el-form
              ref="ruleFormRef"
              :model="newFormInline"
              :rules="formRules"
              label-width="200px"
              :label-position="'top'"
              :size="'small'"
            >
              <el-row>
                <el-col :span="6">
                  <el-form-item label="E总(降雨总动能)" prop="Etotal">
                    <el-input-number v-model="newFormInline.Etotal" />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="I30(降雨的最大30分钟雨强)" prop="I30">
                    <el-input-number v-model="newFormInline.I30" />
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
        </el-collapse-item>
        <el-collapse-item title="土壤可蚀性因子" name="2">
          <template #title>
            <el-icon class="icon-left"><Odometer /></el-icon>
            <el-text tag="b">土壤可蚀性因子</el-text>
          </template>
          <div class="description">
            <el-text size="small" type="info">
              是指土壤对侵蚀的敏感性。它是土壤对侵蚀抵抗力的倒数。
            </el-text>
          </div>
          <div>
            <el-form
              ref="ruleFormRef"
              :model="newFormInline"
              :rules="formRules"
              label-width="100px"
              :label-position="'top'"
              :size="'small'"
            >
              <el-row>
                <el-col :span="6">
                  <el-form-item label="粉粒含量(%)" prop="siltContent">
                    <el-input-number v-model="newFormInline.siltContent" />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="细粒含量(%)" prop="fineSandContent">
                    <el-input-number v-model="newFormInline.fineSandContent" />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="砂粒含量(%)" prop="sandContent">
                    <el-input-number v-model="newFormInline.sandContent" />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item
                    label="OM(有机物含量%)"
                    prop="organicMatterContent"
                  >
                    <el-input-number
                      v-model="newFormInline.organicMatterContent"
                    />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="平均团聚体(%)" prop="averageAggregate">
                    <el-input-number v-model="newFormInline.averageAggregate" />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="渗透性(mm/d)" prop="permeability">
                    <el-input-number v-model="newFormInline.permeability" />
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
        </el-collapse-item>
        <el-collapse-item title="地形因子" name="3">
          <template #title>
            <el-icon class="icon-left"><Odometer /></el-icon>
            <el-text tag="b">地形因子</el-text>
          </template>
          <div class="description">
            <el-text size="small" type="info">
              为定量表达地貌形态特征而设定的具有一定意义的数学参数或指标。
            </el-text>
          </div>
          <div>
            <el-form
              ref="ruleFormRef"
              :model="newFormInline"
              :rules="formRules"
              label-width="100px"
              :label-position="'top'"
              :size="'small'"
            >
              <el-row>
                <el-col :span="6">
                  <el-form-item label="S(坡度)" prop="slopeSteepness">
                    <el-input-number v-model="newFormInline.slopeSteepness" />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="L(坡长)" prop="slopeLength">
                    <el-input-number v-model="newFormInline.slopeLength" />
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
        </el-collapse-item>
        <el-collapse-item title="植被与经营管理因子" name="4">
          <template #title>
            <el-icon class="icon-left"><Odometer /></el-icon>
            <el-text tag="b">植被与经营管理因子</el-text>
          </template>
          <div class="description">
            <el-text size="small" type="info">
              植被覆盖和管理措施对土壤侵蚀的作用，是人为控制土壤侵蚀的重要因子。
            </el-text>
          </div>
          <div>
            <el-form
              ref="ruleFormRef"
              :model="newFormInline"
              :rules="formRules"
              label-width="100px"
              :label-position="'top'"
              :size="'small'"
            >
              <el-row>
                <el-col :span="4">
                  <el-form-item
                    label="A(有作物生长小区土壤流失量)"
                    prop="cropGrowthAreaLoss"
                  >
                    <el-input-number
                      v-model="newFormInline.cropGrowthAreaLoss"
                    />
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item
                    label="A'(休闲地小区土壤流失量)"
                    prop="fallowLandLoss"
                  >
                    <el-input-number v-model="newFormInline.fallowLandLoss" />
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item
                    label="R(降雨与径流因子)"
                    prop="rainfallAndRunoffFactor"
                  >
                    <el-input-number
                      v-model="newFormInline.rainfallAndRunoffFactor"
                    />
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
        </el-collapse-item>
        <el-collapse-item title="水土保持措施因子" name="5">
          <template #title>
            <el-icon class="icon-left"><Odometer /></el-icon>
            <el-text tag="b">水土保持措施因子</el-text>
          </template>
          <div>
            <el-text size="small" type="info"
              >指在特定水土保持措施的土壤流失与起伏地耕作的相应土壤流失之比。</el-text
            >
          </div>
          <div>
            <el-form
              ref="ruleFormRef"
              :model="newFormInline"
              :rules="formRules"
              label-width="100px"
              :label-position="'top'"
              :size="'small'"
            >
              <el-row>
                <el-col :span="4">
                  <el-form-item label="土壤坡度(%)" prop="soilSlope">
                    <el-input-number v-model="newFormInline.soilSlope" />
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item label="耕作方式" prop="cultivationMethod">
                    <el-select
                      v-model="newFormInline.cultivationMethod"
                      placeholder="请选择"
                      size="small"
                      style="width: 240px"
                    >
                      <el-option
                        v-for="item in opts"
                        :key="item.value"
                        :label="item.label"
                        :value="item.label"
                      />
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>
    <div class="buttons">
      <el-button type="primary" @click="onSubmit">开始分析</el-button>
      <el-button>重置</el-button>
    </div>
  </el-card>
</template>
<script setup lang="ts">
import { formRules } from "@/views/system/user/utils/rule";
import { Odometer, ElementPlus } from "@element-plus/icons-vue";
import { ref } from "vue";
import {FormItemProps, FormProps} from "@/views/data-analysis/utils/types";
import {
  type LocationQueryRaw,
  type RouteParamsRaw,
  useRouter
} from "vue-router";
import { getInputErosionResult } from "@/api/erosion";

import { store } from "@/store";
import router from "@/router";
const props = withDefaults(defineProps<FormProps>(), {
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
import { useRoute } from "vue-router";

// 使用 computed 函数创建计算属性 result
const route = useRoute();
function onSubmit() {
  router.push({
    path: "/data-analysis/erosion/input/result",
    query: { formInline: JSON.stringify(props.formInline) }
  });
}

const opts = [
  {
    value: "等高耕作",
    label: "等高耕作"
  },
  {
    value: "等高带状种植并开垅沟",
    label: "等高带状种植并开垅沟"
  },
  {
    value: "修梯田",
    label: "修梯田"
  }
];

const types = [
  {
    value: "东北黑土区",
    label: "东北黑土区"
  },
  {
    value: "北方风沙区",
    label: "北方风沙区"
  },
  {
    value: "北方土石山区",
    label: "北方土石山区"
  },
  {
    value: "西北黄土高原区",
    label: "西北黄土高原区"
  },
  {
    value: "南方红壤区",
    label: "南方红壤区"
  },
  {
    value: "西南紫色土区",
    label: "西南紫色土区"
  },
  {
    value: "西南岩溶区",
    label: "西南岩溶区"
  },
  {
    value: "青藏高原区",
    label: "青藏高原区"
  }
];

const activeNames = ref([]);
const newFormInline = ref(props.formInline);
</script>

<style scoped>
.description {
  margin-bottom: 20px;
}

.icon-left {
  color: green;
  margin-right: 10px;
}

.buttons {
  display: flex;
  justify-content: right;
  margin-top: 20px;
}

.el-form-item__label {
  font-weight: normal !important;
}
</style>
