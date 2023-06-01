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
              <h4>Training</h4>
              <table class="table has-mobile-cards w-full is-hoverable">
                <thead class="font-thin">
                <tr>
                  <th>
                    Type
                  </th>
                  <th>
                    Description
                  </th>
                  <th>
                    Start Date
                  </th>
                  <th>
                    End Date
                  </th>
                  <th>
                    Cost
                  </th>
                  <th>
                    Status
                  </th>
                  <th>
                    Action
                  </th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="training in trainingList">
                  <td data-label="Name">{{ training.trainingType.type }}</td>
                  <td data-label="Description">{{ training.description }}</td>
                  <td data-label="Description">{{ training.startDate }}</td>
                  <td data-label="Description">{{ training.endDate }}</td>
                  <td data-label="Description">{{ training.cost }}</td>
                  <td data-label="Description">{{ training.status }}</td>
                  <td data-label="Action">
                    <div class="action-controls d-flex justify-end">
                      <button
                          :to="`/goal-type-edit/${training.id}`" tag="button"
                          @click="setTrainingToUpdate(training)" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                      </button>
                      <button
                          @click="confirmRemoveTraining(training)"
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
                  <td colspan="7">
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
    <TrainingCreateForm
        @modalClosed="showCreateForm=false"
        @createSuccessful="createSuccessfulHandler"
        v-if="showCreateForm"></TrainingCreateForm>
        <TrainingEditForm
            @updateSuccessful="updateSuccessfulHandler"
            :id="trainingToUpdate.id"
            @modalClosed="showEditForm=false"
            v-if="showEditForm"></TrainingEditForm>
  </div>
</template>
<script>
import data_table_mixin from "../../../mixins/data_table_mixin";
import Paginator from "../../common/paginator/Paginator";
import TrainingCreateForm from "./TrainingCreateForm";
import TrainingEditForm from "./TrainingEditForm";

export default {
  mixins: [data_table_mixin],
  components: {
    Paginator,
    TrainingCreateForm,
    TrainingEditForm
  },
  data() {
    return {
      showEditForm: false,
      loading: false,
      showCreateForm: false,
      trainingToUpdate: null,
      trainingList: []
    }
  },
  created() {
    this.getTrainingList();
  },
  methods: {
    fetchRecords() {
      this.getTrainingList();
    },
    createSuccessfulHandler() {
      this.showCreateForm = false;
      this.getTrainingList();
    },
    setTrainingToUpdate(training) {
      this.trainingToUpdate = training;
      this.$nextTick(() => {
        this.showEditForm = true;
      })
    },
    updateSuccessfulHandler() {
    },
    removeTraining({id}) {
      axios.delete(`/api/trainings/${id}`).then(resp => {
        this.getTrainingList();
      })
    },
    confirmRemoveTraining(training) {
      this.$buefy.dialog.confirm({
        title: 'Delete Training',
        message: `Are you sure want to delete <b> ${training.description}</b> training`,
        onConfirm: () => this.removeTraining(training)
      })
    },
    getTrainingList() {
      let vm = this;
      axios.get("/api/trainings", {
        params: {
          page: vm.page,
          pageSize: vm.pageSize
        }
      }).then(resp => {
        vm.trainingList = resp.data.content;
        vm.pageable = resp.data;
      }, error => {

      })
    }
  }
}
</script>