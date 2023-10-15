<template>
    <main class="content-wrapper">
        <h3 class="page-title card">Личный кабинет</h3>
        <div class="flex-center">
            <div class="card flex-center profile-wrap">
                <div class="info">
                    <span class="bold">Имя пользователя</span>
                    <span class="value">{{ userInfo.username }}</span>
                    <span class="bold">Пароль</span>
                    <span class="value">*********</span>
                    <h1>WiP</h1>
                    <h1>...</h1>
                </div>
                <div class="svg-wrap">
                    <img class="svg" src="@/assets/imgs/logout.svg" @click="logout" />
                </div>
            </div>
        </div>
    </main>
</template>
<script>
import axios from '@/axios'
import { authHeader } from '@/util'
export default {
    data() {
        return {
            userInfo: {}
        }
    },
    methods: {
        logout() {
            localStorage.removeItem('token')
            this.$router.push('/authenticate')
        },
        async getInfo() {
            axios.get('/auth/profile', authHeader())
                .then(response => {
                    this.userInfo = response.data
                    this.userInfo.createdAt = new Date(this.userInfo.createdAt).toLocaleString()
                })
                .catch(error => console.log(error))
        }
    },
    async mounted() {
        await this.getInfo()
    }
}
</script>

<style scoped>
.page-title {
    margin: 0 auto;
}
.info {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 1rem;
    align-items: center;
}

.value {
    backdrop-filter: invert(0.05);
    padding: 0.5rem;
    border-radius: 1rem;
    width: fit-content;
}

.profile-wrap {
    gap: 2rem;
}

.svg {
    width: 2.5rem;
}

.svg-wrap {
    align-self: self-start;
    position: relative;
    height: 2.4rem;
}

.svg-wrap::after {
    content: "Выйти из аккаунта";
    backdrop-filter: invert(0.2);
    padding: 0.5rem;
    border-radius: 1rem;
    bottom: -2.5rem;
    right: -4rem;
    width: max-content;
    position: absolute;
    opacity: 0;
    transition: opacity 0.1s ease-in-out;
    pointer-events: none;
}

.svg-wrap:hover::after {
    opacity: 1;
    transition: opacity 0.1s 0.4s ease-in-out;
}</style>