<template>
  <section>
    <b-field>
      <template slot="label">
        <span>Training Type<sup>*</sup></span>
      </template>
    </b-field>
    <b-autocomplete
        :data="data"
        field="type"
        :loading="isFetching"
        :check-infinite-scroll="true"
        @typing="getAsyncData"
        @select="option => selected = option"
        @infinite-scroll="getMoreAsyncData">
      <template slot-scope="props">
        <div class="media">
          <div class="media-content">
            {{ props.option.type }}
            <br>
          </div>
        </div>
      </template>
      <template #footer>
        <span v-show="page > totalPages" class="has-text-grey"> Thats it! No more movies found. </span>
      </template>
    </b-autocomplete>
    </b-field>
  </section>
</template>

<script>
import debounce from 'lodash/debounce'

export default {
  data() {
    return {
      data: [],
      selected: null,
      isFetching: false,
      name: '',
      page: 0,
      totalPages: 0
    }
  },
  methods: {
    // You have to install and import debounce to use it,
    // it's not mandatory though.
    getAsyncData: debounce(function (name) {
      // String update
      if (this.name !== name) {
        this.name = name
        this.data = []
        this.page = 0
        this.totalPages = 0
      }
      // String cleared
      if (!name.length) {
        this.data = []
        this.page = 0
        this.totalPages = 0
        return
      }
      // Reached last page
      if (this.page > this.totalPages) {
        return
      }
      this.isFetching = true
      axios.get(`/api/training-types`, {
        params: {
          page: this.page,
          pageSize: this.pageSize,
        }
      })
          .then(({data}) => {
            data.content.forEach((item) => this.data.push(item))
            this.page++
            this.totalPages = data.totalPages;
          })
          .catch((error) => {
            throw error
          })
          .finally(() => {
            this.isFetching = false
          })
    }, 500),
    getMoreAsyncData: debounce(function () {
      this.getAsyncData(this.name)
    }, 250)
  }
}
</script>