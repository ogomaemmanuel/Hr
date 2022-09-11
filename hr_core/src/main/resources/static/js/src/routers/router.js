import Vue from "vue"
import Router from "vue-router"

const AuthLayout = () =>
    import ("../components/auth/AuthLayout.vue");
const Login = () =>
    import ("../components/auth/Login.vue");
const Dashboard = () => import("../components/dashboard/DashboardPage")
const Home = () =>
    import ("../components/home/Home");
const MainAppWrapper = () => import("../components/MainAppWrapper")
const ForgotPassword = () =>
    import ("../components/auth/ForgotPassword");
const Register = () =>
    import ("../components/auth/Register");

// Apps
const EventsPage = ()=> import("../components/events/EventsPage");
const ContactsPage = ()=> import("../components/contacts/ContactsPage");

//users,user permission and roles routes go here
const Users = () =>
    import ("../components/access_control/users/UsersPage");
const UserCreate = () =>
    import ("../components/access_control/users/UserCreateModal");
const UserEdit = () =>
    import ("../components/access_control/users/UserEditModal");
const UserProfile = () => import("../components/user_profile/UserProfile")

const Roles = () =>
    import ("../components/access_control/roles/RolesPage");
const RoleCreate = () =>
    import ("../components/access_control/roles/RoleCreateModal");
const RoleEdit = () =>
    import ("../components/access_control/roles/RoleEditModal");
const Permissions = () =>
    import ("../components/access_control/permissions/PermissionList");

const DepartmentsPage = () => import("../components/employee_management/departments/DepartmentsPage")
const DepartmentList = () => import("../components/employee_management/departments/DepartmentList")
const DepartmentCreate = () => import("../components/employee_management/departments/DepartmentCreateModal")
const DepartmentEdit = () => import("../components/employee_management/departments/DepartmentEditModal")

const DesignationsPage = () => import("../components/employee_management/designations/DesignationsPage")
const DesignationList = () => import("../components/employee_management/designations/DesignationList")
const DesignationsCreate = () => import("../components/employee_management/designations/DesignationCreateModal")
const DesignationsEdit = () => import("../components/employee_management/designations/DesignationEditModal")


const ResignationPage = () => import("../components/employee_management/resignation/EmployeeResignationPage")
const ResignationList = () => import("../components/employee_management/resignation/ResignationList")
const ResignationEdit = () => import("../components/employee_management/resignation/ResignationEditModal")


const EmployeeTerminationPage = () => import("../components/employee_management/termination/TerminationPage")
const EmployeeTerminationList = () => import("../components/employee_management/termination/TerminationList")
const EmployeeTerminationEdit = () => import("../components/employee_management/termination/TerminationEditModal")


const EmployeeAttendance = () => import("../components/attendance/EmployeeAttendancePage")
const AdminAttendancePage = () => import("../components/attendance/AdminAttendancePage")


const EmployeesPage = () => import("../components/employee_management/employees/list/EmployeePage")
const EmployeeList = () => import("../components/employee_management/employees/list/EmployeeList")
const EmployeeCreate = () => import("../components/employee_management/employees/create/EmployeeCreateForm")


const OvertimeRequests = () => import("../components/employee_management/overtime_requests/OverTimeRquestPage")
const OvertimeRequestList = () => import("../components/employee_management/overtime_requests/OvertimerRequestList")
const OvertimeRequestEdit = () => import("../components/employee_management/overtime_requests/OvertimeRequestEditModal")


const PayrollItemsPage = () => import("../components/payroll/payroll_items/PayrollItemPage")
const SalaryView = () => import("../components/payroll/employee_salary/PaySlip")
const EmployeeSalaryView = () => import("../components/payroll/employee_salary/EmployeePayslip")
const EmployeesSalaryPage = () => import("../components/payroll/employee_salary/EmployeeSalaryPage")
const EmployeeSalaryList = () => import("../components/payroll/employee_salary/EmployeeSalaryList")
const EmployeeSalaryDetails = () => import("../components/payroll/employee_salary/EmployeeSalaryDetails")


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


const ClientsPage = () => import("../components/project_management/clients/ClientsPage")
const ClientList = () => import("../components/project_management/clients/ClientList")
const ClientCreate = () => import("../components/project_management/clients/ClientCreateModal")
const ClientEdit = () => import("../components/project_management/clients/ClientEditModal")

