<template>
    <div class="h-full">
        <div class="columns h-full is-multiline">
            <div v-for="client in clients" class="column  is-3-desktop is-4-tablet">
                <div class="card min-h-48">
                    <div class="card-content">

                        <div>
                            <div class="flex justify-center">
                                <figure class="image is-128x128">
                                    <img class="is-rounded"
                                         src="https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg"
                                         alt="Placeholder image">
                                </figure>
                            </div>
                            <div class="text-center text-truncate">
                                <a href="">{{client.companyName}}</a>
                            </div>
                            <div class="text-center text-truncate">
                                <a href="">{{client.fullName}}</a>
                            </div>
                            <div class="text-center text-truncate">
                                <!--                                <a href="">Title</a>-->
                                <a href="">{{client.phone}}</a>
                            </div>
                            <div class="flex justify-center">
                                <div class="">
                                    <button class="button is-size-7 mr-1">Message</button>
                                </div>
                                <div class="">
                                    <button class="button is-size-7 ml-1">View Profile</button>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="profile-action">

                        <b-dropdown class="text-left" aria-role="list">
                            <i
                                    class="fa fa-ellipsis-v text-muted"
                                    slot="trigger"
                                    role="button">
                            </i>
                            <b-dropdown-item :disabled="false"
                                             value="withdraw"
                                             @click="confirmRemoveClient(client)"
                                             aria-role="listitem">
                                <span class="icon"><i class="fa fa-trash"></i></span>
                                Remove
                            </b-dropdown-item>
                            <b-dropdown-item
                                    :disabled="false" value="edit" aria-role="listitem">
                                <router-link :to="`/clients-edit/${client.id}`">
                                    <span class="icon"><i class="fa fa-pencil"></i></span>
                                    Edit
                                </router-link>
                            </b-dropdown-item>
                        </b-dropdown>
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>
<script>
    import data_table_mixin from "../../../mixins/data_table_mixin";
    import ClientListMixin from "./ClientListMixin";

    export default {
        mixins: [data_table_mixin, ClientListMixin],
        data() {
            return {
                clients: [],
                loading: false
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
<style lang="scss" scoped>
    .profile-action {
        position: absolute;
        right: 5px;
        text-align: right;
        top: 10px;
        top: 0px;
        right: 5px;
    }

    .text-truncate {
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
</style>