import styles from './styles.module.css'
import Button from '../Button'

export default function DetalhesLivro() {
    const dados = [
        {
            titulo: "Orgulho e Preconceito",
            autor: "Jane Austen"
        },
        {
            titulo: "Java®: Como Programar",
            autor: "Paul Deitel"
        }
    ]

    return (
        <div className={styles.container}>
            <div className={styles.bloco}>
                <p className={styles.paragrafo}>Usuário</p>
            </div>
            <div className={styles.areaTexto}>
                <p className={styles.paragrafo}>Nome</p>
                <div className={styles.areaDados}>
                    <p className={styles.paragrafo}>
                        <span className="material-symbols-outlined">mail</span>
                        Endereço de e-mail
                    </p>
                    <p className={styles.paragrafo}>
                        <span className="material-symbols-outlined">call</span>
                        Número de telefone
                    </p>
                </div>
            </div>
            <div className={styles.bloco}>
                <p className={styles.paragrafo}>Itens</p>
                <p className={styles.paragrafo}>0 itens</p>
            </div>
            <ul className={styles.lista}>
                {dados.map((livro, i) => (
                    <li className={styles.cartao} key={i}>
                        <h1 className={styles.titulo}>{livro.titulo}</h1>
                        <p className={styles.destaque}>{livro.autor}</p>
                    </li>
                ))}
            </ul>
            <div className={styles.bloco}>
                <div className={styles.areaTexto}>
                    <h1 className={styles.titulo}>Data de retirada</h1>
                    <p className={styles.paragrafo}>00/00/0000</p>
                </div>
                <span className={styles.linhaVertical} />
                <div className={styles.areaTexto + " " + styles.alinhamentoDireita}>
                    <h1 className={styles.titulo}>Data de devolução</h1>
                    <p className={styles.paragrafo}>00/00/0000</p>
                </div>
            </div>
            <Button tipoBotao={'terciarioConfirma'}>Renovar</Button>
            <Button tipoBotao={'terciarioCancela'}>Encerrar</Button>
        </div>
    )
}