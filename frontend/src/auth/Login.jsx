import  {useState} from 'react';
import {useNavigate} from "react-router-dom";
import apicall from "../apicall/apicall.js";

function Login() {
    const [email,setEmail]=useState('')
    const [password,setPassword]=useState('')
    const navigate=useNavigate()
    function submitLogin() {
        apicall("/login","post",{username:email,password}).then(res=>{
            if(res.data){
                localStorage.setItem("access_token",res.data.access_token)
                localStorage.setItem("refresh_token",res.data.refresh_token)
                apicall("/user/getId","GET", {}, {refreshToken:localStorage.getItem("refresh_token")}).then(({data})=>{
                    localStorage.setItem("userId", data);
                })
                navigate("/app")
            }else {
                alert("err")
            }
        }).catch(()=>alert("parol xato"))
    }
    return (
        <div className={""}>
            <div className={"card w-50 p-4 text-center my-5 bg-dark"}>
                <h3 className={"text-white"}>Login</h3>
                <input
                    value={email}
                    onChange={(e)=>setEmail(e.target.value)}
                    className={"form-control my-2"}
                    type={"text"}
                    placeholder={"email..."}/>
                <input
                    value={password}
                    onChange={(e)=>setPassword(e.target.value)}
                    className={"form-control my-2"}
                    type={"password"}
                    placeholder={"password..."}/>
                <button onClick={submitLogin} className={"btn btn-outline-success my-3"}>save</button>
            </div>
        </div>
    );
}

export default Login;