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
    <el-form-item label="区域编号" prop="areaId">
      <el-input v-model="newFormInline.areaId" clearable placeholder="请输入区域编号" />
    </el-form-item>

    <el-form-item label="侵蚀类型" prop="erosionType">
      <el-input v-model="newFormInline.erosionType" clearable placeholder="请输入侵蚀类型" />
    </el-form-item>

    <el-form-item label="侵蚀等级" prop="erosionGrade">
      <el-input v-model="newFormInline.erosionGrade" clearable placeholder="请输入侵蚀等级" />
    </el-form-item>

    <el-form-item label="侵蚀年限" prop="erosionYears">
      <el-input-number v-model="newFormInline.erosionYears" controls-position="right" placeholder="请输入侵蚀年限" />
    </el-form-item>

    <el-form-item label="风险等级" prop="riskLevel">
      <el-input v-model="newFormInline.riskLevel" clearable placeholder="请输入风险等级" />
    </el-form-item>

    <el-form-item label="侵蚀描述" prop="erosionDescription">
      <el-input v-model="newFormInline.erosionDescription" type="textarea" clearable placeholder="请输入侵蚀描述" />
    </el-form-item>

    <el-form-item label="风险评估结果" prop="riskAssessmentResult">
      <el-input v-model="newFormInline.riskAssessmentResult" type="textarea" clearable placeholder="请输入风险评估结果" />
    </el-form-item>
  </el-form>
</template>
