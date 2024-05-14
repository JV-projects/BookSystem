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

export default function Editar() {

    const [arquivo, setArquivo] = useState("/assets/images/livro.jpg")

    function handleArquivo(e) {
        setArquivo(URL.createObjectURL(e.target.files[0]))
    }

    const livro = {
        tituloSubtitulo: "Orgulho e Preconceito",
        autor: "Jane Austen",
        editora: "Martin Claret",
        ano: "2012",
        edicao: "1",
        nPaginas: "424",
        assuntos: [
            {
                assunto: "Literatura",
                assunto: "Romance",
            }
        ],
        etiqueta: "98765432100",
        isbn: "9788483431078"
    }


    return (
        <EstruturaPagina>
            <TopoPagina
                titulo="Editar livro"
                subtitulo="Altere os campos desejados para atualizar os dados do livro"
                link="/gerenciamento"
            />

            <form className={styles.containerArea}>

                <div className={styles.form}>
                    <div className={styles.blocoInput}>
                        <label htmlFor="tituloSubtitulo">Título e subtítulo</label>
                        <Input name="tituloSubtitulo" id="tituloSubtitulo" value={livro.tituloSubtitulo} />
                    </div>
                    <div className={styles.blocoInput}>
                        <label htmlFor="autor">Autor</label>
                        <Input name="autor" id="autor" value={livro.autor} />
                    </div>
                    <div className={styles.blocoInput}>
                        <label htmlFor="editora">Editora</label>
                        <Input name="editora" id="editora" value={livro.editora} />
                    </div>

                    <div className={styles.blocoInput2}>
                        <div className={styles.blocoInput}>
                            <label htmlFor="ano">Ano</label>
                            <Input type="number" name="ano" id="ano" value={livro.ano} />
                        </div>

                        <div className={styles.blocoInput}>
                            <label htmlFor="edicao">Edição</label>
                            <Input type="number" name="edicao" id="edicao" value={livro.edicao} />
                        </div>

                        <div className={styles.blocoInput}>
                            <label htmlFor="nPaginas">N° de páginas</label>
                            <Input type="number" name="nPaginas" id="nPaginas" value={livro.nPaginas} />
                        </div>

                    </div>

                    <div className={styles.blocoInput}>
                        <label>Assuntos</label>
                        <div className={styles.blocoInput2}>
                            <Select name="assuntos" id="assuntos" selected="Selecione" opcoes={[]} />
                            <Button tipoBotao="primario">
                                Adicionar
                            </Button>
                        </div>
                        <div className={styles.areaAssunto}>
                            <Assunto fechavel={true}>
                                <p>Literatura estrangeira</p>
                            </Assunto>
                            <Assunto fechavel={true}>
                                <p>Romance</p>
                            </Assunto>
                        </div>
                    </div>

                </div>

                <div className={styles.form}>
                    <div className={styles.blocoInput}>
                        <label htmlFor="etiqueta">Etiqueta</label>
                        <div className={styles.blocoInput2}>
                            <Input name="etiqueta" id="etiqueta" disabled="true" value={livro.etiqueta} />
                            <Button tipoBotao="primario">
                                Escanear
                            </Button>
                        </div>

                    </div>
                    <div className={styles.blocoInput}>
                        <label htmlFor="isbn">ISBN</label>
                        <Input name="isbn" id="isbn" value={livro.isbn} />
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
                            <Button tipoBotao="terciarioCancela" type="button">
                                <Link to="/gerenciamento">Cancelar</Link>
                            </Button>
                        </div>
                        <div className={styles.blocoInput}>
                            <Button tipoBotao="primario">Salvar</Button>
                        </div>
                    </div>
                </div>

            </form>
        </EstruturaPagina>
    )
}