(window.webpackJsonp=window.webpackJsonp||[]).push([[10],{122:function(t,s,a){"use strict";a.r(s);var e={mixins:[a(12).a],data:()=>({user:{}}),methods:{login(){let t=this.createFormData(this.user);axios.post("/login",t).then(t=>{window.location.replace("/")},t=>{console.log(t.response.status)})}}},i=a(2),l=Object(i.a)(e,function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"hero is-primary is-fullheight"},[a("div",{staticClass:"hero-head"},[a("nav",{staticClass:"navbar"},[a("div",{staticClass:"container"},[t._m(0),t._v(" "),a("div",{staticClass:"navbar-menu",attrs:{id:"navbarMenuHeroA"}},[a("div",{staticClass:"navbar-end"},[a("span",{staticClass:"navbar-item"},[a("router-link",{staticClass:"button is-primary is-inverted",attrs:{to:"register",button:""},on:{click:function(t){t.preventDefault()}}},[t._v("\n                                            Sign up\n                                        ")])],1)])])])])]),t._v(" "),a("div",{staticClass:"hero-body"},[a("div",{staticClass:"container"},[a("div",{staticClass:"columns is-centered "},[a("div",{staticClass:"column is-5-tablet is-4-desktop is-3-widescreen"},[a("form",{staticClass:"box"},[a("div",{staticClass:"field"},[a("label",{staticClass:"label"},[t._v("Email")]),t._v(" "),a("div",{staticClass:"control has-icons-left"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.user.email,expression:"user.email"}],staticClass:"input",attrs:{type:"email",placeholder:"e.g. alex@smith.com",required:""},domProps:{value:t.user.email},on:{input:function(s){s.target.composing||t.$set(t.user,"email",s.target.value)}}}),t._v(" "),t._m(1)])]),t._v(" "),a("div",{staticClass:"field"},[a("label",{staticClass:"label"},[t._v("Password")]),t._v(" "),a("div",{staticClass:"control has-icons-left"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.user.password,expression:"user.password"}],staticClass:"input",attrs:{type:"password",placeholder:"********",required:""},domProps:{value:t.user.password},on:{input:function(s){s.target.composing||t.$set(t.user,"password",s.target.value)}}}),t._v(" "),t._m(2)])]),t._v(" "),t._m(3),t._v(" "),a("div",{staticClass:"field"},[a("button",{staticClass:"button is-fullwidth is-success",on:{click:function(s){return s.preventDefault(),t.login(s)}}},[t._v("\n\t\t\t\t\t\t\t\t\tLogin\n\t\t\t\t\t\t\t\t")])]),t._v(" "),a("div",{staticClass:"columns"},[a("div",{staticClass:"column"}),t._v(" "),a("div",{staticClass:"column"},[a("div",{staticClass:"field"},[a("router-link",{staticClass:"button is-text",attrs:{tag:"button",to:"forgot-password",button:""},on:{click:function(t){t.preventDefault()}}},[t._v("\n\t\t\t\t\t\t\t\t\t\t\tForgot password\n\t\t\t\t\t\t\t\t\t\t")])],1)])])])])])])])])},[function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"navbar-brand"},[s("a",{staticClass:"navbar-item"},[s("img",{attrs:{src:"https://bulma.io/images/bulma-type-white.png",alt:"Logo"}})]),this._v(" "),s("span",{staticClass:"navbar-burger burger",attrs:{"data-target":"navbarMenuHeroA"}},[s("span"),this._v(" "),s("span"),this._v(" "),s("span")])])},function(){var t=this.$createElement,s=this._self._c||t;return s("span",{staticClass:"icon is-small is-left"},[s("i",{staticClass:"fa fa-envelope"})])},function(){var t=this.$createElement,s=this._self._c||t;return s("span",{staticClass:"icon is-small is-left"},[s("i",{staticClass:"fa fa-lock"})])},function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"field"},[s("label",{staticClass:"checkbox"},[s("input",{attrs:{type:"checkbox"}}),this._v("\n\t\t\t\t\t\t\t\t\tRemember me\n\t\t\t\t\t\t\t\t")])])}],!1,null,null,null);s.default=l.exports}}]);