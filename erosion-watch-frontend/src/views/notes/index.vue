<script setup lang="ts">
import { ref } from "vue";
import { Base } from "./components";

defineOptions({
  name: "Editor"
});

</script>

<template>
  <el-card shadow="never">
        <Base/>
  </el-card>
</template>

<style lang="scss" scoped>
:deep(.el-collapse-item__header) {
  padding-left: 10px;
}
</style>
