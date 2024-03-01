// src/router/menus/dataprocess.ts
import { $t } from "@/plugins/i18n";
import { dataprocess } from "@/router/enums";

export default {
  path: "/data-process",
  name: "DataProcess",
  redirect: "/data-process/index",
  meta: {
    icon: "share",
    title: $t("menus.hsDataProcess"),
    rank: dataprocess
  },
  children: [
    {
      path: "/data-process/index",
      name: "DataProcess",
      component: () => import("@/views/data-process/index.vue"),
      meta: {
        icon: "share",
        title: $t("menus.hsDataProcess"),
        keepAlive: true
      }
    }
  ]
} satisfies RouteConfigsTable;
