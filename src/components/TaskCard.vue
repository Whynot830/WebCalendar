<template>
  <div ref="task" :class="{'completed':completed}" class="card-container flex-center">
    <vue-checkbox :completed="completed" ref="checkbox" @change="complete"></vue-checkbox>
    <div class="card inset time">{{ formattedTime }}</div>
    <div class="card description">{{ formattedDescription }}</div>
  </div>
</template>

<script>
export default {
  name: 'taskCard',
  props: {
    time: {
      required: true,
      default: '00:00'
    },
    description: {
      type: [String, Number],
      required: true,
      default: '',
    },
    completed: {
      type: [Boolean],
      required: true,
      default: false,
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
    formattedTime() {
      // console.log(this.time.substring(0,5))
      return this.time.substring(0,5)
    }
  },
  mounted() {
    if (this.completed) this.$refs.checkbox.$refs.check.setAttribute('disabled', '')
  }
}
</script>

<style scoped>
.card-container {
  position: relative;
  padding: 1rem;
  gap: 3rem;
  justify-content: flex-start;
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
.time {
  padding: 0.5rem;
  width: 5rem; 
}
.card {
  text-align: center;
}
.description {
  width: max-content;
  flex: 1;
}
</style>