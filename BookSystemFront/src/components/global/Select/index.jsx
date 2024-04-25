import styles from './styles.module.css'

export default function Select(props) {
    return (
        <div className={styles.container}>
            <select className={styles.select}>
                <option value="" selected disabled>{props.selected}</option>
                {props.opcoes.map((opcao, i)=> {
                    return (
                        <option key={i} value={opcao.valor}>{opcao.texto}</option>
                    )
                })}
            </select>
            <div className={styles.icon}>
                <span className="material-symbols-outlined">expand_more</span>
            </div>
        </div>
    )
}