(window.webpackJsonp=window.webpackJsonp||[]).push([[5],{148:function(t,e,s){"use strict";var a=s(94);s.n(a).a},149:function(t,e,s){(t.exports=s(5)(!1)).push([t.i,".datepicker[data-v-fe7a44b8]{min-width:100%}\n",""])},150:function(t,e,s){"use strict";var a=s(95);s.n(a).a},151:function(t,e,s){(t.exports=s(5)(!1)).push([t.i,".datepicker[data-v-0ac89aa8]{min-width:100%}\n",""])},152:function(t,e,s){"use strict";var a=s(96);s.n(a).a},153:function(t,e,s){(t.exports=s(5)(!1)).push([t.i,".delete-contact[data-v-09419f4e]{position:absolute;top:3rem;right:-0.2rem}.contact-header[data-v-09419f4e]{padding:10px 10px;background-color:#fafbfc;border-top-left-radius:3px;border-top-right-radius:3px}\n",""])},154:function(t,e,s){"use strict";var a=s(97);s.n(a).a},155:function(t,e,s){(t.exports=s(5)(!1)).push([t.i,'.steps[data-v-209eaa3f]{display:-ms-flexbox;display:flex;-ms-flex-wrap:wrap;flex-wrap:wrap;font-size:1rem;min-height:2rem;flex-wrap:nowrap !important}.steps[data-v-209eaa3f]:not(:last-child){margin-bottom:1.5rem}.steps .step-item[data-v-209eaa3f]{margin-top:0;position:relative;-ms-flex-positive:1;flex-grow:1;-ms-flex-preferred-size:0;flex-basis:0;background:#f2f5f9;padding-top:20px;padding-bottom:15px}.steps .step-item[data-v-209eaa3f]:before{background:linear-gradient(to left, #dbdbdb 50%, #00d1b2 50%);background-position-x:0%;background-position-y:0%;background-size:auto;background-size:200% 100%;background-position:right bottom}.steps .step-item[data-v-209eaa3f]:not(:first-child):before{height:.2em;width:100%;bottom:0;left:-50%;top:2.2rem;content:" ";display:block;position:absolute}.steps .step-item .step-marker[data-v-209eaa3f]{-ms-flex-align:center;align-items:center;display:-ms-flexbox;display:flex;border-radius:50%;font-weight:700;-ms-flex-pack:center;justify-content:center;background-color:#b5b5b5;color:#fff;border:0.2em solid #fff;z-index:1;height:2rem;width:2rem;position:absolute;left:calc(50% - 1rem)}.steps .step-item .step-details[data-v-209eaa3f]{margin-top:2rem;margin-left:.5em;margin-right:.5em;padding-top:.2em;text-align:center}.steps .step-item .step-details .step-title[data-v-209eaa3f]{font-size:0.9rem;font-weight:500}.steps .step-item.is-active[data-v-209eaa3f]:before{background-position:left bottom}.steps .step-item.is-active .step-marker[data-v-209eaa3f]{background-color:#fff;border-color:#00d1b2;color:#00d1b2}\n',""])},165:function(t,e,s){"use strict";s.r(e);var a=s(77),i=s.n(a),n=(s(79),s(24),s(80)),o=s.n(n),r=s(12),l={components:{DatePicker:o.a},mixins:[r.a],props:{employeeDetails:{required:!0}},data:()=>({basicInfo:{firstName:"",lastName:"",phone:"",email:"",dateOfBirth:"",identityNo:"",city:"",postalAddress:"",maritalStatusId:""},isLoading:!1}),computed:{canMoveNext:()=>!0},methods:{onNext(){this.employeeDetails.basicInfo=this.basicInfo,this.$emit("goToNext",!1)},validateBasicInfo(){return this.basicInfo.firstName.length>0&&this.basicInfo.lastName.length>0&&this.basicInfo.city.length>0&&this.basicInfo.phone.length>0&&this.basicInfo.identityNo.length>0&&this.basicInfo.dateOfBirth.toString().length>0&&this.basicInfo.postalAddress.length>0&&this.basicInfo.maritalStatusId.length>0}}},c=(s(148),s(2)),d=Object(c.a)(l,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("div",{staticClass:"steps-body pt-4 pb-4 pl-0 pr-0"},[s("div",{staticClass:"steps-content",attrs:{"data-v-5d80c0af":""}},[s("div",{staticClass:"step-content has-text-left is-active animated preFadeInUp fadeInUp",attrs:{"data-v-5d80c0af":""}},[s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(0),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.basicInfo.firstName,expression:"basicInfo.firstName"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.basicInfo.firstName},on:{input:[function(e){e.target.composing||t.$set(t.basicInfo,"firstName",e.target.value)},function(e){return t.clearFieldError("firstName")}]}}),t._v(" "),t.errors.firstName?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.firstName[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(1),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.basicInfo.lastName,expression:"basicInfo.lastName"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.basicInfo.lastName},on:{input:[function(e){e.target.composing||t.$set(t.basicInfo,"lastName",e.target.value)},function(e){return t.clearFieldError("lastName")}]}}),t._v(" "),t.errors.lastName?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.lastName[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(2),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.basicInfo.phone,expression:"basicInfo.phone"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.basicInfo.phone},on:{input:[function(e){e.target.composing||t.$set(t.basicInfo,"phone",e.target.value)},function(e){return t.clearFieldError("basicInfo.phone")}]}}),t._v(" "),t.errors["basicInfo.phone"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["basicInfo.phone"][0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(3),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.basicInfo.email,expression:"basicInfo.email"}],staticClass:"input",attrs:{type:"email"},domProps:{value:t.basicInfo.email},on:{input:[function(e){e.target.composing||t.$set(t.basicInfo,"email",e.target.value)},function(e){return t.clearFieldError("basicInfo.email")}]}}),t._v(" "),t.errors["basicInfo.email"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["basicInfo.email"][0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(4),t._v(" "),s("div",{staticClass:"control"},[s("DatePicker",{staticClass:"datepicker",on:{input:function(e){return t.clearFieldError("basicInfo.dateOfBirth")}},model:{value:t.basicInfo.dateOfBirth,callback:function(e){t.$set(t.basicInfo,"dateOfBirth",e)},expression:"basicInfo.dateOfBirth"}}),t._v(" "),t.errors["basicInfo.dateOfBirth"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["basicInfo.dateOfBirth"][0])+"\n\t\t\t\t\t")]):t._e()],1)])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(5),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.basicInfo.identityNo,expression:"basicInfo.identityNo"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.basicInfo.identityNo},on:{input:[function(e){e.target.composing||t.$set(t.basicInfo,"identityNo",e.target.value)},function(e){return t.clearFieldError("basicInfo.identityNo")}]}}),t._v(" "),t.errors["basicInfo.identityNo"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["basicInfo.identityNo"][0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(6),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.basicInfo.city,expression:"basicInfo.city"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.basicInfo.city},on:{input:[function(e){e.target.composing||t.$set(t.basicInfo,"city",e.target.value)},function(e){return t.clearFieldError("basicInfo.city")}]}}),t._v(" "),t.errors["basicInfo.city"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["basicInfo.city"][0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(7),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.basicInfo.postalAddress,expression:"basicInfo.postalAddress"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.basicInfo.postalAddress},on:{input:[function(e){e.target.composing||t.$set(t.basicInfo,"postalAddress",e.target.value)},function(e){return t.clearFieldError("postalAddress")}]}}),t._v(" "),t.errors.postalAddress?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.postalAddress[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(8),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.basicInfo.maritalStatusId,expression:"basicInfo.maritalStatusId"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.basicInfo.maritalStatusId},on:{input:[function(e){e.target.composing||t.$set(t.basicInfo,"maritalStatusId",e.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])])])])])])]),t._v(" "),t._t("default",null,{isLoading:t.isLoading,canMoveNext:t.canMoveNext,onNext:t.onNext})],2)},[function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("First Name "),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Last Name "),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Phone"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Email"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Date of Birth"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Id No"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Residential Address"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Postal Address"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Marital Status"),e("span",[e("sup",[this._v("*")])])])}],!1,null,"fe7a44b8",null).exports,p=s(82),m=s.n(p),u={data:()=>({departments:[],loading:!1,isFetching:!1,departmentName:"",page:0,totalPages:0,selectedDepartment:{}}),methods:{showAddDepartment(){},fetchDepartments(t){axios.get("/api/departments",{params:{page:this.page,pageSize:10}}).then(({data:t})=>{t.content.forEach(t=>this.departments.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:m()(function(t){if(this.departmentName!==t&&(this.departmentName=t,this.departments=[],this.page=0,this.totalPages=0),!t.length)return this.departments=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchDepartments(t))},500),getMoreAsyncData:m()(function(){this.getAsyncData(this.departmentName)},250)},watch:{selectedDepartment:function(t){this.$emit("input",t.id)}}},v=Object(c.a)(u,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("b-field",[s("template",{slot:"label"},[t._v("\n            Department "),s("span",[s("sup",[t._v("*")])])]),t._v(" "),s("b-autocomplete",{attrs:{data:t.departments,placeholder:"Department name",field:"name",loading:t.isFetching,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:function(e){return t.selectedDepartment=e},"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(e){return[s("div",{staticClass:"media"},[s("div",{staticClass:"media-left"}),t._v(" "),s("div",{staticClass:"media-content"},[t._v("\n                        "+t._s(e.option.name)+"\n                        "),s("br"),t._v(" "),s("small")])])]}}])},[s("template",{slot:"header"},[s("a",{on:{click:t.showAddDepartment}},[s("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),s("template",{slot:"footer"},[s("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2)],2)],1)},[],!1,null,"650a8f71",null).exports,f={data:()=>({designations:[],loading:!1,isFetching:!1,departmentName:"",page:0,totalPages:0,selectedDesignation:{}}),methods:{showAddDepartment(){},fetchDesignations(t){axios.get("/api/designations",{params:{page:this.page,pageSize:10}}).then(({data:t})=>{t.content.forEach(t=>this.designations.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:m()(function(t){if(this.departmentName!==t&&(this.departmentName=t,this.designations=[],this.page=0,this.totalPages=0),!t.length)return this.designations=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchDesignations(t))},500),getMoreAsyncData:m()(function(){this.getAsyncData(this.departmentName)},250)},watch:{selectedDesignation:function(t){this.$emit("input",t.id)}}},h=Object(c.a)(f,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("b-field",[s("template",{slot:"label"},[t._v("\n            Designation "),s("span",[s("sup",[t._v("*")])])]),t._v(" "),s("b-autocomplete",{attrs:{data:t.designations,placeholder:"Search Designation",field:"name",loading:t.isFetching,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:function(e){return t.selectedDesignation=e},"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(e){return[s("div",{staticClass:"media"},[s("div",{staticClass:"media-left"}),t._v(" "),s("div",{staticClass:"media-content"},[t._v("\n                        "+t._s(e.option.name)+"\n                        "),s("br"),t._v(" "),s("small")])])]}}])},[s("template",{slot:"header"},[s("a",{on:{click:t.showAddDepartment}},[s("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),s("template",{slot:"footer"},[s("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2)],2)],1)},[],!1,null,"55d556fe",null).exports,_={components:{DatePicker:o.a,DepartmentSelectInput:v,DesignationSelectInput:h},mixins:[r.a],props:{employeeDetails:{required:!0}},data:()=>({isLoading:!1,canMoveNext:!0,employementDetail:{}}),created(){this.employeeDetails.employementDetail=this.employementDetail},methods:{onNext(){this.$emit("goToNext",!1)}}},b=(s(150),Object(c.a)(_,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("div",[s("div",{staticClass:"steps-body pt-4 pb-4 pl-0 pr-0"},[s("div",{staticClass:"steps-content"},[s("div",{staticClass:"step-content has-text-left is-active animated preFadeInUp fadeInUp"},[s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("DepartmentSelectInput",{model:{value:t.employementDetail.departmentId,callback:function(e){t.$set(t.employementDetail,"departmentId",e)},expression:"employementDetail.departmentId"}})],1),t._v(" "),s("div",{staticClass:"column"},[s("DesignationSelectInput",{on:{input:function(e){return t.clearFieldError("designationId")}},model:{value:t.employementDetail.designationId,callback:function(e){t.$set(t.employementDetail,"designationId",e)},expression:"employementDetail.designationId"}}),t._v(" "),t.errors.designationId?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()],1),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(0),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.employementDetail.salaryAmount,expression:"employementDetail.salaryAmount"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.employementDetail.salaryAmount},on:{input:[function(e){e.target.composing||t.$set(t.employementDetail,"salaryAmount",e.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(1),t._v(" "),s("div",{staticClass:"control"},[s("DatePicker",{staticClass:"datepicker",on:{input:function(e){return t.clearFieldError("joiningDate")}},model:{value:t.employementDetail.joiningDate,callback:function(e){t.$set(t.employementDetail,"joiningDate",e)},expression:"employementDetail.joiningDate"}}),t._v(" "),t.errors.joiningDate?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.joiningDate[0])+"\n\t\t\t\t\t")]):t._e()],1)])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(2),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.employementDetail.supervisorId,expression:"employementDetail.supervisorId"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.employementDetail.supervisorId},on:{input:[function(e){e.target.composing||t.$set(t.employementDetail,"supervisorId",e.target.value)},function(e){return t.clearFieldError("supervisorId")}]}}),t._v(" "),t.errors.supervisorId?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.supervisorId[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(3),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.employementDetail.shiftId,expression:"employementDetail.shiftId"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.employementDetail.shiftId},on:{input:[function(e){e.target.composing||t.$set(t.employementDetail,"shiftId",e.target.value)},function(e){return t.clearFieldError("salaryAmount")}]}}),t._v(" "),t.errors.salaryAmount?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.salaryAmount[0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(4),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.employementDetail.nhifNo,expression:"employementDetail.nhifNo"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.employementDetail.nhifNo},on:{input:[function(e){e.target.composing||t.$set(t.employementDetail,"nhifNo",e.target.value)},function(e){return t.clearFieldError("nhifNo")}]}}),t._v(" "),t.errors.nhifNo?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(5),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.employementDetail.nssfNo,expression:"employementDetail.nssfNo"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.employementDetail.nssfNo},on:{input:[function(e){e.target.composing||t.$set(t.employementDetail,"nssfNo",e.target.value)},function(e){return t.clearFieldError("nssfNo")}]}}),t._v(" "),t.errors.nssfNo?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.nssfNo[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(6),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.employementDetail.kraPinNumber,expression:"employementDetail.kraPinNumber"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.employementDetail.kraPinNumber},on:{input:[function(e){e.target.composing||t.$set(t.employementDetail,"kraPinNumber",e.target.value)},function(e){return t.clearFieldError("kraPinNumber")}]}}),t._v(" "),t.errors.kraPinNumber?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.kraPinNumber[0])+"\n\t\t\t\t\t")]):t._e()])])])])])])]),t._v(" "),t._t("default",null,{isLoading:t.isLoading,onNext:t.onNext})],2)])},[function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v("Salary Amount"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Joining Date"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Supervisor"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Shift"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("NHIF No"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("NSSF No"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("KRA Pin"),e("span",[e("sup",[this._v("*")])])])}],!1,null,"0ac89aa8",null).exports),g={mixins:[r.a],props:{employeeDetails:{required:!0}},data:()=>({isLoading:!1,contactAddresses:[]}),created(){this.initialize()},computed:{contactAddressAreValid(){return this.contactAddresses.every(t=>this.validateContactAddress(t))},canMoveNext(){return this.contactAddressAreValid}},methods:{onNext(){this.employeeDetails.contactAddresses=this.contactAddresses,this.$emit("goToNext",!1)},addRow(){this.contactAddresses.push({name:"",relationshipId:"",phoneNumber:""})},initialize(){this.contactAddresses=[{name:"",relationshipId:"",phoneNumber:""},{name:"",relationshipId:"",phoneNumber:""},{name:"",relationshipId:"",phoneNumber:""}]},validateContactAddress:t=>t.name.length>0&&t.phoneNumber.length>0&&t.relationshipId.length>0,removeRow(t){this.contactAddresses.length>1&&this.contactAddresses.splice(t,1)}}},C=(s(152),Object(c.a)(g,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("div",[s("div",{staticClass:"steps-body pt-4 pb-4 pl-0 pr-0"},[s("div",{staticClass:"steps-content"},[s("div",{staticClass:"step-content has-text-left is-active animated preFadeInUp fadeInUp"},[t._l(t.contactAddresses,function(e,a){return s("div",[t.contactAddresses.length>1?s("div",{staticClass:"flex is-hidden-desktop justify-end contact-header"},[s("i",{staticClass:"fa fa-trash has-text-danger",on:{click:function(e){return t.removeRow(a)}}})]):t._e(),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(0,!0),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:e.name,expression:"contactAddress.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:e.name},on:{input:[function(s){s.target.composing||t.$set(e,"name",s.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(1,!0),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:e.phoneNumber,expression:"contactAddress.phoneNumber"}],staticClass:"input",attrs:{type:"text"},domProps:{value:e.phoneNumber},on:{input:[function(s){s.target.composing||t.$set(e,"phoneNumber",s.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column is-relative"},[s("div",{staticClass:"field"},[t._m(2,!0),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:e.relationshipId,expression:"contactAddress.relationshipId"}],staticClass:"input",attrs:{type:"text"},domProps:{value:e.relationshipId},on:{input:[function(s){s.target.composing||t.$set(e,"relationshipId",s.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),t.contactAddresses.length>1?s("i",{staticClass:"fa fa-trash has-text-danger delete-contact is-hidden-mobile",on:{click:function(e){return t.removeRow(a)}}}):t._e()])])])}),t._v(" "),s("div",{staticClass:"flex justify-end pt-2"},[s("div",[s("button",{staticClass:"button",on:{click:function(e){return t.addRow()}}},[s("i",{staticClass:"fa fa-plus"})])])])],2)])]),t._v(" "),t._t("default",null,{isLoading:t.isLoading,canMoveNext:t.canMoveNext,onNext:t.onNext})],2)])},[function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Contact Name "),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Contact Phone "),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label is-size-7"},[this._v("Relationship "),e("span",[e("sup",[this._v("*")])])])}],!1,null,"09419f4e",null).exports),y={data:()=>({isLoading:!1}),methods:{onNext(){}}},x=Object(c.a)(y,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("div",{staticClass:"steps-body  pt-4 pb-4  pr-0 pl-2"},[s("div",{staticClass:"steps-content"},[s("div",{staticClass:"step-content has-text-left is-active animated preFadeInUp fadeInUp"},[s("div",{staticClass:"step-content has-text-centered is-active"},[t._m(0),t._v(" "),s("h1",{staticClass:"title is-5 mt-2"},[t._v("Employee Successfully created!")]),t._v(" "),s("div",{},[s("button",{staticClass:"button is-success",attrs:{type:"button"}},[t._v("\n                            Add Another Employee\n                        ")]),t._v(" "),s("router-link",{staticClass:"button is-clear",attrs:{to:"/employees",tag:"button",type:"button"}},[t._v("\n                            Back to employees\n                        ")])],1)])])])]),t._v(" "),t._t("default",null,{isLoading:t.isLoading,onNext:t.onNext})],2)},[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"flex justify-center"},[e("img",{staticClass:"confirm-image pb-30",attrs:{src:"/images/illustrations/success_tick.svg",width:"40%"}})])}],!1,null,null,null).exports;function N(t,e){var s=Object.keys(t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(t);e&&(a=a.filter(function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable})),s.push.apply(s,a)}return s}var I={components:{EmployeeBasicInfoStep:d,EmployeeInfoStep:b,EmployeeContactAddressesForm:C,EmployeeCreateComplete:x},data:()=>({step:0,employeeDetails:{},visitedSteps:new Set}),created(){this.setVisited(0)},computed:{currentForm(){return 0==this.step?d:1==this.step?b:2==this.step?C:3==this.step?x:void 0}},methods:{setStem(t){(this.visitedSteps.has(t)||t<this.step)&&(this.step=t)},setVisited(t){this.visitedSteps.add(t)},createEmployee(){axios.post("/api/employees",this.employeeDetails).then(t=>{this.step=3})},goToNextStep(t){let e=this;t&&(this.employeeDetails=function(t){for(var e=1;e<arguments.length;e++){var s=null!=arguments[e]?arguments[e]:{};e%2?N(s,!0).forEach(function(e){i()(t,e,s[e])}):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(s)):N(s).forEach(function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(s,e))})}return t}({},e.employeeDetails)),2!=e.step?(e.step++,e.setVisited(e.step)):e.createEmployee()}}},D=(s(154),Object(c.a)(I,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("div",{staticClass:"card"},[s("div",{staticClass:"card-content"},[s("div",{staticClass:"steps",attrs:{id:"stepsDemo3"}},[s("div",{staticClass:"step-item",class:{"is-active":t.step>=0},on:{click:function(e){return e.preventDefault(),t.setStem(0)}}},[s("div",{staticClass:"step-marker"},[t._v("1")]),t._v(" "),t._m(0)]),t._v(" "),s("div",{staticClass:"step-item",class:{"is-active":t.step>=1},on:{click:function(e){return e.preventDefault(),t.setStem(1)}}},[s("div",{staticClass:"step-marker"},[t._v("2")]),t._v(" "),t._m(1)]),t._v(" "),s("div",{staticClass:"step-item",class:{"is-active":t.step>=2},on:{click:function(e){return e.preventDefault(),t.setStem(2)}}},[s("div",{staticClass:"step-marker"},[t._v("3")]),t._v(" "),t._m(2)]),t._v(" "),s("div",{staticClass:"step-item",class:{"is-active":t.step>=3},on:{click:function(e){return e.preventDefault(),t.setStem(3)}}},[s("div",{staticClass:"step-marker"},[t._v("4")]),t._v(" "),t._m(3)])]),t._v(" "),s("keep-alive",[s(t.currentForm,{tag:"component",attrs:{employeeDetails:t.employeeDetails},on:{goToNext:t.goToNextStep},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.isLoading,i=e.canMoveNext,n=e.onNext;return s("div",{staticClass:"nav-wrapper step-content has-text-left is-active animated preFadeInUp fadeInUp",staticStyle:{bottom:"30px"}},[s("div",{staticClass:"col-md-12"},[s("div",{staticClass:"steps-actions flex flex-row-reverse justify-between"},[s("div",{staticClass:"steps-action pl-3 step-action-next-button-wrapper"},[s("button",{staticClass:"button btn success-btn btn-align ",class:{"is-loading":a},attrs:{disabled:a||0==i,type:"button","data-nav":"next"},on:{click:n}},[t._v("\n                                        Next\n                                    ")])]),t._v(" "),t.step>0?s("div",{staticClass:"steps-action step-action-prev-button-wrapper"},[s("button",{staticClass:"button btn default-btn raised btn-align",attrs:{type:"button","data-nav":"previous"},on:{click:function(e){t.step--}}},[t._v("\n                                        Previous\n                                    ")])]):t._e()])])])}}])})],1)],1)])])},[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"step-details"},[e("p",{staticClass:"step-title"},[this._v("Basic Info")])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"step-details"},[e("p",{staticClass:"step-title"},[this._v("Employement Details")])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"step-details"},[e("p",{staticClass:"step-title"},[this._v("Employee Contact Address")])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"step-details"},[e("p",{staticClass:"step-title"},[this._v("Finish")])])}],!1,null,"209eaa3f",null));e.default=D.exports},77:function(t,e){t.exports=function(t,e,s){return e in t?Object.defineProperty(t,e,{value:s,enumerable:!0,configurable:!0,writable:!0}):t[e]=s,t}},82:function(t,e,s){(function(e){var s="Expected a function",a=NaN,i="[object Symbol]",n=/^\s+|\s+$/g,o=/^[-+]0x[0-9a-f]+$/i,r=/^0b[01]+$/i,l=/^0o[0-7]+$/i,c=parseInt,d="object"==typeof e&&e&&e.Object===Object&&e,p="object"==typeof self&&self&&self.Object===Object&&self,m=d||p||Function("return this")(),u=Object.prototype.toString,v=Math.max,f=Math.min,h=function(){return m.Date.now()};function _(t){var e=typeof t;return!!t&&("object"==e||"function"==e)}function b(t){if("number"==typeof t)return t;if(function(t){return"symbol"==typeof t||function(t){return!!t&&"object"==typeof t}(t)&&u.call(t)==i}(t))return a;if(_(t)){var e="function"==typeof t.valueOf?t.valueOf():t;t=_(e)?e+"":e}if("string"!=typeof t)return 0===t?t:+t;t=t.replace(n,"");var s=r.test(t);return s||l.test(t)?c(t.slice(2),s?2:8):o.test(t)?a:+t}t.exports=function(t,e,a){var i,n,o,r,l,c,d=0,p=!1,m=!1,u=!0;if("function"!=typeof t)throw new TypeError(s);function g(e){var s=i,a=n;return i=n=void 0,d=e,r=t.apply(a,s)}function C(t){var s=t-c;return void 0===c||s>=e||s<0||m&&t-d>=o}function y(){var t=h();if(C(t))return x(t);l=setTimeout(y,function(t){var s=e-(t-c);return m?f(s,o-(t-d)):s}(t))}function x(t){return l=void 0,u&&i?g(t):(i=n=void 0,r)}function N(){var t=h(),s=C(t);if(i=arguments,n=this,c=t,s){if(void 0===l)return function(t){return d=t,l=setTimeout(y,e),p?g(t):r}(c);if(m)return l=setTimeout(y,e),g(c)}return void 0===l&&(l=setTimeout(y,e)),r}return e=b(e)||0,_(a)&&(p=!!a.leading,o=(m="maxWait"in a)?v(b(a.maxWait)||0,e):o,u="trailing"in a?!!a.trailing:u),N.cancel=function(){void 0!==l&&clearTimeout(l),d=0,i=c=n=l=void 0},N.flush=function(){return void 0===l?r:x(h())},N}}).call(this,s(3))},94:function(t,e,s){var a=s(149);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(6).default)("8dd29676",a,!0,{})},95:function(t,e,s){var a=s(151);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(6).default)("8597caaa",a,!0,{})},96:function(t,e,s){var a=s(153);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(6).default)("192af28a",a,!0,{})},97:function(t,e,s){var a=s(155);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(6).default)("b044e8b6",a,!0,{})}}]);