<template>
  <vue-header />
  <main class="content-wrapper">
    <!-- <div class="card">
      <vue-scrollable :blocksVisible="4" :listGap="24">
        <div v-for="i in 15" class="card" :key="i">{{ i }}</div>
      </vue-scrollable>
      
    </div>
    <vue-calendar></vue-calendar>
    <div class="card">
      <vue-scrollable :isCarousel="true" :listGap="16" :blocksVisible="4" :scrollStep="1">
        <div class="card cards" v-for="_ in 15" :key="_" style="">{{ _ }}</div>
      </vue-scrollable>
    </div> -->

    <vue-login></vue-login>

  </main>
</template>

<script>
import './assets/css/style.css'
export default {
  data() {
    return {
    }
  },
  methods: {
    
  }
}
</script>

<style>
.cards {
  width: 10rem;
}


</style>
