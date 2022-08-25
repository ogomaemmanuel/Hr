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
              <h4>Trainers</h4>
              <table class="table has-mobile-cards w-full is-hoverable">
                <thead class="font-thin">
                <tr>
                  <th>
                    Name
                  </th>
                  <th>
                    Contact Number
                  </th>
                  <th>
                    Email
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
                <tr v-for="trainer in trainers">
                  <td data-label="Name">{{ trainer.fullName }}</td>
                  <td data-label="Description">{{ trainer.description }}</td>
                  <td data-label="Email">{{ trainer.email }}</td>
                  <td data-label="Email">{{ trainer.description }}</td>
                  <td data-label="Action">
                    <div class="action-controls d-flex justify-end">
                      <button
                          :to="`/goal-type-edit/${trainer.id}`" tag="button"
                          @click="setTrainerToUpdate(trainer)" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                      </button>
                      <button
                          @click="confirmRemoveTrainer(trainer)"
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
                  <td colspan="5">
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
    <TrainersCreateForm
        @modalClosed="showCreateForm=false"
        @createSuccessful="createSuccessfulHandler"
        v-if="showCreateForm">
    </TrainersCreateForm>
    <!--        <TrainingTypeEditForm-->
    <!--        @updateSuccessful="updateSuccessfulHandler"-->
    <!--        :id="trainingTypeToUpdate.id"-->
    <!--        @modalClosed="showEditForm=false"-->
    <!--        v-if="showEditForm"></TrainingTypeEditForm>-->
  </div>
</template>
<script>
import data_table_mixin from "../../../mixins/data_table_mixin";
import TrainersCreateForm from "./TrainersCreateForm";
import Paginator from "../../common/paginator/Paginator";

export default {
  components: {
    TrainersCreateForm,
    Paginator
  },
  mixins: [data_table_mixin],

  data() {
    return {
      trainers: [],
      trainerToUpdate: null,
      showEditForm: false,
      showCreateForm: false,
    }
  },
  created() {
    this.getTrainers();
  },
  methods: {
    confirmRemoveTrainer(trainer) {
      this.$buefy.dialog.confirm({
        title: 'Delete Trainer',
        message: `Are you sure want to delete <b> ${trainer.firstName}</b> trainer`,
        onConfirm: () => this.removeTrainer(trainer)
      })
    },
    removeTrainer(trainer) {
      axios.delete(`/api/trainers/${trainer.id}`).then(resp => {
        this.getTrainers();
      })
    },
    createSuccessfulHandler() {
      this.showCreateForm = false;
      this.getTrainers()
    },
    getTrainers() {
      axios.get("/api/trainers", {
        params: {
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(resp => {
        this.trainers = resp.data.content;
        this.pageable = resp.data;
      })
    },
    setTrainerToUpdate(trainer) {
      let vm = this;
      this.trainerToUpdate = trainer;
      this.$nextTick(() => {
        vm.showEditForm = true;
      })

    }
  }
}
</script>