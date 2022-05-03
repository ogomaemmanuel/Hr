<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-black"><b>Add Event</b></h1>
        </div>
        <div class="field">
          <label class="label">Name<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="calenderEvent.title"
                @input="clearFieldError('title')"
                class="input"
                type="text">
            <span class="mb-2 has-text-danger" v-if="errors['title']">
						{{ errors['title'][0] }}
					</span>
          </div>
        </div>
        <label class="label">Start Date<span><sup>*</sup></span></label>
        <DatePicker
            class="datepicker"
            value-format="timestamp"
            v-model="calenderEvent.startDate"
            type="datetime">

        </DatePicker>
        <label class="label">End Date<span><sup>*</sup></span></label>
        <DatePicker
            value-format="timestamp"
            class="datepicker"
            v-model="calenderEvent.endDate"
            type="datetime">
        </DatePicker>
        <div class="flex justify-center m-3">
          <button
              :class="{'is-loading':loading}"
              :disabled="disableSubmitButton"
              @click.prevent.stop="createEvent"
              class="button  is-rounded"
              type="submit">Submit
          </button>
        </div>
      </form>
    </div>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../common/ModalTemplate";
import common_mixin from "../../mixins/common_mixin";
import {DatePicker} from "element-ui"
import {Message} from "element-ui";

export default {
  mixins: [common_mixin],
  components: {
    ModalTemplate,
    DatePicker
  },
  data() {
    return {
      loading: false,
      calenderEvent: {
        title: "",
        startDate: null,
        endDate: null
      }
    }
  },
  methods: {
    createEvent() {
      axios.post("/api/events",
          this.calenderEvent).then(resp => {
        Message.success("Event successfully created");
        this.$emit("createSuccessful");
      }, error => {
        if (error.response.status == 400) {
          this.errors = error.response.data;

        }
      })
    }
  },
  computed: {
    disableSubmitButton() {
      return false;
    }
  }
}
</script>
<style lang="scss" scoped>
.datepicker {
  min-width: 100%;
}
</style>