(window.webpackJsonp=window.webpackJsonp||[]).push([[2],{71:function(s,t,e){"use strict";e.r(t);var i={data:()=>({isLoading:!1,users:[],columns:[{field:"id",label:"ID",width:"40",numeric:!0},{field:"firstName",label:"First Name"},{field:"lastName",label:"Last Name"}]}),created(){this.getUsers()},methods:{getUsers(){let s=this;this.isLoading=!0,axios.get("/api/users").then(t=>{s.isLoading=!1,s.users=t.data},t=>{s.isLoading=!1})},exportReport(){this.$downLoadFile({requestMethod:"Get",endPoint:"/api/users/reports"})}}},a=e(2),l=Object(a.a)(i,function(){var s=this.$createElement,t=this._self._c||s;return t("div",{staticClass:"container is-fluid"},[t("div",{staticClass:"mt-2",on:{click:this.exportReport}},[t("i",{staticClass:"fa fa-download"}),this._v(" Export\n\t")]),this._v(" "),t("b-table",{attrs:{loading:this.isLoading,data:this.users,columns:this.columns}})],1)},[],!1,null,null,null);t.default=l.exports}}]);