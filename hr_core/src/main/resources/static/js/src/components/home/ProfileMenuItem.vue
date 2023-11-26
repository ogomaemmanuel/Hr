<template>
  <div class="flex justify-between w-full py-1">
    <LogoMini style="color: #FFFFFF; float: left"  />
    <div class="flex flex-col ">
      <div class="truncate">{{ authenticatedUser.fullName }}</div>
    </div>
    <i class="fa fa-chevron-down" aria-hidden="true"></i>
  </div>
</template>
<script>
import {mapGetters} from "vuex";
import LogoMini from "../auth/Logos/LogoMain.vue";


export default {
  components: {
    LogoMini
  },
  data(){
    return{

    }
  },
  computed: {
    ...mapGetters(["authenticatedUser"])
  },
}
</script>