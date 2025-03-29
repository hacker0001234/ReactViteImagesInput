import React from "react";
import { useState } from "react";
import axios from "axios";

export default function ImageUpload() {
    const [file, setFile] = useState(null);

    const handleFileChange = (event) => {
        setFile(event.target.files[0]);
    };

    const handleUpload = async () => {
        if (!file) return;

        const formData = new FormData();
        formData.append("file", file);

        try {
            const response = await axios.post("http://localhost:8080/images/upload", formData, {
                headers: { "Content-Type": "multipart/form-data" },
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
