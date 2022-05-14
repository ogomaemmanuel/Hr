const state = {
    authenticatedUser: false
}
const getters = {
    authenticatedUser: (state) => state.authenticatedUser
}
const mutations = {
    SET_USER(state, newUser) {
        state.authenticatedUser = newUser;
    }
}
const actions = {
    setUser({commit}, newUser) {
        commit("SET_USER", newUser);
    }
}

export default {
    state,
    mutations,
    getters,
    actions
}