(window.webpackJsonp=window.webpackJsonp||[]).push([[79],{253:function(t,a,e){var s=e(321);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);(0,e(27).default)("276f6647",s,!0,{})},320:function(t,a,e){"use strict";var s=e(253);e.n(s).a},321:function(t,a,e){(t.exports=e(26)(!1)).push([t.i,".project-menu-head[data-v-0cbaca84]{border-radius:2px;padding:0.5em 0.2em}.project-menu-head .menu-header-text[data-v-0cbaca84]{padding-left:0.5em}.project-menu-head[data-v-0cbaca84]:hover{border-left:4px solid;background-color:#000000;border-left:4px solid #1d8e72;color:#FFFFFF}\n",""])},413:function(t,a,e){"use strict";e.r(a);var s=e(182),l=e.n(s),i=e(184),o={data:()=>({page:0,pageSize:10,projects:[],loading:!1,loaded:!1}),created(){this.getProjects()},methods:{getProjects(){let t=this,a={page:t.page,pageSize:t.pageSize};t.loading=!0,axios.get("/api/projects",{params:a}).then(a=>{var e;t.loaded=!0,t.loading=!1,(e=t.projects).push.apply(e,l()(a.data.content)),a.data.totalPages>t.page&&t.page++},a=>{t.loading=!1})},fetchMoreProjects:e.n(i)()((function(t){let a=this;t.deltaY>0&&a.getProjects()}),2e3)}},c=(e(320),e(20)),r=Object(c.a)(o,(function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"h-full"},[t._m(0),t._v(" "),e("portal",{attrs:{to:"side-menu"}},[e("ul",{staticClass:"menu-list"},[e("li",[e("router-link",{attrs:{to:"/"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-home"})]),t._v(" Back Home\n                    ")])],1),t._v(" "),e("li",{on:{wheel:t.fetchMoreProjects}},[e("div",{staticClass:"flex project-menu-head"},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-group"})]),t._v(" "),e("div",{staticClass:"flex w-full"},[e("div",{staticClass:"flex-1 menu-header-text"},[t._v("Projects")]),t._v(" "),e("i",{staticClass:"fa fa-plus mr-1"})])]),t._v(" "),e("ul",{staticClass:"mr-0 pr-0 border-l-0"},t._l(t.projects,(function(a){return e("li",[e("router-link",{attrs:{to:"/users"}},[e("span",[t._v(t._s(a.name))])])],1)})),0)])])])],1)}),[function(){var t=this.$createElement,a=this._self._c||t;return a("div",{staticClass:"h-full"},[a("div",{staticClass:"columns h-full"},[a("div",{staticClass:"column"},[a("div",{staticClass:"bg-white h-12 w-full"})]),this._v(" "),a("div",{staticClass:"column h-full bg-white"})])])}],!1,null,"0cbaca84",null);a.default=r.exports}}]);