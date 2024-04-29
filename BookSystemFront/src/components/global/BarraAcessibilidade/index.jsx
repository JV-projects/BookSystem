import styles from "./styles.module.css"
import { CSSGlobalVariables } from "css-global-variables"

export default function BarraAcessibilidade() {

    function handleContraste() {
        let cssvar = new CSSGlobalVariables()

        console.log(cssvar)

        let chaves = Object.keys(cssvar)

        chaves.forEach(chave => {
            if (chave.includes("border")) {
                cssvar[chave] = "#0000ff"
            }

            if (chave.includes("highlight")) {
                cssvar[chave] = "#000"
            }

            if (chave.includes("text")) {
                cssvar[chave] = "#fff"
            }


            if (chave.includes("background")) {
                cssvar[chave] = "#000"
            }

            if (chave.includes("link")) {
                cssvar[chave] = "#ffff00"
            }

        });
    }

    return (
        <div className={styles.container}>
            <ul className={styles.lista}>
                <li><a className={styles.link} href="#conteudo" accessKey="1" title="ir para o conteúdo">Ir para o conteúdo [1]</a></li>
                <li><a className={styles.link} href="#menu" accessKey="2" title="ir para o menu">Ir para o menu [2]</a></li>
                <li><a className={styles.link} href="#rodape" accessKey="3" title="ir para o rodapé">Ir para o rodapé [3]</a></li>
            </ul>
            <ul className={styles.lista}>
                <li><a className={styles.link} href={"/acessibilidade"}>Acessibilidade</a></li>
                <li><button className={styles.botao} onClick={handleContraste}>Contraste</button></li>
                <li><button className={styles.botao}>Sem contraste</button></li>
                <li><button className={styles.botao}>A+</button></li>
                <li><button className={styles.botao}>A-</button></li>
            </ul>
        </div>
    )
}