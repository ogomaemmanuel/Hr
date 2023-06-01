<template>
  <section>
    <b-field>
      <template slot="label">
        <span>Trainer<sup>*</sup></span>
      </template>
      <b-autocomplete
          :data="data"
          field="fullName"
          :loading="isFetching"
          :check-infinite-scroll="true"
          @typing="getAsyncData"
          @select="option => selected = option"
          @infinite-scroll="getMoreAsyncData">
        <template slot-scope="props">
          <div class="media">
            <div class="media-content">
              {{ props.option.fullName }}
              <br>
            </div>
          </div>
        </template>
        <template #footer>
          <span v-show="page > totalPages" class="has-text-grey"> Thats it! No more movies found. </span>
        </template>
      </b-autocomplete>
      <div slot="message">
        <slot name="errors">
        </slot>
      </div>
    </b-field>
  </section>
</template>
<script>
export default {
  data() {
    return {

    }
  }
}
</script>