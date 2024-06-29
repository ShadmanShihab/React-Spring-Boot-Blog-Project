import axios from "axios";

const BaseURL = 'http://localhost:8084/api';

export async function getCategories() {
    let res = await axios.get(BaseURL + '/categories');
    return res.status === 200 ? res.data : [];
}

export async function getAllBlogList() {
    let res = await axios.get(BaseURL + '/blogposts');
    return res.status === 200 ? res.data : [];
}

export async function getAllBlogListByCategoryId(id) {
    let res = await axios.get(BaseURL + '/blogposts/categories/' + id);
    return res.status === 200 ? res.data : [];
}

export async function getBlogById(id) {
    debugger;
    let res = await axios.get(BaseURL + '/blogposts/' + id);
    debugger;
    return res.status === 200 ? res.data : [];
}