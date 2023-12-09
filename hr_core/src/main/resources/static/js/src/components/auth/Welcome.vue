<template>
  <Layout :padding="'1.5rem 4.5rem 4.5rem 4.5rem'" :show-hero-section="false">
    <template v-slot:hero-section>
      <div class="relative bg-white pt-32 pb-32 dark:bg-dark lg:pt-[150px]" style="background-color: rgb(39, 29, 59);">
        <div class="container mx-auto">
          <div class="-mx-4 flex flex-wrap items-center">
            <div class="w-full px-4 lg:w-5/12">
              <div class="hero-content">
                <h1 class="mb-5 text-4xl font-bold !leading-[1.208] text-white dark:text-white sm:text-[42px] lg:text-[40px] xl:text-5xl">
                  The Greatest <br>
                  Journey Of Talent <br>
                  Thrive.
                </h1>
                <p class="mb-8 max-w-[480px] text-white text-body-color dark:text-dark-6">
                  With Lambo-HR, business can cost-effectively outsource the management of payroll,
                  workers’ compensation, human resources, HR Data & Analytics,
                  and employee benefits with an easy transition.
                </p>
                <ul class="flex flex-wrap items-center">
                  <li>
                    <a class="inline-flex items-center justify-center rounded-md bg-primary px-6 py-3 text-center text-base font-medium text-white hover:bg-blue-dark lg:px-7"
                       href="javascript:void(0)">
                      Get Started
                    </a>
                  </li>
                  <li>
                    <a class="inline-flex items-center justify-center px-5 py-3 text-center text-white font-medium text-[#464646] hover:text-primary dark:text-white"
                       href="javascript:void(0)">
                    <span class="mr-2">
                      <svg fill="none" height="25" viewBox="0 0 24 25" width="24" xmlns="http://www.w3.org/2000/svg">
                        <circle cx="12" cy="12.6152" fill="#3758F9" r="12"></circle>
                        <rect fill="white" height="1.63636" width="8.18182" x="7.99893" y="14.979"></rect>
                        <rect fill="white" height="4.09091" width="1.63636" x="11.2717" y="7.61523"></rect>
                        <path d="M12.0898 14.1606L14.9241 11.0925H9.25557L12.0898 14.1606Z" fill="white"></path>
                      </svg>
                    </span>
                      Download App
                    </a>
                  </li>
                </ul>
                <div class="clients pt-16">
                  <h6 class="mb-6 flex items-center text-xs font-normal text-white dark:text-dark-6">
                    Some Of Our Clients
                    <span class="ml-3 inline-block h-px w-8 bg-body-color"></span>
                  </h6>
                  <div class="flex items-center gap-4 xl:gap-[50px]">
                    <a class="block py-3" href="javascript:void(0)">
                      <img alt="oracle" src="../assets/images/brands/oracle.svg">
                    </a>
                    <a class="block py-3" href="javascript:void(0)">
                      <img alt="intel" src="../assets/images/brands/intel.svg">
                    </a>
                    <a class="block py-3" href="javascript:void(0)">
                      <img alt="logitech" src="../assets/images/brands/logitech.svg">
                    </a>
                  </div>
                </div>
              </div>
            </div>
            <div class="hidden px-4 lg:block lg:w-1/12"></div>
            <div class="w-full px-4 lg:w-6/12">
              <div class="lg:ml-auto lg:text-right">
                <div class="relative z-10 inline-block pt-11 lg:pt-0">
                  <img alt="hero" class="max-w-full lg:ml-auto" src="../assets/images/hero/hero-image-01.png">
                  <span class="absolute -bottom-8 -left-8 z-[-1]">
                  <svg fill="none" height="93" viewBox="0 0 93 93" width="93" xmlns="http://www.w3.org/2000/svg">
                    <circle cx="2.5" cy="2.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="2.5" cy="24.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="2.5" cy="46.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="2.5" cy="68.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="2.5" cy="90.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="24.5" cy="2.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="24.5" cy="24.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="24.5" cy="46.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="24.5" cy="68.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="24.5" cy="90.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="46.5" cy="2.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="46.5" cy="24.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="46.5" cy="46.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="46.5" cy="68.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="46.5" cy="90.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="68.5" cy="2.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="68.5" cy="24.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="68.5" cy="46.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="68.5" cy="68.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="68.5" cy="90.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="90.5" cy="2.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="90.5" cy="24.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="90.5" cy="46.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="90.5" cy="68.5" fill="#3056D3" r="2.5"></circle>
                    <circle cx="90.5" cy="90.5" fill="#3056D3" r="2.5"></circle>
                  </svg>
                </span>
                </div>
              </div>
            </div>
          </div>
        </div>
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
</style>