<template>
    <div>
        <form>
            <div class="has-text-centered m-3">
                <h1 class="has-text-black"><b>Update Designation</b></h1>
            </div>
            <div class="field">
                <label class="label"> Name <span><sup>*</sup></span></label>
                <div class="control">
                    <input
                            v-model="designation.name"
                            @input="clearFieldError('name')"
                            class="input"
                            type="text">
                    <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                </div>
            </div>
            <template>
                <b-field>
                    <template slot="label">
                        Department <span><sup>*</sup></span>
                    </template>
                    <b-autocomplete
                            ref="autocomplete"
                            :data="departments"
                            placeholder="enter department name"
                            field="name"
                            :clearable="true"
                            :loading="isFetching"
                            :open-on-focus="true"
                            :check-infinite-scroll="true"
                            @typing="getAsyncData"
                            @select="option => selectedDepartment  = option"
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
                            <span v-show="page > totalPages"
                                  class="has-text-grey"> Thats it! No more movies found. </span>
                        </template>
                    </b-autocomplete>
                </b-field>
            </template>
            <div class="flex justify-center m-3">
                <button

                        :class="{'is-loading':loading}"
                        :disabled="disableSubmitButton"
                        @click.prevent.stop="updateDesignation"
                        class="button  is-rounded"
                        type="submit">Submit
                </button>
            </div>
        </form>
    </div>
</template>

<script>
    import CommonMixin from "../../../mixins/common_mixin"
    import _debounce from "lodash.debounce"

    export default {
        mixins: [CommonMixin],
        props: {
            designationId: {
                required: true,
            }
        },
        data() {
            return {
                departments: [],
                designation: {
                    name: ""
                },
                loading: false,
                loaded: false,
                isFetching: false,
                departmentName: '',
                page: 0,
                totalPages: 0,
                selectedDepartment: {}
            }
        },
        computed: {
            disableSubmitButton() {
                return this.designation.name.length <= 0;
            }
        },
        created() {
            this.getDesignationById();
        },
        mounted() {
            this.getAsyncData();
        },
        methods: {
            setSelectedDepartment(options) {
                this.selectedDepartment = options;
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
            getDesignationById() {
                this.loading = true;
                axios.get(`/api/designations/${this.designationId}`).then(resp => {
                    this.designation = resp.data;
                    this.selectedDepartment = resp.data.department;
                    this.$refs.autocomplete.setSelected(resp.data.department)
                    this.loading = false;
                    this.loaded = true;
                }, error => {
                    this.loading = false;
                })
            },
            getMoreAsyncData: _debounce(function () {
                this.getAsyncData(this.departmentName)
            }, 250),
            showAddDepartment() {

            },
            updateDesignation() {
                this.designation.departmentId = this.selectedDepartment.id;
                axios.put(`/api/designations/${this.designationId}`, this.designation).then(resp => {

                }, error => {

                })
            }

        },

    }
</script>