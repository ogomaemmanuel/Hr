<template>
    <div>
        <nav class="navbar is-fixed-top is-primary" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item" href="https://bulma.io">
                    <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28">
                </a>
                <a role="button" class="navbar-burger burger" aria-label="menu" aria-expanded="false"
                   data-target="navbarBasicExample">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a>
            </div>
            <div id="navbarBasicExample" class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item">
                        Home
                    </a>

                    <a class="navbar-item">
                        Documentation
                    </a>

                    <div class="navbar-item has-dropdown is-hoverable">
                        <a class="navbar-link">
                            More
                        </a>

                        <div class="navbar-dropdown">
                            <a class="navbar-item">
                                About
                            </a>
                            <a class="navbar-item">
                                Jobs
                            </a>
                            <a class="navbar-item">
                                Contact
                            </a>
                            <hr class="navbar-divider">
                            <a class="navbar-item">
                                Report an issue
                            </a>
                        </div>
                    </div>
                </div>

                <div class="navbar-end">
                    <a ref="notification-toggle" @click="showNotifications=true"
                       class="navbar-item is-hoverable is-relative">
                        <i class="fa fa-bell">
                        </i>
                        <NotificationDropDown v-closable="{
    exclude: ['notification-toggle'],
    handler: 'hideNotifications'
  }" v-if="showNotifications"></NotificationDropDown>
                    </a>
                    <a class="navbar-item">
                        <i class="fa fa-envelope"></i>
                    </a>
                    <div class="navbar-item">
                        <LogoutForm></LogoutForm>
                    </div>


                    <div class="navbar-item has-dropdown is-hoverable">
                        <!--						<a class="navbar-link">-->
                        <!--							Docs-->
                        <!--						</a>-->

                        <figure class="image is-fullwidth navbar-link">
                            <img class="is-rounded profile-image"
                                 src="https://bulma.io/images/placeholders/128x128.png">
                        </figure>

                        <div class="navbar-dropdown is-right">
                            <a class="navbar-item">


                                <article class="media">
                                    <figure class="media-left">
                                        <p class="image is-32x32">
                                            <img class="is-rounded"
                                                 src="https://bulma.io/images/placeholders/128x128.png">
                                        </p>
                                    </figure>
                                    <div class="media-content">
                                        <div class="content">
                                            <p>
                                                <strong>{{authenticatedUser.fullName}}</strong>
                                            </p>
                                        </div>
                                    </div>
                                </article>
                            </a>
                            <router-link to="/profile" class="navbar-item">
                                Profile
                            </router-link>
                            <router-link to="/settings" class="navbar-item">
                                Settings
                            </router-link>
                            <a @click="showChangePassword=true" class="navbar-item">
                                Change Password
                            </a>
                            <!--                            <hr class="navbar-divider">-->
                            <a class="navbar-item">
                                Logout
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </nav>

        <section class="main-content columns  is-fullheight">

            <aside class="column pt-12 is-2 bg-gray-900 text-white pr-0 pl-3 pt-5 is-narrow-mobile fixed inset-y-0 section is-hidden-mobile">

                <div class="menu-wrapper">
                    <portal-target class="side-menu-portal-target" name="side-menu">
                    <ul class="menu-list">
                        <li>
                            <a href="#" class="">
                                <span class="icon"><i class="fa fa-home"></i></span> Home
                            </a>
                        </li>
                        <li>
                            <a href="#" class="">
                                <span class="icon"><i class="fa fa-group"></i></span> Access Control
                            </a>

                            <ul class="mr-0 pr-0 border-l-0">
                                <li>
                                    <router-link to="/users">
                                        <span>Users</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="roles">
                                        <span>Roles</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/permissions">
                                        <span>Permissions</span>
                                    </router-link>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" class="">
                                <span class="icon"><i class="fa fa-building-o"></i></span> Employee Management
                            </a>
                            <ul class="mr-0 pr-0 border-l-0">
                                <li>
                                    <router-link to="/employees">
                                        <span>All Employees</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/departments">
                                        <span>Departments</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/designations">
                                        <span>Designations</span>
                                    </router-link>
                                </li>
                                <li>
                                    <a href="#">
                                        <span>Attendance(Admin)</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span>Attendance(Employee)</span>
                                    </a>
                                </li>
                                <li>
                                    <router-link to="/overtime-requests">
                                        <span>Overtime</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/employee-resignations">
                                        <span>Resignation</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/employee-terminations">
                                        <span>Termination</span>
                                    </router-link>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" class="">
                                <span class="icon"><i class="fa fa-money"></i></span> Payroll
                            </a>
                            <ul class="mr-0 pr-0 border-l-0">
                                <li>
                                    <router-link to="/salary">
                                        <span>Employee Salary</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/salary-view">
                                        <span>Payslip</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/payroll-items">
                                        <span>Payroll Items</span>
                                    </router-link>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" class="">
                                <span class="icon"><i class="fa fa-money"></i></span> Project Management
                            </a>
                            <ul class="mr-0 pr-0 border-l-0">
                                <li>
                                    <router-link to="/clients">
                                        <span>Clients</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/projects">
                                        <span>Projects</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/tasks">
                                        <span>Tasks</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/payroll-items">
                                        <span>Task Board</span>
                                    </router-link>
                                </li>
                            </ul>
                        </li>

                        <li>
                            <a href="#" class="">
                                <span class="icon"><i class="fa fa-table"></i></span> Leave Management
                            </a>
                            <ul class="border-l-0">
                                <li>
                                    <router-link to="/leave">
                                        <span>My Leaves</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/documents">
                                        <span>In Place</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/leave-approvals">
                                        <span>Leave approvals</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/holidays">
                                        <span>Holidays</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/leave-types">
                                        <span>Leave Types</span>
                                    </router-link>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" class="">
                                <span class="icon"><i class="fa fa-table"></i></span> Accounts
                            </a>
                            <ul class="border-l-0">
                                <li>
                                    <router-link to="/leave">
                                        <span>Estimates</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/documents">
                                        <span>Invoices</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/leave-approvals">
                                        <span>Payments</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/holidays">
                                        <span>Expenses</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/leave-types">
                                        <span>Provided Fund</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/leave-types">
                                        <span>Taxes</span>
                                    </router-link>
                                </li>
                            </ul>
                        </li>

                        <li>
                            <a href="#" class="">
                                <span class="icon"><i class="fa fa-folder-open"></i></span> File Management
                            </a>
                            <ul class="border-l-0">
                                <li>
                                    <router-link to="/documents">
                                        <span>Manage Files</span>
                                    </router-link>
                                </li>
                                <li>
                                    <router-link to="/documents">
                                        <span>My Files</span>
                                    </router-link>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" class="">
                                <span class="icon"><i class="fa fa-info"></i></span> About
                            </a>
                        </li>
                    </ul>
                    </portal-target>
                </div>
                <div class="side-bar-footer bg-gray-800 left-0  right-0 h-8 absolute bottom-0">
                    <div class="flex justify-end mr-4">
                        <i><span class="fa fa-angle-left"></span></i>
                    </div>
                    <!--						<div class="relative mt-5 h-full">-->
                    <!--					</div>-->
                </div>
            </aside>


            <div class=" column is-offset-2 is-10 pr-10 pl-10 pb-10 pt-20 h-screen mb-0">
                <div class="">

                    <div class="columns">
                        <div class="column">

                            <div class="flex align-center">
                                <button type="button" class="is-hidden-desktop toggle-mobile-nav">
                                    <i class="fa fa-bars text-gray-600"></i>
                                </button>
                                <TestBreadCrump></TestBreadCrump>
                            </div>
                        </div>
                        <div class="column">
                            <div class="flex sm:justify-start md:justify-end">
                                <portal-target name="page-controls">
                                    <!--
                                    This component can be located anywhere in your App.
                                    The slot content of the above portal component will be rendered here.
                                    -->
                                </portal-target>
                            </div>
                        </div>
                    </div>


                    <!--                    <breadcrumbs></breadcrumbs>-->
                </div>
                <div class="mt-5 h-full">
                    <router-view></router-view>
                </div>
            </div>
        </section>
        <PasswordResetForm
                @close="showChangePassword=false"
                v-if="showChangePassword"></PasswordResetForm>
    </div>
