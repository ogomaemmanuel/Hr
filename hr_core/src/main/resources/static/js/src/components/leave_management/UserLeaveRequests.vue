<template>
  <div class="bg-white p-4">
    <portal to="page-controls">
      <div class="pt-2 pr-2 flex justify-end">
        <p class="buttons">
          <router-link
              class="button  is-rounded"
              tag="button"
              to="leave-create">
				<span class="icon">

				<i class="fa fa-plus-circle"></i>
				</span>
            <span>New Request</span>
          </router-link>
        </p>
      </div>
    </portal>
    <div class="tabs">
      <ul>
        <li :class="{'is-active':showLeaveBalances==false}" @click="showLeaveBalances=false"><a>My Leave
          Requests</a></li>
        <li :class="{'is-active':showLeaveBalances==true}" @click="showLeaveBalances=true"><a>My Leave
          Balances</a></li>
      </ul>
    </div>
    <div class="columns">
      <div v-if="showLeaveBalances==false" class="column is-12">
        <EmptyState v-if="showEmptyState">
          <h4 class="ml-3">Leave requests not found</h4>
          <div class="flex justify-center">
            <p class="buttons mt-5">
              <router-link
                  class="button  is-rounded"
                  tag="button"
                  to="leave-create">
				<span class="icon">
 
				<i class="fa fa-plus-circle"></i>
				</span>
                <span>New Requests</span>
              </router-link>
            </p>
          </div>

        </EmptyState>
        <div v-else ref="leaveRequests" class="card">
          <div v-if="loaded" class="card-content card-simple">
            <div class="content b-table">
              <table class="table has-mobile-cards is-hoverable">
                <thead class="font-thin">
                <tr>
                  <th>
                    Type
                  </th>
                  <th>
                    Days
                  </th>
                  <th>
                    Start Date
                  </th>
                  <th>
                    End Date
                  </th>
                  <th>
                    Status
                  </th>
                  <th>
                    Date Requested
                  </th>
                  <th>
                    Action
                  </th>
                </tr>
                </thead>
                <tbody>
                <tr is="UserLeaveRequestItem" v-for="leaveRequest in leaveRequests"
                    :key="leaveRequest.id" :leave-request="leaveRequest">
                </tr>
                </tbody>
                <tfoot>
                <tr>
                  <td colspan="7">
                    <Paginator
                        :paginationData="pageable"
                        @nextPage="goToNext"
                        @paginationChanged="onPaginationChanged"
                        @previousPage="goToPrevious">
                    </Paginator>
                  </td>
                </tr>
                </tfoot>
              </table>
            </div>
          </div>
        </div>
      </div>
      <div v-else class="column is-12">
        <LeaveBalanceCard></LeaveBalanceCard>
      </div>
    </div>
    <router-view
        @leaveRequestSuccessful="getUserLeaveRequests"
        @leaveUpdateSuccessful="getUserLeaveRequests">
    </router-view>
  </div>
</template>
<script>
import LeaveBalanceCard from "./LeaveBalanceCard.vue"
import Paginator from "../common/paginator/Paginator"
import UserLeaveRequestItem from "./UserLeaveRequestItem"
import EmptyState from "../common/EmptyState"

export default {
  components: {
    LeaveBalanceCard,
    Paginator,
    UserLeaveRequestItem,
    EmptyState
  },
  data() {
    return {
      loading: false,
      leaveRequests: [],
      pageable: false,
      pageSize: 10,
      page: 0,
      loaded: false,
      showLeaveBalances: false
    }
  },
  created() {
    this.getUserLeaveRequests();
  },
  methods: {
    getUserLeaveRequests() {
      let vm = this;
      const loadingComponent = this.$buefy.loading.open({
        container: this.isFullPage ? null : vm.$refs.leaveRequests
      })
      axios.get("/api/user/leave-requests", {
        params: {
          pageSize: vm.pageSize,
          page: vm.page

        }
      }).then(resp => {
        loadingComponent.close();
        vm.leaveRequests = [];
        this.$nextTick().then(function () {
          vm.leaveRequests.push(...resp.data.content);
          vm.pageable = resp.data;
          vm.loaded = true;
        })
      }, error => {
        loadingComponent.close();
      })
    },
    goToPrevious() {
      this.page--;
      this.getUserLeaveRequests();
    },
    goToNext() {
      this.page++;
      this.getUserLeaveRequests();
    },
    onPaginationChanged(pageSize) {
      this.page = 0;
      this.pageSize = pageSize;
      this.getUserLeaveRequests();
    }
  },
  computed: {
    showEmptyState() {
      return this.loaded && this.leaveRequests.length <= 0;
    }
  },
  filters: {
    dateFormat(date) {
      return moment(date).format("LL")
    }
  }
}
</script>
<style lang="scss" scoped>
</style>