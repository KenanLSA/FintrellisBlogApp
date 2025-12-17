import './App.scss'

import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import RootLayout from './layouts/RootLayout';
import NotFound from './pages/NotFound';
import BlogPostPage from './pages/BlogPostPage';
import BlogPostDetail from './pages/BlogPostDetail';
import AddBlogPost from './pages/AddBlogPost';
import UpdateBlogPostPage from './pages/UpdateBlogPostPage';

const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout/>,
    children: [
      { 
        index: true,
        element: <BlogPostPage/>
      },
      {
        path: '/:id',
        element: <BlogPostDetail/>,
        errorElement: <NotFound/>
      },
      {
        path: '/add',
        element: <AddBlogPost/>
      },
      {
        path: ':id/update',
        element: <UpdateBlogPostPage/>,
        errorElement: <NotFound/>
      }
    ]
  },
  {
    path: '*',
    element: <NotFound />
  }
]);

function App() {
  return <RouterProvider router={router} />
}

export default App
