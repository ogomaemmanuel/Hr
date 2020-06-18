<template>
    <div>
        <b-field>
            <template slot="label">
                Department <span><sup>*</sup></span>
            </template>
            <b-autocomplete
                    :data="departments"
                    placeholder="Department name"
                    field="name"
                    :loading="isFetching"
                    :check-infinite-scroll="true"
                    @typing="getAsyncData"
                    @select="option => selectedDepartment = option"
                    @infinite-scroll="getMoreAsyncData">
                <template slot="header">
                    <a @click="showAddDepartment">
                        <span class="has-text-link"> Add new... </span>
                    </a>
                </template>
                <template slot-scope="props">
                    <div class="media">
                        <div class="media-left">
                            <!--                                <img width="32" :src="`https://image.tmdb.org/t/p/w500/${props.option.poster_path}`">-->
                        </div>
                        <div class="media-content">
                            {{ props.option.name }}
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
        </b-field>
    </div>
</template>
<script>
    import _debounce from "lodash.debounce";

    export default {
        data() {
            return {
                departments: [],
                loading: false,
                isFetching: false,
                departmentName: '',
                page: 0,
                totalPages: 0,
                selectedDepartment: {}
            }
        },
        methods: {
            showAddDepartment() {

            },
            fetchDepartments(name) {
                axios.get("/api/departments", {
                    params: {
                        page: this.page,
                        pageSize: 10
                    }
                })
                    .then(({data}) => {
                        data.content.forEach((item) => this.departments.push(item))
                        this.page++
                        this.totalPages = data.totalPages
                        this.isFetching = false
                    }, error => {
                        this.isFetching = false
                    })
            },
            getAsyncData: _debounce(function (name) {
                // String update
                if (this.departmentName !== name) {
                    this.departmentName = name
                    this.departments = []
                    this.page = 0
                    this.totalPages = 0
                }
                // String cleared
                if (!name.length) {
                    this.departments = []
                    this.page = 0
                    this.totalPages = 0
                    return
                }
                // Reached last page
                if (this.page > this.totalPages) {
                    return
                }
                this.isFetching = true
                //call fetchdepartments
                this.fetchDepartments(name)
            }, 500),
            getMoreAsyncData: _debounce(function () {
                this.getAsyncData(this.departmentName)
            }, 250)
        },
        watch: {
            selectedDepartment: function (val) {
                this.$emit('input', val.id);
            }
        }
    }
</script>
<style lang="scss" scoped>

</style>