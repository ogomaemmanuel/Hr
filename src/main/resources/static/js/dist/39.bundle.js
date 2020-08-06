(window.webpackJsonp=window.webpackJsonp||[]).push([[39],{235:function(s,t,a){"use strict";a.r(t);var o=a(75),e={mixins:[a(12).a],components:{ModalTemplate:o.a},data:()=>({passwordUpdate:{oldPassword:"",newPassword:"",confirmationPassword:""},loading:!1}),methods:{changePassword(){let s=this;axios.post("/api/profile/update-password",this.passwordUpdate).then(t=>{s.$swal({type:"success",title:"Success",text:"Password  successfully updated"}),s.onModalClose()},s=>{400==s.response.status&&(this.errors=s.response.data)})},onModalClose(){this.$emit("close")}}},r=a(2),l=Object(r.a)(e,function(){var s=this,t=s.$createElement,a=s._self._c||t;return a("ModalTemplate",{on:{modalClosed:s.onModalClose}},[a("div",{attrs:{slot:"modal-content"},slot:"modal-content"},[a("div",{staticClass:"has-text-centered m-3"},[a("h1",{staticClass:"has-text-black"},[a("b",[s._v("Change Password")])])]),s._v(" "),a("form",[a("div",{staticClass:"field"},[a("p",{staticClass:"control has-icons-left"},[a("input",{directives:[{name:"model",rawName:"v-model",value:s.passwordUpdate.oldPassword,expression:"passwordUpdate.oldPassword"}],staticClass:"input",attrs:{type:"password",placeholder:"Old Password"},domProps:{value:s.passwordUpdate.oldPassword},on:{input:[function(t){t.target.composing||s.$set(s.passwordUpdate,"oldPassword",t.target.value)},function(t){return s.clearFieldError("oldPassword")}]}}),s._v(" "),a("span",{staticClass:"icon is-small is-left"},[a("i",{staticClass:"fa fa-key"})])]),s._v(" "),s.errors.oldPassword?a("span",{staticClass:"mb-2 has-text-danger"},[s._v("\n\t\t\t\t\t\t"+s._s(s.errors.oldPassword[0])+"\n\t\t\t\t\t")]):s._e()]),s._v(" "),a("div",{staticClass:"field"},[a("p",{staticClass:"control has-icons-left"},[a("input",{directives:[{name:"model",rawName:"v-model",value:s.passwordUpdate.newPassword,expression:"passwordUpdate.newPassword"}],staticClass:"input",attrs:{type:"password",placeholder:"New Password"},domProps:{value:s.passwordUpdate.newPassword},on:{input:[function(t){t.target.composing||s.$set(s.passwordUpdate,"newPassword",t.target.value)},function(t){return s.clearFieldError("newPassword")}]}}),s._v(" "),a("span",{staticClass:"icon is-small is-left"},[a("i",{staticClass:"fa fa-key"})])]),s._v(" "),s.errors.newPassword?a("span",{staticClass:"mb-2 has-text-danger"},[s._v("\n\t\t\t\t\t\t"+s._s(s.errors.newPassword[0])+"\n\t\t\t\t\t")]):s._e()]),s._v(" "),a("div",{staticClass:"field"},[a("p",{staticClass:"control has-icons-left"},[a("input",{directives:[{name:"model",rawName:"v-model",value:s.passwordUpdate.confirmationPassword,expression:"passwordUpdate.confirmationPassword"}],staticClass:"input",attrs:{type:"password",placeholder:"Confirm New Password"},domProps:{value:s.passwordUpdate.confirmationPassword},on:{input:[function(t){t.target.composing||s.$set(s.passwordUpdate,"confirmationPassword",t.target.value)},function(t){return s.clearFieldError("confirmationPassword")}]}}),s._v(" "),a("span",{staticClass:"icon is-small is-left"},[a("i",{staticClass:"fa fa-key"})])]),s._v(" "),s.errors.confirmationPassword?a("span",{staticClass:"mb-2 has-text-danger"},[s._v("\n\t\t\t\t\t\t"+s._s(s.errors.confirmationPassword[0])+"\n\t\t\t\t\t")]):s._e()]),s._v(" "),a("div",{staticClass:"flex justify-center m-3"},[a("button",{staticClass:"button  is-rounded",class:{"is-loading":s.loading},attrs:{type:"submit"},on:{click:function(t){return t.preventDefault(),t.stopPropagation(),s.changePassword(t)}}},[s._v("Submit\n                    ")])])])])])},[],!1,null,null,null);t.default=l.exports},70:function(s,t,a){var o=a(74);"string"==typeof o&&(o=[[s.i,o,""]]),o.locals&&(s.exports=o.locals);(0,a(6).default)("23dcd51c",o,!0,{})},72:function(s,t,a){"use strict";(function(s){t.a={methods:{closeModal(){s(this.$refs.modalContent).toggleClass("scaleIn"),s(this.$refs.modalClose).toggleClass("is-hidden"),s(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){s(this.$refs.modal).toggleClass("is-active")}}}}).call(this,a(79))},73:function(s,t,a){"use strict";var o=a(70);a.n(o).a},74:function(s,t,a){(s.exports=a(5)(!1)).push([s.i,".modal[data-v-c09ee790]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-c09ee790]{overflow:visible}\n",""])},75:function(s,t,a){"use strict";var o={mixins:[a(72).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},e=(a(73),a(2)),r=Object(e.a)(o,function(){var s=this,t=s.$createElement,a=s._self._c||t;return a("div",{ref:"modal",staticClass:"modal"},[a("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":s.width+"px",overflow:s.overflow}},[a("div",{staticClass:"box"},[s._t("modal-content")],2)]),s._v(" "),s.showCloseButton?[a("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(t){return t.stopPropagation(),s.closeModal(t)}}})]:s._e()],2)},[],!1,null,"c09ee790",null);t.a=r.exports}}]);