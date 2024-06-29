import { useEffect, useState } from "react";
import BlogList from "../components/BlogList";
import Layout from "../layout/Layout";
import { getAllBlogList } from "../apiRequest/APIRequest";
import Loader from "../components/Loader";

const HomePage = () => {

  const [blogList, setBlogList] = useState(null);

  useEffect(() => {
    (async() => {
      let res = await getAllBlogList();
      setBlogList(res);
    })()
  }, [])

  return (
    <Layout>
      {
        blogList === null ? <Loader/> : <BlogList list={blogList}/>
      }
    </Layout>
  );
};

export default HomePage;
