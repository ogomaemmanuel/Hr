<template>
  <div>
    <div class="pb-2 flex justify-end">
      <router-link
          to="/holiday-create"
          tag="button"
          class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add Event
				</span>
      </router-link>
    </div>
    <calendar-view
        :show-date="showDate"
        class="theme-default holiday-us-traditional holiday-us-official">
      <template #header="{ headerProps }">
        <calendar-view-header
            :header-props="headerProps"
            @input="setShowDate" />
      </template>
    </calendar-view>
  </div>
</template>
<script>
import {CalendarView,CalendarViewHeader} from "vue-simple-calendar";
export default {
  components:{
    CalendarView,
    CalendarViewHeader,
  },
  data() {
    return {
      showDate: new Date(),
      events: []
    }

  },
  created() {
    this.getEvents();
  },
  methods: {
    setShowDate(d) {
      this.showDate = d;
    },
    getEvents() {
      axios.get("api/events").then(resp => {
        this.events = resp.data;
      })
    }
  }
}
</script>
<style scoped lang="scss">

</style>