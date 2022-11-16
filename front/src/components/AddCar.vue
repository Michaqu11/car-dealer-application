<template>
 <q-btn class="q-ma-sm" @click="showDialog()" flat round :icon="addToSalon ? 'add' : 'toys'"/>

 <q-dialog v-model="dialog">
    <q-card  style="width: 700px; max-width: 80vw;">
      <q-card-section class="row items-center q-pb-none">
        <div class="text-h6">Add Car</div>
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
            :rules="[ val => val && val.length > 0 || 'Please type something']"
          />

          <q-input
            v-show="addToSalon"
            filled
            v-model="salonName"
            label="Salon name"
            lazy-rules
            :rules="[ val => val && val.length > 0 || 'Please type something']"
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

import { getBackendUrl } from '../configuration/conf.js'
import { useQuasar } from 'quasar'
import { useRouter } from 'vue-router';

export default defineComponent({
  name: 'AddCar',
  props:{
    salonNameProps: {
      type: String,
      default: '',
    }
  },
  setup(props){

    const router = useRouter();
    const url = getBackendUrl + '/car';
    const dialog = ref(false)
    const brand = ref('')
    const model = ref('')
    const maxSpeed = ref(null)
    const salonName = ref(props.salonNameProps)
    const addToSalon = ref(props.salonNameProps ? false : true)
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
      await axios.post(url, data, { headers: {
        'Content-Type': 'application/json; charset=utf-8',
        'Access-Control-Allow-Origin': '*'
        }}).then(()=> {
          $q.notify({
          message: 'Add successful',
          color: 'primary'
          })
          router.go()
        })
        .catch(err=> {
          console.log(err)
          $q.notify({
          message: 'There was a problem! Please correct the details and try again.',
          color: 'red'
          })
        })
    }

    return {
      showDialog,
      onSubmit,
      dialog,
      brand,
      model,
      maxSpeed,
      salonName,
      addToSalon
    }
  }

})
</script>
