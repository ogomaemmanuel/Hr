(window.webpackJsonp=window.webpackJsonp||[]).push([[24],{223:function(e,t,s){var a=s(227);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);(0,s(21).default)("3c92a25e",a,!1,{})},224:function(e,t,s){"use strict";var a=function(){var e=this,t=e._self._c;return t("div",{staticClass:"modal-wrapper"},[t("div",{ref:"modal",staticClass:"modal"},[t("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":e.width+"px",overflow:e.overflow}},[t("div",{staticClass:"box",class:e.hasPadding?"":"p-0"},[e._t("modal-content")],2)]),e._v(" "),e.showCloseButton?[t("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(t){return t.stopPropagation(),e.closeModal.apply(null,arguments)}}})]:e._e()],2)])};a._withStripped=!0;var o={mixins:[s(225).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0},hasPadding:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},i=(s(226),s(14)),l=Object(i.a)(o,a,[],!1,null,"f5b23902",null);t.a=l.exports},225:function(e,t,s){"use strict";(function(e){t.a={methods:{closeModal(){e(this.$refs.modalContent).toggleClass("scaleIn"),e(this.$refs.modalClose).toggleClass("is-hidden"),e(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){e(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(184))},226:function(e,t,s){"use strict";s(223)},227:function(e,t,s){(e.exports=s(20)(!1)).push([e.i,".modal[data-v-f5b23902]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,.86)}.modal .modal-content[data-v-f5b23902]{overflow:visible}",""])},233:function(e,t,s){"use strict";var a=function(){var e=this,t=e._self._c;return t("div",[t("b-field",[e.showLabel?t("template",{slot:"label"},[e._v("\n      "+e._s(e.label)+" "),e.required?t("span",[t("sup",[e._v("*")])]):e._e()]):e._e(),e._v(" "),t("b-autocomplete",{attrs:{data:e.employees,placeholder:e.placeholder,field:"fullName",loading:e.isFetching,"check-infinite-scroll":!0},on:{typing:e.getAsyncData,select:t=>e.selectedEmployee=t,"infinite-scroll":e.getMoreAsyncData},scopedSlots:e._u([{key:"default",fn:function(s){return[t("div",{staticClass:"media"},[t("div",{staticClass:"media-left"}),e._v(" "),t("div",{staticClass:"media-content"},[e._v("\n            "+e._s(s.option.fullName)+"\n            "),t("br"),e._v(" "),t("small")])])]}}])},[t("template",{slot:"header"},[t("a",{on:{click:e.showAddEmployee}},[t("span",{staticClass:"has-text-link"},[e._v(" Add new... ")])])]),e._v(" "),e._v(" "),t("template",{slot:"footer"},[t("span",{directives:[{name:"show",rawName:"v-show",value:e.page>e.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[e._v(" Thats it! No more movies found. ")])])],2),e._v(" "),t("div",{attrs:{slot:"message"},slot:"message"},[e._t("errors")],2)],2)],1)};a._withStripped=!0;var o=s(187),i=s.n(o),l={props:{label:{default:"Employee"},required:{default:!0},showLabel:{default:!0},placeholder:{default:"Select Employee"}},data:()=>({employees:[],loading:!1,isFetching:!1,employeeName:"",page:0,totalPages:0,selectedEmployee:{}}),methods:{showAddEmployee(){},fetchEmployees(e){axios.get("/api/employees",{params:{page:this.page,pageSize:10}}).then(({data:e})=>{e.content.forEach(e=>this.employees.push(e)),this.page++,this.totalPages=e.totalPages,this.isFetching=!1},e=>{this.isFetching=!1})},getAsyncData:i()((function(e){if(this.employeeName!==e&&(this.employeeName=e,this.employees=[],this.page=0,this.totalPages=0),!e.length)return this.employees=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchEmployees(e))}),500),getMoreAsyncData:i()((function(){this.getAsyncData(this.employeeName)}),250)},watch:{selectedEmployee:function(e){this.$emit("input",e.id)}}},r=s(14),n=Object(r.a)(l,a,[],!1,null,"30d6cd57",null);t.a=n.exports},299:function(e,t,s){var a=s(371);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);(0,s(21).default)("5bd4962c",a,!1,{})},370:function(e,t,s){"use strict";s(299)},371:function(e,t,s){(e.exports=s(20)(!1)).push([e.i,".datepicker[data-v-45f4a09d]{min-width:100%}",""])},456:function(e,t,s){"use strict";s.r(t);var a=function(){var e=this,t=e._self._c;return t("div",[t("div",{staticClass:"pb-2 flex justify-end"},[t("button",{staticClass:"button mr-1 is-rounded",attrs:{to:"/departments-create",tag:"button"},on:{click:function(t){e.showOvertimeRequestForm=!0}}},[e._m(0),e._v(" "),t("span",[e._v("\n\t\t\t\t\t Add Overtime\n\t\t\t\t")])]),e._v(" "),e._m(1)]),e._v(" "),e.showOvertimeRequestForm?t("OvertimeRequestCreateForm",{on:{modalClosed:function(t){e.showOvertimeRequestForm=!1}}}):e._e(),e._v(" "),t("router-view")],1)};a._withStripped=!0;var o=function(){var e=this,t=e._self._c;return t("ModalTemplate",{on:{modalClosed:function(t){return e.$emit("modalClosed")}}},[t("div",{attrs:{slot:"modal-content"},slot:"modal-content"},[t("form",[t("div",{staticClass:"has-text-centered m-3"},[t("h1",{staticClass:"has-text-black"},[t("b",[e._v("Add Overtime")])])]),e._v(" "),t("EmployeeSelectInput",{attrs:{required:!1,label:"Employee"},on:{input:function(t){return e.clearFieldError("employeeId")}},model:{value:e.overtimeRequest.employeeId,callback:function(t){e.$set(e.overtimeRequest,"employeeId",t)},expression:"overtimeRequest.employeeId"}}),e._v(" "),t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[e._v("Overtime Date"),t("span",[t("sup",[e._v("*")])])]),e._v(" "),t("div",{staticClass:"control"},[t("DatePicker",{staticClass:"datepicker",on:{input:function(t){return e.clearFieldError("overtimeDate")}},model:{value:e.overtimeRequest.overtimeDate,callback:function(t){e.$set(e.overtimeRequest,"overtimeDate",t)},expression:"overtimeRequest.overtimeDate"}}),e._v(" "),e.errors.overtimeDate?t("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.overtimeDate[0])+"\n\t\t\t\t\t")]):e._e()],1)]),e._v(" "),t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[e._v("Overtime Hours"),t("span",[t("sup",[e._v("*")])])]),e._v(" "),t("div",{staticClass:"control"},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.overtimeRequest.overtimeHours,expression:"overtimeRequest.overtimeHours"}],staticClass:"input",attrs:{type:"number"},domProps:{value:e.overtimeRequest.overtimeHours},on:{input:[function(t){t.target.composing||e.$set(e.overtimeRequest,"overtimeHours",t.target.value)},function(t){return e.clearFieldError("overtimeHours")}]}}),e._v(" "),e.errors.overtimeHours?t("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.overtimeHours[0])+"\n\t\t\t\t\t")]):e._e()])]),e._v(" "),t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[e._v("Description "),t("span",[t("sup",[e._v("*")])])]),e._v(" "),t("div",{staticClass:"control"},[t("textarea",{directives:[{name:"model",rawName:"v-model",value:e.overtimeRequest.description,expression:"overtimeRequest.description"}],staticClass:"textarea is-primary",attrs:{placeholder:"Primary textarea"},domProps:{value:e.overtimeRequest.description},on:{input:[function(t){t.target.composing||e.$set(e.overtimeRequest,"description",t.target.value)},function(t){return e.clearFieldError("description")}]}}),e._v(" "),e.errors.description?t("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.description[0])+"\n\t\t\t\t\t")]):e._e()])]),e._v(" "),t("div",{staticClass:"flex justify-center m-3"},[t("button",{staticClass:"button is-rounded",class:{"is-loading":e.loading},attrs:{type:"submit"},on:{click:function(t){return t.preventDefault(),t.stopPropagation(),e.createOvertimeRequest.apply(null,arguments)}}},[e._v("Submit\n                    ")])])],1)])])};o._withStripped=!0;s(185),s(81);var i=s(186),l=s.n(i),r=s(33),n=s(233),c=s(224),d={mixins:[r.a],components:{EmployeeSelectInput:n.a,ModalTemplate:c.a,DatePicker:l.a},data:()=>({departments:[],overtimeRequest:{employeeId:"",overtimeHours:"",description:"",overtimeDate:""},loading:!1}),computed:{disableSubmitButton(){return this.designation.name.length<=0}},methods:{showAddDepartment(){},createOvertimeRequest(){let e=this;axios.post("/api/overtime-requests",this.overtimeRequest).then(t=>{e.$swal({type:"success",title:"Success",text:"Overtime request successfully saved"}),this.$emit("overtimeRequestCreated")},e=>{400==e.response.status&&(this.errors=e.response.data)})}}},u=(s(370),s(14)),m={components:{OvertimeRequestCreateForm:Object(u.a)(d,o,[],!1,null,"45f4a09d",null).exports},data:()=>({showOvertimeRequestForm:!1}),methods:{getOvertimeRequests(){}}},p=Object(u.a)(m,a,[function(){var e=this._self._c;return e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-plus-circle mr-1"})])},function(){var e=this._self._c;return e("a",{staticClass:"button is-rounded",attrs:{href:"/api/overtime-requests/excel-reports"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-download mr-1"})]),this._v(" "),e("span",[this._v("\n\t\t\t\t\t Export\n\t\t\t\t")])])}],!1,null,null,null);t.default=p.exports}}]);