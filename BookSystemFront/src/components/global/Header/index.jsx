import { Link } from 'react-router-dom'
import logo from '/assets/images/logo.svg'
import styles from './styles.module.css'

const Header = () => {
    return(
        <header className={styles.header}>
            <img className={styles.logo} src={logo} alt="Logo"/>
            <ul className={styles.ul}>
                <Link className={window.location.pathname == "/gerenciamento" ? styles.selectedPage : styles.page} to="/gerenciamento">Gerenciamento</Link>
                <Link className={window.location.pathname == "/historico" ? styles.selectedPage : styles.page} to="/historico">Empréstimos</Link>
                <span className={styles.bg}/>
            </ul>
            <div>Ícone</div>
        </header>
    )
}

export default Header