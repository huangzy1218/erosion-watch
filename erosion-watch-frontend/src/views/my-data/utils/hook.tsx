import dayjs from "dayjs";
import uploadForm from "../upload.vue";
import {message} from "@/utils/message";
import {deleteMyData, getFileList} from "@/api/mydata";
import {usePublicHooks} from "../hooks";
import {addDialog} from "@/components/ReDialog/index";
import type {FormItemProps} from "./types";
import type {PaginationProps} from "@pureadmin/table";
import {computed, h, onMounted, reactive, ref, toRaw} from "vue";
import {useRouter} from "vue-router";
import renameForm from "@/views/my-data/renameForm.vue";

export function useMyData() {
  const form = reactive({
    fid: "",
    fileName: "",
    author: "",
    createTime: ""
  });
  const router = useRouter();
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
      label: "文件名称",
      prop: "fileName",
      minWidth: 160,
      fixed: "left",
      cellRenderer: ({ row }) => (
        <div style="display: flex; align-items: center">
          <iconify-icon-online icon="ep:document" />
          <span style="margin-left: 10px">{row.fileName}</span>
        </div>
      )
    },
    {
      label: "创建人",
      minWidth: 160,
      prop: "author"
    },
    {
      label: "创建时间",
      minWidth: 160,
      prop: "createTime",
      formatter: ({ createTime }) =>
        dayjs(createTime).format("YYYY-MM-DD HH:mm:ss")
    },
    {
      label: "操作",
      fixed: "right",
      width: 440,
      slot: "operation"
    }
  ];
  const buttonClass = computed(() => {
    return [
      "!h-[20px]",
      "reset-margin",
      "!text-gray-500",
      "dark:!text-white",
      "dark:hover:!text-primary"
    ];
  });

  // function onChange({ row, index }) {
  //   ElMessageBox.confirm(
  //     `确认要<strong>${
  //       row.status === 0 ? "停用" : "启用"
  //     }</strong><strong style='color:var(--el-color-primary)'>${
  //       row.name
  //     }</strong>吗?`,
  //     "系统提示",
  //     {
  //       confirmButtonText: "确定",
  //       cancelButtonText: "取消",
  //       type: "warning",
  //       dangerouslyUseHTMLString: true,
  //       draggable: true
  //     }
  //   )
  //     .then(() => {
  //       switchLoadMap.value[index] = Object.assign(
  //         {},
  //         switchLoadMap.value[index],
  //         {
  //           loading: true
  //         }
  //       );
  //       setTimeout(() => {
  //         switchLoadMap.value[index] = Object.assign(
  //           {},
  //           switchLoadMap.value[index],
  //           {
  //             loading: false
  //           }
  //         );
  //         message(`已${row.status === 0 ? "停用" : "启用"}${row.name}`, {
  //           type: "success"
  //         });
  //       }, 300);
  //     })
  //     .catch(() => {
  //       row.status === 0 ? (row.status = 1) : (row.status = 0);
  //     });
  // }

  const handleDelete = async row => {
    console.log("hhh");
    deleteMyData(row.fid)
      .then(response => {
        if (response.code === 200) {
          console.log("删除成功:", response);
          message("删除成功", { type: "success" });
        } else {
          console.log("删除失败:", response);
          message("删除失败", { type: "error" });
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
    const { data } = await getFileList(toRaw(form));
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

  const handleSee = row => {
    console.log(row);
    const { id } = row;

    // 使用 router.push 方法跳转，携带 fid 作为参数
    router.push({ path: "/my-data/detail", query: { id: id } });
  };

  function openDialog(title = "新增", row?: FormItemProps) {
    addDialog({
      title: `上传文件`,
      props: {
        formInline: {
          fileName: row?.fileName ?? ""
        }
      },
      width: "40%",
      draggable: true,
      fullscreenIcon: true,
      closeOnClickModal: false,
      contentRenderer: () => h(uploadForm, { ref: formRef }),
      beforeSure: (done, { options }) => {
        const FormRef = formRef.value.getRef();
        const curData = options.props.formInline as FormItemProps;
        function chores() {
          message(`您${title}了文件名为${curData.fileName}的这条数据`, {
            type: "success"
          });
          done(); // 关闭弹框
          onSearch(); // 刷新表格数据
        }
        FormRef.validate(valid => {
          if (valid) {
            console.log("curData", curData);
            // 表单规则校验通过
            if (title === "新增") {
              // 实际开发先调用新增接口，再进行下面操作
              chores();
            } else {
              chores();
            }
          }
        });
      }
    });
  }

  function openRenameDialog(row) {
    addDialog({
      title: "重命名",
      props: {
        // 传递当前文件的名称到对话框中，用于初始化表单字段
        formInline: {
          fileName: row?.fileName ?? ""
        }
      },
      width: "40%",
      draggable: true,
      fullscreenIcon: true,
      closeOnClickModal: false,
      // 使用渲染函数h来渲染重命名表单组件，这里假设该组件命名为renameForm
      // renameForm组件应该接受一个名为fileName的prop来初始化文件名输入框的值
      contentRenderer: () => h(renameForm, { ref: formRef }),
      beforeSure: (done, { options }) => {
        const FormRef = formRef.value.getRef();
        const curData = options.props.formInline;
        FormRef.validate(valid => {
          if (valid) {
            // 表单规则校验通过
            // 在这里调用实际的重命名接口，使用curData.fileName作为新的文件名
            console.log("新文件名", curData.fileName);
            // 假设renameFile是执行重命名操作的函数
            renameFile(row.id, curData.fileName)
              .then(() => {
                message("文件重命名成功", { type: "success" });
                done(); // 关闭弹框
                onSearch(); // 刷新列表以显示新的文件名
              })
              .catch(error => {
                // 处理错误情况
                console.error("重命名失败", error);
                message("文件重命名失败", { type: "error" });
              });
          }
        });
      }
    });
  }

  /**
   * 执行文件重命名操作。
   *
   * @param {Number} fileId 要重命名的文件的ID。
   * @param {String} newName 新的文件名。
   * @returns {Promise} 一个Promise对象，表示异步操作的结果。
   */
  function renameFile(fileId, newName) {
    // 假设后端提供了一个用于重命名文件的API接口，这里使用POST方法作为示例
    const apiURL = `/api/files/rename`; // 请根据实际API路径调整

    // 请求体，根据后端要求调整
    const requestBody = {
      id: fileId, // 文件ID
      newName: newName // 新的文件名
    };

    // 发起fetch请求
    return fetch(apiURL, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(requestBody)
    })
      .then(response => {
        // 检查响应状态
        if (!response.ok) {
          throw new Error("网络响应错误");
        }
        return response.json();
      })
      .then(data => {
        // 处理后端返回的数据
        if (data.success) {
          return data; // 如果成功，返回数据
        } else {
          throw new Error(data.message || "重命名失败");
        }
      })
      .catch(error => {
        // 处理错误情况
        console.error("重命名文件失败:", error);
        throw error; // 将错误向上抛出，以便调用者处理
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
    buttonClass,
    onSearch,
    resetForm,
    openDialog,
    handleMenu,
    handleDelete,
    // handleDatabase,
    handleSizeChange,
    handleCurrentChange,
    handleSelectionChange,
    handleSee,
    openRenameDialog
  };
}
