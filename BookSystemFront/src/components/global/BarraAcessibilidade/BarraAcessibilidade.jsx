import { Link } from "react-router-dom";
import estilo from "./BarraAcessibilidade.module.css"

function BarraAcessibilidade() {
    return (
        <div className={estilo.container}>
            <ul className={estilo.lista}>
                <li><a href="#conteudo" accessKey="1" title="ir para o conteúdo">Ir para o conteúdo [1]</a></li>
                <li><a href="#menu" accessKey="2" title="ir para o menu">Ir para o menu [2]</a></li>
                <li><a href="#rodape" accessKey="3" title="ir para o rodapé">Ir para o rodapé [3]</a></li>
            </ul>
            <ul className={estilo.lista}>
                <li><Link to={"/acessibilidade"}>Acessibilidade</Link></li>
                <li><button id="contraste">Contraste</button></li>
                <li><button id="semcontraste">Sem contraste</button></li>
                <li><button id="fontemais">A+</button></li>
                <li><button id="fontemenos">A-</button></li>
            </ul>
        </div>
    )
}

export default BarraAcessibilidade;