<script setup lang="ts">
import { ref, computed, reactive, onMounted } from "vue";
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
import { getReferencesList } from "@/api/references";

const settingLR: ContextProps = reactive({
  minPercent: 30,
  defaultPercent: 30,
  split: "vertical"
});

interface treeNode {
  id: number; // 节点的唯一标识
  label: string; // 显示在树上的文献题目
  pdfUrl: string; // 相应PDF文档的链接
  children?: treeNode[]; // 子节点数组
}

const menusData = ref<treeNode[]>();

const query = ref("");
const dataProps = ref({
  label: "label",
  children: "children"
});
const treeRef = ref<InstanceType<typeof ElTreeV2>>();
const menusTree = clone(usePermissionStoreHook().wholeMenus, true);

const expandedKeys = extractPathList(menusData.value);

const onQueryChanged = (query: string) => {
  (treeRef as any).value!.filter(query);
};

onMounted(async () => {
  try {
    const res = await getReferencesList();
    console.log(res);
    menusData.value = res.data.nodes;
  } catch (error) {
    console.error("Failed to fetch menus data:", error);
  }
});

const { t } = useI18n();
const pdfRef = ref<any>();
const pageCount = ref(1);
const loading = ref(true);
const currentPage = ref(1);
const currentRotation = ref(0);
const showAllPages = ref(false);
const rotations = [0, 90, 180, 270];

const source = ref(
  "https://xiaoxian521.github.io/hyperlink/pdf/Cookie%E5%92%8CSession%E5%8C%BA%E5%88%AB%E7%94%A8%E6%B3%95.pdf"
);

const handleNodeClick = (nodeData: treeNode) => {
  if (nodeData.pdfUrl) {
    source.value = nodeData.pdfUrl; // 更新PDF源地址
    currentPage.value = 1; // 重置到PDF的第一页
    loading.value = true; // 可能需要重新显示加载状态
  }
};

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
  <el-card style="height: 100%">
    <splitpane :splitSet="settingLR">
      <template #paneL>
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
          :height="400"
          :default-expanded-keys="expandedKeys"
          @node-click="handleNodeClick"
        >
          <template #default="{ data }">
            <span>{{ data.label }}</span>
          </template>
        </el-tree-v2>
      </template>
      <template #paneR>
        <el-card shadow="never">
          <div
            v-loading="loading"
            class="h-[calc(100vh-239px)]"
            :element-loading-text="t('status.hsLoad')"
          >
            <div class="flex justify-between items-center h-9">
              <div v-if="showAllPages" class="font-medium ml-1.25 text-base">
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
                :height="1050"
                class="h-full container overflow-auto"
                :rotation="rotations[currentRotation]"
                :page="currentPage"
                :source="source"
                @rendered="handleDocumentRender"
              />
            </el-scrollbar>
          </div>
        </el-card>
      </template>
    </splitpane>
  </el-card>
</template>
