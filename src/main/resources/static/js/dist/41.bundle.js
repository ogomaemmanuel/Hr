(window.webpackJsonp=window.webpackJsonp||[]).push([[41],{475:function(t,e,s){"use strict";s.r(e);var o=s(11),a={mixins:[o.a,o.a],data:()=>({role:{name:""},isLoading:!1}),methods:{createRole(){let t=this;axios.post("/api/roles",this.role).then(e=>{t.$swal({type:"success",title:"Success",text:"Role created successfully"}),this.$emit("roleCreateSuccessful")},t=>{400==t.response.status&&(this.errors=t.response.data)})}},computed:{disableSubmitButton(){return this.role.name.length<=0||this.isLoading}}},l=s(2),i=Object(l.a)(a,(function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("form",[t._m(0),t._v(" "),s("div",{staticClass:"field"},[t._m(1),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.role.name,expression:"role.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.role.name},on:{input:[function(e){e.target.composing||t.$set(t.role,"name",e.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),s("div",{staticClass:"field"},[t._m(2),t._v(" "),s("div",{staticClass:"control"},[s("textarea",{directives:[{name:"model",rawName:"v-model",value:t.role.description,expression:"role.description"}],staticClass:"textarea",attrs:{type:"text"},domProps:{value:t.role.description},on:{input:[function(e){e.target.composing||t.$set(t.role,"description",e.target.value)},function(e){return t.clearFieldError("description")}]}}),t._v(" "),t.errors.description?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.description[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),s("div",{staticClass:"flex justify-center m-3"},[s("button",{ref:"createButton",staticClass:"button  is-rounded",class:{"is-loading":t.isLoading},attrs:{disabled:t.disableSubmitButton,type:"submit"},on:{click:function(e){return e.preventDefault(),e.stopPropagation(),t.createRole()}}},[t._v("Submit\n                ")])])])])}),[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"has-text-centered m-3"},[e("h1",{staticClass:"has-text-black"},[e("b",[this._v("Add Role")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v("Name "),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v("Description "),e("span",[e("sup",[this._v("*")])])])}],!1,null,null,null).exports,n={components:{ModalTemplate:s(72).a,RoleCreateForm:i},methods:{onRoleCreateSuccessful(){this.$emit("roleCreateSuccessful"),this.$router.back()},onModalClosed(){this.$router.back()}}},r=Object(l.a)(n,(function(){var t=this.$createElement,e=this._self._c||t;return e("ModalTemplate",{ref:"modalTemplate",on:{modalClosed:this.onModalClosed}},[this._t("modal-content",[e("RoleCreateForm",{attrs:{slot:"modal-content"},on:{roleCreateSuccessful:this.onRoleCreateSuccessful},slot:"modal-content"})])],2)}),[],!1,null,null,null);e.default=r.exports},70:function(t,e,s){var o=s(75);"string"==typeof o&&(o=[[t.i,o,""]]),o.locals&&(t.exports=o.locals);(0,s(6).default)("6a4b444c",o,!0,{})},72:function(t,e,s){"use strict";var o={mixins:[s(73).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},a=(s(74),s(2)),l=Object(a.a)(o,(function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{ref:"modal",staticClass:"modal"},[s("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[s("div",{staticClass:"box"},[t._t("modal-content")],2)]),t._v(" "),t.showCloseButton?[s("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(e){return e.stopPropagation(),t.closeModal(e)}}})]:t._e()],2)}),[],!1,null,"c09ee790",null);e.a=l.exports},73:function(t,e,s){"use strict";(function(t){e.a={methods:{closeModal(){t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(80))},74:function(t,e,s){"use strict";var o=s(70);s.n(o).a},75:function(t,e,s){(t.exports=s(5)(!1)).push([t.i,".modal[data-v-c09ee790]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-c09ee790]{overflow:visible}\n",""])}}]);