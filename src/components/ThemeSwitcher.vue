<template>
    <div class="switcher" @click="toggle">
      <TransitionGroup name="fade">
        <img class="switcher-img svg" :key="1" v-if="!isDark" src="@/assets/imgs/sun.svg">
        <img class="switcher-img svg" v-else :key="2" src="@/assets/imgs/moon.svg">
      </TransitionGroup>
    </div>
  </template>
  
  <script>
  export default {
    name: 'themeSwitcher',
    data() {
      return {
        isDark: false
      }
    },
    methods: {
      toggle() {
        this.isDark = !this.isDark
        this.$emit('toggleDark')
      }
    }
  }
  </script>
  
  <style scoped>
  img {
    width: 1rem;
  }
  .switcher {
    position: relative;
    display: flex;
    flex-flow: column nowrap;
    width: 2rem;
    height: 2rem;
    cursor: pointer;
  }
  .switcher-img {
    position: absolute;
    width: 2rem;
  }
  .fade-enter-active, .fade-leave-active {
    transition: all 0.5s;
  }
  
 .fade-leave-to {
    transform: translateY(-100%);
    opacity: 0;
  }
  .fade-enter-from {
    transform: translateY(50%);
    opacity: 0;
  }
  </style>
