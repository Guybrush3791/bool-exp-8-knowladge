<template>
    <form @submit.prevent="submit">
        <label for="name">Name</label>
        <input type="text" name="name" id="name" v-model="newPizza.name">
        <br>
        <label for="price">Price</label>
        <input type="number" name="price" id="price" v-model="newPizza.price">
        <br>
        <label for="description">Description</label>
        <input type="text" name="description" id="description" v-model="newPizza.description">
        <br>
        <label for="photo">Photo</label>
        <input type="text" name="photo" id="photo" v-model="newPizza.photo">
        <br>
        <button type="submit">
            {{ props.oldPizza == null ? "Create" : "Update" }}
        </button>
        <button 
            type="button" 
            @click="$emit('back')">
            Back
        </button>
    </form>
</template>

<script setup>
// IMPORT LIBS
import { defineEmits, ref } from 'vue';
import axios from 'axios';

// PROPS
const props = defineProps({
    oldPizza: {
        type: Object,
        required: false,
        default: null
    }
});

// DATA
const newPizza = ref({
    name: "new pizza",
    price: 7,
    description: "my new pizza desc",
    photo: "https://picsum.photos/300?random=10"
});
if (props.oldPizza != null) {

    newPizza.value = {
        name: props.oldPizza.name,
        price: props.oldPizza.price,
        description: props.oldPizza.description,
        photo: props.oldPizza.photo
    };
}

// EMITS
const emits = defineEmits(["back", "created"]);

// FUNCTIONS
const submit = async () => {
    if (props.oldPizza == null) {
     
        const data = await axios.post(
            "http://localhost:8080/api/v1.0/pizzas", 
            newPizza.value
        );

        console.log("data", data);

        emits("created");

        return;
    } 

    const data = await axios.put(
        `http://localhost:8080/api/v1.0/pizzas/${props.oldPizza.id}`, 
        newPizza.value
    );

    console.log("data", data);

    emits("created", newPizza.value);
}


</script>