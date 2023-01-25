import axios from 'axios';
import { useStore } from 'src/stores/store.js';
import { getBackendUrl } from '../configuration/conf.js'
const changeFileToFormData = (file) => {
    const formData = new FormData();
    formData.append('file', file, file.name);
    formData.append('description','asd');
    formData.append('author', 'asd');
    return formData
}

const store = useStore();

const sendFile = async (file) => {
    const formData = changeFileToFormData(file);
    try{
        await axios.post(getBackendUrl+'/file', formData, { headers: {
            'Content-Type': `multipart/form-data`
        } }).then(res => {
          store.setId(Number(res.data.split(':')[1]))
        })
        return true;
    }
    catch(err) {
        console.log(err);
        return false;
    }
}

export { sendFile };
