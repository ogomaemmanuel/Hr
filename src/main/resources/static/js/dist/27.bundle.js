(window.webpackJsonp=window.webpackJsonp||[]).push([[27],{174:function(e,t,s){"use strict";s.r(t);var a={mixins:[s(12).a],data:()=>({leaveType:{name:"",numberOfDays:""},loading:!1}),methods:{createLeaveType(){this.loading=!0,axios.post("api/leave-types",this.leaveType).then(e=>{this.loading=!1,this.$swal({text:"Leave Type successfully created",type:"success"}),this.$emit("leaveTypeCreateSuccessful")},e=>{400==e.response.status&&(this.errors=e.response.data)})}},computed:{disableSubmitButton(){return 0==this.leaveType.name.length||0==this.leaveType.numberOfDays.length||this.loading}}},l=s(2),n=Object(l.a)(a,function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("form",[e._m(0),e._v(" "),s("div",{staticClass:"field"},[e._m(1),e._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:e.leaveType.name,expression:"leaveType.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:e.leaveType.name},on:{input:[function(t){t.target.composing||e.$set(e.leaveType,"name",t.target.value)},function(t){return e.clearFieldError("name")}]}}),e._v(" "),e.errors.name?s("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t"+e._s(e.errors.name[0])+"\n\t\t\t\t")]):e._e()])]),e._v(" "),s("div",{staticClass:"field"},[e._m(2),e._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:e.leaveType.numberOfDays,expression:"leaveType.numberOfDays"}],staticClass:"min-w-full input",attrs:{type:"number"},domProps:{value:e.leaveType.numberOfDays},on:{input:[function(t){t.target.composing||e.$set(e.leaveType,"numberOfDays",t.target.value)},function(t){return e.clearFieldError("numberOfDays")}]}}),e._v(" "),e.errors.numberOfDays?s("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t"+e._s(e.errors.numberOfDays[0])+"\n\t\t\t\t")]):e._e()])]),e._v(" "),s("div",{staticClass:"flex justify-center m-3"},[s("button",{staticClass:"button is-small is-rounded",class:{"is-loading":e.loading},attrs:{disabled:e.disableSubmitButton,type:"submit"},on:{click:function(t){return t.preventDefault(),t.stopPropagation(),e.createLeaveType(t)}}},[e._v("Submit\n\t\t")])])])},[function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"has-text-centered m-3"},[t("h1",{staticClass:"has-text-black"},[t("b",[this._v("Create Leave Type")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("label",{staticClass:"label is-size-7"},[this._v("Name "),t("span",[t("sup",[this._v("*")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("label",{staticClass:"label is-size-7"},[this._v("Number of Days"),t("span",[t("sup",[this._v("*")])])])}],!1,null,null,null).exports,o={components:{ModalTemplate:s(71).a,LeaveTypeCreateForm:n},methods:{onCreateSuccessful(){this.$emit("holidayCreateSuccessful"),this.$router.go(-1)},onModalClosed(){this.$router.go(-1)}}},i=Object(l.a)(o,function(){var e=this.$createElement,t=this._self._c||e;return t("ModalTemplate",{ref:"modalTemplate",on:{modalClosed:this.onModalClosed}},[this._t("modal-content",[t("LeaveTypeCreateForm",{attrs:{slot:"modal-content"},on:{leaveTypeCreateSuccessful:this.onCreateSuccessful},slot:"modal-content"})])],2)},[],!1,null,null,null);t.default=i.exports},70:function(e,t,s){"use strict";(function(e){t.a={methods:{closeModal(){e(this.$refs.modalBackground).toggleClass("scaleInCircle"),e(this.$refs.modalContent).toggleClass("scaleIn"),e(this.$refs.modalClose).toggleClass("is-hidden"),e(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){e(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(75))},71:function(e,t,s){"use strict";var a={mixins:[s(70).a],props:{overflow:{required:!1,default:"auto"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal()}},l=s(2),n=Object(l.a)(a,function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{ref:"modal",staticClass:"modal"},[s("div",{ref:"modalBackground",staticClass:"modal-background"}),e._v(" "),s("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":e.width+"px",overflow:e.overflow}},[s("div",{staticClass:"box"},[e._t("modal-content")],2)]),e._v(" "),e.showCloseButton?[s("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(t){return t.stopPropagation(),e.closeModal(t)}}})]:e._e()],2)},[],!1,null,null,null);t.a=n.exports}}]);