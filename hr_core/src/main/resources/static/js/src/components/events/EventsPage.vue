<template>
  <div>
    <div class="pb-2 flex justify-end">
      <button
          @click.stop="showEventCreateForm=true"
          to="/holiday-create"
          tag="button"
          class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add Event
				</span>
      </button>
    </div>
    <div>
      <EventCreateForm v-if="showEventCreateForm"></EventCreateForm>
    </div>
    <calendar-view
        :show-date="showDate"
        class="theme-default holiday-us-traditional holiday-us-official">
      <template #header="{ headerProps }">
        <calendar-view-header
            :header-props="headerProps"
            @input="setShowDate"/>
      </template>
    </calendar-view>
  </div>
</template>
<script>
import {CalendarView, CalendarViewHeader} from "vue-simple-calendar";
import EventCreateForm from "./EventCreateForm";

export default {
  components: {
    CalendarView,
    CalendarViewHeader,
    EventCreateForm
  },
  data() {
    return {
      showEventCreateForm: false,
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