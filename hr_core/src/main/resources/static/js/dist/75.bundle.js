(window.webpackJsonp=window.webpackJsonp||[]).push([[75],{365:function(t,a,e){var s=e(368);s.__esModule&&(s=s.default),"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,e(22).default)("70f2b8ba",s,!1,{})},366:function(t,a,e){"use strict";var s=function(){var t=this,a=t._self._c;return t.paginationData?a("div",{staticClass:"paginator"},[a("div",{staticClass:"page-per-row"},[a("label",[t._v("Records per page:")]),t._v(" "),a("select",{staticClass:"page-per-row-selector",on:{change:function(a){return t.onPaginationChanged(a)}}},[a("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),a("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),a("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),a("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),a("div",{staticClass:"paginator-controls"},[a("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),a("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[a("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),a("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[a("i",{staticClass:"fa fa-angle-right"})])])]):t._e()};s._withStripped=!0;var i={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},n=(e(367),e(15)),o=Object(n.a)(i,s,[],!1,null,"248be8a4",null);a.a=o.exports},367:function(t,a,e){"use strict";e(365)},368:function(t,a,e){(t.exports=e(21)(!1)).push([t.i,".paginator[data-v-248be8a4]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-248be8a4]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-248be8a4]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-248be8a4]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}",""])},369:function(t,a,e){"use strict";a.a={data:()=>({pageable:!1,pageSize:10,page:0}),methods:{goToPrevious(){this.page--,this.fetchRecords()},goToNext(){this.page++,this.fetchRecords()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.fetchRecords()}}}},679:function(t,a,e){"use strict";e.r(a);var s=function(){var t=this,a=t._self._c;return a("div",[a("div",{staticClass:"pb-2 flex justify-end"},[a("router-link",{staticClass:"button mr-1 is-rounded",attrs:{to:"/tax-create",tag:"button"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-plus-circle mr-1"})]),t._v(" "),a("span",[t._v("\n\t\t\t\t\t Add Tax\n\t\t\t\t")])]),t._v(" "),t._m(0)],1),t._v(" "),a("div",{staticClass:"columns"},[a("div",{staticClass:"column is-12"},[a("div",{ref:"leaveRequests",staticClass:"card"},[a("div",{staticClass:"card-content"},[a("div",{staticClass:"content b-table is-relative"},[a("h4",[t._v("Taxes")]),t._v(" "),a("table",{staticClass:"table has-mobile-cards w-full is-hoverable"},[t._m(1),t._v(" "),a("tbody",t._l(t.taxes,(function(e){return a("tr",{key:e.id},[a("td",{attrs:{"data-label":"Name"}},[t._v(t._s(e.name))]),t._v(" "),a("td",{attrs:{"data-label":"Date"}},[t._v(t._s(e.percentageAmount))]),t._v(" "),a("td",{attrs:{"data-label":"Description"}},[t._v(t._s(e.name))]),t._v(" "),a("td",{attrs:{"data-label":"Action"}},[a("div",{staticClass:"action-controls d-flex justify-end"},[a("router-link",{staticClass:"button is-white is-small",attrs:{to:"/tax-edit/"+e.id,tag:"button"},on:{click:function(t){}}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-pencil-square-o has-text-primary"})])]),t._v(" "),a("button",{staticClass:"button is-white is-small",on:{click:function(a){return t.confirmRemoveTax(e)}}},[t._m(2,!0)])],1)])])})),0),t._v(" "),a("tfoot",[a("tr",[a("td",{attrs:{colspan:"8"}},[a("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])]),t._v(" "),a("b-loading",{attrs:{"is-full-page":!1,active:t.loading,"can-cancel":!0},on:{"update:active":function(a){t.loading=a}}})],1)])])])]),t._v(" "),a("router-view",{on:{updateSuccessful:t.onUpdateSuccessful,createSuccessful:t.onCreateSuccessful}})],1)};s._withStripped=!0;e(186),e(83);var i=e(187),n=e.n(i),o=e(366),r=e(369),l={components:{Paginator:o.a},mixins:[r.a],data:()=>({loading:!1,taxes:[]}),created(){this.getTaxes()},methods:{confirmRemoveTax(t){this.$buefy.dialog.confirm({title:"Remove Tax",message:`Are you sure want to remove <b> ${t.name}</b>`,onConfirm:()=>this.removeTax(t)})},fetchRecords(){this.getTaxes()},getTaxes(){axios.get("/api/taxes",{params:{page:this.page,pageSize:this.pageSize}}).then(t=>{this.loading=!1,this.taxes=t.data.content,this.pageable=t.data},t=>{this.loading=!1})},onCreateSuccessful(){this.getTaxes()},onUpdateSuccessful(){console.log("onUpdateSuccessful getTaxes"),this.getTaxes()},removeTax(t){axios.delete("/api/taxes/"+t.id).then(t=>{n.a.success("Tax successfully removed"),this.getTaxes()})}}},c=e(15),u=Object(c.a)(l,s,[function(){var t=this._self._c;return t("a",{staticClass:"button is-rounded",attrs:{href:"/api/holidays/excel-report"}},[t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-download mr-1"})]),this._v(" "),t("span",[this._v("\n\t\t\t\t\t Export\n\t\t\t\t")])])},function(){var t=this._self._c;return t("thead",{staticClass:"font-thin"},[t("tr",[t("th",[this._v("\n                    Tax Name\n                  ")]),this._v(" "),t("th",[this._v("\n                    Tax Percentage (%)\n                  ")]),this._v(" "),t("th",[this._v("\n                    Status\n                  ")]),this._v(" "),t("th",[this._v("\n                    Action\n                  ")])])])},function(){var t=this._self._c;return t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-trash-o has-text-danger"})])}],!1,null,null,null);a.default=u.exports}}]);