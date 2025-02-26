// src/globalMethods.js
import axios from '@/defaultEndPoint';

export default {
  install(app, router) {
    app.config.globalProperties.$expiredCheck = async function () {
      const token = localStorage.getItem('jwtToken');
      if (!token) {
        return false; // localStorage 没有 jwtToken
      }

      // 设置 Axios Authorization header
      axios.defaults.headers.common['Authorization'] = token;

      try {
        const response = await axios.get('/user/tokenexpiredcheck');
        if (response.data === true) {
          // 清空 localStorage 并跳转到登录页
          localStorage.clear();
          router.push('/login');
        }
      } catch (error) {
        console.error('Error checking token expiration:', error);
      }
    };
  },
};
