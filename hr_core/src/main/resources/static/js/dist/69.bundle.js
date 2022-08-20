(window.webpackJsonp=window.webpackJsonp||[]).push([[69],{199:function(t,e,a){var s=a(204);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,a(23).default)("1f8d4a96",s,!0,{})},201:function(t,e,a){"use strict";var s={mixins:[a(202).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},o=(a(203),a(15)),n=Object(o.a)(s,(function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"modal-wrapper"},[a("div",{ref:"modal",staticClass:"modal"},[a("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[a("div",{staticClass:"box"},[t._t("modal-content")],2)]),t._v(" "),t.showCloseButton?[a("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(e){return e.stopPropagation(),t.closeModal(e)}}})]:t._e()],2)])}),[],!1,null,"2fb1f790",null);e.a=n.exports},202:function(t,e,a){"use strict";(function(t){e.a={methods:{closeModal(){t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,a(164))},203:function(t,e,a){"use strict";var s=a(199);a.n(s).a},204:function(t,e,a){(t.exports=a(22)(!1)).push([t.i,".modal[data-v-2fb1f790]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-2fb1f790]{overflow:visible}\n",""])},384:function(t,e,a){"use strict";a.r(e);var s={mixins:[a(35).a],props:{departmentId:{required:!0}},data:()=>({department:{name:""},loading:!1}),created(){this.getDepartmentById()},methods:{getDepartmentById(){axios.get("/api/departments/"+this.departmentId).then(t=>{this.department=t.data})},updateDepartment(){let t=this;axios.put("/api/departments/"+this.departmentId,this.department).then(e=>{t.$swal({type:"success",title:"Success",text:"Department successfully updated"}),this.$emit("departmentUpdated")})}},computed:{disableSubmitButton(){return this.department.name.length<=0||this.loading}}},o=a(15),n={components:{DepartmentEditForm:Object(o.a)(s,(function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("form",[t._m(0),t._v(" "),a("div",{staticClass:"field"},[t._m(1),t._v(" "),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.department.name,expression:"department.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.department.name},on:{input:[function(e){e.target.composing||t.$set(t.department,"name",e.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?a("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),a("div",{staticClass:"flex justify-center m-3"},[a("button",{staticClass:"button  is-rounded",class:{"is-loading":t.loading},attrs:{disabled:t.disableSubmitButton,type:"submit"},on:{click:function(e){return e.preventDefault(),e.stopPropagation(),t.updateDepartment(e)}}},[t._v("Submit\n                ")])])])])}),[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"has-text-centered m-3"},[e("h1",{staticClass:"has-text-black"},[e("b",[this._v("Update Department")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v("Department Name "),e("span",[e("sup",[this._v("*")])])])}],!1,null,null,null).exports,ModalTemplate:a(201).a},methods:{onModalClosed(){this.$router.go(-1)},onDepartmentUpdated(){this.$emit("departmentUpdated"),this.$router.go(-1)}}},i=Object(o.a)(n,(function(){var t=this.$createElement,e=this._self._c||t;return e("ModalTemplate",{ref:"editModalTemplate",on:{modalClosed:this.onModalClosed}},[this._t("modal-content",[e("DepartmentEditForm",{attrs:{slot:"modal-content","department-id":this.$route.params.id},on:{departmentUpdated:this.onDepartmentUpdated},slot:"modal-content"})])],2)}),[],!1,null,null,null);e.default=i.exports}}]);