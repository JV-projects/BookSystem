import styles from './styles.module.css'

let estiloAplicado
//(?)

export default function Button({ children, tipoBotao, icone, ...rest }) {
    const estilo = Object.values(styles)

    estilo.forEach(classe => {
        if(classe.includes(tipoBotao)){
            estiloAplicado = classe
        }
    })

    return (
        <button className={estiloAplicado} {...rest}>
            {icone != null && <span className="material-symbols-outlined">{icone}</span>}
            {children}
        </button>
    )
}