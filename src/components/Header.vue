<template>
  <header class="header no-select">
    <div class="flex-center search-wrap">
      <vue-input v-model="searchQuery" @change="setQuery" class="search-bar" v-if="$route.path === '/'" />
      <search-ico class="search-ico" />
    </div>
    <div class="flex-center">
      <vue-button class="header-button" @click="this.$router.push('/add-task')" v-if="$route.path === '/'">
        <x-ico :rotationDegree=45></x-ico>
      </vue-button>
      <vue-button class="header-button" @click="this.$router.push('/profile')" v-if="$route.path !== '/profile'">
        <img src="@/assets/imgs/user.svg" class="svg">
      </vue-button>
      <vue-button class="header-button" @click="this.$router.push('/')" v-if="$route.path !== '/'">
        <img src="@/assets/imgs/home.svg" class="svg">
      </vue-button>
    </div>
  </header>
</template>

<script>
export default {
  name: 'vueHeader',
  props: {
    pageTitle: String
  },
  data() {
    return {
      searchQuery: ''
    }
  },
  methods: {
    setQuery() {
      this.$store.commit('SET_SEARCH_QUERY', this.searchQuery)
      this.searchQuery = ''
    }
  },
}
</script>

<style scoped>
.header {
  display: flex;
  position: relative;
  justify-content: space-between;
  align-items: center;
  background-color: var(--background-light);
  box-shadow: 0 0 15px -10px black;
  padding: 1rem;
}

.search-wrap {
  position: relative;
}

.search-wrap:has(.search-bar.inset, .search-bar:focus) {
  transform: translate(1px);
}

.search-bar {
  padding-right: 3.5rem !important;
  transform: unset !important;
}

.search-ico {
  pointer-events: none;
  position: absolute;
  right: 1rem;
}

.header-button {
  padding: 0.5rem !important;
  width: 3rem !important;
  height: 3rem !important;
}

.logo {
  width: 2.7rem;
  height: 2.7rem;
}

#page-title {
  display: none;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  justify-content: center;
  align-items: center;
  font-size: 1.6rem;
}

nav {
  z-index: 1;
}
</style>