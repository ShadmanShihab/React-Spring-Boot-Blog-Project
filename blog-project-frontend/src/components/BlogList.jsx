import { Link } from "react-router-dom";

const BlogList = (props) => {
  return (
    <div className="container mx-auto my-16 p-9">
      <div className="grid grid-cols-1 mt-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
        {props.list.map((blog, index) => {
          return (
            <Link 
                key={index.toString()} 
                to={"/details/" + blog.id} 
            className="card w-100 glass">
              <figure>
                <img
                  src={blog.image}
                  alt="Shoes"
                />
              </figure>
              <div className="card-body">
                <h2 className="card-title">{blog.title}</h2>
                <p>{blog.content}</p>
                <div className="card-actions justify-end">
                    <p>{blog.author}</p>
                </div>
              </div>
            </Link>
          );
        })}
      </div>
    </div>
  );
};

export default BlogList;
