<template>
    <q-markup-table>
      <thead>
        <tr>
          <th class="text-left">Id</th>
          <th class="text-center">Name</th>
          <th class="text-center">Address</th>
          <th class="text-center">Options</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="salon of salons" :key="salon.id">
          <td class="text-left">{{salon.id}}</td>
          <td class="text-center">{{salon.name}}</td>
          <td class="text-center">{{salon.address}}</td>
          <td class="text-center">
            <UpdateSalon :salonProps="salon" />
            <DeleteSalon :SalonIdProps="salon.id" />
            <AddCar :salonNameProps="salon.saveName"/>
            <q-btn @click="showDetails(salon.id)" flat round icon="more_vert"/>
            <SalonDetails v-if="details==salon.id" :SalonNameProps="salon.name" :SalonSaveNameProps="salon.saveName"  @close="clearDetails"/>
          </td>
        </tr>
      </tbody>
    </q-markup-table>
</template>

<script>
import { defineComponent, computed, onMounted,ref  } from 'vue'
import SalonDetails from 'components/SalonDetails.vue'
import UpdateSalon from 'components/UpdateSalon.vue'
import DeleteSalon from 'components/DeleteSalon.vue'
import { useStore } from 'src/stores/store.js';

import { useRouter } from 'vue-router';
import AddCar from './AddCar.vue';

export default defineComponent({
  name: 'ListOfSalons',
  components: {
    UpdateSalon,
    DeleteSalon,
    SalonDetails,
    AddCar,
},
  setup(){

    const store = useStore();
    const router = useRouter();
    const details = ref(0);

    const salons = computed(() => store.getSalons)

    onMounted(() => {
      store.setSalons();
    })

    function showDetails(id){
      details.value = id;
    }

    function clearDetails(){
      details.value = 0;
    }

    return {
      salons,
      details,
      showDetails,
      clearDetails
    }
  }

})
</script>
