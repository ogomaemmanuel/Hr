(window.webpackJsonp=window.webpackJsonp||[]).push([[15],{199:function(e,t,a){var s=a(204);"string"==typeof s&&(s=[[e.i,s,""]]),s.locals&&(e.exports=s.locals);(0,a(23).default)("1f8d4a96",s,!0,{})},201:function(e,t,a){"use strict";var s={mixins:[a(202).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},o=(a(203),a(15)),i=Object(o.a)(s,(function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"modal-wrapper"},[a("div",{ref:"modal",staticClass:"modal"},[a("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":e.width+"px",overflow:e.overflow}},[a("div",{staticClass:"box"},[e._t("modal-content")],2)]),e._v(" "),e.showCloseButton?[a("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(t){return t.stopPropagation(),e.closeModal(t)}}})]:e._e()],2)])}),[],!1,null,"2fb1f790",null);t.a=i.exports},202:function(e,t,a){"use strict";(function(e){t.a={methods:{closeModal(){e(this.$refs.modalContent).toggleClass("scaleIn"),e(this.$refs.modalClose).toggleClass("is-hidden"),e(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){e(this.$refs.modal).toggleClass("is-active")}}}}).call(this,a(164))},203:function(e,t,a){"use strict";var s=a(199);a.n(s).a},204:function(e,t,a){(e.exports=a(22)(!1)).push([e.i,".modal[data-v-2fb1f790]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-2fb1f790]{overflow:visible}\n",""])},209:function(e,t,a){"use strict";var s=a(169),o=a.n(s),i={props:{label:{default:"Employee"},required:{default:!0},showLabel:{default:!0},placeholder:{default:"Select Employee"}},data:()=>({employees:[],loading:!1,isFetching:!1,employeeName:"",page:0,totalPages:0,selectedEmployee:{}}),methods:{showAddEmployee(){},fetchEmployees(e){axios.get("/api/employees",{params:{page:this.page,pageSize:10}}).then(({data:e})=>{e.content.forEach(e=>this.employees.push(e)),this.page++,this.totalPages=e.totalPages,this.isFetching=!1},e=>{this.isFetching=!1})},getAsyncData:o()((function(e){if(this.employeeName!==e&&(this.employeeName=e,this.employees=[],this.page=0,this.totalPages=0),!e.length)return this.employees=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchEmployees(e))}),500),getMoreAsyncData:o()((function(){this.getAsyncData(this.employeeName)}),250)},watch:{selectedEmployee:function(e){this.$emit("input",e.id)}}},n=a(15),l=Object(n.a)(i,(function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("b-field",[e.showLabel?a("template",{slot:"label"},[e._v("\n      "+e._s(e.label)+" "),e.required?a("span",[a("sup",[e._v("*")])]):e._e()]):e._e(),e._v(" "),a("b-autocomplete",{attrs:{data:e.employees,placeholder:e.placeholder,field:"fullName",loading:e.isFetching,"check-infinite-scroll":!0},on:{typing:e.getAsyncData,select:function(t){return e.selectedEmployee=t},"infinite-scroll":e.getMoreAsyncData},scopedSlots:e._u([{key:"default",fn:function(t){return[a("div",{staticClass:"media"},[a("div",{staticClass:"media-left"}),e._v(" "),a("div",{staticClass:"media-content"},[e._v("\n            "+e._s(t.option.fullName)+"\n            "),a("br"),e._v(" "),a("small")])])]}}])},[a("template",{slot:"header"},[a("a",{on:{click:e.showAddEmployee}},[a("span",{staticClass:"has-text-link"},[e._v(" Add new... ")])])]),e._v(" "),e._v(" "),a("template",{slot:"footer"},[a("span",{directives:[{name:"show",rawName:"v-show",value:e.page>e.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[e._v(" Thats it! No more movies found. ")])])],2),e._v(" "),a("div",{attrs:{slot:"message"},slot:"message"},[e._t("errors")],2)],2)],1)}),[],!1,null,"2b0b2b84",null);t.a=l.exports},231:function(e,t,a){var s=a(313);"string"==typeof s&&(s=[[e.i,s,""]]),s.locals&&(e.exports=s.locals);(0,a(23).default)("398f9f44",s,!0,{})},312:function(e,t,a){"use strict";var s=a(231);a.n(s).a},313:function(e,t,a){(e.exports=a(22)(!1)).push([e.i,".datepicker[data-v-2992ca2c]{min-width:100%}\n",""])},387:function(e,t,a){"use strict";a.r(t);a(167),a(75);var s=a(168),o=a.n(s),i=a(35),n=a(209),l=a(201),r={mixins:[i.a],components:{EmployeeSelectInput:n.a,ModalTemplate:l.a,DatePicker:o.a},data:()=>({employeeResignation:{},loading:!1}),methods:{saveResignation(){let e=this;axios.post("/api/employee-resignations",this.employeeResignation).then(t=>{e.$swal({type:"success",title:"Success",text:"Resignation successfully saved"}),this.$emit("resignationSaved")},e=>{400==e.response.status&&(this.errors=e.response.data)})}}},c=(a(312),a(15)),d={components:{ResignationCreateForm:Object(c.a)(r,(function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("ModalTemplate",{on:{modalClosed:function(t){return e.$emit("modalClosed")}}},[a("div",{attrs:{slot:"modal-content"},slot:"modal-content"},[a("form",[a("div",{staticClass:"has-text-centered m-3"},[a("h1",{staticClass:"has-text-black"},[a("b",[e._v("Add Resignation")])])]),e._v(" "),a("EmployeeSelectInput",{attrs:{required:!1,label:"Employee"},on:{input:function(t){return e.clearFieldError("employeeId")}},model:{value:e.employeeResignation.employeeId,callback:function(t){e.$set(e.employeeResignation,"employeeId",t)},expression:"employeeResignation.employeeId"}}),e._v(" "),a("div",{staticClass:"field"},[a("label",{staticClass:"label "},[e._v("Notice Date"),a("span",[a("sup",[e._v("*")])])]),e._v(" "),a("div",{staticClass:"control"},[a("DatePicker",{staticClass:"datepicker",on:{input:function(t){return e.clearFieldError("noticeDate")}},model:{value:e.employeeResignation.noticeDate,callback:function(t){e.$set(e.employeeResignation,"noticeDate",t)},expression:"employeeResignation.noticeDate"}}),e._v(" "),e.errors.noticeDate?a("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.noticeDate[0])+"\n\t\t\t\t\t")]):e._e()],1)]),e._v(" "),a("div",{staticClass:"field"},[a("label",{staticClass:"label "},[e._v("Resignation Date"),a("span",[a("sup",[e._v("*")])])]),e._v(" "),a("div",{staticClass:"control"},[a("DatePicker",{staticClass:"datepicker",on:{input:function(t){return e.clearFieldError("resignationDate")}},model:{value:e.employeeResignation.resignationDate,callback:function(t){e.$set(e.employeeResignation,"resignationDate",t)},expression:"employeeResignation.resignationDate"}}),e._v(" "),e.errors.resignationDate?a("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.resignationDate[0])+"\n\t\t\t\t\t")]):e._e()],1)]),e._v(" "),a("div",{staticClass:"field"},[a("label",{staticClass:"label "},[e._v("Reason "),a("span",[a("sup",[e._v("*")])])]),e._v(" "),a("div",{staticClass:"control"},[a("textarea",{directives:[{name:"model",rawName:"v-model",value:e.employeeResignation.reason,expression:"employeeResignation.reason"}],staticClass:"textarea is-primary",attrs:{placeholder:"Primary textarea"},domProps:{value:e.employeeResignation.reason},on:{input:[function(t){t.target.composing||e.$set(e.employeeResignation,"reason",t.target.value)},function(t){return e.clearFieldError("reason")}]}}),e._v(" "),e.errors.reason?a("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.reason[0])+"\n\t\t\t\t\t")]):e._e()])]),e._v(" "),a("div",{staticClass:"flex justify-center m-3"},[a("button",{staticClass:"button  is-rounded",class:{"is-loading":e.loading},attrs:{type:"submit"},on:{click:function(t){return t.preventDefault(),t.stopPropagation(),e.saveResignation(t)}}},[e._v("Submit\n                    ")])])],1)])])}),[],!1,null,"2992ca2c",null).exports},data:()=>({showResignationCreateForm:!1})},p=Object(c.a)(d,(function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{staticClass:"pb-2 flex justify-end"},[a("button",{staticClass:"button mr-1 is-rounded",attrs:{to:"/departments-create",tag:"button"},on:{click:function(t){e.showResignationCreateForm=!0}}},[e._m(0),e._v(" "),a("span",[e._v("\n\t\t\t\t\t Add Resignation\n\t\t\t\t")])]),e._v(" "),e._m(1)]),e._v(" "),e.showResignationCreateForm?a("ResignationCreateForm",{on:{resignationSaved:function(t){e.showResignationCreateForm=!1},modalClosed:function(t){e.showResignationCreateForm=!1}}}):e._e(),e._v(" "),a("router-view")],1)}),[function(){var e=this.$createElement,t=this._self._c||e;return t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-plus-circle mr-1"})])},function(){var e=this.$createElement,t=this._self._c||e;return t("a",{staticClass:"button is-rounded",attrs:{href:"/api/overtime-requests/excel-reports"}},[t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-download mr-1"})]),this._v(" "),t("span",[this._v("\n\t\t\t\t\t Export\n\t\t\t\t")])])}],!1,null,"6231aa5b",null);t.default=p.exports}}]);