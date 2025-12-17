import { useNavigate } from "react-router-dom"

const UpdateButton = ({ id }: { id: number }) => {

    const navigate = useNavigate();

    const redirectHandler = () => {
        navigate(`/${id}/update`);
    }

    return (
        <button onClick={() => redirectHandler() }>
            Update
        </button>
    )
}

export default UpdateButton