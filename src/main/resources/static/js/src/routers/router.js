import Vue from "vue"
import Router from "vue-router"

const Login = () =>
    import ("../components/auth/Login.vue");
const ForgotPassword = () =>
    import ("../components/auth/ForgotPassword");
const Register = () =>
    import ("../components/auth/Register");
Vue.use(Router);
const routes = new Router({
    mode: "history",
    linkExactActiveClass: "",
    linkActiveClass: "ant-breadcrumb",
    routes: [
        // {path: '*', redirect: "/login"},
        {
            path: "/login",
            component: Login,
            props: true,
            meta: {
                breadcrumb: 'Login',
            },
            // children: [{
            //     path: "/",
            //     name: "login",
            //     component: Login,
            //     props: true
            // },
            //
            //     {
            //         path: "/email-login",
            //         name: "email-login",
            //         component: EmailLogin,
            //         props: true
            //     },
            //
            //
            //     {
            //         path: "/forgot-password",
            //         name: "forgot-password",
            //         component: ForgotPassword,
            //         props: true
            //     },
            //
            // ]
        },
        {
            path: "/register",
            name: "register",
            component: Register,
            props: true
        },

    ]
});
setTimeout(() => {
    console.log(routes.currentRoute.path);
}, 0);
export default routes;
