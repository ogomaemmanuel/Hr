<template>
    <div>
        <div class="pb-2 flex justify-end">

            <portal to="page-controls">
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

                        <router-link
                                to="/client-create"
                                tag="button"
                                class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
                            <span>
					 Create Project
				</span>
                        </router-link>
                    </p>
                </button>
            </portal>
        </div>
        <ProjectsCardList></ProjectsCardList>
    </div>
</template>
<script>
    import ProjectsCardList from "./ProjectsCardList";

    export default {
        components: {
            ProjectsCardList
        },
        data() {
            return {

            }
        }
    }
</script>