const ProjectsPage = () => import("../components/project_management/projects/ProjectsPage")
const ProjectList = () => import("../components/project_management/projects/ProjectList")
const ProjectCreate = () => import("../components/project_management/projects/ProjectCreateModal")
const ProjectEdit = () => import("../components/project_management/projects/ProjectEditModal")
const ProjectDetails = () => import("../components/project_management/projects/ProjectDetails")

const TasksPage = () => import("../components/project_management/tasks/TasksPage")

const SettingsPage = () => import("../components/settings/Settings")
const CompanySetting = () => import("../components/settings/company/CompanyDetailsForm")
const EmailSetting = () => import("../components/settings/email/EmailSettingsForm")
const NotificationSetting = () => import("../components/settings/notifications/NotificationsSettingsForm")
const InvoiceSetting = () => import("../components/settings/invoice/InvoiceSettingsForm")


const TaxPage = () => import("../components/accounting/taxes/TaxPage")
const TaxList = () => import("../components/accounting/taxes/TaxList")
const TaxCreateModal = () => import("../components/accounting/taxes/TaxCreateModal")
const TaxEditModal = () => import("../components/accounting/taxes/TaxEditModal")

const EstimatesPage = () => import("../components/accounting/estimates/EstimatesPage")
const EstimateList = () => import("../components/accounting/estimates/EstimateList")
const EstimateCreate = () => import("../components/accounting/estimates/EstimateCreateForm")
const EstimateEdit = () => import("../components/accounting/estimates/EstimatesEditForm")

const ExpensePage = () => import("../components/accounting/expenses/ExpensePage")
const ExpenseList = () => import("../components/accounting/expenses/ExpenseList")
const ExpenseCreate = () => import("../components/accounting/expenses/ExpenseCreateModal")
const ExpenseEdit = () => import("../components/accounting/expenses/ExpenseEditModal")

const InvoicePage =()=> import("../components/accounting/invoices/InvoicesPage")
const InvoiceList =()=> import("../components/accounting/invoices/InvoiceList")
const InvoiceCreate =()=> import("../components/accounting/invoices/InvoiceCreateForm")
const InvoiceEdit =()=> import("../components/accounting/invoices/InvoiceEditForm")


const PaymentsPage =()=> import("../components/accounting/payments/PaymentsPage")
const PaymentsList =()=> import("../components/accounting/payments/PaymentList")


const GoalTypes =()=> import("../components/performance/goals_types/GoalsTypes")
const GoalTracking =()=> import("../components/performance/goals_tracking/GoalTrackingList")
const TrainingType =()=> import("../components/performance/training_types/TrainingTypeList")
const Trainers =()=> import("../components/performance/trainers/TrainersList")
const TrainingList =()=> import("../components/performance/training/TrainingList")





const ProvidentFundsPage = () => import("../components/accounting/provident_fund/ProvidentFundPage")
const ProvidentFundList = () => import("../components/accounting/provident_fund/ProvidentFundList")
const ProvidentFundCreate = () => import("../components/accounting/provident_fund/ProvidentFundCreateModal")
const ProvidentFundEdit = () => import("../components/accounting/provident_fund/ProvidentFundEditModal")


const PolicyPage = () => import("../components/employee_management/policy/PolicyPage")
const PolicyList = () => import("../components/employee_management/policy/PolicyList")
const PolicyCreate = () => import("../components/employee_management/policy/PolicyCreateModal")
const PolicyEdit = () => import("../components/employee_management/policy/PolicyEditModal")


const AssetsPage = () => import("../components/assets/AssestsPage")
const AssetList = () => import("../components/assets/AssetList")
const AssetCreate = () => import("../components/assets/AssetCreateModal")
const AssetEdit = () => import("../components/assets/AssetEditModal")

const JobsPage = () => import("../components/jobs/manage_jobs/JobsPage")
const JobList = () => import("../components/jobs/manage_jobs/JobList")
const JobCreate =()=> import("../components/jobs/manage_jobs/JobCreateFormModal")
const JobEdit =()=> import("../components/jobs/manage_jobs/JobEditFormModal")


