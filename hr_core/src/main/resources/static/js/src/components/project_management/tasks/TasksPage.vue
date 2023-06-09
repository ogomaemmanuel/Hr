<template>
  <div class="task-page h-full columns is-gapless">
    <div class="project-list column is-one-fifth">
      <ProjectList :key="currentProject.id" @projectSelected="setCurrentProject"></ProjectList>
    </div>
    <div class="project-task-list column">
      <div class="task-list-header pl-5 pr-5 pb-3 pt-3 bg-white flex items-center">
        <div class="flex-1">
          <button @click="showAddTaskInput=!showAddTaskInput" class="button">Add task</button>
        </div>
        <div>
       <span class="icon">
       <i class="fa fa-cog fa-2x"></i>
        </span>
        </div>
      </div>
      <div class="p-5">
        <div class="task-list-item-container">
        <div v-for="(task,index) in tasks"
             :key="index"
             class="task-list-item bg-white mt-0 p-2">
          {{ task.title }}
        </div>
        </div>
        <div v-if="showAddTaskInput">
          <input class="input" v-model="taskCreateRequest.title" placeholder="Enter new task here ..." type="text">
          <div class="flex justify-end mt-3 gap-1">
            <button @click="showAddTaskInput=!showAddTaskInput" class="button is-light">Close</button>
            <button @click="createTask" class="button">
              Add Task
            </button>
          </div>
        </div>
      </div>

    </div>
    <div class="project-details column bg-white">

      <div
          class="project-details-header border-solid	 border-b border-slate-200 pr-5 pl-5 pb-4 pt-4 flex items-center">
        <div class="flex-1">
          <button class="button">
          <span class="icon">
      <i class="fa fa-check"></i>
    </span>
            <span>Mark Complete</span>
          </button>
        </div>
        <span class="icon">
           <i class="fa fa-ellipsis-v"></i>
        </span>
      </div>

      <div class="project-details-footer border-t border-slate-200 pr-5 pl-5 pb-4 pt-4">
        <div>
          <input placeholder="Type message..." class="input" type="text"></input>
        </div>
        <div class="flex justify-start items-center mt-3 gap-2">
          <span>Followers</span>
          <figure class="image is-32x32">
            <img src="/images/undraw_profile_pic_ic-5-t.svg">
          </figure>
          <figure class="image is-32x32">
            <img src="/images/undraw_profile_pic_ic-5-t.svg">
          </figure>
          <figure class="image is-32x32">
            <img src="/images/undraw_profile_pic_ic-5-t.svg">
          </figure>
        </div>
      </div>
    </div>

  </div>
</template>
<script>
import _throttle from "lodash.throttle"
import ProjectList from "./ProjectList";

export default {
  components: {
    ProjectList
  },
  data() {
    return {
      page: 0,
      pageSize: 10,
      projects: [],
      loading: false,
      loaded: false,
      showAddTaskInput: false,
      taskCreateRequest: {},
      currentProject: {},
      tasks: []
    }
  },
  created() {
    this.getProjects();
  },
  methods: {
    getProjects() {
      let vm = this;
      let request = {
        page: vm.page,
        pageSize: vm.pageSize
      }
      vm.loading = true;
      axios.get("/api/projects",
          {params: request}).then(resp => {
        vm.loaded = true;
        vm.loading = false;
        vm.projects.push(...resp.data.content);
        if (resp.data.totalPages > vm.page) {
          vm.page++;
        }
      }, error => {
        vm.loading = false;
      })
    },
    async createTask() {
      this.taskCreateRequest.projectId = this.currentProject.id;
      let result = await axios.post("/api/tasks", this.taskCreateRequest)
      this.tasks = [...this.tasks, result.data];
      this.taskCreateRequest = {}
    },
    setCurrentProject(project) {
      this.currentProject = project;
    },
    fetchMoreProjects: _throttle(function (event) {
          let vm = this;
          if (event.deltaY > 0) {
            vm.getProjects();
          }
        },
        2000),
  }
}
</script>
<style scoped lang="scss">
.task-page {
  margin-top: 3.25rem;
  min-height: 100%;

  .project-list {
    background-color: #34444c;
    min-height: 100%;
  }

  .project-details {
    position: relative;

    .project-details-footer {
      position: absolute;
      bottom: 0px;
      left: 0px;
      right: 0px;
    }
  }

  .task-list-item-container:first-child {
    border-bottom: none;
  }
  .task-list-item-container{
    .task-list-item{
      border: 1px solid #eaeaea;
    }
  }
}
</style>