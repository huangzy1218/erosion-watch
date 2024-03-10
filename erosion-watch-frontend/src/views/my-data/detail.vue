<script setup lang="ts">
import { ref } from "vue";
import EditableTable from "./components/EditableTable.vue";

import { useColumns as useExcelColumns } from "@/views/pure-table/high/excel/columns";
import { useColumns as usePrintColums } from "@/views/pure-table/high/prints/columns";
import "handsontable/dist/handsontable.full.css";

const printRef = ref();
const { columns, dataList, print } = usePrintColums(printRef);

const { exportExcel } = useExcelColumns();

const selectedCell = ref(null);
const handleCellClick = (row, column, cell, event) => {
  // 清除之前选中单元格的样式
  if (selectedCell.value && selectedCell.value !== cell) {
    selectedCell.value.style.border = ""; // 清除之前选中的单元格边框样式
  }

  // 更新选中单元格的样式
  cell.style.border = "1.5px solid green";
  selectedCell.value = cell; // 更新选中单元格的引用
};

const editingCell = ref(null);
</script>

<template>
  <el-form
    :inline="true"
    class="search-form bg-bg_color w-[99/100] pl-8 pt-[12px]"
  >
    <el-form-item>
      <el-button type="primary" class="export-button" @click="exportExcel">
        开始分析
      </el-button>
    </el-form-item>
    <el-form-item>
      <el-button
        type="primary"
        class="export-button"
        plain
        @click="exportExcel"
      >
        导出
      </el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" plain @click="print"> 打印 </el-button>
    </el-form-item>
  </el-form>
  <el-card>
    <EditableTable />
  </el-card>
</template>

<style scoped>
.button-container {
  display: flex;
  justify-content: flex-start;
  margin-bottom: 20px;
}

.search-form {
  display: flex;
  justify-content: flex-end;
}
</style>
