<template>
    <div ref="task" class="card-container flex-center">
        <vue-checkbox ref="checkbox" @change="complete"></vue-checkbox>
        <span>{{ formattedDate }}</span>
        <div class="card">{{ formattedDescription }}</div>
    </div>
</template>

<script>
    export default {
     name: 'taskCard',
     props: {
        date: {
            required: true,
            default: new Date()
        },
        description: {
            type: [String, Number],
            required: true,
            default: '',
        }
     },
     methods: {
        complete() {
            this.$refs.checkbox.$refs.check.setAttribute('disabled', '')
            this.$refs.task.classList.add('completed')
            this.$emit('complete')
        }
     },
     computed: {
        formattedDescription() {
            return this.description.slice(0, 25) + ('...'.repeat(this.description.length > 25))
        },
        formattedDate() {
            return `${this.date.getMonth() + 1}/${this.date.getDate()}/${this.date.getFullYear()}`
        }
     }
    }
</script>

<style scoped>
.card-container {
    position: relative;
    padding: 1rem;
    gap: 1rem;
}
.card-container::after {
    content: '';
    position: absolute;
    left: 0;
    background-color: black;
    width: 0;
    height: 2px;
    border-radius: 5px;
    transition: width 150ms ease-in-out;
}
.card-container.completed::after {
    width: 100%;
}
</style>