(window.webpackJsonp=window.webpackJsonp||[]).push([[6],{118:function(t,e,a){"use strict";var s=a(89);a.n(s).a},119:function(t,e,a){(t.exports=a(5)(!1)).push([t.i,".notification-item[data-v-d50ed452]{display:flex;flex-direction:column}.notification-item[data-v-d50ed452]:hover{background-color:#fafafa}\n",""])},121:function(t,e,a){"use strict";var s=a(90);a.n(s).a},122:function(t,e,a){(t.exports=a(5)(!1)).push([t.i,".drop-menu-custom[data-v-29e24b38]{left:auto;right:0px;position:absolute;display:block;top:92%;background:#fff;width:430px;max-height:400px;min-height:0px;border:1px solid #ededed;border-radius:3px;-webkit-transform:translateY(5px);transform:translateY(5px);-webkit-box-shadow:-1px 3px 15px 0 rgba(0,0,0,0.06);box-shadow:-1px 3px 15px 0 rgba(0,0,0,0.06);-webkit-transition:all .3s;transition:all .3s;z-index:20}.drop-menu-custom .loading-indicator[data-v-29e24b38]{z-index:-60}.drop-menu-custom .notification-header[data-v-29e24b38]{z-index:40}.drop-menu-custom .notification-footer[data-v-29e24b38]{z-index:40}.drop-menu-custom .notification-content[data-v-29e24b38]{max-height:300px;overflow-y:auto}\n",""])},128:function(t,e,a){"use strict";var s=a(91);a.n(s).a},129:function(t,e,a){(t.exports=a(5)(!1)).push([t.i,".app-breadcrumb.el-breadcrumb[data-v-9ea32918]{display:inline-block;font-size:14px;line-height:50px;margin-left:8px}.app-breadcrumb.el-breadcrumb .no-redirect[data-v-9ea32918]{color:#97a8be;cursor:text}\n",""])},130:function(t,e,a){"use strict";var s=a(92);a.n(s).a},131:function(t,e,a){(t.exports=a(5)(!1)).push([t.i,".navbar-item .profile-image[data-v-50923f72]{height:36px;width:36px;max-height:36px}.toggle-mobile-nav[data-v-50923f72]{background-color:transparent;border:0px;padding:6px 16px;margin:0 0 0 -15px;height:46px}\n",""])},166:function(t,e,a){"use strict";a.r(e);var s=a(77),i=a.n(s),n={data:()=>({csrfToken:null}),created(){this.csrfToken=document.querySelector("meta[name='_csrf']").getAttribute("content")},methods:{logout(){this.$refs.logoutForm.submit()}}},r=a(2),o=Object(r.a)(n,function(){var t=this.$createElement,e=this._self._c||t;return e("b-tooltip",{attrs:{label:"logout",type:"is-dark",position:"is-left"}},[e("form",{ref:"logoutForm",attrs:{method:"post",action:"/logout"}},[e("input",{attrs:{type:"hidden",name:"_csrf"},domProps:{value:this.csrfToken}}),this._v(" "),e("i",{staticClass:"fa fa-sign-out fa-2x",on:{click:this.logout}})])])},[],!1,null,null,null).exports,l=a(84),c=a.n(l),u=a(88).a,d=(a(118),Object(r.a)(u,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"notification-item  pr-2 pl-2 pt-1 pb-1"},[a("div",[t._v("\n\t\t"+t._s(t.notification.message)+"\n\t")]),t._v(" "),a("div",{staticClass:"mt-1 is-size-7"},[a("span",{staticClass:"mr-2"},[t._v("\n\t\t\t"+t._s(t._f("formattedDate")(t.notification.updatedAt))+"\n\t\t")])]),t._v(" "),a("div")])},[],!1,null,"d50ed452",null).exports),v=a(120),f={components:{NotificationItem:d},data:()=>({notifications:[],loaded:!1,page:0,pageSize:10,loading:!1}),created(){this.getUserNotifications()},methods:{getUserNotifications(){let t=this,e={page:t.page,pageSize:t.pageSize};t.loading=!0,axios.get("/api/user-notifications",{params:e}).then(e=>{var a;t.loaded=!0,t.loading=!1,(a=t.notifications).push.apply(a,c()(e.data.content)),e.data.totalPages>t.page&&t.page++},e=>{t.loading=!1})},fetchMoreNotification:a.n(v)()(function(t){let e=this;t.deltaY>0&&e.getUserNotifications()},2e3)}},m=(a(121),Object(r.a)(f,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"drop-menu-custom text-black",on:{wheel:function(e){return t.fetchMoreNotification(e)}}},[t.loaded?a("div",{staticClass:"drop-menu-inner h-full w-full relative"},[a("div",{staticClass:"h-full"},[t._m(0),t._v(" "),a("div",{staticClass:"notification-content"},[a("div",{staticClass:"content"},t._l(t.notifications,function(t){return a("NotificationItem",{attrs:{notification:t}})}),1)]),t._v(" "),t._m(1)])]):a("div",{staticClass:"h-48 flex justify-center is-relative"},[a("b-loading",{attrs:{"is-full-page":!1,active:t.loading,"can-cancel":!0},on:{"update:active":function(e){t.loading=e}}})],1)])},[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"notification-header p-2 h-12 has-background-white-bis"},[e("div",{staticClass:"flex h-full items-center"},[e("div",{staticClass:"flex-1"},[this._v("\n\t\t\t\t\t\tNotifications\n\t\t\t\t\t")]),this._v(" "),e("div",{staticClass:"hu"},[this._v("\n\t\t\t\t\t\tMark All as Read\n\t\t\t\t\t")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",[e("div",{staticClass:"notification-footer h-12 has-background-white-bis"},[e("div",{staticClass:"flex h-full items-center justify-center"},[this._v("\n\t\t\t\t\t\tSee All\n\t\t\t\t\t")])])])}],!1,null,"29e24b38",null).exports),p=a(10),h=(a(123),a(24),a(124)),_=a.n(h),b=(a(125),a(126)),g=a.n(b),C=a(127),x={components:{Breadcrumb:g.a,BreadcrumbItem:_.a},data:()=>({levelList:null}),watch:{$route(t){t.path.startsWith("/redirect/")||this.getBreadcrumb()}},created(){this.getBreadcrumb()},methods:{getBreadcrumb(){let t=this.$route.matched.filter(t=>t.meta&&t.meta.title);const e=t[0];this.isHome(e)||(t=[{path:"/",meta:{title:"Home",redirect:!0}}].concat(t)),this.levelList=t.filter(t=>t.meta&&t.meta.title&&!1!==t.meta.breadcrumb)},isHome(t){const e=t&&t.name;return!!e&&e.trim().toLocaleLowerCase()==="Home".toLocaleLowerCase()},pathCompile(t){const{params:e}=this.$route;return C.a(t)(e)},handleLink(t){const{redirect:e,path:a}=t;e?this.$router.push(e):this.$router.push(this.pathCompile(a))}}};a(128);function w(t,e){var a=Object.keys(t);if(Object.getOwnPropertySymbols){var s=Object.getOwnPropertySymbols(t);e&&(s=s.filter(function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable})),a.push.apply(a,s)}return a}function y(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{};e%2?w(a,!0).forEach(function(e){i()(t,e,a[e])}):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(a)):w(a).forEach(function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(a,e))})}return t}let k;var E={components:{LogoutForm:o,NotificationDropDown:m,TestBreadCrump:Object(r.a)(x,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("Breadcrumb",{staticClass:"app-breadcrumb",attrs:{separator:"/"}},[a("transition-group",{attrs:{name:"breadcrumb"}},t._l(t.levelList,function(e,s){return a("BreadcrumbItem",{key:e.path},["noRedirect"===e.redirect||s==t.levelList.length-1?a("span",{staticClass:"no-redirect"},[t._v(t._s(e.meta.title))]):a("a",{on:{click:function(a){return a.preventDefault(),t.handleLink(e)}}},[t._v(t._s(e.meta.title))])])}),1)],1)},[],!1,null,"9ea32918",null).exports},props:{user:{}},data:()=>({showNotifications:!1,isFullPage:!0}),computed:y({},Object(p.c)(["authenticatedUser"])),created(){this.setUser(JSON.parse(this.user))},directives:{closable:{bind(t,e,a){k=s=>{s.stopPropagation();const{handler:i,exclude:n}=e.value;let r=!1;n.forEach(t=>{if(!r){const e=a.context.$refs[t];r=e.contains(s.target)}}),t.contains(s.target)||r||a.context[i]()},document.addEventListener("click",k),document.addEventListener("touchstart",k)},unbind(){document.removeEventListener("click",k),document.removeEventListener("touchstart",k)}}},methods:y({},Object(p.b)(["setUser"]),{hideNotifications(){this.showNotifications=!1},open(){const t=this.$buefy.loading.open({container:this.isFullPage?null:this.$refs.element.$el});setTimeout(()=>t.close(),3e3)}})},$=(a(130),Object(r.a)(E,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("nav",{staticClass:"navbar is-primary",attrs:{role:"navigation","aria-label":"main navigation"}},[t._m(0),t._v(" "),a("div",{staticClass:"navbar-menu",attrs:{id:"navbarBasicExample"}},[t._m(1),t._v(" "),a("div",{staticClass:"navbar-end"},[a("a",{ref:"notification-toggle",staticClass:"navbar-item is-hoverable is-relative",on:{click:function(e){t.showNotifications=!0}}},[a("i",{staticClass:"fa fa-bell"}),t._v(" "),t.showNotifications?a("NotificationDropDown",{directives:[{name:"closable",rawName:"v-closable",value:{exclude:["notification-toggle"],handler:"hideNotifications"},expression:"{\n    exclude: ['notification-toggle'],\n    handler: 'hideNotifications'\n  }"}]}):t._e()],1),t._v(" "),t._m(2),t._v(" "),a("div",{staticClass:"navbar-item"},[a("LogoutForm")],1),t._v(" "),a("div",{staticClass:"navbar-item has-dropdown is-hoverable"},[t._m(3),t._v(" "),a("div",{staticClass:"navbar-dropdown is-right"},[a("a",{staticClass:"navbar-item"},[a("article",{staticClass:"media"},[t._m(4),t._v(" "),a("div",{staticClass:"media-content"},[a("div",{staticClass:"content"},[a("p",[a("strong",[t._v(t._s(t.authenticatedUser.fullName))])])])])])]),t._v(" "),a("a",{staticClass:"navbar-item"},[t._v("\n                                Profile\n                            ")]),t._v(" "),a("a",{staticClass:"navbar-item"},[t._v("\n                                Change Password\n                            ")]),t._v(" "),a("a",{staticClass:"navbar-item"},[t._v("\n                                Logout\n                            ")])])])])])]),t._v(" "),a("section",{staticClass:"main-content columns  is-fullheight"},[a("aside",{staticClass:"column is-2 bg-gray-900 text-white pr-0 pl-3 pt-5 is-narrow-mobile relative section is-hidden-mobile"},[a("ul",{staticClass:"menu-list"},[t._m(5),t._v(" "),a("li",[t._m(6),t._v(" "),a("ul",{staticClass:"mr-0 pr-0 border-l-0"},[a("li",[a("router-link",{attrs:{to:"/users"}},[a("span",[t._v("Users")])])],1),t._v(" "),a("li",[a("router-link",{attrs:{to:"roles"}},[a("span",[t._v("Roles")])])],1),t._v(" "),t._m(7)])]),t._v(" "),a("li",[t._m(8),t._v(" "),a("ul",{staticClass:"mr-0 pr-0 border-l-0"},[a("li",[a("router-link",{attrs:{to:"/employees"}},[a("span",[t._v("All Employees")])])],1),t._v(" "),a("li",[a("router-link",{attrs:{to:"/departments"}},[a("span",[t._v("Departments")])])],1),t._v(" "),a("li",[a("router-link",{attrs:{to:"/designations"}},[a("span",[t._v("Designations")])])],1),t._v(" "),t._m(9),t._v(" "),t._m(10),t._v(" "),t._m(11)])]),t._v(" "),a("li",[t._m(12),t._v(" "),a("ul",{staticClass:"border-l-0"},[a("li",[a("router-link",{attrs:{to:"/leave"}},[a("span",[t._v("My Leaves")])])],1),t._v(" "),a("li",[a("router-link",{attrs:{to:"/documents"}},[a("span",[t._v("In Place")])])],1),t._v(" "),a("li",[a("router-link",{attrs:{to:"/leave-approvals"}},[a("span",[t._v("Leave approvals")])])],1),t._v(" "),a("li",[a("router-link",{attrs:{to:"/holidays"}},[a("span",[t._v("Holidays")])])],1),t._v(" "),a("li",[a("router-link",{attrs:{to:"/leave-types"}},[a("span",[t._v("Leave Types")])])],1)])]),t._v(" "),a("li",[t._m(13),t._v(" "),a("ul",{staticClass:"border-l-0"},[a("li",[a("router-link",{attrs:{to:"/documents"}},[a("span",[t._v("Manage Files")])])],1),t._v(" "),a("li",[a("router-link",{attrs:{to:"/documents"}},[a("span",[t._v("My Files")])])],1)])]),t._v(" "),t._m(14)]),t._v(" "),t._m(15)]),t._v(" "),a("div",{staticClass:" column is-10 p-10 h-screen mb-0"},[a("div",{staticClass:"flex items-center"},[t._m(16),t._v(" "),a("TestBreadCrump")],1),t._v(" "),a("div",{staticClass:"mt-5 h-full"},[a("router-view")],1)])])])},[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"navbar-brand"},[e("a",{staticClass:"navbar-item",attrs:{href:"https://bulma.io"}},[e("img",{attrs:{src:"https://bulma.io/images/bulma-logo.png",width:"112",height:"28"}})]),this._v(" "),e("a",{staticClass:"navbar-burger burger",attrs:{role:"button","aria-label":"menu","aria-expanded":"false","data-target":"navbarBasicExample"}},[e("span",{attrs:{"aria-hidden":"true"}}),this._v(" "),e("span",{attrs:{"aria-hidden":"true"}}),this._v(" "),e("span",{attrs:{"aria-hidden":"true"}})])])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"navbar-start"},[a("a",{staticClass:"navbar-item"},[t._v("\n                        Home\n                    ")]),t._v(" "),a("a",{staticClass:"navbar-item"},[t._v("\n                        Documentation\n                    ")]),t._v(" "),a("div",{staticClass:"navbar-item has-dropdown is-hoverable"},[a("a",{staticClass:"navbar-link"},[t._v("\n                            More\n                        ")]),t._v(" "),a("div",{staticClass:"navbar-dropdown"},[a("a",{staticClass:"navbar-item"},[t._v("\n                                About\n                            ")]),t._v(" "),a("a",{staticClass:"navbar-item"},[t._v("\n                                Jobs\n                            ")]),t._v(" "),a("a",{staticClass:"navbar-item"},[t._v("\n                                Contact\n                            ")]),t._v(" "),a("hr",{staticClass:"navbar-divider"}),t._v(" "),a("a",{staticClass:"navbar-item"},[t._v("\n                                Report an issue\n                            ")])])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("a",{staticClass:"navbar-item"},[e("i",{staticClass:"fa fa-envelope"})])},function(){var t=this.$createElement,e=this._self._c||t;return e("figure",{staticClass:"image is-fullwidth navbar-link"},[e("img",{staticClass:"is-rounded profile-image",attrs:{src:"https://bulma.io/images/placeholders/128x128.png"}})])},function(){var t=this.$createElement,e=this._self._c||t;return e("figure",{staticClass:"media-left"},[e("p",{staticClass:"image is-32x32"},[e("img",{staticClass:"is-rounded",attrs:{src:"https://bulma.io/images/placeholders/128x128.png"}})])])},function(){var t=this.$createElement,e=this._self._c||t;return e("li",[e("a",{attrs:{href:"#"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-home"})]),this._v(" Home\n                        ")])])},function(){var t=this.$createElement,e=this._self._c||t;return e("a",{attrs:{href:"#"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-id-card"})]),this._v(" Access Control\n                        ")])},function(){var t=this.$createElement,e=this._self._c||t;return e("li",[e("a",{attrs:{href:"#"}},[e("span",[this._v("Permissions")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("a",{attrs:{href:"#"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-id-card"})]),this._v(" Employee Management\n                        ")])},function(){var t=this.$createElement,e=this._self._c||t;return e("li",[e("a",{attrs:{href:"#"}},[e("span",[this._v("Attendance(Admin)")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("li",[e("a",{attrs:{href:"#"}},[e("span",[this._v("Attendance(Employee)")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("li",[e("a",{attrs:{href:"#"}},[e("span",[this._v("Overtime")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("a",{attrs:{href:"#"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-table"})]),this._v(" Leave Management\n                        ")])},function(){var t=this.$createElement,e=this._self._c||t;return e("a",{attrs:{href:"#"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-folder-open"})]),this._v(" File Management\n                        ")])},function(){var t=this.$createElement,e=this._self._c||t;return e("li",[e("a",{attrs:{href:"#"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-info"})]),this._v(" About\n                        ")])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"side-bar-footer bg-gray-800 left-0  right-0 h-8 absolute bottom-0"},[e("div",{staticClass:"flex justify-end mr-4"},[e("i",[e("span",{staticClass:"fa fa-angle-left"})])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("button",{staticClass:"is-hidden-desktop toggle-mobile-nav",attrs:{type:"button"}},[e("i",{staticClass:"fa fa-bars text-gray-600"})])}],!1,null,"50923f72",null));e.default=$.exports},78:function(t,e){function a(t){var e=new Error("Cannot find module '"+t+"'");throw e.code="MODULE_NOT_FOUND",e}a.keys=function(){return[]},a.resolve=a,t.exports=a,a.id=78},88:function(t,e,a){"use strict";(function(t){e.a={props:{notification:{required:!0,type:Object}},filters:{formattedDate:e=>t(e).format("LLL")}}}).call(this,a(76))},89:function(t,e,a){var s=a(119);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,a(6).default)("790a7652",s,!0,{})},90:function(t,e,a){var s=a(122);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,a(6).default)("1ef384b4",s,!0,{})},91:function(t,e,a){var s=a(129);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,a(6).default)("a759de54",s,!0,{})},92:function(t,e,a){var s=a(131);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,a(6).default)("18e3f3b8",s,!0,{})}}]);