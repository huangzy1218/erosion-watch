import { $t } from "@/plugins/i18n";
import { references } from "@/router/enums";
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/references",
  name: "References",
  component: Layout,
  meta: {
    icon: "book",
    title: $t("menus.hsReferences"),
    rank: references
  }
} as RouteConfigsTable;
