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
Vue.use(Router);
const routes = new Router({
    mode: "history",
    linkExactActiveClass: "",
    linkActiveClass: "ant-breadcrumb",
    routes: [
        // {path: '*', redirect: "/login"},
        {
            path: "/login",
            component: AuthLayout,
           // props: true,
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
        //     path: "/register",
        //     name: "register",
        //     component: Register,
        //     props: true
        // },

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
           children: [
               {
                   path: "/users",
                   name: "users",
                   component: Users,
                   props: true
               },
           ]
        },


    ]
});
setTimeout(() => {
    console.log(routes.currentRoute.path);
}, 0);
export default routes;
