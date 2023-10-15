<template>
  <div class="dialog" v-show="show" @click="hideDialog">
    <div @click.stop class="dialog-content">
      <slot></slot>
    </div>
  </div>
</template>

<script>

export default {
  name: 'dialogWindow',
  props: {
    show: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    hideDialog() {
      this.$emit('update:show', false)
    }
  },
}

</script>
<style scoped>
.dialog {
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.3);
  position: fixed;
  display: flex;
}

.dialog-content {
  position: relative;
  margin: auto;
  min-height: 4rem;
  max-width: 80%;
}
</style>