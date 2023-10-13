<template>
  <div class="flex-1 bg-white p-5">
    <div class="text-center">
      <h2>{{ status.name }}</h2>
    </div>
    <draggable class="draggable-list" @change="onChangeHandler" :list="tasks" group="task-group">
      <div class="list-item" v-for="task in tasks" :key="task.id">
        {{ task.name }}
      </div>
    </draggable>
  </div>
</template>
<script>
import draggable from "vuedraggable"

export default {
  components: {
    draggable,
  },
  props: {
    projectId: {
      required: true,
    },
    status: {
      required: true,
      type: Object
    }
  },
  data() {
    return {
      tasks: [
        {
          name: "Buy a car"
        }
      ]
    }
  },
  created() {
    this.getTasks();
  },
  methods: {

    onChangeHandler(event) {
      console.log("onChangeHandler", event);
      if (event.added) {
        this.tasks = [...this.tasks, ...event.added.element];

        //TODO update task status in the backend
        console.log()
        //this.updateTask();
      }
      if (event.removed) {
        this.tasks = this.tasks.filter(task => task.id != event.added.element.id);
      }
    },
    async updateTask(taskUpdate) {
      let resp = await axios.put("api/tasks", taskUpdate);
    },

    async getTasks() {
      try {
        let resp = await axios.get("/api/tasks", {
          params: {
            projectId: this.projectId,
            status: this.status,
          }
        })
        // this.tasks = resp.data;
      } catch (e) {
        console.log("Error fetching tasks")
      }
    }
  }
}
</script>