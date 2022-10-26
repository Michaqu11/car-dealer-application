<template>
  <q-page class="background">
    <div class="q-mt-xl q-pa-md row items-start fixed fixed-center q-gutter-md">
      <q-card @click="$router.push('/salons')" class="my-card">
        <div class="text-h3 text-center text-size q-pa-xl">Salons</div>
      </q-card>
      <q-card @click="$router.push('/cars')" class="my-card">
        <div class="text-h3 text-center q-pa-xl">Cars</div>
      </q-card>
    </div>

  </q-page>
</template>

<script>
import { defineComponent } from 'vue'

export default defineComponent({
  name: 'IndexPage'
})
</script>
<style scoped>
.background {
  background-image: url('../assets/dealer3.jpg');
    /* Full height */
    height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

.my-card {
  width: 100%;
  /* max-width: 350px; */
}

</style>
