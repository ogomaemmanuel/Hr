(window.webpackJsonp=window.webpackJsonp||[]).push([[11],{141:function(t,e,a){"use strict";a.r(e);var s={props:{leaveType:{required:!0}},methods:{confirmRemove(){this.$buefy.dialog.confirm({title:"Delete Leave Type",message:`Are you sure want to delete <b> ${this.leaveType.name}</b> leave type`,onConfirm:()=>this.removeLeaveType()})},removeLeaveType(){axios.delete(`/api/leave-types/${this.leaveType.id}`).then(t=>{this.$swal({text:"Leave type successfully removed",type:"success"}),this.$emit("leaveTypeRemoveSuccessful")})}}},i=a(2),n={mixins:[{data:()=>({pageable:!1,pageSize:10,page:0}),methods:{goToPrevious(){this.page--,this.fetchRecords()},goToNext(){this.page++,this.fetchRecords()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.fetchRecords()}}}],components:{LeaveTypeItem:Object(i.a)(s,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("tr",[a("td",{attrs:{"data-label":"Name"}},[a("div",{staticClass:"has-text-primary"},[t._v("\n\t\t\t"+t._s(t.leaveType.name)+"\n\t\t")])]),t._v(" "),a("td",{attrs:{"data-label":"Number of Days"}},[t._v("\n\t\t"+t._s(t.leaveType.numberOfDays)+"\n\t")]),t._v(" "),a("td",{attrs:{"data-label":"Action"}},[a("div",{staticClass:"action-controls d-flex justify-end"},[a("router-link",{staticClass:"button is-white is-small",attrs:{to:"/leave-type-edit/"+t.leaveType.id,tag:"button"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-pencil-square-o has-text-primary"})])]),t._v(" "),a("button",{staticClass:"button is-white is-small",on:{click:t.confirmRemove}},[t._m(0)])],1)])])},[function(){var t=this.$createElement,e=this._self._c||t;return e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-trash-o has-text-danger"})])}],!1,null,null,null).exports,Paginator:a(76).a},data:()=>({leaveTypes:[]}),created(){this.fetchRecords()},methods:{getLeaveTypes(){let t={page:this.page,pageSize:this.pageSize};axios.get("/api/leave-types/paged",{params:t}).then(t=>{this.leaveTypes=t.data.content,this.pageable=t.data})},fetchRecords(){this.getLeaveTypes()}}},o=Object(i.a)(n,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"flex  justify-end  mb-5"},[a("div",{staticClass:"columns"},[a("div",{staticClass:"column is-flex justify-end"},[a("router-link",{staticClass:"button mr-1 is-small is-rounded",attrs:{to:"/leave-type-create"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-plus-circle"})]),t._v(" "),a("span",[t._v("\n\t\t\t\t\t\t\tAdd New\n\t\t\t\t\t\t")])]),t._v(" "),t._m(0)],1)])]),t._v(" "),a("div",{staticClass:"mt-5 b-table bg-white p-5 is-size-7 is-full"},[a("table",{staticClass:"table has-mobile-cards is-hoverable  w-full"},[t._m(1),t._v(" "),a("tbody",t._l(t.leaveTypes,function(e){return a("LeaveTypeItem",{tag:"tr",attrs:{leaveType:e},on:{leaveTypeRemoveSuccessful:t.getLeaveTypes}})}),1),t._v(" "),a("tfoot",[a("tr",[a("td",{attrs:{colspan:"8"}},[a("Paginator",{attrs:{paginationData:t.pageable},on:{previousPage:t.goToPrevious,nextPage:t.goToNext,paginationChanged:t.onPaginationChanged}})],1)])])])]),t._v(" "),a("router-view",{on:{leaveUpdateSuccessful:t.getLeaveTypes,holidayCreateSuccessful:t.getLeaveTypes}})],1)},[function(){var t=this.$createElement,e=this._self._c||t;return e("a",{staticClass:"button is-small is-rounded",attrs:{href:"/api/leave-types/excel-report"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-download"})]),this._v(" "),e("span",[this._v("\n\t\t\t\tExport All\n\t\t\t")])])},function(){var t=this.$createElement,e=this._self._c||t;return e("thead",[e("tr",[e("th",[this._v("Name")]),this._v(" "),e("th",[this._v("Number of Days")]),this._v(" "),e("th",[this._v("Action")])])])}],!1,null,"25961476",null);e.default=o.exports},69:function(t,e,a){var s=a(74);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,a(5).default)("32f0fd50",s,!0,{})},73:function(t,e,a){"use strict";var s=a(69);a.n(s).a},74:function(t,e,a){(t.exports=a(4)(!1)).push([t.i,".paginator[data-v-4c61e2cb]{min-width:100%;display:flex;align-items:center;justify-content:flex-end}.paginator .page-per-row[data-v-4c61e2cb]{margin-right:10px}.paginator .page-per-row .page-per-row-selector[data-v-4c61e2cb]{height:35px;border-style:none;outline:none}.paginator .paginator-controls button[data-v-4c61e2cb]{border-radius:50px;display:inline-flex;width:35px;align-items:center;justify-content:center;height:35px;border-style:none;outline:none}\n",""])},76:function(t,e,a){"use strict";var s={props:{paginationData:{default:!1}},data:()=>({}),methods:{goToNext(){this.$emit("nextPage")},goToPrevious(){this.$emit("previousPage")},onPaginationChanged(t){this.$emit("paginationChanged",Number(t.target.value))}},computed:{numberOfElements(){if(this.paginationData)return this.paginationData.last?this.paginationData.totalElements:this.paginationData.first?this.paginationData.numberOfElements:(this.paginationData.number+1)*this.paginationData.size},pageNumber(){if(this.paginationData)return 0==this.paginationData.totalPages?0:this.paginationData.last?(this.paginationData.totalPages-1)*this.paginationData.size+1:this.paginationData.number*this.paginationData.size+1}}},i=(a(73),a(2)),n=Object(i.a)(s,function(){var t=this,e=t.$createElement,a=t._self._c||e;return t.paginationData?a("div",{staticClass:"paginator"},[a("div",{staticClass:"page-per-row"},[a("label",[t._v("Records per page:")]),t._v(" "),a("select",{staticClass:"page-per-row-selector",on:{change:function(e){return t.onPaginationChanged(e)}}},[a("option",{attrs:{value:"10"}},[t._v("10")]),t._v(" "),a("option",{attrs:{value:"25"}},[t._v("25")]),t._v(" "),a("option",{attrs:{value:"50"}},[t._v("50")]),t._v(" "),a("option",{attrs:{value:"100"}},[t._v("100")])])]),t._v(" "),a("div",{staticClass:"paginator-controls"},[a("label",[t._v(t._s(t.pageNumber)+" - "+t._s(t.numberOfElements)+" of "+t._s(t.paginationData.totalElements))]),t._v(" "),a("button",{staticClass:"previous",attrs:{disabled:t.paginationData.first},on:{click:t.goToPrevious}},[a("i",{staticClass:"fa fa-angle-left"})]),t._v(" "),a("button",{staticClass:"next",attrs:{disabled:t.paginationData.last},on:{click:t.goToNext}},[a("i",{staticClass:"fa fa-angle-right"})])])]):t._e()},[],!1,null,"4c61e2cb",null);e.a=n.exports}}]);