<template>
  <Layout>
    <template v-slot:auth-form>
      <h1 class="title has-text-dark has-text-centered" style="">Forgot Password.</h1>
      <p class="mb-8 has-text-left "> An Email with password reset link will be sent to the email you used during
        registration </p>
      <form class="box">
        <div class="field">
          <label class="label">Email</label>
          <div class="control has-icons-left">
            <input v-model="forgotPasswordRequest.email"
                   class="input has-text-left"
                   placeholder="e.g. didinkaj@lambo-hr.com"
                   @input="clearFieldError('email')"
                   required type="email">
                  <span class="icon is-small is-left">
                    <i class="fa fa-envelope"></i>
                  </span>
                  <span v-if="errors['email']" class="has-text-danger">
                      {{ errors['email'][0] }}
                  </span>
          </div>
        </div>
        <div class="field mt-8">
          <div class="control is-block">
            <button :class="{'is-loading':isLoading}" class="button  is-fullwidth is-success"
                    @click.prevent="submitRequest">
              Reset
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
import CommonMixin from "../../mixins/common_mixin.js"
import Layout from "./Layout.vue";

export default {
  mixins: [
    CommonMixin
  ],
  components: {
    Layout
  },
  data() {
    return {
      isLoading: false,
      forgotPasswordRequest: {}
    }
  }
  ,
  methods: {
    submitRequest() {
      let vm = this;
      vm.isLoading = true,
          axios.post("/forgot-password", vm.forgotPasswordRequest).then(resp => {
            vm.isLoading = false
            Notification.success(resp.data);
          }, error => {
            vm.isLoading = false
            if (error.response.status == 400) {
              vm.errors = error.response.data;
            }
          })
    }
  }
}
</script>