import http from 'k6/http';
import { sleep } from 'k6';

export let options = {
    insecureSkipTLSVerify: true,
    noConnectionReuse: false,
    stages: [
        { duration: '2m', target: 400},
        { duration: '3h56m', target: 400},
        { duration: '2m', target: 0},
    ],
};


const API_BASE_URL = 'https://www.deezer.com/en/'

export default () => {

    http.batch([
        ['GET',`${API_BASE_URL}/login`],
        ['GET',`${API_BASE_URL}/register`],
    ]);
  sleep(1);
}