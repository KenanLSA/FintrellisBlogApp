import { useNavigate } from 'react-router-dom';

import type { BlogPost } from '../../types/BlogPost';
import styles from './BlogPostCard.module.scss';

const BlogPostCard = ({ id, title, content } : BlogPost) => {

    const navigate = useNavigate();

    const navigationToPostId = () => {
        return navigate(`/${id}`);
    }

    return (
        <div onClick={() => navigationToPostId()} className={styles.card}>
            <h2>{ title }</h2>
            <br />
            <p>{ content }</p>
        </div>
    )
}

export default BlogPostCard