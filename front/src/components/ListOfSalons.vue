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
          </td>
        </tr>
      </tbody>
    </q-markup-table>
</template>

<script>
import { defineComponent, computed, onMounted  } from 'vue'
import UpdateSalon from 'components/UpdateSalon.vue'
import DeleteSalon from 'components/DeleteSalon.vue'
import axios from 'axios'
import { useStore } from 'src/stores/store.js';

import { getBackendUrl } from '../configuration/conf.js'

import { useRouter } from 'vue-router';

export default defineComponent({
  name: 'ListOfSalons',
  components: {
    UpdateSalon,
    DeleteSalon
  },
  setup(){

    const store = useStore();
    const router = useRouter();
    const url = getBackendUrl + '/salon';

    const salons = computed(() => store.getSalons)

    onMounted(() => {
      store.setSalons();
    })

    async function deleteSalon(id){
      console.log(url+`/${id}`)
      await axios.delete(url+`/${id}`).then(()=>{
        alert('Delete successful')
        router.go()
      })
        .catch(err=>console.log(err))
    } 

    return {
      salons,
      deleteSalon
    }
  }

})
</script>
