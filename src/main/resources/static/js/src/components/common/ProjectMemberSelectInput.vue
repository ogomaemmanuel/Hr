<template>
    <div>
        <b-field>
            <template slot="label">
                {{label}} <span v-if="required"><sup>*</sup></span>
            </template>
            <b-autocomplete
                    :data="employees"
                    placeholder="Select Employee"
                    field="fullName"
                    :loading="isFetching"
                    :check-infinite-scroll="true"
                    @typing="getAsyncData"
                    @select="option => selectedEmployee = option"
                    @infinite-scroll="getMoreAsyncData">
                <template slot="header">
                    <a @click="showAddEmployee">
                        <span class="has-text-link"> Add new... </span>
                    </a>
                </template>
                <template slot-scope="props">
                    <div class="media">
                        <div class="media-left">
                            <!--                                <img width="32" :src="`https://image.tmdb.org/t/p/w500/${props.option.poster_path}`">-->
                        </div>
                        <div class="media-content">
                            {{ props.option.fullName }}
                            <br>
                            <small>
                                <!--                                    Released at {{ props.option.release_date }},-->
                                <!--                                    rated <b>{{ props.option.vote_average }}</b>-->
                            </small>
                        </div>
                    </div>
                </template>
                <template slot="footer">
                    <span v-show="page > totalPages" class="has-text-grey"> Thats it! No more movies found. </span>
                </template>
            </b-autocomplete>
            <div slot="message">
                <slot name="errors">
                </slot>
            </div>
        </b-field>
    </div>
</template>
<script>
    import _debounce from "lodash.debounce";

    export default {
        props: {
            label: {
                default: "Employee"
            },
            required: {
                default: true
            }
        },
        data() {
            return {
                employees: [],
                loading: false,
                isFetching: false,
                employeeName: '',
                page: 0,
                totalPages: 0,
                selectedEmployee: {}
            }
        },
        methods: {
            showAddEmployee() {

            },
            fetchEmployees(name) {
                axios.get("/api/employees", {
                    params: {
                        page: this.page,
                        pageSize: 10
                    }
                })
                    .then(({data}) => {
                        data.content.forEach((item) => this.employees.push(item))
                        this.page++
                        this.totalPages = data.totalPages
                        this.isFetching = false
                    }, error => {
                        this.isFetching = false
                    })
            },
            getAsyncData: _debounce(function (name) {
                // String update
                if (this.employeeName !== name) {
                    this.employeeName = name
                    this.employees = []
                    this.page = 0
                    this.totalPages = 0
                }
                // String cleared
                if (!name.length) {
                    this.employees = []
                    this.page = 0
                    this.totalPages = 0
                    return
                }
                // Reached last page
                if (this.page > this.totalPages) {
                    return
                }
                this.isFetching = true
                //call fetchemployees
                this.fetchEmployees(name)
            }, 500),
            getMoreAsyncData: _debounce(function () {
                this.getAsyncData(this.employeeName)
            }, 250)
        },
        watch: {
            selectedEmployee: function (val) {
                if (val) {
                    this.$emit('input', val);
                } else {
                    this.$emit('input', "")
                }
            }
        }
    }
</script>
<style lang="scss" scoped>

</style>