import Print from "@/utils/print";
import { computed, ref, type Ref, Transition } from "vue";
import { tableDataEdit } from "../data";
import { clone, delay } from "@pureadmin/utils";
import Check from "@iconify-icons/ep/check";
import EditPen from "@iconify-icons/ep/edit-pen";
import { message } from "@/utils/message";

export function useColumns(printRef: Ref) {
  const dataList = ref(clone(tableDataEdit, true));
  const inputValMap = ref({});
  // 是否正处于修改状态（可多个）
  const editStatus = ref({});
  // 当前激活的单元格（唯一）
  const activeIndex = ref(-1);

  const comVal = computed(() => {
    return index => {
      return inputValMap.value[index]?.value;
    };
  });

  const editing = computed(() => {
    return index => {
      return editStatus.value[index]?.editing;
    };
  });

  const iconClass = computed(() => {
    return (index, other = false) => {
      return [
        "cursor-pointer",
        "ml-2",
        "transition",
        "delay-100",
        other
          ? ["hover:scale-110", "hover:text-red-500"]
          : editing.value(index) && ["scale-150", "text-red-500"]
      ];
    };
  });
  const columns: TableColumnList = [
    {
      label: "日期",
      prop: "date"
    },
    {
      label: "姓名",
      prop: "name"
    },
    {
      label: "地址",
      prop: "address"
    }
  ];

  const print = () => {
    Print(printRef.value.getTableDoms().tableWrapper).toPrint;
  };

  function cellStyle({ column: { property }, rowIndex }) {
    if (property === "id") {
      return rowIndex < 3
        ? { background: "#87baf9" }
        : { background: "#87e8de" };
    }
  }

  function headerCellStyle({ columnIndex }) {
    return columnIndex === 0
      ? { background: "#f3b2d0" }
      : { background: "#fafafa" };
  }

  function rowStyle({ rowIndex }) {
    return rowIndex % 2 === 1
      ? { background: "#ffa39e" }
      : { background: "#91d5ff" };
  }

  return {
    columns,
    dataList,
    print,
    rowStyle,
    cellStyle,
    headerCellStyle
  };
}
