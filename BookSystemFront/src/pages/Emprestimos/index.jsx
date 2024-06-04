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
import useSWR from 'swr'
import fetcher from '../../util/fetcher'
import apiUrl from '../../util/apiUrl'

export default function Emprestimos() {
    const { data, error, isLoading } = useSWR(`${apiUrl}/emprestimos`, fetcher)

    const [aberto, setAberto] = useState(false)
    const [indiceSelecionado, setIndiceSelecionado] = useState(null)

    const [pesquisa, setPesquisa] = useState("")
    const [lista, setLista] = useState(data)
    const [sort, setSort] = useState("arrow_upward_alt")

    const dados = [
        {
            "nome": "Jackeline Menezes",
            "numeroTelefone": "(11) 98822-8833",
            "dataEmprestimo": "21/04/2024",
            "dataDevolucao": "21/05/2024",
            "status": "Em atraso",
        },
        {
            "nome": "Yudi Tamashiro",
            "numeroTelefone": "(11) 4002-8922",
            "dataEmprestimo": "21/04/2024",
            "dataDevolucao": "21/05/2024",
            "status": "Em andamento",
        },
        {
            "nome": "Yudi Tamashiro",
            "numeroTelefone": "(11) 4002-8922",
            "dataEmprestimo": "21/04/2024",
            "dataDevolucao": "21/05/2024",
            "status": "Concluído",
        }
    ]

    let pesquisar = [
        { valor: "nome", texto: "Nome" },
        { valor: "email", texto: "Email" }
    ]

    let ordenar = [
        { valor: "nome", texto: "Nome" },
        { valor: "email", texto: "Email" },
        { valor: "status", texto: "Status" }
    ]

    function handleSort() {
        if (sort === "arrow_upward_alt") {
            setSort("arrow_downward_alt")
        } else {
            setSort("arrow_upward_alt")
        }
    }

    return (
        <EstruturaPagina>
            <TopoPagina titulo="Empréstimos" subtitulo="Histórico"/>
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
                                <label htmlFor="Pesquisar por" className={styles.selectLabel}>Pesquisar por</label>
                                <Select name="Pesquisar por" opcoes={pesquisar} />
                            </div>
                            <div>
                                <label htmlFor="Filtrar" className={styles.selectLabel}>Filtrar</label>
                                <Select name="Filtrar" opcoes={ordenar} />
                            </div>
                            <Button icone={sort} onClick={() => handleSort()}>
                                <span className='material-symbols-outlined'>sort</span>
                            </Button>
                        </div>
                    </div>
                </div>
                {error ? (
                    <div className={styles.areaTextoCentralizado}>
                        <p className={styles.paragrafo}>Ocorreu um erro.</p>
                    </div>
                ): isLoading ? (
                    <div className={styles.areaTextoCentralizado}>
                        <p className={styles.paragrafo}>Carregando...</p>
                    </div>
                ) : !lista ? (
                    <div className={styles.areaTextoCentralizado}>
                        <p className={styles.paragrafo}>Nenhum dado encontrado.</p>
                    </div>
                ) : (
                    <div className={styles.containerCartoes}>
                        {lista.map((item, i) => (
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
                                <Status status={item.status} />
                                <Button onClick={() => {setIndiceSelecionado(i), setAberto(true)}}>
                                    <span className="material-symbols-outlined">info</span>
                                </Button>
                            </div>
                        ))}
                    </div>
                )}
            <Aside aberto={aberto} fechar={() => {setIndiceSelecionado(null), setAberto(false)}} titulo={'Detalhes do empréstimo'}>
                <DetalhesEmprestimo id={data && data[indiceSelecionado].id}/>
            </Aside>
        </EstruturaPagina>
    )
}