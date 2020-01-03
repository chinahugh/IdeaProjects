<template>
  <div>
    {{msg}}
    <div>
      <button type="button" @click="login()">请求</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return { msg: "asdas" };
  },
  methods: {
    login() {
      this.$axios({
        url: `http://127.0.0.1:8080/hello`, // 后台接口
        method: "get" // 请求方式
      })
        .then(response => {
          // 请求成功
          console.log("请求成功");
          console.log(response.data);
          this.course_ctx = response.data; // 将后台数据赋值给前台变量完成页面渲染
        })
        .catch(error => {
          // 请求失败
          console.log("请求失败");
          console.log(error);
        });
    }
  }
};
</script>

<style scoped>
</style>