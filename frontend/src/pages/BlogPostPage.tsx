import { useEffect, useState } from "react"
import type { BlogPost } from "../types/BlogPost"
import BlogPostCard from "../components/blogpost/BlogPostCard";
import { useFetch } from "../hooks/useFetch";
import BlogPostList from "../components/blogpostlist/BlogPostList";

const BlogPostPage = () => {

    const [posts, setPosts] = useState<BlogPost[]>();
    const url: string = 'http://localhost:8080/api/v1/posts';

    const { data } = useFetch<BlogPost[]>(url);
 
    useEffect(() => {
        setPosts(data)
    }, [data]);

    const postCards = posts?.map(post => 
        <BlogPostCard { ...post } key={ post.id } />
    );

    return (
        <>
            <h1 style={{ marginBottom: '2rem' }}>All Blog Posts</h1>
            <BlogPostList>
                { postCards }
            </BlogPostList>
        </>
        
    )
}

export default BlogPostPage;
