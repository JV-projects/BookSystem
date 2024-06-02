import styles from './styles.module.css'
import Button from '../Button'
import useSWR from 'swr'
import fetcher from '../../../util/fetcher'

export default function ExcluirLivro({ id }) {
    const { data, error, isLoading } = useSWR(`/booksystem/api/livros/${id}`, fetcher)

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
            <p className={styles.paragrafo}>Tem certeza de que deseja excluir esse livro?</p>
            <div className={styles.cartao}>
                <h1 className={styles.titulo}>{data.titulo}</h1>
                <p className={styles.destaque}>{data.autor}</p>
            </div>
            <div className={styles.areaBotoes}>
                <Button tipoBotao={'terciarioCancela'}>Cancelar</Button>
                <Button tipoBotao={'terciarioConfirma'}>Confirmar</Button>
            </div>
        </div>
    )
}