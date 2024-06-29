import Layout from "../layout/Layout";
import { useEffect, useState } from "react";
import { getBlogById } from "../apiRequest/APIRequest";
import Loader from "../components/Loader";
import BlogDetails from "../components/BlogDetail";
import { useParams } from "react-router-dom";

const DetailsPage = () => {
  let { id } = useParams();

  const [blog, setBlog] = useState(null);

  useEffect(() => {
    (async () => {
      let res = await getBlogById(id);
      setBlog(res);
    })();
  }, id);

  return (
    <Layout>
      {blog == null ? <Loader/> : <BlogDetails blog={blog}/>}
    </Layout>
  );
};

export default DetailsPage;
