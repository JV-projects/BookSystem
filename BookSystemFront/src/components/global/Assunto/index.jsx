import styles from './styles.module.css'

export default function Assunto({ children, fechavel=false, fechar, ...rest }){
    return(
        <p className={styles.assunto} {...rest}>
            {children}
            {fechavel && <button className={styles.botao} type='button' onClick={fechar}>
                <span className="material-symbols-outlined">close</span>
            </button>}
        </p>
    )
}