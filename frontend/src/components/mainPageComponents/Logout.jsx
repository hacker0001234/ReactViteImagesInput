import React from "react";
import './logout.css';
import {Button} from "@mui/material";

export default function Logout(){

    return(
        <div>
            <p className="logoutQuestion">Do u real wanna log out?</p>
            <Button class="yesBtn" variant="outlined"  color="error" onClick={() => (window.location.href="http://localhost:8080/logout")}>YES</Button>
            <Button class="noBtn" variant="outlined"  color="success" onClick={() => (window.location.href="/")}>NO</Button>
        </div>
    );
}