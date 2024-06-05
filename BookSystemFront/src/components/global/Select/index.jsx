import styles from './styles.module.css'

export default function Select({ selected, opcoes, ...rest }) {
    return (
        <div className={styles.container}>
            <select className={styles.select} defaultValue={selected} title='select' {...rest}>
                {selected && <option value={selected} disabled>{selected}</option>}
                {opcoes.map((opcao, i) => (
                    <option value={opcao.valor} key={i}>{opcao.texto}</option>
                ))}
            </select>
            <div className={styles.icon}>
                <span className="material-symbols-outlined">expand_more</span>
            </div>
        </div>
    )
}