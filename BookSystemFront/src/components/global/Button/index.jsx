import styles from './styles.module.css'

let estiloAplicado;
//(?)

export default function Button({ children, tipoBotao, ...rest }) {

    const defStyle = {
        display: "flex",
        "alignItems": "center",
        "padding": "0.45rem 0.75rem 0.45rem 0.75rem",
    }

    const estilo = Object.values(styles)


    estilo.forEach(classe => {

        if(classe.includes(tipoBotao)){
            estiloAplicado = classe
        }

    })

    return (
        <button style={defStyle} className={estiloAplicado} {...rest}>
            <span className="material-symbols-outlined">{rest.icone}</span>
            {children}
        </button>
    )


}