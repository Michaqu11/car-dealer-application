import { defineStore } from 'pinia';
import axios from 'axios';
import { getBackendUrl } from '../configuration/conf.js'


const salonUrl = getBackendUrl + '/salon';
const carUrl = getBackendUrl + '/car';

export const useStore = defineStore('store', {
  state: () => ({
    salons: [],
    carsInSalon: [],
    cars: []
  }),
  getters: {
    getSalons: (state) => state.salons,
    getCarsInSalon: (state) => state.carsInSalon,
    getCars: (state) => state.cars
  },
  actions: {
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
        console.log(res.data.cars)
        this.carsInSalon = res.data.cars
      })
      .catch(err =>{
         console.log(err)
      })
    }
  },
  async setCars() {
    axios.get(carUrl, { headers: {
      'Content-Type': 'application/json; charset=utf-8',
      },
    }).then(res => {
      console.log('test')
      this.cars = res.data.cars
    })
    .catch(err =>{
       console.log(err)
    })
  },
});
