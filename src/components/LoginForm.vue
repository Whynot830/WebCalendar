<template>
    <div class="login-wrap card inset">
        <div class="login-header">
            <h1>{{ title[isSignUp ? 1 : 0] }}</h1>
            <transition-group name="slide">
                <span style="position: absolute; right: 3rem" class="label" v-if="!isSignUp" @click="toggleSignUpMode">New
                    to WebCalendar?</span>
                <span style="position: absolute; right: 3rem" class="label" v-if="isSignUp"
                    @click="toggleSignUpMode">Already have an account?</span>
            </transition-group>

        </div>

        <form class="form">
            <vue-input type="email" placeholder="example@mail.com" />
            <vue-input type="password" placeholder="Password" />

            <span class="label" :class="{ 'sign-up-mode': isSignUp }">Forgot my password</span>

            <div class="buttons-wrap" :class="{ 'sign-up-mode': isSignUp }">
                <TransitionGroup name="slide">
                    <vue-button class="login-button" v-if="!isSignUp">Sign In</vue-button>
                    <vue-button class="login-button" v-if="isSignUp">Sign Up</vue-button>
                </TransitionGroup>
            </div>

        </form>
    </div>
</template>

<script>
export default {
    name: 'vueLogin',
    data() {
        return {
            isSignUp: false,
            title: ['Login', 'Sign Up'],
        }
    },
    methods: {
        toggleSignUpMode() {
            this.isSignUp = !this.isSignUp
        }
    }
}
</script>

<style scoped>
.login-wrap {
    overflow-x: hidden;
    position: relative;
    max-height: 100%;
    width: 400px;
}

.login-header {
    margin-bottom: 1rem;
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
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
    transition: transform 0.3s ease-in-out;
}

.buttons-wrap.sign-up-mode {
    transform: translateY(-1rem);
}

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
    transform: translateX(300%);
}

</style>