(window.webpackJsonp=window.webpackJsonp||[]).push([[114],{447:function(t,s,e){"use strict";e.r(s);e(165),e(75);var a=e(166),i=e.n(a),n=e(172),r=e.n(n),l=(e(173),e(174)),o=e.n(l),c=(e(175),e(176)),p=e.n(c),m=(e(167),e(168)),u=e.n(m),v=e(35);function d(t,s){var e=Object.keys(t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(t);s&&(a=a.filter((function(s){return Object.getOwnPropertyDescriptor(t,s).enumerable}))),e.push.apply(e,a)}return e}function b(t){for(var s=1;s<arguments.length;s++){var e=null!=arguments[s]?arguments[s]:{};s%2?d(Object(e),!0).forEach((function(s){r()(t,s,e[s])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(e)):d(Object(e)).forEach((function(s){Object.defineProperty(t,s,Object.getOwnPropertyDescriptor(e,s))}))}return t}var _={name:"CompanyDetailsForm",components:{DatePicker:u.a,Select:p.a,Option:o.a},mixins:[v.a],data:()=>({companyDetails:{id:"",name:"",websiteUrl:"",registrationNo:"",dateEstablished:"",businessDescription:"",businessEntityType:"",stateOfIncorporation:"",email:""},isLoading:!1}),created(){this.getDetails()},computed:{disableSubmitButton(){let t=this.companyDetails;return t.name.length<=0||t.websiteUrl.length<=0||t.registrationNo.length<=0||t.dateEstablished.toString().length<=0||t.businessDescription.length<=0||t.businessEntityType.length<=0||t.stateOfIncorporation.length<=0||t.email.length<=0||this.isLoading}},methods:{getDetails(){let t=this;axios.get("/api/settings/company").then(s=>{t.companyDetails=b(b({},t.companyDetails),s.data)})},submit(){let t=this;t.isLoading=!0,axios.post("/api/settings/company/update",t.companyDetails).then(s=>{t.isLoading=!1,"00"===s.data.status?i.a.success(s.data.msg):i.a.error(s.data.msg),t.getDetails()},s=>{400===s.response.status?(t.isLoading=!1,this.errors=s.response.data):(t.isLoading=!1,i.a.error("Something went wrong. Contact Admin"))})}}},y=e(15),f=Object(y.a)(_,(function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"card animated preFadeInUp fadeInUp"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(0),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.companyDetails.name,expression:"companyDetails.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.companyDetails.name},on:{input:[function(s){s.target.composing||t.$set(t.companyDetails,"name",s.target.value)},function(s){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t        "+t._s(t.errors.name[0])+"\n\t\t\t\t\t        ")]):t._e()])])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(1),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.companyDetails.registrationNo,expression:"companyDetails.registrationNo"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.companyDetails.registrationNo},on:{input:[function(s){s.target.composing||t.$set(t.companyDetails,"registrationNo",s.target.value)},function(s){return t.clearFieldError("registrationNo")}]}}),t._v(" "),t.errors.registrationNo?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n                    "+t._s(t.errors.registrationNo[0])+"\n                  ")]):t._e()])])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(2),t._v(" "),e("div",{staticClass:"control"},[e("Select",{staticClass:"form-control is-large w-full",attrs:{required:"",placeholder:"Select State"},model:{value:t.companyDetails.stateOfIncorporation,callback:function(s){t.$set(t.companyDetails,"stateOfIncorporation",s)},expression:"companyDetails.stateOfIncorporation"}},[e("Option",{staticClass:"form-control",attrs:{value:"SP",label:"Sole Proprietorship"}}),t._v(" "),e("Option",{staticClass:"form-control",attrs:{value:"P",label:"Partnership"}}),t._v(" "),e("Option",{staticClass:"form-control",attrs:{value:"PLC",label:"Private Liability Company"}}),t._v(" "),e("Option",{staticClass:"form-control",attrs:{value:"LLC",label:"Limited Liability Company"}})],1),t._v(" "),t.errors.stateOfIncorporation?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.stateOfIncorporation[0])+"\n\t\t\t\t\t")]):t._e()],1)])])]),t._v(" "),e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(3),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.companyDetails.email,expression:"companyDetails.email"}],staticClass:"input",attrs:{type:"email"},domProps:{value:t.companyDetails.email},on:{input:[function(s){s.target.composing||t.$set(t.companyDetails,"email",s.target.value)},function(s){return t.clearFieldError("email")}]}}),t._v(" "),t.errors.email?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.email[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(4),t._v(" "),e("div",{staticClass:"control"},[e("DatePicker",{staticClass:"datepicker",on:{input:function(s){return t.clearFieldError("dateEstablished")}},model:{value:t.companyDetails.dateEstablished,callback:function(s){t.$set(t.companyDetails,"dateEstablished",s)},expression:"companyDetails.dateEstablished"}}),t._v(" "),t.errors.dateEstablished?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.dateEstablished[0])+"\n\t\t\t\t\t")]):t._e()],1)])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(5),t._v(" "),e("div",{staticClass:"control"},[e("Select",{staticClass:"form-control is-large w-full",attrs:{required:"",placeholder:"Select Type"},model:{value:t.companyDetails.businessEntityType,callback:function(s){t.$set(t.companyDetails,"businessEntityType",s)},expression:"companyDetails.businessEntityType"}},[e("Option",{staticClass:"form-control",attrs:{value:"1",label:"Entity 1"}}),t._v(" "),e("Option",{staticClass:"form-control",attrs:{value:"2",label:"Entity 2"}}),t._v(" "),e("Option",{staticClass:"form-control",attrs:{value:"3",label:"Entity 3"}}),t._v(" "),e("Option",{staticClass:"form-control",attrs:{value:"4",label:"Entity 4"}}),t._v(" "),e("Option",{staticClass:"form-control",attrs:{value:"5",label:"Entity 5"}})],1),t._v(" "),t.errors.businessEntityType?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.businessEntityType[0])+"\n\t\t\t\t\t")]):t._e()],1)])])]),t._v(" "),e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(6),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.companyDetails.websiteUrl,expression:"companyDetails.websiteUrl"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.companyDetails.websiteUrl},on:{input:[function(s){s.target.composing||t.$set(t.companyDetails,"websiteUrl",s.target.value)},function(s){return t.clearFieldError("websiteUrl")}]}}),t._v(" "),t.errors.websiteUrl?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.websiteUrl[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(7),t._v(" "),e("div",{staticClass:"control"},[e("textarea",{directives:[{name:"model",rawName:"v-model",value:t.companyDetails.businessDescription,expression:"companyDetails.businessDescription"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.companyDetails.businessDescription},on:{input:[function(s){s.target.composing||t.$set(t.companyDetails,"businessDescription",s.target.value)},function(s){return t.clearFieldError("businessDescription")}]}}),t._v(" "),t.errors.businessDescription?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.businessDescription[0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),e("div",{staticClass:"flex justify-end"},[e("button",{staticClass:"button is-rounded p-2",class:{"is-loading":t.isLoading},attrs:{disabled:t.disableSubmitButton},on:{click:function(s){return s.preventDefault(),t.submit(s)}}},[t._v("\n          Submit\n        ")])])])])}),[function(){var t=this.$createElement,s=this._self._c||t;return s("label",{staticClass:"label "},[this._v("Company Name "),s("span",[s("sup",[this._v("*")])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("label",{staticClass:"label "},[this._v("Registration No"),s("span",[s("sup",[this._v("*")])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("label",{staticClass:"label "},[this._v("State Of Incorporation"),s("span",[s("sup",[this._v("*")])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("label",{staticClass:"label "},[this._v("Company Email"),s("span",[s("sup",[this._v("*")])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("label",{staticClass:"label "},[this._v("Date Established"),s("span",[s("sup",[this._v("*")])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("label",{staticClass:"label "},[s("span",[this._v("Business Entity Type"),s("sup",[this._v("*")])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("label",{staticClass:"label "},[this._v("Website URL"),s("span",[s("sup",[this._v("*")])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("label",{staticClass:"label "},[this._v("Business Description"),s("span",[s("sup",[this._v("*")])])])}],!1,null,"1747c696",null);s.default=f.exports}}]);