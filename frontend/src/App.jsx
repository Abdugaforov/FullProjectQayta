import './css/App.css'
import picture from "./photos/CSmJnTefxM 1.svg";
import {useNavigate} from "react-router-dom";
function App() {
    const x=useNavigate();


    return (
        <div>
            <div className={"header"}>
                <div className={"header_container"}>
                    <div className={"box1_container"}>
                        <img className={"header_img"}
                             src="https://s3-alpha-sig.figma.com/img/e8ad/f3eb/c77a6232d187d0552a6a4dc4f0b003ae?Expires=1711929600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=VjO~rW7~xKjyglykACouBOniP7vQH9MyS-pzCT0C1x-FktHOKmBZ5vdIfw-WUeApKdPag2KYEg2NpSuMwrdXDb0CfUsKDgInA5kQaF2C4hBU8URddYPyVvjxC0bkAJz-lNNZZc4g8pnjei3VMqbLOVCyBIAyFlWDyjSEvF0TPg8jBSJ6HNo-GXyhhKZsuL450PO1C9YmRu2V75qjsPc9SE7t-033OVS96xCcNPgg25tRQ-tJUjIKUa1nK0ZfNw33xzN4o1mOHujK4qbi-MZnvfEZLcF5TOdaAn4uc6RllJHARTF65-nxJIiguAY0CG1p0KL2INLOuN9ppgkG6~X8Xg__"
                             alt=""/>
                        <ul className={"ul_group"}>
                            <li onClick={()=>x("/")} className={"li1"}>Home</li>
                            <li onClick={()=>x("/aboutUs")} className={"li"}>About us</li>
                            <li onClick={()=>x("/menu")} className={"li"}>Menu</li>
                            <li onClick={()=>x("/features")} className={"li"}>Features</li>
                            <li onClick={()=>x("/")} className={"li"}>contact us</li>
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
                        <h1 className={"main_Text_h1"}>Making time a good time by making food the good <br/>food.</h1>
                        <p className={"main_Text_p"}>There are many things are needed to start the Fast Food Business. You need not only Just Food Stalls with Persons but also specialized equipment,</p>
                        <div className={"main_btn_group"}>
                            <button className={"main_button_order"}>Order Now</button>
                            <button className={"main_button_food_detail"}>Food Details</button>
                        </div>
                    </div>
                    <div className={"main_box2"}>
                        <img className={"main_img"} src={picture} alt=""/>
                    </div>
                </div>
            </div>


        </div>
    )
}

export default App
