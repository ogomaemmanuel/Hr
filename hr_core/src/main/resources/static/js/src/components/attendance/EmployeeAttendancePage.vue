<template>
  <div>
    <div class="columns">
      <div class="column">
        <LastActivityCard></LastActivityCard>
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
    <PunchInForm
        @createSuccessful="handlePunchInSuccessful"
        @modalClosed="showPunchInForm=false"
        v-if="showPunchInForm"></PunchInForm>
  </div>
</template>
<script>
import PunchInForm from "./PunchInForm";
import AttendanceActivities from "./AttendanceActivities";
import LastActivityCard from "./LastActivityCard";
export default {
  components: {
    PunchInForm,
    LastActivityCard,
    AttendanceActivities
  },
  data() {
    return {
      lastActivity: null,
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


    getLastActivity() {
      axios.get("/api/attendance/last-activity").then(resp => {
        this.lastActivity = resp.data;
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
