import styles from './styles.module.css'
import PageStructure from '../../components/global/PageStructure'
import Select from '../../components/global/Select/Select'
import Button from '../../components/global/Button'

const Borrowings = () => {
    const data = [
        {
            name: "Jackeline Menezes",
            phoneNumber: "(11) 98822-8833",
            borrowingDate: "21/04/2024",
            returnDate: "21/05/2024",
            status: 1
        },
        {
            name: "Yudi Tamashiro",
            phoneNumber: "(11) 4002-8922",
            borrowingDate: "21/04/2024",
            returnDate: "21/05/2024",
            status: 0
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
                                <span class="material-symbols-outlined">search</span>
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
                                <p className={styles.paragraph}>{item.phoneNumber}</p>
                                <div className={styles.textArea}>
                                    <h2 className={styles.secondaryTitle}>Data de retirada</h2>
                                    <p className={styles.paragraph}>{item.borrowingDate}</p>
                                </div>
                                <div className={styles.textArea}>
                                    <h2 className={styles.secondaryTitle}>Data de devolução</h2>
                                    <p className={styles.paragraph}>{item.returnDate}</p>
                                </div>
                                {item.status == 0 && <div className={styles.pendingStatus}>Em andamento</div>}
                                {item.status == 1 && <div className={styles.returnedStatus}>Devolvido</div>}
                                {item.status == 2 && <div className={styles.notReturnedStatus}>Não devolvido</div>}
                                <Button>Ver detalhes</Button>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </PageStructure>
    )
}

export default Borrowings