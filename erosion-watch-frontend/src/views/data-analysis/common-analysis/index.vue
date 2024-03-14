<template>
  <el-card>
    <el-row>
      <el-col :span="6">
        <div class="sidebar2 sidebar2-extra">
          <el-text tag="b" class="text">选择算法</el-text>
          <el-divider class="divider" />
          <el-tree-v2
            :ref="'treeRef'"
            :data="treeData"
            :height="400"
            :indent="26"
            :props="props"
            :default-expand-all="true"
            :highlight-current="true"
            :expand-on-click-node="false"
          >
            <template #default="{ node, data }">
              <span
                v-if="data.children != null"
                style="display: inline-flex; align-items: center"
                @click="handleNodeClick(node, data)"
              >
                <i style="display: inline-flex; align-items: center">
                  <svg
                    style="margin: 2px 7px 2px 5px"
                    viewBox="0 0 16 16"
                    width="16"
                    height="16"
                  >
                    <path
                      d="M14,6 L14,5 L7.58578644,5 L5.58578644,3 L2,3 L2,6 L14,6 Z M14,7 L2,7 L2,13 L14,13 L14,7 Z M1,2 L6,2 L8,4 L15,4 L15,14 L1,14 L1,2 Z"
                      stroke-width="1"
                      fill="#8a8e99"
                    />
                  </svg>
                </i>
                <small :title="node.label">{{ node.label }}</small>
              </span>
              <!-- 文档 -->
              <span v-else style="display: inline-flex; align-items: center">
                <i style="display: inline-flex; align-items: center">
                  <svg
                    style="margin: 2px 5px 2px 3px"
                    viewBox="0 0 16 16"
                    width="16"
                    height="16"
                  >
                    <path
                      d="M13,6 L9,6 L9,5 L9,2 L3,2 L3,14 L13,14 L13,6 Z M12.5857864,5 L10,2.41421356 L10,5 L12.5857864,5 Z M2,1 L10,1 L14,5 L14,15 L2,15 L2,1 Z"
                      stroke-width="1"
                      fill="#8a8e99"
                    />
                  </svg>
                </i>
                <small :title="node.label">{{ node.label }}</small>
              </span>
            </template>
          </el-tree-v2>
        </div>
      </el-col>
      <el-col :span="18">
        <el-row>
          <el-col :span="4">
            <div class="sidebar2 sidebar2-extra">
              <el-text tag="b" class="text">选择变量</el-text>
              <el-divider class="divider" />
              <el-tree-v2
                :data="columnsData"
                :props="dataProps"
                :show-checkbox="true"
                :expand-on-click-node="false"
                @check-change="handleCheckChange"
              >
                <template #default="{ node }">
                  <small :title="node.label">{{ node.label }}</small>
                </template>
              </el-tree-v2>
            </div>
          </el-col>
          <el-col :span="20">
            <div class="sidebar2">
              <el-text tag="b">{{ algo }}</el-text>
              <el-divider class="divider" />
              <div class="description">
                <el-text class="mx-1" type="info" size="small"
                  >描述性统计，是指运用制表和分类，图形以及计算概括性数据来描述数据特征的各项活动。描述性统计分析要对调查总体所有变量的有关数据进行统计性描述，主要包括数据的频数分析、集中趋势分析、离散程度分析、分布以及一些基本的统计图形。</el-text
                >
              </div>
              <div
                v-droppable="{ group: 'variables' }"
                class="dashed-box"
                @drop="handleDrop"
              >
                <div
                  v-for="item in droppedItems"
                  :key="item.id"
                  class="dropped-item"
                >
                  <el-tag size="large" closable @close="removeItem(item)">{{
                    item.label
                  }}</el-tag>
                </div>
                <span v-if="droppedItems.length === 0">拖拽至目标区域</span>
              </div>

              <div style="float: right">
                <el-button type="primary" @click="onSubmit">开始分析</el-button>
                <el-button @click="onSubmit">重置</el-button>
              </div>
            </div>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </el-card>
</template>

<script setup>
import { ref } from "vue";
const data = ref(/* your data object */);
const algo = ref("描述性统计");
const treeData = ref([
  // Populate with your tree data
  {
    id: "1",
    label: "描述性分析",
    children: [
      { id: "1-1", label: "描述性统计" },
      { id: "1-2", label: "频数分析" },
      { id: "1-3", label: "正态性检验" }
    ]
  },
  {
    id: "2",
    label: "预测模型",
    children: [{ id: "2-1", label: "线性回归" }]
  },
  {
    id: "3",
    label: "数据可视化",
    children: [{ id: "3-1", label: "柱状图" }]
  }
  // ... more tree items
]);
const columnsData = ref([
  { id: "1", label: "姓名" },
  { id: "2", label: "性别" },
  { id: "3", label: "学号" }
]);
const droppedItems = columnsData;

const handleCheckChange = (data, checked, indeterminate) => {
  // 如果节点被选中，则添加到 droppedItems
  if (checked) {
    droppedItems.value.push({
      id: data.id,
      label: data.label
    });
  } else {
    // 如果节点被取消选中，则从 droppedItems 移除
    const index = droppedItems.value.findIndex(item => item.id === data.id);
    if (index > -1) {
      droppedItems.value.splice(index, 1);
    }
  }
};

// 处理拖拽的函数
const handleDrop = event => {
  // 防止默认处理（默认是打开链接）
  event.preventDefault();

  const variableId = event.dataTransfer.getData("text/plain");

  const variable = columnsData.value.find(v => v.id === variableId);
  if (variable && !droppedItems.value.includes(variable)) {
    droppedItems.value.push(variable);
  }
};

const handleDragOver = event => {
  event.preventDefault(); // 必须阻止默认事件以允许放下
};

// 删除项的方法
const removeItem = item => {
  const index = droppedItems.value.indexOf(item);
  if (index > -1) {
    droppedItems.value.splice(index, 1);
  }
};

const props = {
  value: "id",
  label: "label",
  children: "children"
};

const dataProps = {
  value: "id",
  label: "label"
};

const searchQuery = ref("");

const handleSearch = () => {
  console.log("Searching for:", searchQuery.value);
};
</script>

<style scoped>
.text {
  font-size: 14px;
  margin-bottom: -10px;
}
.sidebar2 {
  height: 500px;
  overflow-y: auto;
  margin-right: 20px;
  margin-left: 0;
  margin-top: 5px;
}

.sidebar2-extra {
  border-right: 1px solid #ddd;
}

.dashed-box {
  border: 1px dashed #ccc;
  padding: 40px 50px 50px 100px;
  margin-bottom: 20px;
  text-align: center;
  color: #aaa;
  font-size: 1rem;
  width: 100%;
  height: 300px;
  box-sizing: border-box;
  border-radius: 2px;
}

.description {
  margin-bottom: 20px;
}

.divider {
  margin: 8px 0;
}

.dashed-box:empty::after {
  content: "拖拽至目标区域";
  color: #bbb;
  font-style: italic;
}
</style>
