(window.webpackJsonp=window.webpackJsonp||[]).push([[19],{171:function(t,e,a){"use strict";a.r(e);var n=a(71),s=a(12),i=a(82),o=a.n(i),r={mixins:[s.a],props:{designationId:{required:!0}},data:()=>({departments:[],designation:{name:""},loading:!1,loaded:!1,isFetching:!1,departmentName:"",page:0,totalPages:0,selectedDepartment:{}}),computed:{disableSubmitButton(){return this.designation.name.length<=0}},created(){this.getDesignationById()},mounted(){this.getAsyncData()},methods:{setSelectedDepartment(t){this.selectedDepartment=t},fetchDepartments(t){axios.get("/api/departments",{params:{page:this.page,pageSize:10}}).then(({data:t})=>{t.content.forEach(t=>this.departments.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:o()(function(t){if(this.departmentName!==t&&(this.departmentName=t,this.departments=[],this.page=0,this.totalPages=0),!t.length)return this.departments=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchDepartments(t))},500),getDesignationById(){this.loading=!0,axios.get(`/api/designations/${this.designationId}`).then(t=>{this.designation=t.data,this.selectedDepartment=t.data.department,this.$refs.autocomplete.setSelected(t.data.department),this.loading=!1,this.loaded=!0},t=>{this.loading=!1})},getMoreAsyncData:o()(function(){this.getAsyncData(this.departmentName)},250),showAddDepartment(){},updateDesignation(){this.designation.departmentId=this.selectedDepartment.id,axios.put(`/api/designations/${this.designationId}`,this.designation).then(t=>{},t=>{})}}},l=a(2),d=Object(l.a)(r,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("form",[t._m(0),t._v(" "),a("div",{staticClass:"field"},[t._m(1),t._v(" "),a("div",{staticClass:"control"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.designation.name,expression:"designation.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.designation.name},on:{input:[function(e){e.target.composing||t.$set(t.designation,"name",e.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?a("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),[a("b-field",{attrs:{label:"Department"}},[a("b-autocomplete",{ref:"autocomplete",attrs:{data:t.departments,placeholder:"enter department name",field:"name",clearable:!0,loading:t.isFetching,"open-on-focus":!0,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:function(e){return t.selectedDepartment=e},"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(e){return[a("div",{staticClass:"media"},[a("div",{staticClass:"media-left"}),t._v(" "),a("div",{staticClass:"media-content"},[t._v("\n                                    "+t._s(e.option.name)+"\n                                    "),a("br"),t._v(" "),a("small")])])]}}])},[a("template",{slot:"header"},[a("a",{on:{click:t.showAddDepartment}},[a("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),a("template",{slot:"footer"},[a("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2)],1)],t._v(" "),a("div",{staticClass:"flex justify-center m-3"},[a("button",{staticClass:"button is-small is-rounded",class:{"is-loading":t.loading},attrs:{disabled:t.disableSubmitButton,type:"submit"},on:{click:function(e){return e.preventDefault(),e.stopPropagation(),t.updateDesignation(e)}}},[t._v("Submit\n                ")])])],2)])},[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"has-text-centered m-3"},[e("h1",{staticClass:"has-text-black"},[e("b",[this._v("Add Designation")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v(" Name "),e("span",[e("sup",[this._v("*")])])])}],!1,null,null,null).exports,c={components:{ModalTemplate:n.a,DesignationEditForm:d},data:()=>({}),methods:{},created(){}},u=Object(l.a)(c,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("ModalTemplate",{ref:"modalTemplate",attrs:{overflow:"visible"},on:{modalClosed:function(e){return t.$router.back()}}},[t._t("modal-content",[a("DesignationEditForm",{attrs:{slot:"modal-content","designation-id":t.$route.params.id},slot:"modal-content"})])],2)},[],!1,null,null,null);e.default=u.exports},70:function(t,e,a){"use strict";(function(t){e.a={methods:{closeModal(){t(this.$refs.modalBackground).toggleClass("scaleInCircle"),t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,a(72))},71:function(t,e,a){"use strict";var n={mixins:[a(70).a],props:{overflow:{required:!1,default:"auto"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal()}},s=a(2),i=Object(s.a)(n,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{ref:"modal",staticClass:"modal"},[a("div",{ref:"modalBackground",staticClass:"modal-background"}),t._v(" "),a("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[a("div",{staticClass:"box"},[t._t("modal-content")],2)]),t._v(" "),t.showCloseButton?[a("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(e){return e.stopPropagation(),t.closeModal(e)}}})]:t._e()],2)},[],!1,null,null,null);e.a=i.exports},82:function(t,e,a){(function(e){var a="Expected a function",n=NaN,s="[object Symbol]",i=/^\s+|\s+$/g,o=/^[-+]0x[0-9a-f]+$/i,r=/^0b[01]+$/i,l=/^0o[0-7]+$/i,d=parseInt,c="object"==typeof e&&e&&e.Object===Object&&e,u="object"==typeof self&&self&&self.Object===Object&&self,m=c||u||Function("return this")(),p=Object.prototype.toString,f=Math.max,h=Math.min,g=function(){return m.Date.now()};function v(t){var e=typeof t;return!!t&&("object"==e||"function"==e)}function b(t){if("number"==typeof t)return t;if(function(t){return"symbol"==typeof t||function(t){return!!t&&"object"==typeof t}(t)&&p.call(t)==s}(t))return n;if(v(t)){var e="function"==typeof t.valueOf?t.valueOf():t;t=v(e)?e+"":e}if("string"!=typeof t)return 0===t?t:+t;t=t.replace(i,"");var a=r.test(t);return a||l.test(t)?d(t.slice(2),a?2:8):o.test(t)?n:+t}t.exports=function(t,e,n){var s,i,o,r,l,d,c=0,u=!1,m=!1,p=!0;if("function"!=typeof t)throw new TypeError(a);function _(e){var a=s,n=i;return s=i=void 0,c=e,r=t.apply(n,a)}function C(t){var a=t-d;return void 0===d||a>=e||a<0||m&&t-c>=o}function y(){var t=g();if(C(t))return x(t);l=setTimeout(y,function(t){var a=e-(t-d);return m?h(a,o-(t-c)):a}(t))}function x(t){return l=void 0,p&&s?_(t):(s=i=void 0,r)}function D(){var t=g(),a=C(t);if(s=arguments,i=this,d=t,a){if(void 0===l)return function(t){return c=t,l=setTimeout(y,e),u?_(t):r}(d);if(m)return l=setTimeout(y,e),_(d)}return void 0===l&&(l=setTimeout(y,e)),r}return e=b(e)||0,v(n)&&(u=!!n.leading,o=(m="maxWait"in n)?f(b(n.maxWait)||0,e):o,p="trailing"in n?!!n.trailing:p),D.cancel=function(){void 0!==l&&clearTimeout(l),c=0,s=d=i=l=void 0},D.flush=function(){return void 0===l?r:x(g())},D}}).call(this,a(3))}}]);