(window.webpackJsonp=window.webpackJsonp||[]).push([[29],{222:function(t,e,i){"use strict";(function(t){var a=i(174),s=i.n(a),r=i(193),o=i.n(r),l=i(37),n=i(28);function c(t,e){var i=Object.keys(t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(t);e&&(a=a.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),i.push.apply(i,a)}return i}function d(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{};e%2?c(Object(i),!0).forEach((function(e){s()(t,e,i[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(i)):c(Object(i)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(i,e))}))}return t}e.a={mixins:[l.a],props:["imageUrl"],data:()=>({croppie:null,imageCrop:"",formData:""}),methods:d(d({},Object(n.b)(["setUserAvatar"])),{},{closeImagePreview(){t(this.$refs.imagePreview).toggleClass("is-active"),this.imageUrl="",this.$emit("closepreview")},updateUserPhoto(){let e=this;this.croppie.result("blob").then((function(i){let a=new FormData;a.append("image",i,"profilePhoto.png"),axios.post("/api/profile/update-profile-photo",a).then(i=>{t(e.$refs.imagePreview).toggleClass("is-active"),e.imageUrl="",e.setUserAvatar(i.data),e.$emit("closepreview",!0)})}))}}),created(){this.imageCrop=this.imageUrl},mounted(){let t=this,e=t.$refs.newImageUrl;t.croppie&&t.croppie.destroy(),t.croppie=new o.a(e,{enableResize:!0,viewport:{width:200,height:200,type:"circle"}}),this.$refs.imagePreviewWrapper.scrollTop=this.$refs.imagePreviewWrapper.scrollHeight+this.$refs.imagePreviewWrapper.clientHeight},beforeDestroy(){this.croppie.destroy()}}}).call(this,i(166))},223:function(t,e,i){var a=i(278);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,i(27).default)("1302dfc0",a,!0,{})},224:function(t,e,i){var a=i(280);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,i(27).default)("28de5856",a,!0,{})},277:function(t,e,i){"use strict";var a=i(223);i.n(a).a},278:function(t,e,i){(t.exports=i(26)(!1)).push([t.i,".modal .modal-card[data-v-622b2101]{background-color:#FFFFFF}.modal .image-preview-wrapper[data-v-622b2101]{height:300px;max-width:100%;margin-top:5px;padding-top:5px;box-sizing:content-box;overflow:hidden}.modal .image-preview-wrapper .image-preview[data-v-622b2101]{width:100%;height:auto}\n",""])},279:function(t,e,i){"use strict";var a=i(224);i.n(a).a},280:function(t,e,i){(t.exports=i(26)(!1)).push([t.i,".fileupload input.upload[data-v-7865e73b]{cursor:pointer;filter:alpha(opacity=0);font-size:20px;margin:0;opacity:0;padding:0;position:absolute;right:-3px;top:-3px;padding:5px}.btn[data-v-7865e73b]{display:inline-block;font-weight:400;color:#212529;text-align:center;vertical-align:middle;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;background-color:transparent;border:1px solid transparent;padding:.375rem .75rem;font-size:1rem;line-height:1.5;border-radius:.25rem;transition:color .15s ease-in-out, background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out}.btn[data-v-7865e73b]{font-weight:400;color:#212529;text-align:center;font-size:1rem;line-height:1.5}.fileupload.btn[data-v-7865e73b]{position:absolute;right:0;bottom:0;left:0;background:rgba(33,33,33,0.5);border-radius:0;padding:3px 10px;border:none;color:#fff}.profile-img-wrap.edit-img[data-v-7865e73b]{border-radius:50%;margin:0 auto 30px;position:relative}.profile-img-wrap[data-v-7865e73b]{height:128px;position:absolute;width:128px;background:#fff;overflow:hidden}\n",""])},353:function(t,e,i){"use strict";i.r(e);var a=i(174),s=i.n(a),r=i(28),o=i(222).a,l=(i(277),i(20));function n(t,e){var i=Object.keys(t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(t);e&&(a=a.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),i.push.apply(i,a)}return i}var c={components:{ProfilePhotoPreview:Object(l.a)(o,(function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{ref:"imagePreview",staticClass:"modal is-clipped is-active"},[i("div",{ref:"modalBackground",staticClass:"modal-background"}),t._v(" "),i("div",{staticClass:"modal-card"},[i("header",{staticClass:"modal-card-head"},[i("p",{staticClass:"modal-card-title"},[t._v("Preview")]),t._v(" "),i("button",{staticClass:"delete",attrs:{"aria-label":"close"},on:{click:t.closeImagePreview}})]),t._v(" "),i("section",{ref:"imagePreviewWrapper",staticClass:"image-preview-wrapper modal-card-body"},[i("img",{ref:"newImageUrl",staticClass:"image-preview",attrs:{src:t.imageCrop,alt:""}})]),t._v(" "),i("footer",{staticClass:"modal-card-foot"},[i("button",{staticClass:"button is-success",on:{click:t.updateUserPhoto}},[t._v("Save")]),t._v(" "),i("button",{staticClass:"button",on:{click:t.closeImagePreview}},[t._v("Cancel")])])])])}),[],!1,null,"622b2101",null).exports},data:()=>({employeeId:null,showAdditions:!0,employeeSalaryInfo:{},showImagePreview:!1,newImageUrl:""}),computed:function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{};e%2?n(Object(i),!0).forEach((function(e){s()(t,e,i[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(i)):n(Object(i)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(i,e))}))}return t}({},Object(r.c)(["authenticatedUser"])),created(){},methods:{closeImagePreview(t){this.showImagePreview=!1,this.$refs.imageForm.reset()},getEmployeeSalaryInfo(){axios.get("/api/employee-salary/"+this.employeeId).then(t=>{this.employeeSalaryInfo=t.data})},onFileChange(t){let e=this;const i=t.target.files[0];if(i.type.includes("image/"))if("function"==typeof FileReader){const t=new FileReader;t.onload=t=>{this.newImageUrl=t.target.result,e.showImagePreview=!0,e.$refs.imageForm.reset()},t.readAsDataURL(i)}else alert("Sorry, FileReader API not supported")}}},d=(i(279),Object(l.a)(c,(function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"h-full"},[i("div",{staticClass:"card min-h-48"},[i("div",{staticClass:"card-content"},[i("div",{staticClass:"content"},[i("div",{staticClass:"columns"},[i("div",{staticClass:"column is-2"},[i("div",{staticClass:"profile-image-wrapper "},[i("figure",{staticClass:"image is-128x128 relative profile-img-wrap edit-img"},[i("img",{staticClass:"is-rounded",attrs:{src:"https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg",alt:""}}),t._v(" "),i("div",{staticClass:"fileupload btn"},[i("span",{staticClass:"btn-text"},[t._v("edit")]),t._v(" "),i("form",{ref:"imageForm",attrs:{action:""}},[i("input",{ref:"imageInput",staticClass:"upload",attrs:{accept:"image/*",type:"file"},on:{change:t.onFileChange}})])])])])]),t._v(" "),i("div",{staticClass:"column is-10 pl-5"},[i("div",{staticClass:"columns"},[i("div",{staticClass:"column"},[i("div",{staticClass:"pt-5"},[i("h2",{staticClass:"font-semibold"},[t._v(t._s(t.authenticatedUser.fullName))])]),t._v(" "),i("div",{staticClass:"flex "},[i("div",{staticClass:"mr-1"},[t._m(0),t._v(" "),i("span",[t._v(t._s(t.authenticatedUser.departmentName))])]),t._v(" "),i("div",[t._m(1),t._v(" "),i("span",[t._v(t._s(t.authenticatedUser.phone))])])])]),t._v(" "),i("div",{staticClass:"column"})])])])])])]),t._v(" "),i("div",{staticClass:"card mt-1"},[i("div",{staticClass:"tabs"},[i("ul",[i("li",{class:{"is-active":t.showAdditions},on:{click:function(e){t.showAdditions=!0}}},[i("a",[t._v("Profile")])]),t._v(" "),i("li",{class:{"is-active":!t.showAdditions},on:{click:function(e){t.showAdditions=!1}}},[i("a",[t._v("Projects")])]),t._v(" "),i("li",{class:{"is-active":!t.showAdditions},on:{click:function(e){t.showAdditions=!1}}},[i("a",[t._v("Bank & Statutory")])])])])]),t._v(" "),t._m(2),t._v(" "),t._m(3),t._v(" "),t.showImagePreview?i("ProfilePhotoPreview",{attrs:{imageUrl:t.newImageUrl},on:{closepreview:t.closeImagePreview}}):t._e()],1)}),[function(){var t=this.$createElement,e=this._self._c||t;return e("span",[e("i",{staticClass:"fa fa-building"})])},function(){var t=this.$createElement,e=this._self._c||t;return e("span",[e("i",{staticClass:"fa fa-phone"})])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"columns mt-2"},[e("div",{staticClass:"column"},[e("div",{staticClass:"card h-full"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"flex"},[e("h1",{staticClass:"flex-1 title is-5"},[this._v("Personal Informations ")]),this._v(" "),e("div",[e("button",[e("i",{staticClass:"fa fa-edit"})])])])])])]),this._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"card h-full"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"flex"},[e("h1",{staticClass:"flex-1 title is-5"},[this._v("Emergency Contact")]),this._v(" "),e("div",[e("button",[e("i",{staticClass:"fa fa-edit"})])])])])])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"columns mt-2"},[e("div",{staticClass:"column"},[e("div",{staticClass:"card h-full"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"flex"},[e("h1",{staticClass:"flex-1 title is-5"},[this._v("Bank information ")]),this._v(" "),e("div",[e("button",[e("i",{staticClass:"fa fa-edit"})])])])])])]),this._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"card h-full"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"flex"},[e("h1",{staticClass:"flex-1 title is-5"},[this._v("Family Informations")]),this._v(" "),e("div",[e("button",[e("i",{staticClass:"fa fa-edit"})])])])])])])])}],!1,null,"7865e73b",null));e.default=d.exports}}]);