import React, {useEffect} from "react";
import { useState } from "react";
import axios from "axios";
import CSRF from "./CSRF_TOKEN.jsx";

export default function ImageUpload() {
    const [file, setFile] = useState(null);
    const [csrfToken, setCsrfToken] = useState(null);

const getToken= async ()=>{
setCsrfToken(null);
const token = await CSRF();
setCsrfToken(token);
}
    useEffect(() => {
        getToken();
    }, []);
    useEffect(() => {

    }, [csrfToken]);
    const handleFileChange = (event) => {
            setFile(event.target.files[0]);
        };

        const handleUpload = async () => {
            if (!file) return;

            const formData = new FormData();
            formData.append("file", file);

            try {
                const response = await axios.post("http://localhost:8080/images/upload", formData, {
                    headers: {"Content-Type": "multipart/form-data", "X-XSRF-TOKEN": csrfToken},
                    withCredentials:true
                });

            } catch (error) {
                console.error("Error uploading file:", error);
            }
        };

        return (
            <div>
                <input type="file" onChange={handleFileChange} required/>
                <button onClick={handleUpload}>Upload</button>
            </div>
        );
    }
