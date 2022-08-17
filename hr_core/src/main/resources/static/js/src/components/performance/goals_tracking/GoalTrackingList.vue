<template>
  <div>
    <div class="pb-2 flex justify-end">
      <button
          @click="showCreateForm=true"
          to="/goal-type-create"
          tag="button"
          class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add New
				</span>
      </button>
    </div>
    <div class="columns">
      <div class="column is-12">
        <div class="card" ref="leaveRequests">
          <div class="card-content">
            <div class="content b-table is-relative">
              <h4>Goal Types</h4>
              <table class="table has-mobile-cards w-full is-hoverable">
                <thead class="font-thin">
                <tr>
                  <th>
                    Name
                  </th>
                  <th>
                    Description
                  </th>
                  <th>
                    Action
                  </th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="goal in goalTrackingList">
                  <td data-label="Name">{{ goal.type }}</td>
                  <td data-label="Description">{{ goal.description }}</td>
                  <td data-label="Action">
                    <div class="action-controls d-flex justify-end">
                      <button
                          :to="`/goal-type-edit/${goal.id}`" tag="button"
                          @click="setGoalTypeEdit(goal)" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                      </button>
                      <button
                          @click="confirmRemoveGoal(goal)"
                          class="button is-white is-small">
										           <span class="icon">
						                            <i class="fa fa-trash-o has-text-danger"></i>
					                               </span>
                      </button>
                    </div>
                  </td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                  <td colspan="4">
                    <Paginator
                        @previousPage="goToPrevious"
                        @nextPage="goToNext"
                        @paginationChanged="onPaginationChanged"
                        :paginationData="pageable"
                    ></Paginator>
                  </td>
                </tr>
                </tfoot>
              </table>
              <b-loading :is-full-page="false" :active.sync="loading" :can-cancel="true"></b-loading>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>
<script>
import data_table_mixin from "../../../mixins/data_table_mixin";
import Paginator from "../../common/paginator/Paginator";
import {Message} from "element-ui";

export default {
  components: {
    Paginator
  },
  mixins: [data_table_mixin],
  data() {
    return {
      goalTrackingList: [],
      showCreateForm: false,
      showEditForm: false
    }
  },
  created() {
    this.getGoalTrackingList();
  },
  methods: {
    getGoalTrackingList() {
      axios.get("/api/goal-tracking", {
        params: {
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(resp => {
        this.goalTrackingList = resp.data.content;
        this.pageable = resp.data;
      })
    },
    confirmRemoveGoal(goal) {

    }
  }
}
</script>