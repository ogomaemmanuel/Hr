require('./bootstrap');
import VueTelInput from './components/common/vue-tel-input/dist/vue-tel-input'
import "./components/common/vue-tel-input/dist/vue-tel-input.css"
import router from "./routers/router"
import PasswordInput from "./components/common/password-input/Index"
import VueSweetalert2 from 'vue-sweetalert2';
import "../../../../../../node_modules/croppie/croppie.css"
import store from "./store/index.js"
import 'element-ui/lib/theme-chalk/index.css'
import VueBreadcrumbs from 'vue-breadcrumbs'
import Buefy from 'buefy';
import 'bulma';
import 'buefy/dist/buefy.css'

window.Vue = require('vue');
import Tooltip from 'vue-directive-tooltip';
import 'vue-directive-tooltip/src/css/index.scss';
// if (PRODUCTION) {
//     Vue.config.devtools = false;
//     Vue.config.debug = false;
//     Vue.config.silent = true;
// }
Vue.use(Tooltip, {
    delay: 50,
    triggers: ['hover'],
    offset: 0
});
Vue.use(VueTelInput);
Vue.use(VueBreadcrumbs, {
    template: `
        <div v-if="$breadcrumbs.length" class="ant-breadcrumb"><span>
        <!--<span class="ant-breadcrumb-link">Dashboard</span>-->
         <!--<span class="ant-breadcrumb-separator">/</span>-->
    </span><span><span class="ant-breadcrumb-link">
    <router-link exact  tag="span" v-for="(crumb, key) in $breadcrumbs" :to="linkProp(crumb)" :key="key" class="gx-link breadcrumb-item">{{ crumb | crumbText }}</router-link></span>
</span><span><span class="ant-breadcrumb-link">
</span></span></div>`

});

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
