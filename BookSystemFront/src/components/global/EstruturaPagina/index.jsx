import styles from './styles.module.css'
import BarraAcessibilidade from '../BarraAcessibilidade'
import Header from '../Header'
import Footer from '../Footer'

const EstruturaPagina = ({ children }) => {
    return(
        <div className={styles.container}>
            <BarraAcessibilidade/>
            <Header/>
            <div className={styles.areaConteudo}>
                {children}
            </div>
            <Footer/>
        </div>
    )
}

export default EstruturaPagina