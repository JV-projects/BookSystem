export default function Select(props) {
    return (
        <select>
            <option value="" selected disabled>{props.selected}</option>
            {props.opcoes.map((opcao, i)=> {
                return (
                    <option key={i} value={opcao.valor}>{opcao.texto}</option>
                )
            })}
        </select>
    )
}