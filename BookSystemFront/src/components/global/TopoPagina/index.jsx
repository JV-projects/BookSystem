import Subtitulo from "../Subtitulo";
import Titulo from "../Titulo";
import Button from "../Button";
import styles from "./styles.module.css"

export default function TopoPagina({ titulo, subtitulo, link }) {

    return (
        <>
            <div className={styles.container_topo}>
                <a href={link ? link : "#"}>
                    <Button icone="arrow_back" tipoBotao="botaoVoltar" />
                </a>
                <div className={styles.headings}>
                    <Titulo titulo={titulo} />
                    <Subtitulo subtitulo={subtitulo} />
                </div>
            </div>
        </>
    )
}