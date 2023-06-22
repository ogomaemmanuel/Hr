<template>
  <div class="flex-1 bg-white p-5">
    <div class="text-center">
      <h2>{{ status }}</h2>
    </div>
    <draggable class="draggable-list" :list="tasks" group="task-group">
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
      type: String
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
  }
}
</script>