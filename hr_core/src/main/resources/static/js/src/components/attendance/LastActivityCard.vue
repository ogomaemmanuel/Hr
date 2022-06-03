<template>
  <div class="card">
    <div class="card-content">
      <h2>Timesheet 11 Mar 2019</h2>
      <div>
        <div class="flex mt-5 justify-center p-2 bg-gray-100">
          <div>
            <h2 class="font-bold">Punch In at</h2>
            <h2>Wed, 11th Mar 2019 10.00 AM</h2>
          </div>
        </div>
      </div>
      <div class="flex mt-5 justify-center items-center">
        <div class="flex  border-gray-200
              border-2
              h-24
               w-24 rounded-full bg-gray-100 items-center justify-center">
          <h2>3.45 hrs</h2>
        </div>
      </div>

      <div class="flex justify-center mt-5">
        <button
            v-if="showPunchInButton"
            @click="showPunchInForm=true"
            class="button primary">Punch In
        </button>
        <button
            v-else
            @click="showPunchOutForm=true"
            class="button primary">Punch Out
        </button>
      </div>
      <div class="flex justify-between mt-8">
        <div class="flex items-center justify-center h-8 bg-gray-200 pb-5 pt-5 pl-10 pr-10">
          <h2>Break</h2>
        </div>
        <div class="flex items-center justify-center h-8 bg-gray-200 pb-5 pt-5 pl-10 pr-10">
          <h2>Overtime</h2>
        </div>
      </div>
    </div>
    <PunchInForm
        @createSuccessful="handlePunchInSuccessful"
        @modalClosed="showPunchInForm=false"
        v-if="showPunchInForm"></PunchInForm>
    <PunchOutForm
        @createSuccessful="handlePunchOutSuccessful"
        @modalClosed="showPunchOutForm=false"
        v-if="showPunchOutForm"></PunchOutForm>
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