const ChatPage =()=> import("../components/chat/ChatPage")

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
            component: MainAppWrapper,
            children: [
                {
                    path: "/",
                    component: Home,
                    meta: {},

                    children: [
                        {
                            path: "/",
                            name: "Dashboard",
                            component: Dashboard
                        },
                        {
                            path: "/events",
                            name: "events",
                            component: EventsPage,
                            meta: {
                                breadcrumb: true,
                                title: "Events",
                            },
                        },
                        {
                            path: "/contacts",
                            name: "contacts",
                            component: ContactsPage,
                            meta: {
                                breadcrumb: true,
                                title: "Contacts",
                            },
                        },
                        {
                            path: "/users",
                            name: "users",
                            component: Users,
                            meta: {
                                breadcrumb: true,
                                title: "Users",
                            },
                            children: [
                                {
                                    path: "/users-create",
                                    name: "user-create",
                                    component: UserCreate
                                },
                                {
                                    path: "/users-edit/:id",
                                    name: "users-edit",
                                    component: UserEdit
                                }
                            ]

                        },
                        {
                            path: "/profile",
                            name: "users-profile",
                            component: UserProfile,
                            meta: {
                                breadcrumb: true,
                                title: "Profile",
                            },
                            children: []

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
                            path: "/permissions",
                            name: "permissions",
                            component: Permissions,
                            meta: {
                                breadcrumb: true,
                                title: "Permissions",
                            },


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
                                    component: PolicyPage,
                                    path: "/policies",
                                    children: [
                                        {
                                            path: "/",
                                            component: PolicyList,
                                            name: "Policy",
                                            meta: {
                                                breadcrumb: 'Policies',
                                                title: 'Policies',
                                                redirect: true,
                                            },
                                            children: [
                                                {
                                                    path: "/policy-create",
                                                    component: PolicyCreate
                                                },
                                                {
                                                    path: "/policy-edit/:id",
                                                    component: PolicyEdit
                                                },
                                            ]
                                        },


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
                            component: HolidaysPage,
                            children: [
                                {
                                    path: "/",
                                    name: "holidays",
                                    component: HolidayList,
                                    meta: {
                                        title: 'Holidays',
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
                            component: LeaveTypesPage,
                            children: [
                                {
                                    path: "/",
                                    name: "leave-types-list",
                                    component: LeaveTypeList,
                                    meta: {
                                        breadcrumb: 'Leave Types',
                                        title: "Leave Types"
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
                        {
                            path: "/overtime-requests",
                            component: OvertimeRequests,
                            meta: {
                                breadcrumb: true,
                                title: "Overtime Requests",
                            },
                            children: [
                                {
                                    path: "/",
                                    name: "overtime-requests-list",
                                    component: OvertimeRequestList,
                                    children: [
                                        {
                                            path: "/overtime-requests-edit/:id",
                                            name: "overtime-requests-edit",
                                            component: OvertimeRequestEdit,
                                        },
                                    ]
                                },


                            ]
                        },
                        {
                            path: "/employee-resignations",
                            component: ResignationPage,
                            meta: {
                                breadcrumb: true,
                                title: "Resignation",
                            },
                            children: [
                                {
                                    path: "/",
                                    name: "employee-resignation-list",
                                    component: ResignationList,
                                    children: [
                                        {
                                            path: "/employee-resignation-edit/:id",
                                            name: "employee-resignation-edit",
                                            component: ResignationEdit,
                                        },
                                    ]
                                },


                            ]
                        },
                        {
                            path:"/employee-attendance",
                            component: EmployeeAttendance
                        },
                        {
                            path:"/admin-attendance",
                            component: AdminAttendancePage
                        },
                        {
                            path: "/employee-terminations",
                            component: EmployeeTerminationPage,
                            meta: {
                                breadcrumb: true,
                                title: "Terminations",
                            },
                            children: [
                                {
                                    path: "/",
                                    name: "employee-termination-list",
                                    component: EmployeeTerminationList,
                                    children: [
                                        {
                                            path: "/employee-termination-edit/:id",
                                            name: "employee-termination-edit",
                                            component: EmployeeTerminationEdit,
                                        },
                                    ]
                                },


                            ]
                        },
                        {
                            path: "/payroll-items",
                            name: "payroll-terminations",
                            component: PayrollItemsPage,
                            meta: {
                                breadcrumb: true,
                                title: "Payroll Items",
                            },
                        },
                        {
                            path: "/salary-view",
                            name: "salary-view",
                            component: SalaryView,
                            meta: {
                                breadcrumb: true,
                                title: "Payslip",
                            },
                        },

                        {
                            path: "/salary",
                            component: EmployeesSalaryPage,
                            meta: {
                                breadcrumb: true,
                                title: "Employees Salary",
                            },
                            children: [
                                {
                                    path: "/",
                                    name: "Salary",
                                    component: EmployeeSalaryList
                                },
                                {
                                    path: "/salary/:id",
                                    name: "employee-details",
                                    component: EmployeeSalaryDetails,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Salary Details",
                                    },
                                },
                                {
                                    path: "/salary-view/:id",
                                    name: "employee-salary-view",
                                    component: EmployeeSalaryView,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Payslip",
                                    },
                                },
                            ]
                        },
                        {
                            path: "/clients",
                            component: ClientsPage,
                            meta: {
                                breadcrumb: true,
                                title: "Clients",
                            },
                            children: [
                                {
                                    path: "/",
                                    component: ClientList,
                                    name: "clients",
                                    children: [
                                        {
                                            path: "/client-create",
                                            name: "client-create",
                                            component: ClientCreate,
                                            meta: {
                                                breadcrumb: true,
                                                title: "Client Create",
                                            },
                                        },
                                        {
                                            path: "/clients-edit/:id",
                                            name: "clients-edit",
                                            component: ClientEdit,
                                            meta: {
                                                breadcrumb: true,
                                                title: "Client Edit",
                                            },
                                        },
                                    ]
                                },

                            ]
                        },
                        {
                            path: "/projects",
                            component: ProjectsPage,
                            meta: {
                                breadcrumb: true,
                                title: "Projects",
                            },
                            children: [
                                {
                                    path: "/",
                                    component: ProjectList,
                                    name: "projects",
                                    children: [
                                        {
                                            path: "/projects-create",
                                            name: "projects-create",
                                            component: ProjectCreate,
                                            meta: {
                                                breadcrumb: true,
                                                title: "Project Create",
                                            },
                                        },
                                        {
                                            path: "/project-edit/:id",
                                            name: "project-edit",
                                            component: ProjectEdit,
                                            meta: {
                                                breadcrumb: true,
                                                title: "Project Edit",
                                            },
                                        },
                                    ]
                                },
                                {
                                    path: "/project-details/:id",
                                    name: "project-details",
                                    component: ProjectDetails,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Project Details",
                                    }
                                }

                            ]
                        },
                        {
                            path: "/tasks",
                            component: TasksPage,
                            meta: {
                                breadcrumb: true,
                                title: "tasks",
                            },
                            // children: [
                            //     {
                            //         path: "/",
                            //         component: ProjectList,
                            //         children: [
                            //             {
                            //                 path: "/projects-create",
                            //                 name: "projects-create",
                            //                 component: ProjectCreate,
                            //                 meta: {
                            //                     breadcrumb: true,
                            //                     title: "Project Create",
                            //                 },
                            //             },
                            //             {
                            //                 path: "/project-edit/:id",
                            //                 name: "project-edit",
                            //                 component: ProjectEdit,
                            //                 meta: {
                            //                     breadcrumb: true,
                            //                     title: "Project Edit",
                            //                 },
                            //             },
                            //         ]
                            //     },
                            //     {
                            //         path: "/project-details/:id",
                            //         name: "project-details",
                            //         component: ProjectDetails,
                            //         meta: {
                            //             breadcrumb: true,
                            //             title: "Project Details",
                            //         }
                            //     }
                            //
                            // ]
                        },
                        {
                            path: "/taxes",
                            component: TaxPage,
                            meta: {
                                breadcrumb: true,
                                title: "Taxes",
                            },
                            children: [
                                {
                                    path: "/",
                                    component: TaxList,
                                    children: [
                                        {
                                            path: "/tax-create",
                                            name: "tax-create",
                                            component: TaxCreateModal,
                                            meta: {
                                                breadcrumb: true,
                                                title: "Tax Create",
                                            },
                                        },
                                        {
                                            path: "/tax-edit/:id",
                                            name: "tax-edit",
                                            component: TaxEditModal,
                                            meta: {
                                                breadcrumb: true,
                                                title: "Tax Edit",
                                            },
                                        },
                                    ]
                                },
                            ]
                        },
                        {
                            path: "/estimates",
                            component: EstimatesPage,
                            meta: {
                                breadcrumb: true,
                                title: "Estimates",
                            },
                            children: [
                                {
                                    path: "/",
                                    component: EstimateList,
                                },
                                {
                                    path: "/estimate-create",
                                    name: "estimate-create",
                                    component: EstimateCreate,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Estimate Create",
                                    }
                                },
                                {
                                    path: "/estimate-edit/:id",
                                    name: "estimate-edit",
                                    component: EstimateEdit,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Estimate Edit",
                                    }
                                }

                            ]
                        },
                        {
                            path: "/invoices",
                            component: InvoicePage,
                            meta: {
                                breadcrumb: true,
                                title: "Invoices",
                            },
                            children: [
                                {
                                    path: "/",
                                    component: InvoiceList,
                                },
                                {
                                    path: "/invoice-create",
                                    name: "invoice-create",
                                    component: InvoiceCreate,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Invoice Create",
                                    }
                                },
                                {
                                    path: "/invoice-edit/:id",
                                    name: "invoice-edit",
                                    component: InvoiceEdit,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Invoice Edit",
                                    }
                                }

                            ]
                        },
                        {
                            path: "/expenses",
                            component: ExpensePage,
                            meta: {
                                breadcrumb: true,
                                title: "Expenses",
                            },
                            children: [
                                {
                                    path: "/",
                                    component: ExpenseList,
                                },
                                {
                                    path: "/expense-create",
                                    name: "expense-create",
                                    component: ExpenseCreate,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Expense Create",
                                    }
                                },
                                {
                                    path: "/expense-edit/:id",
                                    name: "expense-edit",
                                    component: ExpenseEdit,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Expense  Edit",
                                    }
                                }

                            ]
                        },
                        {
                            path: "/payments",
                            component: PaymentsPage,
                            meta: {
                                breadcrumb: true,
                                title: "Payments",
                            },
                            children: [
                                {
                                    path: "/",
                                    component: PaymentsList,
                                },
                                // {
                                //     path: "/payment-create",
                                //     name: "payment-create",
                                //     component: ExpenseCreate,
                                //     meta: {
                                //         breadcrumb: true,
                                //         title: "Expense Create",
                                //     }
                                // },
                                // {
                                //     path: "/expense-edit/:id",
                                //     name: "expense-edit",
                                //     component: ExpenseEdit,
                                //     meta: {
                                //         breadcrumb: true,
                                //         title: "Expense  Edit",
                                //     }
                                // }

                            ]
                        },
                        {
                            path: "/provident-funds",
                            component: ProvidentFundsPage,
                            meta: {
                                breadcrumb: true,
                                title: "Provident Funds",
                            },
                            children: [
                                {
                                    path: "/",
                                    component: ProvidentFundList,
                                },
                                {
                                    path: "/provident-fund-create",
                                    name: "provident-fund-create",
                                    component: ProvidentFundCreate,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Provident Fund Create",
                                    }
                                },
                                {
                                    path: "/provident-fund-edit/:id",
                                    name: "provident-fund-edit",
                                    component: ProvidentFundEdit,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Provident  Edit",
                                    }
                                }

                            ]
                        },
                        {
                            path: "/settings",
                            name: "settings",
                            component: SettingsPage,
                            meta: {
                                breadcrumb: true,
                                title: "Settings",
                            },
                            children: [
                                {
                                    path: "/settings/company",
                                    name: "companySettings",
                                    component: CompanySetting,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Company",
                                    },
                                },
                                {
                                    path: "/settings/email",
                                    name: "emailSettings",
                                    component: EmailSetting,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Email",
                                    },
                                },
                                {
                                    path: "/settings/notifications",
                                    name: "notificationSettings",
                                    component: NotificationSetting,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Notifications",
                                    },
                                },
                                {
                                    path: "/settings/invoice",
                                    name: "invoiceSettings",
                                    component: InvoiceSetting,
                                    meta: {
                                        breadcrumb: true,
                                        title: "Invoice",
                                    },
                                }
                            ]
                        },
                        {
                            path: "/assets",
                            component: AssetsPage,
                            meta: {
                                breadcrumb: true,
                                title: "Assets",
                            },
                            children: [
                                {
                                    path: "/",
                                    component: AssetList,
                                    name: "assets",
                                    children: [
                                        {
                                            path: "/asset-create",
                                            name: "asset-create",
                                            component: AssetCreate
                                        },
                                        {
                                            path: "/asset-edit/:id",
                                            name: "asset-edit",
                                            component: AssetEdit
                                        }
                                    ]
                                },

                            ]
                        },
                        {
                            path: "/jobs",
                            component: JobsPage,
                            meta: {
                                breadcrumb: true,
                                title: "Jobs",
                            },
                            children: [
                                {
                                    path: "/",
                                    component: JobList,
                                    name: "jobs",
                                    children: [
                                        {
                                            path: "/job-create",
                                            name: "job-create",
                                            component: JobCreate
                                        },
                                        {
                                            path: "/job-edit/:id",
                                            name: "job-edit",
                                            component: JobEdit
                                        }
                                    ]
                                },

                            ]
                        },
                        {
                            path: "/goal-types",
                            component: GoalTypes,
                            meta: {
                                breadcrumb: true,
                                title: "Goal Types",
                            },
                            // children: [
                            //     {
                            //         path: "/",
                            //         component: JobList,
                            //         name: "jobs",
                            //         children: [
                            //             {
                            //                 path: "/job-create",
                            //                 name: "job-create",
                            //                 component: JobCreate
                            //             },
                            //             {
                            //                 path: "/job-edit/:id",
                            //                 name: "job-edit",
                            //                 component: JobEdit
                            //             }
                            //         ]
                            //     },
                            //
                            // ]
                        },
                        {
                            path: "/goal-tracking",
                            component: GoalTracking,
                            meta: {
                                breadcrumb: true,
                                title: "Goal Tracking",
                            },
                            // children: [
                            //     {
                            //         path: "/",
                            //         component: JobList,
                            //         name: "jobs",
                            //         children: [
                            //             {
                            //                 path: "/job-create",
                            //                 name: "job-create",
                            //                 component: JobCreate
                            //             },
                            //             {
                            //                 path: "/job-edit/:id",
                            //                 name: "job-edit",
                            //                 component: JobEdit
                            //             }
                            //         ]
                            //     },
                            //
                            // ]
                        },
                        {
                            path: "/training-types",
                            component: TrainingType,
                            meta: {
                                breadcrumb: true,
                                title: "Training Types",
                            },
                            // children: [
                            //     {
                            //         path: "/",
                            //         component: JobList,
                            //         name: "jobs",
                            //         children: [
                            //             {
                            //                 path: "/job-create",
                            //                 name: "job-create",
                            //                 component: JobCreate
                            //             },
                            //             {
                            //                 path: "/job-edit/:id",
                            //                 name: "job-edit",
                            //                 component: JobEdit
                            //             }
                            //         ]
                            //     },
                            //
                            // ]
                        },
                        {
                            path: "/training",
                            component: TrainingList,
                            meta: {
                                breadcrumb: true,
                                title: "Training",
                            },
                            // children: [
                            //     {
                            //         path: "/",
                            //         component: JobList,
                            //         name: "jobs",
                            //         children: [
                            //             {
                            //                 path: "/job-create",
                            //                 name: "job-create",
                            //                 component: JobCreate
                            //             },
                            //             {
                            //                 path: "/job-edit/:id",
                            //                 name: "job-edit",
                            //                 component: JobEdit
                            //             }
                            //         ]
                            //     },
                            //
                            // ]
                        },
                        {
                            path: "/trainers",
                            component: TrainingList,
                            meta: {
                                breadcrumb: true,
                                title: "Trainers",
                            },
                            // children: [
                            //     {
                            //         path: "/",
                            //         component: JobList,
                            //         name: "jobs",
                            //         children: [
                            //             {
                            //                 path: "/job-create",
                            //                 name: "job-create",
                            //                 component: JobCreate
                            //             },
                            //             {
                            //                 path: "/job-edit/:id",
                            //                 name: "job-edit",
                            //                 component: JobEdit
                            //             }
                            //         ]
                            //     },
                            //
                            // ]
                        },

                    ]
                },

                {
                    path:"/messaging",
                    component: ChatPage
                }
            ]


        },


        {path: '*', component: PageNotFound},


    ]
});
setTimeout(() => {
    console.log(routes.currentRoute.path);
}, 0);
export default routes;
