<template>
    <vue-scrollable :isCarousel="true" :scrollStep="scrollStep" :blocksVisible="tasksVisible" :listGap="24">
        <transition-group name="slide">
            <task-card class="task" @complete="this.$emit('complete', task.id)" v-for="task in tasks" :date="task.date"
                :description="task.description" :key="task.id" :ref="`task-${task.id}`"/>
        </transition-group>
    </vue-scrollable>
</template>

<script>
export default {
    name: 'taskList',
    props: {
        tasksVisible: {
            required: true,
            default: 0,
        },
        scrollStep: {
            default: 1
        },
        tasks: {
            type: Array,
            default: () => []
        }
    }
}
</script>

<style scoped>
.slide-move {
    transition: all 0.4s ease-in-out;
}
</style>