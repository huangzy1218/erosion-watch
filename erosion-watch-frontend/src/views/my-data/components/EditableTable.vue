<template>
  <div class="editable-table">
    <HotTable :settings="tableSettings" />
  </div>
</template>

<script setup>
import { ref } from "vue";
import { HotTable } from "@handsontable/vue3";
import "handsontable/dist/handsontable.full.css";

const tableSettings = ref({
  data: [
    ["", "Tesla", "Nissan", "Toyota", "Ford"],
    ["2020", 10, 11, 12, 13],
    ["2021", 20, 11, 14, 13],
    ["2022", 30, 15, 12, 13]
  ],
  colHeaders: ["Year", "Tesla", "Nissan", "Toyota", "Ford"],
  rowHeaders: true,
  width: "auto",
  height: "auto",
  stretchH: "all",
  manualRowMove: true,
  manualColumnMove: true,
  contextMenu: true,
  filters: true,
  dropdownMenu: true,
  licenseKey: "non-commercial-and-evaluation",
  afterChange: afterChangeHandler
});

function afterChangeHandler(changes, source) {
  if (source !== "loadData") {
    // 过滤掉加载数据时的变更
    if (changes) {
      changes.forEach(([row, prop, oldValue, newValue]) => {
        console.log(
          `Data changed at row ${row}, column ${prop} from ${oldValue} to ${newValue}`
        );
        // 这里可以添加更多的逻辑，例如发送数据到服务器
      });
    }
  }
}
</script>

<style>
.editable-table {
  width: 100%;
  height: auto;
  overflow: hidden;
  --handsontable-color-primary: #078340; /* 主题颜色 */
}
.ht_master .htBorders .current,
.ht_master .htBorders .area {
  border-color: #078340 !important;
}

.ht_master .htCore .ht__highlight,
.ht_master .htCore .current {
  border-color: #078340 !important; /* 使用!important确保覆盖默认样式 */
}

/* 如果你希望改变鼠标悬停时的边框颜色，也可以添加如下规则 */
.ht_master .htCore tbody tr:hover td {
  border-color: #078340 !important;
}

.ht_master .wtHolder {
  border-color: var(--handsontable-color-primary);
}

.ht_master .htCore .htDimmed {
  background-color: var(--handsontable-color-primary);
  color: #fff;
}
</style>
