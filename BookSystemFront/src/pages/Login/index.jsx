import styles from './styles.module.css'
import Input from '../../components/global/Input'
import Button from '../../components/global/Button'

export default function Login() {
    return (
        <div className={styles.container}>
            <div className={styles.areaConteudo}>
                <h1 className={styles.titulo}>Entrar</h1>
                <form className={styles.formulario}>
                    <label className={styles.rotulo}>
                        E-mail
                        <Input type="text" required/>
                    </label>
                    <label className={styles.rotulo}>
                        Senha
                        <Input type="password" required/>
                    </label>
                    <div>
                        <a className={styles.link} href="">Esqueceu a senha?</a>
                    </div>
                    <Button type="submit">Entrar</Button>
                </form>
            </div>
        </div>
    )
}