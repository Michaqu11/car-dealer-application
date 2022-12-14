<template>
  <q-page class=" flex-center q-mx-xl">
    <q-card class="q-ma-md text-center q-pa-lg">
      <div class="text-h4 q-mb-sm">Salons</div>
      <div class="absolute-top-right">
        <AddSalon/>
      </div>
      <ListOfSalons />

    </q-card>
  </q-page>
</template>

<script>
import { defineComponent } from 'vue'
import ListOfSalons from 'components/ListOfSalons.vue'
import AddSalon from 'components/AddSalon.vue'
export default defineComponent({
  name: 'SalonList',
   components: {
    ListOfSalons,
    AddSalon
  },
})
</script>
