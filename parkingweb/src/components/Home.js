import { useEffect, useState } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import APIs, { endpoints } from "../configs/APIs";
import { Button, Col, Form, Row, Table } from "react-bootstrap";

const Home = () => {

    const [parkings, setParkings] = useState([])
    const [q] = useSearchParams()
    const [page, setPage] = useState(1)
    const [address, setAddress] = useState("")
    const [minPrice, setMinPrice] = useState("")
    const [maxPrice, setMaxPrice] = useState("")
    const [statusId, setStatusId] = useState(1)
    const [status, setStatus] = useState([])
    const nav = useNavigate();

    const loadParkings = async () => {
        try {
            let url = `${endpoints["parkings"]}?page=${page}`

            let sId = q.get("statusId");
            if (sId !== null) {
                setPage(1);
                url = `${url}&statusId=${sId}`;
            }

            let a = q.get("address");
            if (a !== null) {
                setPage(1);
                url = `${url}&address=${a}`;
            }

            let min = q.get("minPrice");
            if (min !== null) {
                setPage(1);
                url = `${url}&minPrice=${min}`;
            }

            let max = q.get("maxPrice");
            if (max !== null) {
                setPage(1);
                url = `${url}&maxPrice=${max}`;
            }

            let res = await APIs.get(url)
            console.info(parkings)
            console.info(page)
            if (page === 1)
                setParkings(res.data)
            else
                setParkings(current => [...current, ...res.data])
        } catch (ex) {
            console.error(ex)
        }
    }

    const loadStatus = async () => {
        try {
            let res = await APIs.get(endpoints["status"])
            setStatus(res.data)
        }catch (ex) {
            console.error(ex)
        }
    }

    useEffect(() => {
        loadParkings();
    }, [page, q])

    useEffect(() => {
        loadStatus()
    }, [])
    
    const loadMore = () => {
        setPage(page + 1);
    }

    const submit = (e) => {
        e.preventDefault();

        nav(`/?address=${address}&minPrice=${minPrice}&maxPrice=${maxPrice}&statusId=${statusId}`);
    }

    return (
        <>
        <Form inline onSubmit={submit}>
            <Row>
                <Col xs="auto">
                    <Form.Control
                        type="text"
                        placeholder="Tìm địa chỉ bãi giữ xe..."
                        className=" mr-sm-2"
                        value={address}
                        onChange={e => setAddress(e.target.value)}
                    />
                </Col>
                <Col xs="auto" >
                    <Form.Control
                        type="text"
                        placeholder="Tìm giá thấp nhất..."
                        className=" mr-sm-2"
                        value={minPrice}
                        onChange={e => setMinPrice(e.target.value)}
                    />
                </Col>
                <Col xs="auto" >
                    <Form.Control
                        type="text"
                        placeholder="Tìm giá cao nhất..."
                        className=" mr-sm-2"
                        value={maxPrice}
                        onChange={e => setMaxPrice(e.target.value)}
                    />
                </Col>
                <Col xs="auto">
                    <Form.Select onChange={e => setStatusId(e.target.value)}>
                    <option key={0} value={""}>Tất cả</option>
                        {status.map(s => <option key={s.id} value={s.id}>{s.name}</option>)}
                    </Form.Select>
                </Col>
                <Col xs="auto">
                    <Button type="submit">Tìm</Button>
                </Col>
            </Row>
        </Form>

        <h1 className="text-center text-info mt-1">Bãi giữ xe</h1>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Địa chỉ</th>
                        <th>Số lượng chỗ đỗ</th>
                        <th>Giá ngày</th>
                        <th>Giá đêm</th>
                        <th>Trạng thái</th>
                        <th>Ghi chú</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {parkings.map(p => <tr key={p.id}>
                        <th>{p.address}</th>
                        <th>{p.quantity}</th>
                        <th>{p.dailyPrice}</th>
                        <th>{p.nightPrice}</th>
                        <th>{p.statusId.name}</th>
                        <th>{p.note}</th>
                        {p.statusId.id === 1?<>
                            <th><Button variant="primary">Đặt chỗ giữ xe</Button></th>
                        </>:<></>}
                    </tr>)}                  
                </tbody>
                </Table>

                <div className="mt-2 text-center mb-1">
                    <Button  onClick={loadMore} variant="primary">Xem thêm</Button>
                </div>
        </>
    );
}

export default Home;