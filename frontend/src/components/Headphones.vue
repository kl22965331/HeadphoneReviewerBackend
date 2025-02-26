<template>
  <div>
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

    <el-table :data="filteredHeadphones" style="width: 100%"  class="table-container">
      <el-table-column prop="name" label="名稱" width="100"></el-table-column>
      <el-table-column prop="brand" label="品牌" width="100"></el-table-column>
      <el-table-column prop="price" label="價格" width="80"></el-table-column>
      <el-table-column label="圖片" width="100">
        <template #default="scope">
          <el-image
            :src="scope.row.image ? 'data:image/jpeg;base64,' + scope.row.image : getDefaultImageSrc()"
            style="width: 60px; height: 60px"
            fit="contain"
          />
        </template>
      </el-table-column>
      <el-table-column prop="createDateTime" label="創建時間" sortable width="150"></el-table-column>
      <el-table-column label="操作" width="120">
        <template #default="scope">
          <el-button
            type="primary"
            @click="$router.push({
              path:`/reviews/${scope.row.id}`,
              query: { 
              headphoneId:scope.row.id, 
              brand: scope.row.brand, 
              name: scope.row.name
              }
              })"
            size="small"
            >查看所有評論</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "@/defaultEndPoint";
import { ref, onMounted, computed, watch } from "vue";
import { useRouter } from "vue-router";

export default {
  name: "Headphones",
  setup() {
    const headphones = ref([]);
    const nameFilterText = ref("");
    const brandFilterText = ref("");
    const router = useRouter();

    const fetchHeadphones = async () => {
      try {
        const response = await axios.get("/headphone/listall");
        headphones.value = response.data;
      } catch (error) {
        console.error("獲取數據時出錯：", error);
      }
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
      filteredHeadphones,
      getDefaultImageSrc,
      applyFilter,
      router,
    };
  },
};
</script>

<style scoped>
.input-container {
  margin-bottom: 10px;
  display: flex;
  gap: 5px;
}
.table-container{
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
