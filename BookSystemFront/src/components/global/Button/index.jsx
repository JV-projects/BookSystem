import styles from './styles.module.css'

export default function Button({ children, ...rest }) {
    return (
        <button className={styles.botaoPrimario} {...rest}>
            {children}
        </button>
    )
}