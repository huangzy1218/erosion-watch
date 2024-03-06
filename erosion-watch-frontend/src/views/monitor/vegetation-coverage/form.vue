<script setup lang="ts">
import {ref} from "vue";
import {formRules} from "./utils/rule";
import {FormProps} from "./utils/types";

// Assuming FormProps has been updated to include the new fields
const props = withDefaults(defineProps<FormProps>(), {
  formInline: () => ({
    id: null,
    areaId: null,
    vegetationType: "",
    coveragePercentage: null,
    density: "",
    status: null,
    remarks: ""
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

    <el-form-item label="植被类型" prop="vegetationType">
      <el-input v-model="newFormInline.vegetationType" clearable placeholder="请输入植被类型" />
    </el-form-item>

    <el-form-item label="覆盖百分比" prop="coveragePercentage">
      <el-input-number v-model="newFormInline.coveragePercentage" placeholder="请输入覆盖百分比" />
    </el-form-item>

    <el-form-item label="密度" prop="density">
      <el-input v-model="newFormInline.density" clearable placeholder="请输入密度" />
    </el-form-item>

    <el-form-item label="状态" prop="status">
      <el-input v-model="newFormInline.status" clearable placeholder="请输入状态" />
    </el-form-item>

    <el-form-item label="备注" prop="remarks">
      <el-input v-model="newFormInline.remarks" clearable placeholder="请输入备注" />
    </el-form-item>
  </el-form>
</template>
