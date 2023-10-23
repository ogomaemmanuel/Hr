<template>
  <ModalTemplate :has-padding="false" @modalClosed="$emit(`modalClosed`)">
    <div slot="modal-content">
      <div class="punch-in-header h-16 bg-green-800">
        <div class="flex justify-center relative">
          <figure class="image punch-in-user-profile-image is-64x64 absolute">
            <img src="/images/undraw_profile_pic_ic-5-t.svg" alt=""/>
          </figure>
        </div>

      </div>
      <template v-if="!showSuccessMessage">
        <div class="flex mt-5 flex-col items-center justify-center">
          <div>
            <h2>Emmanuel Ogoma</h2>
          </div>
          <div>
            <h2>Welcome!</h2>
          </div>
        </div>

        <div class="mt-5 pb-5">
          <div class="flex flex-col items-center justify-center">
            <i @click="punchIn" class="fa fa-sign-in fa-3x has-text-primary"></i>
            <h2> Click to Punch In</h2>
          </div>
        </div>
      </template>
      <template v-if="showSuccessMessage">
        <div class="flex mt-5 flex-col items-center justify-center">
          <div>
            <h2>Emmanuel Ogoma</h2>
          </div>
          <div>
            <h2>Welcome!</h2>
          </div>
          <div class="mt-5">
            Checked in at {{ attendance.attendanceTime.toLocaleTimeString() }}
          </div>
        </div>
        <div class="mt-5 pb-5">
          <div class="flex flex-col items-center justify-center">
            <button @click="$emit('createSuccessful')" class="button is-primary">OK</button>
          </div>
        </div>
      </template>

    </div>
  </ModalTemplate>
</template>
<script>
import common_mixin from "../../mixins/common_mixin";
import {Message} from "element-ui"
import ModalTemplate from "../common/ModalTemplate";


export default {
  components: {
    ModalTemplate,

  },
  mixins: [common_mixin],
  data() {
    return {
      showSuccessMessage: false,
      attendance: {
        type: "PUNCH_IN",
        attendanceTime: null
      },
    }
  },
  methods: {
    punchIn() {
      this.attendance.attendanceTime = new Date()
      axios.post("api/attendance/me", this.attendance).then(resp => {
        this.showSuccessMessage = true
        Message.success("Attendance created Successfully")
      }, error => {
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
      })
    }
  }
}
</script>
<style lang="scss" scoped>
.punch-in-user-profile-image {
  bottom: -5.5rem;;
}
</style>