(window.webpackJsonp=window.webpackJsonp||[]).push([[7],{425:function(e,t){function s(e){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}s.keys=function(){return[]},s.resolve=s,e.exports=s,s.id=425},449:function(e,t,s){var a=s(454);"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);(0,s(28).default)("6a4b444c",a,!0,{})},451:function(e,t,s){"use strict";var a={mixins:[s(452).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},l=(s(453),s(21)),n=Object(l.a)(a,(function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{ref:"modal",staticClass:"modal"},[s("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":e.width+"px",overflow:e.overflow}},[s("div",{staticClass:"box"},[e._t("modal-content")],2)]),e._v(" "),e.showCloseButton?[s("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(t){return t.stopPropagation(),e.closeModal(t)}}})]:e._e()],2)}),[],!1,null,"c09ee790",null);t.a=n.exports},452:function(e,t,s){"use strict";(function(e){t.a={methods:{closeModal(){e(this.$refs.modalContent).toggleClass("scaleIn"),e(this.$refs.modalClose).toggleClass("is-hidden"),e(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){e(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(82))},453:function(e,t,s){"use strict";var a=s(449);s.n(a).a},454:function(e,t,s){(e.exports=s(27)(!1)).push([e.i,".modal[data-v-c09ee790]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-c09ee790]{overflow:visible}\n",""])},484:function(e,t,s){"use strict";(function(e){s(421),s(83);var a=s(422),l=s.n(a),n=s(42);t.a={name:"LeaveRequestForm",mixins:[n.a],components:{DatePicker:l.a},data:()=>({datePickerOptions:{disabledDate:t=>t.getTime()<Date.now()-864e5||7==e(t.getTime()).isoWeekday()||6==e(t.getTime()).isoWeekday()},leaveRequest:{leaveTypeId:"",inPlaceId:"",startDate:"",endDate:""},leaveTypes:[],inPlaceEmployees:[],remainingLeaveDays:"",errors:{},loading:!1}),created(){this.getLeaveTypes(),this.getInPlaceEmployees()},methods:{goBack(){this.$router.go(-1)},getLeaveBalanceByLeaveTypeId(e){axios.get("/api/user/leave-balances/"+e).then(e=>{this.remainingLeaveDays=e.data})},getLeaveTypes(){axios.get("/api/leave-types").then(e=>{this.leaveTypes=e.data})},makeLeaveRequest(){let e=this;e.loading=!0,axios.post("/api/leave-request",e.leaveRequest).then(t=>{e.loading=!1,200==t.status&&(e.$swal({type:"success",text:"Leave Request successfully submitted"}),this.$emit("leaveRequestSuccessful"))},t=>{e.loading=!1,400==t.response.status&&(this.errors=t.response.data)})},getInPlaceEmployees(){axios.get("/api/leave-requests/in-place").then(e=>{this.inPlaceEmployees=e.data})}},computed:{numberOfDays(){let t=this,s=this.leaveRequest.startDate,a=this.leaveRequest.endDate;if(s&&a){let l=e(a).diff(s,"days");return t.leaveRequest.numberOfDays=l,l}return t.leaveRequest.numberOfDays=0,0}},watch:{numberOfDays:function(e){this.clearFieldError("numberOfDays")},"leaveRequest.leaveTypeId":function(e){this.getLeaveBalanceByLeaveTypeId(e)}}}}).call(this,s(423))},485:function(e,t,s){var a=s(537);"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);(0,s(28).default)("89b809d8",a,!0,{})},536:function(e,t,s){"use strict";var a=s(485);s.n(a).a},537:function(e,t,s){(e.exports=s(27)(!1)).push([e.i,".date-picker-el[data-v-44654b4a]{width:100% !important}\n",""])},573:function(e,t,s){"use strict";s.r(t);var a=s(451),l=s(484).a,n=(s(536),s(21)),i=Object(n.a)(l,(function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("form",[e._m(0),e._v(" "),s("div",{staticClass:"field"},[e._m(1),e._v(" "),s("div",{staticClass:"control w-full"},[s("div",{staticClass:"select w-full"},[s("select",{directives:[{name:"model",rawName:"v-model",value:e.leaveRequest.leaveTypeId,expression:"leaveRequest.leaveTypeId"}],staticClass:"w-full",on:{input:function(t){return e.clearFieldError("leaveTypeId")},change:function(t){var s=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){return"_value"in e?e._value:e.value}));e.$set(e.leaveRequest,"leaveTypeId",t.target.multiple?s:s[0])}}},[s("option",{attrs:{value:"",disabled:"",selected:"",hidden:""}},[e._v("Select One")]),e._v(" "),e._l(e.leaveTypes,(function(t){return s("option",{key:t.id,domProps:{value:t.id}},[e._v(e._s(t.name)+"\n\t\t\t\t\t")])}))],2)]),e._v(" "),e.errors.leaveTypeId?s("span",{staticClass:"text-red-400"},[e._v("\n\t\t\t\t\t\t"+e._s(e.errors.leaveTypeId[0])+"\n\t\t\t\t\t")]):e._e()])]),e._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[e._m(2),e._v(" "),s("div",{staticClass:"control"},[s("DatePicker",{staticClass:"min-w-full",attrs:{format:"dd-MM-yyyy","value-format":"yyyy-MM-dd","picker-options":e.datePickerOptions},on:{input:function(t){return e.clearFieldError("startDate")}},model:{value:e.leaveRequest.startDate,callback:function(t){e.$set(e.leaveRequest,"startDate",t)},expression:"leaveRequest.startDate"}}),e._v(" "),e.errors.startDate?s("span",{staticClass:"text-red-400"},[e._v("\n\t\t\t\t\t\t\t"+e._s(e.errors.startDate[0])+"\n\t\t\t\t\t\t")]):e._e()],1)])]),e._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[e._m(3),e._v(" "),s("div",{staticClass:"control"},[s("DatePicker",{staticClass:"min-w-full",attrs:{format:"dd-MM-yyyy","value-format":"yyyy-MM-dd"},on:{input:function(t){return e.clearFieldError("endDate")}},model:{value:e.leaveRequest.endDate,callback:function(t){e.$set(e.leaveRequest,"endDate",t)},expression:"leaveRequest.endDate"}}),e._v(" "),e.errors.endDate?s("span",{staticClass:"text-red-400"},[e._v("\n\t\t\t\t\t\t\t"+e._s(e.errors.endDate[0])+"\n\t\t\t\t\t")]):e._e()],1)])])]),e._v(" "),s("div",{staticClass:"field"},[s("label",{staticClass:"label"},[e._v("Employee In Place")]),e._v(" "),s("div",{staticClass:"control w-full"},[s("div",{staticClass:"select w-full"},[s("select",{directives:[{name:"model",rawName:"v-model",value:e.leaveRequest.inPlaceId,expression:"leaveRequest.inPlaceId"}],staticClass:"w-full",on:{input:function(t){return e.clearFieldError("inPlaceId")},change:function(t){var s=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){return"_value"in e?e._value:e.value}));e.$set(e.leaveRequest,"inPlaceId",t.target.multiple?s:s[0])}}},[s("option",{attrs:{value:"",disabled:"",selected:"",hidden:""}},[e._v("Select One")]),e._v(" "),e._l(e.inPlaceEmployees,(function(t){return s("option",{domProps:{value:t.staffId}},[e._v("\n\t\t\t\t\t\t"+e._s(t.fullName)+"\n\t\t\t\t\t")])}))],2)]),e._v(" "),e.errors.inPlaceId?s("span",{staticClass:"text-red-400"},[e._v("\n\t\t\t\t\t\t\t\t"+e._s(e.errors.inPlaceId[0])+"\n\t\t\t\t\t\t")]):e._e()])]),e._v(" "),s("div",{staticClass:"field"},[e._m(4),e._v(" "),s("div",{staticClass:"control"},[s("input",{staticClass:"input",attrs:{disabled:"",type:"text"},domProps:{value:e.numberOfDays},on:{change:function(t){return e.clearFieldError("numberOfDays")}}}),e._v(" "),e.errors.numberOfDays?s("span",{staticClass:"text-red-400"},[e._v("\n\t\t\t\t"+e._s(e.errors.numberOfDays[0])+"\n\t\t\t")]):e._e()])]),e._v(" "),s("div",{staticClass:"field"},[e._m(5),e._v(" "),s("div",{staticClass:"control"},[s("input",{staticClass:"input",attrs:{disabled:"",type:"text"},domProps:{value:e.remainingLeaveDays}})])]),e._v(" "),s("div",{staticClass:"field"},[e._m(6),e._v(" "),s("div",{staticClass:"control"},[s("textarea",{directives:[{name:"model",rawName:"v-model",value:e.leaveRequest.reason,expression:"leaveRequest.reason"}],staticClass:"textarea",domProps:{value:e.leaveRequest.reason},on:{input:[function(t){t.target.composing||e.$set(e.leaveRequest,"reason",t.target.value)},function(t){return e.clearFieldError("reason")}]}}),e._v(" "),e.errors.reason?s("span",{staticClass:"text-red-400"},[e._v("\n\t\t\t\t"+e._s(e.errors.reason[0])+"\n\t\t\t")]):e._e()])]),e._v(" "),s("div",{staticClass:"flex justify-center m-3"},[s("button",{staticClass:"button is-rounded",class:{"is-loading":e.loading},attrs:{type:"submit"},on:{click:function(t){return t.preventDefault(),e.makeLeaveRequest(t)}}},[e._v("Submit\n\t\t")])])])}),[function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"has-text-centered m-3"},[t("h1",{staticClass:"has-text-black"},[t("b",[this._v("Request Leave")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("label",{staticClass:"label"},[this._v("Leave Types "),t("span",[t("sup",{staticClass:"has-text-danger"},[this._v("*")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("label",{staticClass:"label"},[this._v("From "),t("span",[t("sup",{staticClass:"has-text-danger"},[this._v("*")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("label",{staticClass:"label"},[this._v("To "),t("span",[t("sup",{staticClass:"has-text-danger"},[this._v("*")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("label",{staticClass:"label"},[this._v("Number of Days"),t("span",[t("sup",[this._v("*")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("label",{staticClass:"label"},[this._v("Remaining Leaves Days"),t("span",[t("sup",[this._v("*")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("label",{staticClass:"label"},[this._v("Reason"),t("span",[t("sup",[this._v("*")])])])}],!1,null,"44654b4a",null).exports,r={components:{ModalTemplate:a.a,LeaveRequestForm:i},methods:{onLeaveRequestSuccessful(){this.$emit("leaveRequestSuccessful"),this.$router.back()}}},o=Object(n.a)(r,(function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("ModalTemplate",{on:{modalClosed:function(t){return e.$router.back()}}},[s("LeaveRequestForm",{attrs:{slot:"modal-content"},on:{leaveRequestSuccessful:e.onLeaveRequestSuccessful},slot:"modal-content"})],1)}),[],!1,null,"7b07946c",null);t.default=o.exports}}]);