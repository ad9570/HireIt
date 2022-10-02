import React, { useState } from "react";
import "./Login.scss";
import axios from "axios";
import { NavLink, useNavigate } from "react-router-dom";
import img from "../images/hireit-logo-rect.png";

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errormsg, setErrormsg] = useState('');
    const nav=useNavigate();

    const signIn = (e) => {
        e.preventDefault();

        const url=`${process.env.REACT_APP_SPRING_URL}api/authenticate`;
        axios.post(url, {username, password})
        .then(res => {
            if (res.data===0) {
                alert("아이디 또는 비밀번호가 맞지 않습니다");
            } else {
                localStorage.setItem('login', true);
                localStorage.setItem('id', username);
                localStorage.setItem('token', res.data.token);
                nav(-1);
            }
        }).catch(error => {
            setErrormsg('아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.');
        })
    }

    return(
        <div className="container loginMain">
            <div className="loginLogo">
                <img alt="" src={img} style={{cursor:"pointer"}} onClick={() => {nav("/")}}/>
            </div>

            <ul className="links">
                <li className="signin1">
                    <NavLink to="/login" id="signin1">SIGN IN</NavLink>
                </li>
                <li className="signup1">
                    <NavLink to="/signup" id="signup1">SIGN UP</NavLink>
                </li>
            </ul>

            <form action="" method="post" className="loginForm">
                <div className="first-input input__block first-input__block">
                    <input type="text" placeholder="ID / Email" className="input" id="username" onChange={(e) => setUsername(e.target.value)}/>
                </div>
                <div className="input__block">
                    <input type="password" placeholder="Password" className="input" id="password" onChange={(e) => setPassword(e.target.value)}/>
                </div>
                <div className="error">
                    {errormsg}
                </div>
                <button className="signin__btn" onClick={signIn}>
                    Sign In
                </button>
            </form>
            <div className="separator">
                <p>OR</p>
            </div>
            <button className="google__btn">
                <i className="fa fa-google"></i>
                Sign in with Google
            </button>
            <button className="github__btn">
                <i className="fa fa-github"></i>
                Sign in with GitHub
            </button>
        </div>
    )
}

export default Login;