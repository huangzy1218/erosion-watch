import { $t } from "@/plugins/i18n";
import { references } from "@/router/enums";
const References = () => import("@/views/references/index.vue");
import { formRules } from "@/views/my-data/utils/rule";
import { FormProps } from "@/views/my-data/utils/types";

import axios from "axios";
import Sortable from "sortablejs";
import { ref, computed } from "vue";
import { useRouter } from "vue-router";
import { message } from "@/utils/message";
import type { UploadFile } from "element-plus";
import { getKeyList, extractFields, downloadByData } from "@pureadmin/utils";

import Add from "@iconify-icons/ep/plus";
import Eye from "@iconify-icons/ri/eye-line";
import Delete from "@iconify-icons/ri/delete-bin-7-line";

export default {
  path: "/references",
  name: "References",
  component: References,
  meta: {
    icon: "book",
    title: $t("menus.hsReferences"),
    rank: references
  }
} as RouteConfigsTable;
