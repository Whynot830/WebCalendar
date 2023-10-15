<template>
  <main class="content-wrapper">
    <div class="task-form-wrap card inset no-select">
      <h1 class="title">Add Task</h1>
      <!-- @submit.prevent="submitForm" IN FORM-->
      <div class="form">
        <vue-input :textArea="true" v-model="description" type="text" placeholder="Task description" />
        <vue-input :textArea="false" v-model="time" type="time" placeholder="time" />
        <vue-calendar :date="date" @changeDate="date = $event" />
        <div class="buttons-wrap">
          <vue-button type="submit" class="submit-button" @click="submitForm">Add Task</vue-button>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import axios from "@/axios";
import { authHeader } from "@/util";

export default {
  data() {
    return {
      description: null,
      time: null,
      date: new Date(),
    };
  },
  methods: {
    submitForm() {
      console.log(this.date)
      console.log(this.time)
      if (!this.description || !this.date || !this.time) {
        alert("Please fill in all fields");
      } else {
        const moment = require('moment')
        const dateStr = moment(this.date).format('YYYY-MM-DD')
        const data = { description: this.description, date: dateStr, time: this.time }
        console.log(data)
        axios.post('/tasks', data, authHeader()).then(res => {
          if (!res.data) {
            alert('error')
          }
          else {
            this.$router.push('/')
          }
        })


      }
    },
  },
};
</script>

<style scoped>
.task-form-wrap {
  width: 400px;
}
.title {
  margin-bottom: 1rem;
}
.form {
  display: flex;
  align-items: center;
  flex-flow: column nowrap;
  gap: 2.5rem;
}

.buttons-wrap {
  margin-top: 1rem;
}
</style>
