(window.webpackJsonp=window.webpackJsonp||[]).push([[57],{360:function(t,e,s){var a=s(364);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(22).default)("42292892",a,!1,{})},361:function(t,e,s){"use strict";var a=function(){var t=this,e=t._self._c;return e("div",{staticClass:"modal-wrapper"},[e("div",{ref:"modal",staticClass:"modal"},[e("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[e("div",{staticClass:"box",class:t.hasPadding?"":"p-0"},[t.showCloseButton?[e("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(e){return e.stopPropagation(),t.closeModal.apply(null,arguments)}}})]:t._e(),t._v(" "),t._t("modal-content")],2)])])])};a._withStripped=!0;var i={mixins:[s(362).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0},hasPadding:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},l=(s(363),s(15)),n=Object(l.a)(i,a,[],!1,null,"5fe0ec67",null);e.a=n.exports},362:function(t,e,s){"use strict";(function(t){e.a={methods:{closeModal(){t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(187))},363:function(t,e,s){"use strict";s(360)},364:function(t,e,s){(t.exports=s(21)(!1)).push([t.i,".modal[data-v-5fe0ec67]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,.86)}.modal .modal-content[data-v-5fe0ec67]{overflow:visible}",""])},372:function(t,e,s){"use strict";var a=function(){var t=this,e=t._self._c;return e("div",[e("b-field",[e("template",{slot:"label"},[t._v("\n            Department "),e("span",[e("sup",[t._v("*")])])]),t._v(" "),e("b-autocomplete",{attrs:{data:t.departments,placeholder:"Department name",field:"name",loading:t.isFetching,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:e=>t.selectedDepartment=e,"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(s){return[e("div",{staticClass:"media"},[e("div",{staticClass:"media-left"}),t._v(" "),e("div",{staticClass:"media-content"},[t._v("\n                        "+t._s(s.option.name)+"\n                        "),e("br"),t._v(" "),e("small")])])]}}])},[e("template",{slot:"header"},[e("a",{on:{click:t.showAddDepartment}},[e("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),e("template",{slot:"footer"},[e("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2),t._v(" "),e("div",{attrs:{slot:"message"},slot:"message"},[t._t("errors")],2)],2)],1)};a._withStripped=!0;var i=s(190),l=s.n(i),n={data:()=>({departments:[],loading:!1,isFetching:!1,departmentName:"",page:0,totalPages:0,selectedDepartment:{}}),methods:{showAddDepartment(){},fetchDepartments(t){axios.get("/api/departments",{params:{page:this.page,pageSize:10}}).then(({data:t})=>{t.content.forEach(t=>this.departments.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:l()((function(t){if(this.departmentName!==t&&(this.departmentName=t,this.departments=[],this.page=0,this.totalPages=0),!t.length)return this.departments=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchDepartments(t))}),500),getMoreAsyncData:l()((function(){this.getAsyncData(this.departmentName)}),250)},watch:{selectedDepartment:function(t){this.$emit("input",t.id)}}},o=s(15),r=Object(o.a)(n,a,[],!1,null,"8d4e7fbe",null);e.a=r.exports},623:function(t,e,s){"use strict";s.r(e);var a=function(){var t=this._self._c;return t("ModalTemplate",[t("PolicyCreateForm",{attrs:{slot:"modal-content"},on:{createSuccessful:this.onCreateSuccessful},slot:"modal-content"})],1)};a._withStripped=!0;var i=s(361),l=function(){var t=this,e=t._self._c;return e("div",[e("form",[t._m(0),t._v(" "),e("div",{staticClass:"field"},[t._m(1),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.policy.name,expression:"policy.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.policy.name},on:{input:[function(e){e.target.composing||t.$set(t.policy,"name",e.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),e("div",{staticClass:"field"},[t._m(2),t._v(" "),e("div",{staticClass:"control"},[e("textarea",{directives:[{name:"model",rawName:"v-model",value:t.policy.description,expression:"policy.description"}],staticClass:"textarea",attrs:{type:"text"},domProps:{value:t.policy.description},on:{input:[function(e){e.target.composing||t.$set(t.policy,"description",e.target.value)},function(e){return t.clearFieldError("description")}]}}),t._v(" "),t.errors.description?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.description[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),e("DepartmentSelectInput",{on:{input:function(e){return t.clearFieldError("departmentId")}},model:{value:t.policy.departmentId,callback:function(e){t.$set(t.policy,"departmentId",e)},expression:"policy.departmentId"}},[t.errors.departmentId?e("span",{staticClass:"mb-2 has-text-danger",attrs:{slot:"errors"},slot:"errors"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.departmentId[0])+"\n\t\t\t\t\t")]):t._e()]),t._v(" "),e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[t._m(3),t._v(" "),e("div",{staticClass:"file has-name is-fullwidth"},[e("label",{staticClass:"file-label"},[e("input",{staticClass:"file-input",attrs:{type:"file",name:"resume"},on:{change:t.onFileChange}}),t._v(" "),t._m(4),t._v(" "),e("span",{staticClass:"file-name"},[t._v("\n      "+t._s(t.fileName)+"\n    ")])])])])]),t._v(" "),e("div",{staticClass:"flex justify-center m-3"},[e("button",{staticClass:"button is-rounded",class:{"is-loading":t.loading},attrs:{disabled:t.disableSubmitButton,type:"submit"},on:{click:function(e){return e.preventDefault(),e.stopPropagation(),t.createPolicy.apply(null,arguments)}}},[t._v("Submit\n        ")])])],1)])};l._withStripped=!0;s(185),s(83);var n=s(186),o=s.n(n),r=s(34),c=s(372),d={mixins:[r.a],components:{DepartmentSelectInput:c.a},data:()=>({policy:{},loading:!1,fileName:""}),methods:{onFileChange(t){const e=t.target.files[0];this.policy.attachment=e,this.fileName=e.name},createPolicy(){this.loading=!0;let t=this.createFormData(this.policy);axios.post("/api/policies",t).then(t=>{this.loading=!1,o.a.success("Policy successfully created"),this.$emit("createSuccessful")},t=>{this.loading=!1,400==t.response.status?this.errors=t.response.data:o.a.error("There was an error creating policy")})}},computed:{disableSubmitButton(){return this.loading}}},p=s(15),u=Object(p.a)(d,l,[function(){var t=this._self._c;return t("div",{staticClass:"has-text-centered m-3"},[t("h1",{staticClass:"has-text-black"},[t("b",[this._v("Add Policy")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v(" Name "),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v(" Description "),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Upload File"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("span",{staticClass:"file-cta"},[t("span",{staticClass:"file-icon"},[t("i",{staticClass:"fa fa-upload"})]),this._v(" "),t("span",{staticClass:"file-label"},[this._v("\n        Browse…\n      ")])])}],!1,null,null,null).exports,m={components:{ModalTemplate:i.a,PolicyCreateForm:u},methods:{onCreateSuccessful(){this.$emit("createSuccessful"),this.$router.go(-1)}}},h=Object(p.a)(m,a,[],!1,null,null,null);e.default=h.exports}}]);