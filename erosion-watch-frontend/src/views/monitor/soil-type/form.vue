<script setup lang="ts">
import {ref} from "vue";
import {formRules} from "./utils/rule";
import {FormProps} from "./utils/types";

// Assuming FormProps has been updated to include the new fields
const props = withDefaults(defineProps<FormProps>(), {
  formInline: () => ({
    id: null,
    areaId: null,
    erosionType: "",
    erosionGrade: "",
    erosionYears: null,
    riskLevel: "",
    erosionDescription: "",
    riskAssessmentResult: "",
    managementPractice: ""
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
    <el-form-item label="父级编号" prop="parentId">
      <el-input v-model="newFormInline.parentId" clearable placeholder="请输入父级编号" />
    </el-form-item>

    <el-form-item label="土壤类型名称" prop="name">
      <el-input v-model="newFormInline.name" clearable placeholder="请输入土壤类型名称" />
    </el-form-item>

    <el-form-item label="分类级别" prop="level">
      <el-input-number v-model="newFormInline.level" clearable placeholder="请输入分类级别" />
    </el-form-item>

    <el-form-item label="土壤质地" prop="soilQuality">
      <el-input v-model="newFormInline.soilQuality" clearable placeholder="请输入土壤质地" />
    </el-form-item>

    <el-form-item label="土壤含水量" prop="soilMoisture">
      <el-input v-model="newFormInline.soilMoisture" clearable placeholder="请输入土壤含水量" />
    </el-form-item>

    <el-form-item label="描述" prop="description">
      <el-input v-model="newFormInline.description" type="textarea" clearable placeholder="请输入描述" />
    </el-form-item>
  </el-form>
</template>
