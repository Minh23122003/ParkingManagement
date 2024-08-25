import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import APIs, { endpoints } from "../configs/APIs";
import { Navigate, useNavigate } from "react-router";
import cookie, { load } from "react-cookies";

const OrderCancel = () => {
    const [reason, setReason] = useState("");
    const [bankName, setBankName] = useState("");
    const [accountNumber, setAccountNumber] = useState("")
    const order = cookie.load('order')
    const nav = useNavigate()

    const addOrderCancel = async () => {
        try {
            let res = await APIs.post(endpoints['addOrderCancel'], {
                'reason': reason,
                'bankName': bankName,
                'accountNumber': accountNumber,
                'orderId': order.id,
                'date': new Date().toLocaleDateString(),
                'status': 'Đang chờ xử lý'
            })

            if (res.status === 201) {
                alert("Gửi yêu cầu thành công. Vui lòng chờ mail phản hồi")
                nav('/cart')
            }
            
        }catch (ex) {
            console.error(ex)
        }
    }

    return (
        <>
        <Form>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Lý do hủy</Form.Label>
                <Form.Control type="text" placeholder="" value={reason} onChange={e => setReason(e.target.value)} />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Tên ngân hàng nhận tiền</Form.Label>
                <Form.Control type="text" placeholder="" value={bankName} onChange={e => setBankName(e.target.value)} />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Số tài khoản nhận tiền</Form.Label>
                <Form.Control type="number" placeholder="" value={accountNumber} onChange={e => setAccountNumber(e.target.value)} />
            </Form.Group>
        </Form>
        <Button className="mb-3" variant="primary" onClick={addOrderCancel}>Gửi</Button>
        </>
    )
}

export default OrderCancel;