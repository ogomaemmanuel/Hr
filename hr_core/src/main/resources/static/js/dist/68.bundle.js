(window.webpackJsonp=window.webpackJsonp||[]).push([[68],{458:function(t,i,e){var s=e(553);s.__esModule&&(s=s.default),"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,e(22).default)("2afa92bb",s,!1,{})},459:function(t,i,e){var s=e(555);s.__esModule&&(s=s.default),"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,e(22).default)("6e2e7d1b",s,!1,{})},552:function(t,i,e){"use strict";e(458)},553:function(t,i,e){(t.exports=e(21)(!1)).push([t.i,".notification-setting[data-v-58ed64ce]{border-bottom:1px solid gray;padding:10px;display:flex;justify-content:space-between}",""])},554:function(t,i,e){"use strict";e(459)},555:function(t,i,e){(t.exports=e(21)(!1)).push([t.i,".card-content[data-v-66edfa7a]{padding:1.5rem 20rem}.main-div[data-v-66edfa7a]{border:1px solid gray;border-bottom:none}",""])},628:function(t,i,e){"use strict";e.r(i);var s=function(){var t=this._self._c;return t("div",{staticClass:"card animated preFadeInUp fadeInUp"},[t("div",{staticClass:"card-content"},[t("h1",{staticClass:"has-text-weight-bold flex justify-center is-size-4 pb-4"},[this._v("Notifications Settings")]),this._v(" "),t("div",{staticClass:"main-div"},this._l(this.settings,(function(i){return t("Notification",{key:i.id,attrs:{setting:i}})})),1)])])};s._withStripped=!0;e(328),e(83);var n=e(329),a=e.n(n),o=(e(330),e(331)),d=e.n(o),r=e(34),c=function(){var t=this,i=t._self._c;return i("div",{staticClass:"notification-setting"},[i("label",[t._v(t._s(t.setting.name))]),t._v(" "),i("b-switch",{attrs:{size:"is-small","passive-type":"is-danger",type:"is-success"},on:{input:t.submit},model:{value:t.setting.notify,callback:function(i){t.$set(t.setting,"notify",i)},expression:"setting.notify"}})],1)};c._withStripped=!0;e(186);var l=e(187),f=e.n(l),p={name:"Notification",components:{},props:{setting:{required:!0}},data:()=>({value:!0}),methods:{submit(){let t=this;t.isLoading=!0,axios.post("/api/settings/notifications/update",t.setting).then(i=>{t.isLoading=!1,"00"===i.data.status?f.a.success(i.data.msg):f.a.error(i.data.msg),t.getSettings()},i=>{400===i.response.status?(t.isLoading=!1,this.errors=i.response.data):(t.isLoading=!1,f.a.error("Something went wrong. Contact Admin")),t.setting.notify=!t.setting.notify})}}},u=(e(552),e(15)),g=Object(u.a)(p,c,[],!1,null,"58ed64ce",null).exports,m={name:"NotificationSettingsForm",components:{Select:d.a,Option:a.a,Notification:g},mixins:[r.a],data:()=>({setting:{id:"",name:"",notify:""},settings:[{id:1,name:"Leave",notify:!0},{id:2,name:"Employee",notify:!0},{id:3,name:"Holidays",notify:!1}],isLoading:!1}),created(){this.getSettings()},methods:{getSettings(){let t=this;axios.get("/api/settings/notifications").then(i=>{t.settings=i.data})}}},h=(e(554),Object(u.a)(m,s,[],!1,null,"66edfa7a",null));i.default=h.exports}}]);