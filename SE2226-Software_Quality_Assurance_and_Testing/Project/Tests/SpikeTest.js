import http from 'k6/http';
import { sleep } from 'k6';

export let options = {
    insecureSkipTLSVerify: true,
    noConnectionReuse: false,
    stages: [
        { duration: '10s', target: 100},
        { duration: '1m', target: 100},
        { duration: '10s', target: 1400},
        { duration: '3m', target: 1400},
        { duration: '10s', target: 100},
        { duration: '3m', target: 100},
        { duration: '10s', target: 0},
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