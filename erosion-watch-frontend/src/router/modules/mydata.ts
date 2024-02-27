import { $t } from "@/plugins/i18n";
import { mydata } from "@/router/enums";
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/my-data",
  name: "MyData",
  component: Layout,
  redirect: "/my-data/overview",
  meta: {
    icon: "folderOpen",
    title: $t("menus.hsMyData"),
    rank: mydata
  }
} as RouteConfigsTable;
