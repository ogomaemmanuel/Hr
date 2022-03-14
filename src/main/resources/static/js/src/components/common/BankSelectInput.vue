<template>
    <div>
        <b-field >
            <template slot="label">
                Bank <span><sup>*</sup></span>
            </template>
            <b-autocomplete
                    :data="banks"
                    placeholder="Bank name"
                    field="name"
                    :loading="isFetching"
                    :check-infinite-scroll="true"
                    @typing="getAsyncData"
                    @select="option => selectedBank = option"
                    @infinite-scroll="getMoreAsyncData">
                <template slot="header">
                    <a @click="showAddBank">
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
                    <span v-show="page > totalPages" class="has-text-grey"> Thats it! No more banks found. </span>
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
        data() {
            return {
                banks: [],
                loading: false,
                isFetching: false,
                bankName: '',
                page: 0,
                totalPages: 0,
                selectedBank: {}
            }
        },
        methods: {
            showAddBank() {

            },
            fetchBanks(name) {
                axios.get("/api/banks", {
                    params: {
                        page: this.page,
                        pageSize: 10
                    }
                })
                    .then(({data}) => {
                        data.content.forEach((item) => this.banks.push(item))
                        this.page++
                        this.totalPages = data.totalPages
                        this.isFetching = false
                    }, error => {
                        this.isFetching = false
                    })
            },
            getAsyncData: _debounce(function (name) {
                // String update
                if (this.bankName !== name) {
                    this.bankName = name
                    this.banks = []
                    this.page = 0
                    this.totalPages = 0
                }
                // String cleared
                if (!name.length) {
                    this.banks = []
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
                this.fetchBanks(name)
            }, 500),
            getMoreAsyncData: _debounce(function () {
                this.getAsyncData(this.bankName)
            }, 250)
        },
        watch: {
            selectedBank: function (val) {
                this.$emit('input', val.id);
            }
        }
    }
</script>
<style lang="scss" scoped>

</style>