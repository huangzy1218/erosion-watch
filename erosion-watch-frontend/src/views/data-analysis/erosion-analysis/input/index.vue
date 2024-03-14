<template>
  <el-card>
    <div>
      <el-collapse v-model="activeNames" @change="handleChange">
        <el-collapse-item title="降雨与径流因子" name="1">
          <div class="description">
            <el-text size="small" type="info"
              >降雨径流是指雨水在地表流动形成的水流。</el-text
            >
          </div>
          <div>
            <el-form
              ref="ruleFormRef"
              :model="newFormInline"
              :rules="formRules"
              label-width="200px"
              :label-position="'top'"
              :size="'small'"
            >
              <el-row>
                <el-col :span="6">
                  <el-form-item label="E总(降雨总动能)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="I30(降雨的最大30分钟雨强)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
        </el-collapse-item>
        <el-collapse-item title="地形因子" name="2">
          <div class="description">
            <el-text size="small" type="info">
              为定量表达地貌形态特征而设定的具有一定意义的数学参数或指标。
            </el-text>
          </div>
          <div>
            <el-form
              ref="ruleFormRef"
              :model="newFormInline"
              :rules="formRules"
              label-width="100px"
              :label-position="'top'"
              :size="'small'"
            >
              <el-row>
                <el-col :span="6">
                  <el-form-item label="S(坡度因子)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="L(坡长因子)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
        </el-collapse-item>
        <el-collapse-item title="植被与经营管理因子" name="3">
          <div class="description">
            <el-text size="small" type="info">
              植被覆盖和管理措施对土壤侵蚀的作用，是人为控制土壤侵蚀的重要因子。
            </el-text>
          </div>
          <div>
            <el-form
              ref="ruleFormRef"
              :model="newFormInline"
              :rules="formRules"
              label-width="100px"
              :label-position="'top'"
              :size="'small'"
            >
              <el-row>
                <el-col :span="4">
                  <el-form-item label="A(有作物生长小区土壤流失量)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item label="A'(休闲地小区土壤流失量)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item label="R(降雨与径流因子)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
        </el-collapse-item>
        <el-collapse-item title="水土保持措施因子" name="4">
          <div>
            <el-text size="small" type="info"
              >指在特定水土保持措施的土壤流失与起伏地耕作的相应土壤流失之比。</el-text
            >
          </div>
          <div>
            <el-form
              ref="ruleFormRef"
              :model="newFormInline"
              :rules="formRules"
              label-width="100px"
              :label-position="'top'"
              :size="'small'"
            >
              <el-row>
                <el-col :span="4">
                  <el-form-item label="土壤坡度(%)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item label="耕作方式" prop="e">
                    <el-select
                      placeholder="请选择"
                      size="small"
                      style="width: 240px"
                    >
                      <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                      />
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
        </el-collapse-item>
        <el-collapse-item title="土壤可蚀性因子" name="4">
          <div class="description">
            <el-text size="small" type="info">
              是指土壤对侵蚀的敏感性。它是土壤对侵蚀抵抗力的倒数。
            </el-text>
          </div>
          <div>
            <el-form
              ref="ruleFormRef"
              :model="newFormInline"
              :rules="formRules"
              label-width="100px"
              :label-position="'top'"
              :size="'small'"
            >
              <el-row>
                <el-col :span="6">
                  <el-form-item label="粉粒含量(%)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="细粒含量(%)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="砂粒含量(%)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="OM(有机物含量%)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="平均团聚体(%)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="渗透性(mm/d)" prop="e">
                    <el-input-number />
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>
  </el-card>
</template>
<script setup lang="ts">
import { formRules } from "@/views/system/user/utils/rule";
import { ref } from "vue";
import { FormProps } from "@/views/system/user/utils/types";
const props = withDefaults(defineProps<FormProps>(), {
  formInline: () => ({
    title: "新增",
    higherDeptOptions: [],
    parentId: 0,
    nickname: "",
    username: "",
    password: "",
    phone: "",
    email: "",
    sex: "",
    status: 1,
    remark: ""
  })
});

const options = [
  {
    value: "1",
    label: "等高耕作"
  },
  {
    value: "2",
    label: "等高带状种植并开垅沟"
  },
  {
    value: "3",
    label: "修梯田"
  }
];

const activeNames = ref([]);
const newFormInline = ref(props.formInline);
</script>

<style scoped>
.description {
  margin-bottom: 20px;
}
</style>
