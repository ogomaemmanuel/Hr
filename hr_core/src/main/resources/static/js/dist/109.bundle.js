(window.webpackJsonp=window.webpackJsonp||[]).push([[109],{649:function(s,a,e){"use strict";e.r(a);var t=function(){var s=this,a=s._self._c;return a("Layout",{attrs:{padding:"1.5rem 4.5rem 4.5rem 4.5rem"},scopedSlots:s._u([{key:"auth-form",fn:function(){return[a("h1",{staticClass:"title has-text-dark has-text-centered"},[s._v("Let's Get You Signed Up.")]),s._v(" "),a("p",{staticClass:"mb-2 has-text-left"},[s._v(" It is free and only takes a few seconds ")]),s._v(" "),a("form",{staticClass:"box"},[a("div",{staticClass:"field"},[a("label",{staticClass:"label"},[s._v("Name")]),s._v(" "),a("div",{staticClass:"control has-icons-left"},[a("input",{directives:[{name:"model",rawName:"v-model",value:s.user.name,expression:"user.name"}],staticClass:"input has-text-left",attrs:{placeholder:"Name",required:"",type:"text"},domProps:{value:s.user.name},on:{input:function(a){a.target.composing||s.$set(s.user,"name",a.target.value)}}}),s._v(" "),a("span",{staticClass:"icon is-small is-left"},[a("i",{staticClass:"fa fa-user"})]),s._v(" "),s.errors.firstName||s.errors.lastName?a("span",{staticClass:"has-text-danger"},[s._v("\n            "+s._s(s.errors.firstName[0])+" "+s._s(s.errors.lastName[0])+"\n          ")]):s._e()])]),s._v(" "),a("div",{staticClass:"field"},[a("label",{staticClass:"label"},[s._v("Email")]),s._v(" "),a("div",{staticClass:"control has-icons-left"},[a("input",{directives:[{name:"model",rawName:"v-model",value:s.user.email,expression:"user.email"}],staticClass:"input has-text-left",attrs:{placeholder:"e.g. didinkaj@lambo-hr.com",required:"",type:"email"},domProps:{value:s.user.email},on:{input:function(a){a.target.composing||s.$set(s.user,"email",a.target.value)}}}),s._v(" "),a("span",{staticClass:"icon is-small is-left"},[a("i",{staticClass:"fa fa-envelope"})]),s._v(" "),s.errors.email?a("span",{staticClass:"has-text-danger"},[s._v("\n            "+s._s(s.errors.email[0])+"\n          ")]):s._e()])]),s._v(" "),a("div",{staticClass:"field"},[a("label",{staticClass:"label"},[s._v("Password")]),s._v(" "),a("div",{staticClass:"control has-icons-left"},[a("input",{directives:[{name:"model",rawName:"v-model",value:s.user.password,expression:"user.password"}],staticClass:"input",attrs:{placeholder:"********",required:"",type:"password"},domProps:{value:s.user.password},on:{input:function(a){a.target.composing||s.$set(s.user,"password",a.target.value)}}}),s._v(" "),a("span",{staticClass:"icon is-small is-left"},[a("i",{staticClass:"fa fa-lock"})]),s._v(" "),s.errors.password?a("span",{staticClass:"has-text-danger"},[s._v("\n            "+s._s(s.errors.password[0])+"\n          ")]):s._e()])]),s._v(" "),a("div",{staticClass:"field"},[a("label",{staticClass:"label"},[s._v("Confirm Password")]),s._v(" "),a("div",{staticClass:"control has-icons-left"},[a("input",{directives:[{name:"model",rawName:"v-model",value:s.user.confirmPassword,expression:"user.confirmPassword"}],staticClass:"input",attrs:{placeholder:"********",required:"",type:"password"},domProps:{value:s.user.confirmPassword},on:{input:function(a){a.target.composing||s.$set(s.user,"confirmPassword",a.target.value)}}}),s._v(" "),a("span",{staticClass:"icon is-small is-left"},[a("i",{staticClass:"fa fa-lock"})]),s._v(" "),s.errors.confirmPassword?a("span",{staticClass:"has-text-danger"},[s._v("\n            "+s._s(s.errors.confirmPassword[0])+"\n          ")]):s._e()])]),s._v(" "),a("div",{staticClass:"field"},[a("div",{staticClass:"control is-block"},[a("button",{staticClass:"button is-fullwidth is-success",class:{"is-loading":s.isLoading},on:{click:function(a){return a.preventDefault(),s.submitRequest.apply(null,arguments)}}},[s._v("\n            Register\n          ")]),s._v(" "),s.errors.msg?a("span",{staticClass:"has-text-danger"},[s._v("\n            "+s._s(s.errors.msg)+"\n          ")]):s._e()])]),s._v(" "),a("div",{staticClass:"columns"},[a("div",{staticClass:"column"}),s._v(" "),a("div",{staticClass:"column"})])])]},proxy:!0}])})};t._withStripped=!0;e(84),e(83);var i=e(24),r=e.n(i),l=e(375),o=e(34),n={components:{Layout:l.a},mixins:[o.a],data:()=>({isLoading:!1,user:{phone:+new Date}}),methods:{submitRequest(){let s=this,a=s.user.name.split(" ");s.user.firstName=a[0],s.user.lastName=a[a.length-1],s.isLoading=!0,axios.post("/register",s.user).then(a=>{s.isLoading=!1,r.a.success(a.data)},a=>{s.isLoading=!1,400===a.response.status&&(s.errors=a.response.data)})}}},c=e(15),d=Object(c.a)(n,t,[],!1,null,null,null);a.default=d.exports}}]);