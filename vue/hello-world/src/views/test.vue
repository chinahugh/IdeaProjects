<template>
  <div>
    <div>{{msg}}</div>
    <button type="button" @click="add">添加</button>
  </div>
</template>

<script>
export default {
  data() {
    return { msg: "vue模板页" };
  },
  methods: {
    add() {
      console.log(211111111111111);
    }
  }
};
</script>

<style scoped>
</style>