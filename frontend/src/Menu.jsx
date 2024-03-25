import '/src/css/Menu.css'
import pc1 from "./photos/Group 93.svg";
import {useEffect, useState} from "react";
import apicall from "./apicall/apicall.js";
import {useNavigate} from "react-router-dom";

function Menu() {
    const navigate = useNavigate()
    const [categories, setCategories] = useState([])
    const localDate = localStorage.getItem("cart")
    const [product, setProduct] = useState([])
    const [cart, setCart] = useState(
        localDate == null ? [] : JSON.parse(localDate)
    )
    const [name, setName] = useState("")
    useEffect(() => {
        getCategories();
        getProduct;
        getOneProduct;
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
            getCategories()
        }).catch(
            apicall("/refresh", "POST", {}, {refreshToken: localStorage.getItem("refresh_token")}).then(res => {
                localStorage.setItem("access_token", res.data)
            })
        )
    }



    function getProduct() {
        apicall("/product/all", "GET").then(res => {
            setProduct(res.data)
        })
    }
    function getOneProduct(categoryId) {
        apicall(`/product/by?categoryId=${categoryId}`, "GET").then(res => {
            setProduct(res.data)
        })
    }
    function addToCard(item) {
           cart.push({...item,count:1});
           setCart([...cart]);
           localStorage.setItem("cart",JSON.stringify(cart))
    }
    return (
        <div className="menu container">
            <div>
                <button onClick={()=>navigate("/cart")} className={"btn btn-info text-light"}>Basket ({cart.length})</button>
                <div>
                    <div className={"d-flex gap-2 col-7"}>
                        <input placeholder={"Category name.."} type="text" value={name} onChange={(e) => setName(e.target.value)}/>
                        <button className={"btn btn-dark col-2"} onClick={saveCategory}>add category</button>
                    </div>
                    <ul className={"list-group"}>
                        <li className={"list-group-item btn btn-dark col-2 my-1"} onClick={e => getProduct()}>all</li>
                        {categories.length && categories.map((item, index) => {
                        return <li className={"list-group-item btn btn-dark col-2 my-1"} onClick={()=>getOneProduct(item.id)} key={index}>{item.name}</li>
                    })}
                    </ul>
                </div>
                <h2 className={"menu_text"}>Menu</h2>
                <h1 className={"menu_text2"}>Food full of treaty love</h1>
                <p className={"menu_text3"}>During the summer, we enjoyed picnics in the park, swimming in the pool, and
                    barbecues with friends and family. The warm weather brought joy and laughter to our days.</p>

                <div className=" row flex-wrap gap-3 d-flex card_group">
                    {product.map((item,index)=> {


                        return <div className="card p-3" style={{width: "25%"}}>
                            <div className="card-img">
                                <img className={"imgage"} src={pc1} alt=""/>
                            </div>
                            <div>
                                <h2 className="card-text">{item.name}</h2>
                                <h2 className="card-text">{item.price}$</h2>
                            </div>
                            <p className="card-text">
                                There are many things are needed to start the Fast Food Business.
                            </p>
                            <button disabled={cart.find((itm)=>itm.id===item.id)} onClick={()=>addToCard(item)} className="btn btn-warning">ADD TO CARD</button>
                        </div>
                    })}
                </div>
            </div>
        </div>
    )
}

export default Menu;
