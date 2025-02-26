<template>
  <div class="headphone-reviews">
    <h1 class="brand-headphone-title">{{ headphoneBrand }} - {{ headphoneName }}</h1>
    <el-button class="global-button" @click="writeReview">對耳機評論</el-button>
    <div class="review-count">評論個數: {{ reviews.length }}</div>
    <div class="review-grid">
      <div class="review-card"
           v-for="review in reviews" :key="review.id"
           @click="navigateToReview(review.id)">
        <div class="review-blank-space"></div> <!-- 留白區域 -->
        <div class="review-title">{{ review.title }}</div>
        <div class="review-rating">評分: {{ review.rating }}</div>
        <div class="review-rating">觀看次數:{{review.viewsCount}}</div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "@/defaultEndPoint";

export default {
  name: 'HeadphoneReviews',
  data() {
    return {
      reviews: [], // 確保 reviews 初始為空數組
      headphoneName: this.$route.query.name || '',
      headphoneBrand: this.$route.query.brand || '',
      headphoneId: this.$route.params.id || null // 保存耳機ID
    };
  },
  methods: {
    fetchReviews() {
      const headphoneId = this.$route.params.id; // 獲取路由參數中的耳機ID
      this.headphoneId = headphoneId; // 保存耳機ID
      axios.get(`/review/getReviewsByHeadphone`, { params: { id: headphoneId } }) // 使用參數的方式
        .then(response => {
          console.log('Fetched Reviews JSON:', response.data); // 顯示完整的JSON響應在控制台上
          if (response.data && response.data.length > 0) {
            this.reviews = response.data;
          } else {
            console.error('No data found in response:', response.data);
          }
        })
        .catch(error => {
          console.error('Error fetching reviews:', error);
        });
    },
    navigateToReview(id) {
      this.$router.push({ path: `/review/${id}` }); // 導航到/review/:id
    },
    writeReview() {
      this.$router.push({ path: `/writereview`, query: { id: this.headphoneId, name: this.headphoneName, brand: this.headphoneBrand } });
    }
  },
  created() {
    this.fetchReviews(); // 當組件創建時調用fetchReviews方法
  }
};
</script>

<style scoped>
.headphone-reviews {
  padding: 20px;
  font-family: Arial, sans-serif;
}

.headphone-reviews h1 {
  color: #333;
}

.review-count {
  margin-bottom: 20px;
  font-size: 1.1em;
  color: #666;
}

.review-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  gap: 20px;
}

.review-card {
  border: 1px solid #ddd;
  padding: 16px;
  text-align: center;
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  cursor: pointer; /* 設置鼠標樣式為手指 */
}

.review-card:hover {
  background-color: #f9f9f9; /* 鼠標懸停時改變背景顏色 */
}

.review-blank-space {
  width: 100%;
  height: 200px;
  background-color: #f4f4f4; /* 設置留白區域的背景顏色 */
}

.review-title {
  margin-top: 10px;
  font-size: 1.2em;
  font-weight: bold;
}

.review-rating {
  margin-top: 5px;
  color: #666;
}

.brand-headphone-title {
  font-size: 30px;
}

.global-button {
  margin-bottom: 20px;
}
</style>
