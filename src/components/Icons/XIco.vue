<template>
    <div :style="`transform: rotate(${rotationDegree}deg); width: ${size}px; height: ${size}px`">
        <svg class="x" xmlns="http://www.w3.org/2000/svg">
            <rect x="2" y="14.5" width="28" height="3" transform="rotate(45 16 16)"  rx="2" ry="2"/>
            <rect x="2" y="14.5" width="28" height="3" transform="rotate(135 16 16)" rx="2" ry="2" />
        </svg>
    </div>
</template>

<script>
export default {
    name: 'xIco',
    props: {
        size: {
            type: Number,
            default: 32,
        },
        rotationDegree: {
            type: Number,
            default: 0,
        }
    }
}
</script>

<style scoped>

.x {
    width: 100%;
    height: 100%;
    fill: #555;
}
</style>