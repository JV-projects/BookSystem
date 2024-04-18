import styles from './styles.module.css'

const Login = () => {
    return (
        <div className={styles.container}>
            <div className={styles.contentArea}>
                <h1 className={styles.title}>Entrar</h1>
                <form className={styles.form}>
                    <label className={styles.label}>
                        E-mail
                        <input className={styles.input} type="text" required/>
                    </label>
                    <label className={styles.label}>
                        Senha
                        <input className={styles.input} type="password" required/>
                    </label>
                    <div>
                        <a className={styles.link} href="">Esqueceu a senha?</a>
                    </div>
                    <button className={styles.primaryButton} type="submit">Entrar</button>
                </form>
            </div>
        </div>
    )
}

export default Login