import React, {useEffect, useState} from "react";
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Container from '@mui/material/Container';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import Tooltip from '@mui/material/Tooltip';
import MenuItem from '@mui/material/MenuItem';
import AdbIcon from '@mui/icons-material/Adb';
import './mainPage.css';
import axios from "axios";
import Cookies from "universal-cookie";

const pages = ['Products', 'add', 'about us'];
const settings = ['Profile', 'Account', 'Logout'];

export default function MainPage(){
    const [anchorElNav, setAnchorElNav] = React.useState(null);
    const [anchorElUser, setAnchorElUser] = React.useState(null);
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [avatar,setAvatar] = useState("");
    const [allImages,setAllImages] = useState([]);
    const cookies = new Cookies();

    useEffect(() => {
        axios.get("http://localhost:8080/images/all",{withCredentials:true}).then(response =>{
            setAllImages(response.data);
        })
        axios.get("http://localhost:8080/user",{withCredentials:true})
            .then(response => {
                if(response.data!==null) {

                    setIsAuthenticated(true);
                    const encodeAvatar = cookies.get("avatar");
                    const decodeAvatar = atob(encodeAvatar);
                    setAvatar(decodeAvatar);
                }
                else {
                    setIsAuthenticated(false)
                }
            })
            .catch(error => {
                setIsAuthenticated(false);
            });


    }, []);

    const moreAbout = (event) =>{
        const id = event.currentTarget.getAttribute("data-id");
        console.log("Clicked ID:", id);  // Логування для перевірки id
        if (id) {
            window.location.href = `/user/images/${id}`;
        } else {
            console.log("ID is not set or is null");
        }
    }
    const handleOpenNavMenu = (event) => {
        setAnchorElNav(event.currentTarget);
    };
    const handleOpenUserMenu = (event) => {
        if(isAuthenticated) {
            setAnchorElUser(event.currentTarget);
        }
        else {
            window.location.href="http://localhost:5173/auntication";
        }
    };

    const handleCloseNavMenu = (page) => {
        setAnchorElNav(null);
        if(page === "add"){
            window.location.href="http://localhost:5173/upload";
        }
        else if(page === "Products"){
            window.location.href ="http://localhost:5173/products";
        }
        else if(page ==="about us"){
            window.location.href="http://localhost:5173/aboutus";
        }
    };

    const handleCloseUserMenu = (setting) => {
        setAnchorElUser(null);
        if(setting ==="Logout"){
            window.location.href="/logout";
        } else if(setting === "Profile"){
            window.location.href="/user";
        }else if(setting==="Account"){
            window.location.href="/account";
        }
    };

    return(
        <div className="footer">
            <AppBar position="static" >
                <Container maxWidth="xl">
                    <Toolbar disableGutters>
                        <AdbIcon sx={{ display: { xs: 'none', md: 'flex' }, mr: 1 }} />
                        <Typography
                            variant="h6"
                            noWrap
                            component="a"
                            href="#app-bar-with-responsive-menu"
                            sx={{
                                mr: 2,
                                display: { xs: 'none', md: 'flex' },
                                fontFamily: 'monospace',
                                fontWeight: 700,
                                letterSpacing: '.3rem',
                                color: 'inherit',
                                textDecoration: 'none',
                            }}
                        >
                            LOGO
                        </Typography>

                        <Box sx={{ flexGrow: 1, display: { xs: 'flex', md: 'none' } }}>
                            <IconButton
                                size="large"
                                aria-label="account of current user"
                                aria-controls="menu-appbar"
                                aria-haspopup="true"
                                onClick={handleOpenNavMenu}
                                color="inherit"
                            >
                                <MenuIcon />
                            </IconButton>
                            <Menu
                                id="menu-appbar"
                                anchorEl={anchorElNav}
                                anchorOrigin={{
                                    vertical: 'bottom',
                                    horizontal: 'left',
                                }}
                                keepMounted
                                transformOrigin={{
                                    vertical: 'top',
                                    horizontal: 'left',
                                }}
                                open={Boolean(anchorElNav)}
                                onClose={handleCloseNavMenu}
                                sx={{ display: { xs: 'block', md: 'none' } }}
                            >
                                {pages.map((page) => (
                                    <MenuItem key={page} onClick={() => handleCloseNavMenu(page)}>
                                        <Typography sx={{ textAlign: 'center' }}>{page}</Typography>
                                    </MenuItem>
                                ))}
                            </Menu>
                        </Box>
                        <AdbIcon sx={{ display: { xs: 'flex', md: 'none' }, mr: 1 }} />
                        <Typography
                            variant="h5"
                            noWrap
                            component="a"
                            href="#app-bar-with-responsive-menu"
                            sx={{
                                mr: 2,
                                display: { xs: 'flex', md: 'none' },
                                flexGrow: 1,
                                fontFamily: 'monospace',
                                fontWeight: 700,
                                letterSpacing: '.3rem',
                                color: 'inherit',
                                textDecoration: 'none',
                            }}
                        >
                            LOGO
                        </Typography>
                        <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
                            {pages.map((page) => (
                                <Button
                                    key={page}
                                    onClick={() => handleCloseNavMenu(page)}
                                    sx={{ my: 2, color: 'white', display: 'block' }}
                                >
                                    {page}
                                </Button>
                            ))}
                        </Box>
                        <Box sx={{ flexGrow: 0 }}>
                            {isAuthenticated ? (
                            <Tooltip title="Open settings">
                                <IconButton onClick={handleOpenUserMenu} sx={{ p: 0 }}>
                                    <Avatar alt="Remy Sharp" src={avatar} />
                                </IconButton>
                            </Tooltip>
                                ) : (
                                <Tooltip title="Open settings">
                                    <IconButton onClick={handleOpenUserMenu} sx={{ p: 0 }}>
                                        <Avatar alt="Remy Sharp" src="/static/images/avatar/2.jpg" />
                                    </IconButton>
                                </Tooltip>

                            )}
                            <Menu
                                sx={{ mt: '45px' }}
                                id="menu-appbar"
                                anchorEl={anchorElUser}
                                anchorOrigin={{
                                    vertical: 'top',
                                    horizontal: 'right',
                                }}
                                keepMounted
                                transformOrigin={{
                                    vertical: 'top',
                                    horizontal: 'right',
                                }}
                                open={Boolean(anchorElUser)}
                                onClose={handleCloseUserMenu}
                            >
                                {settings.map((setting) => (
                                    <MenuItem key={setting} onClick={() => handleCloseUserMenu(setting)}>
                                        <Typography sx={{ textAlign: 'center' }}>{setting}</Typography>
                                    </MenuItem>
                                ))}
                            </Menu>
                        </Box>
                    </Toolbar>
                </Container>
            </AppBar>
            <div className="equalizer">
                <div className="cardContainer">
                    {allImages.map(image => (
                    <div className="testItem" key={image.id} data-id={image.id} onClick={moreAbout}>
                    <img src={`http://localhost:8080/images/id/${image.id}`}/>
                        <p>Author: {image.name}</p>
                    </div>
                    ))}
                </div>
            </div>
        </div>
    )
}
