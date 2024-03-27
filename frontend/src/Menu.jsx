import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import Rodal from "rodal";
import 'rodal/lib/rodal.css';
import { getCategoriesAsync, saveCategoryAsync } from "/src/categoriesSlice.jsx";
import { getAllProductsAsync } from '/src/productSlice .jsx';
import { addToCart } from "./cartSlice.jsx";

import pc1 from "./photos/Group 93.svg";
import picture from "/src/photos/Group 93.svg";

function Menu() {
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const categories = useSelector(state => state.categories.categories);
    const products = useSelector(state => state.products.products);
    const cart = useSelector(state => state.cart.cart);

    const [name, setName] = useState("");
    const [visible, setVisible] = useState(false);
    const [form, setForm] = useState({
        name: "",
        productCount: 0,
        isActive: true,
        price: "",
        image: picture,
        categoryId: "",
        userId: localStorage.getItem("userId")
    });

    useEffect(() => {
        dispatch(getCategoriesAsync());
        dispatch(getAllProductsAsync());
    }, [dispatch]);

    function openModal() {
        setVisible(!visible);
    }

    function saveCategory() {
        dispatch(saveCategoryAsync({ name: name, userId: localStorage.getItem("userId") }));
    }

    function getProduct(categoryId) {
        if (categoryId) {
            dispatch(getProductByCategoryAsync(categoryId));
        } else {
            dispatch(getAllProductsAsync());
        }
    }

    function addToCard(item) {
        dispatch(addToCart({ ...item, count: 1 }));
    }

    function saveProduct() {
        dispatch(saveProductAsync(form)).then(() => {
            getProduct(form.categoryId);
            openModal();
        });
    }

    const handleChange = (e) => {
        const { name, value } = e.target;
        setForm(prevForm => ({
            ...prevForm,
            [name]: value
        }));
    };

    return (
        <div className="menu container">
            <Rodal visible={visible} onClose={openModal}>
                <input type="text" name="name" value={form.name} onChange={handleChange} />
                <input type="text" name="productCount" value={form.productCount} onChange={handleChange} />
                <input type="text" name="price" value={form.price} onChange={handleChange} />
                <button onClick={saveProduct}>save</button>
            </Rodal>
            <div>
                <button onClick={() => navigate("/cart")} className={"btn btn-info text-light"}>Basket ({cart.length})</button>
                <button onClick={() => openModal()} className={"btn btn-danger text-light"}>add product</button>
                <div>
                    <div className={"d-flex gap-2 col-7"}>
                        <input placeholder={"Category name.."} type="text" value={name} onChange={(e) => setName(e.target.value)} />
                        <button className={"btn btn-dark col-2"} onClick={saveCategory}>add category</button>
                    </div>
                    <ul className={"list-group"}>
                        <li className={"list-group-item btn btn-dark col-2 my-1"} onClick={() => getProduct()}>all</li>
                        {categories.map((item, index) => (
                            <li className={"list-group-item btn btn-dark col-2 my-1"} onClick={() => getProduct(item.id)} key={index}>{item.name}</li>
                        ))}
                    </ul>
                </div>
                <h2 className={"menu_text"}>Menu</h2>
                <h1 className={"menu_text2"}>Food full of treaty love</h1>
                <p className={"menu_text3"}>During the summer, we enjoyed picnics in the park, swimming in the pool, and
                    barbecues with friends and family. The warm weather brought joy and laughter to our days.</p>

                <div className=" row flex-wrap gap-3 d-flex card_group">
                    {products.map((item, index) => (
                        <div className="card p-3" style={{ width: "25%" }} key={index}>
                            <div className="card-img">
                                <img className={"imgage"} src={pc1} alt="" />
                            </div>
                            <div>
                                <h2 className="card-text">{item.name}</h2>
                                <h2 className="card-text">{item.price}$</h2>
                            </div>
                            <p className="card-text">
                                There are many things are needed to start the Fast Food Business.
                            </p>
                            <button disabled={cart.find((itm) => itm.id === item.id)} onClick={() => addToCard(item)} className="btn btn-warning">ADD TO CARD</button>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    )
}

export default Menu;
