import { useEffect, useState } from "react";
import { Button, Form } from "react-bootstrap";
import cookie, { load } from "react-cookies";
import APIs, { endpoints } from "../configs/APIs";

const Order = () => {
    const [parking, setParking] = useState(cookie.load("parking"))
    const [vehicleName, setVehicleName] = useState("")
    const [licensePlates, setLicensePlates] = useState("")
    const [startTime, setStartTime] = useState("")
    const [endTime, setEndTime] = useState("")
    
    useEffect(() => {
        console.info(parking)
    }, [parking])

    const Order = (e) => {
        e.preventDefault();

        console.info(`${new Date().getFullYear()}-${new Date().getMonth}-${new Date().getDate()}`)
        try{
            let res = APIs.post(endpoints['orderParking'],{
                "vehicleName": vehicleName,
                "licensePlates": licensePlates,
                "parkingId": parking.id,
                "username": "admin",
                "status": "Chưa thanh toán",
                "createdDate": `2024-08-22`,
                "startTime": startTime,
                "endTime": endTime
            })
        }catch(ex) {
            console.error(ex)
        }
    }

    return (
        <>
        <h3>Địa chỉ: {parking.address}</h3>
        <h3>Giá ban ngày: {parking.dailyPrice}</h3>
        <h3>Giá ban đêm: {parking.nightPrice}</h3>
        <Form>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Tên phương tiện</Form.Label>
                <Form.Control type="text" placeholder="..." value={vehicleName} onChange={e => setVehicleName(e.target.value)} />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>Biển số xe</Form.Label>
                <Form.Control type="text" placeholder="..." value={licensePlates} onChange={e => setLicensePlates(e.target.value)}  />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>Ngày gửi xe: </Form.Label>
                <Form.Control type="date" placeholder="..." value={startTime} onChange={e => setStartTime(e.target.value)}  />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>Ngày trả xe: </Form.Label>
                <Form.Control type="date" placeholder="..." value={endTime} onChange={e => setEndTime(e.target.value)}  />
            </Form.Group>
        </Form>
        <Button className="mb-3" variant="primary" onClick={Order}>Đặt</Button>
        </>
    )
}

export default Order