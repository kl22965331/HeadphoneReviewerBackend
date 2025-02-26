import axios from 'axios';

console.log("Base URL:", 'http://localhost:8081'); // 打印新設定的baseURL
console.log("123123123123");

const instance = axios.create({
  baseURL: 'http://localhost:8081/' // 直接設置baseURL為http://localhost:8081
});

export default instance;
