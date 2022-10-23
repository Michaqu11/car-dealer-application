<template>
 <q-btn @click="showCars()" flat round icon="more_vert"/>

 <q-dialog v-model="dialog">
    <q-card  style="width: 700px; max-width: 80vw;">
      <q-card-section class="row items-center q-pb-none">
        <div class="text-h6">Cars belonging to {{salonName}} salon</div>
        <q-space />
        <q-btn icon="close" flat round dense v-close-popup />
      </q-card-section>

      <q-card-section>
        <q-list dense bordered padding class="rounded-borders" separator>
          <q-item  v-for="car of cars" v-bind:key="car">
            <q-item-section>{{car}}</q-item-section>
          </q-item>
        </q-list>
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
    SalonNameProps: Object,
  },
  setup(props){

    const router = useRouter();
    const store = useStore();
    const url = getBackendUrl + '/salon';
    const salonName = ref(props.SalonNameProps)
    const $q = useQuasar()

    const dialog = ref(false);
    
    const cars = computed(()=>store.getCarsInSalon)


    onMounted(async () => {
      await store.setCarsInSalon(salonName.value);
    })



    function showCars(){
      console.log('dialog')
      dialog.value = !dialog.value;

    }

   

    return {
      showCars,
      salonName,
      cars,
      dialog
    }
  }

})
</script>
