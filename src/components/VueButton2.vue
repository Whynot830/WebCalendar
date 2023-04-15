<template>
    <button class="button">
        <slot></slot>
    </button>
</template>

<script>

export default {
    name: 'vueButton2'
}
</script>
<style scoped>

.button {
    font-size: 1rem;
    outline: none;
    border: none;
    cursor: pointer;
    color: var(--text-light);
    background-color: var(--button);
    width: max-content;
    height: fit-content;
    margin: 10px;
    padding: 1rem;
    border-radius: 3rem;
    transition: 150ms;
}

.button:focus-visible,
.button:hover {
    background-color: var(--button-hover);
}

.button:active {
    background-color: var(--button);
}

</style>