import { createRouter, createWebHistory } from 'vue-router';
import HomeList from '../components/HomeList.vue';
import Login from '../components/Login.vue';
import UserDetail from '@/components/UserDetail.vue';
import HeadphoneList from '@/components/HeadphoneList.vue';
import Reviews from '@/components/HeadphoneReviews.vue';
import Review from '@/components/Review.vue'
import Register from '@/components/Register.vue'
import AddNewHeadphone from '@/components/AddNewHeadphone.vue';
import Headphones from '@/components/Headphones.vue';
import WriteReview from '@/components/WriteReview.vue';
import VerifyEmail from '@/components/VerifyEmail.vue';
const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeList
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  { 
    path: '/user', 
    name: 'UserDetail', 
    component: UserDetail 
  },
  {
    path: '/headphoneList/:brand',
    name: 'HeadphoneList',
    component: HeadphoneList,
    props: true
  },
  { path: '/reviews/:id', 
    name: 'reviews', 
    component: Reviews, 
    props: route => ({ 
      headphoneId: 
      route.query.headphoneId, 
      brand: route.query.brand, 
      name: route.query.name 
    }) 
  },
  {
    path: '/review/:id',
    name: 'review',
    component: Review
  },
  {
    path:'/register',
    name:'register',
    component:Register

  },{
    path:'/addNewHeadphone',
    name:'addnewheadphone',
    component:AddNewHeadphone
  },{
    path:'/headphones',
    name:'headphones',
    component:Headphones
  },
  {
    path:'/writereview',
    name:'writereview',
    component:WriteReview,
    props: route => ({ name: route.query.name, brand: route.query.brand,id: route.query.id})  
  },{
    path:'/verifyemail/:username',
    name:'verifyemail',
    component:VerifyEmail
  },

];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
