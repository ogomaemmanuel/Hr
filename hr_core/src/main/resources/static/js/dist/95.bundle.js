(window.webpackJsonp=window.webpackJsonp||[]).push([[95,121],{469:function(s,t,i){"use strict";i.r(t);var e=function(){var s=this._self._c;return s("div",[this.loaded?s("div",{domProps:{innerHTML:this._s(this.payslip)}}):s("PayslipSkeleton")],1)};e._withStripped=!0;var a=function(){var s=this._self._c;return s("div",[s("div",{staticClass:"card"},[s("div",{staticClass:"card-content"},[s("div",{staticClass:"mb-8 text-center underline uppercase"},[s("b-skeleton",{attrs:{size:"is-large"}})],1),this._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column is-4 m-b-20"},[s("p",{staticClass:"image is-64x64 mb-4"},[s("b-skeleton",{attrs:{circle:"",width:"64px",height:"64px"}})],1),this._v(" "),s("b-skeleton",{attrs:{size:"is-large"}})],1),this._v(" "),s("div",{staticClass:"column is-4 is-offset-4 m-b-20"},[s("div",{staticClass:"flex sm:items-start lg:items-end flex-col"},[s("b-skeleton",{attrs:{size:"is-large"}})],1)])]),this._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column is-4 m-b-20"},[s("b-skeleton",{attrs:{size:"is-large"}})],1)]),this._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column is-6"},[s("b-skeleton",{attrs:{size:"is-large"}})],1),this._v(" "),s("div",{staticClass:"column is-6"},[s("b-skeleton",{attrs:{size:"is-large"}})],1)]),this._v(" "),s("div",{staticClass:"columns"},[s("div",{staticClass:"column is-12"},[s("b-skeleton",{attrs:{size:"is-large"}})],1)])])])])};a._withStripped=!0;var l={},n=i(15),d={props:{employeeId:{required:!1}},components:{PayslipSkeleton:Object(n.a)(l,a,[],!1,null,"9150017a",null).exports},data:()=>({payslip:"",loading:!1,loaded:!1}),created(){this.getPayslip()},methods:{getPayslip(){this.loading=!0;let s=this.employeeId?"/api/payslip/"+this.employeeId:"/api/payslip/me";axios.get(s).then(s=>{this.loading=!1,this.loaded=!0,this.payslip=s.data})}}},o=Object(n.a)(d,e,[],!1,null,"537f8378",null);t.default=o.exports},650:function(s,t,i){"use strict";i.r(t);var e=function(){return(0,this._self._c)("PaySlip",{attrs:{employeeId:this.id}})};e._withStripped=!0;var a={components:{PaySlip:i(469).default},data:()=>({id:null}),created(){this.id=this.$route.params.id}},l=i(15),n=Object(l.a)(a,e,[],!1,null,"16143bfe",null);t.default=n.exports}}]);