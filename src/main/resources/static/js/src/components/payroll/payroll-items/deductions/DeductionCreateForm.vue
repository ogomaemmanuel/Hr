<template>
    <ModalTemplate>
        <div slot="modal-content">
            <div>
                <form>
                    <div class="has-text-centered m-3">
                        <h1 class="has-text-black"><b>Add Deduction</b></h1>
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

                    <b-field label="Department">
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
                                <span v-show="page > totalPages"
                                      class="has-text-grey"> Thats it! No more movies found. </span>
                            </template>
                        </b-autocomplete>
                    </b-field>
                    <span slot="message" class="mb-2 has-text-danger" v-if="errors['departmentId']">
						{{errors['departmentId'][0]}}
					</span>
                    <div class="flex justify-center m-3">
                        <button

                                :class="{'is-loading':loading}"
                                :disabled="false"
                                @click.prevent.stop=""
                                class="button  is-rounded"
                                type="submit">Submit
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </ModalTemplate>
</template>
<script>
    import ModalTemplate from "../../../common/ModalTemplate";
    import common_mixin from "../../../../mixins/common_mixin";

    export default {
        mixins: {
            common_mixin
        },
        components: {
            ModalTemplate
        },
        data() {
            return {

            }
        }
    }
</script>
<style scoped lang="scss">

</style>