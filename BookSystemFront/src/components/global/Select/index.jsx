export default function Select(props) {
    return (
        <select>
            <option value="" selected disabled>{props.selected}</option>
            {props.options.map((option, i)=> {
                return (
                    <option key={i} value={option.value}>{option.text}</option>
                )
            })}
        </select>
    )
}