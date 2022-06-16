<template>
  <div class="h-full">
    <div class="table-container h-full">
      <table class="table">
        <thead>
        <tr>
          <th>Employee</th>
          <template v-for="daysInMonth in 30">
            <th>{{ daysInMonth }}</th>
          </template>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(value, propertyName ) in attendanceData">
          <td>{{ value[0].fullName }}</td>
          <td v-for="day in 30">
            <i v-if="checkAttendance(day, value)" class="fa fa-check has-text-primary"></i>
            <i v-else class="fa fa-close has-text-danger"></i>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      attendanceData: {}
    }
  },
  created() {
    this.getAttendanceReport();
  },
  methods: {
    getAttendanceReport() {
      let vm = this;
      axios.get("/api/attendance/reports").then(resp => {
        vm.attendanceData = resp.data;
      })
    },

    checkAttendance(dayInMonth, attendanceList) {
      let vm = this;
      let result = attendanceList.find(x => vm.getDayFromDate(x.checkInTime) == dayInMonth);
      if (result) {
        return true
      }
      return false
    },
    getDayFromDate(dateString) {
      return (new Date(Date.parse(dateString))).getDate();
    }
  },
  computed: {}

}
</script>