(window.webpackJsonp=window.webpackJsonp||[]).push([[49],{506:function(t,a,i){"use strict";i.r(a);var e={components:{Paginator:i(76).a},data:()=>({showCreateDialog:!1,designations:[],pageable:!1,pageSize:10,page:0,loading:!1}),created(){this.getDesignations()},methods:{confirmRemoveDesignation(t){this.$buefy.dialog.confirm({title:"Remove Department",message:`Are you sure want to remove <b> ${t.name}</b> from designations`,onConfirm:()=>this.removeDesignation(t)})},removeDesignation(t){axios.delete("/api/designations/"+t.id).then(t=>{this.$swal({type:"success",title:"Success",message:"Designation successfully removed"}),this.getDesignations()})},getDesignations(){let t=this;axios.get("/api/designations",{params:{pageSize:t.pageSize,page:t.page}}).then(a=>{t.loading=!1,this.designations=a.data.content,this.pageable=a.data},a=>{t.loading=!1})},goToPrevious(){this.page--,this.getDesignations()},goToNext(){this.page++,this.getDesignations()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.getDesignations()},onDesignationUpdated(){this.getDesignations()},onDesignationCreated(){this.getDesignations()}}},n=i(2),s=Object(n.a)(e,(function(){var t=this,a=t.$createElement,i=t._self._c||a;return i("div",[i("div",{staticClass:"pb-2 flex justify-end"},[i("router-link",{staticClass:"button mr-1 is-rounded",attrs:{to:"/designations-create",tag:"button"}},[i("span",{staticClass:"icon"},[i("i",{staticClass:"fa fa-plus-circle mr-1"})]),t._v(" "),i("span",[t._v("\n\t\t\t\t\t Add Designation\n\t\t\t\t")])]),t._v(" "),t._m(0)],1),t._v(" "),i("div",{staticClass:"columns"},[i("div",{staticClass:"column is-12"},[i("div",{ref:"leaveRequests",staticClass:"card"},[i("div",{staticClass:"card-content"},[i("div",{staticClass:"content b-table is-relative"},[i("h4",[t._v("Designations")]),t._v(" "),i("table",{staticClass:"table has-mobile-cards w-full is-hoverable"},[t._m(1),t._v(" "),i("tbody",t._l(t.designations,(function(a){return i("tr",[i("td",{attrs:{"data-label":"Name"}},[t._v(t._s(a.name))]),t._v(" "),i("td",{attrs:{"data-label":"Description"}},[t._v(t._s(a.department.name))]),t._v(" "),i("td",{attrs:{"data-label":"Action"}},[i("div",{staticClass:"action-controls d-flex justify-end"},[i("router-link",{staticClass:"button is-white is-small",attrs:{to:"/designations-edit/"+a.id,tag:"button"}},[i("span",{staticClass:"icon"},[i("i",{staticClass:"fa fa-pencil-square-o has-text-primary"})])]),t._v(" "),i("button",{staticClass:"button is-white is-small",on:{click:function(i){return t.confirmRemoveDesignation(a)}}},[t._m(2,!0)])],1)])])})),0),t._v(" "),i("tfoot",[i("tr",[i("td",{attrs:{colspan:"8"}},[i("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])]),t._v(" "),i("b-loading",{attrs:{"is-full-page":!1,active:t.loading,"can-cancel":!0},on:{"update:active":function(a){t.loading=a}}})],1)])])])]),t._v(" "),i("router-view",{on:{designationCreated:t.onDesignationCreated,designationUpdated:t.onDesignationUpdated}})],1)}),[function(){var t=this.$createElement,a=this._self._c||t;return a("a",{staticClass:"button is-rounded",attrs:{href:"/api/designations/excel-report"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-download mr-1"})]),this._v(" "),a("span",[this._v("\n\t\t\t\t\t Export\n\t\t\t\t")])])},function(){var t=this.$createElement,a=this._self._c||t;return a("thead",{staticClass:"font-thin"},[a("tr",[a("th",[this._v("\n                                        Name\n                                    ")]),this._v(" "),a("th",[this._v("\n                                        Department\n                                    ")]),this._v(" "),a("th",[this._v("\n                                        Action\n                                    ")])])])},function(){var t=this.$createElement,a=this._self._c||t;return a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-trash-o has-text-danger"})])}],!1,null,"af0f59d0",null);a.default=s.exports},71:function(t,a,i){var e=i(78);"string"==typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);(0,i(6).default)("c40d3914",e,!0,{})},76:function(t,a,i){"use strict";var e={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},n=(i(77),i(2)),s=Object(n.a)(e,(function(){var t=this,a=t.$createElement,i=t._self._c||a;return t.paginationData?i("div",{staticClass:"paginator"},[i("div",{staticClass:"page-per-row"},[i("label",[t._v("Records per page:")]),t._v(" "),i("select",{staticClass:"page-per-row-selector",on:{change:function(a){return t.onPaginationChanged(a)}}},[i("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),i("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),i("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),i("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),i("div",{staticClass:"paginator-controls"},[i("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),i("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[i("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),i("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[i("i",{staticClass:"fa fa-angle-right"})])])]):t._e()}),[],!1,null,"4c61e2cb",null);a.a=s.exports},77:function(t,a,i){"use strict";var e=i(71);i.n(e).a},78:function(t,a,i){(t.exports=i(5)(!1)).push([t.i,".paginator[data-v-4c61e2cb]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-4c61e2cb]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-4c61e2cb]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-4c61e2cb]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])}}]);