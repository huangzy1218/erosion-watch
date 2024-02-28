import { $t } from "@/plugins/i18n";
import { mydata } from "@/router/enums";
const MyData = () => import("@/views/my-data/index.vue");

export default {
  path: "/my-data",
  name: "MyData",
  component: MyData,
  meta: {
    icon: "folderOpen",
    title: $t("menus.hsMyData"),
    rank: mydata
  }
} as RouteConfigsTable;
