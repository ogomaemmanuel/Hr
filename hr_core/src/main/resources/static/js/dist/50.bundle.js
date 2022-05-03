(window.webpackJsonp=window.webpackJsonp||[]).push([[50],{199:function(t,e,s){var i=s(204);"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);(0,s(23).default)("1f8d4a96",i,!0,{})},201:function(t,e,s){"use strict";var i={mixins:[s(202).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},a=(s(203),s(15)),r=Object(a.a)(i,(function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"modal-wrapper"},[s("div",{ref:"modal",staticClass:"modal"},[s("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[s("div",{staticClass:"box"},[t._t("modal-content")],2)]),t._v(" "),t.showCloseButton?[s("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(e){return e.stopPropagation(),t.closeModal(e)}}})]:t._e()],2)])}),[],!1,null,"2fb1f790",null);e.a=r.exports},202:function(t,e,s){"use strict";(function(t){e.a={methods:{closeModal(){t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(164))},203:function(t,e,s){"use strict";var i=s(199);s.n(i).a},204:function(t,e,s){(t.exports=s(22)(!1)).push([t.i,".modal[data-v-2fb1f790]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-2fb1f790]{overflow:visible}\n",""])},215:function(t,e,s){"use strict";var i=s(172),a=s.n(i),r=(s(179),s(180),s(181),s(182)),n=s.n(r),o={minHeight:"200px",previewStyle:"vertical",useCommandShortcut:!0,useDefaultHTMLSanitizer:!0,usageStatistics:!1,hideModeSwitch:!1,toolbarItems:["heading","bold","italic","strike","divider","hr","quote","divider","ul","ol","task","indent","outdent","divider","table","image","link","divider","code","codeblock"]},l=s(183),c=s.n(l);function d(t,e){var s=Object.keys(t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(t);e&&(i=i.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),s.push.apply(s,i)}return s}function u(t){for(var e=1;e<arguments.length;e++){var s=null!=arguments[e]?arguments[e]:{};e%2?d(Object(s),!0).forEach((function(e){a()(t,e,s[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(s)):d(Object(s)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(s,e))}))}return t}var m={name:"MarkdownEditor",props:{value:{type:String,default:""},id:{type:String,required:!1,default:()=>"markdown-editor-"+ +new Date+(1e3*Math.random()).toFixed(0)},options:{type:Object,default:()=>o},mode:{type:String,default:"markdown"},height:{type:String,required:!1,default:"400px"},language:{type:String,required:!1,default:"en_US"}},data:()=>({editor:null}),computed:{editorOptions(){const t=Object.assign({},o,this.options);return t.initialEditType=this.mode,t.height=this.height,t.language=this.language,t}},watch:{value(t,e){t!==e&&t!==this.editor.getMarkdown()&&this.invoke("setMarkdown",t)},language(t){this.destroyEditor(),this.initEditor()},height(t){this.editor.height(t)},mode(t){this.editor.changeMode(t)}},mounted(){this.initEditor()},destroyed(){this.destroyEditor()},methods:{invoke(t,...e){let s=null;var i;this.editor[t]&&(s=(i=this.editor)[t].apply(i,e));return s},initEditor(){this.editor=new n.a(u(u({el:this.$refs.editorRef},this.editorOptions),{},{plugins:[c.a]})),this.value&&(console.log("editor value is ",this.value),this.invoke("setMarkdown",this.value)),this.editor.on("change",()=>{this.$emit("input",this.editor.getMarkdown())})},destroyEditor(){this.editor&&(this.editor.off("change"),this.editor.remove())},setValue(t){this.invoke("setMarkdown",t)},getValue(){return this.editor.getMarkdown()},setHtml(t){this.editor.setHtml(t)},getHtml(){return this.editor.getHtml()}}},p=s(15),v=Object(p.a)(m,(function(){var t=this.$createElement;return(this._self._c||t)("div",{ref:"editorRef",attrs:{id:this.id}})}),[],!1,null,null,null);e.a=v.exports},397:function(t,e,s){"use strict";s.r(e);s(165),s(75);var i=s(166),a=s.n(i),r=s(35),n={components:{MarkdownEditor:s(215).a},mixins:[r.a],data:()=>({client:{user:{}},isLoading:!1}),methods:{createClient(){this.isLoading=!0,axios.post("/api/clients",this.client).then(t=>{this.isLoading=!1,a.a.success("Client successfully created"),this.$emit("createSuccessful")},t=>{this.isLoading=!1,400==t.response.status&&(this.errors=t.response.data)})}}},o=s(15),l=Object(o.a)(n,(function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("form",[t._m(0),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(1),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.client.user.firstName,expression:"client.user.firstName"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.client.user.firstName},on:{input:[function(e){e.target.composing||t.$set(t.client.user,"firstName",e.target.value)},function(e){return t.clearFieldError("user.firstName")}]}}),t._v(" "),t.errors["user.firstName"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["user.firstName"][0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(2),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.client.user.lastName,expression:"client.user.lastName"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.client.user.lastName},on:{input:[function(e){e.target.composing||t.$set(t.client.user,"lastName",e.target.value)},function(e){return t.clearFieldError("user.lastName")}]}}),t._v(" "),t.errors["user.lastName"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["user.lastName"][0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(3),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.client.user.email,expression:"client.user.email"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.client.user.email},on:{input:[function(e){e.target.composing||t.$set(t.client.user,"email",e.target.value)},function(e){return t.clearFieldError("user.email")}]}}),t._v(" "),t.errors["user.email"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["user.email"][0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"field"},[t._m(4),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.client.user.phone,expression:"client.user.phone"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.client.user.phone},on:{input:[function(e){e.target.composing||t.$set(t.client.user,"phone",e.target.value)},function(e){return t.clearFieldError("user.phone")}]}}),t._v(" "),t.errors["user.phone"]?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["user.phone"][0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),s("div",{staticClass:"field"},[t._m(5),t._v(" "),s("div",{staticClass:"control"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.client.companyName,expression:"client.companyName"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.client.companyName},on:{input:[function(e){e.target.composing||t.$set(t.client,"companyName",e.target.value)},function(e){return t.clearFieldError("companyName")}]}}),t._v(" "),t.errors.companyName?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.companyName[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),s("div",{staticClass:"field"},[t._m(6),t._v(" "),s("div",{staticClass:"control"},[s("MarkdownEditor",{on:{input:function(e){return t.clearFieldError("description")}},model:{value:t.client.description,callback:function(e){t.$set(t.client,"description",e)},expression:"client.description"}}),t._v(" "),t.errors.description?s("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.description[0])+"\n\t\t\t\t\t")]):t._e()],1)]),t._v(" "),s("div",{staticClass:"flex justify-center m-3"},[s("button",{staticClass:"button  is-rounded",class:{"is-loading":t.isLoading},attrs:{disabled:t.isLoading,type:"submit"},on:{click:function(e){return e.preventDefault(),e.stopPropagation(),t.createClient(e)}}},[t._v("Submit\n        ")])])])])}),[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"has-text-centered m-3"},[e("h1",{staticClass:"has-text-black"},[e("b",[this._v("Add Client")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v("First Name "),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v("Last Name "),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v("Email"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v("Phone"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v("Company Name"),e("span",[e("sup",[this._v("*")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("label",{staticClass:"label"},[this._v("Description "),e("span",[e("sup",[this._v("*")])])])}],!1,null,null,null).exports,c={components:{ModalTemplate:s(201).a,ClientCreateForm:l},methods:{onClientCreateSuccessful(){this.$emit("createSuccessful"),this.$router.back()},onModalClosed(){this.$router.back()}}},d=Object(o.a)(c,(function(){var t=this.$createElement,e=this._self._c||t;return e("ModalTemplate",{ref:"modalTemplate",attrs:{width:"900"},on:{modalClosed:this.onModalClosed}},[this._t("modal-content",[e("ClientCreateForm",{attrs:{slot:"modal-content"},on:{createSuccessful:this.onClientCreateSuccessful},slot:"modal-content"})])],2)}),[],!1,null,null,null);e.default=d.exports}}]);