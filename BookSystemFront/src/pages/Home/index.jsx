import { useState } from 'react'
import styles from './styles.module.css'
import PageStructure from '../../components/global/PageStructure'
import Select from '../../components/global/Select/Select'

const Home = () => {
    const [selected, isSelected] = useState(false)
    const data = [
        {
            title: "Orgulho e Preconceito",
            author: "Jane Austen",
            publisher: "Martin Claret",
            year: "2012",
            tags: ["Literatura estrangeira", "Romance"],
            availability: 0
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
                <h1>Gerenciamento</h1>
                <div className={styles.contentArea}>
                    <div className={styles.buttonsContainer}>
                        <div className={styles.buttonsArea}>
                            <input className={styles.input} placeholder='Pesquisar'/>
                            <button className={styles.primaryButton}>

                            </button>
                        </div>
                        <div className={styles.buttonsArea}>
                            <Select selected="Pesquisar por" options={pesquisar}/>
                            <Select selected="Ordenar por" options={ordenar}/>
                        </div>
                    </div>
                    <span className={styles.line}/>
                    <div className={styles.buttonsContainer}>
                        <button className={styles.primaryButton}>
                            Fazer empréstimo
                        </button>
                        <div className={styles.buttonsArea}>
                            <button className={styles.primaryButton}>
                                Criar
                            </button>
                            <button className={styles.primaryButton} disabled={!selected}>
                                Editar
                            </button>
                            <button className={styles.primaryButton} disabled={!selected}>
                                Excluir
                            </button>
                            <button className={styles.primaryButton} disabled={!selected}>
                                Ver detalhes
                            </button>
                        </div>
                    </div>
                    <div className={styles.cardsContainer}>
                        {data.map((item, i) => (
                            <div className={styles.cardContainer} key={i}>
                                <div>
                                <img className={styles.cardImage} src=""/>
                                </div>
                                <div className={styles.cardContentArea}>
                                    <h2 className={styles.secondaryTitle}>{item.title}</h2>
                                    <div className={styles.buttonsArea}>
                                        <p className={styles.paragraph}>Autor: {item.author}</p>
                                        <p className={styles.paragraph}>Editora: {item.publisher}</p>
                                        <p className={styles.paragraph}>Ano: {item.year}</p>
                                    </div>
                                    <div className={styles.buttonsArea}>
                                        {item.tags.map((tag) => (
                                            <div className={styles.tag}>
                                                {tag}
                                            </div>
                                        ))}
                                        <div className={styles.tag}>
                                            Literatura estrangeira
                                        </div>
                                        <div className={styles.tag}>
                                            Romance
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    {item.availability == 0 && <div className={styles.unavailableStatus}>Indisponível</div>}
                                    {item.availability == 1 && <div className={styles.availableStatus}>Disponível</div>}  
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </PageStructure>
    )
}

export default Home