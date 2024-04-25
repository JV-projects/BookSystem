import { useState } from 'react'
import styles from './styles.module.css'
import EstruturaPagina from '../../components/global/EstruturaPagina'
import Select from '../../components/global/Select'
import Input from '../../components/global/Input'
import Button from '../../components/global/Button'

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
            disponivel: false
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
        {valor: "titulo", texto: "Título"},
        {valor: "isbn", texto: "ISBN"},
        {valor: "autor", texto: "Autor"},
        {valor: "editora", texto: "Editora"},
        {valor: "assunto", texto: "Assunto"}
    ]

    let ordenar = [
        {valor: "titulo", texto: "Título"},
        {valor: "autor", texto: "Autor"},
        {valor: "editora", texto: "Editora"}
    ]

    return(
        <EstruturaPagina>
            <div className={styles.container}>
                <h1 className={styles.tituloPrimario}>Gerenciamento</h1>
                <div className={styles.areaConteudo}>
                    <div className={styles.containerBotoes}>
                        <div className={styles.areaBotoes}>
                            <Input value={pesquisa} onChange={(e) => setPesquisa(e.target.value)} placeholder='Pesquisar'/>
                            <Button onClick={handlePesquisar}>
                                <span className="material-symbols-outlined">search</span>
                            </Button>
                        </div>
                        <div className={styles.areaBotoes}>
                            <Select selected="Pesquisar por" opcoes={pesquisar}/>
                            <Select selected="Ordenar por" opcoes={ordenar}/>
                        </div>
                    </div>
                    <span className={styles.linha}/>
                    <div className={styles.containerBotoes}>
                        <Button>
                            Fazer empréstimo
                        </Button>
                        <div className={styles.areaBotoes}>
                            <Button>
                                <span className="material-symbols-outlined">add</span>
                                Criar
                            </Button>
                            <Button isPrimario={false} disabled={!selecionado}>
                                <span className="material-symbols-outlined">edit_square</span>
                                Editar
                            </Button>
                            <Button isPrimario={false} disabled={!selecionado}>
                                <span className="material-symbols-outlined">delete</span>
                                Excluir
                            </Button>
                            <Button isPrimario={false} disabled={!selecionado}>
                                <span className="material-symbols-outlined">info</span>
                                Ver detalhes
                            </Button>
                        </div>
                    </div>
                    <div className={styles.containerCartoes}>
                        {lista.map((item, i) => (
                            <div className={selecionado && indiceSelecionado == i ? styles.cartaoSelecionado : styles.cartaoNaoSelecionado} onClick={() => handleSelecionar(i)} key={i}>
                                <div>
                                    <img className={styles.imagemCartao} src=""/>
                                </div>
                                <div className={styles.areaConteudoCartao}>
                                    <div className={styles.areaTexto}>
                                        <h2 className={styles.tituloSecundario}>{item.titulo}</h2>
                                        <div className={styles.areaBotoes}>
                                            <p className={styles.paragrafo}>Autor: {item.autor}</p>
                                            <p className={styles.paragrafo}>&bull;</p>
                                            <p className={styles.paragrafo}>Editora: {item.editora}</p>
                                            <p className={styles.paragrafo}>&bull;</p>
                                            <p className={styles.paragrafo}>Ano: {item.ano}</p>
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
                                <div>
                                    {item.disponivel ? 
                                        <div className={styles.statusDisponivel}>Disponível</div>
                                        :
                                        <div className={styles.statusIndisponivel}>Indisponível</div>
                                    }  
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </EstruturaPagina>
    )
}