<script setup lang="ts">
import { ref, computed, reactive } from "vue";
import { clone } from "@pureadmin/utils";
import type { ElTreeV2 } from "element-plus";
import { transformI18n } from "@/plugins/i18n";
import { useRenderIcon } from "@/components/ReIcon/src/hooks";
import { extractPathList, deleteChildren } from "@/utils/tree";
import { usePermissionStoreHook } from "@/store/modules/permission";
import type { TreeNode } from "element-plus/es/components/tree-v2/src/types";
import NodeTree from "@iconify-icons/ri/node-tree";
import { useI18n } from "vue-i18n";
import VuePdfEmbed from "vue-pdf-embed";
import splitpane, { ContextProps } from "@/components/ReSplitPane";

const settingLR: ContextProps = reactive({
  minPercent: 20,
  defaultPercent: 40,
  split: "vertical"
});

interface treeNode extends TreeNode {
  meta: {
    title: string;
  };
}

const query = ref("");
const dataProps = ref({
  value: "uniqueId",
  children: "children"
});
const treeRef = ref<InstanceType<typeof ElTreeV2>>();
const menusTree = clone(usePermissionStoreHook().wholeMenus, true);

const menusData = computed(() => {
  return deleteChildren(menusTree);
});

const expandedKeys = extractPathList(menusData.value);

const onQueryChanged = (query: string) => {
  (treeRef as any).value!.filter(query);
};

const filterMethod = (query: string, node: treeNode) => {
  return transformI18n(node.meta.title)!.indexOf(query) !== -1;
};

const { t } = useI18n();
const pdfRef = ref<any>();
const pageCount = ref(1);
const loading = ref(true);
const currentPage = ref(1);
const currentRotation = ref(0);
const showAllPages = ref(false);
const rotations = [0, 90, 180, 270];

const source =
  "https://xiaoxian521.github.io/hyperlink/pdf/Cookie%E5%92%8CSession%E5%8C%BA%E5%88%AB%E7%94%A8%E6%B3%95.pdf";

const handleDocumentRender = () => {
  loading.value = false;
  pageCount.value = pdfRef.value.pageCount;
};

const showAllPagesChange = () => {
  currentPage.value = showAllPages.value ? null : 1;
};

const onPrint = () => {
  pdfRef.value.print();
};
</script>

<template>
  <div class="split-pane">
    <splitpane :splitSet="settingLR">
      <template #paneL>
        <el-scrollbar>
          <el-card shadow="never">
            <el-input
              v-model="query"
              class="mb-4"
              placeholder="请输入关键字查找"
              clearable
              @input="onQueryChanged"
            />
            <el-tree-v2
              ref="treeRef"
              :data="menusData"
              :props="dataProps"
              :height="500"
              :filter-method="filterMethod"
              :default-expanded-keys="expandedKeys"
            >
              <template #default="{ data }">
                <span>{{ transformI18n(data.meta.title) }}</span>
              </template>
            </el-tree-v2>
          </el-card>
        </el-scrollbar>
      </template>
      <template #paneR>
        <el-scrollbar>
          <el-card shadow="never" style="height: 100%">
            <div
              v-loading="loading"
              class="h-[calc(100vh-239px)]"
              :element-loading-text="t('status.hsLoad')"
            >
              <div class="flex justify-between items-center h-9">
                <div v-if="showAllPages" class="font-medium ml-1.25 text-xl">
                  共{{ pageCount }}页
                </div>
                <div v-else>
                  <el-pagination
                    v-model:current-page="currentPage"
                    background
                    layout="prev, slot, next"
                    :page-size="1"
                    :total="pageCount"
                  >
                    {{ currentPage }} / {{ pageCount }}
                  </el-pagination>
                </div>
                <div class="w-[170px] flex-bc">
                  <el-checkbox
                    v-model="showAllPages"
                    @change="showAllPagesChange"
                  >
                    显示所有页面
                  </el-checkbox>
                  <el-tooltip
                    effect="dark"
                    :content="`翻转（当前角度${rotations[currentRotation]}度）`"
                    placement="top"
                  >
                    <IconifyIconOnline
                      icon="ic:baseline-rotate-90-degrees-ccw"
                      class="cursor-pointer outline-transparent"
                      @click="
                        currentRotation === 3
                          ? (currentRotation = 0)
                          : (currentRotation += 1)
                      "
                    />
                  </el-tooltip>
                  <el-tooltip effect="dark" content="打印" placement="top">
                    <IconifyIconOnline
                      icon="ri:printer-line"
                      class="cursor-pointer outline-transparent"
                      @click="onPrint"
                    />
                  </el-tooltip>
                </div>
              </div>
              <el-scrollbar>
                <vue-pdf-embed
                  ref="pdfRef"
                  class="h-full container overflow-auto"
                  :rotation="rotations[currentRotation]"
                  :page="currentPage"
                  :source="source"
                  @rendered="handleDocumentRender"
                />
              </el-scrollbar>
            </div>
          </el-card>
        </el-scrollbar>
      </template>
    </splitpane>
  </div>
</template>

<style lang="scss" scoped>
.body {
  display: flex;
}

.left,
.right {
  flex: 2;
}

.right {
  flex: 5;
}

.split-pane {
  width: 100%;
  height: calc(100vh - 260px);
  font-size: 50px;
  text-align: center;
  border: 1px solid #e5e6eb;

  .dv-a {
    padding-top: 30vh;
    color: rgba($color: dodgerblue, $alpha: 80%);
  }

  .dv-b {
    padding-top: 10vh;
    color: rgba($color: #000, $alpha: 80%);
  }

  .dv-c {
    padding-top: 18vh;
    color: rgba($color: #ce272d, $alpha: 80%);
  }
}
</style>
