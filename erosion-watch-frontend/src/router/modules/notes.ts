import { $t } from "@/plugins/i18n";
import { notes } from "@/router/enums";
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/notes",
  name: "Notes",
  component: Layout,
  meta: {
    icon: "notebook",
    title: $t("menus.hsNotes"),
    rank: notes
  }
} as RouteConfigsTable;
