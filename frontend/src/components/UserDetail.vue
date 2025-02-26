<template>
  <el-container>
    <el-aside width="300px">
      <div class="personal-info">
        <h3>個人資料</h3>
        <p><strong>使用者名稱:</strong> {{ userData.username }}</p>
        <p><strong>電子郵件:</strong> {{ userData.email }}</p>
        <p><strong>建立於:</strong> {{ userData.createdAt }}</p>
      </div>
    </el-aside>
    <el-main>
      <el-table :data="filteredReviews" stripe>
        <el-table-column prop="headphone.name" label="名稱"></el-table-column>
        <el-table-column prop="headphone.brand" label="品牌"></el-table-column>
        <el-table-column prop="headphone.createDateTime" label="發布時間"></el-table-column>
        <el-table-column prop="rating" label="評分"></el-table-column>
        <el-table-column label="操作">
          <template v-slot="scope">
            <el-button 
              class="global-button" 
              @click="navigateToReview(scope.row.id)"
            >查看</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
import axios from '@/defaultEndPoint';
import { mapState } from 'vuex';

export default {
  name: 'UserDetail',
  data() {
    return {
      userData: {},
      reviews: []
    };
  },
  computed: {
    ...mapState(['username']),
    filteredReviews() {
      return this.reviews.filter(review => typeof review !== 'number');
    }
  },
  methods: {
    navigateToReview(id) {
      this.$router.push(`/review/${id}`);
    }
  },
  created() {
    if (!this.username) {
      throw new Error('Username is null');
    }
    axios.get(`/user/getByName?username=${this.username}`)
      .then(response => {
        this.userData = response.data;
        this.reviews = response.data.reviews.filter(review => typeof review !== 'number');
      })
      .catch(error => {
        console.error('Error fetching user data:', error);
      });
  }
};
</script>

<style scoped>
.personal-info {
  text-align: center;
  padding: 20px;
}

.global-button {
  padding: 6px 12px;
  background-color: #409EFF;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.global-button:hover {
  background-color: #66b1ff;
}
</style>
