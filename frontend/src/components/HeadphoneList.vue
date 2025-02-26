<template>
  <div class="headphone-list">
    <h2 class="brand-title">{{ brand }}</h2>
    <h2>耳機清單</h2>
    <div v-if="headphones.length > 0" class="headphones-container">
      <div v-for="headphone in headphones" :key="headphone.id" class="headphone-item" @click="navigateToReviews(headphone)">
        <div class="image-container">
          <img v-if="headphone.image" :src="getImageSrc(headphone.image)" alt="headphone image" class="headphone-image">
          <div v-else class="placeholder"></div>
        </div>
        <p class="headphone-name">{{ headphone.name }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "@/defaultEndPoint";

export default {
  name: "HeadphoneList",
  data() {
    return {
      brand: this.$route.params.brand || '',
      headphones: []
    };
  },
  methods: {
    fetchHeadphones() {
      axios.get(`/headphone/brand/${this.brand}`)
        .then(response => {
          this.headphones = response.data;
          console.log('Fetched Headphones:', response.data);
        })
        .catch(error => {
          console.error('Error fetching headphones:', error);
        });
    },
    getImageSrc(image) {
      return `data:image/jpeg;base64,${image}`;
    },
    navigateToReviews(headphone) {
      this.$router.push({ 
        path: `/reviews/${headphone.id}`, 
        query: { 
          headphoneId: headphone.id, 
          brand: headphone.brand, 
          name: headphone.name 
        }
      });
    }
  },
  watch: {
    '$route.params.brand': function(newBrand) {
      this.brand = newBrand;
      this.fetchHeadphones();
    }
  },
  created() {
    if (this.brand) {
      this.fetchHeadphones();
    }
  }
};
</script>

<style scoped>
.headphone-list {
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center; /* 中央對齊整個列表 */
}

.brand-title {
  font-size: 70px;
  font-weight: bold;
  margin-bottom: 20px;
  text-align: center; /* 中央對齊文字 */
}

.headphones-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center; /* 中央對齊項目 */
}

.headphone-item {
  margin: 20px;
  text-align: center; /* 中央對齊文字 */
  cursor: pointer; /* 添加手指樣式 */
  border: 2px solid red; /* 添加紅色框線 */
  padding: 10px; /* 添加內邊距，使框線更加明顯 */
  background-color: white; /* 添加白色背景 */
}

.headphone-item:hover {
  opacity: 0.8; /* 添加hover效果，使其更加明顯 */
}

.image-container {
  width: 100px;
  height: 100px;
}

.headphone-image,
.placeholder {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.placeholder {
  background-color: #f0f0f0; /* 替代圖片的背景色 */
}

.headphone-name {
  margin-top: 10px;
  text-align: center; /* 中央對齊文字 */
}
</style>
