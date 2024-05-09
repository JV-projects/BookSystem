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

export default function Home() {
    const [pesquisa, setPesquisa] = useState("")
    const [indiceSelecionado, setIndiceSelecionado] = useState(null)
    const [modalSelecionado, setModalSelecionado] = useState(null)


    const dados = [
        {
           "id":1,
           "titulo":"Orgulho e Preconceito",
           "autor":"Jane Austen",
           "editora":"Martin Claret",
           "ano":"2012",
           "assuntos":[
              {
                 "id":1,
                 "assunto":"Literatura estrangeira"
              },
              {
                 "id":2,
                 "assunto":"Romance"
              }
           ],
           "disponivel":"Disponível",
           "codStatus":0
        },
        {
           "id":2,
           "titulo":"Java®: Como Programar",
           "autor":"Paul Deitel",
           "editora":"Pearson Universidades",
           "ano":"2016",
           "assuntos":[
              {
                 "id":3,
                 "assunto":"Programação"
              }
           ],
           "disponivel":"Indisponível",
           "codStatus":2
        }
     ]

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
            setIndiceSelecionado(null)
        } else {
            setIndiceSelecionado(indice)
        }
    }


    const abrirModal = (acao) => {
        setModalSelecionado(acao)
    }

    const fecharModal = () => {
        setModalSelecionado(null)
    }

    return (
        <EstruturaPagina>

            <TopoPagina titulo="Gerenciamento" />

            <div className={styles.barraOpcoes}>
                <div className={styles.containerBotoes}>
                    <div className={styles.areaBotoes + " " + styles.areaPesquisa}>
                        <Input className={styles.barraPesquisa} placeholder='Pesquisar' />
                        <Button tipoBotao="primario" onClick={handlePesquisar}>
                            <span className="material-symbols-outlined">search</span>

                        </Button>
                    </div>
                    <div className={styles.areaBotoes}>
                        <Select selected="Pesquisar por" opcoes={pesquisar} />
                        <Select selected="Ordenar por" opcoes={ordenar} />
                        <Input placeholder='Ano' />
                    </div>
                </div>
                <span className={styles.linha} />
                <div className={styles.containerBotoes}>
                    <Button tipoBotao="primario">
                        <Link to="/novoemprestimo">Novo empréstimo</Link>
                    </Button>
                    <div className={styles.areaBotoes}>
                        <Button icone="add" tipoBotao="primario">
                            <Link to="/criar">
                                Criar
                            </Link>
                        </Button>
                        <Button tipoBotao="secundario" icone="info" onClick={() => abrirModal('detalhes')} disabled={indiceSelecionado === null}>
                            Detalhes
                        </Button>
                        <Button tipoBotao="secundario" icone="edit_square" disabled={indiceSelecionado === null}>
                            <Link to="/editar">
                                Editar
                            </Link>
                        </Button>
                        <Button tipoBotao="secundario" icone="delete" onClick={() => abrirModal('excluir')} disabled={indiceSelecionado === null}>
                            Excluir
                        </Button>
                    </div>

                </div>
            </div>
            <div className={styles.containerCartoes}>
                {lista.map((item, i) => (

                    <div className={indiceSelecionado == i ? styles.cartaoSelecionado : styles.cartaoNaoSelecionado} onClick={() => handleSelecionar(i)} key={i}>

                        <div>
                            <img className={styles.imagemCartao} src="" />
                        </div>
                        <div className={styles.areaConteudoCartao}>
                            <div className={styles.areaTexto}>
                                <h2 className={styles.tituloSecundario}>{item.titulo}</h2>
                                <div className={styles.areaBotoes}>
                                    <p className={styles.paragrafo}>Autor:</p>
                                    <span className={styles.destaque}>{item.autor}</span>
                                    <p className={styles.paragrafo}><span className={styles.linhaHorizontal} /></p>
                                    <p className={styles.paragrafo}>Editora:</p>
                                    <span className={styles.destaque}>{item.editora}</span>
                                    <p className={styles.paragrafo}><span className={styles.linhaHorizontal} /></p>
                                    <p className={styles.paragrafo}>Ano:</p>
                                    <span className={styles.destaque}>{item.ano}</span>
                                </div>
                            </div>
                            <div className={styles.areaBotoes}>
                                {item.assuntos.map((assunto, i) => (
                                    <Assunto key={i}>{assunto}</Assunto>
                                ))}
                            </div>
                        </div>
                        <Status mensagem={item.disponivel} status={item.codStatus} />
                    </div>
                ))}
            </div>
            <Modal aberto={modalSelecionado === 'detalhes'} fechar={fecharModal} titulo={'Detalhes do livro'}>
                <DetalhesLivro />
            </Modal>
            <Modal aberto={modalSelecionado === 'excluir'} fechar={fecharModal} titulo={'Excluir livro'}>
                <ExcluirLivro />
            </Modal>

        </EstruturaPagina>
    )
}

/*
 const handleSelecionar = (indice) => {
        if (indiceSelecionado == indice) {
            setSelecionado(!selecionado)
        }
        setIndiceSelecionado(indice)
    } // <div className={selecionado && indiceSelecionado == i ? 
    styles.cartaoSelecionado : styles.cartaoNaoSelecionado} onClick={() => handleSelecionar(i)} key={i}>

    



*/