import { Route, Routes } from "react-router-dom";
import { Provider } from 'react-redux';
import { store } from './store.js';
import App from "./App.jsx";
import AboutUs from "./AboutUs.jsx";
import Menu from "./Menu.jsx";
import Features from "./Fatures.jsx";
import Register from "./auth/Register.jsx";
import Login from "./auth/Login.jsx";
import CardPage from "./CardPage.jsx";

function Router() {
    return (
        <Provider store={store}>
            <div className={"container"}>
                <Routes>
                    <Route path={"/app"} element={<App />} />
                    <Route path={"/aboutUs"} element={<AboutUs />} />
                    <Route path={"/menu"} element={<Menu />} />
                    <Route path={"/features"} element={<Features />} />
                    <Route path={"/"} element={<Register />} />
                    <Route path={"/login"} element={<Login />} />
                    <Route path={"/cart"} element={<CardPage />} />
                </Routes>
            </div>
        </Provider>
    )
}

export default Router;
