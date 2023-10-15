import { createStore } from "vuex";

export default createStore({
    state: () => ({
        searchQuery: '',
    }),
    mutations: {
        SET_SEARCH_QUERY(state, newValue) {
            state.searchQuery = newValue
        }
    },
    getters: {
        SEARCH_QUERY(state) {
            return state.searchQuery
        },
    }
})