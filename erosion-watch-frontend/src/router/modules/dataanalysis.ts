import { $t } from "@/plugins/i18n";
import { dataanalysis } from "@/router/enums";

export default {
  path: "/data-analysis",
  redirect: "/data-analysis/index",
  meta: {
    title: $t("menus.hsDataAnalysis"),
    rank: dataanalysis,
    icon: "chart"
  },
  children: [
    {
      path: "/data-analysis/index",
      name: "DataAnalysis",
      component: () => import("@/views/data-analysis/index.vue"),
      meta: {
        icon: "chart",
        title: $t("menus.hsDataAnalysis"),
        keepAlive: true
      }
    }
  ]
} satisfies RouteConfigsTable;
