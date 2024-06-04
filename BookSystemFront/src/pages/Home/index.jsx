import { useState } from 'react'
import styles from './styles.module.css'
import EstruturaPagina from '../../components/global/EstruturaPagina'
import Select from '../../components/global/Select'
import Input from '../../components/global/Input'
import Button from '../../components/global/Button'
import Status from '../../components/global/Status'
import { Link } from "react-router-dom"
import TopoPagina from '../../components/global/TopoPagina'
import Modal from '../../components/global/Modal'
import DetalhesLivro from '../../components/global/DetalhesLivro'
import ExcluirLivro from '../../components/global/ExcluirLivro'
import Assunto from '../../components/global/Assunto'
import useSWR from 'swr'
import fetcher from '../../util/fetcher'
import apiUrl from '../../util/apiUrl'

export default function Home() {
    const { data, error, isLoading } = useSWR(`${apiUrl}/livros`, fetcher)
    
    const [pesquisa, setPesquisa] = useState("")
    const [indiceSelecionado, setIndiceSelecionado] = useState(null)
    const [modalSelecionado, setModalSelecionado] = useState(null)
    const [sort, setSort] = useState("arrow_upward_alt")
    const [lista, setLista] = useState(data)

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

    const handlePesquisar = () => {
        pesquisa.length ? setLista(
            data.filter(item =>
                item.titulo.toLowerCase().includes(pesquisa.toLowerCase()) ||
                item.autor.toLowerCase().includes(pesquisa.toLowerCase()) ||
                item.editora.toLowerCase().includes(pesquisa.toLowerCase()) ||
                item.ano.toLowerCase().includes(pesquisa.toLowerCase())
            )
        ) : setLista(data)
    }

    const handleSelecionar = (indice) => {
        if (indiceSelecionado === indice) {
            setIndiceSelecionado(null)
        } else {
            setIndiceSelecionado(indice)
        }
    }

    function handleSort() {
        if (sort === "arrow_upward_alt") {
            setSort("arrow_downward_alt")
        } else {
            setSort("arrow_upward_alt")
        }
    }

    return (
        <EstruturaPagina>
            <TopoPagina titulo="Gerenciamento" />
            <div className={styles.barraOpcoes}>
                <div className={styles.containerPesquisa}>
                    <div className={styles.blocoPesquisa + " " + styles.areaPesquisa}>
                        <Input className={styles.barraPesquisa} value={pesquisa} onChange={e => setPesquisa(e.target.value)} placeholder='Pesquisar' />
                        <Button tipoBotao="primario" onClick={handlePesquisar}>
                            <span className="material-symbols-outlined">search</span>
                        </Button>
                    </div>
                    <div className={styles.blocoFiltro}>
                        <div>
                            <label htmlFor='pesquisarPor' className={styles.selectLabel}>Pesquisar por</label>
                            <Select name={"pesquisarPor"} opcoes={pesquisar} />
                        </div>
                        <div>
                            <label htmlFor='filtrarPor' className={styles.selectLabel}>Filtrar por</label>
                            <Select name='filtrarPor' opcoes={ordenar} />
                        </div>
                        <Input className={styles.barraAno} placeholder='Ano' />
                        <Button icone={sort} onClick={() => handleSort()}>
                            <span className='material-symbols-outlined'>sort</span>
                        </Button>
                    </div>
                </div>
                <span className={styles.linha} />
                <div className={styles.containerBotoes}>
                    <Link to="/novoemprestimo">
                        <Button tipoBotao="primario">
                            <p>Novo empréstimo</p>
                        </Button>
                    </Link>
                    <div className={styles.areaBotoes}>
                        <Link to="/criar">
                            <Button icone="add" tipoBotao="primario">
                                <p className={styles.action}>Criar</p>
                            </Button>
                        </Link>
                        <Button tipoBotao="secundario" icone="info" onClick={() => setModalSelecionado('detalhes')} disabled={indiceSelecionado === null}>
                            <p className={styles.action}>Detalhes</p>
                        </Button>
                        <Link to={`/editar/${data && lista[indiceSelecionado].id}`}>
                            <Button tipoBotao="secundario" icone="edit_square" disabled={indiceSelecionado === null}>
                                <p className={styles.action}>Editar</p>
                            </Button>
                        </Link>
                        <Button tipoBotao="secundario" icone="delete" onClick={() => setModalSelecionado('excluir')} disabled={indiceSelecionado === null}>
                            <p className={styles.action}>Excluir</p>
                        </Button>
                    </div>
                </div>
            </div>
            {error ? (
                <div className={styles.areaTextoCentralizado}>
                    <p className={styles.paragrafo}>Ocorreu um erro.</p>
                </div>
            ) : isLoading ? (
                <div className={styles.areaTextoCentralizado}>
                    <p className={styles.paragrafo}>Carregando...</p>
                </div>
            ) : !data ? (
                <div className={styles.areaTextoCentralizado}>
                    <p className={styles.paragrafo}>Nenhum dado encontrado.</p>
                </div>
            ) : (
                <div className={styles.containerCartoes}>
                    {lista.map((item, i) => (
                        <div className={indiceSelecionado == i ? styles.cartaoSelecionado : styles.cartaoNaoSelecionado} onClick={() => handleSelecionar(i)} key={i}>
                            <div className={styles.imagemCartao}>
                                <img alt={`Foto do livro ${item.titulo}`} />
                            </div>
                            <div className={styles.areaConteudoCartao}>
                                <div className={styles.areaTexto}>
                                    <h2 className={styles.tituloSecundario}>{item.titulo}</h2>
                                    <div className={styles.areaBotoes}>
                                        <div className={styles.grupoTexto}>
                                            <p className={styles.paragrafo}>Autor:</p>
                                            <span className={styles.destaque}>{item.autor}</span>
                                            <p className={styles.paragrafo}><span className={styles.linhaHorizontal} /></p>
                                        </div>
                                        <div className={styles.grupoTexto}>
                                            <p className={styles.paragrafo}>Editora:</p>
                                            <span className={styles.destaque}>{item.editora}</span>
                                            <p className={styles.paragrafo}><span className={styles.linhaHorizontal} /></p>
                                        </div>
                                        <div className={styles.grupoTexto}>
                                            <p className={styles.paragrafo}>Ano:</p>
                                            <span className={styles.destaque}>{item.ano}</span>
                                        </div>
                                    </div>
                                </div>
                                <div className={styles.areaBotoes}>
                                    {item.assuntos.map((assunto, i) => (
                                        <Assunto key={i}><p>{assunto.assunto}</p></Assunto>
                                    ))}
                                </div>
                            </div>
                            <Status status={item.status} />
                        </div>
                    ))}
                </div>
            )}
            <Modal aberto={modalSelecionado === 'detalhes'} fechar={() => setModalSelecionado(null)} titulo={'Detalhes do livro'}>
                <DetalhesLivro id={data && lista[indiceSelecionado].id}/>
            </Modal>
            <Modal aberto={modalSelecionado === 'excluir'} fechar={() => setModalSelecionado(null)} titulo={'Excluir livro'}>
                <ExcluirLivro id={data && lista[indiceSelecionado].id} fechar={() => setModalSelecionado(null)}/>
            </Modal>
        </EstruturaPagina>
    )
}
