import { useEffect, useState } from "react"
import APIs, { endpoints } from "../configs/APIs"
import cookie from "react-cookies";
import { Button, Table } from "react-bootstrap";
import { Link } from "react-router-dom";

const Cart = () => {
    const [order, setOrder] = useState([])
    const user = cookie.load("user")
    const [quantity, setQuantity] = useState(0)
    const [orderId, setOrderId] = useState(null)

    const loadOrder = async () => {
        console.info(user.id)
        try {
            let res = await APIs.post(endpoints['getOrderParking'], {
                "userId": user.id
            })
            console.info(res.data)
            setOrder(res.data)
            cookie.save("order", res.data)
            setQuantity(order.length)
        }catch (ex) {
            console.error(ex)
        }
    }

    useEffect(() => {
        loadOrder()
    }, [quantity])

    const confirm = async (id) => {
        if(window.confirm("Bạn chắc chắn muốn xóa?") === true){
            try {
                let res = await APIs.delete(endpoints['deleteOrderParking'](id))
                if (res.status === 204)
                    setQuantity(quantity - 1)
            }catch (ex){
                console.error(ex)
            }
        }
    }

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
                <th>Tổng cộng</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            {order.map(o => <tr key={o.id}>
                <th>{o.vehicleName}</th>
                <th>{o.licensePlates}</th>
                <th>{new Date(o.createdDate).toLocaleDateString()}</th>
                {o.status === "Chưa thanh toán"?<th className="bg-danger">{o.status}</th>:<th className="bg-info">{o.status}</th>}              
                <th>{new Date(o.startTime).toLocaleDateString()}</th>
                <th>{new Date(o.endTime).toLocaleDateString()}</th>
                <th>{o.parkingId.address}</th>
                <th>{o.total}</th>
                <th>{o.status === "Chưa thanh toán"?<><Button onClick={() => confirm(o.id)} variant="danger">&times;</Button></>:<></>}</th>
                <th></th>
                {o.status === "Đã thanh toán" && new Date() > new Date(o.endTime)?<th><Button><Link onClick={()=> cookie.save("order", o)} className="nav-link" to="/rating">Đánh giá</Link></Button></th>:<th></th>}
                {o.status === "Đã thanh toán" && new Date() > new Date(o.endTime)?<th><Button><Link onClick={()=> cookie.save("order", o)} className="nav-link" to="/comment">Nhận xét</Link></Button></th>:<th></th>}
            </tr>)}                  
        </tbody>
        </Table>
    </>)
}

export default Cart