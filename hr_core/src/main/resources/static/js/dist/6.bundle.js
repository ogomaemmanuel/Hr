(window.webpackJsonp=window.webpackJsonp||[]).push([[6,10],{223:function(t,e,s){var a=s(227);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(21).default)("3c92a25e",a,!1,{})},224:function(t,e,s){"use strict";var a=function(){var t=this,e=t._self._c;return e("div",{staticClass:"modal-wrapper"},[e("div",{ref:"modal",staticClass:"modal"},[e("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[e("div",{staticClass:"box",class:t.hasPadding?"":"p-0"},[t._t("modal-content")],2)]),t._v(" "),t.showCloseButton?[e("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(e){return e.stopPropagation(),t.closeModal.apply(null,arguments)}}})]:t._e()],2)])};a._withStripped=!0;var i={mixins:[s(225).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0},hasPadding:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},n=(s(226),s(14)),c=Object(n.a)(i,a,[],!1,null,"f5b23902",null);e.a=c.exports},225:function(t,e,s){"use strict";(function(t){e.a={methods:{closeModal(){t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,s(184))},226:function(t,e,s){"use strict";s(223)},227:function(t,e,s){(t.exports=s(20)(!1)).push([t.i,".modal[data-v-f5b23902]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-f5b23902]{overflow:visible}\n",""])},237:function(t,e,s){var a=s(250);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(21).default)("9204b060",a,!1,{})},238:function(t,e,s){var a=s(252);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(21).default)("08ed85f0",a,!1,{})},243:function(t,e,s){"use strict";var a=function(){var t=this,e=t._self._c;return e("ModalTemplate",{attrs:{"has-padding":!1},on:{modalClosed:function(e){return t.$emit("modalClosed")}}},[e("div",{attrs:{slot:"modal-content"},slot:"modal-content"},[e("div",{staticClass:"punch-in-header h-16 bg-yellow-800"},[e("div",{staticClass:"flex justify-center relative"},[e("figure",{staticClass:"image punch-in-user-profile-image is-64x64 absolute"},[e("img",{attrs:{src:"/images/undraw_profile_pic_ic-5-t.svg",alt:""}})])])]),t._v(" "),t.showSuccessMessage?t._e():[e("div",{staticClass:"flex mt-5 flex-col items-center justify-center"},[e("div",[e("h2",[t._v("Emmanuel Ogoma")])]),t._v(" "),e("div",[e("h2",[t._v("Welcome!")])])]),t._v(" "),e("div",{staticClass:"mt-5 pb-5"},[e("div",{staticClass:"flex flex-col items-center justify-center"},[e("i",{staticClass:"fa fa-sign-in fa-3x has-text-primary",on:{click:t.punchIn}}),t._v(" "),e("h2",[t._v(" Click to Punch In")])])])],t._v(" "),t.showSuccessMessage?[e("div",{staticClass:"flex mt-5 flex-col items-center justify-center"},[e("div",[e("h2",[t._v("Emmanuel Ogoma")])]),t._v(" "),e("div",[e("h2",[t._v("Welcome!")])]),t._v(" "),e("div",{staticClass:"mt-5"},[t._v("\n          Checked in at "+t._s(t.attendance.attendanceTime.toLocaleTimeString())+"\n        ")])]),t._v(" "),e("div",{staticClass:"mt-5 pb-5"},[e("div",{staticClass:"flex flex-col items-center justify-center"},[e("button",{staticClass:"button is-primary",on:{click:function(e){return t.$emit("createSuccessful")}}},[t._v("OK")])])])]:t._e()],2)])};a._withStripped=!0;s(182),s(81);var i=s(183),n=s.n(i),c=s(33),o={components:{ModalTemplate:s(224).a},mixins:[c.a],data:()=>({showSuccessMessage:!1,attendance:{type:"PUNCH_IN",attendanceTime:null}}),methods:{punchIn(){this.attendance.attendanceTime=new Date,axios.post("api/attendance/me",this.attendance).then(t=>{this.showSuccessMessage=!0,n.a.success("Attendance created Successfully")},t=>{400==t.response.status&&(this.errors=t.response.data)})}}},l=(s(249),s(14)),r=Object(l.a)(o,a,[],!1,null,"32bd7180",null);e.a=r.exports},249:function(t,e,s){"use strict";s(237)},250:function(t,e,s){(t.exports=s(20)(!1)).push([t.i,".punch-in-user-profile-image[data-v-32bd7180]{bottom:-5.5rem}\n",""])},251:function(t,e,s){"use strict";s(238)},252:function(t,e,s){(t.exports=s(20)(!1)).push([t.i,".punch-in-user-profile-image[data-v-780e6c13]{bottom:-5.5rem}\n",""])},297:function(t,e,s){var a=s(366);a.__esModule&&(a=a.default),"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,s(21).default)("23fb8217",a,!1,{})},331:function(t,e,s){"use strict";s.r(e);var a=function(){var t=this,e=t._self._c;return e("div",{staticClass:"card"},[e("div",{staticClass:"card-content"},[e("h2",[t._v("Timesheet 11 Mar 2019")]),t._v(" "),t._m(0),t._v(" "),t._m(1),t._v(" "),e("div",{staticClass:"flex justify-center mt-5"},[t.showPunchInButton?e("button",{staticClass:"button primary",on:{click:function(e){t.showPunchInForm=!0}}},[t._v("Punch In\n      ")]):e("button",{staticClass:"button primary",on:{click:function(e){t.showPunchOutForm=!0}}},[t._v("Punch Out\n      ")])]),t._v(" "),t._m(2)]),t._v(" "),t.showPunchInForm?e("PunchInForm",{on:{createSuccessful:t.handlePunchInSuccessful,modalClosed:function(e){t.showPunchInForm=!1}}}):t._e(),t._v(" "),t.showPunchOutForm?e("PunchOutForm",{on:{createSuccessful:t.handlePunchOutSuccessful,modalClosed:function(e){t.showPunchOutForm=!1}}}):t._e()],1)};a._withStripped=!0;var i=s(188),n=s.n(i),c=s(243),o=function(){var t=this,e=t._self._c;return e("ModalTemplate",{attrs:{"has-padding":!1},on:{modalClosed:function(e){return t.$emit("modalClosed")}}},[e("div",{attrs:{slot:"modal-content"},slot:"modal-content"},[e("div",{staticClass:"punch-in-header h-16 bg-yellow-800"},[e("div",{staticClass:"flex justify-center relative"},[e("figure",{staticClass:"image punch-in-user-profile-image is-64x64 absolute"},[e("img",{attrs:{src:"/images/undraw_profile_pic_ic-5-t.svg",alt:""}})])])]),t._v(" "),t.showSuccessMessage?t._e():[e("div",{staticClass:"flex mt-5 flex-col items-center justify-center"},[e("div",[e("h2",[t._v("Emmanuel Ogoma")])]),t._v(" "),e("div",[e("h2",[t._v("Want to checkout?")])])]),t._v(" "),e("div",{staticClass:"mt-5 pb-5"},[e("div",{staticClass:"flex flex-col items-center justify-center"},[e("i",{staticClass:"fa fa-sign-out fa-3x has-text-primary",on:{click:t.punchIn}}),t._v(" "),e("h2",[t._v(" Click to Check Out")])])])],t._v(" "),t.showSuccessMessage?[e("div",{staticClass:"flex mt-5 flex-col items-center justify-center"},[e("div",[e("h2",[t._v("Emmanuel Ogoma")])]),t._v(" "),e("div",[e("h2",[t._v("Have a good day?")])]),t._v(" "),e("div",{staticClass:"mt-5"},[t._v("\n          Checked out at "+t._s(t.attendance.attendanceTime.toLocaleTimeString())+"\n        ")])]),t._v(" "),e("div",{staticClass:"mt-5 pb-5"},[e("div",{staticClass:"flex flex-col items-center justify-center"},[e("button",{staticClass:"button is-primary",on:{click:function(e){return t.$emit("createSuccessful")}}},[t._v("Goodbye")])])])]:t._e()],2)])};o._withStripped=!0;s(182),s(81);var l=s(183),r=s.n(l),u=s(33),d={components:{ModalTemplate:s(224).a},mixins:[u.a],data:()=>({showSuccessMessage:!1,attendance:{type:"PUNCH_OUT",attendanceTime:null}}),methods:{punchIn(){this.attendance.attendanceTime=new Date,axios.post("api/attendance/me",this.attendance).then(t=>{this.showSuccessMessage=!0,r.a.success("Attendance created Successfully")},t=>{400==t.response.status&&(this.errors=t.response.data)})}}},v=(s(251),s(14)),h=Object(v.a)(d,o,[],!1,null,"780e6c13",null).exports;function f(t,e){var s=Object.keys(t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(t);e&&(a=a.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),s.push.apply(s,a)}return s}function m(t){for(var e=1;e<arguments.length;e++){var s=null!=arguments[e]?arguments[e]:{};e%2?f(Object(s),!0).forEach((function(e){n()(t,e,s[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(s)):f(Object(s)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(s,e))}))}return t}var p={components:{PunchInForm:c.a,PunchOutForm:h},data:()=>({showPunchOutForm:!1,showPunchInForm:!1,lastActivity:{punchInTime:null,punchOutTime:null}}),created(){this.getLastActivity()},methods:{getLastActivity(){let t=this;axios.get("/api/attendance/last-activity").then(e=>{this.lastActivity=m(m({},t.lastActivity),e.data)})},handlePunchInSuccessful(){this.showPunchInForm=!1,this.getLastActivity()},handlePunchOutSuccessful(){this.showPunchOutForm=!1,this.getLastActivity()}},computed:{showPunchInButton(){return this.lastActivity.punchInTime&&this.lastActivity.punchOutTime?Date.parse(this.lastActivity.punchInTime)<Date.parse(this.lastActivity.punchOutTime):!this.lastActivity.punchInTime}}},_=Object(v.a)(p,a,[function(){var t=this._self._c;return t("div",[t("div",{staticClass:"flex mt-5 justify-center p-2 bg-gray-100"},[t("div",[t("h2",{staticClass:"font-bold"},[this._v("Punch In at")]),this._v(" "),t("h2",[this._v("Wed, 11th Mar 2019 10.00 AM")])])])])},function(){var t=this._self._c;return t("div",{staticClass:"flex mt-5 justify-center items-center"},[t("div",{staticClass:"flex border-gray-200 border-2 h-24 w-24 rounded-full bg-gray-100 items-center justify-center"},[t("h2",[this._v("3.45 hrs")])])])},function(){var t=this._self._c;return t("div",{staticClass:"flex justify-between mt-8"},[t("div",{staticClass:"flex items-center justify-center h-8 bg-gray-200 pb-5 pt-5 pl-10 pr-10"},[t("h2",[this._v("Break")])]),this._v(" "),t("div",{staticClass:"flex items-center justify-center h-8 bg-gray-200 pb-5 pt-5 pl-10 pr-10"},[t("h2",[this._v("Overtime")])])])}],!1,null,null,null);e.default=_.exports},365:function(t,e,s){"use strict";s(297)},366:function(t,e,s){(t.exports=s(20)(!1)).push([t.i,".dot[data-v-7089660b]{left:-5px;top:-7px}\n",""])},463:function(t,e,s){"use strict";s.r(e);var a=function(){var t=this,e=t._self._c;return e("div",[e("div",{staticClass:"columns"},[e("div",{staticClass:"column"},[e("LastActivityCard")],1),t._v(" "),t._m(0),t._v(" "),e("div",{staticClass:"column"},[e("AttendanceActivities")],1)]),t._v(" "),t._m(1),t._v(" "),t.showPunchInForm?e("PunchInForm",{on:{createSuccessful:t.handlePunchInSuccessful,modalClosed:function(e){t.showPunchInForm=!1}}}):t._e()],1)};a._withStripped=!0;var i=s(243),n=function(){var t=this,e=t._self._c;return e("div",{staticClass:"card h-60"},[e("div",{staticClass:"card-content"},[e("h2",{staticClass:"font-bold"},[t._v("Today Activity")]),t._v(" "),t._l(t.activities,(function(s){return e("div",{staticClass:"attendance-activity mt-2 h-16 border-l-2 relative pl-2"},[e("div",[e("p",[t._v(t._s(s.type))]),t._v(" "),e("p",[t._m(0,!0),t._v(" "+t._s(t.convertToLocalTimeString(s.attendanceTime)))])]),t._v(" "),t._m(1,!0)])}))],2)])};n._withStripped=!0;var c={data:()=>({activities:[]}),created(){this.getActivityForToday()},methods:{getActivityForToday(){axios.get("/api/attendance/today-activity").then(t=>{this.activities=t.data})},convertToLocalTimeString:t=>t?new Date(Date.parse(t)).toLocaleTimeString():""}},o=(s(365),s(14)),l=Object(o.a)(c,n,[function(){var t=this._self._c;return t("span",[t("i",{staticClass:"fa fa-clock-o"})])},function(){var t=this._self._c;return t("div",{staticClass:"absolute dot"},[t("span",{staticClass:"block h-2 w-2 rounded-full bg-gray-300"})])}],!1,null,"7089660b",null).exports,r=s(331),u={components:{PunchInForm:i.a,LastActivityCard:r.default,AttendanceActivities:l},data:()=>({lastActivity:null,showPunchInForm:!1,attendance:[],activities:[]}),methods:{getAttendance(){axios.get("/api/attendance").then(t=>{this.attendance=t.data.content})},getLastActivity(){axios.get("/api/attendance/last-activity").then(t=>{this.lastActivity=t.data})},getActivityForToday(){axios.get("/api/attendance/today-activity").then(t=>{this.activities=t.data})},handlePunchInSuccessful(){this.showPunchInForm=!1,this.getAttendance()}}},d=Object(o.a)(u,a,[function(){var t=this._self._c;return t("div",{staticClass:"column"},[t("div",{staticClass:"card"},[t("div",{staticClass:"card-content"},[t("h2",{staticClass:"font-bold"},[this._v("Statistics")]),this._v(" "),t("div",{staticClass:"card mt-3 h-16"},[t("div",{staticClass:"card-content"})]),this._v(" "),t("div",{staticClass:"card mt-2 h-16"},[t("div",{staticClass:"card-content"})]),this._v(" "),t("div",{staticClass:"card mt-2 h-16"},[t("div",{staticClass:"card-content"})]),this._v(" "),t("div",{staticClass:"card mt-2 h-16"},[t("div",{staticClass:"card-content"})]),this._v(" "),t("div",{staticClass:"card mt-2 h-16"},[t("div",{staticClass:"card-content"})])])])])},function(){var t=this,e=t._self._c;return e("table",{staticClass:"table is-fullwidth"},[e("thead",[e("tr",[e("td",[t._v("Date")]),t._v(" "),e("td",[t._v("Punch In")]),t._v(" "),e("td",[t._v("Punch Out")]),t._v(" "),e("td",[t._v("Production")]),t._v(" "),e("td",[t._v("Break")]),t._v(" "),e("td",[t._v("Overtime")])])])])}],!1,null,null,null);e.default=d.exports}}]);