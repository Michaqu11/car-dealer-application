<template>
  <q-page class=" flex-center q-mx-xl">
    <q-card class="q-ma-md text-center q-pa-lg">
      <div class="text-h4 q-mb-sm">Cars</div>
      <div class="absolute-top-right">
        <AddCar />
      </div>
      <ListOfCars />

    </q-card>
  </q-page>
</template>

<script>
import { defineComponent } from 'vue'
import AddCar from 'components/AddCar.vue'
import ListOfCars from 'components/ListOfCars.vue'
export default defineComponent({
  name: 'CarsList',
   components: {
    AddCar,
    ListOfCars
  },
})
</script>
