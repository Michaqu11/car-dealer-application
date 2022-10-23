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
            v-model="name"
            label="Salon Name"
            lazy-rules
            :rules="[ val => val && val.length > 0 || 'Please type something']"
          />

          <q-input
            filled
            v-model="address"
            label="Address"
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

import { useQuasar } from 'quasar'
import { getBackendUrl } from '../configuration/conf.js'
import { useRouter } from 'vue-router';

export default defineComponent({
  name: 'AddSalon',
  props: {
    salonProps: Object,
  },
  setup(props){

    const router = useRouter();
    if(props.salonProps == undefined){
      router.push({path:'/salon'})
    }
    const url = getBackendUrl + `/salon/${props.salonProps.id}`;
    const dialog = ref(false)
    const name = ref(props.salonProps.name)
    const address = ref(props.salonProps.address)
    const $q = useQuasar()


    function showDialog(){
      dialog.value = !dialog.value
    }


    async function onSubmit(){
      const data = {
        name: name.value,
        address: address.value
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
        .catch(err=>console.log(err))
    }

    return {
      showDialog,
      onSubmit,
      dialog,
      name,
      address
    }
  }

})
</script>
