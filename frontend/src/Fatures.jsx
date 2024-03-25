import '/src/css/Feature.css'
import  rasm1 from "./photos/Group 94.svg"
import  rasm2 from "./photos/food-delivery.svg"
import  rasm3 from "./photos/Group 93.svg"
function Features() {
    return (
        <div className={"feature"}>
          <div className={"feature_container"}>
              <h3 className={"text-center feature_text"}>Features</h3>
              <h1 className={"feature_text2"}>Food with a New Passion</h1>
              <div className={"box_group"}>
                  <div className={"box"}>
                      <div className={"feature_box_img"}>
                          <img className={"box_img"} src={rasm1} alt=""/>
                      </div>
                      <h2 className={"box_h1"}>Quality Food</h2>
                      <p className={"box_p"}>It can be a very secure path to earn good money and make you very successful creative entrepreneur.</p>
                  </div>
                  <div className={"box"}>
                      <div className={"feature_box_img"}><img className={"box_img"} src={rasm2} alt=""/></div>
                      <h2 className={"box_h1"}>Food Delivery</h2>
                      <p className={"box_p"}>It can be a very secure path to earn good money and make you very successful creative entrepreneur.</p>
                  </div>
                  <div className={"box"}>
                      <div className={"feature_box_img"}><img className={"box_img"} src={rasm3} alt=""/></div>
                      <h2 className={"box_h1"}>Super Taste</h2>
                      <p className={"box_p"}>It can be a very secure path to earn good money and make you very successful creative entrepreneur.</p>
                  </div>
              </div>

          </div>
        </div>
    )
}

export default Features
