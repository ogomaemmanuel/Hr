(window.webpackJsonp=window.webpackJsonp||[]).push([[44],{199:function(t,e,s){var a=s(204);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(23).default)("1f8d4a96",a,!0,{})},201:function(t,e,s){"use strict";var a={mixins:[s(202).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},i=(s(203),s(15)),n=Object(i.a)(a,(function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"modal-wrapper"},[s("div",{ref:"modal",staticClass:"modal"},[s("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[s("div",{staticClass:"box"},[t._t("modal-content")],2)]),t._v(" "),t.showCloseButton?[s("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(e){return e.stopPropagation(),t.closeModal(e)}}})]:t._e()],2)])}),[],!1,null,"2fb1f790",null);e.a=n.exports},202:function(t,e,s){"use strict";(function(t){e.a={methods:{closeModal(){t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(164))},203:function(t,e,s){"use strict";var a=s(199);s.n(a).a},204:function(t,e,s){(t.exports=s(22)(!1)).push([t.i,".modal[data-v-2fb1f790]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-2fb1f790]{overflow:visible}\n",""])},211:function(t,e,s){"use strict";var a=s(169),i=s.n(a),n={data:()=>({departments:[],loading:!1,isFetching:!1,departmentName:"",page:0,totalPages:0,selectedDepartment:{}}),methods:{showAddDepartment(){},fetchDepartments(t){axios.get("/api/departments",{params:{page:this.page,pageSize:10}}).then(({data:t})=>{t.content.forEach(t=>this.departments.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:i()((function(t){if(this.departmentName!==t&&(this.departmentName=t,this.departments=[],this.page=0,this.totalPages=0),!t.length)return this.departments=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchDepartments(t))}),500),getMoreAsyncData:i()((function(){this.getAsyncData(this.departmentName)}),250)},watch:{selectedDepartment:function(t){this.$emit("input",t.id)}}},l=s(15),o=Object(l.a)(n,(function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("b-field",[s("template",{slot:"label"},[t._v("\n            Department "),s("span",[s("sup",[t._v("*")])])]),t._v(" "),s("b-autocomplete",{attrs:{data:t.departments,placeholder:"Department name",field:"name",loading:t.isFetching,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:function(e){return t.selectedDepartment=e},"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(e){return[s("div",{staticClass:"media"},[s("div",{staticClass:"media-left"}),t._v(" "),s("div",{staticClass:"media-content"},[t._v("\n                        "+t._s(e.option.name)+"\n                        "),s("br"),t._v(" "),s("small")])])]}}])},[s("template",{slot:"header"},[s("a",{on:{click:t.showAddDepartment}},[s("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),s("template",{slot:"footer"},[s("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2),t._v(" "),s("div",{attrs:{slot:"message"},slot:"message"},[t._t("errors")],2)],2)],1)}),[],!1,null,"cfd513f8",null);e.a=o.exports},408:function(t,e,s){"use strict";s.r(e);var a=s(201),i=(s(165),s(75),s(166)),n=s.n(i),l=s(35),o=s(211),r={mixins:[l.a],components:{DepartmentSelectInput:o.a},data:()=>({policy:{},loading:!1,fileName:""}),methods:{onFileChange(t){const e=t.target.files[0];this.policy.attachment=e,this.fileName=e.name},createPolicy(){this.loading=!0;let t=this.createFormData(this.policy);axios.post("/api/policies",t).then(t=>{this.loading=!1,n.a.success("Policy successfully created"),this.$emit("createSuccessful")},t=>{this.loading=!1,400==t.response.status?this.errors=t.response.data:n.a.error("There was an error creating policy")})}},computed:{disableSubmitButton(){return this.loading}}},c=s(15),d=Object(c.a)(r,(function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("form",[t._m(0),t._v(" "),s("div",{staticClass:"field"},[t._m(1),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.policy.name,expression:"policy.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.policy.name},on:{input:[function(e){e.target.composing||t.$set(t.policy,"name",e.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),s("div",{staticClass:"field"},[t._m(2),t._v(" "),s("div",{staticClass:"control"},[s("textarea",{directives:[{name:"model",rawName:"v-model",value:t.policy.description,expression:"policy.description"}],staticClass:"textarea",attrs:{type:"text"},domProps:{value:t.policy.description},on:{input:[function(e){e.target.composing||t.$set(t.policy,"description",e.target.value)},function(e){return t.clearFieldError("description")}]}}),t._v(" "),t.errors.description?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.description[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),s("DepartmentSelectInput",{on:{input:function(e){return t.clearFieldError("departmentId")}},model:{value:t.policy.departmentId,callback:function(e){t.$set(t.policy,"departmentId",e)},expression:"policy.departmentId"}},[t.errors.departmentId?s("span",{staticClass:"mb-2 has-text-danger",attrs:{slot:"errors"},slot:"errors"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.departmentId[0])+"\n\t\t\t\t\t")]):t._e()]),t._v(" "),s("div",{staticClass:"field"},[s("div",{staticClass:"control"},[t._m(3),t._v(" "),s("div",{staticClass:"file has-name is-fullwidth"},[s("label",{staticClass:"file-label"},[s("input",{staticClass:"file-input",attrs:{type:"file",name:"resume"},on:{change:t.onFileChange}}),t._v(" "),t._m(4),t._v(" "),s("span",{staticClass:"file-name"},[t._v("\n      "+t._s(t.fileName)+"\n    ")])])])])]),t._v(" "),s("div",{staticClass:"flex justify-center m-3"},[s("button",{staticClass:"button  is-rounded",class:{"is-loading":t.loading},attrs:{disabled:t.disableSubmitButton,type:"submit"},on:{click:function(e){return e.preventDefault(),e.stopPropagation(),t.createPolicy(e)}}},[t._v("Submit\n        ")])])],1)])}),[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"has-text-centered m-3"},[e("h1",{staticClass:"has-text-black"},[e("b",[this._v("Add Policy")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v(" Name "),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v(" Description "),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v("Upload File"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("span",{staticClass:"file-cta"},[e("span",{staticClass:"file-icon"},[e("i",{staticClass:"fa fa-upload"})]),this._v(" "),e("span",{staticClass:"file-label"},[this._v("\n        Browse…\n      ")])])}],!1,null,null,null).exports,p={components:{ModalTemplate:a.a,PolicyCreateForm:d},methods:{onCreateSuccessful(){this.$emit("createSuccessful"),this.$router.go(-1)}}},m=Object(c.a)(p,(function(){var t=this.$createElement,e=this._self._c||t;return e("ModalTemplate",[e("PolicyCreateForm",{attrs:{slot:"modal-content"},on:{createSuccessful:this.onCreateSuccessful},slot:"modal-content"})],1)}),[],!1,null,null,null);e.default=m.exports}}]);