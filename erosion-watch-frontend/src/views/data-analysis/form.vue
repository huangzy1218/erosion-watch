<script setup lang="ts">
import { ref } from "vue";
import { useColumns } from "./utils/columns";

const selectRef = ref();
const {
  columns,
  pagination,
  selectValue,
  tableDataEdit,
  rowStyle,
  onRowClick
} = useColumns(selectRef);

const tableRef = ref();
const currentRow = ref();

const setCurrent = (row?: any) => {
  // 获取表格的方法 tableRef.value.getTableRef()
  const { setCurrentRow } = tableRef.value.getTableRef();
  setCurrentRow(row);
};
const handleCurrentChange = val => {
  currentRow.value = val;
};
</script>

<template>
  <el-form ref="ruleFormRef" label-width="82px">
    <pure-table
      row-key="id"
      alignWhole="left"
      auto
      highlight-current-row
      :header-cell-style="{
        background: '#f5f7fa',
        color: '#303133'
      }"
      :row-style="rowStyle"
      :data="
        tableDataEdit.slice(
          (pagination.currentPage - 1) * pagination.pageSize,
          pagination.currentPage * pagination.pageSize
        )
      "
      :columns="columns"
      :pagination="pagination"
      @page-current-change="handleCurrentChange"
      @row-click="onRowClick"
    />
  </el-form>
</template>
