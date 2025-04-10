import {Navigate} from "react-router-dom";
import axios from "axios";
import React, {useEffect, useState} from "react";


export default function Aunticated({children}){
    const [isAuthenticated, setIsAuthenticated] = useState(null);

    useEffect(() => {

        axios.get("http://localhost:8080/api/auth/check",{withCredentials:true})
            .then(response => {
                if(response.data===true) {
                    setIsAuthenticated(true);
                }
                else {
                    setIsAuthenticated(false);


                }
            })
            .catch(error => {
                setIsAuthenticated(false);
            });
    }, []);

    if (isAuthenticated === null) {
        return <div>Loading...</div>;
    }

    return (
        isAuthenticated ? children :  <Navigate to="/auntication" />
    );
}
