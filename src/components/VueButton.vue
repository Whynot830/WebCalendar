<template>
    <button class="button neu interactive" tabindex="0">
        <slot></slot>
    </button>
</template>

<script>

export default {
    name: 'vueButton'
}
</script>
<style scoped>

.button {
    font-size: 1rem;
    outline: none;
    border: none;
    cursor: pointer;
    color: var(--text-light);
    background-color: var(--ui-main);
    width: max-content;
    height: fit-content;
    margin: 10px;
    padding: 1rem;
    border-radius: 3rem;
}
.button:focus-visible {
    box-shadow: 2.4px 2.4px 7px #9E9E9E, -2.4px -2.4px 7px #FFFFFF;
}
.button:active {
    transform: translate(1px);
}
</style>