<template>
  <vue-header />
  <main class="content-wrapper">
    <!-- {{ currentDate }} -->
    <!-- <div class="card">
      <vue-scrollable :blocksVisible="4" :listGap="24">
        <div v-for="i in 15" class="card" :key="i">{{ i }}</div>
      </vue-scrollable>
      

    </div> -->
    
    <!-- <div class="card">
      <vue-scrollable :isCarousel="true" :listGap="24" :blocksVisible="3" :scrollStep="2">
        <div class="card cards" v-for="_ in 15" :key="_" style="">{{ _ }}</div>
      </vue-scrollable >
      <vue-calendar :date="currentDate" @changeDate="currentDate = $event"/>
    </div> -->
    <!-- <login-form/> -->
    <task-form/>
    <!-- <div class="card no-padding">
      <vue-calendar :date="currentDate" @changeDate="currentDate = $event"/>
    </div> -->
  </main>
</template>

<script>
import './assets/css/style.css'
export default {
  data() {
    return {
      currentDate: new Date()
    }
  },
  methods: {
    func(k) {
      console.log('smth changed', k);
    }
  }
}
</script>

<style>
.cards {
  width: 10rem;
}
</style>
