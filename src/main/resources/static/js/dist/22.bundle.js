(window.webpackJsonp=window.webpackJsonp||[]).push([[22],{214:function(t,e,a){"use strict";(function(t){var i=a(169),s=a.n(i),r=a(186),o=a.n(r),n=a(37),l=a(28);function c(t,e){var a=Object.keys(t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(t);e&&(i=i.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),a.push.apply(a,i)}return a}function d(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{};e%2?c(Object(a),!0).forEach((function(e){s()(t,e,a[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(a)):c(Object(a)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(a,e))}))}return t}e.a={mixins:[n.a],props:["imageUrl"],data:()=>({croppie:null,imageCrop:"",formData:""}),methods:d(d({},Object(l.b)(["setUserAvatar"])),{},{closeImagePreview(){t(this.$refs.imagePreview).toggleClass("is-active"),this.imageUrl="",this.$emit("closepreview")},updateUserPhoto(){let e=this;this.croppie.result("blob").then((function(a){let i=new FormData;i.append("image",a,"profilePhoto.png"),axios.post("/api/profile/update-profile-photo",i).then(a=>{t(e.$refs.imagePreview).toggleClass("is-active"),e.imageUrl="",e.setUserAvatar(a.data),e.$emit("closepreview",!0)})}))}}),created(){this.imageCrop=this.imageUrl},mounted(){let t=this,e=t.$refs.newImageUrl;t.croppie&&t.croppie.destroy(),t.croppie=new o.a(e,{enableResize:!0,viewport:{width:200,height:200,type:"circle"}}),this.$refs.imagePreviewWrapper.scrollTop=this.$refs.imagePreviewWrapper.scrollHeight+this.$refs.imagePreviewWrapper.clientHeight},beforeDestroy(){this.croppie.destroy()}}}).call(this,a(163))},215:function(t,e,a){var i=a(260);"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);(0,a(27).default)("1302dfc0",i,!0,{})},216:function(t,e,a){var i=a(262);"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);(0,a(27).default)("71cff016",i,!0,{})},259:function(t,e,a){"use strict";var i=a(215);a.n(i).a},260:function(t,e,a){(t.exports=a(26)(!1)).push([t.i,".modal .modal-card[data-v-622b2101]{background-color:#FFFFFF}.modal .image-preview-wrapper[data-v-622b2101]{height:300px;max-width:100%;margin-top:5px;padding-top:5px;box-sizing:content-box;overflow:hidden}.modal .image-preview-wrapper .image-preview[data-v-622b2101]{width:100%;height:auto}\n",""])},261:function(t,e,a){"use strict";var i=a(216);a.n(i).a},262:function(t,e,a){(t.exports=a(26)(!1)).push([t.i,".fileupload input.upload[data-v-1a1558f1]{cursor:pointer;filter:alpha(opacity=0);font-size:20px;margin:0;opacity:0;padding:0;position:absolute;right:-3px;top:-3px;padding:5px}.btn[data-v-1a1558f1]{display:inline-block;font-weight:400;color:#212529;text-align:center;vertical-align:middle;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;background-color:transparent;border:1px solid transparent;padding:.375rem .75rem;font-size:1rem;line-height:1.5;border-radius:.25rem;transition:color .15s ease-in-out, background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out}.btn[data-v-1a1558f1]{font-weight:400;color:#212529;text-align:center;font-size:1rem;line-height:1.5}.fileupload.btn[data-v-1a1558f1]{position:absolute;right:0;bottom:0;left:0;background:rgba(33,33,33,0.5);border-radius:0;padding:3px 10px;border:none;color:#fff}.profile-img-wrap.edit-img[data-v-1a1558f1]{border-radius:50%;margin:0 auto 30px;position:relative}.profile-img-wrap[data-v-1a1558f1]{height:128px;position:absolute;width:128px;background:#fff;overflow:hidden}\n",""])},319:function(t,e,a){"use strict";a.r(e);var i=a(169),s=a.n(i),r=a(28),o=a(214).a,n=(a(259),a(20));function l(t,e){var a=Object.keys(t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(t);e&&(i=i.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),a.push.apply(a,i)}return a}var c={components:{ProfilePhotoPreview:Object(n.a)(o,(function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{ref:"imagePreview",staticClass:"modal is-clipped is-active"},[a("div",{ref:"modalBackground",staticClass:"modal-background"}),t._v(" "),a("div",{staticClass:"modal-card"},[a("header",{staticClass:"modal-card-head"},[a("p",{staticClass:"modal-card-title"},[t._v("Preview")]),t._v(" "),a("button",{staticClass:"delete",attrs:{"aria-label":"close"},on:{click:t.closeImagePreview}})]),t._v(" "),a("section",{ref:"imagePreviewWrapper",staticClass:"image-preview-wrapper modal-card-body"},[a("img",{ref:"newImageUrl",staticClass:"image-preview",attrs:{src:t.imageCrop,alt:""}})]),t._v(" "),a("footer",{staticClass:"modal-card-foot"},[a("button",{staticClass:"button is-success",on:{click:t.updateUserPhoto}},[t._v("Save")]),t._v(" "),a("button",{staticClass:"button",on:{click:t.closeImagePreview}},[t._v("Cancel")])])])])}),[],!1,null,"622b2101",null).exports},data:()=>({employeeId:null,showAdditions:!0,employeeSalaryInfo:{},showImagePreview:!1,newImageUrl:""}),computed:function(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{};e%2?l(Object(a),!0).forEach((function(e){s()(t,e,a[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(a)):l(Object(a)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(a,e))}))}return t}({},Object(r.c)(["authenticatedUser"])),created(){},methods:{closeImagePreview(t){this.showImagePreview=!1,this.$refs.imageForm.reset()},getEmployeeSalaryInfo(){axios.get("/api/employee-salary/"+this.employeeId).then(t=>{this.employeeSalaryInfo=t.data})},onFileChange(t){let e=this;const a=t.target.files[0];if(a.type.includes("image/"))if("function"==typeof FileReader){const t=new FileReader;t.onload=t=>{this.newImageUrl=t.target.result,e.showImagePreview=!0,e.$refs.imageForm.reset()},t.readAsDataURL(a)}else alert("Sorry, FileReader API not supported")}}},d=(a(261),Object(n.a)(c,(function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"h-full"},[a("div",{staticClass:"card min-h-48"},[a("div",{staticClass:"card-content"},[a("div",{staticClass:"content"},[a("div",{staticClass:"columns"},[a("div",{staticClass:"column is-2"},[a("div",{staticClass:"profile-image-wrapper "},[a("figure",{staticClass:"image is-128x128 relative profile-img-wrap edit-img"},[a("img",{staticClass:"is-rounded",attrs:{src:"https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg",alt:""}}),t._v(" "),a("div",{staticClass:"fileupload btn"},[a("span",{staticClass:"btn-text"},[t._v("edit")]),t._v(" "),a("form",{ref:"imageForm",attrs:{action:""}},[a("input",{ref:"imageInput",staticClass:"upload",attrs:{accept:"image/*",type:"file"},on:{change:t.onFileChange}})])])])])]),t._v(" "),a("div",{staticClass:"column is-10 pl-5"},[a("div",{staticClass:"columns"},[a("div",{staticClass:"column"},[a("div",{staticClass:"pt-5"},[a("h2",{staticClass:"font-semibold"},[t._v(t._s(t.authenticatedUser.fullName))])]),t._v(" "),a("div",{staticClass:"flex "},[a("div",{staticClass:"mr-1"},[t._m(0),t._v(" "),a("span",[t._v(t._s(t.authenticatedUser.departmentName))])]),t._v(" "),a("div",[t._m(1),t._v(" "),a("span",[t._v(t._s(t.authenticatedUser.phone))])])])]),t._v(" "),a("div",{staticClass:"column"})])])])])])]),t._v(" "),a("div",{staticClass:"card mt-1"},[a("div",{staticClass:"tabs"},[a("ul",[a("li",{class:{"is-active":t.showAdditions},on:{click:function(e){t.showAdditions=!0}}},[a("a",[t._v("Profile")])]),t._v(" "),a("li",{class:{"is-active":!t.showAdditions},on:{click:function(e){t.showAdditions=!1}}},[a("a",[t._v("Projects")])]),t._v(" "),a("li",{class:{"is-active":!t.showAdditions},on:{click:function(e){t.showAdditions=!1}}},[a("a",[t._v("Bank & Statutory")])])])])]),t._v(" "),t._m(2),t._v(" "),t._m(3),t._v(" "),t.showImagePreview?a("ProfilePhotoPreview",{attrs:{imageUrl:t.newImageUrl},on:{closepreview:t.closeImagePreview}}):t._e()],1)}),[function(){var t=this.$createElement,e=this._self._c||t;return e("span",[e("i",{staticClass:"fa fa-building"})])},function(){var t=this.$createElement,e=this._self._c||t;return e("span",[e("i",{staticClass:"fa fa-phone"})])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"columns mt-2"},[e("div",{staticClass:"column"},[e("div",{staticClass:"card h-full"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"flex"},[e("h1",{staticClass:"flex-1"},[this._v("Personal Informations ")]),this._v(" "),e("div",[e("button",[e("i",{staticClass:"fa fa-edit"})])])])])])]),this._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"card h-full"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"flex"},[e("h1",{staticClass:"flex-1"},[this._v("Emergency Contact")]),this._v(" "),e("div",[e("button",[e("i",{staticClass:"fa fa-edit"})])])])])])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"columns mt-2"},[e("div",{staticClass:"column"},[e("div",{staticClass:"card h-full"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"flex"},[e("h1",{staticClass:"flex-1"},[this._v("Bank information ")]),this._v(" "),e("div",[e("button",[e("i",{staticClass:"fa fa-edit"})])])])])])]),this._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"card h-full"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"flex"},[e("h1",{staticClass:"flex-1"},[this._v("Family Informations")]),this._v(" "),e("div",[e("button",[e("i",{staticClass:"fa fa-edit"})])])])])])])])}],!1,null,"1a1558f1",null));e.default=d.exports}}]);