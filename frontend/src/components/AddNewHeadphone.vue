<template>
  <div>
    <!-- 新增耳機表單 -->
    <div class="input-container">
      <el-input v-model="newHeadphone.name" placeholder="名稱" clearable size="small"></el-input>
      <el-autocomplete
        v-model="newHeadphone.brand"
        :fetch-suggestions="querySearch"
        placeholder="品牌"
        clearable
        size="small"
      ></el-autocomplete>
      <el-input v-model="newHeadphone.price" placeholder="價格" clearable size="small"></el-input>
      <input type="file" @change="handleFileUpload" />
      <el-button type="primary" @click="addHeadphone" size="small">新增</el-button>
    </div>

    <!-- 過濾用輸入框 -->
    <div class="input-container">
      <el-input
        v-model="nameFilterText"
        placeholder="輸入耳機名稱來過濾"
        clearable
        @input="applyFilter"
        size="small"
      ></el-input>
      <el-input
        v-model="brandFilterText"
        placeholder="輸入品牌名稱來過濾"
        clearable
        @input="applyFilter"
        size="small"
      ></el-input>
    </div>

    <el-table :data="filteredHeadphones" style="width: 100%">
      <el-table-column prop="name" label="名稱" width="150"></el-table-column>
      <el-table-column prop="brand" label="品牌" width="150"></el-table-column>
      <el-table-column prop="price" label="價格" width="100"></el-table-column>
      <el-table-column label="圖片" width="150">
        <template #default="scope">
          <el-image
            :src="scope.row.image ? 'data:image/jpeg;base64,' + scope.row.image : getDefaultImageSrc()"
            style="width: 80px; height: 80px"
            fit="contain"
          />
        </template>
      </el-table-column>
      <el-table-column prop="createDateTime" label="創建時間" sortable width="180"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "@/defaultEndPoint";
import { ref, onMounted, computed, watch } from "vue";
import { useRouter } from 'vue-router';

export default {
  name: "AddNewHeadphone",
  setup() {
    const router = useRouter();
    const headphones = ref([]);
    const nameFilterText = ref("");
    const brandFilterText = ref("");
    const newHeadphone = ref({
      name: "",
      brand: "",
      price: "",
      image: null,
    });

    const fetchHeadphones = async () => {
      try {
        const response = await axios.get("/headphone/listall");
        headphones.value = response.data;
      } catch (error) {
        console.error("獲取數據時出錯：", error);
      }
    };

    const addHeadphone = async () => {
      const token = localStorage.getItem('jwtToken');
      if (!token) {
        localStorage.removeItem('jwtToken');
        localStorage.removeItem('vuex');
        router.push('/login');
        return;
      }

      const formData = new FormData();
      formData.append('name', newHeadphone.value.name);
      formData.append('brand', newHeadphone.value.brand);
      formData.append('price', newHeadphone.value.price);
      formData.append('image', newHeadphone.value.image); // 確保圖片被附加到 formData

      try {
        await axios.post("/headphone/add", formData, {
          headers: {
            "Content-Type": "multipart/form-data",
            "Authorization": token
          },
        });
        fetchHeadphones();
      } catch (error) {
        console.error("新增耳機時出錯：", error);
      }
    };

    const handleFileUpload = (event) => {
      const file = event.target.files[0];
      const reader = new FileReader();
      reader.onload = (e) => {
        const img = new Image();
        img.onload = () => {
          const canvas = document.createElement('canvas');
          const ctx = canvas.getContext('2d');
          const maxWidth = 800;
          const maxHeight = 800;
          let width = img.width;
          let height = img.height;

          if (width > height) {
            if (width > maxWidth) {
              height *= maxWidth / width;
              width = maxWidth;
            }
          } else {
            if (height > maxHeight) {
              width *= maxHeight / height;
              height = maxHeight;
            }
          }

          canvas.width = width;
          canvas.height = height;
          ctx.drawImage(img, 0, 0, width, height);
          canvas.toBlob((blob) => {
            newHeadphone.value.image = blob; // 將壓縮後的圖片設定為 Blob
          }, 'image/jpeg', 0.7); // 壓縮質量70%
        };
        img.src = e.target.result;
      };
      reader.readAsDataURL(file);
    };

    const getDefaultImageSrc = () => {
      return "images/No_Image_Available.jpg";
    };

    const filteredHeadphones = computed(() => {
      return headphones.value.filter((headphone) =>
        headphone.name.toLowerCase().includes(nameFilterText.value.toLowerCase()) &&
        headphone.brand.toLowerCase().includes(brandFilterText.value.toLowerCase())
      );
    });

    const applyFilter = () => {
      // 計算屬性 filteredHeadphones 自動處理過濾邏輯
    };

    const querySearch = (queryString, cb) => {
      const results = headphones.value
        .map(item => item.brand)
        .filter((brand, index, self) => self.indexOf(brand) === index && brand.toLowerCase().includes(queryString.toLowerCase()))
        .map(brand => ({ value: brand }));
      cb(results);
    };

    watch([nameFilterText, brandFilterText], () => {
      // 更新建議列表
    });

    onMounted(() => {
      fetchHeadphones();
    });

    return {
      headphones,
      nameFilterText,
      brandFilterText,
      newHeadphone,
      filteredHeadphones,
      getDefaultImageSrc,
      applyFilter,
      addHeadphone,
      handleFileUpload,
      querySearch
    };
  },
};
</script>

<style scoped>
.input-container {
  margin-bottom: 20px;
  display: flex;
  gap: 10px;
}
</style>
