<template>
    <div class="h-full">
        <div class="pb-2 flex justify-end">
            <button>
                <p class="buttons">
                    <button @click="showTableList=false" class="button">
    <span class="icon is-small">
      <i class="fa fa-bars"></i>
    </span>
                    </button>
                    <button class="button" @click="showTableList=true">
    <span class="icon is-small">
      <i class="fa fa-th"></i>
    </span>
                    </button>
                </p>
            </button>
            <portal to="page-controls">
                <router-link
                        to="/client-create"
                        tag="button"
                        class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
                    <span>
					 Add Client
				</span>
                </router-link>
                <a
                        href="/api/holidays/excel-report"
                        class="button is-rounded">
				<span class="icon">
					<i class="fa fa-download mr-1"></i>
				</span>
                    <span>
					 Export
				</span>
                </a>
            </portal>
        </div>
        <div class="columns h-full">
            <div class="column is-12">
                <ClientTableList v-if="showTableList"></ClientTableList>
                <ClientCardList v-else></ClientCardList>
            </div>
        </div>
        <router-view></router-view>
    </div>
</template>
<script>
    import ClientCardList from "./ClientCardList";
    import ClientTableList from "./ClientTableList";

    export default {
        components: {
            ClientCardList,
            ClientTableList
        },
        data() {
            return {
                showTableList: false,
            }

        }
    }
</script>