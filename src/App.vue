<template>
  <vue-header />
  <main class="content-wrapper">
    <!-- <div class="card">
      <vue-scrollable :blocksVisible="4" :listGap="24">
        <div v-for="i in 15" class="card" :key="i">{{ i }}</div>
      </vue-scrollable>
      <vue-calendar></vue-calendar>
    </div>
    <div class="card">
      <vue-scrollable :isCarousel="true" :listGap="16" :blocksVisible="4" :scrollStep="1">
        <div class="card cards" v-for="_ in 15" :key="_" style="">{{ _ }}</div>
      </vue-scrollable>
    </div> -->

    <div class="login-wrap card inset">
      <div class="login-header">
        <h1>{{ title[isSignUp ? 1 : 0] }}</h1>
        <span class="label" :class="{ 'sign-up-mode': isSignUp }" @click="toSignUp">New to WebCalendar?</span>
      </div>

      <form class="form">
        <vue-input type="email" class="email" placeholder="example@mail.com" />
        <vue-input type="password" class="password" placeholder="Password" />

        <span class="label" :class="{ 'sign-up-mode': isSignUp }">Forgot my password</span>

        <div class="buttons-wrap" :class="{ 'sign-up-mode': isSignUp }">
          <TransitionGroup name="slide">
            <vue-button class="login-button" v-if="!isSignUp">Sign In</vue-button>
            <vue-button class="login-button" v-if="isSignUp">Sign Up</vue-button>
          </TransitionGroup>
        </div>


      </form>
    </div>

  </main>
</template>

<script>
import './assets/css/style.css'
export default {
  data() {
    return {
      isSignUp: false,
      title: ['Login', 'Sign Up'],
    }
  },
  methods: {
    toSignUp() {
      this.isSignUp = true
    },
    toLogin() {
      this.isSignUp = false
    }
  }
}
</script>

<style>
.cards {
  width: 10rem;
}

.login-wrap {
  overflow-x: hidden;
  max-height: 100%;
  width: 350px;
}

.login-header {
  margin-bottom: 1rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.form {
  display: flex;
  align-items: center;
  flex-flow: column nowrap;
  gap: 1rem;
}

.label {
  cursor: pointer;
  position: relative;
  transition: opacity 0.2s ease-in-out;
}

.label::after {
  content: "";
  position: absolute;
  left: 0;
  bottom: 0px;
  width: 0;
  height: 2px;
  background-color: black;
  transition: width 0.2s ease-in-out;
}

.label:hover::after {
  width: 100%;
}

.buttons-wrap {
  position: relative;
  width: 10rem;
  height: 54px;
  transition: transform 0.3s 0.25s ease-in-out;
}

.buttons-wrap.sign-up-mode {
  transform: translateY(-1rem);
}

.label.sign-up-mode {
  opacity: 0;
}

.login-button {
  margin: 0 !important;
  position: absolute;
  top: 0;
  width: 100% !important;
}

.slide-enter-active,
.slide-leave-active {
  transition: all 0.4s ease-in-out;
}

.slide-enter-from {
  transform: translateX(300%);
}

.slide-leave-to {
  transform: translateX(-300%);
}

/* .slide-enter-to,
.slide-leave {
  transform: translateX(-100%);
} */
</style>
