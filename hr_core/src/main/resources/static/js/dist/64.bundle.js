(window.webpackJsonp=window.webpackJsonp||[]).push([[64],{360:function(t,e,s){var i=s(364);i.__esModule&&(i=i.default),"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);(0,s(22).default)("42292892",i,!1,{})},361:function(t,e,s){"use strict";var i=function(){var t=this,e=t._self._c;return e("div",{staticClass:"modal-wrapper"},[e("div",{ref:"modal",staticClass:"modal"},[e("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[e("div",{staticClass:"box",class:t.hasPadding?"":"p-0"},[t.showCloseButton?[e("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(e){return e.stopPropagation(),t.closeModal.apply(null,arguments)}}})]:t._e(),t._v(" "),t._t("modal-content")],2)])])])};i._withStripped=!0;var a={mixins:[s(362).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0},hasPadding:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},n=(s(363),s(15)),r=Object(n.a)(a,i,[],!1,null,"5fe0ec67",null);e.a=r.exports},362:function(t,e,s){"use strict";(function(t){e.a={methods:{closeModal(){t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(187))},363:function(t,e,s){"use strict";s(360)},364:function(t,e,s){(t.exports=s(21)(!1)).push([t.i,".modal[data-v-5fe0ec67]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,.86)}.modal .modal-content[data-v-5fe0ec67]{overflow:visible}",""])},374:function(t,e,s){"use strict";var i=function(){return(0,this._self._c)("div",{ref:"editorRef",attrs:{id:this.id}})};i._withStripped=!0;var a=s(326),n=s.n(a),r=(s(335),s(336),s(337),s(338)),o=s.n(r),l={minHeight:"200px",previewStyle:"vertical",useCommandShortcut:!0,useDefaultHTMLSanitizer:!0,usageStatistics:!1,hideModeSwitch:!1,toolbarItems:["heading","bold","italic","strike","divider","hr","quote","divider","ul","ol","task","indent","outdent","divider","table","image","link","divider","code","codeblock"]},c=s(339),d=s.n(c);function u(t,e){var s=Object.keys(t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(t);e&&(i=i.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),s.push.apply(s,i)}return s}function p(t){for(var e=1;e<arguments.length;e++){var s=null!=arguments[e]?arguments[e]:{};e%2?u(Object(s),!0).forEach((function(e){n()(t,e,s[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(s)):u(Object(s)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(s,e))}))}return t}var m={name:"MarkdownEditor",props:{value:{type:String,default:""},id:{type:String,required:!1,default:()=>"markdown-editor-"+ +new Date+(1e3*Math.random()).toFixed(0)},options:{type:Object,default:()=>l},mode:{type:String,default:"markdown"},height:{type:String,required:!1,default:"400px"},language:{type:String,required:!1,default:"en_US"}},data:()=>({editor:null}),computed:{editorOptions(){const t=Object.assign({},l,this.options);return t.initialEditType=this.mode,t.height=this.height,t.language=this.language,t}},watch:{value(t,e){t!==e&&t!==this.editor.getMarkdown()&&this.invoke("setMarkdown",t)},language(t){this.destroyEditor(),this.initEditor()},height(t){this.editor.height(t)},mode(t){this.editor.changeMode(t)}},mounted(){this.initEditor()},destroyed(){this.destroyEditor()},methods:{invoke(t,...e){let s=null;var i;this.editor[t]&&(s=(i=this.editor)[t].apply(i,e));return s},initEditor(){this.editor=new o.a(p(p({el:this.$refs.editorRef},this.editorOptions),{},{plugins:[d.a]})),this.value&&(console.log("editor value is ",this.value),this.invoke("setMarkdown",this.value)),this.editor.on("change",()=>{this.$emit("input",this.editor.getMarkdown())})},destroyEditor(){this.editor&&(this.editor.off("change"),this.editor.remove())},setValue(t){this.invoke("setMarkdown",t)},getValue(){return this.editor.getMarkdown()},setHtml(t){this.editor.setHtml(t)},getHtml(){return this.editor.getHtml()}}},v=s(15),h=Object(v.a)(m,i,[],!1,null,null,null);e.a=h.exports},611:function(t,e,s){"use strict";s.r(e);var i=function(){var t=this,e=t._self._c;return e("ModalTemplate",{attrs:{width:"900",overflow:"visible"},on:{modalClosed:function(e){return t.$router.back()}}},[t._t("modal-content",(function(){return[e("ClientEditForm",{attrs:{slot:"modal-content","client-id":t.$route.params.id},on:{updateSuccessful:t.onUpdated},slot:"modal-content"})]}))],2)};i._withStripped=!0;var a=s(361),n=function(){var t=this,e=t._self._c;return e("div",[e("form",[t._m(0),t._v(" "),e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(1),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.client.user.firstName,expression:"client.user.firstName"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.client.user.firstName},on:{input:[function(e){e.target.composing||t.$set(t.client.user,"firstName",e.target.value)},function(e){return t.clearFieldError("user.firstName")}]}}),t._v(" "),t.errors["user.firstName"]?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["user.firstName"][0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(2),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.client.user.lastName,expression:"client.user.lastName"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.client.user.lastName},on:{input:[function(e){e.target.composing||t.$set(t.client.user,"lastName",e.target.value)},function(e){return t.clearFieldError("user.lastName")}]}}),t._v(" "),t.errors["user.lastName"]?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["user.lastName"][0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(3),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.client.user.email,expression:"client.user.email"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.client.user.email},on:{input:[function(e){e.target.composing||t.$set(t.client.user,"email",e.target.value)},function(e){return t.clearFieldError("user.email")}]}}),t._v(" "),t.errors["user.email"]?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["user.email"][0])+"\n\t\t\t\t\t")]):t._e()])])]),t._v(" "),e("div",{staticClass:"column"},[e("div",{staticClass:"field"},[t._m(4),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.client.user.phone,expression:"client.user.phone"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.client.user.phone},on:{input:[function(e){e.target.composing||t.$set(t.client.user,"phone",e.target.value)},function(e){return t.clearFieldError("user.phone")}]}}),t._v(" "),t.errors["user.phone"]?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors["user.phone"][0])+"\n\t\t\t\t\t")]):t._e()])])])]),t._v(" "),e("div",{staticClass:"field"},[t._m(5),t._v(" "),e("div",{staticClass:"control"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.client.companyName,expression:"client.companyName"}],staticClass:"input",attrs:{type:"text"},domProps:{value:t.client.companyName},on:{input:[function(e){e.target.composing||t.$set(t.client,"companyName",e.target.value)},function(e){return t.clearFieldError("companyName")}]}}),t._v(" "),t.errors.companyName?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.companyName[0])+"\n\t\t\t\t\t")]):t._e()])]),t._v(" "),e("div",{staticClass:"field"},[t._m(6),t._v(" "),e("div",{staticClass:"control"},[e("MarkdownEditor",{on:{input:function(e){return t.clearFieldError("description")}},model:{value:t.client.description,callback:function(e){t.$set(t.client,"description",e)},expression:"client.description"}}),t._v(" "),t.errors.description?e("span",{staticClass:"mb-2 has-text-danger"},[t._v("\n\t\t\t\t\t\t"+t._s(t.errors.description[0])+"\n\t\t\t\t\t")]):t._e()],1)]),t._v(" "),e("div",{staticClass:"flex justify-center m-3"},[e("button",{staticClass:"button is-rounded",class:{"is-loading":t.isLoading},attrs:{disabled:t.isLoading,type:"submit"},on:{click:function(e){return e.preventDefault(),e.stopPropagation(),t.updateClient.apply(null,arguments)}}},[t._v("Submit\n        ")])])])])};n._withStripped=!0;s(185),s(83);var r=s(186),o=s.n(r),l=s(34),c={components:{MarkdownEditor:s(374).a},mixins:[l.a],props:{clientId:{required:!0}},data:()=>({client:{user:{}},isLoading:!1}),created(){this.getClient()},methods:{getClient(){axios.get("/api/clients/"+this.clientId).then(t=>{this.client=t.data})},updateClient(){this.isLoading=!0,axios.put("/api/clients/"+this.clientId,this.client).then(t=>{this.isLoading=!1,o.a.success("Client successfully updated"),this.$emit("updateSuccessful")},t=>{this.isLoading=!1,400==t.response.status&&(this.errors=t.response.data)})}}},d=s(15),u=Object(d.a)(c,n,[function(){var t=this._self._c;return t("div",{staticClass:"has-text-centered m-3"},[t("h1",{staticClass:"has-text-black"},[t("b",[this._v("Add Client")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("First Name "),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Last Name "),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Email"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Phone"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Company Name"),t("span",[t("sup",[this._v("*")])])])},function(){var t=this._self._c;return t("label",{staticClass:"label"},[this._v("Description "),t("span",[t("sup",[this._v("*")])])])}],!1,null,null,null).exports,p={components:{ModalTemplate:a.a,ClientEditForm:u},methods:{onUpdated(){this.$emit("updateSuccessful"),this.$router.back()}}},m=Object(d.a)(p,i,[],!1,null,null,null);e.default=m.exports}}]);