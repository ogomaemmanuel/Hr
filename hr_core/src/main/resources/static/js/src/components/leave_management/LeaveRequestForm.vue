<template>
  <form>
    <div class="has-text-centered m-3">
      <h1 class="has-text-black"><b>Request Leave</b></h1>
    </div>
    <div class="field">
      <label class="label">Leave Types <span><sup class="has-text-danger">*</sup></span></label>
      <div class="control w-full">
        <div class="select w-full">
          <select v-model="leaveRequest.leaveTypeId"
                  class="w-full"
                  @input="clearFieldError('leaveTypeId')">
            <option disabled hidden selected value="">Select One</option>
            <option
                v-for="leaveType in leaveTypes"
                :key="leaveType.id"
                :value="leaveType.id">{{ leaveType.name }}
            </option>
          </select>
        </div>
        <span v-if="errors['leaveTypeId']" class="text-red-400">
							{{ errors['leaveTypeId'][0] }}
						</span>
      </div>
    </div>
    <div class="columns">
      <div class="column">
        <div class="field">
          <label class="label">From <span><sup class="has-text-danger">*</sup></span></label>
          <div class="control">
            <DatePicker
                v-model="leaveRequest.startDate"
                :picker-options="datePickerOptions"
                class="min-w-full"
                format="dd-MM-yyyy"
                value-format="yyyy-MM-dd"
                @input="clearFieldError('startDate')">
            </DatePicker>
            <span
                v-if="errors['startDate']"
                class="text-red-400">
								{{ errors['startDate'][0] }}
							</span>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="field">
          <label class="label">To <span><sup class="has-text-danger">*</sup></span></label>
          <div class="control">
            <DatePicker
                v-model="leaveRequest.endDate"
                class="min-w-full"
                format="dd-MM-yyyy"
                value-format="yyyy-MM-dd"
                @input="clearFieldError('endDate')">

            </DatePicker>
            <span
                v-if="errors['endDate']"
                class="text-red-400">
								{{ errors['endDate'][0] }}
						</span>

          </div>
        </div>
      </div>
    </div>

    <div class="field">
      <label class="label">Employee In Place</label>
      <div class="control w-full">
        <div class="select w-full">
          <select
              v-model="leaveRequest.inPlaceId"
              class="w-full"
              @input="clearFieldError('inPlaceId')">
            <option disabled hidden selected value="">Select One</option>
            <option v-for="inPlaceEmployee in inPlaceEmployees" :value="inPlaceEmployee.staffId">
              {{ inPlaceEmployee.fullName }}
            </option>
          </select>
        </div>
        <span
            v-if="errors['inPlaceId']"
            class="text-red-400">
									{{ errors['inPlaceId'][0] }}
							</span>
      </div>
    </div>
    <div class="columns">
      <div class="column">
        <div class="field">
          <label class="label">Number of Days<span><sup>*</sup></span></label>
          <div class="control">
            <input
                :value="numberOfDays"
                class="input"
                disabled
                type="text"
                @change="clearFieldError('numberOfDays')">
            <span
                v-if="errors['numberOfDays']"
                class="text-red-400">
					{{ errors['numberOfDays'][0] }}
				</span>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="field">
          <label class="label">Remaining Leaves Days<span><sup>*</sup></span></label>
          <div class="control">
            <input
                :value="remainingLeaveDays"
                class="input"
                disabled
                type="text">
          </div>
        </div>
      </div>
    </div>
    <div class="field">
      <label class="label">Select Approvers</label>
      <div class="control w-full">
        <div class="select w-full">
          <select
              multiple
              v-model="leaveRequest.ApproverId"
              class="w-full"
              @input="clearFieldError('inPlaceId')">
            <option disabled hidden selected value="">Select multiple</option>
            <option v-for="inPlaceEmployee in inPlaceEmployees" :value="inPlaceEmployee.staffId">
              {{ inPlaceEmployee.fullName }}
            </option>
          </select>
        </div>
        <span
            v-if="errors['ApproverId']"
            class="text-red-400">
									{{ errors['ApproverId'][0] }}
							</span>
      </div>
    </div>
    <div class="field">
      <label class="label">Reason<span><sup>*</sup></span></label>
      <div class="control">
					<textarea
              v-model="leaveRequest.reason"
              class="textarea"
              @input="clearFieldError('reason')">
					</textarea>
        <span
            v-if="errors['reason']"
            class="text-red-400">
					{{ errors['reason'][0] }}
				</span>
      </div>
    </div>
    <div class="flex justify-center m-3">
      <button
          :class="{'is-loading':loading}"
          class="button is-rounded"
          type="submit"
          @click.prevent="makeLeaveRequest">Submit
      </button>
    </div>
  </form>
</template>
<script>
import {DatePicker, Select} from "element-ui"
import CommonMixin from "../../mixins/common_mixin"

export default {
  name: "LeaveRequestForm",
  mixins: [CommonMixin],
  components: {
    DatePicker,
  },
  data() {
    return {
      datePickerOptions: {
        disabledDate(date) {
          return (date.getTime() < Date.now() - 8.64e7) ||
              moment(date.getTime()).isoWeekday() === 7 || moment(date.getTime()).isoWeekday() === 6;
        }
      },
      leaveRequest: {
        leaveTypeId: "",
        inPlaceId: "",
        startDate: "",
        endDate: "",
        ApproverId:[]

      },
      leaveTypes: [],
      inPlaceEmployees: [],
      remainingLeaveDays: "",
      errors: {},
      loading: false,


    }
  },
  created() {
    this.getLeaveTypes();
    this.getInPlaceEmployees();
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    getLeaveBalanceByLeaveTypeId(leaveTypeId) {
      axios.get(`/api/user/leave-balances/${leaveTypeId}`).then(resp => {
        this.remainingLeaveDays = resp.data;
      })

    },
    getLeaveTypes() {
      axios.get("/api/leave-types").then(resp => {
        this.leaveTypes = resp.data;
      })
    },
    makeLeaveRequest() {
      let vm = this;
      vm.loading = true;
      axios.post("/api/leave-request", vm.leaveRequest).then(resp => {
        vm.loading = false;
        if (resp.status === 200) {
          vm.$swal(
              {
                type: "success",
                text: "Leave Request successfully submitted"
              }
          );
          this.$emit("leaveRequestSuccessful");
        }
      }, error => {
        vm.loading = false;
        if (error.response.status === 400) {
          this.errors = error.response.data;
        }
      })
    },
    getInPlaceEmployees() {
      axios.get("/api/leave-requests/in-place").then(resp => {
        this.inPlaceEmployees = resp.data;
      })
    }
  },
  computed: {
    numberOfDays() {
      let vm = this;
      let startDate = this.leaveRequest.startDate;
      let endDate = this.leaveRequest.endDate;
      if (startDate && endDate) {
        let diff = moment(endDate).diff(startDate, "days");
        vm.leaveRequest.numberOfDays = diff;
        return diff;
      }
      vm.leaveRequest.numberOfDays = 0;
      return 0;
    }
  },
  watch: {
    'numberOfDays': function (val) {
      this.clearFieldError("numberOfDays");
    },
    'leaveRequest.leaveTypeId': function (val) {
      this.getLeaveBalanceByLeaveTypeId(val);
    }
  }

}
</script>

<style lang="scss" scoped>
.date-picker-el {
  width: 100% !important;
}
</style>