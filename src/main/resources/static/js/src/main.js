require('./bootstrap');
import VueTelInput from './components/common/vue-tel-input/dist/vue-tel-input'
import "./components/common/vue-tel-input/dist/vue-tel-input.css"
import router from "./routers/router"
import PasswordInput from "./components/common/password-input/Index"
import VueSweetalert2 from 'vue-sweetalert2';
import "../../../../../../node_modules/croppie/croppie.css"
import store from "./store/index.js"
import 'element-ui/lib/theme-chalk/index.css'
import Buefy from 'buefy';
import 'buefy/dist/buefy.css'
import 'bulma';
import DownLoadFilePlugin from "./plugins/FileDownLoad"
import "../../css/tailwind.css"
import "../../css/app.scss"
import "animate.css"
import 'font-awesome/css/font-awesome.min.css'
import Tooltip from 'vue-directive-tooltip';
import 'vue-directive-tooltip/src/css/index.scss';
import PortalVue from 'portal-vue'
window.Vue = require('vue');
// if (PRODUCTION) {
//     Vue.config.devtools = false;
//     Vue.config.debug = false;
//     Vue.config.silent = true;
// }
Vue.use(DownLoadFilePlugin)
Vue.use(Tooltip, {
    delay: 50,
    triggers: ['hover'],
    offset: 0
});
Vue.use(PortalVue)
Vue.use(VueTelInput);
Vue.component('password-reset', require('./components/auth/PasswordReset').default);
Vue.use(VueSweetalert2);
Vue.use(PasswordInput);

Vue.use(Buefy, {
    defaultIconPack: 'fa',
});
const app = new Vue({
    router,
    store,
    el: "#app-root",
});
