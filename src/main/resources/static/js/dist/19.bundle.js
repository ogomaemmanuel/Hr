(window.webpackJsonp=window.webpackJsonp||[]).push([[19],{147:function(t,e,s){"use strict";s.r(e);var a={mixins:[s(12).a],data:()=>({role:{name:""},isLoading:!1}),methods:{createRole(){let t=this;axios.post("/api/roles",this.role).then(e=>{t.$swal({type:"success",title:"Success",text:"Role created successfully"}),this.$emit("roleCreateSuccessful")},t=>{})}},computed:{disableSubmitButton(){return this.role.name.length<=0||this.isLoading}}},l=s(2),o=Object(l.a)(a,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("form",[t._m(0),t._v(" "),s("div",{staticClass:"field"},[t._m(1),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.role.name,expression:"role.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.role.name},on:{input:[function(e){e.target.composing||t.$set(t.role,"name",e.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t")]):t._e()])]),t._v(" "),s("div",{staticClass:"field"},[t._m(2),t._v(" "),s("div",{staticClass:"control"},[s("textarea",{directives:[{name:"model",rawName:"v-model",value:t.role.description,expression:"role.description"}],staticClass:"textarea",attrs:{type:"text"},domProps:{value:t.role.description},on:{input:[function(e){e.target.composing||t.$set(t.role,"description",e.target.value)},function(e){return t.clearFieldError("description")}]}}),t._v(" "),t.errors.description?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t"+t._s(t.errors.description[0])+"\n\t\t\t\t")]):t._e()])]),t._v(" "),s("div",{staticClass:"flex justify-center m-3"},[s("button",{staticClass:"button is-small is-rounded",class:{"is-loading":t.isLoading},attrs:{disabled:t.disableSubmitButton,type:"submit"},on:{click:function(e){return e.preventDefault(),e.stopPropagation(),t.createRole(e)}}},[t._v("Submit\n\t\t\t")])])])])},[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"has-text-centered m-3"},[e("h1",{staticClass:"has-text-black"},[e("b",[this._v("Add Role")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Name "),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Description "),e("span",[e("sup",[this._v("*")])])])}],!1,null,null,null).exports,i={components:{ModalTemplate:s(71).a,RoleCreateForm:o},methods:{onRoleCreateSuccessful(){this.$emit("roleCreateSuccessful"),this.$router.back()},onModalClosed(){this.$router.back()}}},n=Object(l.a)(i,function(){var t=this.$createElement,e=this._self._c||t;return e("ModalTemplate",{ref:"modalTemplate",on:{modalClosed:this.onModalClosed}},[this._t("modal-content",[e("RoleCreateForm",{attrs:{slot:"modal-content"},on:{roleCreateSuccessful:this.onRoleCreateSuccessful},slot:"modal-content"})])],2)},[],!1,null,null,null);e.default=n.exports},70:function(t,e,s){"use strict";(function(t){e.a={methods:{closeModal(){t(this.$refs.modalBackground).toggleClass("scaleInCircle"),t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(74))},71:function(t,e,s){"use strict";var a={mixins:[s(70).a],props:{overflow:{required:!1,default:"auto"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal()}},l=s(2),o=Object(l.a)(a,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{ref:"modal",staticClass:"modal"},[s("div",{ref:"modalBackground",staticClass:"modal-background"}),t._v(" "),s("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[s("div",{staticClass:"box"},[t._t("modal-content")],2)]),t._v(" "),t.showCloseButton?[s("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(e){return e.stopPropagation(),t.closeModal(e)}}})]:t._e()],2)},[],!1,null,null,null);e.a=o.exports}}]);