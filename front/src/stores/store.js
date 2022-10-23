import { defineStore } from 'pinia';
import axios from 'axios';
import { getBackendUrl } from '../configuration/conf.js'


const url = getBackendUrl + '/salon';

export const useStore = defineStore('store', {
  state: () => ({
    salons: [],
    carsInSalon: [],
  }),
  getters: {
    getSalons: (state) => state.salons,
    getCarsInSalon: (state) => state.carsInSalon,
  },
  actions: {
    async setSalons() {
      axios.get(url, { headers: {
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
      console.log(name)
      axios.get(url + `/cars/${name}`, { headers: {
        'Content-Type': 'application/json; charset=utf-8',
        },
      }).then(res => {
        console.log(res.data.cars)
        this.carsInSalon = res.data.cars
      })
      .catch(err =>{
         console.log(err)
      })
    }
  },
});
