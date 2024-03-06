<script setup lang="ts">
import {ref} from "vue";
import {formRules} from "./utils/rule";
import {FormProps} from "./utils/types";

// Assuming FormProps has been updated to include the new fields
const props = withDefaults(defineProps<FormProps>(), {
  formInline: () => ({
    id: null,
    areaId: null,
    monitoringDate: null,
    soilErosionRate: null,
    vegetationCoverageRate: null,
    rainfallAmount: null
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
  <el-form
    ref="ruleFormRef"
    :model="newFormInline"
    :rules="formRules"
    label-width="120px"
  >
    <el-form-item label="地区编号" prop="areaId">
      <el-input v-model="newFormInline.areaId" clearable placeholder="请输入地区编号" />
    </el-form-item>

    <el-form-item label="监测日期" prop="monitoringDate">
      <el-date-picker v-model="newFormInline.monitoringDate" type="date" placeholder="选择监测日期" />
    </el-form-item>

    <el-form-item label="土壤侵蚀率" prop="soilErosionRate">
      <el-input-number v-model="newFormInline.soilErosionRate" placeholder="请输入土壤侵蚀率" />
    </el-form-item>

    <el-form-item label="植被覆盖率" prop="vegetationCoverageRate">
      <el-input-number v-model="newFormInline.vegetationCoverageRate" placeholder="请输入植被覆盖率" />
    </el-form-item>

    <el-form-item label="降雨量" prop="rainfallAmount">
      <el-input-number v-model="newFormInline.rainfallAmount" placeholder="请输入降雨量" />
    </el-form-item>
  </el-form>
</template>
