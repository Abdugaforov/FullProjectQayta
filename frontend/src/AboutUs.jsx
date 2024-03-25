import '/src/css/AboutUs.css'
import picture from "./photos/FmlS61J9LP 1.svg";
function AboutUs() {
    return (
        <div>
          <div className={"middle"}>
              <div className={"middle_container"}>
                  <div className={"middle_picture"}>
                      <img className={"middle_img"} src={picture} alt=""/>4
                  </div>
                  <div className={"middle_left"}>
                        <p className={"middle_p"}>ABOUT US</p>
                      <h1 className={"middle_h1"}>Food Stalls with Persons but to Product marketing plane catlogues etc to.</h1>
                      <p className={"middle_p2"}>There are many things are needed to start the Fast Food Business. You need not only Just Food Stalls with Persons but also equipment make your marketing plane Effective.</p>
                      <button className={"btn_middle"}>READ MORE</button>
                  </div>
              </div>
          </div>
        </div>
    )
}

export default AboutUs
