import type React from "react"
import styles from './styles.module.scss'

const BlogPostList = ({ children }: { children: React.ReactNode}) => {
    return (
        <div className={styles.list}>
            { children }
        </div>
    )
}

export default BlogPostList