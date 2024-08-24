import { useContext, useEffect, useState } from "react";
import { Button, Form } from "react-bootstrap";
import cookie, { load } from "react-cookies";
import APIs, { endpoints } from "../configs/APIs";
import { MyUserContext } from "../App";
import { Navigate } from "react-router";

const Order = () => {
    const [parking, setParking] = useState(cookie.load("parking"))
    const [vehicleName, setVehicleName] = useState("")
    const [licensePlates, setLicensePlates] = useState("")
    const [startTime, setStartTime] = useState("")
    const [endTime, setEndTime] = useState("")
    const user = useContext(MyUserContext)
    
    useEffect(() => {
    }, [parking])

    const Order = async (e) => {
        e.preventDefault();

        var d = new Date().getDate()
        var m = new Date().getMonth()
        var y = new Date().getFullYear()

        var s = new Date(startTime)
        var e = new Date(endTime)

        if (user === null)
            alert("Bạn chưa đăng nhập. Vui lòng đăng nhập")
        else if (vehicleName === "" || licensePlates === "" || startTime === "" || endTime === "")
            alert("Thông tin chưa đầy đủ. Vui lòng kiểm tra lại")
        else if (licensePlates.length < 4 || licensePlates.length > 5)
            alert("Sai biển số xe. Vui lòng nhập lại")
        else if (s < new Date())
            alert("Ngày gửi phải sau ngày đặt")
        else if (s > e)
            alert("Ngày trả phải sau ngày gửi")
        else {
            try{
                var day = (e - s) / 86400000
                var total = day * parking.nightPrice + (day + 1) * parking.dailyPrice

                let res = await APIs.post(endpoints['addOrderParking'],{
                    "vehicleName": vehicleName,
                    "licensePlates": licensePlates,
                    "parkingId": parking.id,
                    "username": user.username,
                    "status": "Chưa thanh toán",
                    "createdDate": `${y}-${parseInt(m) + 1}-${d}`,
                    "startTime": startTime,
                    "endTime": endTime,
                    "total": total
                })
                if (res.status===201)
                    alert("Đặt chỗ thành công")
            }catch(ex) {
                console.error(ex)
            }
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
                <Form.Control type="text" placeholder="" value={vehicleName} onChange={e => setVehicleName(e.target.value)} />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>Biển số xe</Form.Label>
                <Form.Control type="number" placeholder="Biển số xe gồm 4-5 số" value={licensePlates} onChange={e => setLicensePlates(e.target.value)}  />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>Ngày gửi xe: </Form.Label>
                <Form.Control type="date" placeholder="Ngày gửi phải sau ngày đặt" value={startTime} onChange={e => setStartTime(e.target.value)}  />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>Ngày trả xe: </Form.Label>
                <Form.Control type="date" placeholder="Ngày trả phải sau ngày gửi" value={endTime} onChange={e => setEndTime(e.target.value)}  />
            </Form.Group>
        </Form>
        <Button className="mb-3" variant="primary" onClick={Order}>Đặt</Button>
        </>
    )
}

export default Order