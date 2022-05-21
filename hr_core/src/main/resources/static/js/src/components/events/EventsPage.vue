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
      <EventCreateForm
          @createSuccessful="createSuccessful"
          v-if="showEventCreateForm"></EventCreateForm>
    </div>
    <div class="flex flex-col flex-grow">
      <calendar-view
          :items="events"
          :show-date="showDate"
          class="theme-default holiday-us-traditional holiday-us-official">
<!--        <template #header="{ headerProps }">-->
          <calendar-view-header
              slot="header"
              slot-scope="t"
              :header-props="t.headerProps"
              @input="setShowDate"
              />
<!--        </template>-->
      </calendar-view>
    </div>
  </div>
</template>
<script>
import {CalendarView,CalendarViewHeader } from "vue-simple-calendar";
import EventCreateForm from "./EventCreateForm";
import "vue-simple-calendar/static/css/default.css"
import "vue-simple-calendar/static/css/gcal.css"
import "vue-simple-calendar/static/css/holidays-us.css"
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
    },
    createSuccessful() {
      this.showEventCreateForm = false;
      this.getEvents();
    }

  }
}
</script>
<style  scoped lang="scss">
//@import "../../../node_modules/vue-simple-calendar";
</style>