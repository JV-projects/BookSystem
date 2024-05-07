import styles from './styles.module.css'

let estiloAplicado;
//(?)

export default function Button({ children, tipoBotao, ...rest }) {

    const estilo = Object.values(styles)


    estilo.forEach(classe => {

        if(classe.includes(tipoBotao)){
            estiloAplicado = classe
        }

    })

    return (
        <button className={estiloAplicado} value={rest.value} {...rest}>
            <span className="material-symbols-outlined">{rest.icone}</span>
            {children}
        </button>
    )


}