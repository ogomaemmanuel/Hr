(window.webpackJsonp=window.webpackJsonp||[]).push([[22],{223:function(t,a,e){var s=e(227);s.__esModule&&(s=s.default),"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,e(21).default)("3c92a25e",s,!1,{})},224:function(t,a,e){"use strict";var s=function(){var t=this,a=t._self._c;return a("div",{staticClass:"modal-wrapper"},[a("div",{ref:"modal",staticClass:"modal"},[a("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[a("div",{staticClass:"box",class:t.hasPadding?"":"p-0"},[t._t("modal-content")],2)]),t._v(" "),t.showCloseButton?[a("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(a){return a.stopPropagation(),t.closeModal.apply(null,arguments)}}})]:t._e()],2)])};s._withStripped=!0;var i={mixins:[e(225).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0},hasPadding:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},n=(e(226),e(14)),o=Object(n.a)(i,s,[],!1,null,"f5b23902",null);a.a=o.exports},225:function(t,a,e){"use strict";(function(t){a.a={methods:{closeModal(){t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,e(184))},226:function(t,a,e){"use strict";e(223)},227:function(t,a,e){(t.exports=e(20)(!1)).push([t.i,".modal[data-v-f5b23902]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-f5b23902]{overflow:visible}\n",""])},228:function(t,a,e){var s=e(231);s.__esModule&&(s=s.default),"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,e(21).default)("bae396d6",s,!1,{})},229:function(t,a,e){"use strict";var s=function(){var t=this,a=t._self._c;return t.paginationData?a("div",{staticClass:"paginator"},[a("div",{staticClass:"page-per-row"},[a("label",[t._v("Records per page:")]),t._v(" "),a("select",{staticClass:"page-per-row-selector",on:{change:function(a){return t.onPaginationChanged(a)}}},[a("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),a("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),a("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),a("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),a("div",{staticClass:"paginator-controls"},[a("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),a("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[a("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),a("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[a("i",{staticClass:"fa fa-angle-right"})])])]):t._e()};s._withStripped=!0;var i={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},n=(e(230),e(14)),o=Object(n.a)(i,s,[],!1,null,"248be8a4",null);a.a=o.exports},230:function(t,a,e){"use strict";e(228)},231:function(t,a,e){(t.exports=e(20)(!1)).push([t.i,".paginator[data-v-248be8a4]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-248be8a4]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-248be8a4]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-248be8a4]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},275:function(t,a,e){"use strict";var s=function(){var t=this,a=t._self._c;return a("div",[a("form",[t._m(0),t._v(" "),a("div",{staticClass:"field"},[t._m(1),t._v(" "),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.department.name,expression:"department.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.department.name},on:{input:[function(a){a.target.composing||t.$set(t.department,"name",a.target.value)},function(a){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?a("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),a("div",{staticClass:"flex justify-center m-3"},[a("button",{staticClass:"button is-rounded",class:{"is-loading":t.loading},attrs:{disabled:t.disableSubmitButton,type:"submit"},on:{click:function(a){return a.preventDefault(),a.stopPropagation(),t.createDepartment.apply(null,arguments)}}},[t._v("Submit\n                ")])])])])};s._withStripped=!0;var i={mixins:[e(33).a],data:()=>({department:{name:""},loading:!1}),methods:{createDepartment(){let t=this;axios.post("/api/departments",this.department).then(a=>{this.loading=!1,t.$swal({type:"success",title:"Success",text:"Department  successfully created"}),this.$emit("departmentCreated")},t=>{this.loading=!1})}},computed:{disableSubmitButton(){return this.department.name.length<=0||this.loading}}},n=e(14),o=Object(n.a)(i,s,[function(){var t=this._self._c;return t("div",{staticClass:"has-text-centered m-3"},[t("h1",{staticClass:"has-text-black"},[t("b",[this._v("Create New Department")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Department Name "),t("span",[t("sup",[this._v("*")])])])}],!1,null,null,null);a.a=o.exports},502:function(t,a,e){"use strict";e.r(a);var s=function(){var t=this,a=t._self._c;return a("div",[a("div",[a("div",{staticClass:"pb-2 flex justify-end"},[a("router-link",{staticClass:"button mr-1 is-rounded",attrs:{to:"/departments-create",tag:"button"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-plus-circle mr-1"})]),t._v(" "),a("span",[t._v("\n\t\t\t\t\t Add Department\n\t\t\t\t")])]),t._v(" "),t._m(0)],1),t._v(" "),a("div",{staticClass:"columns"},[a("div",{staticClass:"column is-12"},[a("div",{ref:"leaveRequests",staticClass:"card"},[a("div",{staticClass:"card-content"},[a("div",{staticClass:"content b-table is-relative"},[a("h4",[t._v("Departments")]),t._v(" "),a("table",{staticClass:"table has-mobile-cards w-full is-hoverable"},[t._m(1),t._v(" "),a("tbody",t._l(t.departments,(function(e){return a("tr",[a("td",{attrs:{"data-label":"Name"}},[t._v(t._s(e.name))]),t._v(" "),a("td",{attrs:{"data-label":"Action"}},[a("div",{staticClass:"action-controls d-flex float-right"},[a("router-link",{staticClass:"button is-white is-small",attrs:{to:"/departments-edit/"+e.id,tag:"button"},on:{click:function(t){}}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-pencil-square-o has-text-primary"})])]),t._v(" "),a("button",{staticClass:"button is-white is-small",on:{click:function(a){return t.confirmRemoveDepartment(e)}}},[t._m(2,!0)])],1)])])})),0),t._v(" "),a("tfoot",[a("tr",[a("td",{attrs:{colspan:"8"}},[a("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])]),t._v(" "),a("b-loading",{attrs:{"is-full-page":!1,active:t.loading,"can-cancel":!0},on:{"update:active":function(a){t.loading=a}}})],1)])])])]),t._v(" "),a("router-view",{on:{departmentUpdated:t.onDepartmentUpdated,departmentCreated:t.onDepartmentCreated}})],1)])};s._withStripped=!0;var i=e(229),n=e(224),o=e(275),r={components:{Paginator:i.a,ModalTemplate:n.a,DepartmentCreateForm:o.a},data:()=>({departments:[],pageable:!1,pageSize:10,page:0,loading:!1}),methods:{confirmRemoveDepartment(t){this.$buefy.dialog.confirm({title:"Remove Department",message:`Are you sure want to remove <b> ${t.name}</b> from departments`,onConfirm:()=>this.removeDepartment(t)})},removeDepartment(t){axios.delete("/api/departments/"+t.id).then(t=>{this.$swal({type:"success",title:"Success",message:"Department successfully removed"}),this.getDepartments()})},onDepartmentCreated(){this.getDepartments()},getDepartments(){let t=this;t.loading=!0,axios.get("/api/departments",{params:{pageSize:t.pageSize,page:t.page}}).then(a=>{t.loading=!1,this.departments=a.data.content,this.pageable=a.data},a=>{t.loading=!1})},goToPrevious(){this.page--,this.getDepartments()},goToNext(){this.page++,this.getDepartments()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.getDepartments()},onDepartmentUpdated(){this.getDepartments()}},created(){this.getDepartments()}},l=e(14),d=Object(l.a)(r,s,[function(){var t=this._self._c;return t("a",{staticClass:"button is-rounded",attrs:{href:"/api/departments/excel-reports"}},[t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-download mr-1"})]),this._v(" "),t("span",[this._v("\n\t\t\t\t\t Export\n\t\t\t\t")])])},function(){var t=this._self._c;return t("thead",{staticClass:"font-thin"},[t("tr",[t("th",[this._v("\n                                            Name\n                                        ")]),this._v(" "),t("th",[t("div",{staticClass:"float-right"})])])])},function(){var t=this._self._c;return t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-trash-o has-text-danger"})])}],!1,null,null,null);a.default=d.exports}}]);