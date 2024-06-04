import Button from "../../components/global/Button";
import EstruturaPagina from "../../components/global/EstruturaPagina";
import Input from "../../components/global/Input";
import TopoPagina from "../../components/global/TopoPagina";
import styles from './styles.module.css'
import { Link } from "react-router-dom";
import { useEffect, useState } from "react";
import Assunto from "../../components/global/Assunto";
import Modal from "../../components/global/Modal";
import ModalPorta from "../../components/ModalPorta";
import ModalScan from "../../components/ModalScan";
import { arrayToString } from "../../../public/js/scanTag";
import Select from "../../components/global/Select";
import apiUrl from '../../util/apiUrl'
import assuntosPredefinidos from '../../util/assuntosPredefinidos'

export default function Criar() {
    const [arquivo, setArquivo] = useState("")
    const [modalSelecionado, setModalSelecionado] = useState(null)
    const [porta, setPorta] = useState()
    const [tipoModal, setTipoModal] = useState("conectar")
    const [uid, setUid] = useState([])

    const [tituloSubtitulo, setTituloSubtitulo] = useState('')
    const [autor, setAutor] = useState('')
    const [editora, setEditora] = useState('')
    const [ano, setAno] = useState('')
    const [edicao, setEdicao] = useState('')
    const [nPaginas, setNPaginas] = useState('')
    const [assuntos, setAssuntos] = useState([])
    const [etiqueta, setEtiqueta] = useState('')
    const [isbn, setIsbn] = useState('')
    const [novoAssunto, setNovoAssunto] = useState([])

    let array = []

    console.log(uid)

    useEffect(() => {
        if (typeof porta === "object") {
            setModalSelecionado("escanear")
            setTipoModal("escanear")
        }
    }, [porta])


    function handleArquivo(e) {
        setArquivo(URL.createObjectURL(e.target.files[0]))
    }

    const handleCriar = async () => {
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
            const response = await fetch(`${apiUrl}/livros`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(livro)
            })
            if (!response.ok) {
                throw new Error("Erro ao cadastrar o livro.")
            }
        } catch (error) {
            setErrorMessage("Erro ao cadastrar o livro. Verifique os dados informados.")
        }
    }

    const handleFechar = (index) => {
        setAssuntos(assuntos.filter((assunto, i) => i != index))
    }

    return (
        <EstruturaPagina>
            <TopoPagina
                titulo="Criar um livro"
                subtitulo="Preencha corretamente os campos para criar um livro"
                link="/gerenciamento"
            />
            <form className={styles.containerArea} onSubmit={handleCriar}>
                <div className={styles.form}>
                    <div className={styles.blocoInput}>
                        <label htmlFor="tituloSubtitulo">Título e subtítulo</label>
                        <Input name="tituloSubtitulo" id="tituloSubtitulo" value={tituloSubtitulo} onChange={e => setTituloSubtitulo(e.target.value)}/>
                    </div>
                    <div className={styles.blocoInput}>
                        <label htmlFor="autor">Autor</label>
                        <Input name="autor" id="autor" value={autor} onChange={e => setAutor(e.target.value)}/>
                    </div>
                    <div className={styles.blocoInput}>
                        <label htmlFor="editora">Editora</label>
                        <Input name="editora" id="editora" value={editora} onChange={e => setEditora(e.target.value)}/>
                    </div>
                    <div className={styles.blocoInput2}>
                        <div className={styles.blocoInput}>
                            <label htmlFor="ano">Ano</label>
                            <Input type="number" name="ano" id="ano" value={ano} onChange={e => setAno(e.target.value)}/>
                        </div>
                        <div className={styles.blocoInput}>
                            <label htmlFor="edicao">Edição</label>
                            <Input type="number" name="edicao" id="edicao" value={edicao} onChange={e => setEdicao(e.target.value)}/>
                        </div>
                        <div className={styles.blocoInput}>
                            <label className={styles.label} htmlFor="nPaginas">N° de páginas</label>
                            <Input type="number" name="nPaginas" id="nPaginas" value={nPaginas} onChange={e => setNPaginas(e.target.value)}/>
                        </div>
                    </div>
                    <div className={styles.blocoInput}>
                        <label htmlFor="assuntos">Assuntos</label>
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
                            <Input name="etiqueta" id="etiqueta" value={arrayToString(uid)} onChange={(e) => setEtiqueta(e.target.value)} disabled />
                            <Button tipoBotao="primario" type="button" onClick={() => setModalSelecionado(tipoModal)}>
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
                            <input className={styles.inputFile} type="file" name="imagemLivro" id="imagemLivro" onChange={e => handleArquivoe} />
                        </div>
                        <div className={styles.blocoInput + " " + styles.imagem}>
                            <img src={arquivo} alt="Imagem do livro a ser carregada" />
                        </div>
                    </div>
                    <div className={styles.blocoInput2}>
                        <div className={styles.blocoInput}>
                            <Button tipoBotao="terciarioCancela" type="button">
                                <Link to="/gerenciamento">Cancelar</Link>
                            </Button>
                        </div>
                        <div className={styles.blocoInput}>
                            <Button tipoBotao="primario" type='submit'>Criar livro</Button>
                        </div>
                    </div>
                </div>
            </form>
            <Modal aberto={modalSelecionado === 'conectar'} fechar={setModalSelecionado} titulo={'Selecione a porta de comunicação'}>
                <ModalPorta funcao={setPorta} porta={porta} />
            </Modal>
            <Modal aberto={modalSelecionado === 'escanear'} fechar={setModalSelecionado} titulo={'Escanear a Tag RFID'}>
                <ModalScan porta={porta} dados={setUid} />
            </Modal>
        </EstruturaPagina>
    )
}