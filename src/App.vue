<template>
  <vue-header />
  <main class="content-wrapper">
    <!-- <div class="card">
      <vue-scrollable :blocksVisible="4" :listGap="24">
        <div v-for="i in 15" class="card" :key="i">{{ i }}</div>
      </vue-scrollable>
      

    </div> -->

    <!-- <login-form/> -->

    <div class="card">
      <task-list @complete="completeTask" :tasks="tasks" :tasksVisible="3" :scrollStep="3" />
      <vue-calendar :date="currentDate" @changeDate="currentDate = $event" />
    </div>

  </main>
</template>

<script>
import './assets/css/style.css'
export default {
  data() {
    return {
      currentDate: new Date(),
      tasks: [{ id: 1, date: new Date(2023, 2, 2), description: 'DESCRIPTION' },
      { id: 2, date: new Date(2022, 2, 2), description: 'DESCRIPTION' },
      { id: 3, date: new Date(2021, 2, 2), description: 'DESCRIPTION' },
      { id: 4, date: new Date(2020, 2, 2), description: 'DESCRIPTION' },
      { id: 5, date: new Date(2019, 2, 2), description: 'DESCRIPTION' },
      { id: 6, date: new Date(2018, 2, 2), description: 'DESCRIPTION' }],
    }
  },
  methods: {
    completeTask(id) {
      setTimeout(() => {
        let index = this.tasks.findIndex(task => task.id == id)
        if (index !== -1) {
          this.tasks.push(this.tasks.splice(index, 1)[0])
        }
      }, 500)

    },
  }
}
</script>

<style>
.cards {
  width: 10rem;
}
</style>
