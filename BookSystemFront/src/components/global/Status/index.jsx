import styles from './styles.module.css'

let estiloAplicado;

export default function Status({ status }) {


    let estilos = Object.values(styles)


    let subStatus = status.replaceAll(" ", "").substring(0, 5)


    estilos.forEach(classe => {
        if (classe.includes(subStatus)) {
            estiloAplicado = classe;
        }
    })


    return (
        <div className={estiloAplicado}>{status}</div>
    )
}   