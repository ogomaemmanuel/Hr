(window.webpackJsonp=window.webpackJsonp||[]).push([[124],{615:function(t,a,s){"use strict";s.r(a);var e=function(){var t=this._self._c;return t("div",[t("h2",[this._v("Task Board")]),this._v(" "),t("div",{staticClass:"flex justify-start gap-5"},this._l(this.boardStatuses,(function(a,s){return t("TaskBoardCard",{key:s,attrs:{"project-id":1,status:a}})})),1)])};e._withStripped=!0;var n=function(){var t=this,a=t._self._c;return a("div",{staticClass:"flex-1 bg-white p-5"},[a("div",{staticClass:"text-center"},[a("h2",[t._v(t._s(t.status.name))])]),t._v(" "),a("draggable",{staticClass:"draggable-list",attrs:{list:t.tasks,group:"task-group"},on:{change:t.onChangeHandler}},t._l(t.tasks,(function(s){return a("div",{key:s.id,staticClass:"list-item"},[t._v("\n      "+t._s(s.name)+"\n    ")])})),0)],1)};n._withStripped=!0;var i=s(334),r=s.n(i),d=s(357),o={components:{draggable:s.n(d).a},props:{projectId:{required:!0},status:{required:!0,type:Object}},data:()=>({tasks:[{name:"Buy a car"}]}),created(){this.getTasks()},methods:{onChangeHandler(t){console.log("onChangeHandler",t),t.added&&(this.tasks=[].concat(r()(this.tasks),r()(t.added.element)),console.log()),t.removed&&(this.tasks=this.tasks.filter(a=>a.id!=t.added.element.id))},async updateTask(t){await axios.put("api/tasks",t)},async getTasks(){try{await axios.get("/api/tasks",{params:{projectId:this.projectId,status:this.status}})}catch(t){console.log("Error fetching tasks")}}}},l=s(15),c={components:{TaskBoardCard:Object(l.a)(o,n,[],!1,null,null,null).exports},data:()=>({boardStatuses:[{name:"TODO",id:1},{name:"IN PROGRESS",id:2},{name:"DONE",id:3},{name:"COMPLETE",id:4}]})},u=Object(l.a)(c,e,[],!1,null,null,null);a.default=u.exports}}]);