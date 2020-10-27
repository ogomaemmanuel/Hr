(window.webpackJsonp=window.webpackJsonp||[]).push([[31],{115:function(t,a,e){"use strict";(function(t){var i=e(76);a.a={components:{Paginator:i.a},data:()=>({employees:[],pageable:!1,pageSize:10,page:0,loading:!1,totalPages:0}),methods:{getEmployees(){let t=this;t.loading=!0,axios.get("/api/employee-salary",{params:{pageSize:t.pageSize,page:t.page}}).then(a=>{t.loading=!1,this.employees=a.data.content,this.pageable=a.data},a=>{t.loading=!1})},goToPrevious(){this.page--,this.getEmployees()},goToNext(){this.page++,this.getEmployees()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.getEmployees()}},created(){this.getEmployees()},filters:{formatDate:a=>a?t(a).format("DD-MMM-YYYY"):null}}}).call(this,e(85))},523:function(t,a,e){"use strict";e.r(a);var i=e(115).a,s=e(2),n=Object(s.a)(i,(function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"h-full"},[e("div",{staticClass:"pb-2 flex justify-end"},[e("portal",{attrs:{to:"page-controls"}},[e("router-link",{staticClass:"button mr-1 is-rounded",attrs:{to:"/employees-create",tag:"button"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-plus-circle mr-1"})]),t._v(" "),e("span",[t._v("\n\t\t\t\t\t Add Salary\n\t\t\t\t")])]),t._v(" "),e("a",{staticClass:"button is-rounded",attrs:{href:"/api/holidays/excel-report"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-download mr-1"})]),t._v(" "),e("span",[t._v("\n\t\t\t\t\t Export\n\t\t\t\t")])])],1)],1),t._v(" "),e("div",{staticClass:"columns h-full"},[e("div",{staticClass:"column is-12"},[e("div",{staticClass:"card"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"content b-table is-relative"},[e("h4",[t._v("Employees")]),t._v(" "),e("table",{staticClass:"table has-mobile-cards w-full is-hoverable"},[t._m(0),t._v(" "),e("tbody",t._l(t.employees,(function(a){return e("tr",[e("td",{attrs:{"data-label":"Name"}},[t._v(t._s(a.fullName))]),t._v(" "),e("td",{attrs:{"data-label":"Description"}},[t._v(t._s(a.employeeId))]),t._v(" "),e("td",{attrs:{"data-label":"Description"}},[t._v(t._s(a.email))]),t._v(" "),e("td",{attrs:{"data-label":"Description"}},[t._v(t._s(a.phone))]),t._v(" "),e("td",{attrs:{"data-label":"Description"}},[t._v(t._s(t._f("formatDate")(a.joiningDate)))]),t._v(" "),e("td",{attrs:{"data-label":"Description"}},[t._v(t._s(a.designation))]),t._v(" "),e("td",{attrs:{"data-label":"Description"}},[t._v(t._s(a.salaryAmount))]),t._v(" "),e("td",{attrs:{"data-label":"Action"}},[e("div",{staticClass:"action-controls d-flex justify-end"},[e("router-link",{staticClass:"button is-white is-small",attrs:{tag:"button",to:"/salary-view/"+a.id}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-money has-text-link"})])]),t._v(" "),e("router-link",{staticClass:"button is-white is-small",attrs:{tag:"button",to:"/salary/"+a.id}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-eye has-text-success"})])])],1)])])})),0),t._v(" "),e("tfoot",[e("tr",[e("td",{attrs:{colspan:"8"}},[e("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])]),t._v(" "),e("b-loading",{attrs:{"is-full-page":!1,active:t.loading,"can-cancel":!0},on:{"update:active":function(a){t.loading=a}}})],1)])])])])])}),[function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("thead",{staticClass:"font-thin"},[e("tr",[e("th",[t._v("\n                                        Name\n                                    ")]),t._v(" "),e("th",[t._v("\n                                        Employee Id\n                                    ")]),t._v(" "),e("th",[t._v("\n                                        Email\n                                    ")]),t._v(" "),e("th",[t._v("\n                                        Mobile\n                                    ")]),t._v(" "),e("th",[t._v("\n                                        Join Date\n                                    ")]),t._v(" "),e("th",[t._v("\n                                        Designation\n                                    ")]),t._v(" "),e("th",[t._v("\n                                        Salary\n                                    ")]),t._v(" "),e("th")])])}],!1,null,"230f1963",null);a.default=n.exports},71:function(t,a,e){var i=e(78);"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);(0,e(6).default)("c40d3914",i,!0,{})},76:function(t,a,e){"use strict";var i={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},s=(e(77),e(2)),n=Object(s.a)(i,(function(){var t=this,a=t.$createElement,e=t._self._c||a;return t.paginationData?e("div",{staticClass:"paginator"},[e("div",{staticClass:"page-per-row"},[e("label",[t._v("Records per page:")]),t._v(" "),e("select",{staticClass:"page-per-row-selector",on:{change:function(a){return t.onPaginationChanged(a)}}},[e("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),e("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),e("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),e("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),e("div",{staticClass:"paginator-controls"},[e("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),e("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[e("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),e("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[e("i",{staticClass:"fa fa-angle-right"})])])]):t._e()}),[],!1,null,"4c61e2cb",null);a.a=n.exports},77:function(t,a,e){"use strict";var i=e(71);e.n(i).a},78:function(t,a,e){(t.exports=e(5)(!1)).push([t.i,".paginator[data-v-4c61e2cb]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-4c61e2cb]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-4c61e2cb]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-4c61e2cb]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},88:function(t,a){function e(t){var a=new Error("Cannot find module '"+t+"'");throw a.code="MODULE_NOT_FOUND",a}e.keys=function(){return[]},e.resolve=e,t.exports=e,e.id=88}}]);