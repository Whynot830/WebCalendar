<template>
    <div :style="`transform: rotate(${rotationDegree}deg); width: ${size}px`" class="chevron-wrap flex-center">
        <svg class="chevron" id="eSv0UgNrfP91" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
            viewBox="0 0 32 32" shape-rendering="geometricPrecision" text-rendering="geometricPrecision">
            <g transform="matrix(1.719326 0 0 1.71933-11.509216-11.50769)">
                <path
                    d="M20,25c-.265803.001537-.521281-.102813-.71-.29l-8-8c-.189313-.187767-.295798-.443362-.295798-.71s.106485-.522233.295798-.71l8-8c.392122-.392122,1.027878-.392122,1.42,0s.392122,1.027878,0,1.42L13.41,16l7.3,7.29c.189313.187767.295798.443362.295798.71s-.106485.522233-.295798.71c-.188719.187187-.444197.291537-.71.29Z"
                    transform="translate(0 0.001114)"/>
            </g>
        </svg>
    </div>
</template>

<script>
export default {
    name: 'chevronIco',
    props: {
        rotationDegree: {
            type: Number,
            default: 0,
        },
        size: {
            type: Number,
            default: 26,
        }
    }
}
</script>

<style scoped>
.chevron-wrap {
    aspect-ratio: 1;
}

.chevron {
    width: 100%;
    height: 100%;
    fill: #555;
}

</style>