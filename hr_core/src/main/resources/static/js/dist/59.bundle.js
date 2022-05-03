(window.webpackJsonp=window.webpackJsonp||[]).push([[59],{200:function(t,a,e){var n=e(207);"string"==typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);(0,e(23).default)("c40d3914",n,!0,{})},205:function(t,a,e){"use strict";var n={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},i=(e(206),e(15)),s=Object(i.a)(n,(function(){var t=this,a=t.$createElement,e=t._self._c||a;return t.paginationData?e("div",{staticClass:"paginator"},[e("div",{staticClass:"page-per-row"},[e("label",[t._v("Records per page:")]),t._v(" "),e("select",{staticClass:"page-per-row-selector",on:{change:function(a){return t.onPaginationChanged(a)}}},[e("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),e("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),e("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),e("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),e("div",{staticClass:"paginator-controls"},[e("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),e("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[e("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),e("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[e("i",{staticClass:"fa fa-angle-right"})])])]):t._e()}),[],!1,null,"4c61e2cb",null);a.a=s.exports},206:function(t,a,e){"use strict";var n=e(200);e.n(n).a},207:function(t,a,e){(t.exports=e(22)(!1)).push([t.i,".paginator[data-v-4c61e2cb]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-4c61e2cb]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-4c61e2cb]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-4c61e2cb]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},208:function(t,a,e){"use strict";a.a={data:()=>({pageable:!1,pageSize:10,page:0}),methods:{goToPrevious(){this.page--,this.fetchRecords()},goToNext(){this.page++,this.fetchRecords()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.fetchRecords()}}}},460:function(t,a,e){"use strict";e.r(a);var n=e(205),i={mixins:[e(208).a],components:{Paginator:n.a},data:()=>({payments:[],loading:!1}),created(){this.getPayments()},methods:{fetchRecords(){this.getInvoices()},getPayments(){this.loading=!0,axios.get("api/payments",{params:{page:this.page,pageSize:this.pageSize}}).then(t=>{this.payments=t.data.contents,this.pageable=t.data,this.loading=!1},t=>{this.loading=!1})}}},s=e(15),o=Object(s.a)(i,(function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("div",{staticClass:"pb-2 flex justify-end"},[e("router-link",{staticClass:"button mr-1 is-rounded",attrs:{to:"/payments-create",tag:"button"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-plus-circle mr-1"})]),t._v(" "),e("span",[t._v("\n\t\t\t\t\t New Payment\n\t\t\t\t")])]),t._v(" "),t._m(0)],1),t._v(" "),e("div",[e("div",{staticClass:"card"},[e("div",{staticClass:"card-content"},[e("table",{staticClass:"table is-fullwidth"},[t._m(1),t._v(" "),e("tbody",t._l(t.payments,(function(a){return e("tr",[e("td",[t._v("\n                "+t._s(a.id)+"\n              ")]),t._v(" "),e("td",[t._v("\n                "+t._s(a.id)+"\n              ")]),t._v(" "),e("td",[t._v("\n                "+t._s(a.paymentDate)+"\n              ")]),t._v(" "),e("td",[t._v("\n                "+t._s(t._f("formatDate")(a.expiryDate))+"\n              ")]),t._v(" "),e("td",[t._v("\n                "+t._s(a.amount)+"\n              ")])])})),0),t._v(" "),e("tfoot",[e("tr",[e("td",{attrs:{colspan:"8"}},[e("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])])])])])])}),[function(){var t=this.$createElement,a=this._self._c||t;return a("a",{staticClass:"button is-rounded",attrs:{href:"/api/holidays/excel-report"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-download mr-1"})]),this._v(" "),a("span",[this._v("\n\t\t\t\t\t Export\n\t\t\t\t")])])},function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("thead",[e("tr",[e("th",[t._v("\n                Invoice ID\n              ")]),t._v(" "),e("th",[t._v("\n                Client\n              ")]),t._v(" "),e("th",[t._v("\n                Payment Type\n              ")]),t._v(" "),e("th",[t._v("\n                Payment Date\n              ")]),t._v(" "),e("th",[t._v("\n                Paid Amount\n              ")]),t._v(" "),e("th")])])}],!1,null,null,null);a.default=o.exports}}]);