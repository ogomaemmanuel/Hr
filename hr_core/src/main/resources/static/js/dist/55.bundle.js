(window.webpackJsonp=window.webpackJsonp||[]).push([[55],{360:function(t,s,e){var a=e(364);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,e(22).default)("16f8a623",a,!1,{})},361:function(t,s,e){"use strict";var a=function(){var t=this,s=t._self._c;return s("div",{staticClass:"modal-wrapper"},[s("div",{ref:"modal",staticClass:"modal"},[s("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[s("div",{staticClass:"box",class:t.hasPadding?"":"p-0"},[t._t("modal-content")],2)]),t._v(" "),t.showCloseButton?[s("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(s){return s.stopPropagation(),t.closeModal.apply(null,arguments)}}})]:t._e()],2)])};a._withStripped=!0;var i={mixins:[e(362).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0},hasPadding:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},l=(e(363),e(15)),r=Object(l.a)(i,a,[],!1,null,"f5b23902",null);s.a=r.exports},362:function(t,s,e){"use strict";(function(t){s.a={methods:{closeModal(){t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,e(187))},363:function(t,s,e){"use strict";e(360)},364:function(t,s,e){(t.exports=e(21)(!1)).push([t.i,".modal[data-v-f5b23902]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,.86)}.modal .modal-content[data-v-f5b23902]{overflow:visible}",""])},370:function(t,s,e){"use strict";var a=function(){var t=this,s=t._self._c;return s("div",[s("b-field",[t.showLabel?s("template",{slot:"label"},[t._v("\n      "+t._s(t.label)+" "),t.required?s("span",[s("sup",[t._v("*")])]):t._e()]):t._e(),t._v(" "),s("b-autocomplete",{attrs:{data:t.employees,placeholder:t.placeholder,field:"fullName",loading:t.isFetching,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:s=>t.selectedEmployee=s,"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(e){return[s("div",{staticClass:"media"},[s("div",{staticClass:"media-left"}),t._v(" "),s("div",{staticClass:"media-content"},[t._v("\n            "+t._s(e.option.fullName)+"\n            "),s("br"),t._v(" "),s("small")])])]}}])},[s("template",{slot:"header"},[s("a",{on:{click:t.showAddEmployee}},[s("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),s("template",{slot:"footer"},[s("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2),t._v(" "),s("div",{attrs:{slot:"message"},slot:"message"},[t._t("errors")],2)],2)],1)};a._withStripped=!0;var i=e(190),l=e.n(i),r={props:{label:{default:"Employee"},required:{default:!0},showLabel:{default:!0},placeholder:{default:"Select Employee"}},data:()=>({employees:[],loading:!1,isFetching:!1,employeeName:"",page:0,totalPages:0,selectedEmployee:{}}),methods:{showAddEmployee(){},fetchEmployees(t){axios.get("/api/employees",{params:{page:this.page,pageSize:10}}).then(({data:t})=>{t.content.forEach(t=>this.employees.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:l()((function(t){if(this.employeeName!==t&&(this.employeeName=t,this.employees=[],this.page=0,this.totalPages=0),!t.length)return this.employees=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchEmployees(t))}),500),getMoreAsyncData:l()((function(){this.getAsyncData(this.employeeName)}),250)},watch:{selectedEmployee:function(t){this.$emit("input",t.id)}}},n=e(15),o=Object(n.a)(r,a,[],!1,null,"30d6cd57",null);s.a=o.exports},624:function(t,s,e){"use strict";e.r(s);var a=function(){var t=this,s=t._self._c;return s("ModalTemplate",{on:{modalClosed:function(s){return t.$router.go(-1)}}},[s("AssetCreateForm",{attrs:{slot:"modal-content"},on:{createSuccessful:t.onCreateSuccessful},slot:"modal-content"})],1)};a._withStripped=!0;var i=e(361),l=function(){var t=this,s=t._self._c;return s("div",[s("form",[t._m(0),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(1),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.asset.name,expression:"asset.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.asset.name},on:{input:[function(s){s.target.composing||t.$set(t.asset,"name",s.target.value)},function(s){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(2),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.asset.assetId,expression:"asset.assetId"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.asset.assetId},on:{input:[function(s){s.target.composing||t.$set(t.asset,"assetId",s.target.value)},function(s){return t.clearFieldError("assetId")}]}}),t._v(" "),t.errors.assetId?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.assetId[0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(3),t._v(" "),s("div",{staticClass:"control"},[s("DatePicker",{staticClass:"datepicker",on:{input:function(s){return t.clearFieldError("purchaseDate")}},model:{value:t.asset.purchaseDate,callback:function(s){t.$set(t.asset,"purchaseDate",s)},expression:"asset.purchaseDate"}}),t._v(" "),t.errors.purchaseDate?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.purchaseDate[0])+"\n\t\t\t\t\t")]):t._e()],1)])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(4),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.asset.purchasedFrom,expression:"asset.purchasedFrom"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.asset.purchasedFrom},on:{input:[function(s){s.target.composing||t.$set(t.asset,"purchasedFrom",s.target.value)},function(s){return t.clearFieldError("purchasedFrom")}]}}),t._v(" "),t.errors.purchasedFrom?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.purchasedFrom[0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(5),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.asset.manufacturer,expression:"asset.manufacturer"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.asset.manufacturer},on:{input:[function(s){s.target.composing||t.$set(t.asset,"manufacturer",s.target.value)},function(s){return t.clearFieldError("manufacturer")}]}}),t._v(" "),t.errors.manufacturer?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.manufacturer[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(6),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.asset.model,expression:"asset.model"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.asset.model},on:{input:[function(s){s.target.composing||t.$set(t.asset,"model",s.target.value)},function(s){return t.clearFieldError("model")}]}}),t._v(" "),t.errors.model?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.model[0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(7),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.asset.serialNumber,expression:"asset.serialNumber"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.asset.serialNumber},on:{input:[function(s){s.target.composing||t.$set(t.asset,"serialNumber",s.target.value)},function(s){return t.clearFieldError("serialNumber")}]}}),t._v(" "),t.errors.serialNumber?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.serialNumber[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(8),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.asset.supplier,expression:"asset.supplier"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.asset.supplier},on:{input:[function(s){s.target.composing||t.$set(t.asset,"supplier",s.target.value)},function(s){return t.clearFieldError("supplier")}]}}),t._v(" "),t.errors.supplier?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.supplier[0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(9),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.asset.condition,expression:"asset.condition"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.asset.condition},on:{input:[function(s){s.target.composing||t.$set(t.asset,"condition",s.target.value)},function(s){return t.clearFieldError("condition")}]}}),t._v(" "),t.errors.condition?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.condition[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(10),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.asset.warrantyInMonths,expression:"asset.warrantyInMonths"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.asset.warrantyInMonths},on:{input:[function(s){s.target.composing||t.$set(t.asset,"warrantyInMonths",s.target.value)},function(s){return t.clearFieldError("warrantyInMonths")}]}}),t._v(" "),t.errors.warrantyInMonths?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.warrantyInMonths[0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(11),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.asset.value,expression:"asset.value"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.asset.value},on:{input:[function(s){s.target.composing||t.$set(t.asset,"value",s.target.value)},function(s){return t.clearFieldError("value")}]}}),t._v(" "),t.errors.value?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.value[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("EmployeeSelectInput",{attrs:{label:"Asset User"},on:{input:function(s){return t.clearFieldError("assetUserId")}},model:{value:t.asset.assetUserId,callback:function(s){t.$set(t.asset,"assetUserId",s)},expression:"asset.assetUserId"}},[t.errors.assetUserId?s("span",{staticClass:"mb-2 has-text-danger",attrs:{slot:"errors"},slot:"errors"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.assetUserId[0])+"\n\t\t\t\t\t")]):t._e()])],1)]),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(12),t._v(" "),s("div",{staticClass:"control"},[s("textarea",{directives:[{name:"model",rawName:"v-model",value:t.asset.description,expression:"asset.description"}],staticClass:"textarea",attrs:{type:"text"},domProps:{value:t.asset.description},on:{input:[function(s){s.target.composing||t.$set(t.asset,"description",s.target.value)},function(s){return t.clearFieldError("description")}]}}),t._v(" "),t.errors.description?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.description[0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column is-6"},[s("div",{staticClass:"field"},[t._m(13),t._v(" "),s("div",{staticClass:"select is-primary is-fullwidth"},[s("select",{directives:[{name:"model",rawName:"v-model",value:t.asset.status,expression:"asset.status"}],on:{input:function(s){return t.clearFieldError("status")},change:function(s){var e=Array.prototype.filter.call(s.target.options,(function(t){return t.selected})).map((function(t){return"_value"in t?t._value:t.value}));t.$set(t.asset,"status",s.target.multiple?e:e[0])}}},[s("option",{attrs:{value:"Damaged"}},[t._v("Damaged")]),t._v(" "),s("option",{attrs:{value:"Approved"}},[t._v("Approved")]),t._v(" "),s("option",{attrs:{value:"Deployed"}},[t._v("Deployed")]),t._v(" "),s("option",{attrs:{value:"Pending"}},[t._v("Pending")])]),t._v(" "),t.errors.status?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.status[0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"flex justify-center m-3"},[s("button",{staticClass:"button is-rounded",class:{"is-loading":t.loading},attrs:{disabled:t.disableSubmitButton,type:"submit"},on:{click:function(s){return s.preventDefault(),s.stopPropagation(),t.createAsset.apply(null,arguments)}}},[t._v("Submit\n        ")])])])])};l._withStripped=!0;e(185),e(83);var r=e(186),n=e.n(r),o=(e(188),e(189)),c=e.n(o),u=e(34),d=e(370),v={components:{DatePicker:c.a,EmployeeSelectInput:d.a},mixins:[u.a],data:()=>({asset:{},loading:!1}),methods:{createAsset(){this.loading=!0,axios.post("/api/assets",this.asset).then(t=>{this.loading=!1,n.a.success("Asset successfully created"),this.$emit("createSuccessful")},t=>{this.loading=!1,400==t.response.status&&(this.errors=t.response.data)})}},computed:{disableSubmitButton(){return this.loading}}},p=e(15),m=Object(p.a)(v,l,[function(){var t=this._self._c;return t("div",{staticClass:"has-text-centered m-3"},[t("h1",{staticClass:"has-text-black"},[t("b",[this._v("Add Asset")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Asset Name"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Asset ID"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Purchase Date"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Purchase From"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Manufacturer"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Model"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Serial Number"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Supplier"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Condition"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Warranty"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Value"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Description"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Status"),t("span",[t("sup",[this._v("*")])])])}],!1,null,null,null).exports,_={components:{ModalTemplate:i.a,AssetCreateForm:m},methods:{goBack(){this.$router.go(-1)},onCreateSuccessful(){this.$emit("createSuccessful"),this.goBack()}}},h=Object(p.a)(_,a,[],!1,null,null,null);s.default=h.exports}}]);