<template>
 <q-btn class="q-ma-sm" @click="showDialog()" flat round icon="update"/>

 <q-dialog v-model="dialog">
    <q-card  style="width: 700px; max-width: 80vw;">
      <q-card-section class="row items-center q-pb-none">
        <div class="text-h6">Update Salon</div>
        <q-space />
        <q-btn icon="close" flat round dense v-close-popup />
      </q-card-section>

      <q-card-section>
        <q-form @submit="onSubmit">

          <q-input
            filled
            v-model="brand"
            label="Brand"
            lazy-rules
            :rules="[ val => val && val.length > 0 || 'Please type something']"
          />

          <q-input
            filled
            v-model="model"
            label="Model"
            lazy-rules
            :rules="[ val => val && val.length > 0 || 'Please type something']"
          />

          <q-input
            type="number"
            filled
            v-model="maxSpeed"
            label="Max speed"
            lazy-rules
            :rules="[ val => val && val != null || 'Please type something']"
          />

          <div class="text-center">
            <q-btn label="Submit" type="submit" color="primary"/>
          </div>
        </q-form>
      </q-card-section>
    </q-card>
  </q-dialog>


</template>

<script>
import { defineComponent, ref  } from 'vue'
import axios from 'axios'

import { useQuasar } from 'quasar'
import { getBackendUrl } from '../configuration/conf.js'
import { useRouter } from 'vue-router';

export default defineComponent({
  name: 'AddSalon',
  props: {
    carProps: Object,
  },
  setup(props){

    const router = useRouter();
    const car = ref(props.carProps);
    if(car.value == undefined){
      router.push({path:'/car'})
    }
    const url = getBackendUrl + `/car/${car.value.id}`;
    const dialog = ref(false)
    const brand = ref(car.value.brand)
    const model = ref(car.value.model)
    const maxSpeed = ref(parseInt(car.value.maxSpeed))
    const salonName = ref(car.value.salonName)
    const $q = useQuasar()


    function showDialog(){
      dialog.value = !dialog.value
    }


    async function onSubmit(){
      const data = {
        brand: brand.value,
        model: model.value,
        maxSpeed: maxSpeed.value,
        salonName: salonName.value
      }
      await axios.put(url, data, { headers: {
        'Content-Type': 'application/json; charset=utf-8',
        'Access-Control-Allow-Origin': '*'
        }}).then(()=> {
          $q.notify({
          message: 'Update successful',
          color: 'primary'
          })
         
          router.go()
        })
        .catch(err=>{
          console.log(err)
          $q.notify({
          message: 'There was a problem! Please correct the details and try again.',
          color: 'red'
          })})
    }

    return {
      showDialog,
      onSubmit,
      dialog,
      brand,
      model,
      maxSpeed,
    }
  }

})
</script>
