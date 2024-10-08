import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import APIs, { authAPIs, endpoints } from "../configs/APIs";
import cookie, { load } from "react-cookies";
import { Navigate, useNavigate } from "react-router";

const Comment = () => {
    const [content, setContent] = useState();
    const user = cookie.load('user');
    const order = cookie.load('order')
    const nav = useNavigate()

    const addComment = async () => {
        try {
            let res = await APIs.post(endpoints['addComment'], {
                'content': content,
                'username': user.username,
                'parkingId': order.parkingId.id
            })
    
            if(res.status === 201)
                alert("Nhận xét thành công")
                nav('/cart')
        }catch (ex) {
            console.error(ex)
        }
    }

    return (
        <>
        <Form>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Nhận xét</Form.Label>
                <Form.Control type="text" placeholder="" value={content} onChange={e => setContent(e.target.value)} />
            </Form.Group>
        </Form>
        <Button className="mb-3" variant="primary" onClick={addComment}>Gửi</Button>
        </>
    )
}

export default Comment;