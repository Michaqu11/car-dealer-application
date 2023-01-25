<template>
  <q-page class=" flex-center q-ma-xl">
        <AddFile />
  </q-page>
</template>

<script>
import { defineComponent } from 'vue'
import AddFile from 'src/components/AddFile.vue'
export default defineComponent({
  name: 'FilePage',
   components: {
    AddFile
  },
})
</script>
