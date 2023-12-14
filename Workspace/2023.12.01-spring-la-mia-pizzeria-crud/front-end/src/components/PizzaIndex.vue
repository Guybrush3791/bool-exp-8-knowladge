<template>
    <ul>
        <li 
            class="list-elem"
            v-for="pizza in pizzas" 
            :key="pizza.id"
            @click="$emit('openPizza', pizza.id)"
        >
            {{ pizza.name }}
        </li>
    </ul>
</template>

<script setup>
// IMPORT LIBS
import { defineProps } from 'vue';  

// EMITS
const emits = defineEmits(["openPizza"]);

// PROPS
const props = defineProps({
    pizzas: {
        type: Array,
        required: true
    }
});
</script>

<style scoped>

.list-elem {
    cursor: pointer;
    list-style-type: none;
    text-decoration: underline;
}
</style>