<template>
    <div class="app">
        <div class="box">
            <p>name:</p>
            <input v-model="title">
            <p>text:</p>
            <input v-model="text">
        </div>
        <div>
            <button class="ican" type="button" @click="add()">提交</button>
            <button class="ican" type="button" @click="ret()">返回</button>
        </div>
    </div>
</template>

<script>
    import store from "@/store";

    export default {
        data() {
            return {
                title: "",
                text: "",
            };
        },
        methods: {
            add() {
                store.commit("addItm", {
                    title: this.title,
                    text: this.text
                });
                 this.$router.push("/home");
            },
            ret() {
                this.$router.push("/home");
            }
        }
    };
</script>

<style scoped lang="scss">

.box{
    text-size-adjust: 10px;
    color: aqua;
    flex-flow: row nowrap;
    line-height: 1px;
    background-attachment: fixed;
    background-color:bisque;
    top: 10px;
    text-shadow: 100ch
    
    
}
.app{
    flex-flow: row;
    background: yellow;
}
.footer{
    flex-flow: row nowrap;
    line-height: 100px
}
.ican{
    text-align: 10px;
    padding:5%

}
</style>