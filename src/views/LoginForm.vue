<template>
  <div class="login-wrap card inset" :class="{ 'sign-up-mode': isSignUp }">
    <div class="login-header">

      <transition-group name="slide">
        <div class="header-group" v-if="!isSignUp">
          <h1 class="title">Sign In</h1>
          <span class="label" v-if="!isSignUp" @click="toggleSignUpMode">New
            to WebCalendar?</span>
        </div>
        <div class="header-group" v-else>
          <h1 class="title">Sign Up</h1>
          <span class="label" v-if="isSignUp" @click="toggleSignUpMode">
            Already have an account?</span>
        </div>
      </transition-group>
    </div>

    <form class="form" @submit.prevent="submitForm">
      <vue-input v-model="username" type="email" placeholder="example@mail.com" />
      <vue-input class="pass" ref="pass1" v-model="password" type="password" placeholder="Password" />
      <div style="position: relative; height: 47.59px; width: 320px">
        <transition-group name="slide">
          <vue-input style="position: absolute" class="pass" ref="pass2" v-if="isSignUp" v-model="passwordConfirm"
            type="password" placeholder="Password" />
          <span v-else style="position: absolute" class="label">Forgot my password</span>
        </transition-group>
      </div>

      <div class="buttons-wrap" :class="{ 'sign-up-mode': isSignUp }">
        <transition-group name="slide">
          <vue-button class="login-button" v-if="!isSignUp">Sign In</vue-button>
          <vue-button class="login-button" v-if="isSignUp">Sign Up</vue-button>
        </transition-group>
      </div>

    </form>
  </div>
</template>

<script>

import axios from "@/axios";

export default {
  data() {
    return {
      username: null,
      password: null,
      passwordConfirm: null,
      isSignUp: false,
      title: ['Login', 'Sign Up'],
      isError: false,
    }
  },
  methods: {
    toggleSignUpMode() {
      this.isSignUp = !this.isSignUp
    },
    submitForm() {
      if (this.isSignUp && !(this.password === this.passwordConfirm)) {
        this.isError = true
        return
      }
      const data = { username: this.username, password: this.password }
      if (!this.isSignUp) {
        axios.post('/auth/login', {
          'username': this.username,
          'password': this.password
        }).then(res => {
          if (!res.data.token) {
            this.isError = true
          }
          else {
            localStorage.setItem('token', res.data.token)
            this.$router.push('/')
          }
        })
      }
      else {
        console.log(data)
        axios.post('/auth/register', data).then(res => {
          console.log(res.data);
          if (!res.data.token) {
            this.isError = true
          }
          else {
            this.isSignUp = false
          }
        })
      }
    }
  },
  watch: {
    isError() {
      this.password = null
      this.passwordConfirm = null
      if (this.isSignUp) {
        this.$refs.pass2.$el.classList.add('error')
        setTimeout(() => {
          if (!this.$refs.pass2)
            return
          this.$refs.pass2.$el.classList.remove('error')
        }, 1000)
      }
      else {
        this.$refs.pass1.$el.classList.add('error')
        setTimeout(() => {
          if (!this.$refs.pass1)
            return
          this.$refs.pass1.$el.classList.remove('error')
        }, 1000)
        this.password = null
      }
      this.isError = false
    }
  }
}
</script>

<style scoped>
.login-wrap {
  /* max-height: 326px;
  height: 326px; */
  overflow: hidden;
  position: relative;
  width: 400px;
  justify-self: center;
  grid-row: span 2;
  align-self: center;
  /* transition: max-height 0.3s ease-in-out, height 0.3s ease-in-out; */
}

/* .login-wrap.sign-up-mode {
    max-height: 400px;
    height: 400px;
} */

.login-header {
  position: relative;
  height: 43px;
  margin-bottom: 1rem;
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
}

.header-group {
  position: absolute;
  display: flex;
  width: 100%;
  justify-content: space-between;
  align-items: center;
}

.form {
  display: flex;
  align-items: center;
  flex-flow: column nowrap;
  gap: 1rem;
}

.pass {
  transition: background-color 0.2s ease-in-out, transform 0.3s cubic-bezier(0, -0.88, 1, 1.73);
}

.pass.error {
  background-color: rgba(226, 17, 17, 0.315);
  animation: shake 0.1s ease-in-out 3;
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
  transition: transform 0.3s ease-in-out;
}

/* .buttons-wrap.sign-up-mode {
    transform: translateY(1rem);
} */

.label.sign-up-mode {
  opacity: 0;
  pointer-events: none;
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

@keyframes shake {
  0% {
    transform: translateX(0);
  }

  25% {
    transform: translateX(-4px);
  }

  50% {
    transform: translateX(0px);
  }

  75% {
    transform: translateX(4px);
  }

  100% {
    transform: translateX(0);
  }
}
</style>