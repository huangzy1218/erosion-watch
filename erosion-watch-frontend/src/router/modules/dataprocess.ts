// src/router/menus/dataprocess.ts
import { $t } from "@/plugins/i18n";
import { dataprocess } from "@/router/enums";
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/data-process",
  name: "DataProcess",
  component: Layout,
  meta: {
    icon: "share",
    title: $t("menus.hsDataProcess"),
    rank: dataprocess
  }
} as RouteConfigsTable;
