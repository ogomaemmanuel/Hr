(window.webpackJsonp=window.webpackJsonp||[]).push([[5],{108:function(e,t,a){"use strict";var s=a(74);a.n(s).a},109:function(e,t,a){(e.exports=a(4)(!1)).push([e.i,".date-picker-el[data-v-49b419d0]{width:100% !important}\n",""])},130:function(e,t,a){"use strict";a.r(t);var s=a(72).a,l=(a(108),a(2)),i=Object(l.a)(s,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"p-5"},[a("div",{staticClass:"columns mt-2 pl-5 pt-5 pb-5 bg-white is-size-7 "},[a("div",{staticClass:"column is-6"},[a("div",{staticClass:"field"},[a("label",{staticClass:"label is-size-7"},[e._v("Leave Types")]),e._v(" "),a("div",{staticClass:"control w-full"},[a("div",{staticClass:"select w-full"},[a("select",{directives:[{name:"model",rawName:"v-model",value:e.leaveRequest.leaveTypeId,expression:"leaveRequest.leaveTypeId"}],staticClass:"w-full",on:{input:function(t){return e.clearFieldError("leaveTypeId")},change:function(t){var a=Array.prototype.filter.call(t.target.options,function(e){return e.selected}).map(function(e){return"_value"in e?e._value:e.value});e.$set(e.leaveRequest,"leaveTypeId",t.target.multiple?a:a[0])}}},[a("option",{attrs:{value:"",disabled:"",selected:"",hidden:""}},[e._v("Select One")]),e._v(" "),e._l(e.leaveTypes,function(t){return a("option",{key:t.id,domProps:{value:t.id}},[e._v(e._s(t.name)+"\n\t\t\t\t\t\t\t")])})],2)]),e._v(" "),e.errors.leaveTypeId?a("span",{staticClass:"text-red-400"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.leaveTypeId[0])+"\n\t\t\t\t\t")]):e._e()])]),e._v(" "),a("div",{staticClass:"field"},[a("label",{staticClass:"label is-size-7"},[e._v("Start Date")]),e._v(" "),a("div",{staticClass:"control"},[a("DatePicker",{staticClass:"date-picker-el w-full",attrs:{format:"dd-MM-yyyy","picker-options":e.datePickerOptions,"value-format":"yyyy-MM-dd"},on:{input:function(t){return e.clearFieldError("startDate")}},model:{value:e.leaveRequest.startDate,callback:function(t){e.$set(e.leaveRequest,"startDate",t)},expression:"leaveRequest.startDate"}})],1),e._v(" "),e.errors.startDate?a("span",{staticClass:"text-red-400"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.startDate[0])+"\n\t\t\t\t\t")]):e._e()]),e._v(" "),a("div",{staticClass:"field"},[a("label",{staticClass:"label is-size-7"},[e._v("Number of Days")]),e._v(" "),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.leaveRequest.numberOfDays,expression:"leaveRequest.numberOfDays"}],staticClass:"input",attrs:{type:"number"},domProps:{value:e.leaveRequest.numberOfDays},on:{input:[function(t){t.target.composing||e.$set(e.leaveRequest,"numberOfDays",t.target.value)},function(t){return e.clearFieldError("numberOfDays")}]}})]),e._v(" "),e.errors.numberOfDays?a("span",{staticClass:"text-red-400"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.numberOfDays[0])+"\n\t\t\t\t")]):e._e()]),e._v(" "),a("div",{staticClass:"field"},[a("label",{staticClass:"label is-size-7"},[e._v("Employee In Place")]),e._v(" "),a("div",{staticClass:"control w-full"},[a("div",{staticClass:"select w-full"},[a("select",{directives:[{name:"model",rawName:"v-model",value:e.leaveRequest.inPlaceId,expression:"leaveRequest.inPlaceId"}],staticClass:"w-full",on:{input:function(t){return e.clearFieldError("inPlaceId")},change:function(t){var a=Array.prototype.filter.call(t.target.options,function(e){return e.selected}).map(function(e){return"_value"in e?e._value:e.value});e.$set(e.leaveRequest,"inPlaceId",t.target.multiple?a:a[0])}}},[a("option",{attrs:{value:"",disabled:"",selected:"",hidden:""}},[e._v("Select One")]),e._v(" "),e._l(e.inPlaceEmployees,function(t){return a("option",{domProps:{value:t.staffId}},[e._v("\n\t\t\t\t\t\t\t\t"+e._s(t.fullName)+"\n\t\t\t\t\t\t\t")])})],2)]),e._v(" "),e.errors.inPlaceId?a("span",{staticClass:"text-red-400"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.inPlaceId[0])+"\n\t\t\t\t")]):e._e()])]),e._v(" "),a("div",{staticClass:"field"},[a("label",{staticClass:"label is-size-7"},[e._v("Reason (Optional)")]),e._v(" "),a("div",{staticClass:"control"},[a("textarea",{directives:[{name:"model",rawName:"v-model",value:e.leaveRequest.reason,expression:"leaveRequest.reason"}],staticClass:"textarea",attrs:{placeholder:"Textarea"},domProps:{value:e.leaveRequest.reason},on:{input:[function(t){t.target.composing||e.$set(e.leaveRequest,"reason",t.target.value)},function(t){return e.clearFieldError("reason")}]}})]),e._v(" "),e.errors.reason?a("span",{staticClass:"text-red-400"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.reason[0])+"\n\t\t\t\t")]):e._e()]),e._v(" "),a("div",{staticClass:"field is-grouped"},[a("div",{staticClass:"control"},[a("button",{staticClass:"button is-primary is-small",class:{"is-loading":e.loading},on:{click:function(t){return t.preventDefault(),e.makeLeaveRequest(t)}}},[a("i",{staticClass:"fa fa-save mr-1"}),e._v("Submit\n\t\t\t\t\t")])]),e._v(" "),a("div",{staticClass:"control"},[a("button",{staticClass:"button is-light is-small",on:{click:function(t){return t.preventDefault(),e.goBack()}}},[a("i",{staticClass:"fa fa-times mr-1"}),e._v("\n\t\t\t\t\t\tCancel\n\t\t\t\t\t")])])])]),e._v(" "),e._m(0)])])},[function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"column is-6 pr-10 pl-10 pt-10 available-leave-days-card"},[t("div",{staticClass:"card"},[t("div",{staticClass:"card-content"},[t("div",{staticClass:"content"},[t("div",{staticClass:"text-center"},[t("div",{staticClass:"font-bold"},[this._v("Days Available")]),this._v(" "),t("div",{staticClass:"font-bold text-gray-500"},[this._v("17")])])])])])])}],!1,null,"49b419d0",null);t.default=i.exports},72:function(e,t,a){"use strict";(function(e){a(91),a(23);var s=a(92),l=a.n(s),i=a(12);t.a={name:"LeaveRequestForm",mixins:[i.a],components:{DatePicker:l.a},data:()=>({datePickerOptions:{disabledDate:t=>t.getTime()<Date.now()-864e5||7==e(t.getTime()).isoWeekday()||6==e(t.getTime()).isoWeekday()},leaveRequest:{leaveTypeId:"",inPlaceId:""},leaveTypes:[],inPlaceEmployees:[],errors:{},loading:!1}),created(){this.getLeaveTypes(),this.getInPlaceEmployees()},methods:{goBack(){this.$router.go(-1)},getLeaveTypes(){axios.get("/api/leave-types").then(e=>{this.leaveTypes=e.data})},makeLeaveRequest(){let e=this;e.loading=!0,axios.post("/api/leave-request",e.leaveRequest).then(t=>{e.loading=!1,200==t.status&&e.$swal({type:"success",text:"Leave Request successfully submitted"})},t=>{e.loading=!1,400==t.response.status&&(this.errors=t.response.data)})},getInPlaceEmployees(){axios.get("/api/leave-requests/in-place").then(e=>{this.inPlaceEmployees=e.data})}}}}).call(this,a(69))},73:function(e,t){function a(e){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}a.keys=function(){return[]},a.resolve=a,e.exports=a,a.id=73},74:function(e,t,a){var s=a(109);"string"==typeof s&&(s=[[e.i,s,""]]),s.locals&&(e.exports=s.locals);(0,a(5).default)("e706cd2e",s,!0,{})}}]);