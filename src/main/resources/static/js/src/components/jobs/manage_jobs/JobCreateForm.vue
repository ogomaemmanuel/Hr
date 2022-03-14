<template>
  <div>
    <div class="has-text-centered m-3">
      <h1 class="has-text-black"><b>Add Job</b></h1>
    </div>
    <form action="">
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Job Title</label>
            <div class="control">
              <input v-model="job.title" type="text" class="input">
            </div>
          </div>

        </div>
        <div class="column">
          <DepartmentSelectInput
              v-model="job.departmentId"></DepartmentSelectInput>
        </div>
      </div>

      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Job Location</label>
            <div class="control">
              <input v-model="job.location" type="text" class="input">
            </div>
          </div>

        </div>
        <div class="column">
          <div class="field">
            <label class="label">No of Vacancies</label>
            <div class="control">
              <input v-model="job.vacancies" type="text" class="input">
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Experience</label>
            <div class="control">
              <input v-model="job.experience" type="text" class="input">
            </div>
          </div>

        </div>
        <div class="column">
          <div class="field">
            <label class="label">Age</label>
            <div class="control">
              <input v-model="job.age" type="text" class="input">
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Salary From</label>
            <div class="control">
              <input v-model="job.minimumSalary" type="text" class="input">
            </div>
          </div>

        </div>
        <div class="column">
          <div class="field">
            <label class="label">Salary To</label>
            <div class="control">
              <input v-model="job.maximumSalary" type="text" class="input">
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Job Type</label>
            <div class="select is-fullwidth">
              <select v-model="job.type">
                <option value="Internship">Internship</option>
                <option value="Remote">Remote</option>
                <option value="PartTime">Part Time</option>
                <option value="FullTime">Full Time</option>
                <option value="Temporary">Temporary</option>
              </select>
            </div>
          </div>

        </div>
        <div class="column">
          <div class="field">
            <label class="label">Status</label>
            <div class="select is-fullwidth">
              <select v-model="job.status">
                <option value="Open">Open</option>
                <option value="Closed">Closed</option>
                <option value="Cancelled">Cancelled</option>
              </select>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Start Date</label>
            <div class="control">
              <DatePicker v-model="job.startDate"></DatePicker>
            </div>
          </div>

        </div>
        <div class="column">
          <div class="field">
            <label class="label">Expired Date</label>
            <div class="control">
              <DatePicker v-model="job.endDate"></DatePicker>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Description</label>
            <div class="control">
              <textarea v-model="job.description" class="textarea"></textarea>
            </div>
          </div>
        </div>
      </div>
      <div class="flex justify-center m-3">
        <button

            :class="{'is-loading':loading}"
            :disabled="disableSubmitButton"
            @click.prevent.stop="createJob"
            class="button  is-rounded"
            type="submit">Submit
        </button>
      </div>
    </form>
  </div>
</template>
<script>
import DepartmentSelectInput from "../../common/DepartmentSelectInput";
import {DatePicker, Message} from "element-ui"
import common_mixin from "../../../mixins/common_mixin";

export default {
  mixins: [common_mixin],
  components: {
    DepartmentSelectInput,
    DatePicker
  },
  data() {
    return {
      loading: false,
      job: {}
    }
  },
  methods: {
    createJob() {
      this.loading = true;
      axios.post("/api/jobs",
          this.job).then(resp => {
        this.loading = false;
        Message.success("Job successfully created");
        this.$emit("createSuccessful");

      }, error => {
        this.loading = false;
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
      })

    }
  },
  computed: {
    disableSubmitButton() {
      return this.loading
    }
  }

}
</script>