import axios from "axios";

export default async function CSRF() {
    let token =null;
    const csrf_token = async () => {
        try {
            const response = await axios.get("http://localhost:8080/csrf-token", {withCredentials: true});
            token = null;
            token =response.data.token;
        } catch (e) {
            console.log(e)
        }
    }
    await csrf_token();
    return token;
}