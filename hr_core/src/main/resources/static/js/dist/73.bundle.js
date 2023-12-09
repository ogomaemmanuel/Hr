(window.webpackJsonp=window.webpackJsonp||[]).push([[73],{365:function(t,a,n){var i=n(368);i.__esModule&&(i=i.default),"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);(0,n(22).default)("70f2b8ba",i,!1,{})},366:function(t,a,n){"use strict";var i=function(){var t=this,a=t._self._c;return t.paginationData?a("div",{staticClass:"paginator"},[a("div",{staticClass:"page-per-row"},[a("label",[t._v("Records per page:")]),t._v(" "),a("select",{staticClass:"page-per-row-selector",on:{change:function(a){return t.onPaginationChanged(a)}}},[a("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),a("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),a("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),a("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),a("div",{staticClass:"paginator-controls"},[a("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),a("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[a("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),a("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[a("i",{staticClass:"fa fa-angle-right"})])])]):t._e()};i._withStripped=!0;var e={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},s=(n(367),n(15)),o=Object(s.a)(e,i,[],!1,null,"248be8a4",null);a.a=o.exports},367:function(t,a,n){"use strict";n(365)},368:function(t,a,n){(t.exports=n(21)(!1)).push([t.i,".paginator[data-v-248be8a4]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-248be8a4]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-248be8a4]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-248be8a4]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}",""])},369:function(t,a,n){"use strict";a.a={data:()=>({pageable:!1,pageSize:10,page:0}),methods:{goToPrevious(){this.page--,this.fetchRecords()},goToNext(){this.page++,this.fetchRecords()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.fetchRecords()}}}},688:function(t,a,n){"use strict";n.r(a);var i=function(){var t=this,a=t._self._c;return a("div",[a("div",{staticClass:"pb-2 flex justify-end"},[a("router-link",{staticClass:"button mr-1 is-rounded",attrs:{to:"/payments-create",tag:"button"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-plus-circle mr-1"})]),t._v(" "),a("span",[t._v("\n\t\t\t\t\t New Payment\n\t\t\t\t")])]),t._v(" "),t._m(0)],1),t._v(" "),a("div",[a("div",{staticClass:"card"},[a("div",{staticClass:"card-content"},[a("table",{staticClass:"table is-fullwidth"},[t._m(1),t._v(" "),a("tbody",t._l(t.payments,(function(n){return a("tr",[a("td",[t._v("\n                "+t._s(n.id)+"\n              ")]),t._v(" "),a("td",[t._v("\n                "+t._s(n.id)+"\n              ")]),t._v(" "),a("td",[t._v("\n                "+t._s(n.paymentDate)+"\n              ")]),t._v(" "),a("td",[t._v("\n                "+t._s(t._f("formatDate")(n.expiryDate))+"\n              ")]),t._v(" "),a("td",[t._v("\n                "+t._s(n.amount)+"\n              ")])])})),0),t._v(" "),a("tfoot",[a("tr",[a("td",{attrs:{colspan:"8"}},[a("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])])])])])])};i._withStripped=!0;var e=n(366),s={mixins:[n(369).a],components:{Paginator:e.a},data:()=>({payments:[],loading:!1}),created(){this.getPayments()},methods:{fetchRecords(){this.getInvoices()},getPayments(){this.loading=!0,axios.get("api/payments",{params:{page:this.page,pageSize:this.pageSize}}).then(t=>{this.payments=t.data.contents,this.pageable=t.data,this.loading=!1},t=>{this.loading=!1})}}},o=n(15),r=Object(o.a)(s,i,[function(){var t=this._self._c;return t("a",{staticClass:"button is-rounded",attrs:{href:"/api/holidays/excel-report"}},[t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-download mr-1"})]),this._v(" "),t("span",[this._v("\n\t\t\t\t\t Export\n\t\t\t\t")])])},function(){var t=this,a=t._self._c;return a("thead",[a("tr",[a("th",[t._v("\n                Invoice ID\n              ")]),t._v(" "),a("th",[t._v("\n                Client\n              ")]),t._v(" "),a("th",[t._v("\n                Payment Type\n              ")]),t._v(" "),a("th",[t._v("\n                Payment Date\n              ")]),t._v(" "),a("th",[t._v("\n                Paid Amount\n              ")]),t._v(" "),a("th")])])}],!1,null,null,null);a.default=r.exports}}]);