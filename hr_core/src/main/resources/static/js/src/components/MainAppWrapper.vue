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
                        <strong>{{ authenticatedUser.fullName }}</strong>
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
    <PasswordResetForm
        @close="showChangePassword=false"
        v-if="showChangePassword"></PasswordResetForm>
    <router-view></router-view>
  </div>
</template>
<script>
const NotificationDropDown =()=> import( "./notifications/NotificationDropDown");
const PasswordResetForm = () => import("./user_profile/ChangePasswordModal")
import LogoutForm from "./auth/LogoutForm.vue"
import {mapActions, mapGetters} from "vuex";
import utils from "../utils/utils";
// import firebaseUtil from "../firebase/firebaseConfig"
import {Message} from "element-ui"

let handleOutsideClick;
export default {
  props: {
    user: {}
  },
  components: {
    PasswordResetForm,
    NotificationDropDown,
    LogoutForm
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
          Message.success(message.body);
          // if (messageBody.type == "chat") {
          //   if (messageBody.data.senderId != (JSON.parse(vm.user).id)) {
          //     //ToDO uncomment line below
          //     //vm.showNewMessageAlert(messageBody.data);
          //   } else {
          //     // we automatically open a chat-box if the logged in user is the sender
          //     //This we may remove if not desired
          //     //TODO uncomment 2 lines below
          //     // messageBody.data.name = message.groupName
          //     //vm.addChatBox(messageBody.data);
          //   }
          //   // ToDO uncomment the line that follows
          //   // vm.addChatMessage(messageBody.data);
          // }
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

.side-menu-portal-target {
  display: revert;
}
</style>