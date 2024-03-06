import editForm from "../form.vue";
import { message } from "@/utils/message";
import { ElMessageBox } from "element-plus";
import { usePublicHooks } from "../../hooks";
import { addDialog } from "@/components/ReDialog";
import type { FormItemProps } from "../utils/types";
import type { PaginationProps } from "@pureadmin/table";
import { reactive, ref, onMounted, h, toRaw } from "vue";
import {addAreaInfo, deleteAreaInfo, getAreaInfoList, searchAreaInfoList, updateAreaInfo} from "@/api/monitor";

export function useAreaInfo() {
  const form = reactive({
    id: "",
    areaName: "",
    administrativeCode: "",
    latitude: "",
    longitude: "",
    area: "",
    population: "",
    climateType: "",
    terrainFeature: "",
    landformFeature: "",
    landUse: ""
  });
  const formRef = ref();
  const dataList = ref([]);
  const loading = ref(true);
  const switchLoadMap = ref({});
  const { switchStyle } = usePublicHooks();
  const pagination = reactive<PaginationProps>({
    total: 0,
    pageSize: 10,
    currentPage: 1,
    background: true
  });
  const columns: TableColumnList = [
    {
      label: "地区编号",
      prop: "id",
      minWidth: 80
    },
    {
      label: "地区名称",
      prop: "areaName",
      minWidth: 120
    },
    {
      label: "行政区划代码",
      prop: "administrativeCode",
      minWidth: 100
    },
    {
      label: "纬度",
      prop: "latitude",
      minWidth: 100
    },
    {
      label: "经度",
      prop: "longitude",
      minWidth: 100
    },
    {
      label: "面积",
      prop: "area",
      minWidth: 100
    },
    {
      label: "人口",
      prop: "population",
      minWidth: 100
    },
    {
      label: "气候类型",
      prop: "climateType",
      minWidth: 180
    },
    {
      label: "地形特征",
      prop: "terrainFeature",
      minWidth: 150
    },
    {
      label: "地貌特征",
      prop: "landformFeature",
      minWidth: 180
    },
    {
      label: "土地利用情况",
      prop: "landUse",
      minWidth: 180
    },
    {
      label: "操作",
      fixed: "right",
      width: 200,
      slot: "operation"
    }
  ];

  function onChange({ row, index }) {
    ElMessageBox.confirm(
      `确认要<strong>${
        row.status === 0 ? "停用" : "启用"
      }</strong><strong style='color:var(--el-color-primary)'>${
        row.name
      }</strong>吗?`,
      "系统提示",
      {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
        dangerouslyUseHTMLString: true,
        draggable: true
      }
    )
      .then(() => {
        switchLoadMap.value[index] = Object.assign(
          {},
          switchLoadMap.value[index],
          {
            loading: true
          }
        );
        setTimeout(() => {
          switchLoadMap.value[index] = Object.assign(
            {},
            switchLoadMap.value[index],
            {
              loading: false
            }
          );
          message(`已${row.status === 0 ? "停用" : "启用"}${row.name}`, {
            type: "success"
          });
        }, 300);
      })
      .catch(() => {
        row.status === 0 ? (row.status = 1) : (row.status = 0);
      });
  }

  const handleDelete = async row => {
    deleteAreaInfo(row.id)
      .then(response => {
        if (response.code === 200) {
          console.log("删除成功:", response);
          message("删除成功", { type: "success" });
        } else {
          console.log("删除失败:", response);
          message("删除失败", { type: "error" });
        }
        onSearch();
      })
      .catch(error => {
        console.error("删除失败:", error);
        message("删除失败", { type: "error" });
      });
  };

  function handleSizeChange(val: number) {
    console.log(`${val} items per page`);
  }

  function handleCurrentChange(val: number) {
    console.log(`current page: ${val}`);
  }

  function handleSelectionChange(val) {
    console.log("handleSelectionChange", val);
  }

  async function onSearch() {
    loading.value = true;
    const { data } = await getAreaInfoList(toRaw(form));
    dataList.value = data.list;
    pagination.total = data.total;
    pagination.pageSize = data.pageSize;
    pagination.currentPage = data.pageNum;

    setTimeout(() => {
      loading.value = false;
    }, 500);
  }

  async function onConditionalSearch() {
    loading.value = true;
    const { data } = await searchAreaInfoList(toRaw(form));
    dataList.value = data.list;
    pagination.total = data.total;
    pagination.pageSize = data.pageSize;
    pagination.currentPage = data.pageNum;

    setTimeout(() => {
      loading.value = false;
    }, 500);
  }

  const resetForm = formEl => {
    if (!formEl) return;
    formEl.resetFields();
    onSearch();
  };

  function openDialog(title = "新增", row?: FormItemProps) {
    addDialog({
      title: `${title}区域信息`,
      props: {
        formInline: {
          id: row?.id ?? "",
          areaName: row?.areaName ?? "",
          administrativeCode: row?.administrativeCode ?? "",
          latitude: row?.latitude ?? "",
          longitude: row?.longitude ?? "",
          area: row?.area ?? "",
          population: row?.population ?? "",
          climateType: row?.climateType ?? "",
          terrainFeature: row?.terrainFeature ?? "",
          landformFeature: row?.landformFeature ?? "",
          landUse: row?.landUse ?? ""
        }
      },
      width: "40%",
      draggable: true,
      fullscreenIcon: true,
      closeOnClickModal: false,
      contentRenderer: () => h(editForm, { ref: formRef }),
      beforeSure: (done, { options }) => {
        const FormRef = formRef.value.getRef();
        const curData = options.props.formInline as FormItemProps;
        function chores() {
          done(); // 关闭弹框
          onSearch(); // 刷新表格数据
        }
        FormRef.validate(valid => {
          if (valid) {
            console.log("curData", curData);
            // 表单规则校验通过
            if (title === "新增") {
              addAreaInfo(curData)
                .then(response => {
                  if (response.code === 200) {
                    console.log('新增区域信息成功', response);
                    message(`新增区域信息成功`, { type: "success"});
                  } else {
                    console.warn('新增区域信息失败');
                    message(`新增区域信息失败`, { type: "error"});
                  }
              })
                .catch(error => {
                console.error('新增区域信息失败', error);
                message(`新增区域信息失败`, { type: "error"});
              });
              chores();
            } else {
              updateAreaInfo(curData.id, curData)
                .then(response => {
                  if (response.code === 200) {
                    console.log('修改区域信息成功', response);
                    message(`修改区域信息成功`, { type: "success"});
                  } else {
                    console.warn('修改区域信息失败');
                    message(`修改区域信息失败`, { type: "error"});
                  }
                })
                .catch(error => {
                  console.error('修改区域信息失败', error);
                  message(`修改区域信息失败`, { type: "error"});
                });
              chores();
            }
            onSearch();
          }
        });
      }
    });
  }

  /** 菜单权限 */
  function handleMenu() {
    message("等菜单管理页面开发后完善");
  }

  /** 数据权限 可自行开发 */
  // function handleDatabase() {}

  onMounted(() => {
    onSearch();
  });

  return {
    form,
    loading,
    columns,
    dataList,
    pagination,
    // buttonClass,
    onSearch,
    resetForm,
    openDialog,
    handleMenu,
    handleDelete,
    // handleDatabase,
    handleSizeChange,
    handleCurrentChange,
    handleSelectionChange,
    onConditionalSearch
  };
}
