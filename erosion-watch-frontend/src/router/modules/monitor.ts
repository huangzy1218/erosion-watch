import { $t } from "@/plugins/i18n";
import { monitor } from "@/router/enums";

export default {
  path: "/monitor",
  redirect: "/monitor/area-info",
  meta: {
    icon: "monitor",
    title: $t("menus.hsMonitor"),
    rank: monitor
  },
  children: [
    {
      path: "/monitor/area-info",
      name: "AreaInfo",
      component: () => import("@/views/monitor/area-info/index.vue"),
      meta: {
        title: $t("menus.hsAreaInfo")
      }
    },
    {
      path: "/monitor/soil-type",
      name: "SoilType",
      component: () => import("@/views/about/index.vue"),
      meta: {
        title: $t("menus.hsSoilType")
      }
    },
    {
      path: "/monitor/vegetation-coverage",
      name: "VegetationCoverage",
      component: () => import("@/views/about/index.vue"),
      meta: {
        title: $t("menus.hsVegetationCoverage")
      }
    },
    {
      path: "/monitor/terrain-landform",
      name: "TerrainLandform",
      component: () => import("@/views/about/index.vue"),
      meta: {
        title: $t("menus.hsTerrainLandform")
      }
    },
    {
      path: "/monitor/soil-erosion-grade",
      name: "SoilErosionGrade",
      component: () => import("@/views/about/index.vue"),
      meta: {
        title: $t("menus.hsSoilErosionGrade")
      }
    },
    {
      path: "/monitor/monitor-data",
      name: "MonitorData",
      component: () => import("@/views/about/index.vue"),
      meta: {
        title: $t("menus.hsMonitorData")
      }
    },
    {
      path: "/monitor/land-use-change-history",
      name: "LandUseChangeHistory",
      component: () => import("@/views/about/index.vue"),
      meta: {
        title: $t("menus.hsLandUseChangeHistory")
      }
    },
    {
      path: "/monitor/land-management-plans",
      name: "LandManagementPlans",
      component: () => import("@/views/about/index.vue"),
      meta: {
        title: $t("menus.hsLandManagementPlans")
      }
    }
  ]
} satisfies RouteConfigsTable;
