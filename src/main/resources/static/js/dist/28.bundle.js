(window.webpackJsonp=window.webpackJsonp||[]).push([[28],{177:function(s,t,i){"use strict";i.r(t);var e={data:()=>({isLoading:!1,users:[],columns:[{field:"id",label:"ID",width:"40",numeric:!0},{field:"firstName",label:"First Name"},{field:"lastName",label:"Last Name"},{field:"email",label:"Email"}]}),created(){this.getUsers()},methods:{getUsers(){let s=this;this.isLoading=!0,axios.get("/api/users").then(t=>{s.isLoading=!1,s.users=t.data},t=>{s.isLoading=!1})},exportReport(){this.$downLoadFile({requestMethod:"Get",endPoint:"/api/users/reports"})}}},a=i(2),l=Object(a.a)(e,function(){var s=this.$createElement,t=this._self._c||s;return t("div",{staticClass:"container"},[t("div",{staticClass:"flex pb-2 justify-end",on:{click:this.exportReport}},[this._m(0)]),this._v(" "),t("b-table",{staticClass:"is-size-7",attrs:{loading:this.isLoading,data:this.users,columns:this.columns}})],1)},[function(){var s=this.$createElement,t=this._self._c||s;return t("button",{staticClass:"button is-rounded is-small"},[t("span",{staticClass:"icon"},[t("i",{staticClass:"fa fa-download"})]),this._v(" "),t("span",[this._v(" Export")])])}],!1,null,null,null);t.default=l.exports}}]);