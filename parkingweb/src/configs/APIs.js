import axios from "axios"
import cookie from "react-cookies"

const BASE_URL = 'http://localhost:8080/ParkingManagement/api'

export const endpoints = {
    'parkings': '/parkings',
    'status': '/status',
    'login': '/login',
    'current-user': '/current-user',
    'register': '/users',
    'addOrderParking': '/addOrderParking',
    'getOrderParking': '/getOrderParking',
    'deleteOrderParking' : (orderId) => `/orderParking/${orderId}`,
    'addComment': '/comment',
    'addRating': '/rating',
    'addOrderCancel': '/orderCancel',
    'pay': '/pay',
    'updateUser': '/updateUser',
}

export const authAPIs = () => {
    return axios.create({
        baseURL: BASE_URL,
        headers: {
            'Authorization': cookie.load("access-token")
        }
    })
}

export default axios.create({
    baseURL: BASE_URL
});