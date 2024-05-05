import styles from './styles.module.css'
import BarraAcessibilidade from '../BarraAcessibilidade'
import Header from '../Header'
import Footer from '../Footer'

export default function EstruturaPagina({ children }) {
    return (
        <div className={styles.container}>
            <BarraAcessibilidade />
            <Header />
            <div className={styles.areaConteudo}>
                <div className={styles.conteudo}>
                    {children}
                </div>
                <Footer />
            </div>
        </div>
    )
}