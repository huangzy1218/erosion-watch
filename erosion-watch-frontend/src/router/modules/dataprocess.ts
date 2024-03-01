// src/router/menus/dataprocess.ts
import { $t } from "@/plugins/i18n";
import { dataprocess } from "@/router/enums";
const DataProcess = () => import("@/views/data-process/index.vue");

export default {
  path: "/data-process",
  name: "DataProcess",
  component: DataProcess,
  meta: {
    icon: "share",
    title: $t("menus.hsDataProcess"),
    rank: dataprocess
  }
} as RouteConfigsTable;
