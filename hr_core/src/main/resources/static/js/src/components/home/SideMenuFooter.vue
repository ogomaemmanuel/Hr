<template>
  <div class=" left-0 justify-center hidden w-full space-x-4 lg:flex dark:bg-gray-800">
    <router-link
        class="inline-flex vsm--link vsm--link_level-1 justify-center p-2 text-gray-200 rounded cursor-pointer dark:hover:text-white"
        to="/profile">
      <svg class="flex-shrink-0 w-6 h-6 transition text-white duration-75 dark:text-gray-400 dark:group-hover:text-white"
           fill="#ffffff"
           height="800px" viewBox="0 0 24 24" width="800px" xmlns="http://www.w3.org/2000/svg">
        <path
            d="M15.71,12.71a6,6,0,1,0-7.42,0,10,10,0,0,0-6.22,8.18,1,1,0,0,0,2,.22,8,8,0,0,1,15.9,0,1,1,0,0,0,1,.89h.11a1,1,0,0,0,.88-1.1A10,10,0,0,0,15.71,12.71ZM12,12a4,4,0,1,1,4-4A4,4,0,0,1,12,12Z"/>
      </svg>
    </router-link>
    <router-link
        class="inline-flex vsm--link vsm--link_level-1 justify-center p-2 text-gray-200 rounded cursor-pointer hover:text-gray-900  dark:hover:bg-gray-700 dark:hover:text-white"
        data-tooltip-target="tooltip-settings"
        title="Settings"
        to="/profile">
      <svg class="flex-shrink-0 w-6 h-6 transition duration-75 dark:text-gray-400 dark:group-hover:text-white"
           height="80"
           fill="#ffffff"
           viewBox="0 0 102.4 102.4" width="80" xmlns="http://www.w3.org/2000/svg">
        <path
            d="M60.07 6.4a3.2 3.2 0 0 1 3.046 2.221l3.52 10.938a34.798 34.798 0 0 1 4.243 2.451l11.238-2.419a3.2 3.2 0 0 1 3.443 1.536l8.872 15.353a3.2 3.2 0 0 1-.403 3.75l-7.712 8.512a35.712 35.712 0 0 1 0 4.902l7.712 8.525a3.2 3.2 0 0 1 .403 3.75l-8.87 15.36a3.2 3.2 0 0 1-3.443 1.53L70.88 80.39a35.523 35.523 0 0 1-4.237 2.451l-3.526 10.938A3.2 3.2 0 0 1 60.07 96H42.33a3.2 3.2 0 0 1-3.046-2.221L35.77 82.848a35.162 35.162 0 0 1-4.256-2.464L20.282 82.81a3.2 3.2 0 0 1-3.443-1.536L7.968 65.92a3.2 3.2 0 0 1 .403-3.75l7.712-8.525a35.712 35.712 0 0 1 0-4.89L8.371 40.23a3.2 3.2 0 0 1-.403-3.75l8.87-15.36a3.2 3.2 0 0 1 3.443-1.53l11.232 2.426a35.59 35.59 0 0 1 4.256-2.464l3.52-10.931A3.2 3.2 0 0 1 42.323 6.4h17.741zm-2.342 6.4H44.672l-3.635 11.309-2.451 1.197a29.411 29.411 0 0 0-3.482 2.01l-2.266 1.536-11.622-2.509-6.528 11.315 7.968 8.819-.192 2.714a29.312 29.312 0 0 0 0 4.019l.192 2.714-7.981 8.819 6.534 11.315 11.622-2.502 2.266 1.53a29.411 29.411 0 0 0 3.482 2.01l2.451 1.197L44.672 89.6h13.069l3.648-11.315 2.445-1.19a28.828 28.828 0 0 0 3.475-2.01l2.259-1.53 11.629 2.502 6.528-11.315-7.974-8.819.192-2.714a29.312 29.312 0 0 0 0-4.026l-.192-2.714 7.981-8.813-6.534-11.315-11.629 2.496-2.259-1.523a28.762 28.762 0 0 0-3.475-2.01l-2.445-1.19L57.734 12.8zM51.2 32a19.2 19.2 0 1 1 0 38.4 19.2 19.2 0 0 1 0-38.4zm0 6.4a12.8 12.8 0 1 0 0 25.6 12.8 12.8 0 0 0 0-25.6z"/>
      </svg>
    </router-link>
    <router-link
        class="inline-flex vsm--link vsm--link_level-1 justify-center p-2 text-gray-500 rounded cursor-pointer hover:text-gray-900 dark:hover:bg-gray-700 dark:hover:text-white"
        title="Logout"
        to="#">
      <LogoutForm></LogoutForm>
    </router-link>
  </div>
</template>
<script>
import LogoutForm from "../auth/LogoutForm.vue"

export default {
  components: {
    LogoutForm
  }
}

</script>