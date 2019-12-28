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
import 'buefy/dist/buefy.css'
import 'bulma';
import DownLoadFilePlugin from "./plugins/FileDownLoad"
import "../../css/tailwind.css"
import "../../css/app.scss"
import 'font-awesome/css/font-awesome.min.css'
import Tooltip from 'vue-directive-tooltip';
import 'vue-directive-tooltip/src/css/index.scss';

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
Vue.use(VueTelInput);
Vue.use(VueBreadcrumbs, {
    template: `
        <div v-if="$breadcrumbs.length" class="ant-breadcrumb breadcrumb">
        <nav class="breadcrumb is-small" aria-label="breadcrumbs">
  <ul>
    <li tag="span" v-for="(crumb, key) in $breadcrumbs" :class="{'is-active':key==$breadcrumbs.length-1}" :to="linkProp(crumb)" :key="key">
    <router-link :to="linkProp(crumb)">
    <span v-if="crumb.meta.breadcrumbIcon" class="icon is-small">
          <i :class="crumb.meta.breadcrumbIcon" class="fa" aria-hidden="true"></i>
        </span>
    {{ crumb | crumbText }}
    </router-link></li>
  </ul>
</nav>
</div>`

});
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
