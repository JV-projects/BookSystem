import { Link } from 'react-router-dom'
import logo from '/assets/images/logo.svg'
import styles from './styles.module.css'
import Button from '../Button'
import perfil from '/assets/images/perfil.svg'

export default function Header() {

    function dropdown() {
        const drop = document.getElementById("dropdownPerfil")
        const display = drop.style.display

        if (display === "flex") {
            drop.style.display = "none"
        } else {
            drop.style.display = "flex"
        }
    }

    return (
        <>
            <header className={styles.header}>
                <img className={styles.logo} src={logo} alt="Logo" />
                <ul className={styles.ul}>
                    <Link className={window.location.pathname == "/gerenciamento" ? styles.selectedPage : styles.page} to="/gerenciamento">Gerenciamento</Link>
                    <Link className={window.location.pathname == "/emprestimos" ? styles.selectedPage : styles.page} to="/emprestimos">Empréstimos</Link>
                    <span className={styles.bg} />
                </ul>
                <button className={styles.perfil} onClick={dropdown}>
                    <img src={perfil} alt="Ícone de acesso ao perfil" />
                </button>

            </header>

            {/* Header Responsivo */}

            <header className={styles.headerResponsivo}>
                <div className={styles.headerTop}>
                    <img className={styles.logo} src={logo} alt="Logo" />
                    <button className={styles.perfil} onClick={dropdown}>
                        <img src={perfil} alt="Ícone de acesso ao perfil" />
                    </button>

                </div>
                <div className={styles.headerBottom}>
                    <ul className={styles.ul}>
                        <Link className={window.location.pathname == "/gerenciamento" ? styles.selectedPage : styles.page} to="/gerenciamento">Gerenciamento</Link>
                        <Link className={window.location.pathname == "/emprestimos" ? styles.selectedPage : styles.page} to="/emprestimos">Empréstimos</Link>
                        <span className={styles.bg} />
                    </ul>
                </div>
            </header>
            <ul className={styles.dropdownPerfil} id='dropdownPerfil'>
                <li>
                    <Link to={"/"}>
                        <span className="material-symbols-outlined">logout</span>
                        <p>Sair</p>
                    </Link>
                </li>
            </ul>
        </>
    )
}