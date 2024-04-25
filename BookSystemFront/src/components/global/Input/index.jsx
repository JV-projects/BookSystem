import styles from './styles.module.css'

export default function Input({ ...rest }) {
    return (
        <input className={styles.input} {...rest}/>
    )
}