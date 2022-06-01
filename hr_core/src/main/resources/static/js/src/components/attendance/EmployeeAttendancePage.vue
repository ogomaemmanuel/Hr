<template>
  <div>
    <div class="columns">
      <div class="column">
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
              <button @click="showPunchInForm=true"
                      class="button primary">Punch In
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
        </div>
      </div>
      <div class="column">
        <div class="card">
          <div class="card-content">
            <h2 class="font-bold">Statistics</h2>

            <div class="card mt-3 h-16">
              <div class="card-content">

              </div>
            </div>
            <div class="card mt-2 h-16">
              <div class="card-content">

              </div>
            </div>
            <div class="card mt-2 h-16">
              <div class="card-content">

              </div>
            </div>
            <div class="card mt-2 h-16">
              <div class="card-content">

              </div>
            </div>
            <div class="card mt-2 h-16">
              <div class="card-content">

              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="column">
        <AttendanceActivities></AttendanceActivities>
      </div>
    </div>

    <table class="table is-fullwidth">
      <thead>
      <tr>
        <td>Date</td>
        <td>Punch In</td>
        <td>Punch Out</td>
        <td>Production</td>
        <td>Break</td>
        <td>Overtime</td>
      </tr>
      </thead>

    </table>
    <PunchINForm
        @createSuccessful="handlePunchInSuccessful"
        @modalClosed="showPunchInForm=false"
        v-if="showPunchInForm"></PunchINForm>
  </div>
</template>
<script>
import PunchINForm from "./PunchINForm";
import AttendanceActivities from "./AttendanceActivities";

export default {
  components: {
    PunchINForm,
    AttendanceActivities
  },
  data() {
    return {
      showPunchInForm: false,
      attendance: [],
      activities: [],
    }
  },
  methods: {
    getAttendance() {
      axios.get("/api/attendance").then(resp => {
        this.attendance = resp.data.content;
      })
    },

    getActivityForToday() {
      axios.get("/api/attendance/today-activity").then(resp => {
        this.activities = resp.data;
      })
    },
    handlePunchInSuccessful() {
      this.showPunchInForm = false;
      this.getAttendance();
    }

  }
}
</script>
