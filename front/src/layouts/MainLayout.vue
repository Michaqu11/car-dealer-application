<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-toolbar-title>
          Car Dealer
        </q-toolbar-title>

        <q-tabs v-model="tab">
          <q-route-tab name="home" label="Home" to="/" />
          <q-route-tab name="salons" label="Salons"  to="/salons" />
        </q-tabs>
      </q-toolbar>
    </q-header>

  

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
import { defineComponent, ref, onMounted } from 'vue'



export default defineComponent({
  name: 'MainLayout',
  setup () {
    const leftDrawerOpen = ref(false)
    const tab = ref('home')
    onMounted(() =>{
      leftDrawerOpen.value = false;
    })

    return {
      leftDrawerOpen,
      tab,
      toggleLeftDrawer () {
        leftDrawerOpen.value = !leftDrawerOpen.value
      }
    }
  }
})
</script>
