<template>
  <q-page class="background">
    <div class="q-mt-xl q-pa-md row items-start fixed fixed-center  container q-gutter-xl">
      <q-card @click="$router.push('/file')" class="col my-card cursor-pointer q-mx-md">
        <div class="text-h1 text-center text-size q-pa-xl">File</div>
      </q-card>
      <q-card @click="$router.push('/filelist')" class="col my-card cursor-pointer q-mx-md">
        <div class="text-h1 text-center q-pa-xl">List</div>
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

  height: 100%;
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
  color:white;
 }


</style>
