<template>
  <Layout>
    <template v-slot:auth-form>
      <h1 class="title has-text-dark has-text-centered" style="">Welcome Back.</h1>
      <p class="mb-8 has-text-left"> Login with social media or your credentials </p>
      <form class="box">
        <div class="field">
          <label class="label">Email</label>
          <div class="control has-icons-left">
            <input v-model="user.email" class="input has-text-left" placeholder="e.g. didinkaj@lambo-hr.com"
                   required type="email">
            <span class="icon is-small is-left">
              <i class="fa fa-envelope"></i>
            </span>
            <span v-if="errors['email']" class="has-text-danger">
              {{ errors['email'][0] }}
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
            <span v-if="errors['password']" class="has-text-danger">
              {{ errors['password'][0] }}
            </span>
          </div>
        </div>

        <div class="field">
          <label class="checkbox">
            <input type="checkbox">
            Remember me
          </label>
        </div>

        <div class="field">
          <button class="button is-fullwidth is-success" @click.prevent="login">
            Login
          </button>
          <span v-if="errors['msg']" class="has-text-danger">
            {{ errors['msg'] }}
          </span>
        </div>

        <div class="columns">
          <div class="column">
            <div class="field has-text-right">
              <router-link button class="button is-text has-text-right" tag="button" to="forgot-password"
                           @click.prevent="">
                Forgot password?
              </router-link>
              <router-link button class="button is-text has-text-right" tag="button" to="register"
                           @click.prevent="">
                Or Sign Up
              </router-link>
            </div>
          </div>
        </div>
      </form>
    </template>
  </Layout>
</template>
<script>
import CommonMixin from "../../mixins/common_mixin"
import Logo from "./Logos/Logo3.vue";
import LogoMini from "./Logos/LogoMini2.vue";
import Layout from "./Layout.vue";
import {Notification} from "element-ui";

export default {
  components: {Layout, LogoMini, Logo},
  mixins: [
    CommonMixin
  ],
  data() {
    return {
      user: {}
    }
  },
  methods: {
    login() {
      let vm = this;
      let request = this.createFormData(this.user);
      axios.post("/login", request).then(resp => {
        Notification.success(resp.data);
        window.location.replace("/")
      }, error => {
        if (error.response.status === 400) {
          vm.errors = error.response.data;
        }
        console.log(error.response.status);
      })
    }
  }
}
</script>



