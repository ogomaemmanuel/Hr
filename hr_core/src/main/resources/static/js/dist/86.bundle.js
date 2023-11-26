(window.webpackJsonp=window.webpackJsonp||[]).push([[86],{360:function(e,t,a){var s=a(364);s.__esModule&&(s=s.default),"string"==typeof s&&(s=[[e.i,s,""]]),s.locals&&(e.exports=s.locals);(0,a(22).default)("42292892",s,!1,{})},361:function(e,t,a){"use strict";var s=function(){var e=this,t=e._self._c;return t("div",{staticClass:"modal-wrapper"},[t("div",{ref:"modal",staticClass:"modal"},[t("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":e.width+"px",overflow:e.overflow}},[t("div",{staticClass:"box",class:e.hasPadding?"":"p-0"},[e.showCloseButton?[t("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(t){return t.stopPropagation(),e.closeModal.apply(null,arguments)}}})]:e._e(),e._v(" "),e._t("modal-content")],2)])])])};s._withStripped=!0;var l={mixins:[a(362).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0},hasPadding:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},o=(a(363),a(15)),n=Object(o.a)(l,s,[],!1,null,"5fe0ec67",null);t.a=n.exports},362:function(e,t,a){"use strict";(function(e){t.a={methods:{closeModal(){e(this.$refs.modalContent).toggleClass("scaleIn"),e(this.$refs.modalClose).toggleClass("is-hidden"),e(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){e(this.$refs.modal).toggleClass("is-active")}}}}).call(this,a(187))},363:function(e,t,a){"use strict";a(360)},364:function(e,t,a){(e.exports=a(21)(!1)).push([e.i,".modal[data-v-5fe0ec67]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,.86)}.modal .modal-content[data-v-5fe0ec67]{overflow:visible}",""])},607:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e._self._c;return t("ModalTemplate",{ref:"modalTemplate",on:{modalClosed:e.onModalClosed}},[e._t("modal-content",(function(){return[t("LeaveTypeCreateForm",{attrs:{slot:"modal-content"},on:{leaveTypeCreateSuccessful:e.onCreateSuccessful},slot:"modal-content"})]}))],2)};s._withStripped=!0;var l=function(){var e=this,t=e._self._c;return t("form",[e._m(0),e._v(" "),t("div",{staticClass:"field"},[e._m(1),e._v(" "),t("div",{staticClass:"control"},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.leaveType.name,expression:"leaveType.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:e.leaveType.name},on:{input:[function(t){t.target.composing||e.$set(e.leaveType,"name",t.target.value)},function(t){return e.clearFieldError("name")}]}}),e._v(" "),e.errors.name?t("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t"+e._s(e.errors.name[0])+"\n\t\t\t\t")]):e._e()])]),e._v(" "),t("div",{staticClass:"field"},[e._m(2),e._v(" "),t("div",{staticClass:"control"},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.leaveType.numberOfDays,expression:"leaveType.numberOfDays"}],staticClass:"min-w-full input",attrs:{type:"number"},domProps:{value:e.leaveType.numberOfDays},on:{input:[function(t){t.target.composing||e.$set(e.leaveType,"numberOfDays",t.target.value)},function(t){return e.clearFieldError("numberOfDays")}]}}),e._v(" "),e.errors.numberOfDays?t("span",{staticClass:"mb-2 has-text-danger"},[e._v("\n\t\t\t\t\t"+e._s(e.errors.numberOfDays[0])+"\n\t\t\t\t")]):e._e()])]),e._v(" "),t("div",{staticClass:"flex justify-center m-3"},[t("button",{staticClass:"button is-small is-rounded",class:{"is-loading":e.loading},attrs:{disabled:e.disableSubmitButton,type:"submit"},on:{click:function(t){return t.preventDefault(),t.stopPropagation(),e.createLeaveType.apply(null,arguments)}}},[e._v("Submit\n\t\t")])])])};l._withStripped=!0;var o={mixins:[a(34).a],data:()=>({leaveType:{name:"",numberOfDays:""},loading:!1}),methods:{createLeaveType(){this.loading=!0,axios.post("api/leave-types",this.leaveType).then(e=>{this.loading=!1,this.$swal({text:"Leave Type successfully created",type:"success"}),this.$emit("leaveTypeCreateSuccessful")},e=>{400==e.response.status&&(this.errors=e.response.data)})}},computed:{disableSubmitButton(){return 0==this.leaveType.name.length||0==this.leaveType.numberOfDays.length||this.loading}}},n=a(15),i=Object(n.a)(o,l,[function(){var e=this._self._c;return e("div",{staticClass:"has-text-centered m-3"},[e("h1",{staticClass:"has-text-black"},[e("b",[this._v("Create Leave Type")])])])},function(){var e=this._self._c;return e("label",{staticClass:"label is-size-7"},[this._v("Name "),e("span",[e("sup",[this._v("*")])])])},function(){var e=this._self._c;return e("label",{staticClass:"label is-size-7"},[this._v("Number of Days"),e("span",[e("sup",[this._v("*")])])])}],!1,null,null,null).exports,r={components:{ModalTemplate:a(361).a,LeaveTypeCreateForm:i},methods:{onCreateSuccessful(){this.$emit("holidayCreateSuccessful"),this.$router.go(-1)},onModalClosed(){this.$router.go(-1)}}},u=Object(n.a)(r,s,[],!1,null,null,null);t.default=u.exports}}]);