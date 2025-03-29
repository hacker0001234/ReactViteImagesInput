import './App.css'
import {BrowserRouter as Router,Routes,Route} from "react-router-dom";
import ImageUpload from "./components/Test.jsx";

function App() {


    return (
    <Router>
        <Routes>
            <Route path="/" element={<ImageUpload/>}/>
        </Routes>
    </Router>
    )
}

export default App
