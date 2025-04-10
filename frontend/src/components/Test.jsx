import React, { useEffect, useState } from "react";
import axios from "axios";
import CSRF from "./CSRF_TOKEN.jsx";
import { Button, Snackbar } from "@mui/material";
import "./img.css";
import Icon from '@mui/material/Icon';
import KeyboardBackspaceIcon from '@mui/icons-material/KeyboardBackspace';

export default function ImageUpload() {
    const [files, setFiles] = useState([]);
    const [csrfToken, setCsrfToken] = useState(null);
    const [preview, setPreview] = useState([]);
    const [open, setOpen] = useState(false);
    const [isFiles, setisFiles] = useState(true);

    let limit = false;
    if (files === null) {
        limit = true;
    } else if (files.length < 9) {
        limit = true;
    }

    const getToken = async () => {
        setCsrfToken(null);
        const token = await CSRF();
        setCsrfToken(token);
    };

    useEffect(() => {
        setisFiles(false);
        getToken();
    }, []);
    useEffect(() => {
        if (preview.length === 0) {
            setisFiles(false); // Якщо масив порожній, ставимо false
        } else {
            setisFiles(true); // Якщо масив не порожній, ставимо true
        }
    }, [preview]);
    const handleFileChange = (event) => {
        if (limit) {
            const newFiles = event.target.files; // Отримуємо вибрані файли
            const newFileUrls = Array.from(newFiles).map(file => URL.createObjectURL(file)); // Створюємо URL для кожного файлу

            setPreview(prevPreview => [...prevPreview, ...newFileUrls]);
            setFiles(prevFiles => [...prevFiles, ...event.target.files]);
            setisFiles(true);
        }
    };

    const handleClose = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }
        setOpen(false);
    };

    const handleUpload = async () => {
        setOpen(true);
        const formData = new FormData();
        setisFiles(false);

        for (let i = 0; i < files.length; i++) {
            formData.append('files', files[i]);
        }

        setFiles([]);
        setPreview([]);
        try {
            const response = await axios.post("http://localhost:8080/images/upload", formData, {
                headers: { "Content-Type": "multipart/form-data", "X-XSRF-TOKEN": csrfToken },
                withCredentials: true
            });
        } catch (error) {
            console.error("Error uploading file:", error);
        }
        window.location.href ="http://localhost:5173/";

    };

    // Функція для видалення картинки з обраних
    const removeImage = (index) => {
        setPreview(prevPreview => prevPreview.filter((_, i) => i !== index));


        setFiles(prevFiles => prevFiles.filter((_, i) => i !== index));
    };

    const toMain = () =>{
    window.location.href ="http://localhost:5173/";
    }
    return (
        <div>
            <div className="imagesGroup">
                {preview && preview.map((url, index) => (
                    <div key={index} className="image-container">
                        <img src={url} alt={`preview-${index}`} />
                        <button
                            className="remove-btn"
                            onClick={() => removeImage(index)}
                        >
                            ✖
                        </button>
                    </div>
                ))}
            </div>

            {limit ? (
                <input
                    type="file"
                    multiple
                    name="files"
                    id="upload-file"
                    style={{ display: "none" }}
                    onChange={handleFileChange}
                    required
                />
            ) : (
                <></>
            )}

            <label htmlFor="upload-file">
                {limit ? (
                    <Button color="primary" component="span">
                        <Icon>add_circle</Icon>
                    </Button>
                ) : (
                    <Button color="primary" component="span" disabled>
                        <Icon>add_circle</Icon>
                    </Button>
                )}
            </label>
            {isFiles ? (
                <Button variant="contained" color="success" onClick={handleUpload}>
                    Send
                </Button>
            ) : (
                <Button variant="contained" color="success" disabled>
                    Send
                </Button>
            )}

            <div>
                <Snackbar open={open} autoHideDuration={3000} onClose={handleClose} message="Send!" />
            </div>
            <div id="backBtn">
            <Button variant="contained" onClick={toMain}>
               <KeyboardBackspaceIcon></KeyboardBackspaceIcon> back to main
            </Button>
            </div>
        </div>

    );
}
