<template>
  <div class="register-container">
    <h2>註冊 <span class="or-login">or <a @click="$router.push('/login')" class="login-link">登入</a></span></h2>
    <el-form @submit.prevent="handleRegister">
      <el-form-item>
        <label for="username">用戶名:</label>
        <el-input v-model="username" placeholder="用戶名" class="input-field" @keydown.enter="handleRegister" />
      </el-form-item>
      <el-form-item>
        <label for="password">密碼:</label>
        <el-input type="password" v-model="password" placeholder="密碼" class="input-field" @keydown.enter="handleRegister" />
      </el-form-item>
      <el-form-item>
        <label for="email">電子郵件:</label>
        <el-input v-model="email" placeholder="電子郵件" class="input-field" @keydown.enter="handleRegister" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" class="register-button" @click="handleRegister">註冊</el-button>
      </el-form-item>
    </el-form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<script>
import axios from "@/defaultEndPoint";

export default {
  name: 'Register',
  data() {
    return {
      username: '',
      password: '',
      email: '',
      message: ''
    };
  },
  methods: {
    handleRegister() {
      this.message = 'Waiting...'; // 顯示等待字樣
      const registerUrl = `/user/register?username=${this.username}&&password=${this.password}&&email=${this.email}`;
      axios.get(registerUrl).then(response => {
        const { success, message } = response.data;
        this.message = message;
        if (success) {
          this.message += " ";
          setTimeout(() => {
            this.$router.push(`/verifyemail/${this.username}`);
          }, 2000);
        }
      }).catch(error => {
        this.message = '註冊失敗';
        console.error('Register failed:', error);
      });
    }
  }
};
</script>

<style scoped>
.register-container {
  max-width: 400px;
  margin: 50px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
}

h2 {
  text-align: center;
}

.or-login a {
  color: red;
  cursor: pointer;
  text-decoration: none;
}

.login-link {
  font-size: 14px; /* 調整字體大小 */
}

.input-field {
  border: 2px solid red; /* 紅色粗框線 */
}

.el-form-item {
  margin-bottom: 20px;
}

.register-button {
  background-color: red; /* 紅色底色 */
  color: white; /* 白色字體 */
  cursor: pointer;
}

.register-button:hover {
  background-color: #ff4d4d; /* 亮一點的紅色 */
}

.message {
  color: black;
  text-align: center;
  margin-top: 10px;
}
</style>
