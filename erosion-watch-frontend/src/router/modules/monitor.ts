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
        icon: "area-info",
        title: $t("menus.hsAreaInfo")
      }
    },
    {
      path: "/monitor/soil-type",
      name: "SoilType",
      component: () => import("@/views/monitor/soil-type/index.vue"),
      meta: {
        icon: "soil-type",
        title: $t("menus.hsSoilType")
      }
    },
    {
      path: "/monitor/vegetation-coverage",
      name: "VegetationCoverage",
      component: () => import("@/views/monitor/vegetation-coverage/index.vue"),
      meta: {
        icon: "vegetation-coverage",
        title: $t("menus.hsVegetationCoverage")
      }
    },
    {
      path: "/monitor/terrain-landform",
      name: "TerrainLandform",
      component: () => import("@/views/monitor/terrain-landform/index.vue"),
      meta: {
        icon: "terrain-landform",
        title: $t("menus.hsTerrainLandform")
      }
    },
    {
      path: "/monitor/soil-erosion-grade",
      name: "SoilErosionGrade",
      component: () => import("@/views/monitor/soil-erosion-grade/index.vue"),
      meta: {
        icon: "soil-erosion-grade",
        title: $t("menus.hsSoilErosionGrade")
      }
    },
    {
      path: "/monitor/monitor-data",
      name: "MonitorData",
      component: () => import("@/views/monitor/monitor-data/index.vue"),
      meta: {
        icon: "monitor-data",
        title: $t("menus.hsMonitorData")
      }
    },
    {
      path: "/monitor/land-use-change-history",
      name: "LandUseChangeHistory",
      component: () => import("@/views/monitor/land-use-change-history/index.vue"),
      meta: {
        icon: "land-use-change-history",
        title: $t("menus.hsLandUseChangeHistory")
      }
    },
    {
      path: "/monitor/land-management-plans",
      name: "LandManagementPlans",
      component: () => import("@/views/monitor/land-management-plans/index.vue"),
      meta: {
        icon: "land-management-plans",
        title: $t("menus.hsLandManagementPlans")
      }
    }
  ]
} satisfies RouteConfigsTable;
