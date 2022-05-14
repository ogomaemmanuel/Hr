<template>
    <div>
        <div class="card">
            <div class="card-content">
                <div class="mb-8 text-center underline uppercase">
                    <b-skeleton size="is-large"></b-skeleton>
                </div>
                <div class="columns">
                    <div class="column is-4 m-b-20">
                        <p class="image is-64x64 mb-4">
                            <b-skeleton circle width="64px" height="64px"></b-skeleton>
                        </p>
                        <b-skeleton size="is-large"></b-skeleton>
                    </div>
                    <div class="column is-4 is-offset-4 m-b-20">
                        <div class="flex sm:items-start lg:items-end flex-col">
                            <b-skeleton size="is-large"></b-skeleton>
                        </div>
                    </div>
                </div>
                <div class="columns">
                    <div class="column is-4 m-b-20">
                        <b-skeleton size="is-large"></b-skeleton>
                    </div>
                </div>
                <div class="columns">
                    <div class="column is-6">
                        <b-skeleton size="is-large"></b-skeleton></div>
                    <div class="column is-6">
                        <b-skeleton size="is-large"></b-skeleton></div>
                </div>
                <div class="columns">
                    <div class="column is-12">
                        <b-skeleton size="is-large"></b-skeleton>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
    }
</script>
<style lang="scss" scoped>
</style>