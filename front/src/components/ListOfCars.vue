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
          <td class="text-center">{{car.salon}}</td>
          <td class="text-center">
            <UpdateCarVue :carProps="car" />
            <DeleteCarVue :CarIdProps="car.id" />
          </td>
        </tr>
      </tbody>
    </q-markup-table>
</template>

<script>
import { defineComponent, computed, onMounted  } from 'vue'
import { useStore } from 'src/stores/store.js';
import UpdateCarVue from './UpdateCar.vue';
import DeleteCarVue from './DeleteCar.vue';


export default defineComponent({
  name: 'ListOfCars',
  components:{
    UpdateCarVue,
    DeleteCarVue
  },
  setup(){

    const store = useStore();

    const cars = computed(() => store.getCarsData)

    onMounted(async () => 
      await store.setCarsData()
    )

    return {
      cars
    }
  }

})
</script>
