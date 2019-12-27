(window.webpackJsonp=window.webpackJsonp||[]).push([[3],{100:function(t,e,a){"use strict";var s=a(72);a.n(s).a},101:function(t,e,a){(t.exports=a(9)(!1)).push([t.i,".paginator[data-v-19464ff6]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-19464ff6]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-19464ff6]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-19464ff6]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},102:function(t,e,a){"use strict";var s={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},i=(a(100),a(2)),n=Object(i.a)(s,function(){var t=this,e=t.$createElement,a=t._self._c||e;return t.paginationData?a("div",{staticClass:"paginator"},[a("div",{staticClass:"page-per-row"},[a("label",[t._v("Records per page:")]),t._v(" "),a("select",{staticClass:"page-per-row-selector",on:{change:function(e){return t.onPaginationChanged(e)}}},[a("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),a("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),a("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),a("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),a("div",{staticClass:"paginator-controls"},[a("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),a("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[a("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),a("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[a("i",{staticClass:"fa fa-angle-right"})])])]):t._e()},[],!1,null,"19464ff6",null);e.a=n.exports},103:function(t,e,a){"use strict";var s={data:()=>({leaveBalances:[]}),mounted(){this.getUserLeaveBalances()},methods:{getUserLeaveBalances(){let t=this;axios.get("/api/user/leave-balances").then(e=>{t.leaveBalances=e.data})},getDaysAvailable:(t,e)=>t-e}},i=a(2),n=Object(i.a)(s,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"card"},[a("b-notification",{ref:"leaveBalanceCard",staticClass:"bg-white p-0",attrs:{closable:!1}},[a("div",{staticClass:"card-content"},[a("div",{staticClass:"content"},[a("h4",[t._v("My Leave Balances")]),t._v(" "),a("table",{staticClass:"table w-full"},[a("thead",{staticClass:"font-thin"},[a("tr",[a("th",[t._v("\n\t\t\t\t\t\tType\n\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\tDays Eligible\n\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\tAvailable\n\t\t\t\t\t")])])]),t._v(" "),a("tbody",t._l(t.leaveBalances,function(e){return a("tr",[a("td",[t._v(t._s(e.leaveType))]),t._v(" "),a("td",[t._v(t._s(e.elligibleDays))]),t._v(" "),a("td",[t._v(t._s(t.getDaysAvailable(e.elligibleDays,e.totalDaysApplied)))])])}),0)])])])])],1)},[],!1,null,null,null);e.a=n.exports},104:function(t,e,a){"use strict";var s=a(73).a,i=a(2),n=Object(i.a)(s,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("tr",[a("td",[t._v(t._s(t.leaveRequest.leaveType.name))]),t._v(" "),a("td",[t._v(t._s(t.leaveRequest.numberOfDays))]),t._v(" "),a("td",[t._v(t._s(t._f("dateFormat")(t.leaveRequest.startDate)))]),t._v(" "),a("td",[t._v(t._s(t._f("dateFormat")(t.leaveRequest.endDate)))]),t._v(" "),a("td",[a("span",{staticClass:"tag is-success"},[t._v("\n\t\t\t\t\t\t\t\t\t"+t._s(t.leaveRequest.leaveStatuses)+"\n\t\t\t\t\t\t\t\t\t")])]),t._v(" "),a("td",[t._v(t._s(t._f("dateFormat")(t.leaveRequest.createdAt)))]),t._v(" "),a("td",[a("b-dropdown",{attrs:{"aria-role":"list"}},[a("i",{staticClass:"fa fa-ellipsis-h text-muted",attrs:{slot:"trigger",role:"button"},slot:"trigger"}),t._v(" "),a("b-dropdown-item",{attrs:{"aria-role":"listitem"},on:{click:t.confirmLeaveWithdrawal}},[t._v("Withdraw")]),t._v(" "),a("b-dropdown-item",{attrs:{"aria-role":"listitem"}},[t._v("Edit")])],1)],1)])},[],!1,null,null,null);e.a=n.exports},117:function(t,e,a){"use strict";a.r(e);var s=a(71).a,i=a(2),n=Object(i.a)(s,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"pb-2 flex justify-end"},[a("router-link",{staticClass:"button is-primary",attrs:{to:"leave-create",tag:"button"}},[a("i",{staticClass:"fa fa-plus mr-1"}),t._v("New Requests\n\t\t")])],1),t._v(" "),a("div",{staticClass:"columns"},[a("div",{staticClass:"column is-8"},[a("div",{ref:"leaveRequests",staticClass:"card"},[a("div",{staticClass:"card-content"},[a("div",{staticClass:"content"},[a("h4",[t._v("My Leave Requests")]),t._v(" "),a("table",{staticClass:"table  is-hoverable"},[t._m(0),t._v(" "),a("tbody",t._l(t.leaveRequests,function(t){return a("UserLeaveRequestItem",{key:t.id,tag:"tr",attrs:{"leave-request":t}})}),1),t._v(" "),a("tfoot",[a("tr",[a("td",{attrs:{colspan:"7"}},[a("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])])])])])]),t._v(" "),a("div",{staticClass:"column is-4"},[a("LeaveBalanceCard")],1)])])},[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("thead",{staticClass:"font-thin"},[a("tr",[a("th",[t._v("\n\t\t\t\t\t\t\t\t\tType\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tDays\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tStart Date\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tEnd Date\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tStatus\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tDate Requested\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tAction\n\t\t\t\t\t\t\t\t")])])])}],!1,null,null,null);e.default=n.exports},71:function(t,e,a){"use strict";(function(t){var s=a(103),i=a(102),n=a(104);e.a={components:{LeaveBalanceCard:s.a,Paginator:i.a,UserLeaveRequestItem:n.a},data:()=>({loading:!1,leaveRequests:[],pageable:!1,pageSize:10,page:0}),created(){this.getUserLeaveRequests()},methods:{getUserLeaveRequests(){let t=this;const e=this.$buefy.loading.open({container:this.isFullPage?null:t.$refs.leaveRequests});axios.get("/api/user/leave-requests",{params:{pageSize:t.pageSize,page:t.page}}).then(a=>{e.close(),t.leaveRequests=a.data.content,t.pageable=a.data},t=>{e.close()})},goToPrevious(){this.page--,this.getUserLeaveRequests()},goToNext(){this.page++,this.getUserLeaveRequests()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.getUserLeaveRequests()}},filters:{dateFormat:e=>t(e).format("LL")}}}).call(this,a(69))},72:function(t,e,a){var s=a(101);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,a(11).default)("1b9d3cf4",s,!0,{})},73:function(t,e,a){"use strict";(function(t){e.a={props:{leaveRequest:{required:!0,type:Object}},methods:{confirmLeaveWithdrawal(){this.$buefy.dialog.confirm({title:"Leave Withdrawal",message:"Are you sure you want to <b>withdraw</b> this leave?",confirmText:"Withdraw",type:"is-primary",onConfirm:()=>this.withdrawLeave()})},withdrawLeave(){}},filters:{dateFormat:e=>t(e).format("LL")}}}).call(this,a(69))},74:function(t,e){function a(t){var e=new Error("Cannot find module '"+t+"'");throw e.code="MODULE_NOT_FOUND",e}a.keys=function(){return[]},a.resolve=a,t.exports=a,a.id=74}}]);