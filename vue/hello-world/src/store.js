import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        list: []
    },
    mutations: {
        addItm(state, value) {
            state.list.push(value);
        }
    },
    actions: {}
})
