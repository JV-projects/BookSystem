import Subtitulo from "../Subtitulo";
import Titulo from "../Titulo";
import Button from "../Button";
import styles from "./styles.module.css"
import { Link } from "react-router-dom";

export default function TopoPagina({ titulo, subtitulo, link }) {

    return (
        <>
            <div className={styles.container_topo}>
               <ButtonLink link={link} />
                <div className={styles.headings}>
                    <Titulo titulo={titulo} />
                    <Subtitulo subtitulo={subtitulo} />
                </div>
            </div>
        </>
    )
}

function ButtonLink({link}){
    if(link){
        return(
            <Link to={link}>
                 <Button icone="arrow_back" tipoBotao="botaoVoltar" />
            </Link>
           
        )
    }
}