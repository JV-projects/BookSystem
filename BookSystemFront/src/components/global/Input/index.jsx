import styles from './styles.module.css'

const Input = ({ ...rest }) => {
    return (
        <input className={styles.input} {...rest}/>
    )
}

export default Input