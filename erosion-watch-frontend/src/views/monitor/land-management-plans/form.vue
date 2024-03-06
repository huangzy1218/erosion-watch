<script setup lang="ts">
import {ref} from "vue";
import {formRules} from "./utils/rule";
import {FormProps} from "./utils/types";

// Assuming FormProps has been updated to include the new fields
const props = withDefaults(defineProps<FormProps>(), {
  formInline: () => ({
    id: null,
    areaId: null,
    planDate: null,
    planType: "",
    responsibleUnit: "",
    implementationDate: null,
    planContent: ""
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

    <el-form-item label="计划日期" prop="planDate">
      <el-date-picker v-model="newFormInline.planDate" type="date" placeholder="选择日期" />
    </el-form-item>

    <el-form-item label="计划类型" prop="planType">
      <el-input v-model="newFormInline.planType" clearable placeholder="请输入计划类型" />
    </el-form-item>

    <el-form-item label="责任单位" prop="responsibleUnit">
      <el-input v-model="newFormInline.responsibleUnit" clearable placeholder="请输入责任单位" />
    </el-form-item>

    <el-form-item label="实施日期" prop="implementationDate">
      <el-date-picker v-model="newFormInline.implementationDate" type="date" placeholder="选择日期" />
    </el-form-item>

    <el-form-item label="计划内容" prop="planContent">
      <el-input v-model="newFormInline.planContent" type="textarea" clearable placeholder="请输入计划内容" />
    </el-form-item>
  </el-form>
</template>
