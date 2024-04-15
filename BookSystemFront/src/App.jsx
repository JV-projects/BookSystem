import { BrowserRouter, Route, Routes } from "react-router-dom"
import Login from "./pages/Login"
import Gerenciamento from "./pages/Gerenciamento"
import Emprestimo from "./pages/Emprestimo"
import Historico from "./pages/Historico"
import Acessibilidade from "./pages/Acessibilidade"
import Criar from "./pages/Criar"
import Editar from "./pages/Editar"
import './App.css'

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/gerenciamento" element={<Gerenciamento/>} />
        <Route path="/historico" element={<Historico/>} />
        <Route path="/emprestimo" element={<Emprestimo/>} />
        <Route path="/acessibilidade" element={<Acessibilidade/>} />
        <Route path="/criar" element={<Criar/>} />
        <Route path="/editar" element={<Editar/>} />
        
      </Routes>
    </BrowserRouter>
  )
}

export default App
