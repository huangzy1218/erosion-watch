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
    },
    {
      path: "/data-analysis/operation",
      name: "Operation",
      component: () => import("@/views/data-analysis/operation.vue"),
      meta: {
        icon: "folderOpen",
        title: $t("menus.hsOperation"),
        keepAlive: true,
        showLink: false
      }
    }
  ]
} satisfies RouteConfigsTable;
