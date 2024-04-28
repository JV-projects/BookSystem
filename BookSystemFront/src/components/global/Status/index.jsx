import styles from './styles.module.css'

let estiloAplicado;

export default function Status({ status, mensagem }) {


    let estilos = Object.values(styles)

    estilos.forEach(classe => {

        if (classe.includes(status)) {
            estiloAplicado = classe
        }

    });

    return (
        <div className={estilos[status]}>{mensagem}</div>
    )
}   