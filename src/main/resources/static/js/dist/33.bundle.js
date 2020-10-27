(window.webpackJsonp=window.webpackJsonp||[]).push([[33],{381:function(t,a,s){var e=s(388);"string"==typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);(0,s(10).default)("c40d3914",e,!0,{})},386:function(t,a,s){"use strict";var e={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},i=(s(387),s(6)),n=Object(i.a)(e,(function(){var t=this,a=t.$createElement,s=t._self._c||a;return t.paginationData?s("div",{staticClass:"paginator"},[s("div",{staticClass:"page-per-row"},[s("label",[t._v("Records per page:")]),t._v(" "),s("select",{staticClass:"page-per-row-selector",on:{change:function(a){return t.onPaginationChanged(a)}}},[s("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),s("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),s("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),s("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),s("div",{staticClass:"paginator-controls"},[s("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),s("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[s("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),s("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[s("i",{staticClass:"fa fa-angle-right"})])])]):t._e()}),[],!1,null,"4c61e2cb",null);a.a=n.exports},387:function(t,a,s){"use strict";var e=s(381);s.n(e).a},388:function(t,a,s){(t.exports=s(9)(!1)).push([t.i,".paginator[data-v-4c61e2cb]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-4c61e2cb]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-4c61e2cb]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-4c61e2cb]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},389:function(t,a,s){"use strict";a.a={data:()=>({pageable:!1,pageSize:10,page:0}),methods:{goToPrevious(){this.page--,this.fetchRecords()},goToNext(){this.page++,this.fetchRecords()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.fetchRecords()}}}},502:function(t,a,s){"use strict";s.r(a);var e=s(389),i=s(386),n={mixins:[e.a],components:{Paginator:i.a},data:()=>({isLoading:!1,users:[],loading:!1}),created(){this.fetchRecords()},methods:{fetchRecords(){return this.getUsers()},getUsers(){let t=this;this.isLoading=!0,axios.get("/api/users",{params:{pageSize:t.pageSize,page:t.page}}).then(a=>{t.isLoading=!1,t.users=a.data.content,this.pageable=a.data,t.loading=!1},a=>{t.isLoading=!1})},exportReport(){this.$downLoadFile({requestMethod:"Get",endPoint:"/api/users/reports"})}}},o=s(6),r=Object(o.a)(n,(function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"h-full"},[s("div",{staticClass:"flex pb-2 justify-end"},[s("router-link",{staticClass:"button mr-1 is-rounded",attrs:{tag:"button",to:"/users-create"}},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-plus-circle"})]),t._v(" "),s("span",[t._v(" Add Users")])]),t._v(" "),s("button",{staticClass:"button is-rounded",on:{click:t.exportReport}},[t._m(0),t._v(" "),s("span",[t._v(" Export")])])],1),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column is-12"},[s("div",{ref:"leaveRequests",staticClass:"card"},[s("div",{staticClass:"card-content"},[s("div",{staticClass:"content b-table is-relative",class:{"is-loading":t.loading}},[s("h4",[t._v("Users")]),t._v(" "),s("table",{staticClass:"table has-mobile-cards w-full is-hoverable"},[t._m(1),t._v(" "),s("tbody",t._l(t.users,(function(a){return s("tr",[s("td",{attrs:{"data-label":"Name"}},[t._v(t._s(a.firstName))]),t._v(" "),s("td",{attrs:{"data-label":"Date"}},[t._v(t._s(a.lastName))]),t._v(" "),s("td",{attrs:{"data-label":"Date"}},[t._v(t._s(a.email))]),t._v(" "),s("td",{attrs:{"data-label":"Action"}},[s("div",{staticClass:"action-controls d-flex justify-end"},[s("router-link",{staticClass:"button is-white is-small",attrs:{to:"/users-edit/"+a.id,tag:"button"}},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-pencil-square-o has-text-primary"})])]),t._v(" "),t._m(2,!0),t._v(" "),t._m(3,!0)],1)])])})),0),t._v(" "),s("tfoot",[s("tr",[s("td",{attrs:{colspan:"8"}},[s("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])])])])])])]),t._v(" "),s("router-view",{on:{userUpdated:function(a){return t.getUsers()},userUCreated:function(a){return t.getUsers()}}})],1)}),[function(){var t=this.$createElement,a=this._self._c||t;return a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-download"})])},function(){var t=this.$createElement,a=this._self._c||t;return a("thead",{staticClass:"font-thin"},[a("tr",[a("th",[this._v("\n                                        First Name\n                                    ")]),this._v(" "),a("th",[this._v("\n                                        Last Name\n                                    ")]),this._v(" "),a("th",[this._v("\n                                        Email\n                                    ")]),this._v(" "),a("th")])])},function(){var t=this.$createElement,a=this._self._c||t;return a("button",{staticClass:"button is-white is-small"},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-trash-o has-text-danger"})])])},function(){var t=this.$createElement,a=this._self._c||t;return a("button",{staticClass:"button is-white is-small"},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-users has-text-primary"})])])}],!1,null,null,null);a.default=r.exports}}]);