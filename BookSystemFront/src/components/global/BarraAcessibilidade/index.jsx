import styles from "./styles.module.css"
import { Link } from "react-router-dom"
import Cookies from 'js-cookie'
import { useEffect } from "react"
import { fonte } from "../../../../public/js/fonte"
import { setFonte } from "../../../../public/js/fonte"

export default function BarraAcessibilidade() {

    //Como a barra de acessibilidade rederiza em várias páginas,
    //vou usar o useEffect para verificar o cookie

    useEffect(() => {
        const ckContraste = Cookies.get('contraste')
        //'documentElement' encontra o elemento raiz, ou seja, o <HTML>
        if(ckContraste === "true"){
            document.documentElement.classList.add('coresAcessibilidade')
        }else{
            document.documentElement.classList.remove('coresAcessibilidade')
        }

}, [])

    function constrate(){
        document.documentElement.classList.add('coresAcessibilidade')
        Cookies.set('contraste', true)
    }

    function semContraste(){
        document.documentElement.classList.remove('coresAcessibilidade')
        Cookies.set('contraste', false)
    }

    
    function fonteMais() {

        if (fonte < 24) {
            setFonte(fonte + 2)
            document.documentElement.style.fontSize = fonte + "px"
        }
    }

    function fonteMenos() {

        if (fonte > 16) {
            setFonte(fonte - 2)
            document.documentElement.style.fontSize = fonte + "px"
        }

    }

    return (
        <div className={styles.container}>
            <ul className={styles.lista}>
                <li><Link className={styles.link} to="/acessibilidade">Acessibilidade</Link></li>
                <li><button className={styles.botao} onClick={()=> constrate()}>Contraste</button></li>
                <li><button className={styles.botao} onClick={()=> semContraste()}>Sem contraste</button></li>
                <li><button className={styles.botao} onClick={()=> fonteMais()}>A+</button></li>
                <li><button className={styles.botao} onClick={()=> fonteMenos()}>A-</button></li>
            </ul>
        </div>
    )
}