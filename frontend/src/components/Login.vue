<template>
  <div class="login-container">
    <h2>登入 <span class="or-register">or <a @click="$router.push('/register')" class="register-link">註冊</a></span></h2>
    <el-form @submit.prevent="handleLogin">
      <el-form-item>
        <el-input v-model="username" placeholder="用戶名" class="input-field" @keydown.enter="handleLogin" />
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="password" placeholder="密碼" class="input-field" @keydown.enter="handleLogin" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" class="login-button" @click="handleLogin">登入</el-button>
      </el-form-item>
    </el-form>
    <p v-if="loginError" class="error-message">登入失敗 or <a @click="$router.push('/register')" class="register-link">註冊</a></p>
  </div>
</template>

<script>
import axios from "@/defaultEndPoint";

export default {
  name: 'Login',
  data() {
    return {
      username: '',
      password: '',
      loginError: false
    };
  },
  methods: {
    handleLogin() {
      const loginUrl = `/user/login?username=${this.username}&&password=${this.password}`;
      axios.get(loginUrl).then(response => {
        const authorizationHeader = response.headers['authorization'];
        const usernameHeader = response.headers['username'];

        if (response.status === 200 && authorizationHeader && usernameHeader) {
          // 將 username 更新到 Vuex 狀態
          this.$store.commit('setUsername', usernameHeader);

          // 將 JWT Token 儲存到 localStorage
          localStorage.setItem('jwtToken', authorizationHeader);
          // 重新導向到首頁
          this.$router.push('/');
        } else {
          this.loginError = true;
        }
      }).catch(error => {
        this.loginError = true;
        console.error('Login failed:', error);
      });
    }
  }
};
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: 50px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
}

h2 {
  text-align: center;
}

.or-register a {
  color: red;
  cursor: pointer;
  text-decoration: none;
}

.register-link {
  font-size: 14px; /* 調整字體大小 */
}

.input-field {
  border: 2px solid red; /* 紅色粗框線 */
}

.el-form-item {
  margin-bottom: 20px;
}

.login-button {
  background-color: red; /* 紅色底色 */
  color: white; /* 白色字體 */
  cursor: pointer;
}

.login-button:hover {
  background-color: #ff4d4d; /* 亮一點的紅色 */
}

.error-message {
  color: black;
  text-align: center;
  margin-top: 10px;
}

.error-message a {
  color: red;
  cursor: pointer;
}
</style>
