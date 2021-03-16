(window.webpackJsonp=window.webpackJsonp||[]).push([[25],{208:function(t,e,s){"use strict";var a=s(169),i=s.n(a),n={props:{label:{default:"Client"},required:{default:!0},emitAllFields:{default:!1},value:{}},data:()=>({clients:[],loading:!1,isFetching:!1,clientName:"",page:0,totalPages:0,selectedClient:{}}),mounted(){this.value&&this.$refs.autocomplete.setSelected(this.value)},methods:{showAddEmployee(){},fetchClients(t){axios.get("/api/clients",{params:{page:this.page,pageSize:10}}).then(({data:t})=>{t.content.forEach(t=>this.clients.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:i()((function(t){if(this.clientName!==t&&(this.clientName=t,this.clients=[],this.page=0,this.totalPages=0),!t.length)return this.clients=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchClients(t))}),500),getMoreAsyncData:i()((function(){this.getAsyncData(this.clientName)}),250)},watch:{selectedClient:function(t){this.emitAllFields&&t?this.$emit("input",t):this.emitAllFields&&0==t?this.$emit("input",{}):t?this.$emit("input",t.id):this.$emit("input","")}}},l=s(20),r=Object(l.a)(n,(function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("b-field",[s("template",{slot:"label"},[t._v("\n      "+t._s(t.label)+" "),t.required?s("span",[s("sup",[t._v("*")])]):t._e()]),t._v(" "),s("b-autocomplete",{ref:"autocomplete",attrs:{data:t.clients,placeholder:"Select Client",field:"fullName",loading:t.isFetching,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:function(e){return t.selectedClient=e},"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(e){return[s("div",{staticClass:"media"},[s("div",{staticClass:"media-left"}),t._v(" "),s("div",{staticClass:"media-content"},[t._v("\n            "+t._s(e.option.fullName)+"\n            "),s("br"),t._v(" "),s("small")])])]}}])},[s("template",{slot:"header"},[s("a",{on:{click:t.showAddEmployee}},[s("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),s("template",{slot:"footer"},[s("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2),t._v(" "),s("div",{attrs:{slot:"message"},slot:"message"},[t._t("errors")],2)],2)],1)}),[],!1,null,"4ee1a7b7",null);e.a=r.exports},210:function(t,e,s){var a=s(255);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(27).default)("1b8ae346",a,!0,{})},254:function(t,e,s){"use strict";var a=s(210);s.n(a).a},255:function(t,e,s){(t.exports=s(26)(!1)).push([t.i,".estimate-remove-btn[data-v-69131426]{position:absolute;right:-1rem;top:0.5rem}\n",""])},257:function(t,e,s){var a=s(314);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(27).default)("4631352c",a,!0,{})},261:function(t,e,s){"use strict";s(175),s(73);var a=s(176),i=s.n(a),n=s(37),l={components:{ClientSelectInput:s(208).a,InputNumber:i.a},mixins:[n.a],props:{estimateItem:{required:!0},index:{},errorMessages:{}},methods:{removeEstimateItem(t){this.$emit("removedItem",t)}},watch:{errorMessages(t){this.errors=t}}},r=(s(254),s(20)),o=Object(r.a)(l,(function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("tr",[s("td",[t._v("\n    "+t._s(t.index+1)+"\n  ")]),t._v(" "),s("td",[s("div",{staticClass:"field"},[s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.estimateItem.name,expression:"estimateItem.name"}],staticClass:"input",domProps:{value:t.estimateItem.name},on:{input:[function(e){e.target.composing||t.$set(t.estimateItem,"name",e.target.value)},function(e){return t.clearFieldError("items["+t.index+"].name")}]}}),t._v(" "),t.errors["items["+t.index+"].name"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n           "+t._s(t.errors["items["+t.index+"].name"][0])+"\n        ")]):t._e()])])]),t._v(" "),s("td",[s("div",{staticClass:"field"},[s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.estimateItem.description,expression:"estimateItem.description"}],staticClass:"input",attrs:{placeholder:"Textarea"},domProps:{value:t.estimateItem.description},on:{input:[function(e){e.target.composing||t.$set(t.estimateItem,"description",e.target.value)},function(e){return t.clearFieldError("items["+t.index+"].description")}]}}),t._v(" "),t.errors["items["+t.index+"].description"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n           "+t._s(t.errors["items["+t.index+"].description"][0])+"\n        ")]):t._e()])])]),t._v(" "),s("td",[s("div",{staticClass:"field"},[s("div",{staticClass:"control"},[s("InputNumber",{attrs:{controls:!1},on:{input:function(e){return t.clearFieldError("items["+t.index+"].unitCost")}},model:{value:t.estimateItem.unitCost,callback:function(e){t.$set(t.estimateItem,"unitCost",e)},expression:"estimateItem.unitCost"}}),t._v(" "),t.errors["items["+t.index+"].unitCost"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n           "+t._s(t.errors["items["+t.index+"].unitCost"][0])+"\n        ")]):t._e()],1)])]),t._v(" "),s("td",[s("div",{staticClass:"field"},[s("div",{staticClass:"control"},[s("InputNumber",{attrs:{min:1},on:{input:function(e){return t.clearFieldError("items["+t.index+"].quantity")}},model:{value:t.estimateItem.qty,callback:function(e){t.$set(t.estimateItem,"qty",e)},expression:"estimateItem.qty"}}),t._v(" "),t.errors["items["+t.index+"].quantity"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n           "+t._s(t.errors["items["+t.index+"].quantity"][0])+"\n        ")]):t._e()],1)])]),t._v(" "),s("td",[s("div",{staticClass:"field"},[s("div",{staticClass:"control is-relative"},[s("input",{staticClass:"input",attrs:{placeholder:"Textarea"}}),t._v(" "),s("div",{staticClass:"estimate-remove-btn has-text-danger",on:{click:function(e){return t.removeEstimateItem(t.index)}}},[s("i",{staticClass:"fa fa-trash"})])])])])])}),[],!1,null,"69131426",null);e.a=o.exports},313:function(t,e,s){"use strict";var a=s(257);s.n(a).a},314:function(t,e,s){(t.exports=s(26)(!1)).push([t.i,".estimate-remove-btn[data-v-6b1b4f92]{position:absolute;right:-1rem;top:0.5rem}\n",""])},388:function(t,e,s){"use strict";s.r(e);s(170),s(73);var a=s(171),i=s.n(a),n=(s(175),s(176)),l=s.n(n),r=(s(167),s(168)),o=s.n(r),c=s(37),m=s(208),d=s(261),u={components:{DatePicker:o.a,InputNumber:l.a,ClientSelectInput:m.a,EstimateItemCreate:d.a},mixins:[c.a],data:()=>({taxes:[],estimateId:"",selectClient:{},estimateLoaded:!1,estimate:{taxId:"",estimateItems:[{}]}}),computed:{estimateItems(){return this.estimate.estimateItems}},created(){this.estimateId=this.$route.params.id,this.getEstimateById(),this.getTaxes()},methods:{addEstimateItemRow(){this.estimate.estimateItems.push({})},updateEstimate(){this.estimate.clientId=this.selectClient.id,axios.put("/api/estimates/"+this.estimateId,this.estimate).then(t=>{i.a.success("Estimate successfully created")},t=>{i.a.error("There was problem estimate"),400==t.response.status&&(this.errors=t.response.data)})},removeEstimateItem(t){this.estimateItems.length>1&&this.estimateItems.splice(t,1)},getEstimateById(){axios.get("/api/estimates/"+this.estimateId).then(t=>{this.estimate=t.data,this.selectClient=this.estimate.client,this.selectClient.email=this.estimate.client.user.email,this.estimateLoaded=!0},t=>{})},getTaxes(){axios.get("/api/taxes/all").then(t=>{this.taxes=t.data},t=>{console.log("Error fetching taxes  data in EstimateCreateForm")})}}},v=(s(313),s(20)),p=Object(v.a)(u,(function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[t.estimateLoaded?[s("form",{attrs:{action:""}},[s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("ClientSelectInput",{attrs:{"emit-all-fields":!0},on:{input:function(e){return t.clearFieldError("clientId")}},model:{value:t.selectClient,callback:function(e){t.selectClient=e},expression:"selectClient"}},[t.errors.clientId?s("span",{staticClass:"mb-2 has-text-danger",attrs:{slot:"errors"},slot:"errors"},[t._v("\n\t\t\t\t\t\t        "+t._s(t.errors.clientId[0])+"\n            ")]):t._e()])],1),t._v(" "),t._m(0),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[s("label",{staticClass:"label"},[t._v("Email")]),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.selectClient.email,expression:"selectClient.email"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.selectClient.email},on:{input:function(e){e.target.composing||t.$set(t.selectClient,"email",e.target.value)}}})])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[s("label",{staticClass:"label"},[t._v("Tax")]),t._v(" "),s("div",{staticClass:"select is-fullwidth"},[s("select",{directives:[{name:"model",rawName:"v-model",value:t.estimate.taxId,expression:"estimate.taxId"}],on:{change:function(e){var s=Array.prototype.filter.call(e.target.options,(function(t){return t.selected})).map((function(t){return"_value"in t?t._value:t.value}));t.$set(t.estimate,"taxId",e.target.multiple?s:s[0])}}},[s("option",{attrs:{value:"",selected:""}},[t._v("Select Tax")]),t._v(" "),t._l(t.taxes,(function(e){return s("option",{domProps:{value:e.id}},[t._v(t._s(e.name)+"\n                  ")])})),t._v(" "),s("option",[t._v("No tax")])],2)])])])]),t._v(" "),s("div",{staticClass:"columns"},[t._m(1),t._v(" "),t._m(2),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[s("label",{staticClass:"label"},[t._v("Estimate Date")]),t._v(" "),s("div",{staticClass:"control"},[s("DatePicker",{on:{input:function(e){return t.clearFieldError("estimateDate")}},model:{value:t.estimate.estimateDate,callback:function(e){t.$set(t.estimate,"estimateDate",e)},expression:"estimate.estimateDate"}}),t._v(" "),t.errors.estimateDate?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t        "+t._s(t.errors.estimateDate[0])+"\n\t\t\t\t\t    ")]):t._e()],1)])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[s("label",{staticClass:"label"},[t._v("Expiry Date")]),t._v(" "),s("div",{staticClass:"control"},[s("DatePicker",{on:{input:function(e){return t.clearFieldError("expiryDate")}},model:{value:t.estimate.expiryDate,callback:function(e){t.$set(t.estimate,"expiryDate",e)},expression:"estimate.expiryDate"}}),t._v(" "),t.errors.expiryDate?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t        "+t._s(t.errors.expiryDate[0])+"\n\t\t\t\t\t    ")]):t._e()],1)])])])]),t._v(" "),s("div",{staticClass:"card mt-3 pr-0 pl-0"},[s("div",{staticClass:"card-content"},[s("table",{staticClass:"table is-hoverable is-fullwidth"},[t._m(3),t._v(" "),s("tbody",t._l(t.estimateItems,(function(e,a){return s("EstimateItemCreate",{tag:"tr",attrs:{errorMessages:t.errors,estimateItem:e,index:a},on:{removedItem:t.removeEstimateItem}})})),1)]),t._v(" "),s("div",{staticClass:"flex justify-end"},[s("button",{staticClass:"button",on:{click:t.addEstimateItemRow}},[t._m(4)])])])]),t._v(" "),s("div",{staticClass:"card mt-3 p-8"},[s("table",{staticClass:"table is-fullwidth"},[s("tbody",[t._m(5),t._v(" "),t._m(6),t._v(" "),s("tr",[s("td",{staticClass:"has-text-right"},[t._v("\n              Discount %\n            ")]),t._v(" "),s("td",{staticClass:"has-text-right w-48",attrs:{w:""}},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.estimate.percentageDiscount,expression:"estimate.percentageDiscount"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.estimate.percentageDiscount},on:{input:function(e){e.target.composing||t.$set(t.estimate,"percentageDiscount",e.target.value)}}})])]),t._v(" "),t._m(7)])])]),t._v(" "),s("div",{staticClass:"mt-3"},[s("div",{staticClass:"field"},[s("div",{staticClass:"control"},[s("label",{staticClass:"label"},[t._v("Other Information")]),t._v(" "),s("textarea",{directives:[{name:"model",rawName:"v-model",value:t.estimate.otherInformation,expression:"estimate.otherInformation"}],staticClass:"textarea",attrs:{placeholder:"Textarea"},domProps:{value:t.estimate.otherInformation},on:{input:function(e){e.target.composing||t.$set(t.estimate,"otherInformation",e.target.value)}}})])])]),t._v(" "),s("div",{staticClass:"mt-3 pb-5 flex justify-center"},[s("div",{staticClass:"mr-2"},[s("button",{staticClass:"button is-primary is-rounded",on:{click:t.updateEstimate}},[t._v("Save and Send")])]),t._v(" "),t._m(8)])]:[s("b-loading",{attrs:{"is-full-page":!0,"can-cancel":!0}})]],2)}),[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[e("label",{staticClass:"label"},[this._v("Project")]),this._v(" "),e("div",{staticClass:"control"},[e("input",{staticClass:"input",attrs:{type:"text"}})])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[e("label",{staticClass:"label"},[this._v("Client Address")]),this._v(" "),e("div",{staticClass:"control"},[e("textarea",{staticClass:"textarea"})])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[e("label",{staticClass:"label"},[this._v("Billing Address")]),this._v(" "),e("div",{staticClass:"control"},[e("textarea",{staticClass:"textarea",attrs:{placeholder:"Textarea"}})])])])},function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("thead",[s("tr",[s("th",[t._v("#")]),t._v(" "),s("th",[t._v("Item")]),t._v(" "),s("th",[t._v("Description")]),t._v(" "),s("th",[t._v("Unit Cost")]),t._v(" "),s("th",[t._v("Qty")]),t._v(" "),s("th",[t._v("Amount")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-plus-circle mr-1"})])},function(){var t=this.$createElement,e=this._self._c||t;return e("tr",[e("td",{staticClass:"has-text-right"},[this._v("\n              Total\n            ")]),this._v(" "),e("td",{staticClass:"has-text-right"},[this._v("\n              0\n            ")])])},function(){var t=this.$createElement,e=this._self._c||t;return e("tr",[e("td",{staticClass:"has-text-right"},[this._v("\n              Tax\n            ")]),this._v(" "),e("td",{staticClass:"has-text-right w-48"},[e("input",{staticClass:"input",attrs:{disabled:"true",type:"text"}})])])},function(){var t=this.$createElement,e=this._self._c||t;return e("tr",[e("td",{staticClass:"has-text-right"},[this._v("\n              Grand Total\n            ")]),this._v(" "),e("td",{staticClass:"has-text-right w-48",attrs:{w:""}},[this._v("\n              $0.00\n            ")])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"ml-2"},[e("button",{staticClass:"button is-primary is-rounded"},[this._v("Save")])])}],!1,null,"6b1b4f92",null);e.default=p.exports}}]);