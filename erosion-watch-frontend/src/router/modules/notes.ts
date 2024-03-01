import { $t } from "@/plugins/i18n";
import { notes } from "@/router/enums";
const Notes = () => import("@/views/notes/index.vue");

export default {
  path: "/notes",
  name: "Notes",
  component: Notes,
  meta: {
    icon: "notebook",
    title: $t("menus.hsNotes"),
    rank: notes
  }
} as RouteConfigsTable;
