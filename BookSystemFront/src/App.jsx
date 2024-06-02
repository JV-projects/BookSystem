import { BrowserRouter, Route, Routes } from "react-router-dom"
import Login from "./pages/Login"
import Home from "./pages/Home"
import NovoEmprestimo from "./pages/NovoEmprestimo"
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
        <Route path="/novoemprestimo" element={<NovoEmprestimo/>} />
        <Route path="/acessibilidade" element={<Acessibilidade/>} />
        <Route path="/criar" element={<Criar/>} />
        <Route path="/editar/:id" element={<Editar/>} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
