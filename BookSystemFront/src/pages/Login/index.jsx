import styles from './styles.module.css'
import Input from '../../components/global/Input'
import Button from '../../components/global/Button'
import Titulo from '../../components/global/Titulo'
import logo from '/assets/images/logo.svg'
import BarraAcessibilidade from '../../components/global/BarraAcessibilidade'
import Footer from '../../components/global/Footer'
import { Link } from "react-router-dom"

export default function Login() {


    return (
        <>
            <BarraAcessibilidade />
            <div className={styles.container}>
                <div className={styles.areaConteudo}>
                    <img className={styles.logo} src={logo} alt="Logo" />
                    <Titulo titulo="Login" />
                    <form className={styles.formulario}>
                        <label className={styles.rotulo}>
                            E-mail
                            <Input type="text" />
                        </label>
                        <label className={styles.rotulo}>
                            Senha
                            <Input type="password" />
                        </label>
                        <Button tipoBotao="primario" type="submit">
                            <Link to="/gerenciamento">Entrar</Link>
                        </Button>
                    </form>
                </div>
            </div>
            <Footer/>
        </>
    )
}