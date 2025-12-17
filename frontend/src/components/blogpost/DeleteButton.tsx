import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const DeleteButton = ({ id }: { id: number }) => {

    const navigate =  useNavigate();

    const deleteHandler = async () => {
        const url: string = `http://localhost:8080/api/v1/posts/${id}`;

        await axios.delete(url, {
            withCredentials: true
        }).then(_ => navigate('/'))
    }

    return (
        <button type="button" onClick={deleteHandler}>
            Delete
        </button>
    )
}

export default DeleteButton