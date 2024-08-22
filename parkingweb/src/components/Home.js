import 'bootstrap/dist/css/bootstrap.min.css';
import APIs, {endpoints} from '../configs/APIs';
import { useState } from 'react';
import { useEffect } from 'react';

const Home = () => {
    const [parkings, setParkings] = useState([]);
    const loadParks = async () => {
        try {
            let res = await APIs.get(endpoints['parkings']);
            setParkings(res.data);
        } catch(ex) {
            console.error(ex);
        }
    }

    useEffect(() => {
        loadParks();
    }, [])
    return (
        <>
        <table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Địa chỉ</th>
      <th scope="col">Số lượng</th>
      <th scope="col">Giá ngày</th>
      <th scope="col">Giá đêm</th>
      <th scope="col">Ghi chú</th>
      <th scope="col">Trạng thái</th>
    </tr>
  </thead>
  <tbody>
  {parkings.map(p => (
  <tr key={p.id}>
    <th scope="row">{p.id}</th>
    <td>{p.address}</td>
    <td>{p.quantity}</td>
    <td>{p.dailyPrice}</td>
    <td>{p.nightPrice}</td>
    <td>{p.note}</td>
    {/* loi dong nay */}
    <td>{p.statusId == 2 ? 'full' : 'empty'}</td>
  </tr>
))}
    
    
  </tbody>
</table>
        </>
    );
}

export default Home;