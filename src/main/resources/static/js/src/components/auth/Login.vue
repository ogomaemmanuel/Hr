<template>
    <div class="hero is-primary is-fullheight">
        <div class="hero-body">
            <div class="container">
                <div class="columns is-centered ">
                    <div class="column is-5-tablet is-4-desktop is-3-widescreen">
                        <form class="box">


                            <div class="field">
                                <label class="label">Email</label>
                                <div class="control has-icons-left">
                                    <input v-model="user.email" class="input" type="email"
                                           placeholder="e.g. alex@smith.com" required>
                                    <span class="icon is-small is-left">
    <i class="fa fa-envelope"></i>
  </span>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label">Password</label>
                                <div class="control has-icons-left">
                                    <input v-model="user.password" class="input" type="password" placeholder="********"
                                           required>
                                    <span class="icon is-small is-left">
      <i class="fa fa-lock"></i>
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
                                <button @click.prevent="login" class="button is-fullwidth is-success">
                                    Login
                                </button>
                            </div>

                            <div class="columns">
                                <div class="column">
                                    <div class="field">
                                        <router-link to="register" tag="button" button @click.prevent="" class="button">
                                            Sign up
                                        </router-link>
                                    </div>
                                </div>
                                <div class="column">
                                    <div class="field">
                                        <router-link tag="button" to="forgot-password" button @click.prevent=""
                                                     class="button is-text">
                                            Forgot password
                                        </router-link>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import CommonMixin from "../../mixins/common_mixin"

    export default {
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
                let request = this.createFormData(this.user);
                axios.post("/login", request).then(resp => {
                    window.location.replace("/")
                }, error => {
                    console.log(error.response.status);
                })
            }
        }
    }
</script>


