import { useEffect } from "react";
import { Image } from "react-bootstrap";
import cookie from "react-cookies";

const Profile = () => {

    const user = cookie.load("user")

    useEffect(() => {

    }, [user])

    return (
        <>
        <h1>Họ tên: {user.firstName} {user.lastName}</h1>
        <h1>Email: {user.email}</h1>
        <h1>Số điện thoại: {user.phone}</h1>
        <Image src={user.avatar} width="500" />
        </>
    )
}

export default Profile;