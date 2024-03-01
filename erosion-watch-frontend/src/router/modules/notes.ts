import { $t } from "@/plugins/i18n";
import { notes } from "@/router/enums";

export default {
  path: "/notes",
  redirect: "/notes/index",
  meta: {
    icon: "notebook",
    title: $t("menus.hsNotes"),
    rank: notes
  },
  children: [
    {
      path: "/notes/index",
      name: "Notes",
      component: () => import("@/views/notes/index.vue"),
      meta: {
        icon: "book",
        title: $t("menus.hsNotes"),
        keepAlive: true
      }
    }
  ]
} satisfies RouteConfigsTable;
