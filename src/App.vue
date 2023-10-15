<template>
  <vue-header v-if="$route.path != '/auth'"/>
  <router-view v-slot="{Component}">
    <transition name="fade" mode="out-in">
      <component :is="Component"/>
    </transition>
  </router-view>
</template>

<script>
import './assets/css/style.css'
export default {
  name: 'App',
}
</script>

<style>

.fade-enter-active,
.fade-leave-active {
  transition: opacity .1s ease;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}
</style>