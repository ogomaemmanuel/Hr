<template>
    <div>
        <div class="columns is-multiline">
            <div v-for="employee in employees" class="column is-4">

                <div class="card">
                    <div class="pt-2">
                        <div class="card-image is-relative">
                            <div class="flex justify-center">
                                <figure class="image is-128x128">
                                    <img class="is-rounded" src="https://bulma.io/images/placeholders/128x128.png"
                                         alt="Placeholder image">
                                </figure>
                            </div>


                            <div class="profile-action">
                                <div class="dropdown">
                                    <i class="fa fa-ellipsis-v"></i>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#" data-toggle="modal"
                                           data-target="#edit_employee"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                        <a class="dropdown-item" href="#" data-toggle="modal"
                                           data-target="#delete_employee"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                    <div class="card-content">
                        <div class="content">
                            <div class="">
                                <div class="has-text-centered">
                                    <p class="title is-5"> {{employee.fullName||"NO Name"}}</p>
                                </div>
                                <div class="has-text-centered">
                                    <p class="subtitle is-6">{{employee.designation||"NO Name"}}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="flex justify-center">
            <div>
                <Paginator
                        @previousPage="goToPrevious"
                        @nextPage="goToNext"
                        @paginationChanged="onPaginationChanged"
                        :paginationData="pageable"
                ></Paginator>
            </div>
        </div>

    </div>
</template>
<script>
    import Paginator from "../../../common/paginator/Paginator";
    import EmployeeListMixin from "./EmployeeListMixin";

    export default {
        mixins:[EmployeeListMixin];
        components: {
            Paginator
        },
        computed: {
            // current() {
            //     return this.page + 1;
            // }
        },
    }
</script>
<style scoped lang="scss">
    .profile-action {
        position: absolute;
        right: 5px;
        text-align: right;
        top: 10px;
        top: 0px;
        right: 5px;


    }
</style>