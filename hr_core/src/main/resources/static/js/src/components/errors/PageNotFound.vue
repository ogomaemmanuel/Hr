<template>
  <Layout :padding="'1.5rem 4.5rem 4.5rem 4.5rem'" :show-hero-section="false">
    <template v-slot:hero-section>
      <div class="hero " style="height: 82vh">
        <div class="hero-body">
          <div class="container">
            <div class="text-center">
              <h1 class="title has-text-dark has-text-centered" style="">This page isn't available</h1>
              <h5>The link you followed may be broken, or the page may have been removed.</h5>
              <div class="flex m-2 justify-center">
                <img alt="page not found image" src="/images/undraw_not_found_60pq.svg" width="200px">
              </div>
              <button class="button is-success" @click="goBack()">Back</button>
            </div>
          </div>
        </div>
      </div>
    </template>
  </Layout>
</template>
<script>

import Layout from "../auth/Layout.vue";

export default {
  components: {
    Layout
  },
  methods: {
    goBack() {
      return this.$router.go(-1);
    }
  }
}
</script>
