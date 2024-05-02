import styles from './styles.module.css'

export default function Subtitulo({ subtitulo }) {

    if (subtitulo) {
        return (
            <h3 className={styles.subtitulo}>{subtitulo}</h3>
        )
    }
    
}