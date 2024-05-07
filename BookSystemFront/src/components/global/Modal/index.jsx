import styles from './styles.module.css'

const Modal = ({ aberto, fechar, titulo, conteudo }) => {
    if (!aberto) return null

    return (
        <div className={styles.container}>
            <div className={styles.backdrop} onClick={fechar}></div>
            <div className={styles.areaConteudo}>
                <div className={styles.areaTopo}>
                    <h1 className={styles.titulo}>{titulo}</h1>
                    <button className={styles.botao} title="Fechar" onClick={fechar}>
                        <span class="material-symbols-outlined">close</span>
                    </button>
                </div>
                {conteudo}
            </div>
        </div>
    )
}

export default Modal
