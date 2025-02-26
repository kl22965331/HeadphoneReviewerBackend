<template>
  <div class="write-review">
    <h1>對 {{ brand }} 的 {{ name }} 評論</h1>
    <div class="input-container">
      <el-input
        v-model="title"
        placeholder="標題"
        clearable
        size="small"
      ></el-input>
      <el-input
        v-model="comment"
        type="textarea"
        placeholder="評論"
        rows="4"
        clearable
        size="small"
      ></el-input>
      <div class="rating-input">
        <label for="rating">對該耳機評分(0-100)</label>
        <el-input-number
          id="rating"
          v-model="rating"
          :min="0"
          :max="100"
          size="small"
        ></el-input-number>
      </div>
    </div>
    <el-button 
      class="global-button" 
      :disabled="!title || !comment" 
      @click="submitReview"
    >新增</el-button>
    <div v-if="responseMessage" class="response-message">{{ responseMessage }}</div>
    <div v-if="isExpired" class="expired-message">登入已過期，請重新登入</div>
  </div>
</template>

<script>
import axios from '@/defaultEndPoint';
import { ref } from 'vue';
import { useRouter, useRoute } from 'vue-router';

export default {
  name: 'WriteReview',
  setup() {
    const router = useRouter();
    const route = useRoute();

    const brand = route.query.brand || '';
    const name = route.query.name || '';
    const comment = ref('');
    const title = ref('');
    const rating = ref(0);
    const isExpired = ref(false);
    const responseMessage = ref('');

    const submitReview = async () => {
      const token = localStorage.getItem('jwtToken');
      if (!token) {
        responseMessage.value = '未登入將切換到登入頁面';
        setTimeout(() => {
          localStorage.clear();
          router.push('/login');
        }, 2000);
        return;
      }
      
      axios.defaults.headers.common['Authorization'] = token;

      try {
        const response = await axios.get('/user/tokenexpiredcheck');
        if (response.data === true) {
          isExpired.value = true;
          localStorage.clear();
          setTimeout(() => {
            router.push('/login');
          }, 2000);
          return;
        }
      } catch (error) {
        console.error('Error checking token expiration:', error);
        return;
      }

      const reviewData = {
        title: title.value,
        comment: comment.value,
        rating: rating.value,
        headphone: {
          id: route.query.id,
        },
      };

      try {
        const response = await axios.post('/review/add', reviewData);
        if (response.status === 200) {
          responseMessage.value = '新增成功';
          setTimeout(() => {
            router.push('/'); // 切換到 /home 路徑
          }, 2000);
        } else {
          responseMessage.value = `Response: ${response.status} - ${response.statusText} 新增失敗`;
        }
      } catch (error) {
        responseMessage.value = `Error: ${error.response.status} - ${error.response.statusText} 新增失敗`;
        console.error('Error submitting review:', error);
      }
    };

    return {
      brand,
      name,
      comment,
      title,
      rating,
      submitReview,
      isExpired,
      responseMessage,
    };
  },
};
</script>

<style scoped>
.write-review {
  padding: 20px;
  font-family: Arial, sans-serif;
}

.write-review h1 {
  color: #333;
}

.input-container {
  margin-bottom: 20px;
}

.rating-input {
  margin-top: 10px;
}

.global-button {
  margin-top: 20px;
}

.global-button[disabled] {
  opacity: 0.5;
  cursor: not-allowed;
}

.response-message {
  margin-top: 10px;
  color: green;
}

.expired-message {
  color: red;
  margin-top: 10px;
}
</style>
