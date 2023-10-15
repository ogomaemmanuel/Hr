<template>
  <div class="hero hero-bg-color is-fullheight">
    <div class="hero-head">
      <nav class="navbar" style="background: #fff">
        <div class="container">
          <div class="navbar-brand">
            <router-link to="home" class="navbar-item">
              <LogoMini/>
            </router-link>
            <a class="navbar-item bd-navbar-item bd-navbar-item-base bd-navbar-item " href="#">
              <span class="icon has-text-primary">
              </span><span>Home</span>
            </a>

            <a class="navbar-item bd-navbar-item bd-navbar-item-base bd-navbar-item " href="#">
              <span class="icon has-text-primary">
              </span><span>Pricing</span>
            </a>

            <a class="navbar-item bd-navbar-item bd-navbar-item-base bd-navbar-item " href="#">
              <span class="icon has-text-primary">
              </span><span>Docs</span>
            </a>
            <span class="navbar-burger burger" data-target="navbarMenuHeroA">
            <span></span>
            <span></span>
            <span></span>
          </span>
          </div>
          <div id="navbarMenuHeroA" class="navbar-menu">
            <div class="navbar-end">
              <span class="navbar-item">
                <router-link to="register" button @click.prevent="" class="button is-family-secondary is-inverted">
                    Sign up
                </router-link>
							</span>
              <span class="navbar-item">
                <router-link to="login" button @click.prevent="" class="button is-family-secondary is-inverted">
                    Log In
                </router-link>
							</span>
            </div>
          </div>
        </div>
      </nav>
    </div>
    <div class="hero-body">
      <div class="container">
        <div class="columns is-multiline">
          <div class="column is-12 is-offset-0 register">
            <div class="columns">
              <div class="column left" style="background-color: #271d3b;">
                <Logo/>
              </div>
              <div class="column right box" :style="{'padding' :padding+'!important'}">
                <slot name="auth-form" ></slot>
              </div>
            </div>
          </div>
          <div class="column is-8 is-offset-2">
            <br>
            <nav class="level">
              <div class="level-left">
                <div class="level-item">

                </div>
              </div>
              <div class="level-right">
                <small class="level-item" style="color: var(--textLight)">
                  &copy; Lambo HR. All Rights Reserved.
                </small>
              </div>
            </nav>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import CommonMixin from "../../mixins/common_mixin"
import Logo from "./Logos/Logo3.vue";
import LogoMini from "./Logos/LogoMini2.vue";

export default {
  props:{
    padding:{
      type:String,
      default:'4.5em'
    }
  },
  components: {LogoMini, Logo},
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

<style>
:root {
  --brandColor: hsl(166, 67%, 51%);
  --background: rgb(247, 247, 247);
  --textDark: hsla(0, 0%, 0%, 0.66);
  --textLight: hsla(0, 0%, 0%, 0.33);
}

body {
  background: var(--background);
  height: 100vh;
  color: var(--textDark);
}

.field:not(:last-child) {
  margin-bottom: 1rem;
}

.register {
//margin-top: 10rem; background: white;
  border-radius: 10px;
}

.left,
.right {
  padding: 4.5rem;
}

.left {
  border-right: 5px solid var(--background);
}

.left .title {
  font-weight: 800;
  letter-spacing: -2px;
}

.left .colored {
  color: var(--brandColor);
  font-weight: 500;
  margin-top: 1rem !important;
  letter-spacing: -1px;
}

.left p {
  color: var(--textLight);
  font-size: 1.15rem;
}

.right .title {
  font-weight: 800;
  letter-spacing: -1px;
}

.right .description {
  margin-top: 1rem;
  margin-bottom: 1rem !important;
  color: var(--textLight);
  font-size: 1.15rem;
}

.right small {
  color: var(--textLight);
}

input {
  font-size: 1rem;
}

input:focus {
  border-color: var(--brandColor) !important;
  box-shadow: 0 0 0 1px var(--brandColor) !important;
}

.fab,
.fas {
  color: var(--textLight);
  margin-right: 1rem;
}

.hero-bg-color {
  background: #f1f5f9;
}

</style>


