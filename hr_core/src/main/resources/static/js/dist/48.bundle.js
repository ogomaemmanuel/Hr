(window.webpackJsonp=window.webpackJsonp||[]).push([[48],{369:function(t,s,a){"use strict";s.a={data:()=>({pageable:!1,pageSize:10,page:0}),methods:{goToPrevious(){this.page--,this.fetchRecords()},goToNext(){this.page++,this.fetchRecords()},onPaginationChanged(t){this.page=0,this.pageSize=t,this.fetchRecords()}}}},455:function(t,s,a){var e=a(547);e.__esModule&&(e=e.default),"string"==typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);(0,a(22).default)("42e0d6f7",e,!1,{})},456:function(t,s,a){var e=a(549);e.__esModule&&(e=e.default),"string"==typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);(0,a(22).default)("3fdbd5b0",e,!1,{})},546:function(t,s,a){"use strict";a(455)},547:function(t,s,a){(t.exports=a(21)(!1)).push([t.i,".project-details p[data-v-421b3ca6]{display:flex;justify-content:flex-start;position:relative;font-size:15px;color:#b7c0cd;height:auto;transition:all .2s ease;padding:8px 15px}.project-details p[data-v-421b3ca6]:hover{color:#fff}.project-details p[data-v-421b3ca6]:active{background-color:rgba(0,0,0,.2)}",""])},548:function(t,s,a){"use strict";a(456)},549:function(t,s,a){(t.exports=a(21)(!1)).push([t.i,".task-page[data-v-19a271b4]{margin-top:3.25rem;min-height:100%}.task-page .project-list[data-v-19a271b4]{background-color:#34444c;min-height:100%}.task-page .project-details[data-v-19a271b4]{position:relative}.task-page .project-details .project-details-footer[data-v-19a271b4]{position:absolute;bottom:0px;left:0px;right:0px}.task-page .task-list-item-container[data-v-19a271b4]:first-child{border-bottom:none}.task-page .task-list-item-container .task-list-item[data-v-19a271b4]{border:1px solid #eaeaea}.task-page .task-list-item-container .task-list-item .action-icons[data-v-19a271b4]{display:none}.task-page .task-list-item-container .task-list-item:hover .action-icons[data-v-19a271b4]{display:flex}",""])},626:function(t,s,a){"use strict";a.r(s);var e=function(){var t=this,s=t._self._c;return s("div",{staticClass:"task-page h-full columns is-gapless"},[s("div",{staticClass:"project-list column is-one-fifth"},[s("ProjectList",{key:t.currentProject.id,on:{projectSelected:t.setCurrentProject}})],1),t._v(" "),s("div",{staticClass:"project-task-list column"},[s("div",{staticClass:"task-list-header pl-5 pr-5 pb-3 pt-3 bg-white flex items-center"},[s("div",{staticClass:"flex-1"},[s("button",{staticClass:"button",on:{click:function(s){t.showAddTaskInput=!t.showAddTaskInput}}},[t._v("Add task")])]),t._v(" "),t._m(0)]),t._v(" "),s("div",{staticClass:"p-5"},[s("div",{staticClass:"task-list-item-container"},t._l(t.tasks,(function(a,e){return s("div",{key:e,staticClass:"task-list-item bg-white mt-0 p-2 flex"},[s("div",{staticClass:"flex flex-1 items-center"},[t._m(1,!0),t._v(" "),s("div",{staticClass:"ml-1"},[t._v("\n              "+t._s(a.title)+"\n            ")])]),t._v(" "),s("div",{staticClass:"flex action-icons items-center justify-end gap-1"},[s("i",{staticClass:"fa fa-user-plus fa-2x"}),t._v(" "),s("i",{staticClass:"fa fa-trash fa-2x",on:{click:function(s){return t.deleteTask(a)}}})])])})),0),t._v(" "),t.showAddTaskInput?s("div",[s("input",{directives:[{name:"model",rawName:"v-model",value:t.taskCreateRequest.title,expression:"taskCreateRequest.title"}],staticClass:"input",attrs:{placeholder:"Enter new task here ...",type:"text"},domProps:{value:t.taskCreateRequest.title},on:{input:function(s){s.target.composing||t.$set(t.taskCreateRequest,"title",s.target.value)}}}),t._v(" "),s("div",{staticClass:"flex justify-end mt-3 gap-1"},[s("button",{staticClass:"button is-light",on:{click:function(s){t.showAddTaskInput=!t.showAddTaskInput}}},[t._v("Close")]),t._v(" "),s("button",{staticClass:"button",on:{click:t.createTask}},[t._v("\n            Add Task\n          ")])])]):t._e()])]),t._v(" "),t._m(2)])};e._withStripped=!0;var i=a(334),o=a.n(i),c=(a(341),function(){var t=this,s=t._self._c;return s("div",[s("ul",t._l(t.projects,(function(a){return s("li",{staticClass:"project-details",on:{click:function(s){return t.onProjectClicked(a)}}},[s("p",[t._v(t._s(a.name))])])})),0)])});c._withStripped=!0;var r={mixins:[a(369).a],data:()=>({projects:[]}),created(){this.getProjects()},methods:{async getProjects(){let t=await axios.get("/api/projects",{params:{page:this.page,pageSize:this.pageSize}});this.projects=t.data.content},onProjectClicked(t){console.log("onProjectClicked"),this.$emit("projectSelected",t)}}},l=(a(546),a(15)),n={components:{ProjectList:Object(l.a)(r,c,[],!1,null,"421b3ca6",null).exports},data:()=>({page:0,pageSize:10,projects:[],loading:!1,loaded:!1,showAddTaskInput:!1,taskCreateRequest:{},currentProject:{},tasks:[]}),watch:{currentProject(){this.getTasks()}},methods:{getTasks(){let t=this,s={active:!0,projectId:t.currentProject.id};t.loading=!0,axios.get("/api/tasks",{params:s}).then(s=>{t.loaded=!0,t.loading=!1,t.tasks=s.data},s=>{t.loading=!1})},async createTask(){this.taskCreateRequest.projectId=this.currentProject.id;let t=await axios.post("/api/tasks",this.taskCreateRequest);this.tasks=[].concat(o()(this.tasks),[t.data]),this.taskCreateRequest={}},async deleteTask(t){await axios.delete("/api/tasks/"+t.id),this.getTasks()},setCurrentProject(t){this.currentProject=t}}},p=(a(548),Object(l.a)(n,e,[function(){var t=this._self._c;return t("div",[t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-cog fa-2x"})])])},function(){var t=this._self._c;return t("div",{staticClass:"gap-1"},[t("i",{staticClass:"fa fa-check-circle fa-2x"})])},function(){var t=this,s=t._self._c;return s("div",{staticClass:"project-details column bg-white"},[s("div",{staticClass:"project-details-header border-solid border-b border-slate-200 pr-5 pl-5 pb-4 pt-4 flex items-center"},[s("div",{staticClass:"flex-1"},[s("button",{staticClass:"button"},[s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-check"})]),t._v(" "),s("span",[t._v("Mark Complete")])])]),t._v(" "),s("span",{staticClass:"icon"},[s("i",{staticClass:"fa fa-ellipsis-v"})])]),t._v(" "),s("div",{staticClass:"project-details-body pl-5 pr-5 pt-3"},[s("h2",[t._v("Hospital Administration Phase 1")])]),t._v(" "),s("div",{staticClass:"project-details-footer border-t border-slate-200 pr-5 pl-5 pb-4 pt-4"},[s("div",[s("input",{staticClass:"input",attrs:{placeholder:"Type message...",type:"text"}})]),t._v(" "),s("div",{staticClass:"flex justify-start items-center mt-3 gap-2"},[s("span",[t._v("Followers")]),t._v(" "),s("figure",{staticClass:"image is-32x32"},[s("img",{attrs:{src:"/images/undraw_profile_pic_ic-5-t.svg"}})]),t._v(" "),s("figure",{staticClass:"image is-32x32"},[s("img",{attrs:{src:"/images/undraw_profile_pic_ic-5-t.svg"}})]),t._v(" "),s("figure",{staticClass:"image is-32x32"},[s("img",{attrs:{src:"/images/undraw_profile_pic_ic-5-t.svg"}})])])])])}],!1,null,"19a271b4",null));s.default=p.exports}}]);