<template>
 <q-dialog v-model="dialog">
    <q-card  style="width: 700px; max-width: 80vw;">
      <q-card-section class="row items-center q-pb-none">
        <div class="text-h6">Cars belonging to {{salonName}} salon</div>
        <q-space />
        <q-btn icon="close" flat round dense v-close-popup @click="$emit('close', true)"/>
      </q-card-section>

      <q-card-section>
        <q-list v-if="cars.length" dense bordered padding class="rounded-borders" separator>
          <q-item  v-for="car of cars" v-bind:key="car">
            <q-item-section>{{car}}</q-item-section>
          </q-item>
        </q-list>
        <div v-else>
          <span class="text-h7 ">Salon doesn't have any cars</span>
        </div>
      </q-card-section>
    </q-card>
  </q-dialog>


</template>

<script>
import { defineComponent, onMounted, computed,ref } from 'vue'
import { useStore } from 'src/stores/store.js';
import { getBackendUrl } from '../configuration/conf.js'
import { useQuasar } from 'quasar'
import { useRouter } from 'vue-router';

export default defineComponent({
  name: 'SalonDetails',
  props: {
    SalonNameProps: String,
    SalonSaveNameProps: String,
  },
  emits: ['close'],
  setup(props){

    const router = useRouter();
    const store = useStore();
    const url = getBackendUrl + '/salon';
    const salonName = ref(props.SalonNameProps)
    const saveName =  ref(props.SalonSaveNameProps)
    const $q = useQuasar()

    const dialog = ref(true);
    
    const cars = computed(() => store.getCarsInSalon)

    onMounted(async () => {
      await store.setCarsInSalon(saveName.value);
    })
   

    return {
      salonName,
      saveName,
      cars,
      dialog
    }
  }

})
</script>
