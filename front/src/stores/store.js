import { defineStore } from 'pinia';
import axios from 'axios';
import { getBackendUrl } from '../configuration/conf.js'


const url = getBackendUrl + '/salon';

export const useStore = defineStore('store', {
  state: () => ({
    salons: [],
  }),
  getters: {
    getSalons: (state) => state.salons,
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
    }
  },
});
