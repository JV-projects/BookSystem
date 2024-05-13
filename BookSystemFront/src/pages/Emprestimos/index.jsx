import { useState } from 'react'
import styles from './styles.module.css'
import EstruturaPagina from '../../components/global/EstruturaPagina'
import Select from '../../components/global/Select'
import Input from '../../components/global/Input'
import Button from '../../components/global/Button'
import Status from '../../components/global/Status'
import TopoPagina from '../../components/global/TopoPagina'
import Aside from '../../components/global/Aside'
import DetalhesEmprestimo from '../../components/global/DetalhesEmprestimo'

export default function Emprestimos() {
    const [aberto, setAberto] = useState(false)

    const dados = [
        {
            nome: "Jackeline Menezes",
            numeroTelefone: "(11) 98822-8833",
            dataEmprestimo: "21/04/2024",
            dataDevolucao: "21/05/2024",
            status: "Concluído",
            codStatus: 0
        },
        {
            nome: "Yudi Tamashiro",
            numeroTelefone: "(11) 4002-8922",
            dataEmprestimo: "21/04/2024",
            dataDevolucao: "21/05/2024",
            status: "Em andamento",
            codStatus: 1
        }
    ]

    let pesquisar = [
        { valor: "titulo", texto: "Título" },
        { valor: "isbn", texto: "ISBN" },
        { valor: "autor", texto: "Autor" },
        { valor: "editora", texto: "Editora" },
        { valor: "assunto", texto: "Assunto" },
    ]

    let ordenar = [
        { valor: "titulo", texto: "Título" },
        { valor: "autor", texto: "Autor" },
        { valor: "editora", texto: "Editora" },
        { valor: "titulo", texto: "Título" },
        { valor: "autor", texto: "Autor" },
        { valor: "editora", texto: "Editora" }
    ]

    return (
        <EstruturaPagina>
            <TopoPagina titulo="Empréstimos" subtitulo="Histórico"/>
            <div className={styles.areaConteudo}>
                <div className={styles.barraOpcoes}>
                    <div className={styles.containerPesquisa}>
                        <div className={styles.blocoPesquisa + " " + styles.areaPesquisa}>
                            <Input className={styles.barraPesquisa} placeholder='Pesquisar' />
                            <Button tipoBotao="primario">
                                <span className="material-symbols-outlined">search</span>
                            </Button>
                        </div>
                        <div className={styles.blocoFiltro}>
                            <Select selected="Filtrar" opcoes={pesquisar} />
                            <Select selected="Ordenar" opcoes={ordenar} />
                        </div>
                    </div>
                </div>
                <div className={styles.containerCartoes}>
                    {dados.map((item, i) => (
                        <div className={styles.cartao} key={i}>
                            <p className={styles.paragrafo}>{item.nome}</p>
                            <p className={styles.paragrafo + " " + styles.tel}>
                                <span className="material-symbols-outlined">call</span>
                                {item.numeroTelefone}
                            </p>
                            <div className={styles.areaTexto + " " + styles.data}>
                                <h2 className={styles.tituloSecundario}>Data de retirada</h2>
                                <p className={styles.paragrafo}>{item.dataEmprestimo}</p>
                            </div>
                            <div className={styles.areaTexto + " " + styles.data}>
                                <h2 className={styles.tituloSecundario}>Data de devolução</h2>
                                <p className={styles.paragrafo}>{item.dataDevolucao}</p>
                            </div>
                            <Status mensagem={item.status} status={item.codStatus} />
                            <Button onClick={() => setAberto(true)}>
                                <span className="material-symbols-outlined">info</span>
                            </Button>
                        </div>
                    ))}
                </div>
            </div>
            <Aside aberto={aberto} fechar={() => setAberto(false)} titulo={'Detalhes do empréstimo'}>
                <DetalhesEmprestimo/>
            </Aside>
        </EstruturaPagina>
    )
}