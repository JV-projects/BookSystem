import styles from "./styles.module.css"

const BarraAcessibilidade = () => {
    return (
        <div className={styles.container}>
            <ul className={styles.lista}>
                <li><a className={styles.link} href="#conteudo" accessKey="1" title="ir para o conteúdo">Ir para o conteúdo [1]</a></li>
                <li><a className={styles.link} href="#menu" accessKey="2" title="ir para o menu">Ir para o menu [2]</a></li>
                <li><a className={styles.link} href="#rodape" accessKey="3" title="ir para o rodapé">Ir para o rodapé [3]</a></li>
            </ul>
            <ul className={styles.lista}>
                <li><a className={styles.link} href={"/acessibilidade"}>Acessibilidade</a></li>
                <li><button className={styles.botao}>Contraste</button></li>
                <li><button className={styles.botao}>Sem contraste</button></li>
                <li><button className={styles.botao}>A+</button></li>
                <li><button className={styles.botao}>A-</button></li>
            </ul>
        </div>
    )
}

export default BarraAcessibilidade