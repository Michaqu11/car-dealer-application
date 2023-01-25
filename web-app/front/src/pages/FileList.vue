<template>
  <q-page class=" flex-center q-ma-xl">
    <div class="q-gutter-md" style="width:40%">
        <ListOfFiles />
      </div>

  </q-page>
</template>

<script>
import { defineComponent } from 'vue'
import ListOfFiles from 'src/components/ListOfFiles.vue'
export default defineComponent({
  name: 'FileList',
   components: {
    ListOfFiles
  },
})
</script>
