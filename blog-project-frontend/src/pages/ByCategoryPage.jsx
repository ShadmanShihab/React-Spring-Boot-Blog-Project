import { useEffect, useState } from "react";
import Layout from "../layout/Layout";
import { useParams } from "react-router-dom";
import { getAllBlogListByCategoryId } from "../apiRequest/APIRequest";
import BlogList from "../components/BlogList";
import Loader from "../components/Loader";

const ByCategoryPage = () => {
    let {id} = useParams();
    const [blogList, setBlogList] = useState(null);

  useEffect(() => {
    (async() => {
      let res = await getAllBlogListByCategoryId(id);
      setBlogList(res);
    })()
  }, id)

  return (
    <Layout>
      {
        blogList === null ? <Loader/> : <BlogList list={blogList}/>
      }
    </Layout>
  );
}
 
export default ByCategoryPage;