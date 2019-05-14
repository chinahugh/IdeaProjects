<template>
    <div id='app'>
        <button type="button" @click="login()">登陆</button>
        <button type="button" @click="login()">注册</button>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                msg: "login"
            }
        },
        methods:{
            login(){
                this.$router.push("/home");
            }
        }
    }
</script>

<style scoped>
</style>