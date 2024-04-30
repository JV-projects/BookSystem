import { useState } from 'react'
import styles from './styles.module.css'
import EstruturaPagina from '../../components/global/EstruturaPagina'
import Select from '../../components/global/Select'
import Input from '../../components/global/Input'
import Button from '../../components/global/Button'
import Status from '../../components/global/Status'

export default function Home() {
    const [pesquisa, setPesquisa] = useState("")
    const [selecionado, setSelecionado] = useState(false)
    const [indiceSelecionado, setIndiceSelecionado] = useState()

    const dados = [
        {
            titulo: "Orgulho e Preconceito",
            autor: "Jane Austen",
            editora: "Martin Claret",
            ano: "2012",
            assuntos: ["Literatura estrangeira", "Romance"],
            disponivel: "Disponível",
            codStatus : 0
        },
        {
            titulo: "Java®: Como Programar",
            autor: "Paul Deitel",
            editora: "Pearson Universidades",
            ano: "2016",
            assuntos: ["Programação"],
            disponivel: "Indisponível",
            codStatus : 2
        }
    ]

    const [lista, setLista] = useState(dados)

    const handlePesquisar = () => {
        pesquisa.length ? setLista(
            dados.filter(item =>
                item.titulo.toLowerCase().includes(pesquisa.toLowerCase()) ||
                item.autor.toLowerCase().includes(pesquisa.toLowerCase()) ||
                item.editora.toLowerCase().includes(pesquisa.toLowerCase()) ||
                item.ano.toLowerCase().includes(pesquisa.toLowerCase())
            )
        ) : setLista(dados)
    }

    const handleSelecionar = (indice) => {
        if (indiceSelecionado == indice) {
            setSelecionado(!selecionado)
        }
        setIndiceSelecionado(indice)
    }

    let pesquisar = [
        { valor: "titulo", texto: "Título" },
        { valor: "isbn", texto: "ISBN" },
        { valor: "autor", texto: "Autor" },
        { valor: "editora", texto: "Editora" },
        { valor: "assunto", texto: "Assunto" }
    ]

    let ordenar = [
        { valor: "titulo", texto: "Título" },
        { valor: "autor", texto: "Autor" },
        { valor: "editora", texto: "Editora" }
    ]

    return (
        <EstruturaPagina>
            <div className={styles.container}>
                <h1 className={styles.tituloPrimario}>Gerenciamento</h1>
                <div className={styles.areaConteudo}>
                    <div className={styles.barraOpcoes}>
                        <div className={styles.containerBotoes}>
                            <div className={styles.areaBotoes + " " + styles.areaPesquisa}>
                                <Input className={styles.barraPesquisa} value={pesquisa} onChange={(e) => setPesquisa(e.target.value)} placeholder='Pesquisar'/>
                                 <Button tipoBotao="primario" onClick={handlePesquisar}>
                                    <span className="material-symbols-outlined">search</span>
                                </Button>
                            </div>
                            <div className={styles.areaBotoes}>
                                <Select selected="Pesquisar por" opcoes={pesquisar}/>
                                <Select selected="Ordenar por" opcoes={ordenar}/>
                                <Input placeholder='Ano'/>
                            </div>
                        </div>
                        <span className={styles.linha}/>
                        <div className={styles.containerBotoes}>
                            <Button tipoBotao="primario">
                                <a href="/novoemprestimo">
                                    Novo empréstimo
                                </a>
                            </Button>
                            <div className={styles.areaBotoes}>
                                <Button icone="add" tipoBotao="primario">
                                    Criar
                                </Button>
                                <Button tipoBotao="secundario" icone="info" disabled={!selecionado}>
                                    Detalhes
                                </Button>
                                <Button tipoBotao="secundario" icone="edit_square" disabled={!selecionado}>
                                    Editar
                                </Button>
                                <Button tipoBotao="secundario" icone="delete" disabled={!selecionado}>
                                    Excluir
                                </Button>
                                </div>
                            </div>
                    </div>
                    <div className={styles.containerCartoes}>
                        {lista.map((item, i) => (
                            <div className={selecionado && indiceSelecionado == i ? styles.cartaoSelecionado : styles.cartaoNaoSelecionado} onClick={() => handleSelecionar(i)} key={i}>
                                <div>
                                    <img className={styles.imagemCartao} src="" alt="Foto da capa do livro" />
                                </div>
                                <div className={styles.areaConteudoCartao}>
                                    <div className={styles.areaTexto}>
                                        <h2 className={styles.tituloSecundario}>{item.titulo}</h2>
                                        <div className={styles.areaBotoes}>
                                            <p className={styles.paragrafo}>Autor:</p>
                                            <span className={styles.destaque}>{item.autor}</span>
                                            <p className={styles.paragrafo}><span className={styles.linhaHorizontal}/></p>
                                            <p className={styles.paragrafo}>Editora:</p>
                                            <span className={styles.destaque}>{item.editora}</span>
                                            <p className={styles.paragrafo}><span className={styles.linhaHorizontal}/></p>
                                            <p className={styles.paragrafo}>Ano:</p>
                                            <span className={styles.destaque}>{item.ano}</span>
                                        </div>
                                    </div>
                                    <div className={styles.areaBotoes}>
                                        {item.assuntos.map((assunto, i) => (
                                            <div className={styles.assunto} key={i}>
                                                {assunto}
                                            </div>
                                        ))}
                                    </div>
                                </div>
                                <Status mensagem={item.disponivel} status={item.codStatus}/>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </EstruturaPagina>
    )
}