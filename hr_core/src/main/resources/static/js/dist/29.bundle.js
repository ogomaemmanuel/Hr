(window.webpackJsonp=window.webpackJsonp||[]).push([[29],{371:function(t,e,s){"use strict";var i=function(){var t=this,e=t._self._c;return e("div",[e("b-field",[e("template",{slot:"label"},[t._v("\n      "+t._s(t.label)+" "),t.required?e("span",[e("sup",[t._v("*")])]):t._e()]),t._v(" "),e("b-autocomplete",{ref:"autocomplete",attrs:{data:t.clients,placeholder:"Select Client",field:"fullName",loading:t.isFetching,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:e=>t.selectedClient=e,"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(s){return[e("div",{staticClass:"media"},[e("div",{staticClass:"media-left"}),t._v(" "),e("div",{staticClass:"media-content"},[t._v("\n            "+t._s(s.option.fullName)+"\n            "),e("br"),t._v(" "),e("small")])])]}}])},[e("template",{slot:"header"},[e("a",{on:{click:t.showAddEmployee}},[e("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),e("template",{slot:"footer"},[e("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2),t._v(" "),e("div",{attrs:{slot:"message"},slot:"message"},[t._t("errors")],2)],2)],1)};i._withStripped=!0;var a=s(190),n=s.n(a),o={props:{label:{default:"Client"},required:{default:!0},emitAllFields:{default:!1},value:{}},data:()=>({clients:[],loading:!1,isFetching:!1,clientName:"",page:0,totalPages:0,selectedClient:{}}),mounted(){this.value&&this.$refs.autocomplete.setSelected(this.value)},methods:{showAddEmployee(){},fetchClients(t){axios.get("/api/clients",{params:{page:this.page,pageSize:10}}).then(({data:t})=>{t.content.forEach(t=>this.clients.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:n()((function(t){if(this.clientName!==t&&(this.clientName=t,this.clients=[],this.page=0,this.totalPages=0),!t.length)return this.clients=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchClients(t))}),500),getMoreAsyncData:n()((function(){this.getAsyncData(this.clientName)}),250)},watch:{selectedClient:function(t){this.emitAllFields&&t?this.$emit("input",t):this.emitAllFields&&0==t?this.$emit("input",{}):t?this.$emit("input",t.id):this.$emit("input","")}}},l=s(15),r=Object(l.a)(o,i,[],!1,null,"5284fb38",null);e.a=r.exports},378:function(t,e,s){var i=s(408);i.__esModule&&(i=i.default),"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);(0,s(22).default)("29ff239c",i,!1,{})},407:function(t,e,s){"use strict";s(378)},408:function(t,e,s){(t.exports=s(21)(!1)).push([t.i,".estimate-remove-btn[data-v-39eb2e30]{position:absolute;right:-1rem;top:.5rem}",""])},416:function(t,e,s){"use strict";var i=function(){var t=this,e=t._self._c;return e("div",[e("b-field",[e("template",{slot:"label"},[t._v("\n      "+t._s(t.label)+" "),t.required?e("span",[e("sup",[t._v("*")])]):t._e()]),t._v(" "),e("b-autocomplete",{attrs:{data:t.projects,placeholder:"Select Project",field:"name",loading:t.isFetching,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:e=>t.selectedProject=e,"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(s){return[e("div",{staticClass:"media"},[e("div",{staticClass:"media-left"}),t._v(" "),e("div",{staticClass:"media-content"},[t._v("\n            "+t._s(s.option.name)+"\n            "),e("br"),t._v(" "),e("small")])])]}}])},[e("template",{slot:"header"},[e("a",{on:{click:t.showAddProject}},[e("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),e("template",{slot:"footer"},[e("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2),t._v(" "),e("div",{attrs:{slot:"message"},slot:"message"},[t._t("errors")],2)],2)],1)};i._withStripped=!0;var a=s(190),n=s.n(a),o={props:{label:{default:"Project"},required:{default:!0},clientId:{}},data:()=>({projects:[],loading:!1,isFetching:!1,projectName:"",page:0,totalPages:0,selectedProject:{}}),methods:{showAddProject(){},fetchProjects(t){let e={page:this.page,pageSize:10};this.clientId&&(e.clientId=this.clientId),axios.get("/api/projects",{params:e}).then(({data:t})=>{t.content.forEach(t=>this.projects.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:n()((function(t){if(this.projectName!==t&&(this.projectName=t,this.projects=[],this.page=0,this.totalPages=0),!t.length)return this.projects=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchProjects(t))}),500),getMoreAsyncData:n()((function(){this.getAsyncData(this.projectName)}),250)},watch:{selectedProject:function(t){this.$emit("input",t.id)}}},l=s(15),r=Object(l.a)(o,i,[],!1,null,"0bb7c5a6",null);e.a=r.exports},417:function(t,e,s){"use strict";var i=function(){var t=this,e=t._self._c;return e("tr",[e("td",[t._v("\n    "+t._s(t.index+1)+"\n  ")]),t._v(" "),e("td",[e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.invoiceItem.name,expression:"invoiceItem.name"}],staticClass:"input",domProps:{value:t.invoiceItem.name},on:{input:[function(e){e.target.composing||t.$set(t.invoiceItem,"name",e.target.value)},function(e){return t.clearFieldError(`items[${t.index}].name`)}]}}),t._v(" "),t.errors[`items[${t.index}].name`]?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n           "+t._s(t.errors[`items[${t.index}].name`][0])+"\n        ")]):t._e()])])]),t._v(" "),e("td",[e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.invoiceItem.description,expression:"invoiceItem.description"}],staticClass:"input",attrs:{placeholder:"Textarea"},domProps:{value:t.invoiceItem.description},on:{input:[function(e){e.target.composing||t.$set(t.invoiceItem,"description",e.target.value)},function(e){return t.clearFieldError(`items[${t.index}].description`)}]}}),t._v(" "),t.errors[`items[${t.index}].description`]?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n           "+t._s(t.errors[`items[${t.index}].description`][0])+"\n        ")]):t._e()])])]),t._v(" "),e("td",[e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("InputNumber",{attrs:{controls:!1},on:{input:function(e){return t.clearFieldError(`items[${t.index}].unitCost`)}},model:{value:t.invoiceItem.unitCost,callback:function(e){t.$set(t.invoiceItem,"unitCost",e)},expression:"invoiceItem.unitCost"}}),t._v(" "),t.errors[`items[${t.index}].unitCost`]?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n           "+t._s(t.errors[`items[${t.index}].unitCost`][0])+"\n        ")]):t._e()],1)])]),t._v(" "),e("td",[e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("InputNumber",{attrs:{min:1},on:{input:function(e){return t.clearFieldError(`items[${t.index}].quantity`)}},model:{value:t.invoiceItem.qty,callback:function(e){t.$set(t.invoiceItem,"qty",e)},expression:"invoiceItem.qty"}}),t._v(" "),t.errors[`items[${t.index}].quantity`]?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n           "+t._s(t.errors[`items[${t.index}].quantity`][0])+"\n        ")]):t._e()],1)])]),t._v(" "),e("td",[e("div",{staticClass:"field"},[e("div",{staticClass:"control is-relative"},[e("input",{staticClass:"input",attrs:{placeholder:"Textarea"}}),t._v(" "),e("div",{staticClass:"estimate-remove-btn has-text-danger",on:{click:function(e){return t.removeInvoiceItem(t.index)}}},[e("i",{staticClass:"fa fa-trash"})])])])])])};i._withStripped=!0;s(332),s(83);var a=s(333),n=s.n(a),o=s(34),l={components:{ClientSelectInput:s(371).a,InputNumber:n.a},mixins:[o.a],props:{invoiceItem:{},index:{},errorMessages:{}},methods:{removeInvoiceItem(t){this.$emit("removedItem",t)}},watch:{errorMessages(t){this.errors=t}}},r=(s(407),s(15)),c=Object(r.a)(l,i,[],!1,null,"39eb2e30",null);e.a=c.exports},459:function(t,e,s){var i=s(550);i.__esModule&&(i=i.default),"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);(0,s(22).default)("4cc5fd5d",i,!1,{})},549:function(t,e,s){"use strict";s(459)},550:function(t,e,s){(t.exports=s(21)(!1)).push([t.i,".estimate-remove-btn[data-v-46dd6ead]{position:absolute;right:-1rem;top:.5rem}",""])},671:function(t,e,s){"use strict";s.r(e);var i=function(){var t=this,e=t._self._c;return e("div",[e("form",{attrs:{action:""}},[e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("ClientSelectInput",{attrs:{"emit-all-fields":!0},on:{input:function(e){return t.clearFieldError("clientId")}},model:{value:t.selectClient,callback:function(e){t.selectClient=e},expression:"selectClient"}},[t.errors.clientId?e("span",{staticClass:"mb-2 has-text-danger",attrs:{slot:"errors"},slot:"errors"},[t._v("\n\t\t\t\t\t\t        "+t._s(t.errors.clientId[0])+"\n            ")]):t._e()])],1),t._v(" "),e("div",{staticClass:"column"},[e("ProjectSelectInput",{on:{input:function(e){return t.clearFieldError("projectId")}},model:{value:t.invoice.projectId,callback:function(e){t.$set(t.invoice,"projectId",e)},expression:"invoice.projectId"}},[t.errors.projectId?e("span",{staticClass:"mb-2 has-text-danger",attrs:{slot:"errors"},slot:"errors"},[t._v("\n\t\t\t\t\t\t        "+t._s(t.errors.projectId[0])+"\n            ")]):t._e()])],1),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[e("label",{staticClass:"label"},[t._v("Email")]),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.selectClient.email,expression:"selectClient.email"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.selectClient.email},on:{input:function(e){e.target.composing||t.$set(t.selectClient,"email",e.target.value)}}})])])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[e("label",{staticClass:"label"},[t._v("Tax")]),t._v(" "),e("div",{staticClass:"select is-fullwidth"},[e("select",{directives:[{name:"model",rawName:"v-model",value:t.invoice.taxId,expression:"invoice.taxId"}],on:{change:function(e){var s=Array.prototype.filter.call(e.target.options,(function(t){return t.selected})).map((function(t){return"_value"in t?t._value:t.value}));t.$set(t.invoice,"taxId",e.target.multiple?s:s[0])}}},[e("option",{attrs:{value:"",selected:""}},[t._v("Select Tax")]),t._v(" "),t._l(t.taxes,(function(s){return e("option",{domProps:{value:s.id}},[t._v(t._s(s.name)+"\n                ")])})),t._v(" "),e("option",[t._v("No tax")])],2)])])])]),t._v(" "),e("div",{staticClass:"columns"},[t._m(0),t._v(" "),t._m(1),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[e("label",{staticClass:"label"},[t._v("Invoice Date")]),t._v(" "),e("div",{staticClass:"control"},[e("DatePicker",{on:{input:function(e){return t.clearFieldError("invoiceDate")}},model:{value:t.invoice.invoiceDate,callback:function(e){t.$set(t.invoice,"invoiceDate",e)},expression:"invoice.invoiceDate"}}),t._v(" "),t.errors.invoiceDate?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t        "+t._s(t.errors.invoiceDate[0])+"\n\t\t\t\t\t    ")]):t._e()],1)])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[e("label",{staticClass:"label"},[t._v("Expiry Date")]),t._v(" "),e("div",{staticClass:"control"},[e("DatePicker",{on:{input:function(e){return t.clearFieldError("expiryDate")}},model:{value:t.invoice.expiryDate,callback:function(e){t.$set(t.invoice,"expiryDate",e)},expression:"invoice.expiryDate"}}),t._v(" "),t.errors.expiryDate?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t        "+t._s(t.errors.expiryDate[0])+"\n\t\t\t\t\t    ")]):t._e()],1)])])])]),t._v(" "),e("div",{staticClass:"card mt-3 pr-0 pl-0"},[e("div",{staticClass:"card-content"},[e("table",{staticClass:"table is-hoverable is-fullwidth"},[t._m(2),t._v(" "),e("tbody",t._l(t.invoiceItems,(function(s,i){return e("EstimateItemCreate",{key:i,tag:"tr",attrs:{errorMessages:t.errors,invoiceItem:s,index:i},on:{removedItem:t.removeInvoiceItem}})})),1)]),t._v(" "),e("div",{staticClass:"flex justify-end"},[e("button",{staticClass:"button",on:{click:t.addInvoiceItemRow}},[t._m(3)])])])]),t._v(" "),e("div",{staticClass:"card mt-3 p-8"},[e("table",{staticClass:"table is-fullwidth"},[e("tbody",[t._m(4),t._v(" "),t._m(5),t._v(" "),e("tr",[e("td",{staticClass:"has-text-right"},[t._v("\n            Discount %\n          ")]),t._v(" "),e("td",{staticClass:"has-text-right w-48",attrs:{w:""}},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.invoice.percentageDiscount,expression:"invoice.percentageDiscount"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.invoice.percentageDiscount},on:{input:function(e){e.target.composing||t.$set(t.invoice,"percentageDiscount",e.target.value)}}})])]),t._v(" "),t._m(6)])])]),t._v(" "),e("div",{staticClass:"mt-3"},[e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[e("label",{staticClass:"label"},[t._v("Other Information")]),t._v(" "),e("textarea",{directives:[{name:"model",rawName:"v-model",value:t.invoice.otherInformation,expression:"invoice.otherInformation"}],staticClass:"textarea",attrs:{placeholder:"Textarea"},domProps:{value:t.invoice.otherInformation},on:{input:function(e){e.target.composing||t.$set(t.invoice,"otherInformation",e.target.value)}}})])])]),t._v(" "),e("div",{staticClass:"mt-3 pb-5 flex justify-center"},[e("div",{staticClass:"mr-2"},[e("button",{staticClass:"button is-primary is-rounded",on:{click:t.createInvoice}},[t._v("Save and Send")])]),t._v(" "),t._m(7)])])};i._withStripped=!0;s(185),s(83);var a=s(186),n=s.n(a),o=(s(332),s(333)),l=s.n(o),r=(s(188),s(189)),c=s.n(r),v=s(34),d=s(371),u=s(417),m=s(416),p={components:{DatePicker:c.a,InputNumber:l.a,ClientSelectInput:d.a,EstimateItemCreate:u.a,ProjectSelectInput:m.a},mixins:[v.a],data:()=>({taxes:[],selectClient:{},invoice:{taxId:"",invoiceItems:[{}]}}),computed:{invoiceItems(){return this.invoice.invoiceItems}},created(){this.getTaxes()},methods:{addInvoiceItemRow(){this.invoice.invoiceItems.push({})},createInvoice(){this.invoice.clientId=this.selectClient.id,axios.post("/api/invoices",this.invoice).then(t=>{n.a.success("invoice successfully created")},t=>{n.a.error("There was problem invoice"),400==t.response.status&&(this.errors=t.response.data)})},removeInvoiceItem(t){this.invoiceItems.length>1&&this.invoiceItems.splice(t,1)},getTaxes(){axios.get("/api/taxes/all").then(t=>{this.taxes=t.data},t=>{console.log("Error fetching taxes  data in EstimateCreateForm")})}}},h=(s(549),s(15)),_=Object(h.a)(p,i,[function(){var t=this._self._c;return t("div",{staticClass:"column"},[t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[this._v("Client Address")]),this._v(" "),t("div",{staticClass:"control"},[t("textarea",{staticClass:"textarea"})])])])},function(){var t=this._self._c;return t("div",{staticClass:"column"},[t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[this._v("Billing Address")]),this._v(" "),t("div",{staticClass:"control"},[t("textarea",{staticClass:"textarea",attrs:{placeholder:"Textarea"}})])])])},function(){var t=this,e=t._self._c;return e("thead",[e("tr",[e("th",[t._v("#")]),t._v(" "),e("th",[t._v("Item")]),t._v(" "),e("th",[t._v("Description")]),t._v(" "),e("th",[t._v("Unit Cost")]),t._v(" "),e("th",[t._v("Qty")]),t._v(" "),e("th",[t._v("Amount")])])])},function(){var t=this._self._c;return t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-plus-circle mr-1"})])},function(){var t=this._self._c;return t("tr",[t("td",{staticClass:"has-text-right"},[this._v("\n            Total\n          ")]),this._v(" "),t("td",{staticClass:"has-text-right"},[this._v("\n            0\n          ")])])},function(){var t=this._self._c;return t("tr",[t("td",{staticClass:"has-text-right"},[this._v("\n            Tax\n          ")]),this._v(" "),t("td",{staticClass:"has-text-right w-48"},[t("input",{staticClass:"input",attrs:{disabled:"true",type:"text"}})])])},function(){var t=this._self._c;return t("tr",[t("td",{staticClass:"has-text-right"},[this._v("\n            Grand Total\n          ")]),this._v(" "),t("td",{staticClass:"has-text-right w-48",attrs:{w:""}},[this._v("\n            $0.00\n          ")])])},function(){var t=this._self._c;return t("div",{staticClass:"ml-2"},[t("button",{staticClass:"button is-primary is-rounded"},[this._v("Save")])])}],!1,null,"46dd6ead",null);e.default=_.exports}}]);