</template>
<script>
    import LogoutForm from "../auth/LogoutForm.vue"

    const PasswordResetForm = () => import("../user_profile/ChangePasswordModal")
    import NotificationDropDown from "../notifications/NotificationDropDown";
    import {mapActions, mapGetters} from "vuex"
    //import TestBreadCrump from "../common/TestBreadCrump"
    import TestBreadCrump from "../common/TestBreadCrump"
    import firebaseUtil from "../../firebase/ firebaseConfig"
    import {Message} from "element-ui"
    import utils from "../../utils/utils"

    let handleOutsideClick;
    export default {
        components: {
            LogoutForm,
            NotificationDropDown,
            TestBreadCrump,
            PasswordResetForm
        },
        props: {
            user: {}
        },
        data() {
            return {
                showNotifications: false,
                isFullPage: true,
                showChangePassword: false,
                loading: false,
            }

        },
        computed: {
            ...mapGetters(["authenticatedUser"])
        },
        created() {
            // this.open();
            let vm = this;
            if (PRODUCTION) {
                utils.registerServiceWorker();
                firebaseUtil.askForPermissionToReceiveNotifications().then(token => {
                    console.log("Firebase subscription token is dashboard", token);
                    if (token) {
                        firebaseUtil.subscribeToFirebaseMessages(token);
                    }
                });
            } else {
                utils.unregisterServiceWorker();
            }
            try {
                let connection = utils.sockJsConnection();
                vm.handleSockJsSubscriptions(connection);
            } catch (e) {

            }
            this.setUser(JSON.parse(this.user));

        },
        directives: {
            closable: {

                bind(el, binding, vnode) {
                    // Here's the click/touchstart handler
                    // (it is registered below)
                    handleOutsideClick = (e) => {
                        e.stopPropagation()
                        // Get the handler method name and the exclude array
                        // from the object used in v-closable
                        const {handler, exclude} = binding.value

                        // This variable indicates if the clicked element is excluded
                        let clickedOnExcludedEl = false
                        exclude.forEach(refName => {
                            // We only run this code if we haven't detected
                            // any excluded element yet
                            if (!clickedOnExcludedEl) {
                                // Get the element using the reference name
                                const excludedEl = vnode.context.$refs[refName]
                                // See if this excluded element
                                // is the same element the user just clicked on
                                clickedOnExcludedEl = excludedEl.contains(e.target)
                            }
                        })

                        // We check to see if the clicked element is not
                        // the dialog element and not excluded
                        if (!el.contains(e.target) && !clickedOnExcludedEl) {
                            // If the clicked element is outside the dialog
                            // and not the button, then call the outside-click handler
                            // from the same component this directive is used in
                            vnode.context[handler]()
                        }
                    }
                    // Register click/touchstart event listeners on the whole page
                    document.addEventListener('click', handleOutsideClick)
                    document.addEventListener('touchstart', handleOutsideClick)
                },

                unbind() {
                    // If the element that has v-closable is removed, then
                    // unbind click/touchstart listeners from the whole page
                    document.removeEventListener('click', handleOutsideClick)
                    document.removeEventListener('touchstart', handleOutsideClick)
                }
            }
        },
        methods: {
            ...mapActions(["setUser"]),
            hideNotifications() {
                this.showNotifications = false
            },

            handleSockJsSubscriptions(connection) {
                let vm = this;
                connection.connect({}, function (frame) {
                    //subscribe to any notifications meant to me from anybody
                    connection.subscribe("/user/queue/notifications", function (message) {
                        let messageBody = JSON.parse(message.body);
                        if (messageBody.type == "chat") {
                            if (messageBody.data.senderId != (JSON.parse(vm.user).id)) {
                                //ToDO uncomment line below
                                //vm.showNewMessageAlert(messageBody.data);
                            } else {
                                // we automatically open a chat-box if the logged in user is the sender
                                //This we may remove if not desired
                                //TODO uncomment 2 lines below
                                // messageBody.data.name = message.groupName
                                //vm.addChatBox(messageBody.data);
                            }
                            // ToDO uncomment the line that follows
                            // vm.addChatMessage(messageBody.data);
                        }
                    });
                    //subscribe to all broadcast notifications- message sent to anyone-note keyword topic
                    connection.subscribe("/user/topic/notifications", function (message) {
                        Message.info(message.body);
                    });
                    //subcribe to notifications on login, invoke by me
                    connection.subscribe("/swat-chat/user-notifications-me", function (message) {
                        Message.info(message.body);
                    });
                }, function () {
                    window.setTimeout(function () {
                        let connection = utils.sockJsConnection();
                        vm.handleSockJsSubscriptions(connection);
                    }, 2000)
                });
            },
            open() {
                const loadingComponent = this.$buefy.loading.open({
                    container: this.isFullPage ? null : this.$refs.element.$el
                })
                setTimeout(() => loadingComponent.close(), 3 * 1000)
            }
        }
    }
</script>
<style scoped lang="scss">

    .navbar-item .profile-image {
        height: 36px;
        width: 36px;
        max-height: 36px;
    }

    .toggle-mobile-nav {
        //display: none;
        background-color: transparent;
        border: 0px;
        padding: 6px 16px;
        margin: 0 0 0 -15px;
        height: 46px;
    }

    .menu-wrapper {
        overflow-y: scroll;
        position: relative;
        height: 100%;
        margin-top: 2rem;
    }
    .side-menu-portal-target{
        display: revert;
    }
</style>
