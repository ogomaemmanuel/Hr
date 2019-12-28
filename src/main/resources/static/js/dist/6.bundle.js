(window.webpackJsonp=window.webpackJsonp||[]).push([[6],{114:function(t,a,s){"use strict";s.r(a);var e={data:()=>({csrfToken:null}),created(){this.csrfToken=document.querySelector("meta[name='_csrf']").getAttribute("content")},methods:{logout(){this.$refs.logoutForm.submit()}}},i=s(2),n={components:{LogoutForm:Object(i.a)(e,function(){var t=this.$createElement,a=this._self._c||t;return a("b-tooltip",{attrs:{label:"logout",type:"is-dark",position:"is-left"}},[a("form",{ref:"logoutForm",attrs:{method:"post",action:"/logout"}},[a("input",{attrs:{type:"hidden",name:"_csrf"},domProps:{value:this.csrfToken}}),this._v(" "),a("i",{staticClass:"fa fa-sign-out fa-2x",on:{click:this.logout}})])])},[],!1,null,null,null).exports},props:{user:{}},data:()=>({isFullPage:!0}),created(){},methods:{open(){const t=this.$buefy.loading.open({container:this.isFullPage?null:this.$refs.element.$el});setTimeout(()=>t.close(),3e3)}}},r=(s(80),Object(i.a)(n,function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",[s("nav",{staticClass:"navbar is-primary",attrs:{role:"navigation","aria-label":"main navigation"}},[t._m(0),t._v(" "),s("div",{staticClass:"navbar-menu",attrs:{id:"navbarBasicExample"}},[t._m(1),t._v(" "),s("div",{staticClass:"navbar-end"},[s("div",{staticClass:"navbar-item"},[s("LogoutForm")],1),t._v(" "),t._m(2)])])]),t._v(" "),s("section",{staticClass:"main-content columns  is-fullheight"},[s("aside",{staticClass:"column is-2 bg-gray-900 text-white pr-0 pl-3 pt-0 is-narrow-mobile is-fixed h-screen section is-hidden-mobile"},[s("p",{staticClass:"menu-label is-hidden-touch"},[t._v("Navigation")]),t._v(" "),s("ul",{staticClass:"menu-list"},[t._m(3),t._v(" "),s("li",[t._m(4),t._v(" "),s("ul",{staticClass:"mr-0 pr-0 border-l-0"},[s("li",[s("router-link",{attrs:{to:"/users"}},[s("span",[t._v("Users")])])],1),t._v(" "),t._m(5),t._v(" "),t._m(6)])]),t._v(" "),s("li",[t._m(7),t._v(" "),s("ul",{staticClass:"border-l-0"},[s("li",[s("router-link",{attrs:{to:"/documents"}},[s("span",[t._v("Manage Files")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/documents"}},[s("span",[t._v("My Files")])])],1)])]),t._v(" "),s("li",[t._m(8),t._v(" "),s("ul",{staticClass:"border-l-0"},[s("li",[s("router-link",{attrs:{to:"/leave"}},[s("span",[t._v("My Leaves")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/documents"}},[s("span",[t._v("In Place")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/documents"}},[s("span",[t._v("Leave approval")])])],1),t._v(" "),s("li",[s("router-link",{attrs:{to:"/holidays"}},[s("span",[t._v("Holidays")])])],1)])]),t._v(" "),t._m(9)])]),t._v(" "),s("div",{staticClass:"container column is-10 p-10 h-screen mb-0"},[s("div",{staticClass:"flex items-center"},[t._m(10),t._v(" "),s("breadcrumbs",{})],1),t._v(" "),s("router-view")],1)])])},[function(){var t=this.$createElement,a=this._self._c||t;return a("div",{staticClass:"navbar-brand"},[a("a",{staticClass:"navbar-item",attrs:{href:"https://bulma.io"}},[a("img",{attrs:{src:"https://bulma.io/images/bulma-logo.png",width:"112",height:"28"}})]),this._v(" "),a("a",{staticClass:"navbar-burger burger",attrs:{role:"button","aria-label":"menu","aria-expanded":"false","data-target":"navbarBasicExample"}},[a("span",{attrs:{"aria-hidden":"true"}}),this._v(" "),a("span",{attrs:{"aria-hidden":"true"}}),this._v(" "),a("span",{attrs:{"aria-hidden":"true"}})])])},function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"navbar-start"},[s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\tHome\n\t\t\t\t")]),t._v(" "),s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\tDocumentation\n\t\t\t\t")]),t._v(" "),s("div",{staticClass:"navbar-item has-dropdown is-hoverable"},[s("a",{staticClass:"navbar-link"},[t._v("\n\t\t\t\t\t\tMore\n\t\t\t\t\t")]),t._v(" "),s("div",{staticClass:"navbar-dropdown"},[s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tAbout\n\t\t\t\t\t\t")]),t._v(" "),s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tJobs\n\t\t\t\t\t\t")]),t._v(" "),s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tContact\n\t\t\t\t\t\t")]),t._v(" "),s("hr",{staticClass:"navbar-divider"}),t._v(" "),s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tReport an issue\n\t\t\t\t\t\t")])])])])},function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"navbar-item has-dropdown is-hoverable"},[s("figure",{staticClass:"image is-fullwidth navbar-link"},[s("img",{staticClass:"is-rounded profile-image",attrs:{src:"https://bulma.io/images/placeholders/128x128.png"}})]),t._v(" "),s("div",{staticClass:"navbar-dropdown is-right"},[s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tOverview\n\t\t\t\t\t\t")]),t._v(" "),s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tElements\n\t\t\t\t\t\t")]),t._v(" "),s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tComponents\n\t\t\t\t\t\t")]),t._v(" "),s("hr",{staticClass:"navbar-divider"}),t._v(" "),s("div",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tVersion 0.7.5\n\t\t\t\t\t\t")])])])},function(){var t=this.$createElement,a=this._self._c||t;return a("li",[a("a",{attrs:{href:"#"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-home"})]),this._v(" Home\n\t\t\t\t\t")])])},function(){var t=this.$createElement,a=this._self._c||t;return a("a",{attrs:{href:"#"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-table"})]),this._v(" Access Control\n\t\t\t\t\t")])},function(){var t=this.$createElement,a=this._self._c||t;return a("li",[a("a",{attrs:{href:"#"}},[a("span",[this._v("Roles")])])])},function(){var t=this.$createElement,a=this._self._c||t;return a("li",[a("a",{attrs:{href:"#"}},[a("span",[this._v("Permissions")])])])},function(){var t=this.$createElement,a=this._self._c||t;return a("a",{attrs:{href:"#"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-folder-open"})]),this._v(" File Management\n\t\t\t\t\t")])},function(){var t=this.$createElement,a=this._self._c||t;return a("a",{attrs:{href:"#"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-table"})]),this._v(" Leave Management\n\t\t\t\t\t")])},function(){var t=this.$createElement,a=this._self._c||t;return a("li",[a("a",{attrs:{href:"#"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-info"})]),this._v(" About\n\t\t\t\t\t")])])},function(){var t=this.$createElement,a=this._self._c||t;return a("button",{staticClass:"is-hidden-desktop toggle-mobile-nav",attrs:{type:"button"}},[a("i",{staticClass:"fa fa-bars text-gray-600"})])}],!1,null,"23ed84d1",null));a.default=r.exports},68:function(t,a,s){var e=s(81);"string"==typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);(0,s(5).default)("82779e06",e,!0,{})},80:function(t,a,s){"use strict";var e=s(68);s.n(e).a},81:function(t,a,s){(t.exports=s(4)(!1)).push([t.i,".navbar-item .profile-image[data-v-23ed84d1]{height:36px;width:36px;max-height:36px}.toggle-mobile-nav[data-v-23ed84d1]{background-color:transparent;border:0px;padding:6px 16px;margin:0 0 0 -15px;height:46px}\n",""])}}]);