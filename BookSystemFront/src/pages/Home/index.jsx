import { useState } from 'react'
import styles from './styles.module.css'
import PageStructure from '../../components/global/PageStructure'
import Select from '../../components/global/Select/Select'

const Home = () => {
    const [selected, isSelected] = useState(false)
    const data = [
        {
            
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
                            <button className={styles.primaryButton} disabled={!selected}>
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
                            <div className={styles.card} key={i}>
                                <img src=""/>
                                <div>
                                    <h2></h2>
                                    <div className={styles.buttonsArea}></div>
                                    <div className={styles.buttonsArea}></div>
                                </div>
                                <div>
                                    
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