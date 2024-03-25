import '/src/css/Menu.css'
import pc1 from "./photos/Group 93.svg";
import {useEffect, useState} from "react";
import apicall from "./apicall/apicall.js";

function Menu() {
    const [categories, setCategories] = useState([])
    const [name, setName] = useState("")
    useEffect(() => {
        getCategories();
    }, []);

    function getCategories() {
        apicall("/category", "GET", {}, {Authorization: localStorage.getItem("access_token")}).then(res => {
            setCategories(res.data)
        }).catch(
            apicall("/refresh", "POST", {}, {refreshToken: localStorage.getItem("refresh_token")}).then(res => {
                localStorage.setItem("access_token", res.data)
            }))
    }

    function saveCategory() {
        apicall("/category", "POST", {name:name, userId:localStorage.getItem("userId")}, {Authorization: localStorage.getItem("access_token")}).then(res => {
            setCategories(res.data)
        }).catch(
            apicall("/refresh", "POST", {}, {refreshToken: localStorage.getItem("refresh_token")}).then(res => {
                localStorage.setItem("access_token", res.data)
            })
        )
    }

    return (
        <div className="menu container">
            <div>
                <div>
                    <button className={"btn btn-dark"} onClick={saveCategory}>add category</button>
                    <input type="text"  onClick={(e)=>setName(e.target.value)}/>
                    <ul>{categories.length && categories.map((item, index) => {
                        return <li key={index}>{item.name}</li>
                    })}
                    </ul>
                </div>
                <h2 className={"menu_text"}>Menu</h2>
                <h1 className={"menu_text2"}>Food full of treaty love</h1>
                <p className={"menu_text3"}>During the summer, we enjoyed picnics in the park, swimming in the pool, and
                    barbecues with friends and family. The warm weather brought joy and laughter to our days.</p>

                <div className=" row flex-wrap gap-3 d-flex card_group">
                    <div className="card p-3" style={{width: "25%"}}>
                        <div className="card-img">
                            <img className={"imgage"} src={pc1} alt=""/>
                        </div>
                        <div>
                            <h2 className="card-text">Vegie Muffen</h2>
                            <h2 className="card-text">16$</h2>
                        </div>
                        <p className="card-text">
                            There are many things are needed to start the Fast Food Business.
                        </p>
                        <button className="btn btn-warning">+</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Menu;
