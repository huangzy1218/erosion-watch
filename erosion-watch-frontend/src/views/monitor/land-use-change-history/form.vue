<script setup lang="ts">
import {ref} from "vue";
import {formRules} from "./utils/rule";
import {FormProps} from "./utils/types";

// Assuming FormProps has been updated to include the new fields
const props = withDefaults(defineProps<FormProps>(), {
  formInline: () => ({
    id: null,
    areaId: null,
    changeDate: "",
    changeReason: "",
    currentLandUse: "",
    previousLandUse: ""
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
      <el-input v-model="newFormInline.areaId" clearable placeholder="请输入地区ID" />
    </el-form-item>

    <el-form-item label="变更日期" prop="changeDate">
      <el-date-picker v-model="newFormInline.changeDate" type="date" placeholder="选择日期" />
    </el-form-item>

    <el-form-item label="之前利用情况" prop="previousLandUse">
      <el-input v-model="newFormInline.previousLandUse" clearable placeholder="请输入之前的土地利用情况" />
    </el-form-item>

    <el-form-item label="当前利用情况" prop="currentLandUse">
      <el-input v-model="newFormInline.currentLandUse" clearable placeholder="请输入当前的土地利用情况" />
    </el-form-item>

    <el-form-item label="变更原因" prop="changeReason">
      <el-input v-model="newFormInline.changeReason" clearable placeholder="请输入变更原因" />
    </el-form-item>
  </el-form>
</template>
