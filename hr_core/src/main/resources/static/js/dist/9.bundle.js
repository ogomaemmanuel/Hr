(window.webpackJsonp=window.webpackJsonp||[]).push([[9],{171:function(t,e){function a(t){var e=new Error("Cannot find module '"+t+"'");throw e.code="MODULE_NOT_FOUND",e}a.keys=function(){return[]},a.resolve=a,t.exports=a,a.id=171},200:function(t,e,a){var s=a(207);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,a(23).default)("c40d3914",s,!0,{})},205:function(t,e,a){"use strict";var s={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},i=(a(206),a(15)),n=Object(i.a)(s,(function(){var t=this,e=t.$createElement,a=t._self._c||e;return t.paginationData?a("div",{staticClass:"paginator"},[a("div",{staticClass:"page-per-row"},[a("label",[t._v("Records per page:")]),t._v(" "),a("select",{staticClass:"page-per-row-selector",on:{change:function(e){return t.onPaginationChanged(e)}}},[a("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),a("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),a("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),a("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),a("div",{staticClass:"paginator-controls"},[a("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),a("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[a("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),a("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[a("i",{staticClass:"fa fa-angle-right"})])])]):t._e()}),[],!1,null,"4c61e2cb",null);e.a=n.exports},206:function(t,e,a){"use strict";var s=a(200);a.n(s).a},207:function(t,e,a){(t.exports=a(22)(!1)).push([t.i,".paginator[data-v-4c61e2cb]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-4c61e2cb]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-4c61e2cb]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-4c61e2cb]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},217:function(t,e,a){"use strict";var s={},i=a(15),n=Object(i.a)(s,(function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"bg-white  min-h-full p-5 flex justify-center align-center"},[e("div",[e("img",{attrs:{src:"/images/undraw_no_data_qbuo.svg",width:"200px",alt:"empty state here"}}),this._v(" "),e("div",{staticClass:"mt-3 flex flex-col justify-center has-text-grey-light"},[this._t("default")],2)])])}),[],!1,null,null,null);e.a=n.exports},245:function(t,e,a){"use strict";(function(t){var s=a(184),i=a.n(s),n=a(367),l=a(205),o=a(368),r=a(217);e.a={components:{LeaveBalanceCard:n.a,Paginator:l.a,UserLeaveRequestItem:o.a,EmptyState:r.a},data:()=>({loading:!1,leaveRequests:[],pageable:!1,pageSize:10,page:0,loaded:!1,showLeaveBalances:!1}),created(){this.getUserLeaveRequests()},methods:{getUserLeaveRequests(){let t=this;const e=this.$buefy.loading.open({container:this.isFullPage?null:t.$refs.leaveRequests});axios.get("/api/user/leave-requests",{params:{pageSize:t.pageSize,page:t.page}}).then(a=>{e.close(),t.leaveRequests=[],this.$nextTick().then((function(){var e;(e=t.leaveRequests).push.apply(e,i()(a.data.content)),t.pageable=a.data,t.loaded=!0}))},t=>{e.close()})},goToPrevious(){this.page--,this.getUserLeaveRequests()},goToNext(){this.page++,this.getUserLeaveRequests()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.getUserLeaveRequests()}},computed:{showEmptyState(){return this.loaded&&this.leaveRequests.length<=0}},filters:{dateFormat:e=>t(e).format("LL")}}}).call(this,a(170))},246:function(t,e,a){"use strict";(function(t){a(165),a(75);var s=a(166),i=a.n(s),n=a(172),l=a.n(n);function o(t,e){var a=Object.keys(t);if(Object.getOwnPropertySymbols){var s=Object.getOwnPropertySymbols(t);e&&(s=s.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),a.push.apply(a,s)}return a}e.a={props:{leaveRequest:{required:!0,type:Object}},data:()=>({leaveRequestClone:{}}),created(){this.leaveRequestClone=function(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{};e%2?o(Object(a),!0).forEach((function(e){l()(t,e,a[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(a)):o(Object(a)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(a,e))}))}return t}({},this.leaveRequest)},methods:{confirmLeaveWithdrawal(){this.$buefy.dialog.confirm({title:"Leave Withdrawal",message:"Are you sure you want to <b>withdraw</b> this leave?",confirmText:"Withdraw",type:"is-primary is-light",onConfirm:()=>this.withdrawLeave()})},goToEdit(){this.$router.push("/leave-request-edit/"+this.leaveRequestClone.id)},withdrawLeave(){axios.put("/api/user/leave-requests/withdrawal/"+this.leaveRequestClone.id).then(t=>{this.leaveRequestClone=t.data.data,i.a.success(t.data.message)},t=>{})}},filters:{dateFormat:e=>t(e).format("LL")},computed:{statusColor(){return"new"==this.leaveRequestClone.leaveStatuses.toLowerCase()?"is-primary":"withdrawn"==this.leaveRequestClone.leaveStatuses.toLowerCase()?"is-warning":void 0},disableEditOption(){return!("new"==this.leaveRequestClone.leaveStatuses.toLowerCase())},disableWithdrawOption(){return"withdrawn"==this.leaveRequestClone.leaveStatuses.toLowerCase()}}}}).call(this,a(170))},367:function(t,e,a){"use strict";var s={components:{EmptyState:a(217).a},data:()=>({loaded:!1,leaveBalances:[]}),mounted(){this.getUserLeaveBalances()},methods:{getUserLeaveBalances(){let t=this;axios.get("/api/user/leave-balances").then(e=>{t.leaveBalances=e.data,t.loaded=!0})},getDaysAvailable:(t,e)=>t-e},computed:{showEmptyState(){return this.loaded&&this.leaveBalances.length<=0}}},i=a(15),n=Object(i.a)(s,(function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t.showEmptyState?a("EmptyState"):a("div",{staticClass:"bg-white"},[t.loaded?a("b-notification",{ref:"leaveBalanceCard",staticClass:"bg-white p-0",attrs:{closable:!1}},[a("div",{staticClass:"card-content"},[a("div",{staticClass:"content"},[a("table",{staticClass:"table w-full is-hoverable"},[a("thead",{staticClass:"font-thin"},[a("tr",[a("th",[t._v("\n\t\t\t\t\t\t\t\t\tType\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tDays Eligible\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tAvailable\n\t\t\t\t\t\t\t\t")])])]),t._v(" "),a("tbody",t._l(t.leaveBalances,(function(e){return a("tr",[a("td",[t._v(t._s(e.leaveType))]),t._v(" "),a("td",[t._v(t._s(e.elligibleDays))]),t._v(" "),a("td",[t._v(t._s(t.getDaysAvailable(e.elligibleDays,e.totalDaysApplied)))])])})),0)])])])]):t._e()],1)],1)}),[],!1,null,null,null);e.a=n.exports},368:function(t,e,a){"use strict";var s=a(246).a,i=a(15),n=Object(i.a)(s,(function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("tr",[a("td",{attrs:{"data-label":"Name"}},[t._v(t._s(t.leaveRequestClone.leaveType.name))]),t._v(" "),a("td",{attrs:{"data-label":"Number of Days"}},[t._v(t._s(t.leaveRequestClone.numberOfDays))]),t._v(" "),a("td",{attrs:{"data-label":"Start Date"}},[t._v(t._s(t._f("dateFormat")(t.leaveRequestClone.startDate)))]),t._v(" "),a("td",{attrs:{"data-label":"End Date"}},[t._v(t._s(t._f("dateFormat")(t.leaveRequestClone.endDate)))]),t._v(" "),a("td",{attrs:{"data-label":"Status"}},[a("span",{staticClass:"tag  is-light",class:t.statusColor},[t._v("\n\t\t\t\t\t\t\t\t\t"+t._s(t.leaveRequestClone.leaveStatuses)+"\n\t\t\t\t\t\t\t\t\t")])]),t._v(" "),a("td",{attrs:{"data-label":"Date Requested"}},[t._v(t._s(t._f("dateFormat")(t.leaveRequestClone.createdAt)))]),t._v(" "),a("td",[a("b-dropdown",{attrs:{"aria-role":"list"}},[a("i",{staticClass:"fa fa-ellipsis-h text-muted",attrs:{slot:"trigger",role:"button"},slot:"trigger"}),t._v(" "),a("b-dropdown-item",{attrs:{disabled:t.disableWithdrawOption,value:"withdraw","aria-role":"listitem"},on:{click:t.confirmLeaveWithdrawal}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-undo"})]),t._v("\n\t\t\t\tWithdraw\n\t\t\t")]),t._v(" "),t.disableEditOption?a("b-dropdown-item",{attrs:{disabled:t.disableEditOption,value:"edit","aria-role":"listitem"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-pencil"})]),t._v("\n\t\t\t\tEdit\n\t\t\t")]):a("b-dropdown-item",{attrs:{value:"edit","aria-role":"listitem"},on:{click:t.goToEdit}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-pencil"})]),t._v("\n\t\t\t\tEdit\n\t\t\t")])],1)],1)])}),[],!1,null,null,null);e.a=n.exports},473:function(t,e,a){"use strict";a.r(e);var s=a(245).a,i=a(15),n=Object(i.a)(s,(function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"pb-2 flex justify-end"},[a("p",{staticClass:"buttons"},[a("router-link",{staticClass:"button  is-rounded",attrs:{to:"leave-create",tag:"button"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-plus-circle"})]),t._v(" "),a("span",[t._v("New Requests")])])],1)]),t._v(" "),a("div",{staticClass:"tabs is-boxed"},[a("ul",[a("li",{class:{"is-active":0==t.showLeaveBalances},on:{click:function(e){t.showLeaveBalances=!1}}},[a("a",[t._v("My Leave\n\t\t\t\tRequests")])]),t._v(" "),a("li",{class:{"is-active":1==t.showLeaveBalances},on:{click:function(e){t.showLeaveBalances=!0}}},[a("a",[t._v("My Leave\n\t\t\t\tBalances")])])])]),t._v(" "),a("div",{staticClass:"columns"},[0==t.showLeaveBalances?a("div",{staticClass:"column is-12"},[t.showEmptyState?a("EmptyState",[a("h4",{staticClass:"ml-3"},[t._v("Leave requests not found")]),t._v(" "),a("div",{staticClass:"flex justify-center"},[a("p",{staticClass:"buttons mt-5"},[a("router-link",{staticClass:"button  is-rounded",attrs:{to:"leave-create",tag:"button"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-plus-circle"})]),t._v(" "),a("span",[t._v("New Requests")])])],1)])]):a("div",{ref:"leaveRequests",staticClass:"card"},[t.loaded?a("div",{staticClass:"card-content card-simple"},[a("div",{staticClass:"content b-table"},[a("table",{staticClass:"table has-mobile-cards is-hoverable"},[a("thead",{staticClass:"font-thin"},[a("tr",[a("th",[t._v("\n\t\t\t\t\t\t\t\t\tType\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tDays\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tStart Date\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tEnd Date\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tStatus\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tDate Requested\n\t\t\t\t\t\t\t\t")]),t._v(" "),a("th",[t._v("\n\t\t\t\t\t\t\t\t\tAction\n\t\t\t\t\t\t\t\t")])])]),t._v(" "),a("tbody",t._l(t.leaveRequests,(function(t){return a("UserLeaveRequestItem",{key:t.id,tag:"tr",attrs:{"leave-request":t}})})),1),t._v(" "),a("tfoot",[a("tr",[a("td",{attrs:{colspan:"7"}},[a("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])])])]):t._e()])],1):a("div",{staticClass:"column is-12"},[a("LeaveBalanceCard")],1)]),t._v(" "),a("router-view",{on:{leaveUpdateSuccessful:t.getUserLeaveRequests,leaveRequestSuccessful:t.getUserLeaveRequests}})],1)}),[],!1,null,"27dbbe92",null);e.default=n.exports}}]);