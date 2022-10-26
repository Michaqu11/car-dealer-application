<template>
  <q-page class="background">
    <div class="q-mt-xl q-pa-md row items-start fixed fixed-center  container q-gutter-xl">
      <q-card @click="$router.push('/salons')" class="col my-card cursor-pointer q-mx-md">
        <div class="text-h1 text-center text-size q-pa-xl">Salons</div>
      </q-card>
      <q-card @click="$router.push('/cars')" class="col my-card cursor-pointer q-mx-md">
        <div class="text-h1 text-center q-pa-xl">Cars</div>
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

.container{
  width: 80%;
  height: 40%;
}

.my-card {
  widows: 80%;
  height: 100%;
  background: radial-gradient(circle, #35a2ff 0%, #01498810 100%);
 } 

 .my-card:hover{
  transition: ease-in-out 0.4s;
  transform: scale(1.05);
 }
    
 .my-card .text-h1{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
 }


</style>
