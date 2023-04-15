<template>
  <vue-header/>
  <main class="content-wrapper">
    <div class="card">
      <vue-scrollable :isCarousel="true" :blocksVisible="4" :listGap="24">
        <div v-for="i in 15" class="card" :key="i">{{ i }}</div>
      </vue-scrollable>
      <vue-calendar></vue-calendar>
    </div>
    <div class="card">
      <vue-scrollable :listGap="16" :blocksVisible="4" :scrollStep="2">
        <div class="card cards" v-for="_ in 15" :key="_" style="">{{ _ }}</div>
      </vue-scrollable>
    </div>
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
.ff {
  width: 5rem;
  height: 5rem;
  background-color: aqua;
  border: solid 1px black;
}

.cards {
  width: 10rem;
}
</style>
