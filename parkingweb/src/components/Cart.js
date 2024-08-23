import { useEffect, useState } from "react"
import APIs, { endpoints } from "../configs/APIs"
import cookie from "react-cookies";
import { Table } from "react-bootstrap";

const Cart = () => {
    const [order, setOrder] = useState([])
    const user = cookie.load("user")

    const loadOrder = async () => {
        console.info(user.id)
        try {
            fetch("http://localhost:8080/ParkingManagement/api/orderParking", {
                method: "get",
                body: JSON.stringify({
                    "userId" : user.id
                }),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(function(res) {
                return res.json();
            }).then(function(data) {
                setOrder(data)
            });

            // let res = await APIs.get(endpoints['orderParking'], {
            //     "userId": user.id
            // })
            // console.info(res.data)
            // setOrder(res.data)
            // cookie.save("order", res.data)
        }catch (ex) {
            console.error(ex)
        }
    }

    useEffect(() => {
        loadOrder()
    }, [order])

    return (<>
    <h1>Danh sách các bãi giữ xe đã đặt</h1>
    <Table striped bordered hover>
        <thead>
            <tr>
                <th>Tên phương tiện</th>
                <th>Biển số xe</th>
                <th>Ngày đặt</th>
                <th>Trạng thái</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày kết thúc</th>
                <th>Địa chỉ bãi đỗ xe</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            {order.map(o => <tr key={o.id}>
                <th>{o.vehicleName}</th>
                <th>{o.licensePlates}</th>
                <th>{o.createdDate}</th>
                <th>{o.status}</th>
                <th>{o.startTime}</th>
                <th>{o.endTime}</th>
                <th>{o.parkingId.address}</th>
            </tr>)}                  
        </tbody>
        </Table>
    </>)
}

export default Cart