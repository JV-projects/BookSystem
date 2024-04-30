import styles from './styles.module.css'
import Input from '../../components/global/Input'
import Button from '../../components/global/Button'
import { Link } from "react-router-dom"


export default function Login() {
    return (
        <div className={styles.container}>
            <div className={styles.areaConteudo}>
                <h1 className={styles.titulo}>Entrar</h1>
                <form className={styles.formulario}>
                    <label className={styles.rotulo}>
                        E-mail
                        <Input type="text" />
                    </label>
                    <label className={styles.rotulo}>
                        Senha
                        <Input type="password" />
                    </label>
                    <div>
                        <a className={styles.link} href="">Esqueceu a senha?</a>
                    </div>
                    <Button tipoBotao="primario" type="submit">
                        <Link to="/gerenciamento">Login</Link>
                    </Button>
                </form>
            </div>
        </div>
    )
}