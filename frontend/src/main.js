import { createApp } from 'vue';
import App from './App.vue';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import router from './router';
import store from './store';
import './assets/globalButton.css';
import globalmethods from './globalmethods';

    const app = createApp(App);


    app.use(globalmethods,router).use(ElementPlus).use(router).use(store).mount('#app');


    app.config.globalProperties.$username = '';
