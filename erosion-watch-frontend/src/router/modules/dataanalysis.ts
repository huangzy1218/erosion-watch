import { $t } from "@/plugins/i18n";
import { dataanalysis } from "@/router/enums";
const DataAnalysis = () => import("@/views/data-analysis/index.vue");

export default {
  path: "/data-analysis",
  name: "DataAnalysis",
  component: DataAnalysis,
  meta: {
    icon: "chart",
    title: $t("menus.hsDataAnalysis"),
    rank: dataanalysis
  }
} as RouteConfigsTable;
