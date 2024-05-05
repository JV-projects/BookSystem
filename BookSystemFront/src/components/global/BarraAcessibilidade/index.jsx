import styles from "./styles.module.css"
import { Link } from "react-router-dom"
import { CSSGlobalVariables } from "css-global-variables"
import { cssVariaveis } from "../../../../public/js/acessibilidade.js"
import { fonte } from "../../../../public/js/acessibilidade.js"
import { setFonte } from "../../../../public/js/acessibilidade.js"

export default function BarraAcessibilidade() {

    let cssvar = new CSSGlobalVariables()

    let chaves = Object.keys(cssvar)
    let valores = Object.values(cssVariaveis)

    function handleContraste() {
        chaves.forEach(chave => {
            if (chave.includes("border")) {
                cssvar[chave] = "#fff"
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

            if (chave.includes("selected")) {
                cssvar[chave] = "#0000ff"
            }

        });
    }

    function handleSemContraste() {
        let i = 0;


        chaves.forEach(c => {

            cssvar[c] = valores[i]

            i++

        })


    }


    function fonteMais() {

        if (fonte < 25) {
            setFonte(fonte + 1)
            document.documentElement.style.fontSize = fonte + "px"
        }

    }

    function fonteMenos() {

        if (fonte > 16) {
            setFonte(fonte - 1)
            document.documentElement.style.fontSize = fonte + "px"
        }

    }

    return (
        <div className={styles.container}>
            <ul className={styles.lista}>
                <li><Link className={styles.link} to="/acessibilidade">Acessibilidade</Link></li>
                <li><button className={styles.botao} onClick={handleContraste}>Contraste</button></li>
                <li><button className={styles.botao} onClick={handleSemContraste}>Sem contraste</button></li>
                <li><button className={styles.botao} onClick={fonteMais} id="fontemais">A+</button></li>
                <li><button className={styles.botao} onClick={fonteMenos} id="fontmenos">A-</button></li>
            </ul>
        </div>
    )
}