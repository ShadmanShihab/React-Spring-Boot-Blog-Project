import { BrowserRouter, Routes, Route } from 'react-router-dom'
import './App.css'
import HomePage from './pages/HomePage'
import DetailsPage from './pages/DetailsPage';
import ByCategoryPage from './pages/ByCategoryPage';

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<HomePage/>}/>
        <Route path='/byCategory/:id' element={<ByCategoryPage/>}/>
        <Route path='/details/:id' element={<DetailsPage/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
