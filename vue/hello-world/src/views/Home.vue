<template>
  <div>
    <router-view/>
    <ul>
      <li>
        <router-link :to="{name: 'list'}">新闻列表</router-link>
      </li>
      <li>
        <router-link :to="{name: 'user'}">用户信息</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      msg: "vue模板页"
    };
  }
};
</script>

<style scoped>
ul{
      list-style-type:none;
      flex:1;
      text-align: center;
}
</style>