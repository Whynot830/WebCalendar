<template>
  <div class="carousel-wrap">
    <vue-button class="scroll-button no-margin no-padding" v-if="isCarousel" @click="scrollUp">
      <chevron-ico class="no-select" :rotationDegree="90" />
    </vue-button>
    <div class="list-wrap">
      <div :style="`height: ${listHeight}px; gap: ${listGap}px;`" :class="{ 'scrollbar-visible': !isCarousel }"
        class="list card inset" ref="list" id="list">
        <slot></slot>
      </div>
    </div>
    <vue-button class="scroll-button no-margin no-padding" v-if="isCarousel" @click="scrollDown">
      <chevron-ico class="no-select" :rotationDegree="270" />
    </vue-button>
  </div>
</template>
  
<script>
export default {
  name: 'vueScrollable',
  props: {
    isCarousel: {
      type: Boolean,
      default: false,
    },
    scrollStep: {
      type: Number,
      default: 1
    },
    blocksVisible: {
      type: Number,
      default: 1,
    },
    listGap: {
      type: Number,
      default: 16,
    }
  },
  data() {
    return {
      currentBlock: null,
      list: null,
      stepHeight: 0,
      blockHeight: 0,
      paddingTop: 0,
    }
  },
  methods: {
    scrollDown() {
      this.currentBlock = Math.round(this.list.scrollTop / this.stepHeight) + this.scrollStep

      this.list.scrollTo({
        top: this.currentBlock * this.stepHeight,
        behavior: 'smooth'
      })
    },
    scrollUp() {
      this.currentBlock = Math.max(
        Math.round(this.list.scrollTop / this.stepHeight) - this.scrollStep, 0
      )

      this.list.scrollTo({
        top: this.currentBlock * this.stepHeight,
        behavior: 'smooth'
      })
    }
  },
  computed: {
    listHeight() {
      return this.blocksVisible * (this.blockHeight + this.listGap) - this.listGap + this.paddingTop * 2
    },
  },
  mounted() {
    this.list = this.$refs.list

    const firstChild = this.list.children[0]
    if (firstChild) {
      Array.from(this.list.children).forEach(child => {
        child.style.flexShrink = 0
        child.style.flexGrow = 0
      })
      const computedStyle = getComputedStyle(firstChild)
      const marginTop = parseInt(computedStyle.marginTop)
      const marginBottom = parseInt(computedStyle.marginBottom)

      this.paddingTop = parseInt(getComputedStyle(this.list).paddingTop)
      this.blockHeight = firstChild.offsetHeight + marginTop + marginBottom
      this.stepHeight = this.blockHeight + this.listGap
    }
  }
}
</script>
  
<style scoped>
.carousel-wrap {
  display: flex;
  flex-flow: column nowrap;
  align-items: center;
  justify-content: center;
}
.scroll-button {
  width: 3rem !important;
  height: 3rem !important;
}
.list {
  overflow-y: hidden;
  display: flex;
  flex-flow: column;
}

.list-wrap {
  padding: 1rem 0;
}

.scrollbar-visible {
  overflow-y: auto;
  padding: 1.5rem 0.8rem 1.5rem 1.5rem;
}

::-webkit-scrollbar-button:start:increment {
  height: 10%;
}

::-webkit-scrollbar-button:end:increment {
  height: 10%;
}

::-webkit-scrollbar-track {
  background: transparent;
}
</style>
  