import React, {useState} from 'react';
import {useNavigate} from "react-router-dom";
import apicall from "../apicall/apicall.js";
import "/src/css/Register.css"


function Register() {
  const navigate = useNavigate();
    const [fullName, setFullName] = useState('')
    const [password, setPassword] = useState('')
    const [email, setEmail] = useState('')
    const [age, setAge] = useState('')
    function submit() {
        if(fullName,password,email,age){
            apicall("/register","post",{fullName,password,email,age}).then(res=>navigate("/login"));
        }else{
            alert("iltimos kiriting!")
        }
    }
    return (
        <div>
            <div className="row my-5">
                <div className="col-md-6 offset-md-3">
                    <div className="card">
                        <div className="card-header display-5 text-center bg-dark">Sign Up</div>
                        <div className="card-body">
                            <div className="form-group">
                                <label htmlFor="email">EMAIL</label>
                                <input
                                    value={email}
                                    onChange={(e)=>setEmail(e.target.value)}
                                    className="form-control"
                                    type="text"
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="fullName">FULLNAME</label>
                                <input
                                    value={fullName}
                                    onChange={(e)=>setFullName(e.target.value)}
                                    className="form-control"
                                    type="text"
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="age">AGE</label>
                                <input
                                    value={age}
                                    onChange={(e)=>setAge(e.target.value)}
                                    className="form-control"
                                    type="text"
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="password">Password</label>
                                <input
                                    value={password}
                                    onChange={(e)=>setPassword(e.target.value)}
                                    className="form-control"
                                    type={"password"}
                                />
                            </div>
                        </div>
                        <div className="card-footer">
                            <button onClick={submit} className="btn btn-dark" form="form">
                                Save
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Register;