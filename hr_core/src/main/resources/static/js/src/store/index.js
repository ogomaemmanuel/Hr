import Vue from "vue";
import Vuex from "vuex"
import user from "./modules/user"
import chat from "./modules/chat";
Vue.use(Vuex);

const store = new Vuex.Store({
    modules: {
        user,
        chat
    }
});

export default store;