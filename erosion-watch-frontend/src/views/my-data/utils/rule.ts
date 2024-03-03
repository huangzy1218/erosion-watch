import { reactive } from "vue";
import type { FormRules } from "element-plus";

/** 自定义表单规则校验 */
export const formRules = reactive(<FormRules>{
  fileName: [{ required: true, message: "文件名为必填项", trigger: "blur" }]
});
