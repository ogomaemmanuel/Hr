(window.webpackJsonp=window.webpackJsonp||[]).push([[7],{129:function(t,e,a){"use strict";a.r(e);var s=a(73),n=a(87).a,i=a(2),o=Object(i.a)(n,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("tr",[a("td",{attrs:{"data-label":"Employee"}},[a("div",{staticClass:"has-text-primary"},[t._v("\n\t\t"+t._s(t.leaveRequestClone.employee)+"\n\t\t")])]),t._v(" "),a("td",{attrs:{"data-label":"Start Date"}},[t._v("\n\t\t"+t._s(t._f("dateFormat")(t.leaveRequestClone.startDate))+"\n\t")]),t._v(" "),a("td",{attrs:{"data-label":"End Date"}},[t._v("\n\t\t"+t._s(t._f("dateFormat")(t.leaveRequestClone.endDate))+"\n\t")]),t._v(" "),a("td",{attrs:{"data-label":"Number of Days"}},[t._v("\n\t\t"+t._s(t.leaveRequestClone.numberOfDays)+"\n\t")]),t._v(" "),a("td",{attrs:{"data-label":"Leave Type"}},[t._v("\n\t\t"+t._s(t.leaveRequestClone.leaveType)+"\n\t")]),t._v(" "),a("td",{attrs:{"data-label":"Status"}},[a("span",{staticClass:"tag is-light",class:t.statusColor},[t._v("\n\t\t\t"+t._s(t.statusText)+"\n\t\t")])]),t._v(" "),a("td",[a("div",[a("router-link",{staticClass:"button is-small is-white",attrs:{to:"/leave-approvals/leave-details/"+t.leaveRequestClone.id}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-eye has-text-primary"})])]),t._v(" "),t._m(0)],1)])])},[function(){var t=this.$createElement,e=this._self._c||t;return e("button",{staticClass:"button is-small is-white"},[e("span",{staticClass:"icon "},[e("i",{staticClass:"fa fa-trash has-text-danger"})])])}],!1,null,null,null).exports,r={components:{Paginator:s.a,LeaveApprovalItem:o},data:()=>({loading:!1,leaveRequests:[],pageable:!1,pageSize:10,page:0,showLeaveBalances:!1}),created(){this.getLeaveRequestesToApprove()},methods:{getLeaveRequestesToApprove(){let t=this;axios.get("/api/leave-request-approvals",{params:{pageSize:t.pageSize,page:t.page}}).then(e=>{t.leaveRequests=e.data.content,t.pageable=e.data})},goToPrevious(){this.page--,this.getUserLeaveRequests()},goToNext(){this.page++,this.getUserLeaveRequests()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.getUserLeaveRequests()}}},l=Object(i.a)(r,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._m(0),t._v(" "),a("div",{staticClass:"mt-5 b-table bg-white p-5 is-size-7 is-full"},[a("table",{staticClass:"table has-mobile-cards  w-full"},[t._m(1),t._v(" "),a("tbody",t._l(t.leaveRequests,function(t){return a("LeaveApprovalItem",{tag:"tr",attrs:{leaveRequest:t}})}),1),t._v(" "),a("tfoot",[a("tr",[a("td",{attrs:{colspan:"8"}},[a("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])])])])},[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"flex  justify-end  mb-5"},[e("div",{staticClass:"columns"},[e("div",{staticClass:"column is-inline-flex"},[e("input",{staticClass:"input flex-grow-0 is-rounded is-small mr-1",attrs:{type:"text",placeholder:"Search ..."}}),this._v(" "),e("span",{},[e("button",{staticClass:"button is-small is-rounded"},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-download"})]),this._v(" "),e("span",[this._v("\n\t\t\t\tExport All\n\t\t\t")])])])])])])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("thead",[a("tr",[a("th",[t._v("Employee")]),t._v(" "),a("th",[t._v("Start Date")]),t._v(" "),a("th",[t._v("End Date")]),t._v(" "),a("th",[t._v("Days")]),t._v(" "),a("th",[t._v("Leave Type")]),t._v(" "),a("th",[t._v("Status")]),t._v(" "),a("th",[t._v("Action")])])])}],!1,null,null,null);e.default=l.exports},68:function(t,e,a){var s=a(72);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,a(5).default)("32f0fd50",s,!0,{})},70:function(t,e){function a(t){var e=new Error("Cannot find module '"+t+"'");throw e.code="MODULE_NOT_FOUND",e}a.keys=function(){return[]},a.resolve=a,t.exports=a,a.id=70},71:function(t,e,a){"use strict";var s=a(68);a.n(s).a},72:function(t,e,a){(t.exports=a(4)(!1)).push([t.i,".paginator[data-v-4c61e2cb]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-4c61e2cb]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-4c61e2cb]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-4c61e2cb]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},73:function(t,e,a){"use strict";var s={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},n=(a(71),a(2)),i=Object(n.a)(s,function(){var t=this,e=t.$createElement,a=t._self._c||e;return t.paginationData?a("div",{staticClass:"paginator"},[a("div",{staticClass:"page-per-row"},[a("label",[t._v("Records per page:")]),t._v(" "),a("select",{staticClass:"page-per-row-selector",on:{change:function(e){return t.onPaginationChanged(e)}}},[a("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),a("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),a("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),a("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),a("div",{staticClass:"paginator-controls"},[a("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),a("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[a("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),a("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[a("i",{staticClass:"fa fa-angle-right"})])])]):t._e()},[],!1,null,"4c61e2cb",null);e.a=i.exports},85:function(t,e){t.exports=function(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}},87:function(t,e,a){"use strict";(function(t){var s=a(85),n=a.n(s);function i(t,e){var a=Object.keys(t);if(Object.getOwnPropertySymbols){var s=Object.getOwnPropertySymbols(t);e&&(s=s.filter(function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable})),a.push.apply(a,s)}return a}e.a={props:{leaveRequest:{required:!0,type:Object}},created(){this.leaveRequestClone=function(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{};e%2?i(a,!0).forEach(function(e){n()(t,e,a[e])}):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(a)):i(a).forEach(function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(a,e))})}return t}({},this.leaveRequest)},data:()=>({leaveRequestClone:{}}),filters:{dateFormat:e=>t(e).format("LL")},computed:{statusColor(){return"new"==this.leaveRequestClone.status.toLowerCase()?"is-primary":"withdrawn"==this.leaveRequestClone.status.toLowerCase()?"is-warning":void 0},statusText(){return"new"==this.leaveRequestClone.status.toLowerCase()?"Awaiting In Place Approval":"withdrawn"==this.leaveRequestClone.status.toLowerCase()?"is-warning":void 0}}}}).call(this,a(69))}}]);