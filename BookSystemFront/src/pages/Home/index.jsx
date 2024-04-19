import { useState } from 'react'
import styles from './styles.module.css'
import PageStructure from '../../components/global/PageStructure'
import Select from '../../components/global/Select/Select'
import Button from '../../components/global/Button'

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
                    <div className={styles.buttonsContainer}>
                        <Button>
                            Fazer empréstimo
                        </Button>
                        <div className={styles.buttonsArea}>
                            <Button>
                                Criar
                            </Button>
                            <Button disabled={!selected}>
                                Editar
                            </Button>
                            <Button disabled={!selected}>
                                Excluir
                            </Button>
                            <Button disabled={!selected}>
                                Ver detalhes
                            </Button>
                        </div>
                    </div>
                    <div className={styles.cardsContainer}>
                        {data.map((item, i) => (
                            <div className={styles.cardContainer} key={i}>
                                <div>
                                    <img className={styles.cardImage} src=""/>
                                </div>
                                <div className={styles.cardContentArea}>
                                    <div className={styles.textArea}>
                                        <h2 className={styles.secondaryTitle}>{item.title}</h2>
                                        <div className={styles.buttonsArea}>
                                            <p className={styles.paragraph}>Autor: {item.author}</p>
                                            <p className={styles.paragraph}>&bull;</p>
                                            <p className={styles.paragraph}>Editora: {item.publisher}</p>
                                            <p className={styles.paragraph}>&bull;</p>
                                            <p className={styles.paragraph}>Ano: {item.year}</p>
                                        </div>
                                    </div>
                                    <div className={styles.buttonsArea}>
                                        {item.tags.map((tag, i) => (
                                            <div className={styles.tag} key={i}>
                                                {tag}
                                            </div>
                                        ))}
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