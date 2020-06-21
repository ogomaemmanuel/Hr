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
    import ("../components/access_control/users/UsersPage");

const Roles = () =>
    import ("../components/access_control/roles/RolesPage");
const RoleCreate = () =>
    import ("../components/access_control/roles/RoleCreateModal");
const RoleEdit = () =>
    import ("../components/access_control/roles/RoleEditModal");


const DepartmentsPage = () => import("../components/employee_management/departments/DepartmentsPage")
const DepartmentList = () => import("../components/employee_management/departments/DepartmentList")
const DepartmentCreate = () => import("../components/employee_management/departments/DepartmentCreateModal")
const DepartmentEdit = () => import("../components/employee_management/departments/DepartmentEditModal")

const DesignationsPage = () => import("../components/employee_management/designations/DesignationsPage")
const DesignationList = () => import("../components/employee_management/designations/DesignationList")
const DesignationsCreate = () => import("../components/employee_management/designations/DesignationCreateModal")
const DesignationsEdit = () => import("../components/employee_management/designations/DesignationEditModal")


const EmployeesPage = () => import("../components/employee_management/employees/EmployeePage")
const EmployeeList = () => import("../components/employee_management/employees/EmployeeList")
const EmployeeCreate = () => import("../components/employee_management/employees/create/EmployeeCreateForm")
// const DesignationsEdit = () => import("../components/employee_management/designations/DesignationEditModal")


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
            meta: {},

            children: [
                {
                    path: "/users",
                    name: "users",
                    component: Users,
                    meta: {
                        breadcrumb: true,
                        title: "Users",
                    },

                },
                {
                    path: "/roles",
                    name: "roles",
                    component: Roles,
                    meta: {
                        breadcrumb: true,
                        title: "Roles",
                    },
                    children: [
                        {
                            path: "/role-create",
                            name: "role-create",
                            component: RoleCreate
                        },
                        {
                            path: "/role-edit/:id",
                            name: "role-edit",
                            component: RoleEdit
                        }
                    ]

                },
                {
                    path: "/documents",
                    name: "documents",
                    component: Documents,
                    meta: {
                        breadcrumb: true,
                        title: "Documents"
                    },


                },

                {
                    path: "/leave",
                    name: "leave",
                    component: LeavePage,
                    meta: {
                        breadcrumb: true,
                        title: "Leave Requests",
                    },
                    children: [
                        {
                            path: "/",
                            name: "leave-requests",
                            component: LeaveRequests,
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
                    path: "/departments",
                    name: "departments-page",
                    component: DepartmentsPage,
                    meta: {
                        breadcrumbs: true,
                        redirect: true,
                        title: 'Departments'
                    },
                    children: [
                        {
                            path: "/",
                            name: "department-list",
                            component: DepartmentList,
                            meta: {
                                breadcrumb: 'Departments',
                            },
                            children: [
                                {
                                    path: "/departments-edit/:id",
                                    component: DepartmentEdit,
                                    name: "departments-edit"
                                },
                                {
                                    path: "/departments-create",
                                    component: DepartmentCreate,
                                    name: "departments-create"
                                }
                            ]
                        },
                    ]
                },
                {
                    path: "/employees",
                    name: "employee-page",
                    component: EmployeesPage,

                    meta: {
                        breadcrumb: 'Employees',
                        title: 'Employees',
                        redirect: true,
                    },
                    children: [
                        {
                            path: "/",
                            name: "employee-list",
                            component: EmployeeList,
                            meta: {
                                // breadcrumb: 'Employees',
                                // redirect: true
                            },
                            children: [
                                // {
                                //     path: "/employeees-edit/:id",
                                //     component: DepartmentEdit,
                                //     name: "departments-edit"
                                // },

                            ]
                        },
                        {
                            path: "/employees-create",
                            component: EmployeeCreate,
                            name: "employees-create",

                            meta: {
                                breadcrumb: 'Employees Create',
                                title: 'Employees Create',
                                redirect: true,
                            },
                        }
                    ]
                },
                {
                    path: "/designations",
                    name: "designations-page",
                    component: DesignationsPage,
                    meta: {
                        title: "Designations"
                    },
                    children: [
                        {
                            path: "/",
                            name: "designation-list",
                            component: DesignationList,
                            meta: {
                                breadcrumb: 'Designations',
                            },
                            children: [
                                {
                                    path: "/designations-edit/:id",
                                    component: DesignationsEdit,
                                    name: "designations-edit"
                                },
                                {
                                    path: "/designations-create",
                                    component: DesignationsCreate,
                                    name: "designations-create"
                                }
                            ]
                        },
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
