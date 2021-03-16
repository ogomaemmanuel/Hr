(window.webpackJsonp=window.webpackJsonp||[]).push([[30],{206:function(t,s,e){"use strict";s.a={data:()=>({pageable:!1,pageSize:10,page:0}),methods:{goToPrevious(){this.page--,this.fetchRecords()},goToNext(){this.page++,this.fetchRecords()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.fetchRecords()}}}},249:function(t,s,e){var a=e(306);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,e(27).default)("88d039d0",a,!0,{})},250:function(t,s,e){var a=e(308);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,e(27).default)("69d4cea9",a,!0,{})},305:function(t,s,e){"use strict";var a=e(249);e.n(a).a},306:function(t,s,e){(t.exports=e(26)(!1)).push([t.i,".profile-action[data-v-6ac04dd5]{position:absolute;right:5px;text-align:right;top:10px;top:0px;right:5px}\n",""])},307:function(t,s,e){"use strict";var a=e(250);e.n(a).a},308:function(t,s,e){(t.exports=e(26)(!1)).push([t.i,".projects-wrapper[data-v-3546f013]{grid-auto-rows:1fr}\n",""])},325:function(t,s,e){"use strict";e.r(s);e(170),e(73);var a=e(171),i=e.n(a),c=(e(194),e(195)),o=e.n(c),r=e(184),l=e.n(r),n={components:{Avatar:o.a},props:{project:{required:!0}},mounted(){new l.a({el:this.$refs.projectDescription,height:"600px",initialValue:this.project.description})},methods:{confirmRemoveProject(t){this.$buefy.dialog.confirm({title:"Delete Project",message:`Are you sure want to delete <b> ${t.name}</b>`,onConfirm:()=>this.removeProject(t)})},removeProject(t){axios.delete("/api/projects/"+t.id).then(s=>{i.a.success("Project Successfully removed"),this.$emit("deleteSuccessful",t)},t=>{})}}},p=(e(305),e(20)),d=Object(p.a)(n,(function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"card min-h-full"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"flex flex-col"},[e("div",{staticClass:"relative"},[e("h4",{staticClass:"text-black font-medium text-lg font-semibold"},[e("router-link",{attrs:{to:"/project-details/"+t.project.id}},[t._v(t._s(t.project.name))])],1),t._v(" "),t._m(0),t._v(" "),e("div",{staticClass:"profile-action"},[e("b-dropdown",{staticClass:"text-left",attrs:{"aria-role":"list"}},[e("i",{staticClass:"fa fa-ellipsis-v text-muted",attrs:{slot:"trigger",role:"button"},slot:"trigger"}),t._v(" "),e("b-dropdown-item",{attrs:{disabled:!1,value:"withdraw","aria-role":"listitem"},on:{click:function(s){return t.confirmRemoveProject(t.project)}}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-trash"})]),t._v("\n                            Remove\n                        ")]),t._v(" "),e("b-dropdown-item",{attrs:{disabled:!1,value:"edit","aria-role":"listitem"}},[e("router-link",{attrs:{to:"/project-edit/"+t.project.id}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-pencil"})]),t._v("\n                                Edit\n                            ")])],1)],1)],1)]),t._v(" "),e("div",[e("div",{ref:"projectDescription"})]),t._v(" "),e("div",{staticClass:"mt-2"},[e("h4",{staticClass:"text-black font-medium text-lg font-semibold"},[t._v("Deadline:")]),t._v(" "),e("div",[e("span",[t._v(t._s(t.project.endDate))])])]),t._v(" "),e("div",{staticClass:"mt-2"},[e("h4",{staticClass:"text-black font-medium text-lg font-semibold"},[t._v("\n                    Project Leader:")]),t._v(" "),e("div",[e("Avatar",{attrs:{size:"small",src:"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"}})],1)]),t._v(" "),e("div",{staticClass:"mt-2"},[e("h4",{staticClass:"text-black font-medium text-lg font-semibold"},[t._v("\n                    Team:")]),t._v(" "),e("div",[e("Avatar",{attrs:{size:"small",src:"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"}}),t._v(" "),e("Avatar",{attrs:{size:"small",src:"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"}}),t._v(" "),e("Avatar",{attrs:{size:"small",src:"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"}}),t._v(" "),e("Avatar",{attrs:{size:"small",src:"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"}}),t._v(" "),e("Avatar",{attrs:{size:"small",src:"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"}})],1)]),t._v(" "),t._m(1)])])])}),[function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"text-xs font-normal"},[s("span",{staticClass:"font-bold"},[this._v("2")]),this._v(" "),s("span",[this._v("open tasks")]),this._v(" "),s("span",{staticClass:"font-bold"},[this._v("5")]),this._v(" "),s("span",[this._v("tasks completed")])])},function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"mt-2"},[s("h4",{staticClass:"text-black font-medium text-lg font-semibold"},[this._v("Progress:")]),this._v(" "),s("progress",{staticClass:"progress is-small is-success",attrs:{value:"15",max:"100"}},[this._v("15%")])])}],!1,null,"6ac04dd5",null).exports,u=(e(206),{components:{ProjectCard:d},data:()=>({projects:[],pageable:!1,pageSize:10,page:0}),created(){this.getProjects()},methods:{getProjects(){let t=this;axios.get("/api/projects",{params:{page:this.page,pageSize:this.pageSize}}).then(s=>{t.loading=!1,this.projects=s.data.content,this.pageable=s.data})}}}),v=(e(307),{components:{ProjectsCardList:Object(p.a)(u,(function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"grid auto-rows-auto  gap-5 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 projects-wrapper"},t._l(t.projects,(function(s){return e("div",{staticClass:"min-h-full"},[e("ProjectCard",{attrs:{project:s},on:{deleteSuccessful:t.getProjects}})],1)})),0)}),[],!1,null,"3546f013",null).exports},data:()=>({})}),m=Object(p.a)(v,(function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",[e("div",{staticClass:"pb-2 flex justify-end"},[e("portal",{attrs:{to:"page-controls"}},[e("button",[e("p",{staticClass:"buttons"},[e("button",{staticClass:"button",on:{click:function(s){t.showTableList=!1}}},[e("span",{staticClass:"icon is-small"},[e("i",{staticClass:"fa fa-bars"})])]),t._v(" "),e("button",{staticClass:"button",on:{click:function(s){t.showTableList=!0}}},[e("span",{staticClass:"icon is-small"},[e("i",{staticClass:"fa fa-th"})])]),t._v(" "),e("router-link",{staticClass:"button mr-1 is-rounded",attrs:{to:"/projects-create",tag:"button"}},[e("span",{staticClass:"icon"},[e("i",{staticClass:"fa fa-plus-circle mr-1"})]),t._v(" "),e("span",[t._v("\n\t\t\t\t\t Create Project\n\t\t\t\t")])])],1)])])],1),t._v(" "),e("ProjectsCardList"),t._v(" "),e("router-view")],1)}),[],!1,null,null,null);s.default=m.exports}}]);