import './App.css'
import {BrowserRouter as Router,Routes,Route} from "react-router-dom";
import ImageUpload from "./components/Test.jsx";
import Aunticated from "./components/aunticated.jsx";
import Auntication from "./components/auntication.jsx";
import Name from "./components/name.jsx";
import MainPage from "./components/mainPageComponents/mainPage.jsx";
import Logout from "./components/mainPageComponents/Logout.jsx";
import AboutId from "./components/mainPageComponents/aboutId.jsx";
import Account from "./components/mainPageComponents/Account.jsx";

function App() {


    return (
    <Router>
        <Routes>
            <Route path="/upload" element={<Aunticated><ImageUpload/></Aunticated>}/>
            <Route path="/auntication" element={<Auntication/>}/>
            <Route path="/user" element={<Aunticated> <Name/></Aunticated>}/>
            <Route path="/logout" element={<Logout/>}/>
            <Route path="/" element={<MainPage/>}/>
            <Route path="/user/images/:id" element={<Aunticated><AboutId/></Aunticated>}/>
            <Route path="/account" element={<Aunticated><Account/></Aunticated>}/>
        </Routes>
    </Router>
    )
}

export default App
