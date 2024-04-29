import styles from './styles.module.css'

export default function Input({ className, ...rest }) {
    return (
        <input className={styles.input + " " + className} {...rest}/>
    )
}