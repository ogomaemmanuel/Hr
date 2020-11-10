(window.webpackJsonp=window.webpackJsonp||[]).push([[12],{193:function(e,t,s){var a=s(198);"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);(0,s(27).default)("6a4b444c",a,!0,{})},195:function(e,t,s){"use strict";var a={mixins:[s(196).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},o=(s(197),s(20)),i=Object(o.a)(a,(function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{ref:"modal",staticClass:"modal"},[s("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":e.width+"px",overflow:e.overflow}},[s("div",{staticClass:"box"},[e._t("modal-content")],2)]),e._v(" "),e.showCloseButton?[s("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(t){return t.stopPropagation(),e.closeModal(t)}}})]:e._e()],2)}),[],!1,null,"c09ee790",null);t.a=i.exports},196:function(e,t,s){"use strict";(function(e){t.a={methods:{closeModal(){e(this.$refs.modalContent).toggleClass("scaleIn"),e(this.$refs.modalClose).toggleClass("is-hidden"),e(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){e(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(163))},197:function(e,t,s){"use strict";var a=s(193);s.n(a).a},198:function(e,t,s){(e.exports=s(26)(!1)).push([e.i,".modal[data-v-c09ee790]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-c09ee790]{overflow:visible}\n",""])},203:function(e,t,s){"use strict";var a=s(167),o=s.n(a),i={props:{label:{default:"Employee"},required:{default:!0}},data:()=>({employees:[],loading:!1,isFetching:!1,employeeName:"",page:0,totalPages:0,selectedEmployee:{}}),methods:{showAddEmployee(){},fetchEmployees(e){axios.get("/api/employees",{params:{page:this.page,pageSize:10}}).then(({data:e})=>{e.content.forEach(e=>this.employees.push(e)),this.page++,this.totalPages=e.totalPages,this.isFetching=!1},e=>{this.isFetching=!1})},getAsyncData:o()((function(e){if(this.employeeName!==e&&(this.employeeName=e,this.employees=[],this.page=0,this.totalPages=0),!e.length)return this.employees=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchEmployees(e))}),500),getMoreAsyncData:o()((function(){this.getAsyncData(this.employeeName)}),250)},watch:{selectedEmployee:function(e){this.$emit("input",e.id)}}},r=s(20),l=Object(r.a)(i,(function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",[s("b-field",[s("template",{slot:"label"},[e._v("\n            "+e._s(e.label)+" "),e.required?s("span",[s("sup",[e._v("*")])]):e._e()]),e._v(" "),s("b-autocomplete",{attrs:{data:e.employees,placeholder:"Select Employee",field:"fullName",loading:e.isFetching,"check-infinite-scroll":!0},on:{typing:e.getAsyncData,select:function(t){return e.selectedEmployee=t},"infinite-scroll":e.getMoreAsyncData},scopedSlots:e._u([{key:"default",fn:function(t){return[s("div",{staticClass:"media"},[s("div",{staticClass:"media-left"}),e._v(" "),s("div",{staticClass:"media-content"},[e._v("\n                        "+e._s(t.option.fullName)+"\n                        "),s("br"),e._v(" "),s("small")])])]}}])},[s("template",{slot:"header"},[s("a",{on:{click:e.showAddEmployee}},[s("span",{staticClass:"has-text-link"},[e._v(" Add new... ")])])]),e._v(" "),e._v(" "),s("template",{slot:"footer"},[s("span",{directives:[{name:"show",rawName:"v-show",value:e.page>e.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[e._v(" Thats it! No more movies found. ")])])],2),e._v(" "),s("div",{attrs:{slot:"message"},slot:"message"},[e._t("errors")],2)],2)],1)}),[],!1,null,"b22729ac",null);t.a=l.exports},224:function(e,t,s){var a=s(276);"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);(0,s(27).default)("56fbd1e2",a,!0,{})},275:function(e,t,s){"use strict";var a=s(224);s.n(a).a},276:function(e,t,s){(e.exports=s(26)(!1)).push([e.i,".datepicker[data-v-1f3317a9]{min-width:100%}\n",""])},311:function(e,t,s){"use strict";s.r(t);s(164),s(70);var a=s(165),o=s.n(a),i=s(37),r=s(203),l=s(195),n={mixins:[i.a],components:{EmployeeSelectInput:r.a,ModalTemplate:l.a,DatePicker:o.a},data:()=>({departments:[],overtimeRequest:{employeeId:"",overtimeHours:"",description:"",overtimeDate:""},loading:!1}),computed:{disableSubmitButton(){return this.designation.name.length<=0}},methods:{showAddDepartment(){},createOvertimeRequest(){let e=this;axios.post("/api/overtime-requests",this.overtimeRequest).then(t=>{e.$swal({type:"success",title:"Success",text:"Overtime request successfully saved"}),this.$emit("overtimeRequestCreated")},e=>{400==e.response.status&&(this.errors=e.response.data)})}}},c=(s(275),s(20)),m={components:{OvertimeRequestCreateForm:Object(c.a)(n,(function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("ModalTemplate",{on:{modalClosed:function(t){return e.$emit("modalClosed")}}},[s("div",{attrs:{slot:"modal-content"},slot:"modal-content"},[s("form",[s("div",{staticClass:"has-text-centered m-3"},[s("h1",{staticClass:"has-text-black"},[s("b",[e._v("Add Overtime")])])]),e._v(" "),s("EmployeeSelectInput",{attrs:{required:!1,label:"Employee"},on:{input:function(t){return e.clearFieldError("employeeId")}},model:{value:e.overtimeRequest.employeeId,callback:function(t){e.$set(e.overtimeRequest,"employeeId",t)},expression:"overtimeRequest.employeeId"}}),e._v(" "),s("div",{staticClass:"field"},[s("label",{staticClass:"label "},[e._v("Overtime Date"),s("span",[s("sup",[e._v("*")])])]),e._v(" "),s("div",{staticClass:"control"},[s("DatePicker",{staticClass:"datepicker",on:{input:function(t){return e.clearFieldError("overtimeDate")}},model:{value:e.overtimeRequest.overtimeDate,callback:function(t){e.$set(e.overtimeRequest,"overtimeDate",t)},expression:"overtimeRequest.overtimeDate"}}),e._v(" "),e.errors.overtimeDate?s("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.overtimeDate[0])+"\n\t\t\t\t\t")]):e._e()],1)]),e._v(" "),s("div",{staticClass:"field"},[s("label",{staticClass:"label "},[e._v("Overtime Hours"),s("span",[s("sup",[e._v("*")])])]),e._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:e.overtimeRequest.overtimeHours,expression:"overtimeRequest.overtimeHours"}],staticClass:"input",attrs:{type:"number"},domProps:{value:e.overtimeRequest.overtimeHours},on:{input:[function(t){t.target.composing||e.$set(e.overtimeRequest,"overtimeHours",t.target.value)},function(t){return e.clearFieldError("overtimeHours")}]}}),e._v(" "),e.errors.overtimeHours?s("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.overtimeHours[0])+"\n\t\t\t\t\t")]):e._e()])]),e._v(" "),s("div",{staticClass:"field"},[s("label",{staticClass:"label "},[e._v("Description "),s("span",[s("sup",[e._v("*")])])]),e._v(" "),s("div",{staticClass:"control"},[s("textarea",{directives:[{name:"model",rawName:"v-model",value:e.overtimeRequest.description,expression:"overtimeRequest.description"}],staticClass:"textarea is-primary",attrs:{placeholder:"Primary textarea"},domProps:{value:e.overtimeRequest.description},on:{input:[function(t){t.target.composing||e.$set(e.overtimeRequest,"description",t.target.value)},function(t){return e.clearFieldError("description")}]}}),e._v(" "),e.errors.description?s("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.description[0])+"\n\t\t\t\t\t")]):e._e()])]),e._v(" "),s("div",{staticClass:"flex justify-center m-3"},[s("button",{staticClass:"button  is-rounded",class:{"is-loading":e.loading},attrs:{type:"submit"},on:{click:function(t){return t.preventDefault(),t.stopPropagation(),e.createOvertimeRequest(t)}}},[e._v("Submit\n                    ")])])],1)])])}),[],!1,null,"1f3317a9",null).exports},data:()=>({showOvertimeRequestForm:!1}),methods:{getOvertimeRequests(){}}},u=Object(c.a)(m,(function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",[s("div",{staticClass:"pb-2 flex justify-end"},[s("button",{staticClass:"button mr-1 is-rounded",attrs:{to:"/departments-create",tag:"button"},on:{click:function(t){e.showOvertimeRequestForm=!0}}},[e._m(0),e._v(" "),s("span",[e._v("\n\t\t\t\t\t Add Overtime\n\t\t\t\t")])]),e._v(" "),e._m(1)]),e._v(" "),e.showOvertimeRequestForm?s("OvertimeRequestCreateForm",{on:{modalClosed:function(t){e.showOvertimeRequestForm=!1}}}):e._e(),e._v(" "),s("router-view")],1)}),[function(){var e=this.$createElement,t=this._self._c||e;return t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-plus-circle mr-1"})])},function(){var e=this.$createElement,t=this._self._c||e;return t("a",{staticClass:"button is-rounded",attrs:{href:"/api/overtime-requests/excel-reports"}},[t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-download mr-1"})]),this._v(" "),t("span",[this._v("\n\t\t\t\t\t Export\n\t\t\t\t")])])}],!1,null,null,null);t.default=u.exports}}]);