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
            <SalonDetails :SalonNameProps="salon.name" />
          </td>
        </tr>
      </tbody>
    </q-markup-table>
</template>

<script>
import { defineComponent, computed, onMounted  } from 'vue'
import SalonDetails from 'components/SalonDetails.vue'
import UpdateSalon from 'components/UpdateSalon.vue'
import DeleteSalon from 'components/DeleteSalon.vue'
import { useStore } from 'src/stores/store.js';

import { useRouter } from 'vue-router';

export default defineComponent({
  name: 'ListOfSalons',
  components: {
    UpdateSalon,
    DeleteSalon,
    SalonDetails
  },
  setup(){

    const store = useStore();
    const router = useRouter();

    const salons = computed(() => store.getSalons)

    onMounted(() => {
      store.setSalons();
    })

    return {
      salons
    }
  }

})
</script>
