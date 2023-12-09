<template>
  <div :class="showHeroSection? 'hero hero-bg-color is-fullheight':''">
    <div class="hero-head">
      <nav class="navbar" style="background: #fff">
        <div class="container">
          <div class="navbar-brand">
            <router-link to="home" class="navbar-item">
              <LogoMini/>
            </router-link>
            <router-link to="home" class="navbar-item bd-navbar-item bd-navbar-item-base bd-navbar-item ">
              <span class="icon has-text-primary">
              </span><span>Home</span>
            </router-link>

            <router-link  to="pricing" class="navbar-item bd-navbar-item bd-navbar-item-base bd-navbar-item " href="#">
              <span class="icon has-text-primary">
              </span><span>Pricing</span>
            </router-link>

            <router-link  to="docs" class="navbar-item bd-navbar-item bd-navbar-item-base bd-navbar-item " href="#">
              <span class="icon has-text-primary">
              </span><span>Docs</span>
            </router-link>
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
    <div class="hero-body" v-if="showHeroSection">
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
        </div>
      </div>
    </div>
    <div v-else>
      <slot name="hero-section" ></slot>
    </div>
    <footer class="relative z-10 bg-white">
      <div class=" bg-dark-2 py-8  px-12 lg:mt-[60px]">
        <div class="max-w-7xl mx-auto">
          <div class="flex flex-wrap -mx-4">
            <div class="w-full px-4 md:w-1/3 lg:w-1/2">
              <div class="flex justify-center my-1 md:justify-start"><p class="text-base text-[#CACBCF]">© 2025
                Lambo HR All Rights Reserved</p></div>
            </div>
            <div class="w-full px-4 md:w-2/3 lg:w-1/2">
              <div class="my-1">
                <div class="flex flex-wrap items-center justify-center -mx-3 md:justify-end"><a
                    class="px-3 text-base text-[#CACBCF] hover:text-white" href="javascript:void(0)"> Privacy
                  policy </a><a class="px-3 text-base text-[#CACBCF] hover:text-white" href="javascript:void(0)">
                  Legal notice </a><a class="px-3 text-base text-[#CACBCF] hover:text-white"
                                      href="javascript:void(0)"> Terms of service </a></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer>
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
    },
    showHeroSection:{
      type: Boolean,
      default: true
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


