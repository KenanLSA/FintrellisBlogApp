import { useParams } from "react-router-dom"
import { useFetch } from "../hooks/useFetch";
import type { BlogPost } from "../types/BlogPost";
import { useEffect, useState } from "react";
import DeleteButton from "../components/blogpost/DeleteButton";
import UpdateButton from "../components/blogpost/UpdateButton";

const BlogPostDetail = () => {
    const [post, setPost] = useState<BlogPost>();

    const { id } = useParams();
    const url: string = `http://localhost:8080/api/v1/posts/${id}`
    const {data, error} = useFetch<BlogPost>(url);

    

    useEffect(() => {
        if (error?.response?.status === 404)
            throw new Response()

        if (data)
            setPost(data);
    }, [data, error])
    

    return (
        <div>
            <h1>{ post?.title }</h1>
            <hr />
            <pre>
                { post?.content }
            </pre>
            <DeleteButton id={Number(id)} />
            <UpdateButton id={Number(id)} />
        </div>
    )
}

export default BlogPostDetail