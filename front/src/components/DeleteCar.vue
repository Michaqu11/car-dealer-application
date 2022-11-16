<template>
 <q-btn @click="deleteCarModel()" flat round icon="delete"/>
</template>

<script>
import { defineComponent, ref } from 'vue'
import axios from 'axios'

import { getBackendUrl } from '../configuration/conf.js'
import { useQuasar } from 'quasar'
import { useRouter } from 'vue-router';

export default defineComponent({
  name: 'DeleteSalon',
  props: {
    CarIdProps: Number,
  },
  setup(props){

    const router = useRouter();
    const url = getBackendUrl + '/car';
    const carId = ref(props.CarIdProps)
    const $q = useQuasar()



    async function deleteCarModel(){
      await axios.delete(url+`/${carId.value}`, { headers: {
        'Content-Type': 'application/json; charset=utf-8',
        'Access-Control-Allow-Origin': '*'
        }}).then(()=> {
          $q.notify({
          message: 'Delete successful',
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
      deleteCarModel,
    }
  }

})
</script>
