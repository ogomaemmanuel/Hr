<template>
  <Layout :padding="'1.5rem 4.5rem 4.5rem 4.5rem'">
    <template v-slot:auth-form style="margin-top: -2em!important;">
      <h1 class="title has-text-dark has-text-centered" style="">Sing up.</h1>
      <p class="mb-2 has-text-left "> It is free and only takes a few seconds </p>
      <form class="box">
        <div class="field">
          <label class="label">Name</label>
          <div class="control has-icons-left">
            <input v-model="user.name" class="input has-text-left" placeholder="Name"
                   required type="text">
            <span class="icon is-small is-left">
                    <i class="fa fa-user"></i>
                  </span>
          </div>
        </div>

        <div class="field">
          <label class="label">Email</label>
          <div class="control has-icons-left">
            <input v-model="user.email" class="input has-text-left" placeholder="e.g. didinkaj@lambo-hr.com"
                   required type="email">
            <span class="icon is-small is-left">
                    <i class="fa fa-envelope"></i>
                  </span>
          </div>
        </div>
        <div class="field">
          <label class="label">Password</label>
          <div class="control has-icons-left">
            <input v-model="user.password" class="input" placeholder="********" required
                   type="password">
            <span class="icon is-small is-left">
                    <i class="fa fa-lock"></i>
                  </span>
          </div>
        </div>

        <div class="field">
          <label class="label">Confirm Password</label>
          <div class="control has-icons-left">
            <input v-model="user.confirmPassword" class="input" placeholder="********" required
                   type="password">
            <span class="icon is-small is-left">
                    <i class="fa fa-lock"></i>
                  </span>
          </div>
        </div>


        <div class="field">
          <div class="control is-block">
            <button :class="{'is-loading':isLoading}" class="button  is-fullwidth is-success"
                    @click.prevent="submitRequest">
              Register
            </button>
          </div>
        </div>
        <div class="columns">
          <div class="column">
          </div>
          <div class="column">
            <div class="field">
              <router-link button class="button is-text has-text-centered" tag="button" to="login"
                           @click.prevent="">
                Or Sign In
              </router-link>
            </div>
          </div>
        </div>
      </form>
    </template>
  </Layout>
</template>
<script>
import {Notification} from "element-ui"
import Layout from "./Layout.vue";

export default {
  components: {
    Layout
  },
  data() {
    return {
      isLoading: false,
      user: {
        phone: '00000000'
      }
    }
  },
  methods: {
    submitRequest() {
      let vm = this;
      vm.isLoading = true,
          axios.post("/register", vm.user).then(resp => {
            vm.isLoading = false
            Notification.success(resp.data);
          }, error => {
            vm.isLoading = false
          })
    }
  }
}
</script>