<template>
    <div class="card">
        <div class="card-content">
            <div class="content b-table is-relative">
                <h4>Clients</h4>
                <table class="table has-mobile-cards w-full is-hoverable">
                    <thead class="font-thin">
                    <tr>
                        <th>
                            Name
                        </th>
                        <th>
                            Client Id
                        </th>
                        <th>
                            Email
                        </th>
                        <th>
                            Mobile
                        </th>
                        <th>

                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="client in clients">
                        <td data-label="Name">{{client.fullName}}</td>
                        <td data-label="Description">{{client.id}}</td>
                        <td data-label="Description">{{client.email}}</td>
                        <td data-label="Description">{{client.phone}}</td>
                        <td data-label="Action">
                            <div class="action-controls d-flex justify-end">
                                <router-link
                                        :to="`/clients-edit/${client.id}`" tag="button"
                                        class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                                </router-link>
                                <button
                                        @click="confirmRemoveClient(client)"
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
</template>
<script>
    import ClientListMixin from "./ClientListMixin";
    import data_table_mixin from "../../../mixins/data_table_mixin";
    import Paginator from "../../common/paginator/Paginator";

    export default {
        components: {
            Paginator
        },
        mixins: [data_table_mixin, ClientListMixin],
        data() {
            return {
                clients: []
            }
        },
        created() {
            this.getClients();
        },
        methods: {
            getClients() {
                let vm = this;
                axios.get(`/api/clients`, {
                    params: {
                        page: this.page,
                        pageSize: this.pageSize,
                    }
                }).then(resp => {
                    vm.loading = false;
                    this.clients = resp.data.content;
                    this.pageable = resp.data;
                })
            }
        }
    }
</script>