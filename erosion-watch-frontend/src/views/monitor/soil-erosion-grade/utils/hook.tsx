import editForm from "../form.vue";
import {message} from "@/utils/message";
import {ElMessageBox} from "element-plus";
import {usePublicHooks} from "../../hooks";
import {addDialog} from "@/components/ReDialog";
import type {FormItemProps} from "../utils/types";
import type {PaginationProps} from "@pureadmin/table";
import {h, onMounted, reactive, ref, toRaw} from "vue";
import {
  addSoilErosionGrade,
  deleteSoilErosionGrade,
  getSoilErosionGrade,
  searchSoilErosionGrade,
  updateSoilErosionGrade
} from "@/api/monitor";

export function useSoilErosionGrade() {
  const form = reactive({
    id: "",
    areaId: "",
    erosionType: "",
    erosionGrade: "",
    erosionYears: "",
    riskLevel: "",
    erosionDescription: "",
    riskAssessmentResult: "",
    managementPractice: ""
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
      prop: "areaId",
      minWidth: 120
    },
    {
      label: "侵蚀类型",
      prop: "erosionType",
      minWidth: 150
    },
    {
      label: "侵蚀等级",
      prop: "erosionGrade",
      minWidth: 150
    },
    {
      label: "抗蚀年限(年)",
      prop: "erosionYears",
      minWidth: 200
    },
    {
      label: "风险等级",
      prop: "riskLevel",
      minWidth: 150
    },
    {
      label: "侵蚀描述",
      prop: "erosionDescription",
      minWidth: 250
    },
    {
      label: "风险评估结果",
      prop: "riskAssessmentResult",
      minWidth: 250
    },
    {
      label: "管理措施",
      prop: "managementPractice",
      minWidth: 250
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
    deleteSoilErosionGrade(row.id)
      .then(response => {
        if (response.code === 200) {
          console.log("删除成功:", response);
          message("删除成功", { type: "success" });
        } else {
          console.log("删除失败:", response);
          message("删除失败", {type: "error"});
        }
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
    const { data } = await getSoilErosionGrade(toRaw(form));
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
    const { data } = await searchSoilErosionGrade(toRaw(form));
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
      title: `${title}土壤侵蚀程度信息`,
      props: {
        formInline: {
          id: row?.id ?? "",
          areaId: row?.areaId ?? "",
          erosionType: row?.erosionType ?? "",
          erosionGrade: row?.erosionGrade ?? "",
          erosionYears: row?.erosionYears ?? "",
          riskLevel: row?.riskLevel ?? "",
          erosionDescription: row?.erosionDescription ?? "",
          riskAssessmentResult: row?.riskAssessmentResult ?? "",
          managementPractice: row?.managementPractice ?? ""
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
              addSoilErosionGrade(curData)
                .then(response => {
                  if (response.code === 200) {
                    console.log('新增土壤侵蚀程度信息成功', response);
                    message(`新增土壤侵蚀程度信息成功`, { type: "success"});
                  } else {
                    console.warn('新增土壤侵蚀程度信息失败');
                    message(`新增土壤侵蚀程度信息失败`, { type: "error"});
                  }
              })
                .catch(error => {
                console.error('新增土壤侵蚀程度信息失败', error);
                message(`新增土壤侵蚀程度信息失败`, { type: "error"});
              });
              chores();
            } else {
              updateSoilErosionGrade(curData.id, curData)
                .then(response => {
                  if (response.code === 200) {
                    console.log('修改土壤侵蚀程度信息成功', response);
                    message(`修改土壤侵蚀程度信息成功`, { type: "success"});
                  } else {
                    console.warn('修改土壤侵蚀程度信息失败');
                    message(`修改土壤侵蚀程度信息失败`, { type: "error"});
                  }
                })
                .catch(error => {
                  console.error('修改土壤侵蚀程度信息失败', error);
                  message(`修改土壤侵蚀程度信息失败`, { type: "error"});
                });
              chores();
              onSearch();
            }
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
