<template>
    <div :style="`width: ${size}px; height: ${size}px`">
        <svg class="search-ico" viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg" fill="#555">
            <rect transform="rotate(-135 23.2656 23.5625)" stroke-width="2" rx="2" id="svg_7" height="3.125"
                width="16.11557" y="22" x="15.20784" fill="#555" />
            <ellipse stroke-width="3" stroke="#555" ry="9" rx="9" id="svg_9" cy="12" cx="12" fill="none" />
        </svg>
    </div>
</template>

<script>
export default {
    name: 'searchIco',
    props: {
        size: {
            type: Number,
            default: 32,
        }
    }
}
</script>

<style scoped>
.search-ico {
    width: 100%;
    height: 100%;
}
</style>