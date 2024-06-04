import styles from './styles.module.css'
import Button from '../Button'
import useSWR from 'swr'
import fetcher from '../../../util/fetcher'
import apiUrl from '../../../util/apiUrl'

export default function DetalhesLivro({ id }) {
    const { emprestimo, error, isLoading } = useSWR(`${apiUrl}/emprestimos/${id}`, fetcher)
    const { usuario, userError, userIsLoading } = useSWR(`${apiUrl}/usuarios/${id}`, fetcher)

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
            <div className={styles.bloco}>
                <p className={styles.paragrafo}>Usuário</p>
            </div>
            <div className={styles.areaTexto}>
                {userError ? (
                    <p className={styles.paragrafo}>Ocorreu um erro ao buscar os dados do usuário.</p>
                ) : userIsLoading ? (
                    <p className={styles.paragrafo}>Carregando...</p>
                ) : (
                    <>
                        <p className={styles.paragrafo}>{usuario.nome}</p>
                        <div className={styles.areaDados}>
                            <p className={styles.paragrafo}>
                                <span className="material-symbols-outlined">mail</span>
                                {usuario.email}
                            </p>
                            <p className={styles.paragrafo}>
                                <span className="material-symbols-outlined">call</span>
                                {usuario.telefone}
                            </p>
                        </div>
                    </>
                )}
            </div>
            <div className={styles.bloco}>
                <p className={styles.paragrafo}>Itens</p>
                <p className={styles.paragrafo}>0 itens</p>
            </div>
            <ul className={styles.lista}>
                {emprestimo.itensEmprestimo.map((livro, i) => (
                    <li className={styles.cartao} key={i}>
                        <h1 className={styles.titulo}>{livro.titulo}</h1>
                        <p className={styles.destaque}>{livro.autor}</p>
                    </li>
                ))}
            </ul>
            <div className={styles.bloco}>
                <div className={styles.areaTexto}>
                    <h1 className={styles.titulo}>Data de retirada</h1>
                    <p className={styles.paragrafo}>{emprestimo.dataRetirada}</p>
                </div>
                <span className={styles.linhaVertical} />
                <div className={styles.areaTexto + " " + styles.alinhamentoDireita}>
                    <h1 className={styles.titulo}>Data de devolução</h1>
                    <p className={styles.paragrafo}>{emprestimo.dataDevolucao}</p>
                </div>
            </div>
            <Button tipoBotao={'terciarioConfirma'}>Renovar</Button>
            <Button tipoBotao={'terciarioCancela'}>Encerrar</Button>
        </div>
    )
}