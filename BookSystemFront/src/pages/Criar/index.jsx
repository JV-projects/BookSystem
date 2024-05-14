import Button from "../../components/global/Button";
import EstruturaPagina from "../../components/global/EstruturaPagina";
import Input from "../../components/global/Input";
import TopoPagina from "../../components/global/TopoPagina";
import styles from './styles.module.css'
import Select from '../../components/global/Select'
import { Link } from "react-router-dom";
import { useState } from "react";
import Assunto from "../../components/global/Assunto";

export default function Criar() {

    const [arquivo, setArquivo] = useState("")

    function handleArquivo(e) {
        setArquivo(URL.createObjectURL(e.target.files[0]))
    }


    return (
        <EstruturaPagina>
            <TopoPagina
                titulo="Criar um livro"
                subtitulo="Preencha corretamente os campos para criar um livro"
                link="/gerenciamento"
            />

            <form className={styles.containerArea}>

                <div className={styles.form}>
                    <div className={styles.blocoInput}>
                        <label htmlFor="tituloSubtitulo">Título e subtítulo</label>
                        <Input name="tituloSubtitulo" id="tituloSubtitulo" />
                    </div>
                    <div className={styles.blocoInput}>
                        <label htmlFor="autor">Autor</label>
                        <Input name="autor" id="autor" />
                    </div>
                    <div className={styles.blocoInput}>
                        <label htmlFor="editora">Editora</label>
                        <Input name="editora" id="editora" />
                    </div>

                    <div className={styles.blocoInput2}>
                        <div className={styles.blocoInput}>
                            <label htmlFor="ano">Ano</label>
                            <Input type="number" name="ano" id="ano" />
                        </div>

                        <div className={styles.blocoInput}>
                            <label htmlFor="edicao">Edição</label>
                            <Input type="number" name="edicao" id="edicao" />
                        </div>

                        <div className={styles.blocoInput}>
                            <label className={styles.label} htmlFor="nPaginas">N° de páginas</label>
                            <Input type="number" name="nPaginas" id="nPaginas" />
                        </div>

                    </div>

                    <div className={styles.blocoInput}>
                        <label htmlFor="assuntos">Assuntos</label>
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
                        </div>
                    </div>

                </div>

                <div className={styles.form}>
                    <div className={styles.blocoInput}>
                        <label htmlFor="etiqueta">Etiqueta</label>
                        <div className={styles.blocoInput2}>
                            <Input name="etiqueta" id="etiqueta" />
                            <Button tipoBotao="primario">
                                Escanear
                            </Button>
                        </div>

                    </div>
                    <div className={styles.blocoInput}>
                        <label htmlFor="isbn">ISBN</label>
                        <Input name="isbn" id="isbn" />
                    </div>
                    <div className={styles.blocoInput2 +" "+ styles.imagemArea}>
                        <div className={styles.blocoInput}>
                            <label>Carregar imagem do livro</label>
                            <label htmlFor="imagemLivro" className={styles.inputFile}>
                                <span className="material-symbols-outlined">add_a_photo</span>
                            </label>
                            <input className={styles.inputFile} type="file" name="imagemLivro" id="imagemLivro" onChange={(e) => handleArquivo(e)} />
                        </div>
                        <div className={styles.blocoInput +" "+ styles.imagem}>
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
                            <Button tipoBotao="primario">Criar livro</Button>
                        </div>
                    </div>
                </div>

            </form>
        </EstruturaPagina>
    )
}