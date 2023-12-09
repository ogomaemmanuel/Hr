<template>
  <Layout :padding="'1.5rem 4.5rem 4.5rem 4.5rem'" :show-hero-section="false">
    <template v-slot:hero-section>
      <div class="relative bg-white h-full lg:pt-[150px]"
           style="background-color: rgb(39, 29, 59);">

        <section
            class="relative z-20 overflow-hidden  dark:bg-dark dark:bg-dark-2 pt-20 pb-12 lg:pt-[120px] lg:pb-[90px]">
          <div class="container mx-auto">
            <div class="flex flex-wrap -mx-4">
              <div class="w-full px-4">
                <div class="mx-auto mb-[60px] max-w-[510px] text-center">
                  <h2 class="mb-4 text-3xl leading-[1.208] font-bold text-white dark:text-white sm:text-4xl md:text-[40px]">
                    Our Pricing Plan </h2>
                  <p class="text-base text-white pb-8 dark:text-dark-6"> There are many variations of passages of Lorem Ipsum
                    available but the majority have suffered alteration in some form. </p></div>
              </div>
            </div>
            <div class="flex flex-wrap justify-center -mx-4">
              <div class="w-full px-4 md:w-1/2 lg:w-1/3">
                <div
                    class="relative z-10 px-8 py-10 mb-10 overflow-hidden text-center bg-white rounded-xl dark:bg-dark-3 shadow-pricing-5 sm:p-12 lg:py-10 lg:px-6 xl:p-14">
                  <span class="block mb-4 text-xl font-medium text-dark dark:text-white"> Starter </span>
                  <h2 class="mb-10 xl:mb-[50px] text-4xl font-semibold text-dark dark:text-white xl:leading-[1.24] xl:text-[42px]">
                    <sup class="text-xl font-medium -top-5">$</sup><span class="px-0.5">25</span><span
                      class="text-base text-body-color dark:text-dark-6"> Month </span></h2>
                  <div class="mb-11 space-y-[14px]"><p class="text-base text-body-color dark:text-dark-6"> Core UI
                    Components </p>
                    <p class="text-base text-body-color dark:text-dark-6"> Use on Unlimited Projects </p>
                    <p class="text-base text-body-color dark:text-dark-6"> Personal and Commercial Use </p>
                    <p class="text-base text-body-color dark:text-dark-6"> Lifetime Free Updates </p>
                    <p class="text-base text-body-color dark:text-dark-6"> Figma Source File </p></div>
                  <a class="inline-block rounded-md bg-secondary py-4 px-8 mt-4 text-center text-base font-medium text-white transition hover:bg-opacity-90"
                     href="javascript:void(0)"> Purchase Now </a>

                </div>
              </div>
              <div class="w-full px-4 md:w-1/2 lg:w-1/3">
                <div
                    class="relative z-10 px-8 py-10 mb-10 overflow-hidden text-center bg-white rounded-xl dark:bg-dark-3 shadow-pricing-5 sm:p-12 lg:py-10 lg:px-6 xl:p-14">
                  <span class="block mb-4 text-xl font-medium text-dark dark:text-white"> Business </span>
                  <h2 class="mb-10 xl:mb-[50px] text-4xl font-semibold text-dark dark:text-white xl:leading-[1.24] xl:text-[42px]">
                    <sup class="text-xl font-medium -top-5">$</sup><span class="px-0.5">59</span><span
                      class="text-base text-body-color dark:text-dark-6"> Month </span></h2>
                  <div class="mb-11 space-y-[14px]"><p class="text-base text-body-color dark:text-dark-6"> Core UI
                    Components </p>
                    <p class="text-base text-body-color dark:text-dark-6"> Use on Unlimited Projects </p>
                    <p class="text-base text-body-color dark:text-dark-6"> Personal and Commercial Use </p>
                    <p class="text-base text-body-color dark:text-dark-6"> Lifetime Free Updates </p>
                    <p class="text-base text-body-color dark:text-dark-6"> Figma Source File </p></div>
                  <a class="inline-block rounded-md bg-primary py-4 px-8 mt-4 text-center text-base font-medium text-white transition hover:bg-opacity-90"
                     href="javascript:void(0)"> Purchase Now </a>
                </div>
              </div>
              <div class="w-full px-4 md:w-1/2 lg:w-1/3">
                <div
                    class="relative z-10 px-8 py-10 mb-10 overflow-hidden text-center bg-white rounded-xl dark:bg-dark-3 shadow-pricing-5 sm:p-12 lg:py-10 lg:px-6 xl:p-14">
                  <span class="block mb-4 text-xl font-medium text-dark dark:text-white"> Extended </span>
                  <h2 class="mb-10 xl:mb-[50px] text-4xl font-semibold text-dark dark:text-white xl:leading-[1.24] xl:text-[42px]">
                    <sup class="text-xl font-medium -top-5">$</sup><span class="px-0.5">199</span><span
                      class="text-base text-body-color dark:text-dark-6"> Month </span></h2>
                  <div class="mb-11 space-y-[14px]"><p class="text-base text-body-color dark:text-dark-6"> Core UI
                    Components </p>
                    <p class="text-base text-body-color dark:text-dark-6"> Use on Unlimited Projects </p>
                    <p class="text-base text-body-color dark:text-dark-6"> Personal and Commercial Use </p>
                    <p class="text-base text-body-color dark:text-dark-6"> Lifetime Free Updates </p>
                    <p class="text-base text-body-color dark:text-dark-6"> Figma Source File </p></div>
                  <a class="inline-block rounded-md bg-dark py-4 px-8 mt-4 text-center text-base font-medium text-white transition hover:bg-opacity-90"
                     href="javascript:void(0)"> Purchase Now </a>
                </div>
              </div>
            </div>
          </div>
        </section>

      </div>
    </template>
  </Layout>
</template>
<script>
import Layout from "./Layout.vue";

export default {
  components: {
    Layout
  },
  data() {
    return {
      isLoading: false,

    }
  },
  methods: {}
}
</script>
<style>
.bg-primary {
  --tw-bg-opacity: 1;
  background-color: rgb(55 88 249 / var(--tw-bg-opacity));
}
.bg-secondary {
  --tw-bg-opacity: 1;
  background-color: rgb(19 194 150 / var(--tw-bg-opacity));
}
.bg-primary {
  --tw-bg-opacity: 1;
  background-color: rgb(55 88 249 / var(--tw-bg-opacity));
}
.bg-dark {
  --tw-bg-opacity: 1;
  background-color: rgb(17 25 40 / var(--tw-bg-opacity));
}
.text-base {
  font-size: 1rem;
  line-height: 1.5rem;
}
.shadow-pricing-5 {

  --tw-shadow: 0px 10px 25px 0px rgba(0, 0, 0, .08);
  --tw-shadow-colored: 0px 10px 25px 0px var(--tw-shadow-color);
  box-shadow: var(--tw-ring-offset-shadow, 0 0 #0000),var(--tw-ring-shadow, 0 0 #0000),var(--tw-shadow);
}
</style>