<template>
 <q-btn @click="deleteSalon()" flat round icon="delete"/>
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
    SalonIdProps: Number,
  },
  setup(props){

    const router = useRouter();
    const url = getBackendUrl + '/salon';
    const salonId = ref(props.SalonIdProps)
    const $q = useQuasar()



    async function deleteSalon(){
      await axios.delete(url+`/${salonId.value}`, { headers: {
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
      deleteSalon,
    }
  }

})
</script>
