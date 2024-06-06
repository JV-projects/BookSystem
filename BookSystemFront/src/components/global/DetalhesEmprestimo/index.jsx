import styles from './styles.module.css'
import Button from '../Button'

export default function DetalhesLivro({ data }) {
    return (
        <div className={styles.container}>
            <div className={styles.bloco}>
                <p className={styles.paragrafo}>Usuário</p>
            </div>
            <div className={styles.areaTexto}>
                <p className={styles.paragrafo}>{data.usuario.nome}</p>
                <div className={styles.areaDados}>
                    <p className={styles.paragrafo}>
                        <span className="material-symbols-outlined">mail</span>
                        {data.usuario.email}
                    </p>
                    <p className={styles.paragrafo}>
                        <span className="material-symbols-outlined">call</span>
                        {data.usuario.telefones[0]}
                    </p>
                </div>
            </div>
            <div className={styles.bloco}>
                <p className={styles.paragrafo}>Itens</p>
                <p className={styles.paragrafo}>0 itens</p>
            </div>
            <ul className={styles.lista}>
                {data.itensEmprestimo.map((livro, i) => (
                    <li className={styles.cartao} key={i}>
                        <h1 className={styles.titulo}>{livro.titulo}</h1>
                        <p className={styles.destaque}>{livro.autor}</p>
                    </li>
                ))}
            </ul>
            <div className={styles.bloco}>
                <div className={styles.areaTexto}>
                    <h1 className={styles.titulo}>Data de retirada</h1>
                    <p className={styles.paragrafo}>{data.dataRetirada}</p>
                </div>
                <span className={styles.linhaVertical} />
                <div className={styles.areaTexto + " " + styles.alinhamentoDireita}>
                    <h1 className={styles.titulo}>Data de devolução</h1>
                    <p className={styles.paragrafo}>{data.dataDevolucao}</p>
                </div>
            </div>
            <Button tipoBotao={'terciarioConfirma'}>Renovar</Button>
            <Button tipoBotao={'terciarioCancela'}>Encerrar</Button>
        </div>
    )
}