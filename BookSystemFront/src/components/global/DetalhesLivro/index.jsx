import { Link } from "react-router-dom"
import styles from './styles.module.css'
import Button from '../Button'
import Status from '../Status'
import Assunto from '../Assunto'

export default function DetalhesLivro() {
    return (
        <div className={styles.container}>
            <div className={styles.areaTopo}>
                <div className={styles.areaTexto}>
                    <h1 className={styles.titulo}>Nome do livro</h1>
                    <p className={styles.destaque}>Autor do livro</p>
                </div>
                <div className={styles.areaTexto + " " + styles.alinhamentoDireita}>
                    <Status status={"Disponível"}/>
                    <Link to="/novoemprestimo">
                        <Button tipoBotao={'primario'}>
                            <p>Novo empréstimo</p>
                        </Button>
                    </Link>
                </div>
            </div>
            <span className={styles.linhaHorizontal} />
            <div className={styles.areaAssuntos}>
                <Assunto>Assunto 1</Assunto>
                <Assunto>Assunto 2</Assunto>
            </div>
            <div className={styles.areaConteudo}>
                <h1 className={styles.titulo}>Detalhes</h1>
                <div className={styles.cartao}>
                    <div className={styles.areaConteudoCartao}>
                        <p className={styles.paragrafo}>Nome do dado</p>
                        <p className={styles.paragrafo}>Titulo</p>
                        <p className={styles.paragrafo}>Autor</p>
                        <p className={styles.paragrafo}>Editora</p>
                        <p className={styles.paragrafo}>Etiqueta</p>
                        
                    </div>
                    <span className={styles.linhaVertical} />
                    <div className={styles.areaConteudoCartao + " " + styles.alinhamentoDireita}>
                        <p className={styles.paragrafo}>Dado</p>
                        <p className={styles.paragrafo}>Orgulho e Preconceito</p>
                        <p className={styles.paragrafo}>Jane Austen</p>
                        <p className={styles.paragrafo}>Martin Claret</p>
                        <p className={styles.paragrafo}>A3A73F25</p>
                    </div>
                </div>
            </div>
        </div>
    )
}