import { Link } from 'react-router-dom'
import styles from './styles.module.css'

let estiloAplicado
//(?)

export default function Button({ children, tipoBotao, icone, to, ...rest }) {
    const estilo = Object.values(styles)

    estilo.forEach(classe => {
        if(classe.includes(tipoBotao)){
            estiloAplicado = classe
        }
    })

    if (to) {
        return (
            <Link className={estiloAplicado} to={to} {...rest}>
                {icone != null && <span className="material-symbols-outlined">{icone}</span>}
                {children}
            </Link>
        )
    }

    return (
        <button className={estiloAplicado} {...rest}>
            {icone != null && <span className="material-symbols-outlined">{icone}</span>}
            {children}
        </button>
    )
}