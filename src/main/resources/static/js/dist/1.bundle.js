(window.webpackJsonp=window.webpackJsonp||[]).push([[1],{65:function(t,a,s){},66:function(t,a,s){"use strict";var i=s(65);s.n(i).a},68:function(t,a,s){"use strict";s.r(a);var i={props:{user:{}},data:()=>({isFullPage:!0,csrfToken:null}),created(){this.open(),this.csrfToken=document.querySelector("meta[name='_csrf']").getAttribute("content")},methods:{logout(){this.$refs.logoutForm.submit()},open(){const t=this.$buefy.loading.open({container:this.isFullPage?null:this.$refs.element.$el});setTimeout(()=>t.close(),3e3)}}},n=(s(66),s(2)),e=Object(n.a)(i,function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",[s("nav",{staticClass:"navbar is-primary",attrs:{role:"navigation","aria-label":"main navigation"}},[t._m(0),t._v(" "),s("div",{staticClass:"navbar-menu",attrs:{id:"navbarBasicExample"}},[t._m(1),t._v(" "),s("div",{staticClass:"navbar-end"},[s("div",{staticClass:"navbar-item"},[s("b-tooltip",{attrs:{label:"logout",type:"is-dark",position:"is-left"}},[s("form",{ref:"logoutForm",attrs:{method:"post",action:"/logout"}},[s("input",{attrs:{type:"hidden",name:"_csrf"},domProps:{value:t.csrfToken}}),t._v(" "),s("i",{staticClass:"fa fa-sign-out fa-2x",on:{click:t.logout}})])])],1),t._v(" "),t._m(2)])])]),t._v(" "),s("section",{staticClass:"main-content columns is-fullheight"},[s("aside",{staticClass:"column is-2 is-narrow-mobile is-fixed is-fullheight section is-hidden-mobile"},[s("p",{staticClass:"menu-label is-hidden-touch"},[t._v("Navigation")]),t._v(" "),s("ul",{staticClass:"menu-list"},[t._m(3),t._v(" "),s("li",[t._m(4),t._v(" "),s("ul",[s("li",[s("router-link",{attrs:{to:"/users"}},[s("span",{staticClass:"icon is-small"},[s("i",{staticClass:"fa fa-link"})]),t._v(" Users\n\t\t\t\t\t\t\t")])],1),t._v(" "),t._m(5)])]),t._v(" "),t._m(6)])]),t._v(" "),s("div",{staticClass:"container column is-10"},[s("router-view")],1)])])},[function(){var t=this.$createElement,a=this._self._c||t;return a("div",{staticClass:"navbar-brand"},[a("a",{staticClass:"navbar-item",attrs:{href:"https://bulma.io"}},[a("img",{attrs:{src:"https://bulma.io/images/bulma-logo.png",width:"112",height:"28"}})]),this._v(" "),a("a",{staticClass:"navbar-burger burger",attrs:{role:"button","aria-label":"menu","aria-expanded":"false","data-target":"navbarBasicExample"}},[a("span",{attrs:{"aria-hidden":"true"}}),this._v(" "),a("span",{attrs:{"aria-hidden":"true"}}),this._v(" "),a("span",{attrs:{"aria-hidden":"true"}})])])},function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"navbar-start"},[s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\tHome\n\t\t\t\t")]),t._v(" "),s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\tDocumentation\n\t\t\t\t")]),t._v(" "),s("div",{staticClass:"navbar-item has-dropdown is-hoverable"},[s("a",{staticClass:"navbar-link"},[t._v("\n\t\t\t\t\t\tMore\n\t\t\t\t\t")]),t._v(" "),s("div",{staticClass:"navbar-dropdown"},[s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tAbout\n\t\t\t\t\t\t")]),t._v(" "),s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tJobs\n\t\t\t\t\t\t")]),t._v(" "),s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tContact\n\t\t\t\t\t\t")]),t._v(" "),s("hr",{staticClass:"navbar-divider"}),t._v(" "),s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tReport an issue\n\t\t\t\t\t\t")])])])])},function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"navbar-item has-dropdown is-hoverable"},[s("figure",{staticClass:"image is-fullwidth navbar-link is-64x64"},[s("img",{staticClass:"is-rounded",attrs:{src:"https://bulma.io/images/placeholders/128x128.png"}})]),t._v(" "),s("div",{staticClass:"navbar-dropdown is-right"},[s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tOverview\n\t\t\t\t\t\t")]),t._v(" "),s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tElements\n\t\t\t\t\t\t")]),t._v(" "),s("a",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tComponents\n\t\t\t\t\t\t")]),t._v(" "),s("hr",{staticClass:"navbar-divider"}),t._v(" "),s("div",{staticClass:"navbar-item"},[t._v("\n\t\t\t\t\t\t\tVersion 0.7.5\n\t\t\t\t\t\t")])])])},function(){var t=this.$createElement,a=this._self._c||t;return a("li",[a("a",{attrs:{href:"#"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-home"})]),this._v(" Home\n\t\t\t\t\t")])])},function(){var t=this.$createElement,a=this._self._c||t;return a("a",{staticClass:"is-active",attrs:{href:"#"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-table"})]),this._v(" Access Control\n\t\t\t\t\t")])},function(){var t=this.$createElement,a=this._self._c||t;return a("li",[a("a",{attrs:{href:"#"}},[a("span",{staticClass:"icon is-small"},[a("i",{staticClass:"fa fa-link"})]),this._v(" Link2\n\t\t\t\t\t\t\t")])])},function(){var t=this.$createElement,a=this._self._c||t;return a("li",[a("a",{attrs:{href:"#"}},[a("span",{staticClass:"icon"},[a("i",{staticClass:"fa fa-info"})]),this._v(" About\n\t\t\t\t\t")])])}],!1,null,"3cfb1228",null);a.default=e.exports}}]);