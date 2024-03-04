<template>
  <el-card class="profile-card">
    <div class="profile-header">
      <el-avatar class="avatar" :src="user.profilePicture" :size="100"></el-avatar>
      <div class="user-details">
        <el-form ref="userForm" :model="user" label-position="top">
          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="昵称">
                <el-input v-model="user.nickname" placeholder="请输入昵称"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="性别">
                <el-select v-model="user.gender" placeholder="请选择性别">
                  <el-option label="男" value="男"></el-option>
                  <el-option label="女" value="女"></el-option>
                  <el-option label="其他" value="其他"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="手机号码">
                <el-input v-model="user.phoneNumber" placeholder="请输入手机号码" type="tel"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="个人邮箱">
                <el-input v-model="user.email" placeholder="请输入个人邮箱" type="email"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row :gutter="20">
              <el-col :span="12">
                <el-form-item label="出生日期">
                  <el-date-picker v-model="user.dateOfBirth" type="date" placeholder="选择日期"></el-date-picker>
                </el-form-item>
              </el-col>
            <el-col :span="12">
              <el-form-item label="通讯住址">
                <el-input v-model="user.address" placeholder="请输入通讯住址"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="个人简介">
            <el-input type="textarea" v-model="user.biography" placeholder="介绍一下自己吧"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </div>
    <div class="form-actions">
      <el-button type="primary" @click="submitForm">保存</el-button>
    </div>
  </el-card>
</template>

<script setup>
import {ref} from 'vue';
import {
  ElForm,
  ElFormItem,
  ElInput,
  ElDatePicker,
  ElSelect,
  ElOption,
  ElButton,
  ElUpload,
} from 'element-plus';

const user = ref({
  id: null, // 用户ID通常是不可编辑的
  username: '',
  password: '',
  nickname: '',
  email: '',
  registrationDate: '', // 这里应该是Date对象或可被<el-date-picker>解析的值
  lastLogin: '', // 同上
  firstName: '',
  lastName: '',
  gender: '',
  dateOfBirth: '', // 同上
  address: '',
  phoneNumber: '',
  profilePicture: '', // 这应该是图片的URL
  organization: '',
  realName: '',
  biography: '',
});

// 提交表单的方法
const submitForm = async () => {
  try {
    // 假设你有一个函数sendFormDataToServer来处理数据提交
    const response = await sendFormDataToServer(user.value);
    console.log('Form submitted:', response);
    // 这里可以处理提交后的逻辑，比如提示用户或者清空表单
  } catch (error) {
    console.error('Form submission error:', error);
    // 处理错误，可能是显示一个错误消息给用户
  }
};

// 假设的发送数据到服务器的函数
const sendFormDataToServer = async (formData) => {
  // 使用fetch API或者axios等发送数据到服务器
  const response = await fetch('your-api-endpoint', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(formData),
  });

  if (!response.ok) {
    throw new Error('Network response was not ok');
  }

  return response.json();
};

// 重置表单的方法
const resetForm = () => {
  // 在这里实现重置逻辑
  console.log('Form reset');
};

// 处理头像上传成功的方法
const handleAvatarSuccess = (response, file) => {
  // 在这里更新头像URL
  user.value.profilePicture = URL.createObjectURL(file.raw);
};

// 上传头像前的钩子
const beforeAvatarUpload = (file) => {
  // 在这里实现上传前的校验或其它逻辑
  const isJPG = file.type === 'image/jpeg';
  const isPNG = file.type === 'image/png';
  if (!isJPG && !isPNG) {
    alert('上传头像图片只能是 JPG/PNG 格式!');
    return false;
  }
  const isLt2M = file.size / 1024 / 1024 < 2;
  if (!isLt2M) {
    alert('上传头像图片大小不能超过 2MB!');
    return false;
  }
  return true;
};
</script>

<style scoped>
.profile-card {
  width: 100%;
  margin: auto;
  display: flex;
  justify-content: center;
}

.profile-header {
  display: flex;
  align-items: center;
  max-width: 800px;
  justify-content: center;
  flex-direction: column;
  text-align: center;
}

.avatar {
  margin-bottom: 20px;
}

.user-details {
  width: 100%;
}

.form-actions {
  margin-top: 20px;
  text-align: right;
}
</style>
