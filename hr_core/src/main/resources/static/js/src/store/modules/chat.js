const state = {
    chatMessage: null,
}

const getters = {
    chatMessage: (state) => state.chatMessage
}
const mutations = {
    SET_CHAT_MESSAGE(state, newMessage) {
        state.chatMessage = newMessage;
    }
}
const actions = {
    setChatMessage: ({commit}, chatMessage) => {
        commit("SET_CHAT_MESSAGE", chatMessage);
    }
}

export default
{
    state,
    mutations,
    getters,
    actions
}