(window.webpackJsonp=window.webpackJsonp||[]).push([[27],{174:function(e,t,a){"use strict";a.r(t);var s=a(71),l={mixins:[a(12).a],props:{leaveTypeId:{required:!0}},data:()=>({leaveType:{name:"",numberOfDays:""},loading:!1}),created(){this.getLeaveTypeById()},methods:{getLeaveTypeById(){let e=this;axios.get(`/api/leave-types/${e.leaveTypeId}`).then(t=>{e.leaveType=t.data},e=>{})},updateLeaveType(){let e=this;this.loading=!0,axios.put(`/api/leave-types/${e.leaveTypeId}`,this.leaveType).then(t=>{e.loading=!1,this.$swal({text:"Leave type successfully updated",type:"success"}),this.$emit("leaveUpdateSuccessful")},t=>{e.loading=!1})}},computed:{disableSubmitButton(){return 0==this.leaveType.name.length||0==this.leaveType.numberOfDays.length||this.loading}}},n=a(2),i=Object(n.a)(l,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("form",[e._m(0),e._v(" "),a("div",{staticClass:"field"},[e._m(1),e._v(" "),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.leaveType.name,expression:"leaveType.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:e.leaveType.name},on:{input:[function(t){t.target.composing||e.$set(e.leaveType,"name",t.target.value)},function(t){return e.clearFieldError("name")}]}}),e._v(" "),e.errors.name?a("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t"+e._s(e.errors.name[0])+"\n\t\t\t\t")]):e._e()])]),e._v(" "),a("div",{staticClass:"field"},[e._m(2),e._v(" "),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.leaveType.numberOfDays,expression:"leaveType.numberOfDays"}],staticClass:"min-w-full input",attrs:{type:"number"},domProps:{value:e.leaveType.numberOfDays},on:{input:[function(t){t.target.composing||e.$set(e.leaveType,"numberOfDays",t.target.value)},function(t){return e.clearFieldError("numberOfDays")}]}}),e._v(" "),e.errors.numberOfDays?a("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t"+e._s(e.errors.numberOfDays[0])+"\n\t\t\t\t")]):e._e()])]),e._v(" "),a("div",{staticClass:"flex justify-center m-3"},[a("button",{staticClass:"button is-small is-rounded",class:{"is-loading":e.loading},attrs:{disabled:e.disableSubmitButton,type:"submit"},on:{click:function(t){return t.preventDefault(),t.stopPropagation(),e.updateLeaveType(t)}}},[e._v("Submit\n\t\t\t")])])])])},[function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"has-text-centered m-3"},[t("h1",{staticClass:"has-text-black"},[t("b",[this._v("Edit Leave Type")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("label",{staticClass:"label is-size-7"},[this._v("Name "),t("span",[t("sup",[this._v("*")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("label",{staticClass:"label is-size-7"},[this._v("Number of Days"),t("span",[t("sup",[this._v("*")])])])}],!1,null,null,null).exports,o={name:"LeaveTypeEditModal",components:{ModalTemplate:s.a,LeaveTypeEditForm:i},data:()=>({id:""}),created(){this.id=this.$route.params.id},methods:{onUpdateSuccessful(){this.$emit("leaveUpdateSuccessful"),this.$router.go(-1)}}},r=Object(n.a)(o,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("ModalTemplate",{on:{modalClosed:function(t){return e.$router.back()}}},[e._t("modal-content",[a("LeaveTypeEditForm",{attrs:{slot:"modal-content","leave-type-id":e.id},on:{leaveUpdateSuccessful:e.onUpdateSuccessful},slot:"modal-content"})])],2)},[],!1,null,"40842d16",null);t.default=r.exports},70:function(e,t,a){"use strict";(function(e){t.a={methods:{closeModal(){e(this.$refs.modalBackground).toggleClass("scaleInCircle"),e(this.$refs.modalContent).toggleClass("scaleIn"),e(this.$refs.modalClose).toggleClass("is-hidden"),e(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){e(this.$refs.modal).toggleClass("is-active")}}}}).call(this,a(72))},71:function(e,t,a){"use strict";var s={mixins:[a(70).a],props:{overflow:{required:!1,default:"auto"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal()}},l=a(2),n=Object(l.a)(s,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{ref:"modal",staticClass:"modal"},[a("div",{ref:"modalBackground",staticClass:"modal-background"}),e._v(" "),a("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":e.width+"px",overflow:e.overflow}},[a("div",{staticClass:"box"},[e._t("modal-content")],2)]),e._v(" "),e.showCloseButton?[a("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(t){return t.stopPropagation(),e.closeModal(t)}}})]:e._e()],2)},[],!1,null,null,null);t.a=n.exports}}]);