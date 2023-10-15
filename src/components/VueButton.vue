<template>
  <button class="button neu flex-center" tabIndex="0">
    <slot></slot>
  </button>
</template>

<script>

export default {
  name: 'vueButton'
}
</script>
<style scoped>

.button {
  font-size: 1rem;
  outline: none;
  border: none;
  cursor: pointer;
  color: var(--text-light);
  background-color: var(--ui-main);
  width: max-content;
  height: fit-content;
  margin: 10px;
  padding: 1rem;
  border-radius: 3rem;
}

.button:focus-visible {
  box-shadow: 2.4px 2.4px 7px #9E9E9E, -2.4px -2.4px 7px #FFFFFF;
}

.button:active {
  box-shadow: inset 1.8px 1.8px 3px #C6C6C6, inset -1.8px -1.8px 3px #FAFAFA;
  transform: translate(1px);
}
</style>