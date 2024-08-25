import { useState } from "react";
import APIs, { endpoints } from "../configs/APIs";
import cookie, { load } from "react-cookies";
import { Button, Form } from "react-bootstrap";
import { Navigate } from "react-router";

const Rating = () => {

    const [stars, setStars] = useState();
    const user = cookie.load('user');
    const order = cookie.load('order')

    const addRating = async () => {
        try {
            let res = await APIs.post(endpoints['addRating'], {
                'stars': stars,
                'userId': user.id,
                'parkingId': order.parkingId.id
            })
    
            if(res.status === 201)
                return <Navigate to="/cart" />
        }catch (ex) {
            console.error(ex)
        }
    }

    return (
        <>
        <Form>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Nhập số sao đánh giá</Form.Label>
                <Form.Control type="text" placeholder="" value={stars} onChange={e => setStars(e.target.value)} />
            </Form.Group>
        </Form>
        <Button className="mb-3" variant="primary" onClick={addRating}>Gửi</Button>
        </>
    )
}

export default Rating;