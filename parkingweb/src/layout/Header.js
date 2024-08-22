import { useContext, useEffect, useState } from 'react';
import { Badge, Button, Col, Container, Form, Image, Nav, Navbar, NavDropdown, Row } from 'react-bootstrap';
import { Link, useNavigate } from 'react-router-dom';
import { MyCartContext, MyDispatchContext, MyUserContext } from '../App';
import APIs, { endpoints } from '../configs/APIs';
import cookie from "react-cookies";

const Header = () => {
    const user = useContext(MyUserContext)
    // const user = cookie.load("user")
    const dispatch = useContext(MyDispatchContext);
    const nav = useNavigate();
    useEffect(()=>{
        console.info(user)
    })

    return (
        <>
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">E-commerce Website</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="me-auto">
                    <Link className='nav-link' to="/">Trang chủ</Link>

                    {user===null?<>
                        <Link className='nav-link text-success' to="/login">&#129489; Đăng nhập</Link>
                        <Link className='nav-link text-success' to="/register">&#129489; Đăng ký</Link>
                        
                        
                    </>:<>
                         <Link className='nav-link text-success' to="/login">
                         <Image src={user.avatar} width="25" roundedCircle />
                              Chào {user.username}!</Link>
                    <Button variant='danger' onClick={() => dispatch({"type": "logout"})}>Đăng xuất</Button>
                    </>}
                </Nav>
                </Navbar.Collapse>
            </Container>
            </Navbar>
        </>
    );
}

export default Header;