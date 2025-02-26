<template>
  <div>
    <h1 class="title">品牌清單</h1>
    <el-row :gutter="20">
      <el-col v-for="item in data" :key="item" :span="6">
        <el-card
          :body-style="{ padding: '5px' }"
          @click="navigateToBrand(item)"
          class="clickable-card"
        >
          <el-image
            v-if="images[item]"
            style="width: 100%; height: 200px"
            :src="images[item]"
            fit="contain"
          />
          <el-image
            v-else
            style="width: 100%; height: 200px"
            :src="getDefaultImageSrc()"
            fit="contain"
          />
          <div class="brand-name">{{ item }}</div>
        </el-card>
      </el-col>
    </el-row>
    <el-button
      v-if="role === 'manager'"
      class="global-button"
      @click="toggleInput"
    >
      新增品牌圖片
    </el-button>
    <div v-if="showInput">
      <el-input
        placeholder="品牌名稱"
        v-model="newBrand.name"
        style="margin: 10px 0"
      />
      <el-upload
        action=""
        :http-request="handleUpload"
        :auto-upload="false"
        :on-change="handleFileChange"
      >
        <el-button>選擇品牌圖片(Only jpg)</el-button>
      </el-upload>
      <el-button @click="addBrand">新增</el-button>
    </div>
    <br>
    <br>
    <reviews-order-by-views-count></reviews-order-by-views-count>
  </div>
</template>

<script>
import axios from "@/defaultEndPoint";
import { ref, onMounted, computed } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import ReviewsOrderByViewsCount from "./ReviewsOrderByViewsCount.vue";

export default {
  name: "HomeList",
  components:{
    ReviewsOrderByViewsCount
  }
  ,
  setup() {
    const store = useStore();
    const role = computed(() => store.state.role);
    const data = ref([]);
    const images = ref({});
    const router = useRouter();
    const showInput = ref(false);
    const newBrand = ref({ name: "", image: null });

    const fetchData = async () => {
      try {
        const response = await axios.get("headphone/brand/brandList");
        data.value = response.data;
        await preloadImages(response.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    const preloadImages = async (brands) => {
      const promises = brands.map((brand) => {
        return new Promise((resolve) => {
          const img = new Image();
          img.src = getImageSrc(brand);
          img.onload = () => {
            images.value[brand] = img.src;
            resolve();
          };
          img.onerror = () => {
            console.error("Error loading image:", img.src);
            resolve(); // 即使圖片加載失敗也調用resolve
          };
        });
      });
      await Promise.all(promises);
    };

    const getImageSrc = (brand) => {
      return `images/${brand}.jpg`;
    };

    const getDefaultImageSrc = () => {
      return `images/No_Image_Available.jpg`;
    };

    const navigateToBrand = (brand) => {
      router.push(`/headphoneList/${brand}`);
    };

    const toggleInput = () => {
      showInput.value = !showInput.value;
    };

    const handleFileChange = (file) => {
      newBrand.value.image = file.raw;
    };

    const handleUpload = async (options) => {
      const jwtToken = localStorage.getItem("jwtToken");
      if (!jwtToken) {
        router.push("/login");
        return;
      }

      const formData = new FormData();
      formData.append("name", newBrand.value.name);
      formData.append("image", newBrand.value.image);

      try {
        const response = await axios.post("/util/upload/image", formData, {
          headers: {
            Authorization: jwtToken, // 附加 jwtToken，不加 Bearer
          },
        });
        console.log("Upload response:", response);
        fetchData(); // 重新加載品牌列表
      } catch (error) {
        console.error("Error uploading image:", error);
      }
    };

    const addBrand = () => {
      handleUpload();
      toggleInput(); // 關閉輸入框
    };

    onMounted(() => {
      console.log(role.value); // 打印role值，調試用
      fetchData();
    });

    return {
      data,
      images,
      navigateToBrand,
      getDefaultImageSrc,
      role,
      showInput,
      newBrand,
      toggleInput,
      handleFileChange,
      addBrand,
    };
  },
};
</script>

<style scoped>
.title {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 40px;
}
.brand-name {
  text-align: center;
  margin-top: 10px;
  cursor: pointer;
  color: rgb(0, 0, 0); /* 更改顏色以顯示它是可點擊的 */
}
.clickable-card {
  cursor: pointer;
}
.global-button {
  /* 假設global-button是你定義的全局樣式類 */
}
</style>
