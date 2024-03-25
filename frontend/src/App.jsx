import '/src/css/App.css'
import picture from "./photos/CSmJnTefxM 1.svg"
import {useNavigate} from "react-router-dom";
function App() {
    const x = useNavigate();
    return (
        <div>
            <div className={"header"}>
                <div className={"header_container"}>

                    <div className={"box1_container"}>
                        <img className={"header_img"} src={picture} alt=""/>
                        <ul className={"ul_group"}>{}
                            <li onClick={(e)=>x("")} className={"li1"}>Home</li>
                            <li onClick={e=>{x("/aboutUs")}} className={"li"}>About us</li>
                            <li onClick={e=>{x("/menu")}} className={"li"}>Menu</li>
                            <li onClick={e=>x("/features")} className={"li"}>Features</li>
                            <li className={"li"}>contact us</li>
                        </ul>
                    </div>
                    <div className={"box2_container"}>
                        <button className={"booking_button"}>booking now</button>
                    </div>
                </div>
            </div>
            <div className={"main"}>
                <div className={"main_container"}>
                    <div className={"main_box1"}>
                        <h1 className={"main_Text_h1"}>Making time a good time by making food the good food.</h1>
                        <p className={"main_Text_p"}>There are many things are needed to start the Fast Food Business. You need not only Just Food Stalls with Persons but also specialized equipment,</p>
                   <div className={"main_btn_group"}>
                       <button className={"main_button_order"}>Order Now</button>
                       <button className={"main_button_food_detail"}>Food Details</button>
                   </div>
                    </div>
                    <div className={"main_box2"}>
                        <img src={picture} alt=""/>
                    </div>
                </div>
            </div>

        </div>
    )
}

export default App
