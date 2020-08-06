(window.webpackJsonp=window.webpackJsonp||[]).push([[29],{219:function(t,a,e){"use strict";e.r(a);var i=e(83),s=e(76),n={mixins:[i.a],components:{Paginator:s.a},data:()=>({isLoading:!1,permissions:[],loading:!1}),created(){this.fetchRecords()},methods:{fetchRecords(){return this.getPermissions()},getPermissions(){let t=this;this.isLoading=!0,axios.get("/api/permissions",{params:{pageSize:t.pageSize,page:t.page}}).then(a=>{t.isLoading=!1,t.permissions=a.data.content,this.pageable=a.data,t.loading=!1},a=>{t.isLoading=!1})},exportReport(){this.$downLoadFile({requestMethod:"Get",endPoint:"/api/permissions/reports"})}}},o=e(2),r=Object(o.a)(n,function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{},[t._m(0),t._v(" "),e("div",{staticClass:"columns"},[e("div",{staticClass:"column is-12"},[e("div",{ref:"leaveRequests",staticClass:"card"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"content b-table is-relative",class:{"is-loading":t.loading}},[e("h4",[t._v("Permissions")]),t._v(" "),e("table",{staticClass:"table has-mobile-cards w-full is-hoverable"},[t._m(1),t._v(" "),e("tbody",t._l(t.permissions,function(a){return e("tr",[e("td",{attrs:{"data-label":"Name"}},[t._v(t._s(a.name))]),t._v(" "),e("td",{attrs:{"data-label":"Date"}},[t._v(t._s(a.description))])])}),0),t._v(" "),e("tfoot",[e("tr",[e("td",{attrs:{colspan:"8"}},[e("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])])])])])])]),t._v(" "),e("router-view")],1)},[function(){var t=this.$createElement,a=this._self._c||t;return a("div",{staticClass:"flex pb-2 justify-end"},[a("a",{staticClass:"button is-rounded",attrs:{href:"/api/permissions/excel-report"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-download"})]),this._v(" "),a("span",[this._v("Export")])])])},function(){var t=this.$createElement,a=this._self._c||t;return a("thead",{staticClass:"font-thin"},[a("tr",[a("th",[this._v("\n                                       Name\n                                    ")]),this._v(" "),a("th")])])}],!1,null,null,null);a.default=r.exports},71:function(t,a,e){var i=e(78);"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);(0,e(6).default)("32f0fd50",i,!0,{})},76:function(t,a,e){"use strict";var i={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},s=(e(77),e(2)),n=Object(s.a)(i,function(){var t=this,a=t.$createElement,e=t._self._c||a;return t.paginationData?e("div",{staticClass:"paginator"},[e("div",{staticClass:"page-per-row"},[e("label",[t._v("Records per page:")]),t._v(" "),e("select",{staticClass:"page-per-row-selector",on:{change:function(a){return t.onPaginationChanged(a)}}},[e("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),e("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),e("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),e("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),e("div",{staticClass:"paginator-controls"},[e("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),e("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[e("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),e("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[e("i",{staticClass:"fa fa-angle-right"})])])]):t._e()},[],!1,null,"4c61e2cb",null);a.a=n.exports},77:function(t,a,e){"use strict";var i=e(71);e.n(i).a},78:function(t,a,e){(t.exports=e(5)(!1)).push([t.i,".paginator[data-v-4c61e2cb]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-4c61e2cb]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-4c61e2cb]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-4c61e2cb]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},83:function(t,a,e){"use strict";a.a={data:()=>({pageable:!1,pageSize:10,page:0}),methods:{goToPrevious(){this.page--,this.fetchRecords()},goToNext(){this.page++,this.fetchRecords()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.fetchRecords()}}}}}]);