<template>
  <div class=" left-0 justify-center hidden w-full space-x-4 lg:flex dark:bg-gray-800">
    <router-link
        class="inline-flex vsm--link vsm--link_level-1 justify-center p-2 text-gray-200 rounded cursor-pointer dark:hover:text-white"
        to="/profile">
      <svg fill="#ffffff"  class="flex-shrink-0 w-6 h-6 transition text-white duration-75 dark:text-gray-400 dark:group-hover:text-white" width="800px" height="800px" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M15.71,12.71a6,6,0,1,0-7.42,0,10,10,0,0,0-6.22,8.18,1,1,0,0,0,2,.22,8,8,0,0,1,15.9,0,1,1,0,0,0,1,.89h.11a1,1,0,0,0,.88-1.1A10,10,0,0,0,15.71,12.71ZM12,12a4,4,0,1,1,4-4A4,4,0,0,1,12,12Z"/></svg>
    </router-link>
    <router-link
        title="Settings"
        class="inline-flex vsm--link vsm--link_level-1 justify-center p-2 text-gray-200 rounded cursor-pointer hover:text-gray-900  dark:hover:bg-gray-700 dark:hover:text-white"
        data-tooltip-target="tooltip-settings"
        to="/profile">
      <svg
          class="flex-shrink-0 w-6 h-6 transition duration-75 dark:text-gray-400 dark:group-hover:text-white"
          fill="currentColor" height="24" viewBox="0 -960 960 960" width="24" xmlns="http://www.w3.org/2000/svg">
        <path
            d="m370-80-16-128q-13-5-24.5-12T307-235l-119 50L78-375l103-78q-1-7-1-13.5v-27q0-6.5 1-13.5L78-585l110-190 119 50q11-8 23-15t24-12l16-128h220l16 128q13 5 24.5 12t22.5 15l119-50 110 190-103 78q1 7 1 13.5v27q0 6.5-2 13.5l103 78-110 190-118-50q-11 8-23 15t-24 12L590-80H370Zm70-80h79l14-106q31-8 57.5-23.5T639-327l99 41 39-68-86-65q5-14 7-29.5t2-31.5q0-16-2-31.5t-7-29.5l86-65-39-68-99 42q-22-23-48.5-38.5T533-694l-13-106h-79l-14 106q-31 8-57.5 23.5T321-633l-99-41-39 68 86 64q-5 15-7 30t-2 32q0 16 2 31t7 30l-86 65 39 68 99-42q22 23 48.5 38.5T427-266l13 106Zm42-180q58 0 99-41t41-99q0-58-41-99t-99-41q-59 0-99.5 41T342-480q0 58 40.5 99t99.5 41Zm-2-140Z"></path>
      </svg>
    </router-link>
    <router-link
        title="Logout"
        class="inline-flex vsm--link vsm--link_level-1 justify-center p-2 text-gray-500 rounded cursor-pointer hover:text-gray-900 dark:hover:bg-gray-700 dark:hover:text-white"
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