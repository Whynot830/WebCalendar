<template>
  <main class="content-wrapper">
    <!--     <div class="card">
      <vue-scrollable :blocksVisible="4" :listGap="24">
        <div v-for="i in 15" class="card" :key="i">{{ i }}</div>
      </vue-scrollable>


    </div>-->

    <!-- <login-form/> -->

    <div class="card wrap">
      <!-- <div v-if="loading">Loading...</div> -->
      <task-list @complete="completeTask" :tasks="sortedAndSearchedTasks" :tasksVisible="3" :scrollStep="3" />
      <div style="padding: 1.5rem 2.5rem">
        <vue-calendar :date="currentDate" @changeDate="currentDate = $event" />
      </div>
    </div>

  </main>
</template>

<script>
import axios from "@/axios";
import { authHeader } from "@/util";
import { mapGetters } from 'vuex'
export default {
  data() {
    return {
      currentDate: new Date(),
      tasks: [],
      loading: true
    }
  },
  methods: {
    async getTasks() {
      var month = this.currentDate.getMonth() + 1
      month = month > 9 ? month : `0${month}`
      const path = `${this.currentDate.getDate()}.${month}.${this.currentDate.getFullYear()}`
      axios.get('/tasks/' + path, authHeader()).then(res => {
        this.tasks = res.data
        this.loading = false
      })
    },

    completeTask(id) {
      axios.post('/tasks/' + id + "/complete", {}, authHeader()).then(() => {
        setTimeout(() => { this.getTasks() }, 500)
      })


    },
  },
  async mounted() {
    await this.getTasks()
  },
  watch: {
    currentDate() {
      this.loading = true
      setTimeout(() => {
        this.getTasks()
      }, 100)
    }
  },
  computed: {
    ...mapGetters([
      'SEARCH_QUERY'
    ]),
    sortedTasks() {
      return [...this.tasks]
        .filter(task => !task.completed)
        .sort((task1, task2) => task1.time.localeCompare(task2.time))
        .concat(...this.tasks.filter(task => task.completed).sort((task1, task2) => task1.time.localeCompare(task2.time)))
    },
    sortedAndSearchedTasks() {
      return this.sortedTasks.filter(task =>
        task.description.toLowerCase().includes(this.SEARCH_QUERY.toLowerCase()))
    }
  }
}
</script>

<style>
.wrap {
  width: 70%;
}
</style>