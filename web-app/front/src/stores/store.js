import { defineStore } from 'pinia';
import axios from 'axios';
import { getBackendUrl } from '../configuration/conf.js'
// import { useSessionStorage } from '@vueuse/core';

const salonUrl = getBackendUrl + '/salon';
const carUrl = getBackendUrl + '/car';

export const useStore = defineStore('store', {
  state: () => ({
    id:  0,
    salons: [],
    carsInSalon: [],
    carsData: []
  }),
  getters: {
    getSalons: (state) => state.salons,
    getCarsInSalon: (state) => state.carsInSalon,
    getCarsData: (state) => state.carsData,
    getId: (state) => state.id
  },
  actions: {
    async setCarsData() {
      axios.get(carUrl, { headers: {
        'Content-Type': 'application/json; charset=utf-8',
        },
      }).then(res => {
        this.carsData = res.data.cars
      })
      .catch(err =>{
         console.log(err)
      })
    },
    async setSalons() {
      axios.get(salonUrl, { headers: {
        'Content-Type': 'application/json; charset=utf-8',
        },
      }).then(res => {
        this.salons = res.data.salons
      })
      .catch(err =>{
         console.log(err)
      })
    },
    async setCarsInSalon(name){
      axios.get(salonUrl + `/cars/${name}`, { headers: {
        'Content-Type': 'application/json; charset=utf-8',
        },
      }).then(res => {
        this.carsInSalon = res.data.cars
        return this.carsInSalon
      })
      .catch(err =>{
         console.log(err)
         return []
      })
    },
    clearCarsInSalon(){
      this.carsInSalon = []
    },
    setId(num){
      this.id = num
    }
  },
});
