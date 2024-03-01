import { $t } from "@/plugins/i18n";
import { references } from "@/router/enums";

export default {
  path: "/references",
  redirect: "/references/index",
  meta: {
    title: $t("menus.hsReferences"),
    icon: "book",
    rank: references
  },
  children: [
    {
      path: "/references/index",
      name: "References",
      component: () => import("@/views/references/index.vue"),
      meta: {
        icon: "book",
        title: $t("menus.hsReferences"),
        keepAlive: true
      }
    }
  ]
} satisfies RouteConfigsTable;
