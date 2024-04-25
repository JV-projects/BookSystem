import { BrowserRouter, Route, Routes } from "react-router-dom"
import Login from "./pages/Login"
import Home from "./pages/Home"
import Emprestimo from "./pages/Emprestimo"
import Emprestimos from "./pages/Emprestimos"
import Acessibilidade from "./pages/Acessibilidade"
import Criar from "./pages/Criar"
import Editar from "./pages/Editar"
import './App.css'

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/gerenciamento" element={<Home/>} />
        <Route path="/emprestimos" element={<Emprestimos/>} />
        <Route path="/emprestimo" element={<Emprestimo/>} />
        <Route path="/acessibilidade" element={<Acessibilidade/>} />
        <Route path="/criar" element={<Criar/>} />
        <Route path="/editar" element={<Editar/>} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
