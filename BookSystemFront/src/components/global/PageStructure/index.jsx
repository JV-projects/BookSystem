import styles from './styles.module.css'
import AcessibilityBar from '../AcessibilityBar'
import Header from '../Header'
import Footer from '../Footer'

const PageStructure = ({ children }) => {
    return(
        <div className={styles.container}>
            <AcessibilityBar/>
            <Header/>
            <div className={styles.contentArea}>
                {children}
            </div>
            <Footer/>
        </div>
    )
}

export default PageStructure