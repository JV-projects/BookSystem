import Button from "../../components/global/Button";
import EstruturaPagina from "../../components/global/EstruturaPagina";
import Input from "../../components/global/Input";
import TopoPagina from "../../components/global/TopoPagina";
import styles from './styles.module.css'

export default function Criar() {
    return (
        <EstruturaPagina>
            <TopoPagina
                titulo="Criar um livro"
                subtitulo="Preencha corretamente os campos para criar um livro"
                link="/gerenciamento"
            />

            <form className={styles.containerArea}>

                <div className="form-parteUm">
                    <div className="blocoInput">
                        <label labelFor="">Título e subtítulo</label>
                        <Input />
                    </div>
                    <div className="blocoInput">
                        <label labelFor="">Autor</label>
                        <Input />
                    </div>
                    <div className="blocoInput">
                        <label labelFor="">Editora</label>
                        <Input />
                    </div>

                    <div className="blocoInput3">
                        <div className="blocoInput">
                            <label labelFor="">Ano</label>
                            <Input />
                        </div>

                        <div className="blocoInput">
                            <label labelFor="">Edição</label>
                            <Input />
                        </div>

                        <div className="blocoInput">
                            <label labelFor="">N° de páginas</label>
                            <Input />
                        </div>

                    </div>
                </div>

                <div className="form-parteDois">
                    <div className="blocoInput">
                        <label labelFor="">Etiqueta</label>
                        <div className="blocoInput2">
                            <Input />
                            <Button tipoBotao="primario">
                                Escanear
                            </Button>
                        </div>

                    </div>
                    <div className="blocoInput">
                        <label labelFor="">ISBN</label>
                        <Input />
                    </div>
                    <div className="blocoInput">
                        <label labelFor="">Imagem</label>
                        <Button tipoBotao="primario">Inserir imagem</Button>
                    </div>

                    <div className="blocoInput2">
                        <Button tipoBotao="terciarioCancela">Cancelar</Button>
                        <Button tipoBotao="primario">Criar livro</Button>
                    </div>
                </div>

            </form>
        </EstruturaPagina>
    )
}