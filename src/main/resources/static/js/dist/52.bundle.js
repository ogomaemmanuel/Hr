(window.webpackJsonp=window.webpackJsonp||[]).push([[52],{218:function(t,a,s){var e=s(278);"string"==typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);(0,s(27).default)("34198d16",e,!0,{})},219:function(t,a,s){var e=s(280);"string"==typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);(0,s(27).default)("1403536e",e,!0,{})},277:function(t,a,s){"use strict";var e=s(218);s.n(e).a},278:function(t,a,s){(t.exports=s(26)(!1)).push([t.i,".app-breadcrumb.el-breadcrumb[data-v-ad29f5d2]{display:inline-block;font-size:14px;line-height:50px;margin-left:8px}.app-breadcrumb.el-breadcrumb .no-redirect[data-v-ad29f5d2]{color:#97a8be;cursor:text}\n",""])},279:function(t,a,s){"use strict";var e=s(219);s.n(e).a},280:function(t,a,s){(t.exports=s(26)(!1)).push([t.i,".navbar-item .profile-image[data-v-b00caed6]{height:36px;width:36px;max-height:36px}.toggle-mobile-nav[data-v-b00caed6]{background-color:transparent;border:0px;padding:6px 16px;margin:0 0 0 -15px;height:46px}.menu-wrapper[data-v-b00caed6]{overflow-y:scroll;position:relative;height:100%;margin-top:2rem}.side-menu-portal-target[data-v-b00caed6]{display:revert}\n",""])},347:function(t,a,s){"use strict";s.r(a);s(185),s(73);var e=s(186),r=s.n(e),i=(s(187),s(188)),l=s.n(i),n=s(189),o={components:{Breadcrumb:l.a,BreadcrumbItem:r.a},data:()=>({levelList:null}),watch:{$route(t){t.path.startsWith("/redirect/")||this.getBreadcrumb()}},created(){this.getBreadcrumb()},methods:{getBreadcrumb(){let t=this.$route.matched.filter(t=>t.meta&&t.meta.title);const a=t[0];this.isHome(a)||(t=[{path:"/",meta:{title:"Home",redirect:!0}}].concat(t)),this.levelList=t.filter(t=>t.meta&&t.meta.title&&!1!==t.meta.breadcrumb)},isHome(t){const a=t&&t.name;return!!a&&a.trim().toLocaleLowerCase()==="Home".toLocaleLowerCase()},pathCompile(t){const{params:a}=this.$route;return n.a(t)(a)},handleLink(t){const{redirect:a,path:s}=t;a?this.$router.push(a):this.$router.push(this.pathCompile(s))}}},c=(s(277),s(20)),p={components:{TestBreadCrump:Object(c.a)(o,(function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("Breadcrumb",{staticClass:"app-breadcrumb",attrs:{separator:"/"}},[s("transition-group",{attrs:{name:"breadcrumb"}},t._l(t.levelList,(function(a,e){return s("BreadcrumbItem",{key:a.path},["noRedirect"===a.redirect||e==t.levelList.length-1?s("span",{staticClass:"no-redirect"},[t._v(t._s(a.meta.title))]):s("a",{on:{click:function(s){return s.preventDefault(),t.handleLink(a)}}},[t._v(t._s(a.meta.title))])])})),1)],1)}),[],!1,null,"ad29f5d2",null).exports},data:()=>({isFullPage:!0}),computed:{},created(){},methods:{}},v=(s(279),Object(c.a)(p,(function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",[s("section",{staticClass:"main-content columns  is-fullheight"},[s("aside",{staticClass:"column pt-12 is-2 bg-gray-900 text-white pr-0 pl-3 pt-5 is-narrow-mobile fixed inset-y-0 section is-hidden-mobile"},[s("div",{staticClass:"menu-wrapper"},[s("portal-target",{staticClass:"side-menu-portal-target",attrs:{name:"side-menu"}},[s("ul",{staticClass:"menu-list"},[s("li",[s("router-link",{attrs:{to:"/"}},[s("span",{staticClass:"icon",attrs:{tag:"span",to:"/"}},[s("i",{staticClass:"fa fa-home"})]),t._v(" Home\n              ")])],1),t._v(" "),s("li",[s("a",{attrs:{href:"#"}},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-group"})]),t._v(" Access Control\n              ")]),t._v(" "),s("ul",{staticClass:"mr-0 pr-0 border-l-0"},[s("li",[s("router-link",{attrs:{to:"/users"}},[s("span",[t._v("Users")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"roles"}},[s("span",[t._v("Roles")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/permissions"}},[s("span",[t._v("Permissions")])])],1)])]),t._v(" "),s("li",[s("a",{attrs:{href:"#"}},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-building-o"})]),t._v(" Employee Management\n              ")]),t._v(" "),s("ul",{staticClass:"mr-0 pr-0 border-l-0"},[s("li",[s("router-link",{attrs:{to:"/employees"}},[s("span",[t._v("All Employees")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/departments"}},[s("span",[t._v("Departments")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/designations"}},[s("span",[t._v("Designations")])])],1),t._v(" "),s("li",[s("a",{attrs:{href:"#"}},[s("span",[t._v("Attendance(Admin)")])])]),t._v(" "),s("li",[s("a",{attrs:{href:"#"}},[s("span",[t._v("Attendance(Employee)")])])]),t._v(" "),s("li",[s("router-link",{attrs:{to:"/overtime-requests"}},[s("span",[t._v("Overtime")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/employee-resignations"}},[s("span",[t._v("Resignation")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/employee-terminations"}},[s("span",[t._v("Termination")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/policies"}},[s("span",[t._v("Policy")])])],1)])]),t._v(" "),s("li",[s("a",{attrs:{href:"#"}},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-money"})]),t._v(" Payroll\n              ")]),t._v(" "),s("ul",{staticClass:"mr-0 pr-0 border-l-0"},[s("li",[s("router-link",{attrs:{to:"/salary"}},[s("span",[t._v("Employee Salary")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/salary-view"}},[s("span",[t._v("Payslip")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/payroll-items"}},[s("span",[t._v("Payroll Items")])])],1)])]),t._v(" "),s("li",[s("a",{attrs:{href:"#"}},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-money"})]),t._v(" Project Management\n              ")]),t._v(" "),s("ul",{staticClass:"mr-0 pr-0 border-l-0"},[s("li",[s("router-link",{attrs:{to:"/clients"}},[s("span",[t._v("Clients")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/projects"}},[s("span",[t._v("Projects")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/tasks"}},[s("span",[t._v("Tasks")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/payroll-items"}},[s("span",[t._v("Task Board")])])],1)])]),t._v(" "),s("li",[s("a",{attrs:{href:"#"}},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-table"})]),t._v(" Leave Management\n              ")]),t._v(" "),s("ul",{staticClass:"border-l-0"},[s("li",[s("router-link",{attrs:{to:"/leave"}},[s("span",[t._v("My Leaves")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/documents"}},[s("span",[t._v("In Place")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/leave-approvals"}},[s("span",[t._v("Leave approvals")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/holidays"}},[s("span",[t._v("Holidays")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/leave-types"}},[s("span",[t._v("Leave Types")])])],1)])]),t._v(" "),s("li",[s("a",{attrs:{href:"#"}},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-files-o"})]),t._v(" Accounts\n              ")]),t._v(" "),s("ul",{staticClass:"border-l-0"},[s("li",[s("router-link",{attrs:{to:"/estimates"}},[s("span",[t._v("Estimates")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/invoices"}},[s("span",[t._v("Invoices")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/payments"}},[s("span",[t._v("Payments")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/expenses"}},[s("span",[t._v("Expenses")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/provident-funds"}},[s("span",[t._v("Provided Fund")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/taxes"}},[s("span",[t._v("Taxes")])])],1)])]),t._v(" "),s("li",[s("router-link",{attrs:{to:"/assets"}},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-object-ungroup"})]),t._v(" Assets\n              ")])],1),t._v(" "),s("li",[s("a",{attrs:{href:"#"}},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-briefcase"})]),t._v(" Jobs\n              ")]),t._v(" "),s("ul",{staticClass:"border-l-0"},[s("li",[s("router-link",{attrs:{to:"/jobs"}},[s("span",[t._v("Manage Jobs")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/taxes"}},[s("span",[t._v("Applied Candidates")])])],1)])]),t._v(" "),s("li",[s("a",{attrs:{href:"#"}},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-folder-open"})]),t._v(" File Management\n              ")]),t._v(" "),s("ul",{staticClass:"border-l-0"},[s("li",[s("router-link",{attrs:{to:"/documents"}},[s("span",[t._v("Manage Files")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/documents"}},[s("span",[t._v("My Files")])])],1)])]),t._v(" "),s("li",[s("a",{attrs:{href:"#"}},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-info"})]),t._v(" About\n              ")])])])])],1),t._v(" "),t._m(0)]),t._v(" "),s("div",{staticClass:" column is-offset-2 is-10 pr-10 pl-10 pb-10 pt-20 h-screen mb-0"},[s("div",{},[s("div",{staticClass:"columns"},[s("div",{staticClass:"column"},[s("div",{staticClass:"flex align-center"},[t._m(1),t._v(" "),s("TestBreadCrump")],1)]),t._v(" "),s("div",{staticClass:"column"},[s("div",{staticClass:"flex sm:justify-start md:justify-end"},[s("portal-target",{attrs:{name:"page-controls"}})],1)])])]),t._v(" "),s("div",{staticClass:"mt-5 h-full"},[s("router-view")],1)])])])}),[function(){var t=this.$createElement,a=this._self._c||t;return a("div",{staticClass:"side-bar-footer bg-gray-800 left-0  right-0 h-8 absolute bottom-0"},[a("div",{staticClass:"flex justify-end mr-4"},[a("i",[a("span",{staticClass:"fa fa-angle-left"})])])])},function(){var t=this.$createElement,a=this._self._c||t;return a("button",{staticClass:"is-hidden-desktop toggle-mobile-nav",attrs:{type:"button"}},[a("i",{staticClass:"fa fa-bars text-gray-600"})])}],!1,null,"b00caed6",null));a.default=v.exports}}]);