import { $t } from "@/plugins/i18n";
import { dataanalysis } from "@/router/enums";

export default {
  path: "/data-analysis",
  redirect: "/data-analysis/erosion/table",
  meta: {
    title: $t("menus.hsDataAnalysis"),
    rank: dataanalysis,
    icon: "chart"
  },
  children: [
    {
      path: "/data-analysis/erosion",
      name: "Erosion",
      meta: {
        icon: "analysis-erosion",
        title: $t("menus.hsErosionAnalysis"),
        keepAlive: true
      },
      redirect: "/data-analysis/erosion/table",
      children: [
        {
          path: "/data-analysis/erosion/table",
          name: "TableErosion",
          component: () => import("@/views/data-analysis/index.vue"),
          meta: {
            icon: "erosion-base-table",
            title: $t("menus.hsErosionAnalysisFromFile"),
            keepAlive: true
          }
        },
        {
          path: "/data-analysis/erosion/input",
          name: "InputErosion",
          component: () => import("@/views/monitor/area-info/index.vue"),
          meta: {
            icon: "erosion-base-input",
            title: $t("menus.hsSoilErosionAnalysisFromInput"),
            keepAlive: true
          }
        }
      ]
    },
    {
      path: "/data-analysis/common",
      name: "Analysis",
      component: () => import("@/views/monitor/area-info/index.vue"),
      meta: {
        icon: "analysis-common",
        title: $t("menus.hsBasicDataAnalysis"),
        keepAlive: true
      }
    }
  ]
} satisfies RouteConfigsTable;
