<template>
    <div class="list-wrap">
        <div :style="`height: ${listHeight}px; gap: ${listGap}px`" class="list card inset" ref="list" id="list">
            <slot></slot>
        </div>
    </div>
</template>

<script>
export default {
    name: 'vueScrollable2',
    data() {
        return {
            blockHeight: 0
        }
    },
    props: {
        blocksVisible: {
            type: Number,
            default: 1,
        },
        listGap: {
            type: Number,
            default: 16,
        }
    },
    computed: {
        listHeight() {
            return this.blocksVisible * (this.blockHeight + this.listGap) - this.listGap
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

            this.blockHeight = firstChild.offsetHeight +
                marginTop + marginBottom
        }
    }
}
</script>

<style scoped>
.list {
    padding: 1.5rem 0.8rem 1.5rem 1.5rem;
    /* overflow-y: scroll;  */
    overflow-y: auto;

    display: flex;
    flex-flow: column;
}

.list-wrap {
    padding: 1rem 0;
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