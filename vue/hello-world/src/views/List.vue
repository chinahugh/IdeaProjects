<template>
  <div>
    <div>
      <ul>
        <li v-for="(itm,index) in pageLists" :key="index">{{itm.title}}---{{itm.text}}</li>
      </ul>
    </div>
    <div>
      <input type="button" value="添加" @click="add()">
    </div>
  </div>
</template>

<script>
import store from "@/store";

export default {
  msg: "List",
  store,
  computed: {
    pageLists() {
      console.log(store);
      return store.state.lists;
    }
  },
  methods: {
    add() {
      this.$router.push("/add");
    }
  }
};
</script>

<style scoped>
li{
    list-style-type:none;
}
ul{
    list-style-type:none;
}
</style>