(window.webpackJsonp=window.webpackJsonp||[]).push([[108],{645:function(s,t,a){"use strict";a.r(t);var e=function(){var s=this,t=s._self._c;return t("Layout",{scopedSlots:s._u([{key:"auth-form",fn:function(){return[t("h1",{staticClass:"title has-text-dark has-text-centered"},[s._v("Welcome Back.")]),s._v(" "),t("p",{staticClass:"mb-8 has-text-left"},[s._v(" Login with social media or your credentials ")]),s._v(" "),t("form",{staticClass:"box"},[t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[s._v("Email")]),s._v(" "),t("div",{staticClass:"control has-icons-left"},[t("input",{directives:[{name:"model",rawName:"v-model",value:s.user.email,expression:"user.email"}],staticClass:"input has-text-left",attrs:{placeholder:"e.g. didinkaj@lambo-hr.com",required:"",type:"email"},domProps:{value:s.user.email},on:{input:function(t){t.target.composing||s.$set(s.user,"email",t.target.value)}}}),s._v(" "),t("span",{staticClass:"icon is-small is-left"},[t("i",{staticClass:"fa fa-envelope"})]),s._v(" "),s.errors.email?t("span",{staticClass:"has-text-danger"},[s._v("\n            "+s._s(s.errors.email[0])+"\n          ")]):s._e()])]),s._v(" "),t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[s._v("Password")]),s._v(" "),t("div",{staticClass:"control has-icons-left"},[t("input",{directives:[{name:"model",rawName:"v-model",value:s.user.password,expression:"user.password"}],staticClass:"input",attrs:{placeholder:"********",required:"",type:"password"},domProps:{value:s.user.password},on:{input:function(t){t.target.composing||s.$set(s.user,"password",t.target.value)}}}),s._v(" "),t("span",{staticClass:"icon is-small is-left"},[t("i",{staticClass:"fa fa-lock"})]),s._v(" "),s.errors.password?t("span",{staticClass:"has-text-danger"},[s._v("\n            "+s._s(s.errors.password[0])+"\n          ")]):s._e()])]),s._v(" "),t("div",{staticClass:"field"},[t("label",{staticClass:"checkbox"},[t("input",{attrs:{type:"checkbox"}}),s._v("\n          Remember me\n        ")])]),s._v(" "),t("div",{staticClass:"field"},[t("button",{staticClass:"button is-fullwidth is-success",on:{click:function(t){return t.preventDefault(),s.login.apply(null,arguments)}}},[s._v("\n          Login\n        ")]),s._v(" "),s.errors.msg?t("span",{staticClass:"has-text-danger"},[s._v("\n          "+s._s(s.errors.msg)+"\n        ")]):s._e()]),s._v(" "),t("div",{staticClass:"columns"},[t("div",{staticClass:"column"},[t("div",{staticClass:"field has-text-right"},[t("router-link",{staticClass:"button is-text has-text-right",attrs:{button:"",tag:"button",to:"forgot-password"},on:{click:function(s){s.preventDefault()}}},[s._v("\n              Forgot password?\n            ")]),s._v(" "),t("router-link",{staticClass:"button is-text has-text-right",attrs:{button:"",tag:"button",to:"register"},on:{click:function(s){s.preventDefault()}}},[s._v("\n              Or Sign Up\n            ")])],1)])])])]},proxy:!0}])})};e._withStripped=!0;a(84),a(83);var i=a(24),o=a.n(i),l=a(34),r=a(419),n=a(476),c={components:{Layout:a(375).a,LogoMini:n.a,Logo:r.default},mixins:[l.a],data:()=>({user:{}}),methods:{login(){let s=this,t=this.createFormData(this.user);axios.post("/login",t).then(s=>{o.a.success(s.data),window.location.replace("/")},t=>{400===t.response.status&&(s.errors=t.response.data),console.log(t.response.status)})}}},u=a(15),d=Object(u.a)(c,e,[],!1,null,null,null);t.default=d.exports}}]);