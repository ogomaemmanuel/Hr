(window.webpackJsonp=window.webpackJsonp||[]).push([[32],{171:function(t,a){function e(t){var a=new Error("Cannot find module '"+t+"'");throw a.code="MODULE_NOT_FOUND",a}e.keys=function(){return[]},e.resolve=e,t.exports=e,e.id=171},200:function(t,a,e){var i=e(207);"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);(0,e(23).default)("c40d3914",i,!0,{})},205:function(t,a,e){"use strict";var i={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},n=(e(206),e(15)),s=Object(n.a)(i,(function(){var t=this,a=t.$createElement,e=t._self._c||a;return t.paginationData?e("div",{staticClass:"paginator"},[e("div",{staticClass:"page-per-row"},[e("label",[t._v("Records per page:")]),t._v(" "),e("select",{staticClass:"page-per-row-selector",on:{change:function(a){return t.onPaginationChanged(a)}}},[e("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),e("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),e("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),e("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),e("div",{staticClass:"paginator-controls"},[e("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),e("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[e("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),e("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[e("i",{staticClass:"fa fa-angle-right"})])])]):t._e()}),[],!1,null,"4c61e2cb",null);a.a=s.exports},206:function(t,a,e){"use strict";var i=e(200);e.n(i).a},207:function(t,a,e){(t.exports=e(22)(!1)).push([t.i,".paginator[data-v-4c61e2cb]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-4c61e2cb]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-4c61e2cb]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-4c61e2cb]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},208:function(t,a,e){"use strict";a.a={data:()=>({pageable:!1,pageSize:10,page:0}),methods:{goToPrevious(){this.page--,this.fetchRecords()},goToNext(){this.page++,this.fetchRecords()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.fetchRecords()}}}},232:function(t,a,e){"use strict";(function(t){var i=e(205),n=e(208);a.a={mixins:[n.a],components:{Paginator:i.a},data:()=>({loading:!1,pageable:!1,resignations:[]}),created(){this.getResignations()},filters:{dateFormat:a=>t(a).format("DD MMM YYYY ")},methods:{fetchRecords(){this.getResignations()},getResignations(){this.loading=!0,axios.get("/api/employee-resignations",{params:{page:this.page,pageSize:this.pageSize}}).then(t=>{this.loading=!1,this.resignations=t.data.content,this.pageable=t.data},t=>{this.loading=!1})},confirmRemove(t){this.$buefy.dialog.confirm({title:"Remove Resignation",message:"Are you sure you want remove this record",onConfirm:()=>this.removeResignation(t)})},removeResignation(t){axios.delete("/api/employee-resignations/"+t.id).then(t=>{this.getResignations()})}}}}).call(this,e(170))},471:function(t,a,e){"use strict";e.r(a);var i=e(232).a,n=e(15),s=Object(n.a)(i,(function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"columns"},[e("div",{staticClass:"column is-12"},[e("div",{ref:"leaveRequests",staticClass:"card"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"content b-table is-relative"},[e("h4",[t._v("Resignations")]),t._v(" "),e("table",{staticClass:"table has-mobile-cards w-full is-hoverable"},[t._m(0),t._v(" "),e("tbody",t._l(t.resignations,(function(a){return e("tr",[e("td",{attrs:{"data-label":"Name"}},[t._v(t._s(a.employeeFullName))]),t._v(" "),e("td",{attrs:{"data-label":"Description"}},[t._v(t._s(a.employeeDepartment))]),t._v(" "),e("td",{attrs:{"data-label":"Description"}},[t._v(t._s(a.reason))]),t._v(" "),e("td",{attrs:{"data-label":"Description"}},[t._v(t._s(t._f("dateFormat")(a.noticeDate)))]),t._v(" "),e("td",{attrs:{"data-label":"Description"}},[t._v(t._s(t._f("dateFormat")(a.resignationDate)))]),t._v(" "),e("td",{attrs:{"data-label":"Action"}},[e("div",{staticClass:"action-controls d-flex justify-end"},[e("router-link",{staticClass:"button is-white is-small",attrs:{to:"/employee-resignation-edit/"+a.id,tag:"button"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-pencil-square-o has-text-primary"})])]),t._v(" "),e("button",{staticClass:"button is-white is-small",on:{click:function(e){return t.confirmRemove(a)}}},[t._m(1,!0)])],1)])])})),0),t._v(" "),e("tfoot",[e("tr",[e("td",{attrs:{colspan:"8"}},[e("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])])])])])]),t._v(" "),e("router-view",{on:{designationUpdated:function(a){return t.getResignations()},overtimeRequestUpdated:function(a){return t.getResignations()}}})],1)}),[function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("thead",{staticClass:"font-thin"},[e("tr",[e("th",[t._v("\n                                    Resigning Employee\n                                ")]),t._v(" "),e("th",[t._v("\n                                    Department\n                                ")]),t._v(" "),e("th",[t._v("\n                                    Reason\n                                ")]),t._v(" "),e("th",[t._v("\n                                    Notice Date\n                                ")]),t._v(" "),e("th",[t._v("\n                                    Resignation Date\n                                ")]),t._v(" "),e("th",[t._v("\n                                    Action\n                                ")])])])},function(){var t=this.$createElement,a=this._self._c||t;return a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-trash-o has-text-danger"})])}],!1,null,"e1259d9e",null);a.default=s.exports}}]);