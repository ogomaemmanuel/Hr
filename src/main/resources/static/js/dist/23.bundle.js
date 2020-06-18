(window.webpackJsonp=window.webpackJsonp||[]).push([[23],{168:function(t,e,s){"use strict";s.r(e);var a={mixins:[s(12).a],props:{roleId:{required:!0}},data:()=>({role:{name:"",description:""},loading:!1}),methods:{getRoleDetails(){axios.get(`/api/roles/${this.roleId}`).then(t=>{this.role=t.data})},updateRole(){axios.put(`/api/roles/${this.roleId}`).then(t=>{},t=>{})}},created(){this.getRoleDetails()},computed:{disableSubmitButton(){return this.role.name.length<=0||this.loading}}},o=s(2),l=Object(o.a)(a,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("form",[t._m(0),t._v(" "),s("div",{staticClass:"field"},[t._m(1),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.role.name,expression:"role.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.role.name},on:{input:[function(e){e.target.composing||t.$set(t.role,"name",e.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),s("div",{staticClass:"field"},[t._m(2),t._v(" "),s("div",{staticClass:"control"},[s("textarea",{directives:[{name:"model",rawName:"v-model",value:t.role.description,expression:"role.description"}],staticClass:"textarea",attrs:{type:"text"},domProps:{value:t.role.description},on:{input:[function(e){e.target.composing||t.$set(t.role,"description",e.target.value)},function(e){return t.clearFieldError("description")}]}}),t._v(" "),t.errors.description?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.description[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),s("div",{staticClass:"flex justify-center m-3"},[s("button",{staticClass:"button is-small is-rounded",class:{"is-loading":t.loading},attrs:{disabled:t.disableSubmitButton,type:"submit"},on:{click:function(e){return e.preventDefault(),e.stopPropagation(),t.updateRole(e)}}},[t._v("Submit\n                ")])])])])},[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"has-text-centered m-3"},[e("h1",{staticClass:"has-text-black"},[e("b",[this._v("Edit Role")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Role Name "),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Description"),e("span",[e("sup",[this._v("*")])])])}],!1,null,"5eacd138",null).exports,i={components:{ModalTemplate:s(71).a,RoleEditForm:l},methods:{onRoleUpdateSuccessful(){this.$emit("roleUpdateSuccessful"),this.$router.back()},onModalClosed(){this.$router.back()}}},n=Object(o.a)(i,function(){var t=this.$createElement,e=this._self._c||t;return e("ModalTemplate",{ref:"modalTemplate",on:{modalClosed:this.onModalClosed}},[this._t("modal-content",[e("RoleEditForm",{attrs:{slot:"modal-content","role-id":this.$route.params.id},on:{roleUpdateSuccessful:this.onRoleUpdateSuccessful},slot:"modal-content"})])],2)},[],!1,null,null,null);e.default=n.exports},70:function(t,e,s){"use strict";(function(t){e.a={methods:{closeModal(){t(this.$refs.modalBackground).toggleClass("scaleInCircle"),t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(72))},71:function(t,e,s){"use strict";var a={mixins:[s(70).a],props:{overflow:{required:!1,default:"auto"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal()}},o=s(2),l=Object(o.a)(a,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{ref:"modal",staticClass:"modal"},[s("div",{ref:"modalBackground",staticClass:"modal-background"}),t._v(" "),s("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[s("div",{staticClass:"box"},[t._t("modal-content")],2)]),t._v(" "),t.showCloseButton?[s("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(e){return e.stopPropagation(),t.closeModal(e)}}})]:t._e()],2)},[],!1,null,null,null);e.a=l.exports}}]);