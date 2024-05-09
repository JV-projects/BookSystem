import styles from './styles.module.css'
import Button from '../Button'

export default function ExcluirLivro() {
    return (
        <div className={styles.container}>
            <p className={styles.paragrafo}>Tem certeza de que deseja excluir esse livro?</p>
            <div className={styles.cartao}>
                <h1 className={styles.titulo}>Nome do livro</h1>
                <p className={styles.destaque}>Autor do livro</p>
            </div>
            <div className={styles.areaBotoes}>
                <Button tipoBotao={'terciarioCancela'}>Cancelar</Button>
                <Button tipoBotao={'terciarioConfirma'}>Confirmar</Button>
            </div>
        </div>
    )
}