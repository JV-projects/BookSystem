import Button from "../../components/global/Button";
import EstruturaPagina from "../../components/global/EstruturaPagina";
import Input from "../../components/global/Input";
import TopoPagina from "../../components/global/TopoPagina";
import styles from './styles.module.css'
import Select from '../../components/global/Select'
import { Link } from "react-router-dom";
import { useState } from "react";
import livro from '/assets/images/livro.jpg'
import Assunto from "../../components/global/Assunto";
import { useParams } from 'react-router-dom'
import useSWR from 'swr'
import fetcher from '../../util/fetcher'
import apiUrl from '../../util/apiUrl'
import assuntosPredefinidos from '../../util/assuntosPredefinidos'

export default function Editar() {
    const { id } = useParams()

    const { data, error, isLoading } = useSWR(`${apiUrl}/livros/${id}`, fetcher)

    const [arquivo, setArquivo] = useState("/assets/images/livro.jpg")

    function handleArquivo(e) {
        setArquivo(URL.createObjectURL(e.target.files[0]))
    }

    const [tituloSubtitulo, setTituloSubtitulo] = useState(data && data.tituloSubtitulo || '')
    const [autor, setAutor] = useState(data && data.autor || '')
    const [editora, setEditora] = useState(data && data.editora || '')
    const [ano, setAno] = useState(data && data.ano || '')
    const [edicao, setEdicao] = useState(data && data.edicao || '')
    const [nPaginas, setNPaginas] = useState(data && data.nPaginas || '')
    const [assuntos, setAssuntos] = useState(data && data.assuntos || [])
    const [etiqueta, setEtiqueta] = useState(data && data.etiqueta || '')
    const [isbn, setIsbn] = useState(data && data.isbn || '')
    const [novoAssunto, setNovoAssunto] = useState([])

    const handleEditar = async () => {
        const livro = {
            tituloSubtitulo,
            autor,
            editora,
            ano,
            edicao,
            nPaginas,
            assuntos,
            etiqueta,
            isbn
        }

        try {
            const response = await fetch(`${apiUrl}/livros/${id}`, {
                method: "PATCH",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(livro)
            })
            if (!response.ok) {
                throw new Error("Erro ao editar o livro.")
            }
        } catch (error) {
            setErrorMessage("Erro ao editar o livro. Verifique os dados informados.")
        }
    }

    const handleFechar = (index) => {
        setAssuntos(assuntos.filter((assunto, i) => i != index))
    }

    return (
        <EstruturaPagina>
            <TopoPagina
                titulo="Editar livro"
                subtitulo="Altere os campos desejados para atualizar os dados do livro"
                link="/gerenciamento"
            />
            <form className={styles.containerArea} onSubmit={handleEditar}>
                <div className={styles.form}>
                    <div className={styles.blocoInput}>
                        <label htmlFor="tituloSubtitulo">Título e subtítulo</label>
                        <Input name="tituloSubtitulo" id="tituloSubtitulo" value={tituloSubtitulo} onChange={(e) => setTituloSubtitulo(e.target.value)}/>
                    </div>
                    <div className={styles.blocoInput}>
                        <label htmlFor="autor">Autor</label>
                        <Input name="autor" id="autor" value={autor} onChange={(e) => setAutor(e.target.value)}/>
                    </div>
                    <div className={styles.blocoInput}>
                        <label htmlFor="editora">Editora</label>
                        <Input name="editora" id="editora" value={editora} onChange={(e) => setEditora(e.target.value)}/>
                    </div>
                    <div className={styles.blocoInput2}>
                        <div className={styles.blocoInput}>
                            <label htmlFor="ano">Ano</label>
                            <Input type="number" name="ano" id="ano" value={ano} onChange={(e) => setAno(e.target.value)}/>
                        </div>
                        <div className={styles.blocoInput}>
                            <label htmlFor="edicao">Edição</label>
                            <Input type="number" name="edicao" id="edicao" value={edicao} onChange={(e) => setEdicao(e.target.value)}/>
                        </div>
                        <div className={styles.blocoInput}>
                            <label className={styles.label} htmlFor="nPaginas">N° de páginas</label>
                            <Input type="number" name="nPaginas" id="nPaginas" value={nPaginas} onChange={(e) => setNPaginas(e.target.value)}/>
                        </div>
                    </div>
                    <div className={styles.blocoInput}>
                        <label>Assuntos</label>
                        <div className={styles.blocoInput2}>
                            <Select name="assuntos" id="assuntos" selected="Selecione" onChange={e => setNovoAssunto(e.target.value)} opcoes={assuntosPredefinidos} />
                            <Button tipoBotao="primario" type="button" onClick={() => novoAssunto != '' && setAssuntos([...assuntos, novoAssunto])}>
                                Adicionar
                            </Button>
                        </div>
                        <div className={styles.areaAssunto}>
                            {assuntos.map((assunto, i) => (
                                <Assunto fechavel={true} fechar={() => handleFechar(i)} key={i}>
                                    {assunto}
                                </Assunto>
                            ))}
                        </div>
                    </div>
                </div>
                <div className={styles.form}>
                    <div className={styles.blocoInput}>
                        <label htmlFor="etiqueta">Etiqueta</label>
                        <div className={styles.blocoInput2}>
                            <Input name="etiqueta" id="etiqueta" value={etiqueta} disabled/>
                            <Button tipoBotao="primario">
                                Escanear
                            </Button>
                        </div>
                    </div>
                    <div className={styles.blocoInput}>
                        <label htmlFor="isbn">ISBN</label>
                        <Input name="isbn" id="isbn" value={isbn} onChange={(e) => setIsbn(e.target.value)}/>
                    </div>
                    <div className={styles.blocoInput2 + " " + styles.imagemArea}>
                        <div className={styles.blocoInput}>
                            <label>Carregar imagem do livro</label>
                            <label htmlFor="imagemLivro" className={styles.inputFile}>
                                <span className="material-symbols-outlined">add_a_photo</span>
                            </label>
                            <input className={styles.inputFile} type="file" name="imagemLivro" id="imagemLivro" onChange={(e) => handleArquivo(e)} />
                        </div>
                        <div className={styles.blocoInput + " " + styles.imagem}>
                            <img src={arquivo} alt="Imagem do livro a ser carregada" />
                        </div>
                    </div>
                    <div className={styles.blocoInput2}>
                        <div className={styles.blocoInput}>
                            <Button tipoBotao="terciarioCancela" to="/gerenciamento" type="button">Cancelar</Button>
                        </div>
                        <div className={styles.blocoInput}>
                            <Button tipoBotao="primario" type="submit">Salvar</Button>
                        </div>
                    </div>
                </div>
            </form>
        </EstruturaPagina>
    )
}