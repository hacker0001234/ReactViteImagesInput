import React, {useEffect, useState} from "react";
import Cookies from "universal-cookie";
import {Base64} from "js-base64";
import axios from "axios";
import ArrowForwardIosIcon from "@mui/icons-material/ArrowForwardIos";
import ArrowBackIosNewIcon from "@mui/icons-material/ArrowBackIosNew";
import "./aboutId.css";
import {Button, styled} from "@mui/material";
import CSRF from "../CSRF_TOKEN.jsx";

export default function Account(){
    const cookies = new Cookies;
    const VisuallyHiddenInput = styled('input')({
        clip: 'rect(0 0 0 0)',
        clipPath: 'inset(50%)',
        height: 1,
        overflow: 'hidden',
        position: 'absolute',
        bottom: 0,
        left: 0,
        whiteSpace: 'nowrap',
        width: 1,
    });
    const [image,setImage] = useState(null);
    const [email,setEmail] = useState("");
    const [name,setName] = useState("");
    const [avatar,setAvatar] = useState("");
    const [img2,setImg2] = useState([]);
    const [img3,setImg3] = useState([]);
    const [img4,setImg4] = useState([]);
    const [img5,setImg5] = useState([]);
    const [img6,setImg6] = useState([]);
    const [img7,setImg7] = useState([]);
    const [img8,setImg8] = useState([]);
    const [img9,setImg9]  = useState([]);
    const [images,setImages] = useState(["http://localhost:8080/images/id"]);
    const [index,setIndex] = useState(0);
    const [isOverflowed,setIsOverflowed] = useState(true);
    const [csrfToken, setCsrfToken] = useState(null);

    const getToken = async () => {
        setCsrfToken(null);
        const token = await CSRF();
        setCsrfToken(token);

    };

    useEffect(() => {

        getToken();
        axios.get(`http://localhost:8080/images/id/Image2`,{withCredentials:true}).then(resp =>{
            setImg2(resp.data);
        }).catch(error =>{
            setImg2(null);
        })
        axios.get(`http://localhost:8080/images/id/Image3`,{withCredentials:true}).then(resp =>{
            setImg3(resp.data);
        }).catch(error =>{
            setImg3(null);
        })
        axios.get(`http://localhost:8080/images/id/Image4`,{withCredentials:true}).then(resp =>{
            setImg4(resp.data);
        }).catch(error =>{
            setImg4(null);
        })
        axios.get(`http://localhost:8080/images/id/Image5`,{withCredentials:true}).then(resp =>{
            setImg5(resp.data);
        }).catch(error =>{
            setImg5(null);
        })
        axios.get(`http://localhost:8080/images/id/Image6`,{withCredentials:true}).then(resp =>{
            setImg6(resp.data);
        }).catch(error =>{
            setImg6(null);
        })
        axios.get(`http://localhost:8080/images/id/Image7`,{withCredentials:true}).then(resp =>{
            setImg7(resp.data);
        }).catch(error =>{
            setImg7(null);
        })
        axios.get(`http://localhost:8080/images/id/Image8`,{withCredentials:true}).then(resp =>{
            setImg8(resp.data);
        }).catch(error =>{
            setImg8(null);
        })
        axios.get(`http://localhost:8080/images/id/Image9`,{withCredentials:true}).then(resp =>{
            setImg9(resp.data);
        }).catch(error =>{
            setImg9(null);
        })

        const encodeEmail = cookies.get("email");
        const decodeEmail = atob(encodeEmail);
        setEmail(decodeEmail);

        const encodeName = cookies.get("name");
        const decodeName = Base64.decode(encodeName);
        setName(decodeName);

        const encodeAvatar = cookies.get("avatar");
        const decodeAvatar = atob(encodeAvatar);
        setAvatar(decodeAvatar);


    }, []);

    useEffect(()=>{
        if (img2[0] !== undefined && img2[0]!==null && img2 !== "notFound") {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/Image2`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/Image2`]
            );
        }
    },[img2])

    useEffect(()=>{
        if (img3[0] !== undefined && img3[0]!==null && img3 !== "notFound") {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/Image3`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/Image3`]
            );
        }
    },[img3])

    useEffect(()=>{
        if (img4[0] !== undefined && img4[0]!==null  && img4 !== "notFound") {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/Image4`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/Image4`]
            );
        }
    },[img4])

    useEffect(()=>{
        if (img5[0] !== undefined && img5[0]!==null  && img5 !== "notFound") {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/Image5`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/Image5`]
            );
        }
    },[img5])

    useEffect(()=>{
        if (img6[0] !== undefined && img6[0]!==null  && img6 !== "notFound") {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/Image6`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/Image6`]
            );
        }
    },[img6])

    useEffect(()=>{
        if (img7[0] !== undefined && img7[0]!==null  && img7 !== "notFound") {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/Image7`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/Image7`]
            );
        }
    },[img7])

    useEffect(()=>{
        if (img8[0] !== undefined && img8[0]!==null  && img8 !== "notFound") {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/Image8`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/Image8`]
            );
        }
    },[img8])

    useEffect(()=>{
        if (img9[0] !== undefined && img9[0]!==null && img9 !== "notFound") {
            setImages(prev =>
                prev.includes(`http://localhost:8080/images/id/Image9`)
                    ? prev
                    : [...prev, `http://localhost:8080/images/id/Image9`]
            );
        }
    },[img9])

    useEffect(() => {
        if(images.length===9){
            setIsOverflowed(true);
        }
        else {
            setIsOverflowed(false);
        }
    }, [images]);
    const nextImage = () =>{
        if(index===9){
            setIndex(0);
        }
        else {
            setIndex((index + 1) % images.length);
        }
    }
    const prevImage = () => {
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
        const deleteImg = () => {
           if(index===0){
               alert("u cant delete first image");
           }else {
               axios.get(`${images[index]}/delete`,{withCredentials:true}).then(
                   window.location.href="/"
               );

           }
        }
        const uploadFile=(event) =>{
       const file = event.target.files[0];
       if(file){
           setImage(file);
       }
        }
        const SendImage = () =>{
            const formData = new FormData();
            formData.append("file",image);

            try{
                axios.post("http://localhost:8080/images/upload/one",formData, {
                    headers: { "Content-Type": "multipart/form-data", "X-XSRF-TOKEN": csrfToken },
                    withCredentials: true
                });
            }catch (error){
                console.log("error uploading",error);
            }

            window.location.href ="/";
        }
    return (
        <div>

            <div className="aboutId">
                {email ? (
                    <>
                        {avatar && <img src={avatar} alt="'" className="avatar"/>}
                        <h1>{name}</h1>
                        <p>{email}</p>
                        <img className="caroselImg" src={images[index]}/>
                        <button className="nextBtn" onClick={nextImage}><ArrowForwardIosIcon/></button>
                        <button className="prevBtn" onClick={prevImage}><ArrowBackIosNewIcon/></button>
                        <button className="backBtnn"
                                onClick={() => (window.location.href = "http://localhost:5173/")}>back
                        </button>
                        <button onClick={deleteImg}>
                            delete
                        </button>
                        {
                        isOverflowed ?
                        <Button disabled>Add</Button>
                        :
                            <Button
                                component="label"
                                role={undefined}
                                variant="contained"
                                tabIndex={-1}

                            >
                                add
                                <VisuallyHiddenInput
                                    type="file"
                                    onChange={uploadFile}
                                    multiple
                                />
                            </Button>
                        }
                        {image && <Button onClick={SendImage}>send</Button>}
                    </>) : (
                    <>
                        <div className="loader"></div>
                    </>
                )}
            </div>
        </div>
    );
}