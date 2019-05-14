<template>
    <div>
        <div>
            <p>name:</p>
            <input v-model="title">
            <p>text:</p>
            <input v-model="text">
        </div>
        <div>
            <button type="button" @click="add()">提交</button>
            <button type="reset">取消</button>
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
            }
        }
    };
</script>

<style scoped>
</style>