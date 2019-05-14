<template>
    <div>
        <dev>
            <ul>
                <li v-for="(itm,index) in pageLists" :key="index">
                    {{itm.title}}---{{itm.text}}
                </li>
            </ul>
        </dev>
        <div>
            <input type="button" value="添加" @click="add()">
        </div>
    </div>
</template>

<script>
    import store from '@/store'

    export default {
        data() {
            return {
                msg: 'List',
                store,
                computed: {
                    pagelists() {
                        return store.state.list;
                    }
                }
            }
        },
        methods: {
            add() {
                this.$router.push("/add");
            }
        }
    }
</script>

<style scoped>
</style>