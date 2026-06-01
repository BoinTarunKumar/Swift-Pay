import http from 'k6/http';
import { check } from 'k6';

export let options = {
    vus: 250,
    duration: '1h'
};

export default function () {

    const payload = JSON.stringify({
        transactionId: `TXN-${Date.now()}-${Math.random()}`,
        senderId: 101,
        receiverId: 102,
        amount: 100,
        currency: "INR"
    });

    const params = {
        headers: {
            'Content-Type': 'application/json'
        }
    };

    let response = http.post(
        'http://localhost:8080/v1/payments',
        payload,
        params
    );

    check(response, {
        'status is 202': (r) => r.status === 202
    });
}