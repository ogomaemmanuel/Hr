(window.webpackJsonp=window.webpackJsonp||[]).push([[9],{369:function(e,t,s){"use strict";t.a={data:()=>({pageable:!1,pageSize:10,page:0}),methods:{goToPrevious(){this.page--,this.fetchRecords()},goToNext(){this.page++,this.fetchRecords()},onPaginationChanged(e){this.page=0,this.pageSize=e,this.fetchRecords()}}}},461:function(e,t,s){var a=s(555);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);(0,s(22).default)("da41d9f4",a,!1,{})},462:function(e,t,s){var a=s(557);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);(0,s(22).default)("7c259512",a,!1,{})},463:function(e,t,s){var a=s(559);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);(0,s(22).default)("5cd4b610",a,!1,{})},464:function(e,t,s){var a=s(561);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);(0,s(22).default)("e7066286",a,!1,{})},554:function(e,t,s){"use strict";s(461)},555:function(e,t,s){(e.exports=s(21)(!1)).push([e.i,".received-message[data-v-2f068737]{display:flex;justify-content:start}.received-message .message-text[data-v-2f068737]{background-color:#fff;max-width:60%;border-radius:5px;padding:8px 15px}",""])},556:function(e,t,s){"use strict";s(462)},557:function(e,t,s){(e.exports=s(21)(!1)).push([e.i,".sent-message[data-v-7e46c1a1]{display:flex;justify-content:end}.sent-message .message-text[data-v-7e46c1a1]{background-color:#f2f2f2;border:1px solid #e3e3e3;max-width:60%;color:#727272;padding:8px 15px;border-radius:5px}.sent-message .message-text .chat-time[data-v-7e46c1a1]{display:flex;justify-content:end}",""])},558:function(e,t,s){"use strict";s(463)},559:function(e,t,s){(e.exports=s(21)(!1)).push([e.i,".conversions-messages-wrapper[data-v-4728b50e]{background-color:#f7f7f7;overflow-y:auto}",""])},560:function(e,t,s){"use strict";s(464)},561:function(e,t,s){(e.exports=s(21)(!1)).push([e.i,".chat-page[data-v-12d5b1c4]{margin-top:3.25rem}.chat-page .conversations-body[data-v-12d5b1c4]{overflow-x:hidden;overflow-y:scroll}.chat-page .conversions-messages-wrapper[data-v-12d5b1c4]{background-color:#f7f7f7;overflow-y:auto}.chat-page .conversation-header-title[data-v-12d5b1c4]{height:44px;border-bottom:1px solid rgba(0,0,0,.08);display:flex;align-items:center}.chat-page .message-title-bar[data-v-12d5b1c4]{height:44px;border-bottom:1px solid rgba(0,0,0,.08);display:flex;align-items:center}.chat-page .message-input-wrapper[data-v-12d5b1c4]{border-top-style:solid;border-top-width:1px;z-index:8}.chat-page .message-input-wrapper .paper-clip[data-v-12d5b1c4]{transform:rotate(90deg)}",""])},581:function(e,t,s){"use strict";s.r(t);var a=function(){var e=this,t=e._self._c;return t("div",{staticClass:"h-screen"},[t("div",{staticClass:"chat-page h-full"},[t("div",{staticClass:"h-full pt-8 pr-16 pl-16"},[t("div",{staticClass:"card overflow-hidden h-full rounded-t-lg"},[t("div",{staticClass:"card-content pt-0 h-full pr-0"},[t("div",{staticClass:"columns h-full"},[t("div",{staticClass:"column is-3 border-r-2 h-full pr-0"},[e._m(0),e._v(" "),t("div",{staticClass:"relative w-full h-full overflow-hidden pb-3"},[t("div",{staticClass:"conversations-body w-full h-full absolute"},[t("UserConversations",{on:{conversationChanged:e.changeRecipient}})],1)])]),e._v(" "),t("div",{staticClass:"column pl-0"},[t("div",{staticClass:"message-title-bar pl-2 pr-2"},[t("div",{staticClass:"flex w-full"},[t("div",{staticClass:"flex-1"},[e._v("\n                    "+e._s(e.recipient.fullName)+"\n                  ")]),e._v(" "),e._m(1)])]),e._v(" "),t("div",{staticClass:"message-area flex flex-col h-full"},[t("ChatMessages",{key:e.recipient.userId,attrs:{recipient:e.recipient}}),e._v(" "),t("div",{staticClass:"message-input-wrapper flex p-4"},[e._m(2),e._v(" "),t("input",{directives:[{name:"model",rawName:"v-model",value:e.message,expression:"message"}],staticClass:"input flex-1",attrs:{placeholder:"Type message...",type:"text"},domProps:{value:e.message},on:{input:function(t){t.target.composing||(e.message=t.target.value)}}}),e._v(" "),t("button",{staticClass:"button is-primary",on:{click:e.sendChatMessage}},[e._m(3)])])],1)])])])])])])])};a._withStripped=!0;var i=s(326),r=s.n(i),n=function(){var e=this._self._c;return e("div",{staticClass:"received-message mb-3"},[e("div",{staticClass:"message-text"},[this._v("\n    "+this._s(this.message.message)+"\n    "),e("div",{staticClass:"chat-time"},[this._v("\n      "+this._s(this.formatDate(this.message.createdAt))+"\n    ")])])])};n._withStripped=!0;var c={props:{message:{required:!0,type:Object}},data:()=>({}),methods:{isToday(e){const t=new Date;return e.getFullYear()===t.getFullYear()&&e.getMonth()===t.getMonth()&&e.getDate()===t.getDate()},formatDate(e){if(e)return this.isToday(new Date(e))?new Date(e).toLocaleTimeString():new Date(e).toLocaleDateString()}}},o=(s(554),s(15)),l=Object(o.a)(c,n,[],!1,null,"2f068737",null).exports,p=function(){var e=this._self._c;return e("div",{staticClass:"sent-message mb-3"},[e("div",{staticClass:"message-text"},[this._v("\n    "+this._s(this.message.message)+"\n    "),e("div",{staticClass:"chat-time"},[this._v("\n      "+this._s(this.formatDate(this.message.createdAt))+"\n    ")])])])};p._withStripped=!0;var d={props:{message:{type:Object,required:!0}},data:()=>({}),methods:{isToday(e){const t=new Date;return e.getFullYear()===t.getFullYear()&&e.getMonth()===t.getMonth()&&e.getDate()===t.getDate()},formatDate(e){if(e)return this.isToday(new Date(e))?new Date(e).toLocaleTimeString():new Date(e).toLocaleDateString()}}},g=(s(556),Object(o.a)(d,p,[],!1,null,"7e46c1a1",null).exports),u=function(){var e=this,t=e._self._c;return t("div",e._l(e.conversations,(function(s){return t("div",{key:s.id,staticClass:"flex pb-3 pt-3",on:{click:function(t){return e.onConversationClick(s)}}},[e._m(0,!0),e._v(" "),t("div",[e._v("\n      "+e._s(s.fullName)+"\n      "),t("div",[e._v("\n        "+e._s(s.lastMessage)+"\n      ")])])])})),0)};u._withStripped=!0;var h=s(369),f=s(23),v=function(){var e=this,t=e._self._c;return t("div",{ref:"messages",staticClass:"conversions-messages-wrapper flex-1 p-3"},e._l(e.sortedMessages,(function(s,a){return t("div",{key:a},[e.isSender(s)?t("SentMessage",{attrs:{message:s}}):t("ReceivedMessage",{attrs:{message:s}})],1)})),0)};v._withStripped=!0;var m=s(334),b=s.n(m);function y(e,t){var s=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),s.push.apply(s,a)}return s}function _(e){for(var t=1;t<arguments.length;t++){var s=null!=arguments[t]?arguments[t]:{};t%2?y(Object(s),!0).forEach((function(t){r()(e,t,s[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(s)):y(Object(s)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(s,t))}))}return e}var C={components:{SentMessage:g,ReceivedMessage:l},props:{recipient:{required:!0,type:Object}},data:()=>({messages:[]}),computed:_(_({},Object(f.c)(["authenticatedUser","chatMessage"])),{},{sortedMessages(){return this.messages.sort((function(e,t){return e.createdAt==t.createdAt?0:+(e.createdAt>t.createdAt)||-1}))}}),watch:{chatMessage(e,t){if(e&&(e.senderId==this.authenticatedUser.id&&e.recipientId==this.recipient.userId||e.recipientId==this.authenticatedUser.id&&e.senderId==this.recipient.userId)){this.messages=[].concat(b()(this.messages),[e])}},messages(){let e=this;e.$nextTick((function(){e.scrollMessagesToBottom()}))}},created(){this.getChatMessages()},methods:{async getChatMessages(){try{let e=await axios.get("/chats/"+this.recipient.userId);this.messages=e.data.content}catch(e){}},isSender(e){return e.senderId==this.authenticatedUser.id},scrollMessagesToBottom(){this.$refs.messages.scrollTop=this.$refs.messages.scrollHeight+this.$refs.messages.clientHeight}}},w=(s(558),Object(o.a)(C,v,[],!1,null,"4728b50e",null).exports);function O(e,t){var s=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),s.push.apply(s,a)}return s}var x={mixins:[h.a],data:()=>({conversations:[]}),created(){this.getConversations()},computed:function(e){for(var t=1;t<arguments.length;t++){var s=null!=arguments[t]?arguments[t]:{};t%2?O(Object(s),!0).forEach((function(t){r()(e,t,s[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(s)):O(Object(s)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(s,t))}))}return e}({},Object(f.c)(["chatMessage"])),watch:{chatMessage(){this.getConversations()}},methods:{onConversationClick(e){this.$emit("conversationChanged",e)},async getConversations(){let e=await axios.get("/chats/conversations",{params:{pageSize:this.pageSize,page:this.page}});this.conversations=e.data.content,this.conversations.length>0&&this.$emit("conversationChanged",this.conversations[0])}}};function j(e,t){var s=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),s.push.apply(s,a)}return s}function M(e){for(var t=1;t<arguments.length;t++){var s=null!=arguments[t]?arguments[t]:{};t%2?j(Object(s),!0).forEach((function(t){r()(e,t,s[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(s)):j(Object(s)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(s,t))}))}return e}var D={components:{UserConversations:Object(o.a)(x,u,[function(){var e=this._self._c;return e("figure",{staticClass:"image is-32x32"},[e("img",{attrs:{src:"/images/undraw_profile_pic_ic-5-t.svg"}})])}],!1,null,null,null).exports,ReceivedMessage:l,ChatMessages:w,SentMessage:g},data:()=>({message:"",recipient:{}}),methods:M(M({},Object(f.b)(["setChatMessage"])),{},{changeRecipient(e){console.log(e),this.recipient=M({},e)},async sendChatMessage(){let e={message:this.message,recipient:this.recipient.userId};try{let t=await axios.post("/chats",e);this.setChatMessage(t.data),this.message=""}catch(e){console.log("Error sending chat message")}}}),computed:{}},P=(s(560),Object(o.a)(D,a,[function(){var e=this._self._c;return e("div",{staticClass:"conversation-header"},[e("div",{staticClass:"conversation-header-title"},[e("h2",[this._v("Messaging")])]),this._v(" "),e("div",{staticClass:"message-search-wrapper pt-2 pb-2"},[e("div",{staticClass:"control has-icons-left has-icons-right"},[e("input",{staticClass:"input",attrs:{type:"text",placeholder:"Search Messages"}}),this._v(" "),e("span",{staticClass:"icon is-small is-left"},[e("i",{staticClass:"fa fa-search"})]),this._v(" "),e("span",{staticClass:"icon is-small is-right"},[e("i",{staticClass:"fa fa-sliders"})])])])])},function(){var e=this._self._c;return e("div",{staticClass:"flex"},[e("i",{staticClass:"fa fa-ellipsis-h text-danger"}),this._v(" "),e("i",{staticClass:"fa fa-video-camera pl-2"})])},function(){var e=this._self._c;return e("div",{staticClass:"flex justify-center pr-3 items-center"},[e("span",{staticClass:"icon is-small"},[e("i",{staticClass:"fa fa-paperclip fa-2x paper-clip"})])])},function(){var e=this._self._c;return e("span",{staticClass:"icon is-small"},[e("i",{staticClass:"fa fa-send"})])}],!1,null,"12d5b1c4",null));t.default=P.exports}}]);