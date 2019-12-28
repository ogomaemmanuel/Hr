import Vue from "vue"
import Router from "vue-router"

const AuthLayout= () =>
    import ("../components/auth/AuthLayout.vue");
const Login = () =>
    import ("../components/auth/Login.vue");
const Home= () =>
    import ("../components/home/Home");
const ForgotPassword = () =>
    import ("../components/auth/ForgotPassword");
const Register = () =>
    import ("../components/auth/Register");

//users,user permission and roles routes go here
const Users = () =>
    import ("../components/access_control/Users");

const Documents=()=>import("../components/file_management/Index")
const PageNotFound=()=>import("../components/errors/PageNotFound")

const LeavePage =()=>import("../components/leave_management/LeavePage")
const LeaveRequestForm =()=>import("../components/leave_management/LeaveRequestForm")
const LeaveRequests =()=>import("../components/leave_management/UserLeaveRequests")

const HolidaysPage =()=>import("../components/holidays/HolidaysPage.vue")
const HolidayList =()=>import("../components/holidays/HolidayList.vue")


Vue.use(Router);
const routes = new Router({
    mode: "history",
    linkExactActiveClass: "",
    linkActiveClass: "ant-breadcrumb",
    routes: [

        {
            path: "/login",
            component: AuthLayout,

            meta: {
                breadcrumb: 'Login',
            },
            children: [{
                path: "/",
                name: "login",
                component: Login,
            },

                {
                    path: "/register",
                    name: "register",
                    component: Register,
                },


                {
                    path: "/forgot-password",
                    name: "forgot-password",
                    component: ForgotPassword,
                },

            ]
        },


            // {
            //     path: "/forgot-password",
            //     name: "forgot-password",
            //     component: ForgotPassword,
            //     props: true
            // },
        {
            path: "/",
            name: "home",
            component: Home,
            meta: {
                breadcrumb: 'Home',
                breadcrumbIcon:'fa-home'
            },

            children: [
               {
                   path: "/users",
                   name: "users",
                   component: Users,
                   meta: {
                       breadcrumb: 'Users',
                   },

               },
               {
                   path: "/documents",
                   name: "documents",
                   component: Documents,
                   meta: {
                       breadcrumb: 'Documents',
                   },


               },

               {
                   path: "/leave",
                   name: "leave",
                   component: LeavePage,
                   children:[
                       {
                           path:"/",
                           name:"leave-requests",
                           component:LeaveRequests,
                           meta: {
                               breadcrumb: 'Leave Requests',
                           },
                       },
                       {
                           path:"/leave-create",
                           name:"leave-create",
                           component:LeaveRequestForm,
                           meta: {
                               breadcrumb: 'Leave Create',
                           },
                       }
                   ]
               },
               {
                   path: "/holidays",
                   name: "holidays",
                   component: HolidaysPage,
                   children:[
                       {
                           path:"/",
                           name:"leave-requests",
                           component:HolidayList,
                           meta: {
                               breadcrumb: 'Holidays',
                           },
                       },
                   ]
               },
           ]
        },
        {path: '*', component: PageNotFound},


    ]
});
setTimeout(() => {
    console.log(routes.currentRoute.path);
}, 0);
export default routes;
