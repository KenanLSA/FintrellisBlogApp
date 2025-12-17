import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom"
import { useFetch } from "../../hooks/useFetch";
import type { BlogPost } from "../../types/BlogPost";
import axios from "axios";
import type { PutRequestDto } from "../../types/dto/RequestDto";

const UpdateForm = () => {

    const { id } = useParams();
    const navigate = useNavigate();
    const url = `http://localhost:8080/api/v1/posts/${id}`;
    const [form, setForm] = useState<PutRequestDto>({ title: "", content: ""});
    const {data, error} = useFetch<BlogPost>(url);
    const [isDisabled, setIsDisabled] = useState<boolean>();

    useEffect(() => {
        if (error?.response?.status === 404) {
            throw new Response();
        }
        
        if (data) {
            setForm({ title: data.title, content: data.content});
        }     
    }, [data, error]);

    const onChangeHandler = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        const { name, value } = e.target;
        setForm(prev => (
            { ...prev, [name]: value}
        ))

        setIsDisabled(!form.title.trim() || !form.content.trim());
    }

    const formSubmitHandler = async (e: React.FormEvent) => {
        e.preventDefault();

        const body = JSON.stringify(form);

        await axios.put(url, body, {
            withCredentials: true,
            headers: {
                "Content-Type": 'application/json'
            }
        }).then(_ => navigate(`/${id}`));
    }

    return (
        <form onSubmit={formSubmitHandler}>
            <label htmlFor="title">Title</label>
            <input type="text" required name="title" value={form.title} onChange={onChangeHandler}/>

            <label htmlFor="content">Content</label>
            <textarea name="content" 
                required 
                value={form.content} 
                onChange={onChangeHandler}
                maxLength={500}
                rows={10}/>

            <button type="submit" disabled={isDisabled}>
                Update
            </button>
        </form>
    )
}

export default UpdateForm