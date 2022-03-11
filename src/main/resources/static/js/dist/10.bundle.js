(window.webpackJsonp=window.webpackJsonp||[]).push([[10],{173:function(t,s){function e(t){var s=new Error("Cannot find module '"+t+"'");throw s.code="MODULE_NOT_FOUND",s}e.keys=function(){return[]},e.resolve=e,t.exports=e,e.id=173},199:function(t,s,e){var a=e(204);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);(0,e(27).default)("2c495914",a,!0,{})},201:function(t,s,e){"use strict";var a={mixins:[e(202).a],props:{overflow:{required:!1,default:"initial"},width:{required:!1,default:640},showCloseButton:{type:Boolean,default:!0}},created(){},mounted(){this.openModal(),document.body.classList.add("modal-open")},beforeDestroy(){document.body.classList.remove("modal-open")}},i=(e(203),e(20)),l=Object(i.a)(a,(function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{ref:"modal",staticClass:"modal"},[e("div",{ref:"modalContent",staticClass:"modal-content",style:{"max-width":t.width+"px",overflow:t.overflow}},[e("div",{staticClass:"box"},[t._t("modal-content")],2)]),t._v(" "),t.showCloseButton?[e("button",{staticClass:"modal-close is-large",attrs:{"aria-label":"close"},on:{click:function(s){return s.stopPropagation(),t.closeModal(s)}}})]:t._e()],2)}),[],!1,null,"65f97b4a",null);s.a=l.exports},202:function(t,s,e){"use strict";(function(t){s.a={methods:{closeModal(){t(this.$refs.modalContent).toggleClass("scaleIn"),t(this.$refs.modalClose).toggleClass("is-hidden"),t(".modal.is-active").removeClass("is-active"),this.$emit("modalClosed")},openModal(){t(this.$refs.modal).toggleClass("is-active")}}}}).call(this,e(166))},203:function(t,s,e){"use strict";var a=e(199);e.n(a).a},204:function(t,s,e){(t.exports=e(26)(!1)).push([t.i,".modal[data-v-65f97b4a]{overflow-y:auto;position:fixed;left:0;right:0;top:0;width:100%;height:100%;background-color:rgba(10,10,10,0.86)}.modal .modal-content[data-v-65f97b4a]{overflow:visible}\n",""])},216:function(t,s,e){"use strict";var a=e(167),i=e.n(a),l={props:{clearOnSelect:{default:!1},label:{default:"Employee"},required:{default:!0},showLabel:{default:!0},value:{}},data:()=>({employees:[],loading:!1,isFetching:!1,employeeName:"",page:0,totalPages:0,selectedEmployee:{}}),methods:{showAddEmployee(){},fetchEmployees(t){axios.get("/api/employees",{params:{page:this.page,pageSize:10}}).then(({data:t})=>{t.content.forEach(t=>this.employees.push(t)),this.page++,this.totalPages=t.totalPages,this.isFetching=!1},t=>{this.isFetching=!1})},getAsyncData:i()((function(t){if(this.employeeName!==t&&(this.employeeName=t,this.employees=[],this.page=0,this.totalPages=0),!t.length)return this.employees=[],this.page=0,void(this.totalPages=0);this.page>this.totalPages||(this.isFetching=!0,this.fetchEmployees(t))}),500),getMoreAsyncData:i()((function(){this.getAsyncData(this.employeeName)}),250)},watch:{selectedEmployee:function(t){this.$emit("input",t)},value(t){this.selectedEmployee=t}}},n=e(20),o=Object(n.a)(l,(function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",[e("b-field",[t.showLabel?e("template",{slot:"label"},[t._v("\n            "+t._s(t.label)+" "),t.required?e("span",[e("sup",[t._v("*")])]):t._e()]):t._e(),t._v(" "),e("b-autocomplete",{attrs:{data:t.employees,placeholder:"Select Employee",field:"fullName",loading:t.isFetching,"clear-on-select":t.clearOnSelect,"check-infinite-scroll":!0},on:{typing:t.getAsyncData,select:function(s){return t.selectedEmployee=s},"infinite-scroll":t.getMoreAsyncData},scopedSlots:t._u([{key:"default",fn:function(s){return[e("div",{staticClass:"media"},[e("div",{staticClass:"media-left"}),t._v(" "),e("div",{staticClass:"media-content"},[t._v("\n                        "+t._s(s.option.fullName)+"\n                        "),e("br"),t._v(" "),e("small")])])]}}])},[e("template",{slot:"header"},[e("a",{on:{click:t.showAddEmployee}},[e("span",{staticClass:"has-text-link"},[t._v(" Add new... ")])])]),t._v(" "),t._v(" "),e("template",{slot:"footer"},[e("span",{directives:[{name:"show",rawName:"v-show",value:t.page>t.totalPages,expression:"page > totalPages"}],staticClass:"has-text-grey"},[t._v(" Thats it! No more movies found. ")])])],2),t._v(" "),e("div",{attrs:{slot:"message"},slot:"message"},[t._t("errors")],2)],2)],1)}),[],!1,null,"2da89e11",null);s.a=o.exports},252:function(t,s,e){"use strict";(function(t){var a=e(183),i=e.n(a),l=e(336);s.a={components:{ProjectMembersCard:l.a},data:()=>({project:{},loaded:!1,showAddMemberModal:!1}),mounted(){this.getProjectDetails()},methods:{getProjectDetails(){let t=this,s=this.$route.params.id;axios.get("/api/projects/details/"+s).then(s=>{this.project=s.data,this.loaded=!0;new i.a({el:t.$refs.projectDescription,height:"600px",initialValue:t.project.description})},t=>{})}},filters:{formatDate(s){if(s)return t(s).format("DD MMM YYYY")}}}}).call(this,e(172))},336:function(t,s,e){"use strict";e(170),e(73);var a=e(171),i=e.n(a),l=e(201),n=e(216),o={mixins:[e(37).a],props:{projectId:{required:!0}},components:{ModalTemplate:l.a,ProjectMemberSelectInput:n.a},data:()=>({isLoading:!1,member:"",projectMembers:[]}),methods:{addProjectMember(t){if(t){this.projectMembers.find(s=>s.id==t.id)||(this.projectMembers.push(t),this.clearFieldError("teamMembers"))}},submitMembers(){let t=this.projectMembers.map(t=>t.id);axios.post("/api/projects/team-members/"+this.projectId,{teamMembers:t}).then(t=>{i.a.success(t.data)},t=>{400==t.response.status&&(this.errors=t.response.data)})}}},r=e(20),c={components:{ProjectAddMemberModal:Object(r.a)(o,(function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("ModalTemplate",{on:{modalClosed:function(s){return t.$emit("modalClosed")}}},[e("div",{attrs:{slot:"modal-content"},slot:"modal-content"},[e("h4",{staticClass:"title is-4 text-center"},[t._v("Assign the user to this project")]),t._v(" "),e("div",[e("form",[e("ProjectMemberSelectInput",{attrs:{"clear-on-select":!0,"show-label":!1},on:{input:t.addProjectMember},model:{value:t.member,callback:function(s){t.member=s},expression:"member"}},[t.errors.teamMembers?e("span",{staticClass:"mb-2 has-text-danger help",attrs:{slot:"errors"},slot:"errors"},[t._v("\n                                "+t._s(t.errors.teamMembers[0])+"\n                     ")]):t._e()]),t._v(" "),e("div",{staticClass:"mt-3"},t._l(t.projectMembers,(function(s){return e("div",{staticClass:"card divide-none"},[e("div",{staticClass:"card-content p-2"},[e("article",{staticClass:"media"},[e("figure",{staticClass:"media-left"},[e("p",{staticClass:"image is-32x32"},[e("img",{staticClass:"is-rounded",attrs:{src:"https://bulma.io/images/placeholders/128x128.png"}})])]),t._v(" "),e("div",{staticClass:"media-content"},[e("div",{staticClass:"content"},[e("p",[e("strong",[t._v(t._s(s.fullName))]),t._v(" "),e("small",[t._v("@johnsmith")]),t._v(" "),e("small",[t._v("31m")])])])]),t._v(" "),e("div",{staticClass:"media-right"},[e("button",{staticClass:"delete",attrs:{type:"button"}})])])])])})),0),t._v(" "),e("div",{staticClass:"flex justify-center m-3"},[e("button",{staticClass:"button  is-rounded",class:{"is-loading":t.isLoading},attrs:{disabled:t.isLoading,type:"submit"},on:{click:function(s){return s.preventDefault(),s.stopPropagation(),t.submitMembers()}}},[t._v("Add Members\n                    ")])])],1)])])])}),[],!1,null,null,null).exports},props:{projectId:{required:!0}},data:()=>({projectMembers:[],showAddMemberModal:!1}),created(){this.getProjectMembers()},methods:{getProjectMembers(){axios.get("/api/projects/team-members/"+this.projectId,{params:{page:0,pageSize:5}}).then(t=>{this.projectMembers=t.data.content},t=>{})}}},d=Object(r.a)(c,(function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"card mt-4"},[e("div",{staticClass:"card-content"},[e("div",{staticClass:"flex"},[e("h4",{staticClass:"font-black flex-1"},[t._v("\n                Assigned users\n            ")]),t._v(" "),e("div",[e("button",{staticClass:"button is-small is-primary",on:{click:function(s){t.showAddMemberModal=!0}}},[e("i",{staticClass:"fa fa-plus"})])])]),t._v(" "),t._l(t.projectMembers,(function(s){return e("div",{staticClass:"mt-3"},[e("div",{staticClass:"flex content-center"},[t._m(0,!0),t._v(" "),e("div",{staticClass:"pl-1"},[e("div",{staticClass:"font-semibold"},[t._v("\n                        "+t._s(s.fullName)+"\n                    ")]),t._v(" "),e("div",{staticClass:"font-medium"},[t._v("\n                        "+t._s(s.designation)+"\n                    ")])])])])}))],2),t._v(" "),t.showAddMemberModal?e("ProjectAddMemberModal",{attrs:{"project-id":t.projectId},on:{modalClosed:function(s){t.showAddMemberModal=!1}}}):t._e()],1)}),[function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"flex items-center"},[s("figure",{staticClass:"image is-32x32"},[s("img",{staticClass:"is-rounded",attrs:{src:"https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg",alt:""}})])])}],!1,null,null,null);s.a=d.exports},441:function(t,s,e){"use strict";e.r(s);var a=e(252).a,i=e(20),l=Object(i.a)(a,(function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",[e("div",{staticClass:"columns"},[e("div",{staticClass:"column is-9"},[e("div",{staticClass:"card"},[e("div",{staticClass:"card-content"},[e("h4",{staticClass:"font-black"},[t._v(t._s(t.project.name))]),t._v(" "),e("p",[t._v(" "+t._s(t.project.openTasks||0)+" open tasks, "+t._s(t.project.completedTasks||0)+" tasks completed")]),t._v(" "),e("div",{ref:"projectDescription"})])]),t._v(" "),e("div",{staticClass:"card mt-4"},[e("div",{staticClass:"card-content"},[e("h4",{staticClass:"title is-4"},[t._v("Uploaded image files")]),t._v(" "),e("div",{staticClass:"columns"},t._l(4,(function(s){return e("div",{staticClass:"column"},[t._m(0,!0)])})),0)])]),t._v(" "),e("div",{staticClass:"card mt-4"},[e("div",{staticClass:"card-content"},[e("h4",{staticClass:"title is-4"},[t._v("Uploaded files")]),t._v(" "),t._l(2,(function(s){return e("article",{staticClass:"media"},[t._m(1,!0),t._v(" "),t._m(2,!0),t._v(" "),t._m(3,!0)])}))],2)]),t._v(" "),t._m(4),t._v(" "),e("div",{staticClass:"mt-3"},t._l(6,(function(s){return e("div",{staticClass:"card"},[t._m(5,!0)])})),0)]),t._v(" "),e("div",{staticClass:"column is-3"},[e("div",{staticClass:"card"},[e("div",{staticClass:"card-content"},[e("h2",{staticClass:"font-black"},[t._v("Project details")]),t._v(" "),e("table",{staticClass:"table is-striped is-hoverable is-fullwidth"},[e("tbody",[t._m(6),t._v(" "),e("tr",[e("td",[t._v("\n                                Total Hours:\n                            ")]),t._v(" "),e("td",[t._v("\n                                "+t._s(t.project.totalHours)+" Hours\n                            ")])]),t._v(" "),e("tr",[e("td",[t._v("\n                                Created:\n                            ")]),t._v(" "),e("td",[t._v("\n                                "+t._s(t._f("formatDate")(t.project.createdAt))+"\n                            ")])]),t._v(" "),e("tr",[e("td",[t._v("\n                                Deadline:\n                            ")]),t._v(" "),e("td",[t._v("\n                                "+t._s(t._f("formatDate")(t.project.endDate))+"\n                            ")])]),t._v(" "),t._m(7),t._v(" "),t._m(8),t._v(" "),t._m(9)])]),t._v(" "),t._m(10)])]),t._v(" "),e("div",{staticClass:"card mt-4"},[e("div",{staticClass:"card-content"},[e("h4",{staticClass:"font-black"},[t._v("\n                        Assigned Leader\n                    ")]),t._v(" "),e("div",{staticClass:"mt-3"},[e("div",{staticClass:"flex content-center"},[t._m(11),t._v(" "),e("div",{staticClass:"pl-1"},[e("div",{staticClass:"font-semibold"},[t._v("\n                                    "+t._s(t.project.leadFullName)+"\n                                ")]),t._v(" "),e("div",{staticClass:"font-medium"},[t._v("\n                                    "+t._s(t.project.leadDesignation)+"\n                                ")])])])])])]),t._v(" "),e("ProjectMembersCard",{attrs:{"project-id":t.$route.params.id}}),t._v(" "),e("div",{staticClass:"card mt-4"},[e("div",{staticClass:"card-content"},[t._m(12),t._v(" "),t._m(13),t._v(" "),e("div",{staticClass:"flex justify-center"},[e("h4",{staticClass:"title is-4"},[t._v(t._s(t.project.clientFullName))])]),t._v(" "),t._m(14),t._v(" "),t._m(15)])])],1)])])}),[function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"card"},[s("div",{staticClass:"card-image"},[s("figure",{staticClass:"image m-1 is-4by3"},[s("img",{attrs:{src:"https://bulma.io/images/placeholders/1280x960.png",alt:"Placeholder image"}})])]),this._v(" "),s("div",{staticClass:"card-content"},[s("div",{staticClass:"media"},[s("div",{staticClass:"media-content"},[s("p",{staticClass:"title is-6"},[this._v("demo.png")])])])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("figure",{staticClass:"media-left"},[s("p",{staticClass:"image is-64x64"},[s("img",{attrs:{src:"https://bulma.io/images/placeholders/128x128.png"}})])])},function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"media-content"},[s("div",{staticClass:"content"},[s("p",[s("strong",[this._v("John Smith")]),this._v(" "),s("small",[this._v("@johnsmith")]),this._v(" "),s("small",[this._v("31m")]),this._v(" "),s("br"),this._v("\n                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ornare magna\n                                    eros, eu pellentesque tortor vestibulum ut. Maecenas non massa sem. Etiam\n                                    finibus odio quis feugiat facilisis.\n                                ")])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"media-right"},[s("button",{staticClass:"delete"})])},function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"tabs is-fullwidth mt-3"},[s("ul",[s("li",{staticClass:"is-active"},[s("a",[this._v("All Tasks")])]),this._v(" "),s("li",[s("a",[this._v("Pending Tasks")])]),this._v(" "),s("li",[s("a",[this._v("Completed Tasks")])])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"card-content pt-2 pb-2"},[s("article",{staticClass:"media"},[s("div",{staticClass:"media-left"},[s("i",{staticClass:"fa fa-check-circle"})]),this._v(" "),s("div",{staticClass:"media-content"},[s("div",{staticClass:"content"},[this._v("\n                                    Patient appointment booking\n                                ")])]),this._v(" "),s("div",{staticClass:"media-right"},[s("i",{staticClass:"fa fa-user-plus"}),this._v(" "),s("i",{staticClass:"fa fa-trash"})])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("tr",[s("td",[this._v("\n                                Cost:\n                            ")]),this._v(" "),s("td",{staticClass:"text-right"},[this._v("\n                                $1200\n                            ")])])},function(){var t=this.$createElement,s=this._self._c||t;return s("tr",[s("td",[this._v("\n                                Priority:\n                            ")]),this._v(" "),s("td",[s("span",{staticClass:"tag is-danger is-light"},[this._v("Danger")])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("tr",[s("td",[this._v("\n                                Created By:\n                            ")]),this._v(" "),s("td",[this._v("\n                                Emmanuel Ogoma\n                            ")])])},function(){var t=this.$createElement,s=this._self._c||t;return s("tr",[s("td",[this._v("\n                                Status:\n                            ")]),this._v(" "),s("td",[this._v("\n                                Working\n                            ")])])},function(){var t=this.$createElement,s=this._self._c||t;return s("div",[s("div",{staticClass:"mt-2"},[s("h4",{staticClass:"text-black font-medium text-lg font-semibold"},[this._v("Progress:")]),this._v(" "),s("progress",{staticClass:"progress is-small is-success",attrs:{value:"15",max:"100"}},[this._v("15%")])])])},function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"flex items-center"},[s("figure",{staticClass:"image is-32x32"},[s("img",{staticClass:"is-rounded",attrs:{src:"https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg",alt:""}})])])},function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"flex"},[s("h4",{staticClass:"font-black flex-1"},[this._v("\n                            About Client\n                        ")])])},function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"flex mt-3 justify-center"},[s("figure",{staticClass:"image is-128x128"},[s("img",{staticClass:"is-rounded",attrs:{src:"https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg",alt:"Placeholder image"}})])])},function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"flex justify-center"},[s("h4",{staticClass:"subtitle is-7"},[this._v("Washington, d.c.")])])},function(){var t=this.$createElement,s=this._self._c||t;return s("div",{staticClass:"flex mt-2 justify-center"},[s("div",{},[s("button",{staticClass:"button is-size-7 mr-1 text-black text-sm font-semibold"},[this._v("Message")])]),this._v(" "),s("div",{},[s("button",{staticClass:"button is-size-7 ml-1 text-black text-sm font-semibold"},[this._v("View Profile\n                            ")])])])}],!1,null,"672ed687",null);s.default=l.exports}}]);