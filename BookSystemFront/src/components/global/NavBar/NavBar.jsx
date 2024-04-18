import { Link } from "react-router-dom"
import logo from "/assets/images/logo.svg"
import estilo from './NavBar.module.css'

function NavBar(){
    return(
        <nav className={estilo.navbar}>
            <div className={estilo.nav_content}>

                <div className={estilo.logo}>
                    <img src={logo} alt="Logo do sistema BookSystem" />
                </div>
                <ul className={estilo.ul}>
                    <Link to="/gerenciamento">Gerenciamento</Link>
                    <Link to="/historico">Empréstimos</Link>
                    <div className={estilo.bg}></div>
                </ul>
                <div className="conta">icone</div>
            </div>
        </nav>
    )
}

export default NavBar