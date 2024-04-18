import Header from "../components/global/Header";
import Select from "../components/global/Select/Select";

function Gerenciamento() {

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
        <>
            <Header/>
            <div>Gerenciamento</div>
            <Select selected="Pesquisar por" options={pesquisar}/>
            <Select selected="Ordenar por" options={ordenar}/>
        </>
    )
}

export default Gerenciamento;