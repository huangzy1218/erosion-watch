import { $t } from "@/plugins/i18n";
import { dataanalysis } from "@/router/enums";
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/data-analysis",
  name: "DataAnalysis",
  component: Layout,
  redirect: "/data-analysis/statistics",
  meta: {
    icon: "chart",
    title: $t("menus.hsDataAnalysis"),
    rank: dataanalysis
  }
} as RouteConfigsTable;
