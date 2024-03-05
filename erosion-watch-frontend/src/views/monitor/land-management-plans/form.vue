<script setup lang="ts">
import { ref } from "vue";
import { formRules } from "./utils/rule";
import { FormProps } from "./utils/types";

// Assuming FormProps has been updated to include the new fields
const props = withDefaults(defineProps<FormProps>(), {
  formInline: () => ({
    id: null,
    areaName: "",
    administrativeCode: "",
    latitude: null,
    longitude: null,
    area: null,
    population: null,
    climateType: "",
    terrainFeature: "",
    landformFeature: "",
    landUse: ""
  })
});

const ruleFormRef = ref();
const newFormInline = ref(props.formInline);

function getRef() {
  return ruleFormRef.value;
}

defineExpose({ getRef });
</script>


<template>
  <el-form ref="ruleFormRef" :model="newFormInline" :rules="formRules" label-width="120px">
    <el-form-item label="地区名称" prop="areaName">
      <el-input v-model="newFormInline.areaName" clearable placeholder="请输入地区名称" />
    </el-form-item>

    <el-form-item label="行政区划代码" prop="administrativeCode">
      <el-input v-model="newFormInline.administrativeCode" clearable placeholder="请输入行政区划代码" />
    </el-form-item>

    <el-form-item label="地理坐标">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item prop="latitude">
            <el-input-number v-model="newFormInline.latitude" placeholder="请输入纬度" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item prop="longitude">
            <el-input-number v-model="newFormInline.longitude" placeholder="请输入经度" />
          </el-form-item>
        </el-col>
      </el-row>
    </el-form-item>

    <el-form-item label="面积" prop="area">
      <el-input v-model="newFormInline.area" placeholder="请输入面积" />
    </el-form-item>

    <el-form-item label="人口" prop="population">
      <el-input v-model="newFormInline.population" placeholder="请输入人口" />
    </el-form-item>

    <el-form-item label="气候类型" prop="climateType">
      <el-input v-model="newFormInline.climateType" clearable placeholder="请输入气候类型" />
    </el-form-item>

    <el-form-item label="地形特征" prop="terrainFeature">
      <el-input v-model="newFormInline.terrainFeature" clearable placeholder="请输入地形特征" />
    </el-form-item>

    <el-form-item label="地貌特征" prop="landformFeature">
      <el-input v-model="newFormInline.landformFeature" clearable placeholder="请输入地貌特征" />
    </el-form-item>

    <el-form-item label="土地利用情况" prop="landUse">
      <el-input v-model="newFormInline.landUse" clearable placeholder="请输入土地利用情况" />
    </el-form-item>
  </el-form>
</template>
