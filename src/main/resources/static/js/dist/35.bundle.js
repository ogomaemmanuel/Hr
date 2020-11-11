(window.webpackJsonp=window.webpackJsonp||[]).push([[35],{194:function(t,e,a){var i=a(201);"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);(0,a(27).default)("c40d3914",i,!0,{})},199:function(t,e,a){"use strict";var i={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},s=(a(200),a(20)),n=Object(s.a)(i,(function(){var t=this,e=t.$createElement,a=t._self._c||e;return t.paginationData?a("div",{staticClass:"paginator"},[a("div",{staticClass:"page-per-row"},[a("label",[t._v("Records per page:")]),t._v(" "),a("select",{staticClass:"page-per-row-selector",on:{change:function(e){return t.onPaginationChanged(e)}}},[a("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),a("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),a("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),a("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),a("div",{staticClass:"paginator-controls"},[a("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),a("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[a("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),a("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[a("i",{staticClass:"fa fa-angle-right"})])])]):t._e()}),[],!1,null,"4c61e2cb",null);e.a=n.exports},200:function(t,e,a){"use strict";var i=a(194);a.n(i).a},201:function(t,e,a){(t.exports=a(26)(!1)).push([t.i,".paginator[data-v-4c61e2cb]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-4c61e2cb]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-4c61e2cb]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-4c61e2cb]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},202:function(t,e,a){"use strict";e.a={data:()=>({pageable:!1,pageSize:10,page:0}),methods:{goToPrevious(){this.page--,this.fetchRecords()},goToNext(){this.page++,this.fetchRecords()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.fetchRecords()}}}},337:function(t,e,a){"use strict";a.r(e);var i=a(199),s={mixins:[a(202).a],components:{Paginator:i.a},data:()=>({loading:!1,pageable:!1,overtimeRequests:[]}),created(){this.getOvertimeRequests()},methods:{fetchRecords(){this.getOvertimeRequests()},getOvertimeRequests(){this.loading=!0,axios.get("/api/overtime-requests",{params:{page:this.page,pageSize:this.pageSize}}).then(t=>{this.loading=!1,this.overtimeRequests=t.data.content,this.pageable=t.data},t=>{this.loading=!1})},confirmRemove(t){this.$buefy.dialog.confirm({title:"Remove Overtime Requests",message:"Are you sure you want remove this record",onConfirm:()=>this.removeOvertimeRequest(t)})},removeOvertimeRequest(t){axios.delete("/api/overtime-requests/"+t.id).then(t=>{this.getOvertimeRequests()})}}},n=a(20),o=Object(n.a)(s,(function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"columns"},[a("div",{staticClass:"column is-12"},[a("div",{ref:"leaveRequests",staticClass:"card"},[a("div",{staticClass:"card-content"},[a("div",{staticClass:"content b-table is-relative"},[a("h4",[t._v("Overtime Requests")]),t._v(" "),a("table",{staticClass:"table has-mobile-cards w-full is-hoverable"},[t._m(0),t._v(" "),a("tbody",t._l(t.overtimeRequests,(function(e){return a("tr",[a("td",{attrs:{"data-label":"Name"}},[t._v(t._s(e.employeeFullName))]),t._v(" "),a("td",{attrs:{"data-label":"Description"}},[t._v(t._s(e.overtimeDate))]),t._v(" "),a("td",{attrs:{"data-label":"Description"}},[t._v(t._s(e.overtimeHours))]),t._v(" "),a("td",{attrs:{"data-label":"Description"}},[t._v(t._s(e.description))]),t._v(" "),a("td",{attrs:{"data-label":"Description"}}),t._v(" "),a("td",{attrs:{"data-label":"Description"}}),t._v(" "),a("td",{attrs:{"data-label":"Action"}},[a("div",{staticClass:"action-controls d-flex justify-end"},[a("router-link",{staticClass:"button is-white is-small",attrs:{to:"/overtime-requests-edit/"+e.id,tag:"button"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-pencil-square-o has-text-primary"})])]),t._v(" "),a("button",{staticClass:"button is-white is-small",on:{click:function(a){return t.confirmRemove(e)}}},[t._m(1,!0)])],1)])])})),0),t._v(" "),a("tfoot",[a("tr",[a("td",{attrs:{colspan:"8"}},[a("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])])])])])]),t._v(" "),a("router-view",{on:{overtimeRequestUpdated:function(e){return t.getOvertimeRequests()}}})],1)}),[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("thead",{staticClass:"font-thin"},[a("tr",[a("th",[t._v("\n                                    Name\n                                ")]),t._v(" "),a("th",[t._v("\n                                    OT Date\n                                ")]),t._v(" "),a("th",[t._v("\n                                    OT Hours\n                                ")]),t._v(" "),a("th",[t._v("\n                                    Description\n                                ")]),t._v(" "),a("th",[t._v("\n                                    Status\n                                ")]),t._v(" "),a("th",[t._v("\n                                    Approved By\n                                ")]),t._v(" "),a("th",[t._v("\n                                    Action\n                                ")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-trash-o has-text-danger"})])}],!1,null,"43082d4a",null);e.default=o.exports}}]);