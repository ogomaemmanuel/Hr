<template>
  <div class="card h-60">
    <div class="card-content">
      <h2 class="font-bold">Today Activity</h2>
      <div v-for="activity in activities" class="attendance-activity mt-2 h-16 border-l-2 relative pl-2">
        <div>
          <p>{{ activity.type }}</p>
          <p><span><i class="fa fa-clock-o"></i></span> {{ convertToLocalTimeString(activity.attendanceTime) }}</p>
        </div>
        <div class="absolute dot">
          <span class="block h-2 w-2 rounded-full bg-gray-300"></span>
        </div>
      </div>
      <!--      <div class="attendance-activity mt-2 h-16 border-l-2 relative pl-2">-->
      <!--        <div>-->
      <!--          <p>Punch In at</p>-->
      <!--          <p><span><i class="fa fa-clock-o"></i></span> 10.00 AM.</p>-->
      <!--        </div>-->

      <!--        <div class="absolute dot">-->
      <!--          <span class="block h-2 w-2 rounded-full bg-gray-300"></span>-->
      <!--        </div>-->

      <!--      </div>-->
      <!--      <div class="attendance-activity mt-2 h-16 border-l-2 relative pl-2">-->
      <!--        <div>-->
      <!--          <p>Punch In at</p>-->
      <!--          <p><span><i class="fa fa-clock-o"></i></span> 10.00 AM.</p>-->
      <!--        </div>-->

      <!--        <div class="absolute dot">-->
      <!--          <span class="block h-2 w-2 rounded-full bg-gray-300"></span>-->
      <!--        </div>-->

      <!--      </div>-->
      <!--      <div class="attendance-activity mt-2 h-16 border-l-2 relative pl-2">-->
      <!--        <div>-->
      <!--          <p>Punch In at</p>-->
      <!--          <p><span><i class="fa fa-clock-o"></i></span> 10.00 AM.</p>-->
      <!--        </div>-->

      <!--        <div class="absolute dot">-->
      <!--          <span class="block h-2 w-2 rounded-full bg-gray-300"></span>-->
      <!--        </div>-->

      <!--      </div>-->
      <!--      <div class="attendance-activity mt-2 h-16 border-l-2 relative pl-2">-->
      <!--        <div>-->
      <!--          <p>Punch In at</p>-->
      <!--          <p><span><i class="fa fa-clock-o"></i></span> 10.00 AM.</p>-->
      <!--        </div>-->

      <!--        <div class="absolute dot">-->
      <!--          <span class="block h-2 w-2 rounded-full bg-gray-300"></span>-->
      <!--        </div>-->

      <!--      </div>-->
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      activities: []
    }
  },
  created() {
    this.getActivityForToday();
  },
  methods: {
    getActivityForToday() {
      //( new Date()).toTimeString()
      axios.get("/api/attendance/today-activity").then(resp => {
        this.activities = resp.data;
      })
    },
    convertToLocalTimeString(dateString) {
      if (dateString) {
        return new Date(Date.parse(dateString)).toLocaleTimeString();
      } else {
        return ""
      }
    }
  }
}
</script>
<style scoped lang="scss">
.dot {
  left: -5px;
  top: -7px;
}
</style>