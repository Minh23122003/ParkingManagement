import 'bootstrap/dist/css/bootstrap.min.css';
import { createContext, useReducer } from 'react';

import { Container } from 'react-bootstrap';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import Home from './components/Home';
import Register from './components/Register';
import Order from './components/Order';

import Footer from './layout/Footer';
import Header from './layout/Header';
import MyCartReducer from './reducers/MyCartReducer';
import MyUserReducer from './reducers/MyUserReducer';
import Cart from './components/Cart';
import Profile from './components/Profile';
import Rating from './components/Rating';
import Comment from './components/Comment';
import OrderCancel from './components/orderCancel';
import ChangeProfile from './components/changeProfile';

export const MyUserContext = createContext();
export const MyDispatchContext = createContext();
export const MyCartContext = createContext();

const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, null);
  const [cartCounter, cartDispatch] = useReducer(MyCartReducer, 0);

  return (
    <MyUserContext.Provider value={user}>
      <MyDispatchContext.Provider value={dispatch}>
        <MyCartContext.Provider value={[cartCounter, cartDispatch]}>
          <BrowserRouter>
            <Header />
            <Container>
              <Routes>
                <Route path='/' element={<Home />} />
                <Route path='/login' element={<Login />} />
                <Route path='/register' element={<Register />} />
                <Route path='/order'  element={<Order />} />
                <Route path='/cart' element={<Cart />} />
                <Route path='/profile' element={<Profile />} />
                <Route path='/rating' element={<Rating />} />
                <Route path='/comment' element={<Comment />} />
                <Route path='/orderCancel' element={<OrderCancel />} />
                <Route path='/changeProfile' element={<ChangeProfile />} />
              </Routes>
            </Container>
            <Footer />
          </BrowserRouter>
        </MyCartContext.Provider>
      </MyDispatchContext.Provider>
    </MyUserContext.Provider>
    
  );
}

export default App