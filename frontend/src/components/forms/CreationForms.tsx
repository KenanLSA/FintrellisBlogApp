import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import type { PostRequestDto } from "../../types/dto/RequestDto";

const CreationForms = () => {
    const [form, setForm] = useState<PostRequestDto>({ title: "", content: "" })

    const url: string = "http://localhost:8080/api/v1/posts";
    const navigate = useNavigate();

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        const { name, value } = e.target;
        setForm(prev => (
            {
                ...prev, [name]: value
            }
        ))
    }

    const handleSubmit = async (e: React.FormEvent) => {

        e.preventDefault();
        const body = JSON.stringify(form);

        await axios.post(
            url, 
            body, 
            {
                withCredentials: true,
                headers: {
                    "Content-Type": 'application/json'
                }
            })
            .then(_ => navigate('/')); // redirect to blog post list after creation
    };

    return (
        <form onSubmit={handleSubmit}>
            <div className="form-group">
                <label htmlFor="title">Title</label>
                <input type="text" required name="title" value={form.title} onChange={handleChange}/>
            </div>
            
            <div className="form-group">
                <label htmlFor="title">Content</label> 
                <textarea name="content" 
                    required 
                    value={form.content} 
                    onChange={handleChange} 
                    maxLength={500} 
                    rows={10}/>
            </div>
            
            <input type="submit" value="Create" />
        </form>
    )
}

export default CreationForms