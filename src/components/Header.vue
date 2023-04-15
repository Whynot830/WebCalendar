<template>
    <header class="header no-select">
        <vue-input></vue-input>
        <div class="buttons">
            <vue-button></vue-button>
            <vue-button></vue-button>
            <vue-button></vue-button>
            <vue-button></vue-button>
        </div>
    </header>
</template>

<script>
export default {
    name: 'vueHeader',
    props: {
        pageTitle: String
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

.to-home-img,
.chevron {
    cursor: pointer;
    transition: filter 150ms;
}

.to-home-img {
    width: 2.5rem;
    margin-right: 1rem;
    margin-bottom: 3px;
}

.chevron {
    width: 3.5rem;
}

.nav-links {
    display: flex;
    gap: 2rem;
    margin-left: 1rem;
}

/* @media (min-width: 425px) {
    .header {
        padding: 0 2rem;
    }
    .to-home-img {
        margin-right: 1.5rem;
    }
    .chevron {
        margin-right: 0.5rem;
    }
}

@media (min-width: 1024px) {
    .header {
        padding: 0 5rem;
    }
}

@media (min-width: 1440px) {
    .header {
        padding: 0 10rem;
    }

    #page-title {
        display: flex;
    }

    .nav-links {
        gap: 3rem;
        margin-left: 2rem;
    }

    .logo {
        margin-right: 1rem;
    }
} */
</style>