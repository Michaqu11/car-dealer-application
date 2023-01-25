import axios from 'axios';
import { getBackendUrl } from '../configuration/conf.js'


const getFile = async (id) => {
  return await axios.get(getBackendUrl+'/file/' + id, { headers: {
      'Content-Type': `multipart/form-data`
  } }).then(res => {
    return res.data
  }).catch(err => {
    console.log(err);
    return ''
  })



}

export { getFile };
