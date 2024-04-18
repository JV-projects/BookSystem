import { Link } from 'react-router-dom'
import logo from '/assets/images/logo.svg'
import styles from './styles.module.css'

const Header = () => {
    return(
        <header className={styles.header}>
            <img className={styles.logo} src={logo} alt="Logo"/>
            <ul className={styles.ul}>
                <Link to="/gerenciamento">Gerenciamento</Link>
                <Link to="/historico">Empréstimos</Link>
                <span className={styles.bg}/>
            </ul>
            <div>Ícone</div>
        </header>
    )
}

export default Header