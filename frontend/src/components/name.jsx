import React, {useEffect, useState} from "react";
import axios from "axios";
import Cookies from "universal-cookie";
import {Base64} from "js-base64";
import './name.css';

export default function Name(){
    const [email, setEmail] = useState("");
    const [name,setName] = useState("");
    const [avatar,setAvatar] = useState("");
    const [testEmail,setTestEmail] = useState("");
    const [aunticated,setAunticated] = useState(false);

    const cookies = new Cookies();


    useEffect(()=>{
axios.post("http://localhost:8080/user/create", {}, {withCredentials: true}).then(r =>{
               setTestEmail(r.data.email);
        if(testEmail === null){
            window.location.reload();
        }
        else {
            handleUser();
        }}
            );



            const encodeEmail = cookies.get("email");
            const decodeEmail = atob(encodeEmail);
            setEmail(decodeEmail);


            const encodedName = cookies.get("name");
            const decodedName = Base64.decode(encodedName);
            setName(decodedName);


            const encodeAvatar = cookies.get("avatar");
            const decodeAvatar = atob(encodeAvatar);
            setAvatar(decodeAvatar);

            setTimeout(() => {

            setAunticated(true);
            },100);

    },[]);



    const handleUser = async () => {
        try {
            const response = await axios.get("http://localhost:8080/user", { withCredentials: true });
            if (response.data) {
                setName(response.data.name);
                setEmail(response.data.email);
                setAvatar(response.data.avatar);


                setTimeout(() => {

                    setAunticated(true);
                },100);

            } else {
                alert("null");
            }
        } catch (e) {
            console.error("error ", e);
        }

    };
    return (
        <div>
            { aunticated ? (
                name ? (
                <div className="profileContainer">
                    <img className="uravatar" src={avatar} alt="notFound"/>
                    <p className="welcomep1" >hello {name}</p>
                    <p  className="welcomep2">ur email: {email}</p>
                    <button className="backBtn" onClick={() => (window.location.href="/")}>back</button>
                </div>
            ) : (
                <button onClick={handleUser}>Click to get your data</button>
            )) : (
                <div className="loader"></div>)}
        </div>
    );
}
