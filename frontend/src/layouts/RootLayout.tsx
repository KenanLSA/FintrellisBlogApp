import { Link, Outlet } from "react-router-dom"

const RootLayout = () => {
    return (
        <>
            <header>
                <nav>
                    <Link to='/'>Home</Link>
                    <Link to='/add'>Add New Blog Post</Link>
                </nav>
            </header>
            <Outlet/>
        </>
    )
}

export default RootLayout