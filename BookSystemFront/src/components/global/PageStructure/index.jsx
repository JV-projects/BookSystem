import styles from './styles.module.css'
import Header from '../Header'
import Footer from '../Footer'

const PageStructure = ({ children }) => {
    return(
        <div className={styles.container}>
            <Header/>
            <div className={styles.contentArea}>
                {children}
            </div>
            <Footer/>
        </div>
    )
}

export default PageStructure