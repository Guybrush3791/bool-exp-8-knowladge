<template>
    <div v-if="!pizzaUpdate">
        <h1>
            Pizza: {{ myPizza.name }}
            <span 
                class="link"
                @click="$emit('closePizza', myPizza != pizza)">
                X
            </span>
        </h1>
        <p>Price: {{ myPizza.price }}</p>
        <span>{{ myPizza.description }}</span>
        <br>
        {{ myPizza.image }}
        <img :src="myPizza.photo" alt="pizza image" >
        <br>
        <button 
            @click="pizzaUpdate = true"
        >UPDATE</button>
        <br><br>
        <button 
            @click="deletePizza(myPizza.id)"
        >DELETE</button>
    </div>
    <pizza-form 
        v-else
        :oldPizza="pizza"
        @back="pizzaUpdate = false"
        @created="updatedPizza"
    />
</template>

<script setup>
// IMPORT LIBS
import { ref } from 'vue';
import axios from 'axios';

// IMPORT COMPONENTS
import PizzaForm from './PizzaForm.vue';

// PROPS
const props = defineProps({
    pizza: {
        type: Object,
        required: true
    }
});

// DATA
const pizzaUpdate = ref(false);
const myPizza = ref(props.pizza);

// EMITS
const emits = defineEmits(["closePizza", "deletePizza"]);

// FUNCTIONS
const deletePizza = async (id) => {
    const data = await axios.delete(
        `http://localhost:8080/api/v1.0/pizzas/${id}`
    );
    console.log("data", data);

    emits("deletePizza");
}
const updatedPizza = (newPizza) => {
    pizzaUpdate.value = false;
    myPizza.value = newPizza;
}
</script>

<style scoped>

.link {
    cursor: pointer;
    text-decoration: underline;
}
</style>