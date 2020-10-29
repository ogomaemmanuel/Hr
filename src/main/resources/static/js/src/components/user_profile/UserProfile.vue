<template>
    <div class="h-full">
        <div class="card min-h-48">
            <div class="card-content">
                <div class="content">
                    <div class="columns">
                        <div class="column is-2">
                            <figure class="image is-128x128">
                                <img class="is-rounded"
                                     src="https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg"
                                     alt="">
                            </figure>
                        </div>
                        <div class="column is-10 pl-5">
                            <div class="columns">
                                <div class="column">
                                    <div class="pt-5">
                                        <h2 class="font-semibold">{{authenticatedUser.fullName}}</h2>
                                    </div>
                                    <div class="flex ">
                                        <div class="mr-1">
                                     <span>
                                    <i class="fa fa-building"></i>
                                </span>
                                            <span>{{authenticatedUser.departmentName}}</span>
                                        </div>
                                        <div>
                                     <span>
                                    <i class="fa fa-phone"></i>
                                </span>
                                            <span>{{authenticatedUser.phone}}</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="column"></div>
                            </div>



                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="card mt-1">
            <div class="tabs">
                <ul>
                    <li @click="showAdditions=true" :class="{'is-active':showAdditions}"><a>Profile</a></li>
                    <li @click="showAdditions=false" :class="{'is-active':!showAdditions}"><a>Projects</a></li>
                    <li @click="showAdditions=false" :class="{'is-active':!showAdditions}"><a>Bank & Statutory</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="columns mt-2">
            <div class="column">
                <div class="card h-full">
                    <div class="card-content">
                     <div class="flex">
                         <h1 class="flex-1">Personal Informations </h1>
                         <div>
                             <button>
                                 <i class="fa fa-edit"></i>
                             </button>
                         </div>
                     </div>
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="card h-full">
                <div class="card-content">
                    <div class="flex">
                        <h1 class="flex-1">Emergency Contact</h1>
                        <div>
                            <button>
                                <i class="fa fa-edit"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        </div>
        <div class="columns mt-2">
            <div class="column">
                <div class="card h-full">
                    <div class="card-content">
                     <div class="flex">
                         <h1 class="flex-1">Bank information </h1>
                         <div>
                             <button>
                                 <i class="fa fa-edit"></i>
                             </button>
                         </div>
                     </div>
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="card h-full">
                <div class="card-content">
                    <div class="flex">
                        <h1 class="flex-1">Family Informations</h1>
                        <div>
                            <button>
                                <i class="fa fa-edit"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        </div>

    </div>
</template>
<script>
    import {mapGetters} from "vuex"

    export default {
        components: {},
        data() {
            return {
                employeeId: null,
                showAdditions: true,
                employeeSalaryInfo: {}

            }
        },
        computed: {
            ...mapGetters(["authenticatedUser"])
        },
        created() {

            //this.getEmployeeSalaryInfo();

        },
        methods: {
            getEmployeeSalaryInfo() {
                axios.get(`/api/employee-salary/${this.employeeId}`).then(resp => {
                    this.employeeSalaryInfo = resp.data;
                })
            }
        }
    }
</script>
<style lang="scss" scoped>

</style>