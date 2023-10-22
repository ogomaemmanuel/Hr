<template>
  <div class="card">
    <div class="card-header">
      <p class="card-header-title">
        <i class="fa fa-clock-o mr-2"></i>
        Time Clock
      </p>
    </div>
    <div class="card-content has-text-centered">
      <div>
        <p class="mb-5 is-7 subtitle ">Thursday, 23/10/2023</p>
        <p class="title is-5 mb-0 p-1">3:45PM</p>
        <p class="mt-2 is-7 subtitle ">Clocked Today: 0 Minutes</p>
      </div>

      <div class="flex justify-center mt-5">
        <button
            v-if="showPunchInButton"
            class="button primary"
            @click="showPunchInForm=true">Clock In
        </button>
        <button
            v-else
            class="button primary"
            @click="showPunchOutForm=true">Punch Out
        </button>
      </div>
    </div>
    <PunchInForm
        v-if="showPunchInForm"
        @createSuccessful="handlePunchInSuccessful"
        @modalClosed="showPunchInForm=false"></PunchInForm>
    <PunchOutForm
        v-if="showPunchOutForm"
        @createSuccessful="handlePunchOutSuccessful"
        @modalClosed="showPunchOutForm=false"></PunchOutForm>
  </div>

</template>
<script>
import PunchInForm from "./PunchInForm";
import PunchOutForm from "./PunchOutForm";

export default {
  components: {
    PunchInForm,
    PunchOutForm
  },
  data() {
    return {
      showPunchOutForm: false,
      showPunchInForm: false,
      lastActivity: {
        punchInTime: null,
        punchOutTime: null,

      }
    }
  },
  created() {
    this.getLastActivity();
  },
  methods: {
    getLastActivity() {
      let vm = this;
      axios.get("/api/attendance/last-activity").then(resp => {
        this.lastActivity = {...vm.lastActivity, ...resp.data};
      })
    },
    handlePunchInSuccessful() {
      this.showPunchInForm = false;
      this.getLastActivity();
    },
    handlePunchOutSuccessful() {
      this.showPunchOutForm = false;
      this.getLastActivity();
    }


  },
  computed: {
    showPunchInButton() {
      if (this.lastActivity.punchInTime && this.lastActivity.punchOutTime) {
        return Date.parse(this.lastActivity.punchInTime) < Date.parse(this.lastActivity.punchOutTime)
      }
      if (this.lastActivity.punchInTime) {
        return false;
      }
      return true;
    }

  }
}
</script>