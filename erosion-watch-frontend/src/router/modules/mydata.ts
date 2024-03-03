import { $t } from "@/plugins/i18n";
import { mydata } from "@/router/enums";

export default {
  path: "/my-data",
  name: "MyData",
  redirect: "/my-data/index",
  meta: {
    icon: "folderOpen",
    title: $t("menus.hsMyData"),
    rank: mydata
  },
  children: [
    {
      path: "/my-data/index",
      name: "MyData",
      component: () => import("@/views/my-data/index.vue"),
      meta: {
        icon: "folderOpen",
        title: $t("menus.hsMyData"),
        keepAlive: true
      }
    },
    {
      path: "/my-data/detail",
      name: "Detail",
      component: () => import("@/views/my-data/detail.vue"),
      meta: {
        icon: "folderOpen",
        title: $t("menus.hsDetail"),
        keepAlive: true,
        showLink: false
      }
    }
  ]
} satisfies RouteConfigsTable;
