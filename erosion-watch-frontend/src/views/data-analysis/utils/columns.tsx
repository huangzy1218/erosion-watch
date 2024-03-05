import { message } from "@/utils/message";
import { tableDataEdit } from "../data";
import { ref, reactive, type Ref } from "vue";
import type { PaginationProps } from "@pureadmin/table";

export function useColumns(selectRef: Ref) {
  const selectValue = ref("");
  const columns: TableColumnList = [
    {
      label: "文件名称",
      prop: "fileName",
      width: 280
    },
    {
      label: "更新时间",
      prop: "updateTime",
      minWidth: 220
    }
  ];

  /** 分页配置 */
  const pagination = reactive<PaginationProps>({
    pageSize: 5,
    currentPage: 1,
    layout: "prev, pager, next",
    total: tableDataEdit.length,
    background: true,
    small: true
  });

  /** 高亮当前选中行 */
  function rowStyle({ row: { name } }) {
    return {
      cursor: "pointer",
      background: name === selectValue.value ? "#f5f7fa" : ""
    };
  }

  /** 行点击 */
  function onRowClick(row) {
    selectValue.value = row.name;
    selectRef.value.blur();
    message(`当前选中行的数据为：${JSON.stringify(row)}`, { type: "success" });
  }

  return {
    columns,
    pagination,
    selectValue,
    tableDataEdit,
    rowStyle,
    onRowClick
  };
}