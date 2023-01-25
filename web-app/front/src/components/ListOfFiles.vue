<template>
  <q-card v-for="file of fileList" v-bind:key="file.id" @click="route(file.id)">
    <q-card-section>
      <div class="text-h6">{{ file.id }}</div>
    </q-card-section>
  </q-card>
</template>

<script>
import { defineComponent, onMounted, ref  } from 'vue'

import { getFile } from 'src/api/getFile';
import { useStore } from 'src/stores/store.js';
import { getBackendUrl } from '../configuration/conf.js'
export default defineComponent({
  name: 'ListOfFiles',
  setup(){
    const fileList = ref([])
    const store = useStore();

    function  route(id){
      window.open(getBackendUrl +'/file/' + id)
    }


  onMounted(async () => {

      for(let i = 0 ; i < store.getId; i++){
        const result = await getFile(i+1)
        if(result){

          fileList.value.push({
            'id': i+1,
            'data':result})
        }
      }
    })



  return{
    fileList,
    route
  }

  }

})
</script>
