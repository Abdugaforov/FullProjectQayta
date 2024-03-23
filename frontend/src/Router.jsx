import {Route, Routes} from "react-router-dom";
import App from "./App.jsx";
import AboutUs from "./AboutUs.jsx";
import Menu from "./Menu.jsx";
import Features from "./Fatures.jsx";
function Router() {

    return (
        <div className={"container"}>
            <Routes>
                <Route path={"/"} element={<App/>}/>
                <Route path={"/aboutUs"} element={<AboutUs/>}/>
                <Route path={"/menu"} element={<Menu/>}/>
                <Route path={"/features"} element={<Features/>}/>
            </Routes>
        </div>
    )

}

export default Router
