(window.webpackJsonp=window.webpackJsonp||[]).push([[45],{273:function(t,i,a){"use strict";(function(t){i.a={props:{notification:{required:!0,type:Object}},filters:{formattedDate:i=>t(i).format("LLL")}}}).call(this,a(189))},328:function(t,i,a){var e=a(426);e.__esModule&&(e=e.default),"string"==typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);(0,a(21).default)("83d6f080",e,!1,{})},329:function(t,i,a){var e=a(428);e.__esModule&&(e=e.default),"string"==typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);(0,a(21).default)("a0ac254c",e,!1,{})},425:function(t,i,a){"use strict";a(328)},426:function(t,i,a){(t.exports=a(20)(!1)).push([t.i,".notification-item[data-v-483f06d5]{display:flex;flex-direction:column}.notification-item[data-v-483f06d5]:hover{background-color:#fafafa}\n",""])},427:function(t,i,a){"use strict";a(329)},428:function(t,i,a){(t.exports=a(20)(!1)).push([t.i,".drop-menu-custom[data-v-58480537]{left:auto;right:0px;position:absolute;display:block;top:92%;background:#fff;width:430px;max-height:400px;min-height:0px;border:1px solid #ededed;border-radius:3px;-webkit-transform:translateY(5px);transform:translateY(5px);-webkit-box-shadow:-1px 3px 15px 0 rgba(0,0,0,0.06);box-shadow:-1px 3px 15px 0 rgba(0,0,0,0.06);-webkit-transition:all .3s;transition:all .3s;z-index:20}.drop-menu-custom .loading-indicator[data-v-58480537]{z-index:-60}.drop-menu-custom .notification-header[data-v-58480537]{z-index:40}.drop-menu-custom .notification-footer[data-v-58480537]{z-index:40}.drop-menu-custom .notification-content[data-v-58480537]{max-height:300px;overflow-y:auto}\n",""])},492:function(t,i,a){"use strict";a.r(i);var e=function(){var t=this,i=t._self._c;return i("div",{staticClass:"drop-menu-custom text-black",on:{wheel:function(i){return t.fetchMoreNotification(i)}}},[t.loaded?i("div",{staticClass:"drop-menu-inner h-full w-full relative"},[i("div",{staticClass:"h-full"},[t._m(0),t._v(" "),i("div",{staticClass:"notification-content"},[i("div",{staticClass:"content"},t._l(t.notifications,(function(t){return i("NotificationItem",{key:t.id,attrs:{notification:t}})})),1)]),t._v(" "),t._m(1)])]):i("div",{staticClass:"h-48 flex justify-center is-relative"},[i("b-loading",{attrs:{"is-full-page":!1,active:t.loading,"can-cancel":!0},on:{"update:active":function(i){t.loading=i}}})],1)])};e._withStripped=!0;var n=a(197),o=a.n(n),s=function(){var t=this,i=t._self._c;return i("div",{staticClass:"notification-item pr-2 pl-2 pt-1 pb-1"},[i("div",[t._v("\n\t\t"+t._s(t.notification.message)+"\n\t")]),t._v(" "),i("div",{staticClass:"mt-1 is-size-7"},[i("span",{staticClass:"mr-2"},[t._v("\n\t\t\t"+t._s(t._f("formattedDate")(t.notification.updatedAt))+"\n\t\t")])]),t._v(" "),i("div")])};s._withStripped=!0;var c=a(273).a,l=(a(425),a(14)),r=Object(l.a)(c,s,[],!1,null,"483f06d5",null).exports,d=a(204),f={components:{NotificationItem:r},data:()=>({notifications:[],loaded:!1,page:0,pageSize:10,loading:!1}),created(){this.getUserNotifications()},methods:{getUserNotifications(){let t=this,i={page:t.page,pageSize:t.pageSize};t.loading=!0,axios.get("/api/user-notifications",{params:i}).then(i=>{var a;t.loaded=!0,t.loading=!1,(a=t.notifications).push.apply(a,o()(i.data.content)),i.data.totalPages>t.page&&t.page++},i=>{t.loading=!1})},fetchMoreNotification:a.n(d)()((function(t){let i=this;t.deltaY>0&&i.getUserNotifications()}),2e3)}},u=(a(427),Object(l.a)(f,e,[function(){var t=this._self._c;return t("div",{staticClass:"notification-header p-2 h-12 has-background-white-bis"},[t("div",{staticClass:"flex h-full items-center"},[t("div",{staticClass:"flex-1"},[this._v("\n\t\t\t\t\t\tNotifications\n\t\t\t\t\t")]),this._v(" "),t("div",{staticClass:"hu"},[this._v("\n\t\t\t\t\t\tMark All as Read\n\t\t\t\t\t")])])])},function(){var t=this._self._c;return t("div",[t("div",{staticClass:"notification-footer h-12 has-background-white-bis"},[t("div",{staticClass:"flex h-full items-center justify-center"},[this._v("\n\t\t\t\t\t\tSee All\n\t\t\t\t\t")])])])}],!1,null,"58480537",null));i.default=u.exports}}]);