<template>
    <textarea v-if="textArea" class="input neu" />

    <input v-else class="input neu" :value="modelValue" @input="updateValue" type="text">
</template>

<script>

export default {
    name: 'vueInput',
    props: {
        modelValue: [String, Number],
        textArea: {
            type: Boolean,
            default: false
        }
    },
    methods: {
        updateValue(event) {
            this.$emit('update:modelValue', event.target.value)
        }
    }
}
</script>

<style scoped>
.input {
    font-size: 1rem;
    outline: none;
    border: none;
    height: fit-content;
    width: 100%;
    max-width: 20rem;
    border-radius: 2rem;
    padding: 0.8rem 1rem;
    color: var(--text-light);
    background-color: var(--ui-main);
}

textarea.input {
    padding-left: 1.2rem;
    padding-right: 1.2rem;
    resize: vertical;
    min-height: 3rem;
    height: 7.5rem;
    max-height: 15rem;
}

.input:focus {
    box-shadow: inset 1.8px 1.8px 3px #C6C6C6, inset -1.8px -1.8px 3px #FAFAFA;
    padding-left: 1.05rem;
    transform: translate(1px)
}

</style>