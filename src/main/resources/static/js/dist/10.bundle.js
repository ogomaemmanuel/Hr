(window.webpackJsonp=window.webpackJsonp||[]).push([[10],{449:function(t,a,e){var s=e(454);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,e(28).default)("6a4b444c",s,!0,{})},450:function(t,a,e){var s=e(457);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,e(28).default)("c40d3914",s,!0,{})},451:function(t,a,e){"use strict";var s={mixins:[e(452).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},n=(e(453),e(21)),i=Object(n.a)(s,(function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{ref:"modal",staticClass:"modal"},[e("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[e("div",{staticClass:"box"},[t._t("modal-content")],2)]),t._v(" "),t.showCloseButton?[e("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(a){return a.stopPropagation(),t.closeModal(a)}}})]:t._e()],2)}),[],!1,null,"c09ee790",null);a.a=i.exports},452:function(t,a,e){"use strict";(function(t){a.a={methods:{closeModal(){t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,e(82))},453:function(t,a,e){"use strict";var s=e(449);e.n(s).a},454:function(t,a,e){(t.exports=e(27)(!1)).push([t.i,".modal[data-v-c09ee790]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-c09ee790]{overflow:visible}\n",""])},455:function(t,a,e){"use strict";var s={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},n=(e(456),e(21)),i=Object(n.a)(s,(function(){var t=this,a=t.$createElement,e=t._self._c||a;return t.paginationData?e("div",{staticClass:"paginator"},[e("div",{staticClass:"page-per-row"},[e("label",[t._v("Records per page:")]),t._v(" "),e("select",{staticClass:"page-per-row-selector",on:{change:function(a){return t.onPaginationChanged(a)}}},[e("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),e("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),e("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),e("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),e("div",{staticClass:"paginator-controls"},[e("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),e("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[e("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),e("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[e("i",{staticClass:"fa fa-angle-right"})])])]):t._e()}),[],!1,null,"4c61e2cb",null);a.a=i.exports},456:function(t,a,e){"use strict";var s=e(450);e.n(s).a},457:function(t,a,e){(t.exports=e(27)(!1)).push([t.i,".paginator[data-v-4c61e2cb]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-4c61e2cb]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-4c61e2cb]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-4c61e2cb]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},497:function(t,a,e){"use strict";var s={mixins:[e(42).a],data:()=>({department:{name:""},loading:!1}),methods:{createDepartment(){let t=this;axios.post("/api/departments",this.department).then(a=>{this.loading=!1,t.$swal({type:"success",title:"Success",text:"Department  successfully created"}),this.$emit("departmentCreated")},t=>{this.loading=!1})}},computed:{disableSubmitButton(){return this.department.name.length<=0||this.loading}}},n=e(21),i=Object(n.a)(s,(function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("form",[t._m(0),t._v(" "),e("div",{staticClass:"field"},[t._m(1),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.department.name,expression:"department.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.department.name},on:{input:[function(a){a.target.composing||t.$set(t.department,"name",a.target.value)},function(a){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),e("div",{staticClass:"flex justify-center m-3"},[e("button",{staticClass:"button  is-rounded",class:{"is-loading":t.loading},attrs:{disabled:t.disableSubmitButton,type:"submit"},on:{click:function(a){return a.preventDefault(),a.stopPropagation(),t.createDepartment(a)}}},[t._v("Submit\n                ")])])])])}),[function(){var t=this.$createElement,a=this._self._c||t;return a("div",{staticClass:"has-text-centered m-3"},[a("h1",{staticClass:"has-text-black"},[a("b",[this._v("Create New Department")])])])},function(){var t=this.$createElement,a=this._self._c||t;return a("label",{staticClass:"label"},[this._v("Department Name "),a("span",[a("sup",[this._v("*")])])])}],!1,null,null,null);a.a=i.exports},584:function(t,a,e){"use strict";e.r(a);var s=e(455),n=e(451),i=e(497),o={components:{Paginator:s.a,ModalTemplate:n.a,DepartmentCreateForm:i.a},data:()=>({departments:[],pageable:!1,pageSize:10,page:0,loading:!1}),methods:{confirmRemoveDepartment(t){this.$buefy.dialog.confirm({title:"Remove Department",message:`Are you sure want to remove <b> ${t.name}</b> from departments`,onConfirm:()=>this.removeDepartment(t)})},removeDepartment(t){axios.delete("/api/departments/"+t.id).then(t=>{this.$swal({type:"success",title:"Success",message:"Department successfully removed"}),this.getDepartments()})},onDepartmentCreated(){this.getDepartments()},getDepartments(){let t=this;t.loading=!0,axios.get("/api/departments",{params:{pageSize:t.pageSize,page:t.page}}).then(a=>{t.loading=!1,this.departments=a.data.content,this.pageable=a.data},a=>{t.loading=!1})},goToPrevious(){this.page--,this.getDepartments()},goToNext(){this.page++,this.getDepartments()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.getDepartments()},onDepartmentUpdated(){this.getDepartments()}},created(){this.getDepartments()}},r=e(21),l=Object(r.a)(o,(function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("div",[e("div",{staticClass:"pb-2 flex justify-end"},[e("router-link",{staticClass:"button mr-1 is-rounded",attrs:{to:"/departments-create",tag:"button"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-plus-circle mr-1"})]),t._v(" "),e("span",[t._v("\n\t\t\t\t\t Add Department\n\t\t\t\t")])]),t._v(" "),t._m(0)],1),t._v(" "),e("div",{staticClass:"columns"},[e("div",{staticClass:"column is-12"},[e("div",{ref:"leaveRequests",staticClass:"card"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"content b-table is-relative"},[e("h4",[t._v("Departments")]),t._v(" "),e("table",{staticClass:"table has-mobile-cards w-full is-hoverable"},[t._m(1),t._v(" "),e("tbody",t._l(t.departments,(function(a){return e("tr",[e("td",{attrs:{"data-label":"Name"}},[t._v(t._s(a.name))]),t._v(" "),e("td",{attrs:{"data-label":"Action"}},[e("div",{staticClass:"action-controls d-flex float-right"},[e("router-link",{staticClass:"button is-white is-small",attrs:{to:"/departments-edit/"+a.id,tag:"button"},on:{click:function(t){}}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-pencil-square-o has-text-primary"})])]),t._v(" "),e("button",{staticClass:"button is-white is-small",on:{click:function(e){return t.confirmRemoveDepartment(a)}}},[t._m(2,!0)])],1)])])})),0),t._v(" "),e("tfoot",[e("tr",[e("td",{attrs:{colspan:"8"}},[e("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])]),t._v(" "),e("b-loading",{attrs:{"is-full-page":!1,active:t.loading,"can-cancel":!0},on:{"update:active":function(a){t.loading=a}}})],1)])])])]),t._v(" "),e("router-view",{on:{departmentUpdated:t.onDepartmentUpdated,departmentCreated:t.onDepartmentCreated}})],1)])}),[function(){var t=this.$createElement,a=this._self._c||t;return a("a",{staticClass:"button is-rounded",attrs:{href:"/api/departments/excel-reports"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-download mr-1"})]),this._v(" "),a("span",[this._v("\n\t\t\t\t\t Export\n\t\t\t\t")])])},function(){var t=this.$createElement,a=this._self._c||t;return a("thead",{staticClass:"font-thin"},[a("tr",[a("th",[this._v("\n                                            Name\n                                        ")]),this._v(" "),a("th",[a("div",{staticClass:"float-right"})])])])},function(){var t=this.$createElement,a=this._self._c||t;return a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-trash-o has-text-danger"})])}],!1,null,null,null);a.default=l.exports}}]);