import { Link } from "react-router-dom"
import styles from './styles.module.css'
import Button from '../Button'
import Status from '../Status'
import Assunto from '../Assunto'
import useSWR from 'swr'
import fetcher from '../../../util/fetcher'
import apiUrl from '../../../util/apiUrl'

export default function DetalhesLivro({ id }) {
    const { data, error, isLoading } = useSWR(`${apiUrl}/livros/${id}`, fetcher)

    if (error) return (
        <div className={styles.areaTextoCentralizado}>
            <p className={styles.paragrafo}>Ocorreu um erro.</p>
        </div>
    )
    if (isLoading) return (
        <div className={styles.areaTextoCentralizado}>
            <p className={styles.paragrafo}>Carregando...</p>
        </div>
    )

    return (
        <div className={styles.container}>
            <div className={styles.areaTopo}>
                <div className={styles.areaTexto}>
                    <h1 className={styles.titulo}>{data.titulo}</h1>
                    <p className={styles.destaque}>{data.autor}</p>
                </div>
                <div className={styles.areaTexto + " " + styles.alinhamentoDireita}>
                    <Status mensagem={data.status} status={data.status} />
                    <Link to="/novoemprestimo">
                        <Button tipoBotao={'primario'}>
                            <p>Novo empréstimo</p>
                        </Button>
                    </Link>
                </div>
            </div>
            <span className={styles.linhaHorizontal} />
            <div className={styles.areaAssuntos}>
                {data.assuntos.map((assunto, i) => (
                    <Assunto key={i}>
                        <p>{assunto}</p>
                    </Assunto>
                ))}
            </div>
            <div className={styles.areaConteudo}>
                <h1 className={styles.titulo}>Detalhes</h1>
                <div className={styles.cartao}>
                    <div className={styles.areaConteudoCartao}>
                        <p className={styles.paragrafo}>ISBN</p>
                        <p className={styles.paragrafo}>Etiqueta</p>
                        <p className={styles.paragrafo}>Nº Patrimônio</p>
                        <p className={styles.paragrafo}>Editora</p>
                        <p className={styles.paragrafo}>Ano</p>
                        <p className={styles.paragrafo}>Edição</p>
                        <p className={styles.paragrafo}>Número de páginas</p>
                    </div>
                    <span className={styles.linhaVertical} />
                    <div className={styles.areaConteudoCartao + " " + styles.alinhamentoDireita}>
                        <p className={styles.paragrafo}>{data.isbn}</p>
                        <p className={styles.paragrafo}>{data.etiqueta}</p>
                        <p className={styles.paragrafo}>{data.nPatrimonio}</p>
                        <p className={styles.paragrafo}>{data.editora}</p>
                        <p className={styles.paragrafo}>{data.ano}</p>
                        <p className={styles.paragrafo}>{data.edicao}</p>
                        <p className={styles.paragrafo}>{data.nPaginas}</p>
                    </div>
                </div>
            </div>
        </div>
    )
}