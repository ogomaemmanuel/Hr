(window.webpackJsonp=window.webpackJsonp||[]).push([[33],{183:function(s,t,e){"use strict";e.r(t);e(27),e(24);var a=e(9),i=e.n(a),l={data:()=>({isLoading:!1,user:{}}),methods:{submitRequest(){let s=this;s.isLoading=!0,axios.post("/register",s.user).then(t=>{s.isLoading=!1,i.a.success(t.data)},t=>{s.isLoading=!1})}}},n=e(2),o=Object(n.a)(l,function(){var s=this,t=s.$createElement,e=s._self._c||t;return e("form",[e("div",{staticClass:"hero is-fullheight"},[e("div",{staticClass:"hero-body"},[e("div",{staticClass:"container"},[e("div",{staticClass:"columns is-centered"},[e("div",{staticClass:"column is-12-mobile is-6"},[s._m(0),s._v(" "),e("div",{staticClass:"field "},[e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:s.user.firstName,expression:"user.firstName"}],staticClass:"input",attrs:{type:"text",placeholder:"First name"},domProps:{value:s.user.firstName},on:{input:function(t){t.target.composing||s.$set(s.user,"firstName",t.target.value)}}}),s._v(" "),e("span",{staticClass:"icon is-small is-left"})])]),s._v(" "),e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:s.user.lastName,expression:"user.lastName"}],staticClass:"input",attrs:{type:"text",placeholder:"Last name"},domProps:{value:s.user.lastName},on:{input:function(t){t.target.composing||s.$set(s.user,"lastName",t.target.value)}}}),s._v(" "),e("span",{staticClass:"icon is-small is-left"})])]),s._v(" "),e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:s.user.email,expression:"user.email"}],staticClass:"input",attrs:{type:"email",placeholder:"Email"},domProps:{value:s.user.email},on:{input:function(t){t.target.composing||s.$set(s.user,"email",t.target.value)}}}),s._v(" "),e("span",{staticClass:"icon is-small is-left"})])]),s._v(" "),e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:s.user.phone,expression:"user.phone"}],staticClass:"input",attrs:{type:"phone",placeholder:"Phone"},domProps:{value:s.user.phone},on:{input:function(t){t.target.composing||s.$set(s.user,"phone",t.target.value)}}}),s._v(" "),e("span",{staticClass:"icon is-small is-left"})])]),s._v(" "),e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:s.user.password,expression:"user.password"}],staticClass:"input",attrs:{type:"password",placeholder:"Password"},domProps:{value:s.user.password},on:{input:function(t){t.target.composing||s.$set(s.user,"password",t.target.value)}}}),s._v(" "),e("span",{staticClass:"icon is-small is-left"})])]),s._v(" "),e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:s.user.confirmPassword,expression:"user.confirmPassword"}],staticClass:"input",attrs:{type:"password",placeholder:"Confirm password"},domProps:{value:s.user.confirmPassword},on:{input:function(t){t.target.composing||s.$set(s.user,"confirmPassword",t.target.value)}}}),s._v(" "),e("span",{staticClass:"icon is-small is-left"})])]),s._v(" "),e("div",{staticClass:"field"},[e("div",{staticClass:"control is-block"},[e("button",{staticClass:"button  is-fullwidth is-success",class:{"is-loading":s.isLoading},on:{click:function(t){return t.preventDefault(),s.submitRequest(t)}}},[s._v("\n                                    Sing up\n                                ")])])])])])])])])])},[function(){var s=this.$createElement,t=this._self._c||s;return t("div",{staticClass:"field "},[t("section",{staticClass:"section is-paddingless"},[t("div",{staticClass:"container"},[t("div",{staticClass:"columns"},[t("div",{staticClass:"column is-centered"},[t("h1",{staticClass:"title"},[this._v("Sing up")])])]),this._v(" "),t("h2",{staticClass:"subtitle"},[this._v("\n                                   It is free and only takes a few seconds\n                                ")])])])])}],!1,null,null,null);t.default=o.exports}}]);