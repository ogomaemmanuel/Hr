(window.webpackJsonp=window.webpackJsonp||[]).push([[36],{360:function(t,e,s){var a=s(364);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(22).default)("42292892",a,!1,{})},361:function(t,e,s){"use strict";var a=function(){var t=this,e=t._self._c;return e("div",{staticClass:"modal-wrapper"},[e("div",{ref:"modal",staticClass:"modal"},[e("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[e("div",{staticClass:"box",class:t.hasPadding?"":"p-0"},[t.showCloseButton?[e("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(e){return e.stopPropagation(),t.closeModal.apply(null,arguments)}}})]:t._e(),t._v(" "),t._t("modal-content")],2)])])])};a._withStripped=!0;var i={mixins:[s(362).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0},hasPadding:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},r=(s(363),s(15)),l=Object(r.a)(i,a,[],!1,null,"5fe0ec67",null);e.a=l.exports},362:function(t,e,s){"use strict";(function(t){e.a={methods:{closeModal(){t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(187))},363:function(t,e,s){"use strict";s(360)},364:function(t,e,s){(t.exports=s(21)(!1)).push([t.i,".modal[data-v-5fe0ec67]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,.86)}.modal .modal-content[data-v-5fe0ec67]{overflow:visible}",""])},371:function(t,e,s){"use strict";var a=function(){var t=this,e=t._self._c;return e("div",[e("b-field",[e("template",{slot:"label"},[t._v("\n      "+t._s(t.label)+" "),t.required?e("span",[e("sup",[t._v("*")])]):t._e()]),t._v(" "),e("b-autocomplete",{ref:"autocomplete",attrs:{data:t.clients,placeholder:"Select Client",field:"fullName",loading:t.isFetching,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:e=>t.selectedClient=e,"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(s){return[e("div",{staticClass:"media"},[e("div",{staticClass:"media-left"}),t._v(" "),e("div",{staticClass:"media-content"},[t._v("\n            "+t._s(s.option.fullName)+"\n            "),e("br"),t._v(" "),e("small")])])]}}])},[e("template",{slot:"header"},[e("a",{on:{click:t.showAddEmployee}},[e("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),e("template",{slot:"footer"},[e("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2),t._v(" "),e("div",{attrs:{slot:"message"},slot:"message"},[t._t("errors")],2)],2)],1)};a._withStripped=!0;var i=s(190),r=s.n(i),l={props:{label:{default:"Client"},required:{default:!0},emitAllFields:{default:!1},value:{}},data:()=>({clients:[],loading:!1,isFetching:!1,clientName:"",page:0,totalPages:0,selectedClient:{}}),mounted(){this.value&&this.$refs.autocomplete.setSelected(this.value)},methods:{showAddEmployee(){},fetchClients(t){axios.get("/api/clients",{params:{page:this.page,pageSize:10}}).then(({data:t})=>{t.content.forEach(t=>this.clients.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:r()((function(t){if(this.clientName!==t&&(this.clientName=t,this.clients=[],this.page=0,this.totalPages=0),!t.length)return this.clients=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchClients(t))}),500),getMoreAsyncData:r()((function(){this.getAsyncData(this.clientName)}),250)},watch:{selectedClient:function(t){this.emitAllFields&&t?this.$emit("input",t):this.emitAllFields&&0==t?this.$emit("input",{}):t?this.$emit("input",t.id):this.$emit("input","")}}},o=s(15),n=Object(o.a)(l,a,[],!1,null,"5284fb38",null);e.a=n.exports},374:function(t,e,s){"use strict";var a=function(){return(0,this._self._c)("div",{ref:"editorRef",attrs:{id:this.id}})};a._withStripped=!0;var i=s(326),r=s.n(i),l=(s(335),s(336),s(337),s(338)),o=s.n(l),n={minHeight:"200px",previewStyle:"vertical",useCommandShortcut:!0,useDefaultHTMLSanitizer:!0,usageStatistics:!1,hideModeSwitch:!1,toolbarItems:["heading","bold","italic","strike","divider","hr","quote","divider","ul","ol","task","indent","outdent","divider","table","image","link","divider","code","codeblock"]},c=s(339),d=s.n(c);function p(t,e){var s=Object.keys(t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(t);e&&(a=a.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),s.push.apply(s,a)}return s}function u(t){for(var e=1;e<arguments.length;e++){var s=null!=arguments[e]?arguments[e]:{};e%2?p(Object(s),!0).forEach((function(e){r()(t,e,s[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(s)):p(Object(s)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(s,e))}))}return t}var m={name:"MarkdownEditor",props:{value:{type:String,default:""},id:{type:String,required:!1,default:()=>"markdown-editor-"+ +new Date+(1e3*Math.random()).toFixed(0)},options:{type:Object,default:()=>n},mode:{type:String,default:"markdown"},height:{type:String,required:!1,default:"400px"},language:{type:String,required:!1,default:"en_US"}},data:()=>({editor:null}),computed:{editorOptions(){const t=Object.assign({},n,this.options);return t.initialEditType=this.mode,t.height=this.height,t.language=this.language,t}},watch:{value(t,e){t!==e&&t!==this.editor.getMarkdown()&&this.invoke("setMarkdown",t)},language(t){this.destroyEditor(),this.initEditor()},height(t){this.editor.height(t)},mode(t){this.editor.changeMode(t)}},mounted(){this.initEditor()},destroyed(){this.destroyEditor()},methods:{invoke(t,...e){let s=null;var a;this.editor[t]&&(s=(a=this.editor)[t].apply(a,e));return s},initEditor(){this.editor=new o.a(u(u({el:this.$refs.editorRef},this.editorOptions),{},{plugins:[d.a]})),this.value&&(console.log("editor value is ",this.value),this.invoke("setMarkdown",this.value)),this.editor.on("change",()=>{this.$emit("input",this.editor.getMarkdown())})},destroyEditor(){this.editor&&(this.editor.off("change"),this.editor.remove())},setValue(t){this.invoke("setMarkdown",t)},getValue(){return this.editor.getMarkdown()},setHtml(t){this.editor.setHtml(t)},getHtml(){return this.editor.getHtml()}}},h=s(15),v=Object(h.a)(m,a,[],!1,null,null,null);e.a=v.exports},380:function(t,e,s){"use strict";var a=function(){var t=this,e=t._self._c;return e("div",[e("b-field",[t.showLabel?e("template",{slot:"label"},[t._v("\n            "+t._s(t.label)+" "),t.required?e("span",[e("sup",[t._v("*")])]):t._e()]):t._e(),t._v(" "),e("b-autocomplete",{attrs:{data:t.employees,placeholder:"Select Employee",field:"fullName",loading:t.isFetching,"clear-on-select":t.clearOnSelect,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:e=>t.selectedEmployee=e,"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(s){return[e("div",{staticClass:"media"},[e("div",{staticClass:"media-left"}),t._v(" "),e("div",{staticClass:"media-content"},[t._v("\n                        "+t._s(s.option.fullName)+"\n                        "),e("br"),t._v(" "),e("small")])])]}}])},[e("template",{slot:"header"},[e("a",{on:{click:t.showAddEmployee}},[e("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),e("template",{slot:"footer"},[e("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2),t._v(" "),e("div",{attrs:{slot:"message"},slot:"message"},[t._t("errors")],2)],2)],1)};a._withStripped=!0;var i=s(190),r=s.n(i),l={props:{clearOnSelect:{default:!1},label:{default:"Employee"},required:{default:!0},showLabel:{default:!0},value:{}},data:()=>({employees:[],loading:!1,isFetching:!1,employeeName:"",page:0,totalPages:0,selectedEmployee:{}}),methods:{showAddEmployee(){},fetchEmployees(t){axios.get("/api/employees",{params:{page:this.page,pageSize:10}}).then(({data:t})=>{t.content.forEach(t=>this.employees.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:r()((function(t){if(this.employeeName!==t&&(this.employeeName=t,this.employees=[],this.page=0,this.totalPages=0),!t.length)return this.employees=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchEmployees(t))}),500),getMoreAsyncData:r()((function(){this.getAsyncData(this.employeeName)}),250)},watch:{selectedEmployee:function(t){this.$emit("input",t)},value(t){this.selectedEmployee=t}}},o=s(15),n=Object(o.a)(l,a,[],!1,null,"76b54214",null);e.a=n.exports},612:function(t,e,s){"use strict";s.r(e);var a=function(){var t=this,e=t._self._c;return e("ModalTemplate",{ref:"modalTemplate",attrs:{width:"900"},on:{modalClosed:t.onModalClosed}},[t._t("modal-content",(function(){return[e("ProjectCreateForm",{attrs:{slot:"modal-content"},on:{createSuccessful:t.onCreateSuccessful},slot:"modal-content"})]}))],2)};a._withStripped=!0;var i=function(){var t=this,e=t._self._c;return e("div",[e("form",[t._m(0),t._v(" "),e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(1),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.project.name,expression:"project.name"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.project.name},on:{input:[function(e){e.target.composing||t.$set(t.project,"name",e.target.value)},function(e){return t.clearFieldError("name")}]}}),t._v(" "),t.errors.name?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.name[0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),e("div",{staticClass:"column"},[e("ClientSelectInput",{attrs:{label:"Client"},on:{input:function(e){return t.clearFieldError("clientId")}},model:{value:t.project.clientId,callback:function(e){t.$set(t.project,"clientId",e)},expression:"project.clientId"}},[t.errors.clientId?e("span",{staticClass:"mb-2 has-text-danger",attrs:{slot:"errors"},slot:"errors"},[t._v("\n                            "+t._s(t.errors.clientId[0])+"\n                        ")]):t._e()])],1)]),t._v(" "),e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(2),t._v(" "),e("div",{staticClass:"control"},[e("DatePicker",{staticClass:"datepicker",attrs:{"value-format":"yyyy-MM-dd"},on:{input:function(e){return t.clearFieldError("startDate")}},model:{value:t.project.startDate,callback:function(e){t.$set(t.project,"startDate",e)},expression:"project.startDate"}}),t._v(" "),t.errors.startDate?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n                                                    "+t._s(t.errors.startDate[0])+"\n                                                ")]):t._e()],1)])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(3),t._v(" "),e("div",{staticClass:"control"},[e("DatePicker",{staticClass:"datepicker",attrs:{"value-format":"yyyy-MM-dd"},on:{input:function(e){return t.clearFieldError("endDate")}},model:{value:t.project.endDate,callback:function(e){t.$set(t.project,"endDate",e)},expression:"project.endDate"}}),t._v(" "),t.errors.endDate?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n                                                    "+t._s(t.errors.endDate[0])+"\n                                                ")]):t._e()],1)])])]),t._v(" "),e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("div",{staticClass:"columns flex"},[e("div",{staticClass:"column is-6-mobile"},[e("div",{staticClass:"field"},[t._m(4),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.project.rate,expression:"project.rate"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.project.rate},on:{input:[function(e){e.target.composing||t.$set(t.project,"rate",e.target.value)},function(e){return t.clearFieldError("rate")}]}}),t._v(" "),t.errors.rate?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n                                                    "+t._s(t.errors.rate[0])+"\n                                                ")]):t._e()])])]),t._v(" "),e("div",{staticClass:"column mt-8 is-6-mobile"},[e("div",{staticClass:"control"},[e("div",{staticClass:"select is-fullwidth"},[e("select",{directives:[{name:"model",rawName:"v-model",value:t.project.rateType,expression:"project.rateType"}],on:{input:function(e){return t.clearFieldError("rateType")},change:function(e){var s=Array.prototype.filter.call(e.target.options,(function(t){return t.selected})).map((function(t){return"_value"in t?t._value:t.value}));t.$set(t.project,"rateType",e.target.multiple?s:s[0])}}},[e("option",[t._v("Select")]),t._v(" "),e("option",{attrs:{value:"HOURLY"}},[t._v("Hourly")]),t._v(" "),e("option",{attrs:{value:"FIXED"}},[t._v("Fixed")])])]),t._v(" "),t.errors.rateType?e("span",{staticClass:"mb-2 has-text-danger help"},[t._v("\n                                    "+t._s(t.errors.rateType[0])+"\n                                ")]):t._e()])])])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(5),t._v(" "),e("div",{staticClass:"select is-fullwidth"},[e("select",{directives:[{name:"model",rawName:"v-model",value:t.project.priority,expression:"project.priority"}],on:{input:function(e){return t.clearFieldError("priority")},change:function(e){var s=Array.prototype.filter.call(e.target.options,(function(t){return t.selected})).map((function(t){return"_value"in t?t._value:t.value}));t.$set(t.project,"priority",e.target.multiple?s:s[0])}}},[e("option",[t._v("Select")]),t._v(" "),e("option",{attrs:{value:"HIGH"}},[t._v("High")]),t._v(" "),e("option",{attrs:{value:"MEDIUM"}},[t._v("Medium")]),t._v(" "),e("option",{attrs:{value:"LOW"}},[t._v("Low")])])]),t._v(" "),t.errors.priority?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n                            "+t._s(t.errors.priority[0])+"\n                        ")]):t._e()])])]),t._v(" "),e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("ProjectMemberSelectInput",{attrs:{label:"Add Project Leader"},on:{input:function(e){return t.clearFieldError("teamLeaderId")}},model:{value:t.project.teamLeader,callback:function(e){t.$set(t.project,"teamLeader",e)},expression:"project.teamLeader"}},[t.errors.teamLeaderId?e("span",{staticClass:"mb-2 has-text-danger",attrs:{slot:"errors"},slot:"errors"},[t._v("\n                            "+t._s(t.errors.teamLeaderId[0])+"\n                        ")]):t._e()])],1),t._v(" "),t._m(6)]),t._v(" "),e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("ProjectMemberSelectInput",{attrs:{label:"Add Team","clear-on-select":!0},on:{input:t.addProjectMember},model:{value:t.projectMember,callback:function(e){t.projectMember=e},expression:"projectMember"}},[t.errors.projectMembersIds?e("span",{staticClass:"mb-2 has-text-danger",attrs:{slot:"errors"},slot:"errors"},[t._v("\n                            "+t._s(t.errors.projectMembersIds[0])+"\n                        ")]):t._e()])],1),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(7),t._v(" "),e("div",{staticClass:"flex"},[t._l(t.project.projectMembers,(function(s,a){return[a<5?e("figure",{staticClass:"image is-32x32"},[e("img",{staticClass:"is-rounded",attrs:{src:"https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-16.jpg",alt:""}})]):t._e()]})),t._v(" "),t.project.projectMembers.length>=5?e("div",[t._v("\n                                +"+t._s(t.project.projectMembers.length-4)+"\n                            ")]):t._e()],2)])])]),t._v(" "),e("div",[e("div",{staticClass:"field"},[t._m(8),t._v(" "),e("MarkdownEditor",{model:{value:t.project.description,callback:function(e){t.$set(t.project,"description",e)},expression:"project.description"}}),t._v(" "),t.errors.description?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n                        "+t._s(t.errors.description[0])+"\n                    ")]):t._e()],1)]),t._v(" "),e("div",{staticClass:"field"},[e("div",{staticClass:"control"},[t._m(9),t._v(" "),e("div",{staticClass:"file has-name is-fullwidth"},[e("label",{staticClass:"file-label"},[e("input",{staticClass:"file-input",attrs:{type:"file",name:"resume"},on:{change:t.onFileChange}}),t._v(" "),t._m(10),t._v(" "),e("span",{staticClass:"file-name"},[t._v("\n      "+t._s(t.fileName)+"\n    ")])])])])]),t._v(" "),e("div",{staticClass:"flex justify-center m-3"},[e("button",{staticClass:"button is-rounded",class:{"is-loading":t.isLoading},attrs:{disabled:t.isLoading,type:"submit"},on:{click:function(e){return e.preventDefault(),e.stopPropagation(),t.createProject()}}},[t._v("Submit\n                ")])])])])};i._withStripped=!0;s(188),s(83);var r=s(189),l=s.n(r),o=s(374),n=s(371),c=s(380),d={mixins:[s(34).a],components:{MarkdownEditor:o.a,ClientSelectInput:n.a,DatePicker:l.a,ProjectMemberSelectInput:c.a},data:()=>({project:{user:{},teamLeader:{},projectMembers:[]},fileName:"",projectMember:"",isLoading:!1,errors:{}}),methods:{addProjectMember(t){if(t){this.project.projectMembers.find(e=>e.id==t.id)||(this.project.projectMembers.push(t),this.clearFieldError("projectMembersIds"))}},onFileChange(t){const e=t.target.files[0];this.project.attachment=e,this.fileName=e.name},createProject(){this.isLoading=!0,this.project.teamLeaderId=this.project.teamLeader.id,this.project.projectMembersIds=this.project.projectMembers.map(t=>t.id),console.log(this.project);let t=this.createFormData(this.project);axios.post("/api/projects",t).then(t=>{this.isLoading=!1,this.$emit("createSuccessful")},t=>{this.isLoading=!1,400==t.response.status&&(this.errors=t.response.data)})}}},p=s(15),u=Object(p.a)(d,i,[function(){var t=this._self._c;return t("div",{staticClass:"has-text-centered m-3"},[t("h1",{staticClass:"has-text-black"},[t("b",[this._v("Create Project")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Project Name "),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Start Date"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("End Date"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Rate"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Priority"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("div",{staticClass:"column"},[t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[this._v("Team Leader"),t("span",[t("sup",[this._v("*")])])]),this._v(" "),t("figure",{staticClass:"image is-32x32"},[t("img",{staticClass:"is-rounded",attrs:{src:"https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-16.jpg",alt:""}})])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Team Members"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Description"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Upload File"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("span",{staticClass:"file-cta"},[t("span",{staticClass:"file-icon"},[t("i",{staticClass:"fa fa-upload"})]),this._v(" "),t("span",{staticClass:"file-label"},[this._v("\n        Browse…\n      ")])])}],!1,null,null,null).exports,m={components:{ModalTemplate:s(361).a,ProjectCreateForm:u},methods:{onCreateSuccessful(){this.$emit("createSuccessful"),this.$router.back()},onModalClosed(){this.$router.back()}}},h=Object(p.a)(m,a,[],!1,null,null,null);e.default=h.exports}}]);