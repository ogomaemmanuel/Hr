(window.webpackJsonp=window.webpackJsonp||[]).push([[38],{371:function(t,e,s){"use strict";var a=function(){var t=this,e=t._self._c;return e("div",[e("b-field",[e("template",{slot:"label"},[t._v("\n      "+t._s(t.label)+" "),t.required?e("span",[e("sup",[t._v("*")])]):t._e()]),t._v(" "),e("b-autocomplete",{ref:"autocomplete",attrs:{data:t.clients,placeholder:"Select Client",field:"fullName",loading:t.isFetching,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:e=>t.selectedClient=e,"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(s){return[e("div",{staticClass:"media"},[e("div",{staticClass:"media-left"}),t._v(" "),e("div",{staticClass:"media-content"},[t._v("\n            "+t._s(s.option.fullName)+"\n            "),e("br"),t._v(" "),e("small")])])]}}])},[e("template",{slot:"header"},[e("a",{on:{click:t.showAddEmployee}},[e("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),e("template",{slot:"footer"},[e("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2),t._v(" "),e("div",{attrs:{slot:"message"},slot:"message"},[t._t("errors")],2)],2)],1)};a._withStripped=!0;var i=s(190),n=s.n(i),l={props:{label:{default:"Client"},required:{default:!0},emitAllFields:{default:!1},value:{}},data:()=>({clients:[],loading:!1,isFetching:!1,clientName:"",page:0,totalPages:0,selectedClient:{}}),mounted(){this.value&&this.$refs.autocomplete.setSelected(this.value)},methods:{showAddEmployee(){},fetchClients(t){axios.get("/api/clients",{params:{page:this.page,pageSize:10}}).then(({data:t})=>{t.content.forEach(t=>this.clients.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:n()((function(t){if(this.clientName!==t&&(this.clientName=t,this.clients=[],this.page=0,this.totalPages=0),!t.length)return this.clients=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchClients(t))}),500),getMoreAsyncData:n()((function(){this.getAsyncData(this.clientName)}),250)},watch:{selectedClient:function(t){this.emitAllFields&&t?this.$emit("input",t):this.emitAllFields&&0==t?this.$emit("input",{}):t?this.$emit("input",t.id):this.$emit("input","")}}},r=s(15),o=Object(r.a)(l,a,[],!1,null,"5284fb38",null);e.a=o.exports},378:function(t,e,s){var a=s(405);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(22).default)("052d4672",a,!1,{})},404:function(t,e,s){"use strict";s(378)},405:function(t,e,s){(t.exports=s(21)(!1)).push([t.i,".estimate-remove-btn[data-v-9525c486]{position:absolute;right:-1rem;top:.5rem}",""])},415:function(t,e,s){"use strict";var a=function(){var t=this,e=t._self._c;return e("tr",[e("td",[t._v("\n    "+t._s(t.index+1)+"\n  ")]),t._v(" "),e("td",[e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.estimateItem.name,expression:"estimateItem.name"}],staticClass:"input",domProps:{value:t.estimateItem.name},on:{input:[function(e){e.target.composing||t.$set(t.estimateItem,"name",e.target.value)},function(e){return t.clearFieldError(`items[${t.index}].name`)}]}}),t._v(" "),t.errors[`items[${t.index}].name`]?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n           "+t._s(t.errors[`items[${t.index}].name`][0])+"\n        ")]):t._e()])])]),t._v(" "),e("td",[e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.estimateItem.description,expression:"estimateItem.description"}],staticClass:"input",attrs:{placeholder:"Textarea"},domProps:{value:t.estimateItem.description},on:{input:[function(e){e.target.composing||t.$set(t.estimateItem,"description",e.target.value)},function(e){return t.clearFieldError(`items[${t.index}].description`)}]}}),t._v(" "),t.errors[`items[${t.index}].description`]?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n           "+t._s(t.errors[`items[${t.index}].description`][0])+"\n        ")]):t._e()])])]),t._v(" "),e("td",[e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("InputNumber",{attrs:{controls:!1},on:{input:function(e){return t.clearFieldError(`items[${t.index}].unitCost`)}},model:{value:t.estimateItem.unitCost,callback:function(e){t.$set(t.estimateItem,"unitCost",e)},expression:"estimateItem.unitCost"}}),t._v(" "),t.errors[`items[${t.index}].unitCost`]?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n           "+t._s(t.errors[`items[${t.index}].unitCost`][0])+"\n        ")]):t._e()],1)])]),t._v(" "),e("td",[e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("InputNumber",{attrs:{min:1},on:{input:function(e){return t.clearFieldError(`items[${t.index}].quantity`)}},model:{value:t.estimateItem.qty,callback:function(e){t.$set(t.estimateItem,"qty",e)},expression:"estimateItem.qty"}}),t._v(" "),t.errors[`items[${t.index}].quantity`]?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n           "+t._s(t.errors[`items[${t.index}].quantity`][0])+"\n        ")]):t._e()],1)])]),t._v(" "),e("td",[e("div",{staticClass:"field"},[e("div",{staticClass:"control is-relative"},[e("input",{staticClass:"input",attrs:{placeholder:"Textarea"}}),t._v(" "),e("div",{staticClass:"estimate-remove-btn has-text-danger",on:{click:function(e){return t.removeEstimateItem(t.index)}}},[e("i",{staticClass:"fa fa-trash"})])])])])])};a._withStripped=!0;s(332),s(83);var i=s(333),n=s.n(i),l=s(34),r={components:{ClientSelectInput:s(371).a,InputNumber:n.a},mixins:[l.a],props:{estimateItem:{required:!0},index:{},errorMessages:{}},methods:{removeEstimateItem(t){this.$emit("removedItem",t)}},watch:{errorMessages(t){this.errors=t}}},o=(s(404),s(15)),c=Object(o.a)(r,a,[],!1,null,"9525c486",null);e.a=c.exports},458:function(t,e,s){var a=s(549);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(22).default)("6613812a",a,!1,{})},548:function(t,e,s){"use strict";s(458)},549:function(t,e,s){(t.exports=s(21)(!1)).push([t.i,".estimate-remove-btn[data-v-f594daa8]{position:absolute;right:-1rem;top:.5rem}",""])},668:function(t,e,s){"use strict";s.r(e);var a=function(){var t=this,e=t._self._c;return e("div",[t.estimateLoaded?[e("form",{attrs:{action:""}},[e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("ClientSelectInput",{attrs:{"emit-all-fields":!0},on:{input:function(e){return t.clearFieldError("clientId")}},model:{value:t.selectClient,callback:function(e){t.selectClient=e},expression:"selectClient"}},[t.errors.clientId?e("span",{staticClass:"mb-2 has-text-danger",attrs:{slot:"errors"},slot:"errors"},[t._v("\n\t\t\t\t\t\t        "+t._s(t.errors.clientId[0])+"\n            ")]):t._e()])],1),t._v(" "),t._m(0),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[e("label",{staticClass:"label"},[t._v("Email")]),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.selectClient.email,expression:"selectClient.email"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.selectClient.email},on:{input:function(e){e.target.composing||t.$set(t.selectClient,"email",e.target.value)}}})])])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[e("label",{staticClass:"label"},[t._v("Tax")]),t._v(" "),e("div",{staticClass:"select is-fullwidth"},[e("select",{directives:[{name:"model",rawName:"v-model",value:t.estimate.taxId,expression:"estimate.taxId"}],on:{change:function(e){var s=Array.prototype.filter.call(e.target.options,(function(t){return t.selected})).map((function(t){return"_value"in t?t._value:t.value}));t.$set(t.estimate,"taxId",e.target.multiple?s:s[0])}}},[e("option",{attrs:{value:"",selected:""}},[t._v("Select Tax")]),t._v(" "),t._l(t.taxes,(function(s){return e("option",{key:s.id,domProps:{value:s.id}},[t._v(t._s(s.name)+"\n                  ")])})),t._v(" "),e("option",[t._v("No tax")])],2)])])])]),t._v(" "),e("div",{staticClass:"columns"},[t._m(1),t._v(" "),t._m(2),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[e("label",{staticClass:"label"},[t._v("Estimate Date")]),t._v(" "),e("div",{staticClass:"control"},[e("DatePicker",{on:{input:function(e){return t.clearFieldError("estimateDate")}},model:{value:t.estimate.estimateDate,callback:function(e){t.$set(t.estimate,"estimateDate",e)},expression:"estimate.estimateDate"}}),t._v(" "),t.errors.estimateDate?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t        "+t._s(t.errors.estimateDate[0])+"\n\t\t\t\t\t    ")]):t._e()],1)])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[e("label",{staticClass:"label"},[t._v("Expiry Date")]),t._v(" "),e("div",{staticClass:"control"},[e("DatePicker",{on:{input:function(e){return t.clearFieldError("expiryDate")}},model:{value:t.estimate.expiryDate,callback:function(e){t.$set(t.estimate,"expiryDate",e)},expression:"estimate.expiryDate"}}),t._v(" "),t.errors.expiryDate?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t        "+t._s(t.errors.expiryDate[0])+"\n\t\t\t\t\t    ")]):t._e()],1)])])])]),t._v(" "),e("div",{staticClass:"card mt-3 pr-0 pl-0"},[e("div",{staticClass:"card-content"},[e("table",{staticClass:"table is-hoverable is-fullwidth"},[t._m(3),t._v(" "),e("tbody",t._l(t.estimateItems,(function(s,a){return e("EstimateItemCreate",{key:a,tag:"tr",attrs:{errorMessages:t.errors,estimateItem:s,index:a},on:{removedItem:t.removeEstimateItem}})})),1)]),t._v(" "),e("div",{staticClass:"flex justify-end"},[e("button",{staticClass:"button",on:{click:t.addEstimateItemRow}},[t._m(4)])])])]),t._v(" "),e("div",{staticClass:"card mt-3 p-8"},[e("table",{staticClass:"table is-fullwidth"},[e("tbody",[t._m(5),t._v(" "),t._m(6),t._v(" "),e("tr",[e("td",{staticClass:"has-text-right"},[t._v("\n              Discount %\n            ")]),t._v(" "),e("td",{staticClass:"has-text-right w-48",attrs:{w:""}},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.estimate.percentageDiscount,expression:"estimate.percentageDiscount"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.estimate.percentageDiscount},on:{input:function(e){e.target.composing||t.$set(t.estimate,"percentageDiscount",e.target.value)}}})])]),t._v(" "),t._m(7)])])]),t._v(" "),e("div",{staticClass:"mt-3"},[e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("label",{staticClass:"label"},[t._v("Other Information")]),t._v(" "),e("textarea",{directives:[{name:"model",rawName:"v-model",value:t.estimate.otherInformation,expression:"estimate.otherInformation"}],staticClass:"textarea",attrs:{placeholder:"Textarea"},domProps:{value:t.estimate.otherInformation},on:{input:function(e){e.target.composing||t.$set(t.estimate,"otherInformation",e.target.value)}}})])])]),t._v(" "),e("div",{staticClass:"mt-3 pb-5 flex justify-center"},[e("div",{staticClass:"mr-2"},[e("button",{staticClass:"button is-primary is-rounded",on:{click:t.updateEstimate}},[t._v("Save and Send")])]),t._v(" "),t._m(8)])]:[e("b-loading",{attrs:{"is-full-page":!0,"can-cancel":!0}})]],2)};a._withStripped=!0;s(185),s(83);var i=s(186),n=s.n(i),l=(s(332),s(333)),r=s.n(l),o=(s(188),s(189)),c=s.n(o),m=s(34),d=s(371),u=s(415),v={components:{DatePicker:c.a,InputNumber:r.a,ClientSelectInput:d.a,EstimateItemCreate:u.a},mixins:[m.a],data:()=>({taxes:[],estimateId:"",selectClient:{},estimateLoaded:!1,estimate:{taxId:"",estimateItems:[{}]}}),computed:{estimateItems(){return this.estimate.estimateItems}},created(){this.estimateId=this.$route.params.id,this.getEstimateById(),this.getTaxes()},methods:{addEstimateItemRow(){this.estimate.estimateItems.push({})},updateEstimate(){this.estimate.clientId=this.selectClient.id,axios.put("/api/estimates/"+this.estimateId,this.estimate).then(t=>{n.a.success("Estimate successfully created")},t=>{n.a.error("There was problem estimate"),400==t.response.status&&(this.errors=t.response.data)})},removeEstimateItem(t){this.estimateItems.length>1&&this.estimateItems.splice(t,1)},getEstimateById(){axios.get("/api/estimates/"+this.estimateId).then(t=>{this.estimate=t.data,this.selectClient=this.estimate.client,this.selectClient.email=this.estimate.client.user.email,this.estimateLoaded=!0},t=>{})},getTaxes(){axios.get("/api/taxes/all").then(t=>{this.taxes=t.data},t=>{console.log("Error fetching taxes  data in EstimateCreateForm")})}}},p=(s(548),s(15)),h=Object(p.a)(v,a,[function(){var t=this._self._c;return t("div",{staticClass:"column"},[t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[this._v("Project")]),this._v(" "),t("div",{staticClass:"control"},[t("input",{staticClass:"input",attrs:{type:"text"}})])])])},function(){var t=this._self._c;return t("div",{staticClass:"column"},[t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[this._v("Client Address")]),this._v(" "),t("div",{staticClass:"control"},[t("textarea",{staticClass:"textarea"})])])])},function(){var t=this._self._c;return t("div",{staticClass:"column"},[t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[this._v("Billing Address")]),this._v(" "),t("div",{staticClass:"control"},[t("textarea",{staticClass:"textarea",attrs:{placeholder:"Textarea"}})])])])},function(){var t=this,e=t._self._c;return e("thead",[e("tr",[e("th",[t._v("#")]),t._v(" "),e("th",[t._v("Item")]),t._v(" "),e("th",[t._v("Description")]),t._v(" "),e("th",[t._v("Unit Cost")]),t._v(" "),e("th",[t._v("Qty")]),t._v(" "),e("th",[t._v("Amount")])])])},function(){var t=this._self._c;return t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-plus-circle mr-1"})])},function(){var t=this._self._c;return t("tr",[t("td",{staticClass:"has-text-right"},[this._v("\n              Total\n            ")]),this._v(" "),t("td",{staticClass:"has-text-right"},[this._v("\n              0\n            ")])])},function(){var t=this._self._c;return t("tr",[t("td",{staticClass:"has-text-right"},[this._v("\n              Tax\n            ")]),this._v(" "),t("td",{staticClass:"has-text-right w-48"},[t("input",{staticClass:"input",attrs:{disabled:"true",type:"text"}})])])},function(){var t=this._self._c;return t("tr",[t("td",{staticClass:"has-text-right"},[this._v("\n              Grand Total\n            ")]),this._v(" "),t("td",{staticClass:"has-text-right w-48",attrs:{w:""}},[this._v("\n              $0.00\n            ")])])},function(){var t=this._self._c;return t("div",{staticClass:"ml-2"},[t("button",{staticClass:"button is-primary is-rounded"},[this._v("Save")])])}],!1,null,"f594daa8",null);e.default=h.exports}}]);