import './css/Menu.css';
import pc1 from "./photos/Group 93.svg";
import pc2 from "./photos/Group 93.svg";
import pc3 from "./photos/Group 94.svg";
import pc4 from "./photos/Group 94.svg";
import pc5 from "./photos/Group 94.svg";

function Menu() {
    return (
        <div className="menu container">
            <div>
                <h2 className={"menu_text"}>Menu</h2>
                <h1 className={"menu_text2"}>Food full of treaty love</h1>
                <p className={"menu_text3"}>During the summer, we enjoyed picnics in the park, swimming in the pool, and barbecues with friends and family. The warm weather brought joy and laughter to our days.</p>

                <div className=" row flex-wrap gap-3 d-flex card_group">
                    <div className="card p-3" style={{width:"25%"}}>
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

                    <div className="card border rounded p-3 w-25">
                        <div className="card-img">
                            <img className={"imgage"} src={pc2} alt=""/>
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
                    <div className="card border rounded p-3 w-25">
                        <div className="card-img">
                            <img className={"imgage"} src={pc3} alt=""/>
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
                    <div className="card border rounded p-3 w-25">
                        <div className="card-img">
                            <img className={"imgage"} src={pc4} alt=""/>
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
                    <div className="card border rounded p-3 w-25">
                        <div className="card-img">
                            <img className={"imgage"} src={pc5} alt=""/>
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
