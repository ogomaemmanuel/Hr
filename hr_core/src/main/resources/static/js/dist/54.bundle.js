(window.webpackJsonp=window.webpackJsonp||[]).push([[54],{261:function(t,i,e){var s=e(347);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,e(23).default)("12853470",s,!0,{})},262:function(t,i,e){var s=e(349);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,e(23).default)("50169cc2",s,!0,{})},346:function(t,i,e){"use strict";var s=e(261);e.n(s).a},347:function(t,i,e){(t.exports=e(22)(!1)).push([t.i,".notification-setting[data-v-61ed547e]{border-bottom:1px solid gray;padding:10px;display:flex;justify-content:space-between}\n",""])},348:function(t,i,e){"use strict";var s=e(262);e.n(s).a},349:function(t,i,e){(t.exports=e(22)(!1)).push([t.i,".card-content[data-v-3e1b82e8]{padding:1.5rem 20rem}.main-div[data-v-3e1b82e8]{border:1px solid gray;border-bottom:none}\n",""])},401:function(t,i,e){"use strict";e.r(i);e(173),e(75);var s=e(174),n=e.n(s),a=(e(175),e(176)),o=e.n(a),r=e(35),c=(e(165),e(166)),d=e.n(c),l={name:"Notification",components:{},props:{setting:{required:!0}},data:()=>({value:!0}),methods:{submit(){let t=this;t.isLoading=!0,axios.post("/api/settings/notifications/update",t.setting).then(i=>{t.isLoading=!1,"00"===i.data.status?d.a.success(i.data.msg):d.a.error(i.data.msg),t.getSettings()},i=>{400===i.response.status?(t.isLoading=!1,this.errors=i.response.data):(t.isLoading=!1,d.a.error("Something went wrong. Contact Admin")),t.setting.notify=!t.setting.notify})}}},g=(e(346),e(15)),p=Object(g.a)(l,(function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",{staticClass:"notification-setting"},[e("label",[t._v(t._s(t.setting.name))]),t._v(" "),e("b-switch",{attrs:{size:"is-small","passive-type":"is-danger",type:"is-success"},on:{input:t.submit},model:{value:t.setting.notify,callback:function(i){t.$set(t.setting,"notify",i)},expression:"setting.notify"}})],1)}),[],!1,null,"61ed547e",null).exports,f={name:"NotificationSettingsForm",components:{Select:o.a,Option:n.a,Notification:p},mixins:[r.a],data:()=>({setting:{id:"",name:"",notify:""},settings:[{id:1,name:"Leave",notify:!0},{id:2,name:"Employee",notify:!0},{id:3,name:"Holidays",notify:!1}],isLoading:!1}),created(){this.getSettings()},methods:{getSettings(){let t=this;axios.get("/api/settings/notifications").then(i=>{t.settings=i.data})}}},u=(e(348),Object(g.a)(f,(function(){var t=this.$createElement,i=this._self._c||t;return i("div",{staticClass:"card animated preFadeInUp fadeInUp"},[i("div",{staticClass:"card-content"},[i("h1",{staticClass:"has-text-weight-bold flex justify-center is-size-4 pb-4"},[this._v("Notifications Settings")]),this._v(" "),i("div",{staticClass:"main-div"},this._l(this.settings,(function(t){return i("Notification",{key:t.id,attrs:{setting:t}})})),1)])])}),[],!1,null,"3e1b82e8",null));i.default=u.exports}}]);