<template>
  <div class="verify-container">
    <div class="input-group">
      <el-input v-model="code[0]" maxlength="1" class="verify-input" @input="handleInput(0)" @keyup.enter="handleEnter(0)" ref="input0"></el-input>
      <el-input v-model="code[1]" maxlength="1" class="verify-input" @input="handleInput(1)" @keyup.enter="handleEnter(1)" ref="input1"></el-input>
      <el-input v-model="code[2]" maxlength="1" class="verify-input" @input="handleInput(2)" @keyup.enter="handleEnter(2)" ref="input2"></el-input>
      <el-input v-model="code[3]" maxlength="1" class="verify-input" @input="handleInput(3)" @keyup.enter="handleEnter(3)" ref="input3"></el-input>
    </div>
    <el-button type="primary" @click="handleVerify">驗證</el-button>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<script>
import axios from "@/defaultEndPoint";

export default {
  name: 'VerifyEmail',
  data() {
    return {
      code: ['', '', '', ''],
      message: ''
    };
  },
  methods: {
    handleInput(index) {
      if (this.code[index].length === 1 && index < 3) {
        this.$refs[`input${index + 1}`].focus();
      }
    },
    handleEnter(index) {
      if (index === 3) {
        this.handleVerify();
      } else {
        this.$refs[`input${index + 1}`].focus();
      }
    },
    handleVerify() {
      const username = this.$route.params.username;
      const verifyIntCode = this.code.map(Number); // 将输入转换为整数数组
      const verifyUrl = `/user/verifyemail?username=${username}`;
      
      axios.post(verifyUrl, verifyIntCode).then(response => {
        const { success, message } = response.data;
        this.message = message;
        if (success) {
          setTimeout(() => {
            this.$router.push('/login');
          }, 2000);
        }
      }).catch(error => {
        this.message = '驗證失敗';
        console.error('Verification failed:', error);
      });
    }
  },
  mounted() {
    this.$refs.input0.focus();
    // 在组件挂载时检查路由参数
    console.log(this.$route.params.username);
  }
};
</script>

<style scoped>
.verify-container {
  max-width: 400px;
  margin: 50px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
  text-align: center;
}

.input-group {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.verify-input {
  width: 50px;
  height: 50px;
  margin: 0 5px;
  text-align: center;
  font-size: 18px;
}

.message {
  color: black;
  margin-top: 10px;
}
</style>
