<template>
  <div class="review" v-if="review">
    <h1>{{ review.title }}</h1>
    <div class="review-container">
      <div class="review-details">
        <p><strong>評論者:</strong> {{ review.user.username }}</p>
        <p>{{ review.comment }}</p>
        <p><strong>對於該耳機的評分:</strong> {{ review.rating }}</p>
        <p>觀看次數:{{ review.viewsCount}}</p>
        <p><strong>發布於:</strong> {{ review.createdAt }}</p>
      </div>
      <div class="headphone-details">
        <h3>Headphone Details</h3>
        <p class="small-font"><strong>耳機名稱:</strong> {{ review.headphone.name }}</p>
        <p class="small-font"><strong>品牌:</strong> {{ review.headphone.brand }}</p>
        <p class="small-font"><strong>價格:</strong> ${{ review.headphone.price }}</p>
        <img
          :src="review.headphone.image ? `data:image/jpeg;base64,${review.headphone.image}` : '/images/No_Image_Available.jpg'"
          alt="Headphone Image"
          class="headphone-image"
        />
      </div>
    </div>
    <hr> <!-- 分隔線 -->

    <div v-if="comments && comments.length > 0" class="comments-section">
      <h3>Comments</h3>
      <ul>
        <li v-for="comment in comments" :key="comment.id">
          <p><strong>@</strong> {{ comment.user.username }}</p>
          <p>{{ comment.comment }}</p>
          <p><strong>發布於:</strong> {{ comment.createdAt }}</p>
        </li>
      </ul>
    </div>
    <div v-else>
      <p>No comments available.</p>
    </div>

    <!-- 新增評論區域 -->
    <div class="comment-form">
      <el-input
        v-model="newComment"
        type="textarea"
        placeholder="請輸入評論"
        rows="3"
        clearable
        size="small"
      ></el-input>
      <el-button class="global-button" @click="submitComment">發表評論</el-button>
      <div v-if="responseMessage" class="response-message">{{ responseMessage }}</div>
    </div>
  </div>
  <div v-else>
    <p>Loading review...</p>
  </div>
</template>

<script>
import axios from "@/defaultEndPoint";

export default {
  name: 'Review',
  data() {
    return {
      review: null,
      comments: null,
      newComment: '',
      responseMessage: '',
    };
  },
  methods: {
    fetchReview() {
      const reviewId = this.$route.params.id; // 獲取路由參數中的評論ID
      axios.get(`/review/get/${reviewId}`) // 使用路徑參數發送請求
        .then(response => {
          console.log('Fetched Review JSON:', response.data); // 顯示JSON響應在控制台上
          this.review = response.data;

          // Fetch comments by review ID
          axios.get(`/comment/commentsByReviewId?id=${reviewId}`)
            .then(commentResponse => {
              console.log('Fetched Comments JSON:', commentResponse.data); // 顯示評論響應在控制台上
              this.comments = commentResponse.data;
            })
            .catch(commentError => {
              console.error('Error fetching comments:', commentError);
            });
        })
        .catch(error => {
          console.error('Error fetching review:', error);
        });
    },
    submitComment() {
      const token = localStorage.getItem('jwtToken');
      if (!token) {
        localStorage.clear();
        this.$router.push('/login');
        return;
      }

      axios.defaults.headers.common['Authorization'] = token;
      const reviewId = this.$route.params.id;
      const params = new URLSearchParams();
      params.append('reviewId', reviewId);
      params.append('comment', this.newComment);

      axios.post('/comment/addNewComment', params)
        .then(response => {
          this.responseMessage = `Response: ${response.status} - ${response.statusText}`;
          if (response.status === 200) {
            this.newComment = '';
            this.fetchReview(); // 重新獲取評論和回應
          }
        })
        .catch(error => {
          this.responseMessage = `Error: ${error.response.status} - ${error.response.statusText}`;
          console.error('Error submitting comment:', error);
        });
    },
  },
  created() {
    this.fetchReview(); // 當組件創建時調用fetchReview方法
  },
};
</script>

<style scoped>
.review {
  padding: 20px;
  font-family: Arial, sans-serif;
}

.review h1 {
  color: #333;
  text-align: center; /* 標題置中 */
}

.review-container {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
}

.review-details {
  width: 65%;
  text-align: center; /* 內容置中 */
}

.headphone-details {
  width: 25%;
  text-align: left; /* 默認靠左 */
}

.headphone-image {
  width: 100px; /* 設置圖片的最大寬度 */
  height: auto; /* 自動調整高度以保持比例 */
  object-fit: contain; /* 保持圖片比例 */
}

.comments-section {
  margin-top: 20px;
}

.comments-section h3 {
  color: #333;
  text-align: center; /* 標題置中 */
}

.comments-section ul {
  list-style-type: none;
  padding: 0;
}

.comments-section li {
  margin-bottom: 15px;
  border-bottom: 1px solid #ddd;
  padding-bottom: 10px;
}

.comment-form {
  margin-top: 20px;
}

.global-button {
  margin-top: 10px;
}

.response-message {
  margin-top: 10px;
  color: green;
}

.small-font {
  font-size: 0.9em; /* 調整字體大小 */
}
</style>
