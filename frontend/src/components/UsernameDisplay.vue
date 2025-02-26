<template>
  <div v-if="username" class="username-display" @click="navigateToUserDetail">
    {{ username }}
  </div>
</template>

<script>
import { computed } from 'vue';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';

export default {
  name: 'UsernameDisplay',
  setup() {
    const store = useStore();
    const router = useRouter();
    const username = computed(() => store.state.username);

    const navigateToUserDetail = () => {
      if (!username.value) {
        throw new Error('Username is null');
      }
      router.push('/user');
    };

    return {
      username,
      navigateToUserDetail,
    };
  },
};
</script>

<style scoped>
.username-display {
  position:absolute;
  margin-left: 10px;
  top: 10px; /* 距離頂部 10 像素 */
  left: 10px;/*  距離左側 10 像素 */
  padding: 10px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  cursor: pointer;
  background-color: #ebe2e2; /* 背景顏色 */
  color: #000000; /* 字體顏色 */
}
</style>
