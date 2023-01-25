<template>
 <q-card class="q-pa-md q-px-xl q-pb-xl">
  <div class="q-my-md row items-start justify-center text-h3">
    Add File
  </div>
  <q-separator/>
 <div class="items-start justify-start">
    <q-form @submit.prevent.stop="onSubmit" class="q-gutter-md q-mt-md">

      <q-file
        v-model="file"
        label="Upload File"
        filled
      >
        <template v-slot:prepend>
          <q-icon name="attach_file" />
        </template>
        </q-file>

      <div>
        <q-btn label="Submit" type="submit" color="primary" class="full-width" size="lg" />
      </div>
    </q-form>
  </div>
  </q-card>


</template>

<script>
import { defineComponent, ref, onMounted } from 'vue'

import { useQuasar } from 'quasar'
import { useRouter } from 'vue-router';
import { sendFile } from 'src/api/postFile';
export default defineComponent({
  name: 'AddFile',
  setup(){

    const router = useRouter();
    const file = ref(null)
    const $q = useQuasar()

    const setResult = (result) => {
      if(result){
          $q.notify({
            color: 'primary',
            message: 'Success',
            timeout: 1000
          })
          router.push({ path: '/' });
        }
        else{
          $q.notify({
            type: 'negative',
            message: 'Error'
          })
        }
    }


const onSubmit = async () => {
  if(file.value){
    const result = await sendFile(file.value)
    setResult(result)
  }
  else{
    $q.notify({
      type: 'negative',
      message: 'emptyData'
    })
  }
}

    return {
      onSubmit,
     file
    }
  }

})
</script>
