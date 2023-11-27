(window.webpackJsonp=window.webpackJsonp||[]).push([[61],{360:function(e,t,a){var s=a(364);s.__esModule&&(s=s.default),"string"==typeof s&&(s=[[e.i,s,""]]),s.locals&&(e.exports=s.locals);(0,a(22).default)("42292892",s,!1,{})},361:function(e,t,a){"use strict";var s=function(){var e=this,t=e._self._c;return t("div",{staticClass:"modal-wrapper"},[t("div",{ref:"modal",staticClass:"modal"},[t("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":e.width+"px",overflow:e.overflow}},[t("div",{staticClass:"box",class:e.hasPadding?"":"p-0"},[e.showCloseButton?[t("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(t){return t.stopPropagation(),e.closeModal.apply(null,arguments)}}})]:e._e(),e._v(" "),e._t("modal-content")],2)])])])};s._withStripped=!0;var i={mixins:[a(362).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0},hasPadding:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},o=(a(363),a(15)),n=Object(o.a)(i,s,[],!1,null,"5fe0ec67",null);t.a=n.exports},362:function(e,t,a){"use strict";(function(e){t.a={methods:{closeModal(){e(this.$refs.modalContent).toggleClass("scaleIn"),e(this.$refs.modalClose).toggleClass("is-hidden"),e(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){e(this.$refs.modal).toggleClass("is-active")}}}}).call(this,a(187))},363:function(e,t,a){"use strict";a(360)},364:function(e,t,a){(e.exports=a(21)(!1)).push([e.i,".modal[data-v-5fe0ec67]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,.86)}.modal .modal-content[data-v-5fe0ec67]{overflow:visible}",""])},370:function(e,t,a){"use strict";var s=function(){var e=this,t=e._self._c;return t("div",[t("b-field",[e.showLabel?t("template",{slot:"label"},[e._v("\n      "+e._s(e.label)+" "),e.required?t("span",[t("sup",[e._v("*")])]):e._e()]):e._e(),e._v(" "),t("b-autocomplete",{attrs:{data:e.employees,placeholder:e.placeholder,field:"fullName",loading:e.isFetching,"check-infinite-scroll":!0},on:{typing:e.getAsyncData,select:t=>e.selectedEmployee=t,"infinite-scroll":e.getMoreAsyncData},scopedSlots:e._u([{key:"default",fn:function(a){return[t("div",{staticClass:"media"},[t("div",{staticClass:"media-left"}),e._v(" "),t("div",{staticClass:"media-content"},[e._v("\n            "+e._s(a.option.fullName)+"\n            "),t("br"),e._v(" "),t("small")])])]}}])},[t("template",{slot:"header"},[t("a",{on:{click:e.showAddEmployee}},[t("span",{staticClass:"has-text-link"},[e._v(" Add new... ")])])]),e._v(" "),e._v(" "),t("template",{slot:"footer"},[t("span",{directives:[{name:"show",rawName:"v-show",value:e.page>e.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[e._v(" Thats it! No more movies found. ")])])],2),e._v(" "),t("div",{attrs:{slot:"message"},slot:"message"},[e._t("errors")],2)],2)],1)};s._withStripped=!0;var i=a(190),o=a.n(i),n={props:{label:{default:"Employee"},required:{default:!0},showLabel:{default:!0},placeholder:{default:"Select Employee"}},data:()=>({employees:[],loading:!1,isFetching:!1,employeeName:"",page:0,totalPages:0,selectedEmployee:{}}),methods:{showAddEmployee(){},fetchEmployees(e){axios.get("/api/employees",{params:{page:this.page,pageSize:10}}).then(({data:e})=>{e.content.forEach(e=>this.employees.push(e)),this.page++,this.totalPages=e.totalPages,this.isFetching=!1},e=>{this.isFetching=!1})},getAsyncData:o()((function(e){if(this.employeeName!==e&&(this.employeeName=e,this.employees=[],this.page=0,this.totalPages=0),!e.length)return this.employees=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchEmployees(e))}),500),getMoreAsyncData:o()((function(){this.getAsyncData(this.employeeName)}),250)},watch:{selectedEmployee:function(e){this.$emit("input",e.id)}}},l=a(15),r=Object(l.a)(n,s,[],!1,null,"30d6cd57",null);t.a=r.exports},600:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e._self._c;return t("ModalTemplate",{on:{modalClosed:function(t){return e.$router.back()}}},[t("ResignationEditForm",{attrs:{slot:"modal-content",id:e.$route.params.id},on:{designationUpdated:e.onResignationUpdated},slot:"modal-content"})],1)};s._withStripped=!0;var i=function(){var e=this,t=e._self._c;return t("form",[e._m(0),e._v(" "),t("div",{staticClass:"field"},[e._m(1),e._v(" "),t("div",{staticClass:"control"},[t("DatePicker",{staticClass:"datepicker",on:{input:function(t){return e.clearFieldError("noticeDate")}},model:{value:e.employeeResignation.noticeDate,callback:function(t){e.$set(e.employeeResignation,"noticeDate",t)},expression:"employeeResignation.noticeDate"}}),e._v(" "),e.errors.noticeDate?t("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.noticeDate[0])+"\n\t\t\t\t\t")]):e._e()],1)]),e._v(" "),t("div",{staticClass:"field"},[e._m(2),e._v(" "),t("div",{staticClass:"control"},[t("DatePicker",{staticClass:"datepicker",on:{input:function(t){return e.clearFieldError("resignationDate")}},model:{value:e.employeeResignation.resignationDate,callback:function(t){e.$set(e.employeeResignation,"resignationDate",t)},expression:"employeeResignation.resignationDate"}}),e._v(" "),e.errors.resignationDate?t("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.resignationDate[0])+"\n\t\t\t\t\t")]):e._e()],1)]),e._v(" "),t("div",{staticClass:"field"},[e._m(3),e._v(" "),t("div",{staticClass:"control"},[t("textarea",{directives:[{name:"model",rawName:"v-model",value:e.employeeResignation.reason,expression:"employeeResignation.reason"}],staticClass:"textarea is-primary",attrs:{placeholder:"Primary textarea"},domProps:{value:e.employeeResignation.reason},on:{input:[function(t){t.target.composing||e.$set(e.employeeResignation,"reason",t.target.value)},function(t){return e.clearFieldError("reason")}]}}),e._v(" "),e.errors.reason?t("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.reason[0])+"\n\t\t\t\t\t")]):e._e()])]),e._v(" "),t("div",{staticClass:"flex justify-center m-3"},[t("button",{staticClass:"button is-rounded",class:{"is-loading":e.loading},attrs:{type:"submit"},on:{click:function(t){return t.preventDefault(),t.stopPropagation(),e.updateDesignation.apply(null,arguments)}}},[e._v("Submit\n            ")])])])};i._withStripped=!0;a(188),a(83);var o=a(189),n=a.n(o),l=a(34),r=a(370),c={props:{id:{required:!0}},mixins:[l.a],components:{DatePicker:n.a,EmployeeSelectInput:r.a},created(){this.getDesignation()},data:()=>({loading:!1,employeeResignation:{}}),methods:{getDesignation(){axios.get("/api/employee-resignations/"+this.id).then(e=>{this.employeeResignation=e.data})},updateDesignation(){let e=this;axios.put("/api/employee-resignations/"+this.id,this.employeeResignation).then(t=>{e.$swal({type:"success",title:"Success",text:"Resignation  update successful "}),this.$emit("designationUpdated")})}}},d=a(15),p=Object(d.a)(c,i,[function(){var e=this._self._c;return e("div",{staticClass:"has-text-centered m-3"},[e("h1",{staticClass:"has-text-black"},[e("b",[this._v("Update Resignation")])])])},function(){var e=this._self._c;return e("label",{staticClass:"label"},[this._v("Notice Date"),e("span",[e("sup",[this._v("*")])])])},function(){var e=this._self._c;return e("label",{staticClass:"label"},[this._v("Resignation Date"),e("span",[e("sup",[this._v("*")])])])},function(){var e=this._self._c;return e("label",{staticClass:"label"},[this._v("Reason "),e("span",[e("sup",[this._v("*")])])])}],!1,null,null,null).exports,u={components:{ModalTemplate:a(361).a,ResignationEditForm:p},data:()=>({}),methods:{onResignationUpdated(){this.$emit("designationUpdated"),this.$router.back()}}},m=Object(d.a)(u,s,[],!1,null,null,null);t.default=m.exports}}]);