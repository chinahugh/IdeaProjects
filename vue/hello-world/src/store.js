import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        lists: []
    },
    mutations: {
        addItm(state, value) {
            state.lists.push(value)
        },
    },
    actions: {}
})
