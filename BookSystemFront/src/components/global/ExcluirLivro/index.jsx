import { useState } from 'react'
import styles from './styles.module.css'
import Button from '../Button'
import useSWR from 'swr'
import fetcher from '../../../util/fetcher'
import apiUrl from '../../../util/apiUrl'

export default function ExcluirLivro({ id, fechar }) {
    const { data, error, isLoading } = useSWR(`${apiUrl}/livros/${id}`, fetcher)

    const [errorMessage, setErrorMessage] = useState("")

    const handleExcluir = async () => {
        try {
            const response = await fetch(`${apiUrl}/livros/${id}`, {
                method: "DELETE"
            })
            if (!response.ok) {
                throw new Error("Erro ao excluir o livro.")
            }
        } catch (error) {
            setErrorMessage("Erro ao excluir o livro. Verifique os dados informados.")
        }
    }

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
                <Button tipoBotao={'terciarioCancela'} onClick={fechar}>Cancelar</Button>
                <Button tipoBotao={'terciarioConfirma'} onClick={handleExcluir}>Confirmar</Button>
            </div>
        </div>
    )
}