<template>
    <dev>{{msg}}</dev>
    <button type="button" @click="add">添加</button>
</template>

<style>
</style>

<script>
    export default {
        data() {
            return {msg: 'vue模板页'}
        },
        methods: {
            add() {
                console.log(211111111111111);
            }
        }
    }
</script>    