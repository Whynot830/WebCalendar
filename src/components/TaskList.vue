<template>
  <vue-scrollable :isCarousel="true" :scrollStep="scrollStep" :blocksVisible="tasksVisible" :listGap="24">
    <transition name="fade" mode="out-in">
      <div style="position: relative;" v-if="tasks.length">
        <transition-group  name="slide" :key="0">
        
        <task-card class="task" @complete="this.$emit('complete', task.id)" v-for="task in tasks" :time="task.time"
          :description="task.description" :completed="task.completed" :key="task.id" :ref="`task-${task.id}`" />
      </transition-group>
      </div>
      <div v-else class="message flex-center" :key="1">
        Заданий не найдено
      </div>
    </transition>
  </vue-scrollable>
</template>

<script>
export default {
  name: 'taskList',
  props: {
    tasksVisible: {
      required: true,
      default: 0,
    },
    scrollStep: {
      default: 1
    },
    tasks: {
      type: Array,
      default: () => []
    }
  }
}
</script>

<style scoped>
.slide-move,
.slide-enter-active,
.slide-leave-active {
  transition: all 0.4s ease-in-out;
}
.slide-enter-from,
.slide-leave-to {
  transform: translateX(-100%);
  opacity: 0;
}
.slide-leave-active {
  position: absolute;
}
.message {
  height: 80%;
}
</style>