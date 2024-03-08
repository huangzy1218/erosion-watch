<script setup lang="ts">
import {ref} from "vue";
import {useColumns as useExcelColumns} from "@/views/pure-table/high/excel/columns";
import {useColumns as usePrintColums} from "@/views/pure-table/high/prints/columns";

const printRef = ref();
const { columns, dataList, print } = usePrintColums(printRef);

const { exportExcel } = useExcelColumns();

const empty: TableColumnList = [
  {
    label: "",
    prop: ""
  },
  {
    label: "",
    prop: ""
  },
  {
    label: "",
    prop: ""
  },
  {
    label: "",
    prop: ""
  },
  {
    label: "",
    prop: ""
  },
  {
    label: "",
    prop: ""
  },
  {
    label: "",
    prop: ""
  },
  {
    label: "",
    prop: ""
  },
  {
    label: "",
    prop: ""
  }
];

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

const rowStyle = ({ rowIndex }) => {
  return {};
};

// 单元格样式
const cellStyle = ({ rowIndex, columnIndex }) => {
  return {
    padding: "0px"
    // border: "0.7px solid #e8e8e8" // Excel-like 细边框
  };
};

// 表头单元格样式
const headerCellStyle = () => {
  return {
    // backgroundColor: "#f0f0f0", // 轻灰色背景
    color: "#333", // 字体颜色
    fontWeight: "bold", // 加粗
    fontSize: "14px"
  };
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
    <pure-table
      ref="printRef"
      adaptive
      alignWhole="center"
      :data="dataList.concat(dataList).concat(dataList)"
      :columns="columns.concat(empty)"
      row-key="id"
      border
      height="500px"
      auto
      stripe
      size="small"
      :row-style="rowStyle"
      :cell-style="cellStyle"
      :header-cell-style="headerCellStyle"
      @cell-click="handleCellClick"
      @cell-mouse-enter="handleCellClick"
    >
      <template #default="{ row, column, rowIndex, columnIndex }">
        <div
          v-if="
            editingCell &&
            editingCell.rowIndex === rowIndex &&
            editingCell.columnIndex === columnIndex
          "
        >
          <input
            ref="input-${rowIndex}-${columnIndex}"
            v-model="row[column.prop]"
          />
        </div>
        <div v-else>
          {{ row[column.prop] }}
        </div>
      </template>
    </pure-table>
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
