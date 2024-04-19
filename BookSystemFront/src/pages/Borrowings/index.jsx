import styles from './styles.module.css'
import PageStructure from '../../components/global/PageStructure'
import Select from '../../components/global/Select/Select'
import Button from '../../components/global/Button'

const Borrowings = () => {
    const data = [
        {
            name: ""
        }
    ]

    let pesquisar = [
        {value: "titulo", text: "Título"},
        {value: "isbn", text: "ISBN"},
        {value: "autor", text: "Autor"},
        {value: "editora", text: "Editora"},
        {value: "assunto", text: "Assunto"}
    ]

    let ordenar = [
        {value: "titulo", text: "Título"},
        {value: "autor", text: "Autor"},
        {value: "editora", text: "Editora"}
    ]

    return(
        <PageStructure>
            <div className={styles.container}>
                <h1>Empréstimos</h1>
                <div className={styles.contentArea}>
                    <div className={styles.buttonsContainer}>
                        <div className={styles.buttonsArea}>
                            <input className={styles.input} placeholder='Pesquisar'/>
                            <Button>

                            </Button>
                        </div>
                        <div className={styles.buttonsArea}>
                            <Select selected="Pesquisar por" options={pesquisar}/>
                            <Select selected="Ordenar por" options={ordenar}/>
                        </div>
                    </div>
                    <span className={styles.line}/>
                    <div className={styles.cardsContainer}>
                        {data.map((item, i) => (
                            <div className={styles.cardContainer} key={i}>
                                <p className={styles.paragraph}>{item.name}</p>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </PageStructure>
    )
}

export default Borrowings