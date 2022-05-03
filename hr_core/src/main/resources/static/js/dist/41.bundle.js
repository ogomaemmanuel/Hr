(window.webpackJsonp=window.webpackJsonp||[]).push([[41],{199:function(e,t,a){var s=a(204);"string"==typeof s&&(s=[[e.i,s,""]]),s.locals&&(e.exports=s.locals);(0,a(23).default)("1f8d4a96",s,!0,{})},201:function(e,t,a){"use strict";var s={mixins:[a(202).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},n=(a(203),a(15)),i=Object(n.a)(s,(function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"modal-wrapper"},[a("div",{ref:"modal",staticClass:"modal"},[a("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":e.width+"px",overflow:e.overflow}},[a("div",{staticClass:"box"},[e._t("modal-content")],2)]),e._v(" "),e.showCloseButton?[a("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(t){return t.stopPropagation(),e.closeModal(t)}}})]:e._e()],2)])}),[],!1,null,"2fb1f790",null);t.a=i.exports},202:function(e,t,a){"use strict";(function(e){t.a={methods:{closeModal(){e(this.$refs.modalContent).toggleClass("scaleIn"),e(this.$refs.modalClose).toggleClass("is-hidden"),e(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){e(this.$refs.modal).toggleClass("is-active")}}}}).call(this,a(164))},203:function(e,t,a){"use strict";var s=a(199);a.n(s).a},204:function(e,t,a){(e.exports=a(22)(!1)).push([e.i,".modal[data-v-2fb1f790]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-2fb1f790]{overflow:visible}\n",""])},209:function(e,t,a){"use strict";var s=a(169),n=a.n(s),i={props:{label:{default:"Employee"},required:{default:!0},showLabel:{default:!0},placeholder:{default:"Select Employee"}},data:()=>({employees:[],loading:!1,isFetching:!1,employeeName:"",page:0,totalPages:0,selectedEmployee:{}}),methods:{showAddEmployee(){},fetchEmployees(e){axios.get("/api/employees",{params:{page:this.page,pageSize:10}}).then(({data:e})=>{e.content.forEach(e=>this.employees.push(e)),this.page++,this.totalPages=e.totalPages,this.isFetching=!1},e=>{this.isFetching=!1})},getAsyncData:n()((function(e){if(this.employeeName!==e&&(this.employeeName=e,this.employees=[],this.page=0,this.totalPages=0),!e.length)return this.employees=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchEmployees(e))}),500),getMoreAsyncData:n()((function(){this.getAsyncData(this.employeeName)}),250)},watch:{selectedEmployee:function(e){this.$emit("input",e.id)}}},o=a(15),r=Object(o.a)(i,(function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("b-field",[e.showLabel?a("template",{slot:"label"},[e._v("\n      "+e._s(e.label)+" "),e.required?a("span",[a("sup",[e._v("*")])]):e._e()]):e._e(),e._v(" "),a("b-autocomplete",{attrs:{data:e.employees,placeholder:e.placeholder,field:"fullName",loading:e.isFetching,"check-infinite-scroll":!0},on:{typing:e.getAsyncData,select:function(t){return e.selectedEmployee=t},"infinite-scroll":e.getMoreAsyncData},scopedSlots:e._u([{key:"default",fn:function(t){return[a("div",{staticClass:"media"},[a("div",{staticClass:"media-left"}),e._v(" "),a("div",{staticClass:"media-content"},[e._v("\n            "+e._s(t.option.fullName)+"\n            "),a("br"),e._v(" "),a("small")])])]}}])},[a("template",{slot:"header"},[a("a",{on:{click:e.showAddEmployee}},[a("span",{staticClass:"has-text-link"},[e._v(" Add new... ")])])]),e._v(" "),e._v(" "),a("template",{slot:"footer"},[a("span",{directives:[{name:"show",rawName:"v-show",value:e.page>e.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[e._v(" Thats it! No more movies found. ")])])],2),e._v(" "),a("div",{attrs:{slot:"message"},slot:"message"},[e._t("errors")],2)],2)],1)}),[],!1,null,"2b0b2b84",null);t.a=r.exports},407:function(e,t,a){"use strict";a.r(t);var s=a(201),n=(a(165),a(75),a(166)),i=a.n(n),o=a(209),r={mixins:[a(35).a],components:{EmployeeSelectInput:o.a},props:{id:{required:!0}},data:()=>({providentFund:{},isLoading:!1,loaded:!1}),created(){this.getProvidentFundById()},methods:{updateProvidentFund(){axios.put("/api/provident-funds/"+this.id,this.providentFund).then(e=>{i.a.success("Provident fund successfully updated"),this.$emit("updateSuccessfull")},e=>{400==e.response.status&&(this.errors=e.response.data)})},getProvidentFundById(){axios.get("/api/provident-funds/"+this.id).then(e=>{this.providentFund=e.data,this.loaded=!0},e=>{this.loaded=!1})}},computed:{disableSubmitButton(){return this.isLoading}}},l=a(15),d=Object(l.a)(r,(function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("form",[e._m(0),e._v(" "),a("div",{staticClass:"columns"},[a("div",{staticClass:"column"},[a("EmployeeSelectInput",{attrs:{label:"Employee Name"},on:{input:function(t){return e.clearFieldError("employeeId")}},model:{value:e.providentFund.employeeId,callback:function(t){e.$set(e.providentFund,"employeeId",t)},expression:"providentFund.employeeId"}},[e.errors.employeeId?a("span",{staticClass:"mb-2 has-text-danger",attrs:{slot:"errors"},slot:"errors"},[e._v("\n                "+e._s(e.errors.employeeId[0])+"\n              ")]):e._e()])],1),e._v(" "),a("div",{staticClass:"column"},[a("div",{staticClass:"field"},[e._m(1),e._v(" "),a("div",{staticClass:"select is-fullwidth"},[a("select",{directives:[{name:"model",rawName:"v-model",value:e.providentFund.providentFundType,expression:"providentFund.providentFundType"}],on:{input:function(t){return e.clearFieldError("providentFundType")},change:function(t){var a=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){return"_value"in e?e._value:e.value}));e.$set(e.providentFund,"providentFundType",t.target.multiple?a:a[0])}}},[e._l(e.providentFund.providentFundTypesSelectList,(function(t){return a("option",{domProps:{value:Object.keys(t)}},[e._v(e._s(Object.values(t)))])})),e._v(" "),a("option",{attrs:{value:"fixedAmount"}},[e._v("Fixed Amount")])],2),e._v(" "),e.errors.providentFundType?a("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n                "+e._s(e.errors.providentFundType[0])+"\n              ")]):e._e()])])])]),e._v(" "),a("div",{staticClass:"columns"},[a("div",{staticClass:"column"},[a("div",{staticClass:"field"},[a("label",{staticClass:"label"},[e._v("Employee Share (Amount)")]),e._v(" "),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.providentFund.employeeShare,expression:"providentFund.employeeShare"}],staticClass:"input",domProps:{value:e.providentFund.employeeShare},on:{input:[function(t){t.target.composing||e.$set(e.providentFund,"employeeShare",t.target.value)},function(t){return e.clearFieldError("employeeShare")}]}}),e._v(" "),e.errors.employeeShare?a("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.employeeShare[0])+"\n\t\t\t\t\t")]):e._e()])])]),e._v(" "),a("div",{staticClass:"column"},[a("div",{staticClass:"field"},[a("label",{staticClass:"label"},[e._v("Organization Share (Amount)")]),e._v(" "),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.providentFund.organisationShare,expression:"providentFund.organisationShare"}],staticClass:"input",domProps:{value:e.providentFund.organisationShare},on:{input:[function(t){t.target.composing||e.$set(e.providentFund,"organisationShare",t.target.value)},function(t){return e.clearFieldError("organisationShare")}]}}),e._v(" "),e.errors.organisationShare?a("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.organisationShare[0])+"\n\t\t\t\t\t")]):e._e()])])])]),e._v(" "),a("div",{staticClass:"columns"},[a("div",{staticClass:"column"},[a("div",{staticClass:"field"},[a("label",{staticClass:"label"},[e._v("Employee Share (%)")]),e._v(" "),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.providentFund.percentageEmployeeShare,expression:"providentFund.percentageEmployeeShare"}],staticClass:"input",domProps:{value:e.providentFund.percentageEmployeeShare},on:{input:[function(t){t.target.composing||e.$set(e.providentFund,"percentageEmployeeShare",t.target.value)},function(t){return e.clearFieldError("percentageEmployeeShare")}]}}),e._v(" "),e.errors.percentageEmployeeShare?a("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.percentageEmployeeShare[0])+"\n\t\t\t\t\t")]):e._e()])])]),e._v(" "),a("div",{staticClass:"column"},[a("div",{staticClass:"field"},[a("label",{staticClass:"label"},[e._v("Organization Share (%)")]),e._v(" "),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.providentFund.percentageOrganisationShare,expression:"providentFund.percentageOrganisationShare"}],staticClass:"input",domProps:{value:e.providentFund.percentageOrganisationShare},on:{input:[function(t){t.target.composing||e.$set(e.providentFund,"percentageOrganisationShare",t.target.value)},function(t){return e.clearFieldError("percentageOrganisationShare")}]}}),e._v(" "),e.errors.percentageOrganisationShare?a("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.percentageOrganisationShare[0])+"\n\t\t\t\t\t")]):e._e()])])])]),e._v(" "),a("div",{staticClass:"columns"},[a("div",{staticClass:"column"},[a("div",{staticClass:"field"},[e._m(2),e._v(" "),a("textarea",{directives:[{name:"model",rawName:"v-model",value:e.providentFund.description,expression:"providentFund.description"}],staticClass:"textarea",domProps:{value:e.providentFund.description},on:{input:[function(t){t.target.composing||e.$set(e.providentFund,"description",t.target.value)},function(t){return e.clearFieldError("description")}]}}),e._v(" "),e.errors.description?a("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.description[0])+"\n\t\t\t\t\t")]):e._e()])])]),e._v(" "),a("div",{staticClass:"flex justify-center m-3"},[a("button",{ref:"createButton",staticClass:"button  is-rounded",class:{"is-loading":e.isLoading},attrs:{disabled:e.disableSubmitButton,type:"submit"},on:{click:function(t){return t.preventDefault(),t.stopPropagation(),e.updateProvidentFund()}}},[e._v("Submit\n        ")])])])])}),[function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"has-text-centered m-3"},[t("h1",{staticClass:"has-text-black"},[t("b",[this._v("Update Provident Fund")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("label",{staticClass:"label"},[this._v("Provident Fund Type"),t("span",[t("sup",[this._v("*")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("label",{staticClass:"label"},[this._v("Description"),t("span",[t("sup",[this._v("*")])])])}],!1,null,null,null).exports,c={components:{ModalTemplate:s.a,ProvidentFundEditForm:d},data:()=>({id:""}),created(){this.id=this.$route.params.id}},p=Object(l.a)(c,(function(){var e=this.$createElement,t=this._self._c||e;return t("ModalTemplate",{attrs:{width:"900"}},[t("ProvidentFundEditForm",{attrs:{slot:"modal-content",id:this.id},slot:"modal-content"})],1)}),[],!1,null,null,null);t.default=p.exports}}]);