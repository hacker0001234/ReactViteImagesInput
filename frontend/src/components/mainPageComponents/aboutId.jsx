import React, {useEffect, useState} from "react";
import {isRouteErrorResponse, useParams} from "react-router-dom";
import axios from "axios";
import "./aboutId.css"
import ArrowBackIosNewIcon from '@mui/icons-material/ArrowBackIosNew';
import ArrowForwardIosIcon from '@mui/icons-material/ArrowForwardIos';

export default function AboutId(){

const {id} = useParams();
const [user,setUser] =useState([]);
const [userWithUrl,setUserWithUrl] = useState([]);
const [img2,setImg2] = useState([]);
const [img3,setImg3] = useState([]);
const [img4,setImg4] = useState([]);
    const [img5,setImg5] = useState([]);
    const [img6,setImg6] = useState([]);
    const [img7,setImg7] = useState([]);
    const [img8,setImg8] = useState([]);
const [img9,setImg9]  = useState([]);
const [images,setImages] = useState([`http://localhost:8080/images/id/${id}`]);
const [index,setIndex] = useState(0);

    useEffect(() => {
        axios.get(`http://localhost:8080/images/id/${id}/Image2`,{withCredentials:true}).then(resp =>{
            setImg2(resp.data);
        }).catch(error =>{
            setImg2(null);
        })
        axios.get(`http://localhost:8080/images/id/${id}/Image3`,{withCredentials:true}).then(resp =>{
            setImg3(resp.data);
        }).catch(error =>{
            setImg3(null);
        })
        axios.get(`http://localhost:8080/images/id/${id}/Image4`,{withCredentials:true}).then(resp =>{
            setImg4(resp.data);
        }).catch(error =>{
            setImg4(null);
        })
        axios.get(`http://localhost:8080/images/id/${id}/Image5`,{withCredentials:true}).then(resp =>{
            setImg5(resp.data);
        }).catch(error =>{
            setImg5(null);
        })
        axios.get(`http://localhost:8080/images/id/${id}/Image6`,{withCredentials:true}).then(resp =>{
            setImg6(resp.data);
        }).catch(error =>{
            setImg6(null);
        })
        axios.get(`http://localhost:8080/images/id/${id}/Image7`,{withCredentials:true}).then(resp =>{
            setImg7(resp.data);
        }).catch(error =>{
            setImg7(null);
        })
        axios.get(`http://localhost:8080/images/id/${id}/Image8`,{withCredentials:true}).then(resp =>{
            setImg8(resp.data);
        }).catch(error =>{
            setImg8(null);
        })
        axios.get(`http://localhost:8080/images/id/${id}/Image9`,{withCredentials:true}).then(resp =>{
            setImg9(resp.data);
        }).catch(error =>{
            setImg9(null);
        })
        axios.get(`http://localhost:8080/user/${id}`,{withCredentials:true}).then(response => {
            setUser(response.data);
        }).catch(reason => console.log("error",reason));

    }, []);
    useEffect(() => {

        axios.get("http://localhost:8080/user/email", {
            withCredentials: true,
            headers: {
                "email": user.email
            }
        }).then(response => {

            setUserWithUrl(response.data);
        })

    }, [user]);

    useEffect(()=>{
        if (img2[0] !== undefined) {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/${id}/Image2`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/${id}/Image2`]
            );
        }
    },[img2])

    useEffect(()=>{
        if (img3[0] !== undefined) {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/${id}/Image3`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/${id}/Image3`]
            );
        }
    },[img3])

    useEffect(()=>{
        if (img4[0] !== undefined) {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/${id}/Image4`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/${id}/Image4`]
            );
        }
    },[img4])

    useEffect(()=>{
        if (img5[0] !== undefined) {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/${id}/Image5`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/${id}/Image5`]
            );
        }
    },[img5])

    useEffect(()=>{
        if (img6[0] !== undefined) {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/${id}/Image6`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/${id}/Image6`]
            );
        }
    },[img6])

    useEffect(()=>{
        if (img7[0] !== undefined) {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/${id}/Image7`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/${id}/Image7`]
            );
        }
    },[img7])

    useEffect(()=>{
        if (img8[0] !== undefined) {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/${id}/Image8`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/${id}/Image8`]
            );
        }
    },[img8])

    useEffect(()=>{
        if (img9[0] !== undefined) {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/${id}/Image9`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/${id}/Image9`]
            );
        }
    },[img9])

    const nextImage = () =>{
        if(index===9){
            setIndex(0);
        }
        else {
            setIndex((index + 1) % images.length);
        }
    }
    const prevImage = () => {
        console.log(index);
        if(index===0){
            let check = true;
            let indx = 8;
            while (check){
                if(images[indx]!==undefined){
                    setIndex(indx);
                    check=false;
                }
                indx--;
            }
        }else {

            setIndex((index - 1 + images.length) % images.length); // Попередня
        }

    };
    return(
    <div>

        <div className="aboutId">
            {userWithUrl.email ? (
                <>
            {userWithUrl.avatarUrl && <img src={userWithUrl.avatarUrl} alt="'" className="avatar"/>}
        <h1>{userWithUrl.name}</h1>
        <p>{userWithUrl.email}</p>
            <img className="caroselImg" src={images[index]}/>
            <button className="nextBtn" onClick={nextImage}><ArrowForwardIosIcon/></button>
            <button className="prevBtn" onClick={prevImage}><ArrowBackIosNewIcon/></button>
            <button className="backBtnn" onClick={() =>(window.location.href="http://localhost:5173/")}>back</button>
                </> ) : (
        <>
            <div class="loader"></div>
        </>
        )}
        </div>
    </div>
);
}
