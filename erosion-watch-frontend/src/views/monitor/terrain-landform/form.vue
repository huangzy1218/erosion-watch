<script setup lang="ts">
import {ref} from "vue";
import {formRules} from "./utils/rule";
import {FormProps} from "./utils/types";

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
    <el-form-item label="地区编号" prop="areaId">
      <el-input v-model="newFormInline.areaId" clearable placeholder="请输入地区编号" />
    </el-form-item>

    <el-form-item label="地形类型" prop="terrainType">
      <el-input v-model="newFormInline.terrainType" clearable placeholder="请输入地形类型" />
    </el-form-item>

    <el-form-item label="地貌类型" prop="landformType">
      <el-input v-model="newFormInline.landformType" clearable placeholder="请输入地貌类型" />
    </el-form-item>

    <el-form-item label="海拔" prop="elevation">
      <el-input-number v-model="newFormInline.elevation" clearable placeholder="请输入海拔" />
    </el-form-item>

    <el-form-item label="坡度" prop="slope">
      <el-input-number v-model="newFormInline.slope" clearable placeholder="请输入坡度" />
    </el-form-item>

    <el-form-item label="土壤类型" prop="soilType">
      <el-input v-model="newFormInline.soilType" clearable placeholder="请输入土壤类型" />
    </el-form-item>

    <el-form-item label="植被类型" prop="vegetationType">
      <el-input v-model="newFormInline.vegetationType" clearable placeholder="请输入植被类型" />
    </el-form-item>

    <el-form-item label="水系" prop="waterSystem">
      <el-input v-model="newFormInline.waterSystem" clearable placeholder="请输入水系" />
    </el-form-item>
  </el-form>
</template>
