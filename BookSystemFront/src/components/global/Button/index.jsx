import styles from './styles.module.css'

export default function Button({ children, isPrimario, ...rest }) {
    if (isPrimario == null) {
        isPrimario = true
    }

    return (
        <button className={isPrimario ? styles.botaoPrimario : styles.botaoSecundario} {...rest}>
            {children}
        </button>
    )
}