<template>
    <div class="reviews-container">
      <div v-for="review in paginatedReviews" :key="review.id" class="review-card" @click="goToReviewDetail(review.id)">
        <h3>{{ review.title }}</h3>
        <p>{{ truncateComment(review.comment) }}</p>
        <p class="views-count">觀看次數: {{ review.viewsCount }}</p>
      </div>
      <div class="pagination">
        <button @click="prevPage" :disabled="currentPage === 1">上一頁</button>
        <span>第 {{ currentPage }} 頁 / 共 {{ totalPages }} 頁</span>
        <button @click="nextPage" :disabled="currentPage === totalPages">下一頁</button>
      </div>
    </div>
  </template>
  
  <script>
  import axios from "@/defaultEndPoint";
  import { useRouter } from 'vue-router';
  
  export default {
    name: "ReviewsOrderByViewsCount",
    data() {
      return {
        reviews: [],
        currentPage: 1,
        pageSize: 10
      };
    },
    computed: {
      paginatedReviews() {
        const start = (this.currentPage - 1) * this.pageSize;
        const end = start + this.pageSize;
        return this.reviews.slice(start, end);
      },
      totalPages() {
        return Math.ceil(this.reviews.length / this.pageSize);
      }
    },
    methods: {
      async fetchReviews() {
        try {
          const response = await axios.get("/review/getReviewsOrderByViewsCount");
          this.reviews = response.data;
        } catch (error) {
          console.error("Error fetching reviews:", error);
        }
      },
      truncateComment(comment) {
        return comment.length > 10 ? comment.slice(0, 10) + "..." : comment;
      },
      prevPage() {
        if (this.currentPage > 1) {
          this.currentPage--;
        }
      },
      nextPage() {
        if (this.currentPage < this.totalPages) {
          this.currentPage++;
        }
      },
      goToReviewDetail(id) {
        this.$router.push(`/review/${id}`);
      }
    },
    created() {
      this.fetchReviews();
    }
  };
  </script>
  
  <style scoped>
  .reviews-container {
    display: flex;
    flex-direction: column;
    gap: 1rem;
    padding: 0 2rem;
  }
  .review-card {
    border: 1px solid #ccc;
    padding: 1rem;
    border-radius: 5px;
    background-color: #f9f9f9;
    position: relative;
    cursor: pointer;
  }
  .review-card h3 {
    margin: 0;
  }
  .review-card .views-count {
    font-size: 0.9rem;
    color: #555;
    position: absolute;
    bottom: 1rem;
    right: 1rem;
  }
  .pagination {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 1rem;
    margin-top: 1rem;
  }
  .pagination button {
    padding: 0.5rem 1rem;
  }
  </style>
  