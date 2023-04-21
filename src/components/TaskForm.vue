<template>
    <div class="task-form-wrap card inset no-select">
        <h1 class="title">Add Task</h1>
        <!-- @submit.prevent="submitForm" IN FORM-->
        <form class="form" >
            <vue-input :textArea="true" v-model="description" type="text" placeholder="Task description" />
            <vue-calendar :date="date" @changeDate="date = $event"></vue-calendar>
            <div class="buttons-wrap">
                <vue-button type="submit" class="submit-button">Add Task</vue-button>
            </div>
        </form>
    </div>
</template>
  
<script>
export default {
    name: "taskForm",
    data() {
        return {
            description: null,
            date: new Date(),
        };
    },
    methods: {
        submitForm() {
            if (!this.description || !this.date) {
                alert("Please fill in all fields");
            } else {
                // Send task data to server or perform other actions here
                console.log(`New task added: ${this.description} due on ${this.date}`);
                // Clear form inputs
                this.description = null;
                this.date = null;
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
    gap: 1rem;
}

.buttons-wrap {
    margin-top: 1rem;
}
</style>
  