<template>
  <div class="common-layout">
    <el-container>
      <el-header class="header">
        <UsernameDisplay></UsernameDisplay>
        <a @click.prevent="navigateToHome" class="title-link"
          >HeadphoneReviewer</a
        >
        <div class="button-group">
          <el-button
            v-if="!username"
            type="primary"
            @click="$router.push('/login')"
            class="auth-button"
            >登入</el-button
          >
          <el-button
            v-if="!username"
            type="primary"
            @click="$router.push('/register')"
            class="auth-button"
            >註冊</el-button
          >
          <el-button v-else type="primary" @click="logout" class="auth-button"
            >登出</el-button
          >
        </div>
      </el-header>
      <el-container>
        <el-aside class="aside">
          <!-- New button visible only if role is manager -->
          <el-button
            v-if="role === 'manager'"
            type="primary"
            @click="navigateToAddNewHeadphone"
            class="global-button"
            >新增耳機</el-button
          >
        </el-aside>
        <!-- Left Aside with gray background -->
        <el-main class="main">
          <el-button
            type="primary"
            @click="$router.push('/headphones')"
            class="global-button"
            >查看所有耳機</el-button
          >
          <hr>
          <router-view></router-view>
          <hr>
          
        </el-main>
        <el-aside class="aside"></el-aside>
        <!-- Right Aside with gray background -->
      </el-container>
    </el-container>
    <el-footer class="footer">
      <el-button @click="checkIsManager">開發人員</el-button>
    </el-footer>
  </div>
</template>


<script>
import UsernameDisplay from './components/UsernameDisplay.vue';
import { useStore } from 'vuex';
import { computed, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import axios from "@/defaultEndPoint";
export default {
  name: 'App',
  components: {
    UsernameDisplay
  },
  setup() {
    const store = useStore();
    const router = useRouter();
    const username = computed(() => store.state.username);
    const role = computed(() => store.state.role);

    const navigateToHome = () => {
      router.push({ path: '/', query: { reload: new Date().getTime() } });
    };

    const logout = () => {
      store.commit('clearUsername');
      localStorage.removeItem('jwtToken');
      localStorage.removeItem('tokenExpiryTime');
      localStorage.removeItem('usernameExpiryTime');
      localStorage.removeItem('vuex');
      console.log('用戶已登出');
      window.location.reload();
    };

    const checkTokenExpiry = () => {
      const expiryTime = localStorage.getItem('tokenExpiryTime');
      if (expiryTime && Date.now() > expiryTime) {
        localStorage.removeItem('jwtToken');
        localStorage.removeItem('tokenExpiryTime');
        console.log('Token 已過期並被移除');
      }
    };

    const checkUsernameExpiry = () => {
      const usernameExpiryTime = localStorage.getItem('usernameExpiryTime');
      if (usernameExpiryTime && Date.now() > usernameExpiryTime) {
        store.commit('clearUsername');
        localStorage.removeItem('usernameExpiryTime');
        console.log('Username 已過期並被移除');
      }
    };

    const checkIsManager = async () => {
      // Check role in Vuex
      if (role.value === 'manager') {
        store.commit('setRole', null);
        console.log('Role 已清除');
        return;
      }

      try {
        const token = localStorage.getItem('jwtToken');
        if (!token) {
          router.push('/login');
          return;
        }

        const response = await axios.get('/role/isManager', {
          headers: { Authorization: `${token}` },
        });
        if (response.data === true) {
          store.commit('setRole', 'manager');
          console.log('Role 已設置為 manager');
        }
      } catch (error) {
        console.error('Error checking role:', error);
      }
    };

    onMounted(() => {
  setInterval(checkTokenExpiry, 60 * 1000); // 每分鐘檢查一次 Token 是否過期
  setInterval(checkUsernameExpiry, 60 * 1000); // 每分鐘檢查一次 Username 是否過期

  // 檢查 token 是否過期
  axios.get('/user/tokenexpiredcheck', {
    headers: {
      Authorization: `${localStorage.getItem('jwtToken')}`
    }
  })
  .then(response => {
    if (response.data === true) {
      logout();
    }
  })
  .catch(error => {
    console.error('Error checking token expiry:', error);
  });
});

    const navigateToAddNewHeadphone = () => {
      router.push('/addNewHeadphone');
    };

    return { 
      username, 
      role,
      navigateToHome, 
      logout, 
      checkIsManager, 
      navigateToAddNewHeadphone 
    };
  },
};
</script>


<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.header {
  display: flex;
  align-items: center;
  position: relative;
  background-color: red;
  padding: 10px 0;
}
.title-link {
  color: white;
  text-decoration: none;
  font-size: 32px;
  font-weight: bold;
  cursor: pointer;
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
}
.button-group {
  margin-left: auto; /* Aligns the buttons to the right */
  display: flex;
  gap: 1px; /* Adjust the gap value to bring buttons closer or further apart */
}
.auth-button {
  background-color: white;
  color: red;
  border: 1px solid red;
  margin-right: 10px;
}
.main {
  background-color: rgb(235, 235, 235);
}
.aside {
  background-color: rgb(255, 255, 255);
  width: 100px;
  height: 100vh;
}
.footer {
  background-color: red;
}
</style>
