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
              <input type="text" class="input">
            </div>
          </div>

        </div>
        <div class="column">
          <DepartmentSelectInput></DepartmentSelectInput>
        </div>
      </div>

      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Job Location</label>
            <div class="control">
              <input type="text" class="input">
            </div>
          </div>

        </div>
        <div class="column">
          <div class="field">
            <label class="label">No of Vacancies</label>
            <div class="control">
              <input type="text" class="input">
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Experience</label>
            <div class="control">
              <input type="text" class="input">
            </div>
          </div>

        </div>
        <div class="column">
          <div class="field">
            <label class="label">Age</label>
            <div class="control">
              <input type="text" class="input">
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Salary From</label>
            <div class="control">
              <input type="text" class="input">
            </div>
          </div>

        </div>
        <div class="column">
          <div class="field">
            <label class="label">Salary To</label>
            <div class="control">
              <input type="text" class="input">
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Job Type</label>
            <div class="control">
              <input type="text" class="input">
            </div>
          </div>

        </div>
        <div class="column">
          <div class="field">
            <label class="label">Status</label>
            <div class="control">
              <input type="text" class="input">
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Start Date</label>
            <div class="control">
              <DatePicker></DatePicker>
            </div>
          </div>

        </div>
        <div class="column">
          <div class="field">
            <label class="label">Expired Date</label>
            <div class="control">
              <DatePicker></DatePicker>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Description</label>
            <div class="control">
              <textarea class="textarea"></textarea>
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
import {DatePicker} from "element-ui"

export default {
  components: {
    DepartmentSelectInput,
    DatePicker
  },
  data(){
    return{
      loading: false
    }
  },
  methods: {
    createJob() {

    }
  },
  computed: {
    disableSubmitButton() {
      return false
    }
  }

}
</script>