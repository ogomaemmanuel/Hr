import Vue from "vue"
import Router from "vue-router"

const AuthLayout = () =>
    import ("../components/auth/AuthLayout.vue");
const Login = () =>
    import ("../components/auth/Login.vue");
const Home = () =>
    import ("../components/home/Home");
const ForgotPassword = () =>
    import ("../components/auth/ForgotPassword");
const Register = () =>
    import ("../components/auth/Register");

//users,user permission and roles routes go here
const Users = () =>
    import ("../components/access_control/Users");

const Roles = () =>
    import ("../components/access_control/roles/RolesPage");

const Documents = () => import("../components/file_management/Index")
const PageNotFound = () => import("../components/errors/PageNotFound")

const LeavePage = () => import("../components/leave_management/LeavePage")
const LeaveRequestForm = () => import("../components/leave_management/LeaveRequestFormModal")
const LeaveRequests = () => import("../components/leave_management/UserLeaveRequests")
const LeaveRequestEditModal = () => import("../components/leave_management/LeaveRequestEditModal")


const LeaveApprovalsPage = () => import("../components/leave_management/leave_approval/LeaveApprovalPage")
const LeaveApprovalsList = () => import("../components/leave_management/leave_approval/LeaveApprovalList.vue")
const LeaveApprovalsDetails = () => import("../components/leave_management/leave_approval/LeaveDetail.vue")


const LeaveTypesPage = () => import("../components/leave_management/leave_types/LeaveTypesPage.vue")
const LeaveTypeList = () => import("../components/leave_management/leave_types/LeaveTypeList.vue")
const LeaveTypeCreateModal = () => import("../components/leave_management/leave_types/LeaveTypeCreateModal")
const LeaveTypeEditModal = () => import("../components/leave_management/leave_types/LeaveTypeEditModal")

const HolidaysPage = () => import("../components/holidays/HolidaysPage.vue")
const HolidayList = () => import("../components/holidays/HolidayList.vue")
const HolidayCreateModal = () => import("../components/holidays/HolidayCreateModal")
const HolidayEditModal = () => import("../components/holidays/HolidayEditModal")


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
                breadcrumbIcon: 'fa-home'
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
                    path: "/roles",
                    name: "roles",
                    component: Roles,
                    meta: {
                        breadcrumb: 'Roles',
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
                    children: [
                        {
                            path: "/",
                            name: "leave-requests",
                            component: LeaveRequests,
                            meta: {
                                breadcrumb: 'Leave Requests',
                            },
                            children: [
                                {
                                    path: "/leave-request-edit/:id",
                                    name: "leave-request-edit",
                                    component: LeaveRequestEditModal,
                                },
                                {
                                    path: "/leave-create",
                                    name: "leave-create",
                                    component: LeaveRequestForm,
                                    meta: {
                                        breadcrumb: 'Leave Create',
                                    },
                                },
                            ]
                        },
                    ]
                },
                {
                    path: "/leave-approvals",
                    name: "leave-approvals-page",
                    component: LeaveApprovalsPage,
                    children: [
                        {
                            path: "/",
                            name: "leave-approvals",
                            component: LeaveApprovalsList,
                            meta: {
                                breadcrumb: 'Leave Approvals',
                            },

                        },
                        {
                            path: "leave-details/:id",
                            name: "leave-details",
                            component: LeaveApprovalsDetails,
                            meta: {
                                breadcrumb: 'Leave Details',
                            },
                        }
                    ]
                },
                {
                    path: "/holidays",
                    name: "holidays-page",
                    component: HolidaysPage,
                    children: [
                        {
                            path: "/",
                            name: "leave-requests",
                            component: HolidayList,
                            meta: {
                                breadcrumb: 'Holidays',
                            },
                            children: [
                                {
                                    path: "/holiday-edit/:id",
                                    component: HolidayEditModal,
                                    name: "holiday-edit"
                                },
                                {
                                    path: "/holiday-create",
                                    component: HolidayCreateModal,
                                    name: "holiday-create"
                                }
                            ]
                        },
                    ]
                },
                {
                    path: "/leave-types",
                    name: "leave-types-page",
                    component: LeaveTypesPage,
                    children: [
                        {
                            path: "/",
                            name: "leave-types-list",
                            component: LeaveTypeList,
                            meta: {
                                breadcrumb: 'Leave Types',
                            },
                            children: [
                                {
                                    path: "/leave-type-create",
                                    name: "leave-type-create",
                                    component: LeaveTypeCreateModal
                                },
                                {
                                    path: "/leave-type-edit/:id",
                                    name: "leave-type-edit",
                                    component: LeaveTypeEditModal
                                }
                            ]
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
