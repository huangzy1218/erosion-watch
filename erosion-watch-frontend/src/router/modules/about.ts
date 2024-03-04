import { $t } from "@/plugins/i18n";
import { about } from "@/router/enums";

export default {
  path: "/about",
  redirect: "/about/index",
  meta: {
    icon: "info",
    title: $t("menus.hsAbout"),
    rank: about
  },
  children: [
    {
      path: "/about/index",
      name: "About",
      component: () => import("@/views/about/index.vue"),
      meta: {
        title: $t("menus.hsAbout")
      }
    },
    {
      path: "/user-profile",
      name: "UserProfile",
      component: () => import("@/views/user-profile/index.vue"),
      meta: {
        title: $t("menus.hsUserProfile"),
        showLink: false,
      }
    },
    {
      path: "/edit-profile",
      name: "EditProfile",
      component: () => import("@/views/user-profile/editInfo.vue"),
      meta: {
        title: $t("menus.hsUserProfile"),
        showLink: false,
      }
    }
  ]
} satisfies RouteConfigsTable;
