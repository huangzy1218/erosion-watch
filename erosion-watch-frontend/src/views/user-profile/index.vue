<template>
  <el-card>
    <el-row :gutter="20">
      <el-col :span="3" class="user-profile-card">
        <el-avatar shape="square" :size="100" src="src/assets/user.jpg"/>
        <div class="user-details">
          <h2 class="nickname">{{ user.nickname }}</h2>
          <div class="user-contact">
            <p class="user-email">{{ user.email }}</p>
            <p class="user-phone">{{ user.phoneNumber }}</p>
          </div>
        </div>
      </el-col>
      <el-col :span="18">
        <el-descriptions title="用户信息" :column="2" border :size="mini">
          <el-descriptions-item label="用户名称"><el-tag effect="plain">{{ user.username }}</el-tag></el-descriptions-item>
          <el-descriptions-item label="注册日期"><el-tag effect="plain">{{ formatDate(user.registrationDate) }}</el-tag></el-descriptions-item>
          <el-descriptions-item label="性别 ">
            <el-tag effect="plain">{{ user.gender }}</el-tag></el-descriptions-item>
          <el-descriptions-item label="出生日期"><el-tag effect="plain">{{ formatDate(user.dateOfBirth) }}</el-tag></el-descriptions-item>
          <el-descriptions-item label="通讯地址"><el-tag effect="plain">{{ user.address }}</el-tag></el-descriptions-item>
          <el-descriptions-item label="所属单位"><el-tag effect="plain">{{ user.organization }}</el-tag></el-descriptions-item>
          <el-descriptions-item label="真实姓名"><el-tag effect="plain">{{ user.realName }}</el-tag></el-descriptions-item>
          <el-descriptions-item label="个人简介" :span="4">{{ user.biography }}</el-descriptions-item>
        </el-descriptions>
      </el-col>
    </el-row>
    <div class="edit-button">
      <el-button type="primary" @click="editProfile">编辑个人资料</el-button>
    </div>
  </el-card>
</template>

<script setup>
import { ref } from "vue";
import { router } from "@/router";

const user = ref({
  username: "Huang Z.Y.",
  nickname: "485A59",
  email: "john@example.com",
  registrationDate: new Date(),
  firstName: "John",
  lastName: "Doe",
  gender: "男",
  dateOfBirth: new Date(1990, 1, 1),
  address: "某地",
  phoneNumber: "1234567890",
  organization: "某公司",
  realName: "John Doe",
  biography: "个人简介内容..."
});
const formatDate = (value) => {
  if (!value) return "";
  const date = new Date(value);
  return date.toISOString().split("T")[0];
};

const editProfile = () => {
  router.push("/edit-profile");
  console.log("编辑个人资料");
};
</script>

<style scoped>

.edit-button {
  margin-top: 5px;
  text-align: right;
}

.user-info-header p {
  margin-top: 5px;
  font-size: 18px;
  font-weight: bold;
}

.user-profile-card {
  display: flex;
  flex-direction: row;
  align-items: center;
  text-align: center;
  margin-right: 10px;
}

.user-profile-card {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  text-align: center;
  padding: 10px;
  margin-left: 20px;
  box-sizing: border-box;
}

.el-descriptions-item label {
  white-space: pre;
}

.user-info-header {
  display: flex;
  align-items: center;
  gap: 15px;
}

.user-details {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin-top: 10px;
}

.nickname {
  font-size: 1.5em;
  font-weight: bold;
  margin: 0;
  color: #262626;
}

.user-contact {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  text-align: left;
}

.user-email,
.user-phone {
  margin: 0;
  color: #3c3c4399;
  font-weight: lighter;
  font-size: 0.9em;
}
</style>
