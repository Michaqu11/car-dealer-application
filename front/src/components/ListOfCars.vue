<template>
    <q-markup-table>
      <thead>
        <tr>
          <th class="text-left">Id</th>
          <th class="text-center">Brand</th>
          <th class="text-center">Model</th>
          <th class="text-center">MaxSpeed</th>
          <th class="text-center">Salon</th>
          <th class="text-center">Options</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="car of cars" :key="car.id">
          <td class="text-left">{{car.id}}</td>
          <td class="text-center">{{car.brand}}</td>
          <td class="text-center">{{car.model}}</td>
          <td class="text-center">{{car.maxSpeed}}</td>
          <td class="text-center">{{car.salonName}}</td>
          <td class="text-center"></td>
        </tr>
      </tbody>
    </q-markup-table>
</template>

<script>
import { defineComponent, computed, onMounted  } from 'vue'
import { useStore } from 'src/stores/store.js';
// import { useRouter } from 'vue-router';

export default defineComponent({
  name: 'ListOfCars',
  setup(){

    const store = useStore();
    // const router = useRouter();
    

    const cars = computed(() => store.getCars)

    onMounted(async () => {
      await store.setCars;
    })

    return {
      cars
    }
  }

})
</script>
