import styles from './styles.module.css'
import Header from '../Header'
import Footer from '../Footer'

const PageStructure = ({ children }) => {
    return(
        <div className={styles.container}>
            <Header/>
            {children}
            <Footer/>
        </div>
    )
}

export default PageStructure