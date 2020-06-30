(window.webpackJsonp=window.webpackJsonp||[]).push([[16],{189:function(t,a,e){"use strict";e.r(a);var s=e(83),i=e(72),n={mixins:[s.a],components:{Paginator:i.a},data:()=>({roles:[],loading:!1}),created(){this.fetchRecords()},methods:{fetchRecords(){return this.getRoles()},confirmRemoveRole(t){this.$buefy.dialog.confirm({title:"Remove Role",message:`Are you sure want to remove <b> ${t.name}</b> from roles`,onConfirm:()=>this.removeRole(t)})},removeRole(t){axios.delete(`/api/roles/${t.id}`).then(t=>{this.$swal({type:"success",title:"Success",message:"Department successfully removed"}),this.getRoles()})},onRoleCreateSuccessful(){},onRoleUpdateSuccessful(){},getRoles(){let t=this;t.loading=!0,axios.get("api/roles-paged",{params:{pageSize:t.pageSize,page:t.page}}).then(a=>{this.roles=a.data.content,this.pageable=a.data,t.loading=!1},a=>{t.loading=!1})}}},o=e(2),r=Object(o.a)(n,function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("div",{staticClass:"pb-2 flex justify-end"},[e("router-link",{staticClass:"button mr-1 is-rounded",attrs:{to:"/role-create",tag:"button"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-plus-circle mr-1"})]),t._v(" "),e("span",[t._v("\n\t\t\t\t Add Role\n\t\t\t")])]),t._v(" "),t._m(0)],1),t._v(" "),e("div",{staticClass:"columns"},[e("div",{staticClass:"column is-12"},[e("div",{ref:"leaveRequests",staticClass:"card"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"content b-table is-relative",class:{"is-loading":t.loading}},[e("h4",[t._v("Roles")]),t._v(" "),e("table",{staticClass:"table has-mobile-cards w-full is-hoverable"},[t._m(1),t._v(" "),e("tbody",t._l(t.roles,function(a){return e("tr",[e("td",{attrs:{"data-label":"Name"}},[t._v(t._s(a.name))]),t._v(" "),e("td",{attrs:{"data-label":"Date"}},[t._v(t._s(a.description))]),t._v(" "),e("td",{attrs:{"data-label":"Action"}},[e("div",{staticClass:"action-controls d-flex justify-end"},[e("router-link",{staticClass:"button is-white is-small",attrs:{to:"/role-edit/"+a.id,tag:"button"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-pencil-square-o has-text-primary"})])]),t._v(" "),e("button",{staticClass:"button is-white is-small",on:{click:function(e){return t.confirmRemoveRole(a)}}},[t._m(2,!0)])],1)])])}),0),t._v(" "),e("tfoot",[e("tr",[e("td",{attrs:{colspan:"8"}},[e("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])])])])])])]),t._v(" "),e("router-view",{on:{roleCreateSuccessful:t.onRoleCreateSuccessful,roleUpdateSuccessful:t.onRoleUpdateSuccessful}})],1)},[function(){var t=this.$createElement,a=this._self._c||t;return a("a",{staticClass:"button is-rounded",attrs:{href:"/api/holidays/excel-report"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-download mr-1"})]),this._v(" "),a("span",[this._v("\n\t\t\t\t Export\n\t\t\t")])])},function(){var t=this.$createElement,a=this._self._c||t;return a("thead",{staticClass:"font-thin"},[a("tr",[a("th",[this._v("\n\t\t\t\t\t\t\t\t\tName\n\t\t\t\t\t\t\t\t")]),this._v(" "),a("th",[this._v("\n\t\t\t\t\t\t\t\t\tDescription\n\t\t\t\t\t\t\t\t")]),this._v(" "),a("th",[this._v("\n\t\t\t\t\t\t\t\t\tAction\n\t\t\t\t\t\t\t\t")])])])},function(){var t=this.$createElement,a=this._self._c||t;return a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-trash-o has-text-danger"})])}],!1,null,"663e3c3c",null);a.default=r.exports},69:function(t,a,e){var s=e(74);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,e(6).default)("32f0fd50",s,!0,{})},72:function(t,a,e){"use strict";var s={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},i=(e(73),e(2)),n=Object(i.a)(s,function(){var t=this,a=t.$createElement,e=t._self._c||a;return t.paginationData?e("div",{staticClass:"paginator"},[e("div",{staticClass:"page-per-row"},[e("label",[t._v("Records per page:")]),t._v(" "),e("select",{staticClass:"page-per-row-selector",on:{change:function(a){return t.onPaginationChanged(a)}}},[e("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),e("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),e("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),e("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),e("div",{staticClass:"paginator-controls"},[e("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),e("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[e("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),e("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[e("i",{staticClass:"fa fa-angle-right"})])])]):t._e()},[],!1,null,"4c61e2cb",null);a.a=n.exports},73:function(t,a,e){"use strict";var s=e(69);e.n(s).a},74:function(t,a,e){(t.exports=e(5)(!1)).push([t.i,".paginator[data-v-4c61e2cb]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-4c61e2cb]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-4c61e2cb]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-4c61e2cb]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},83:function(t,a,e){"use strict";a.a={data:()=>({pageable:!1,pageSize:10,page:0}),methods:{goToPrevious(){this.page--,this.fetchRecords()},goToNext(){this.page++,this.fetchRecords()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.fetchRecords()}}}}}]);