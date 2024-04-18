function Select(props){
    return(
        <>
        <select name="searchFor">
            <option selected disabled>{props.selected}</option>
            {
                props.options.map((prop)=> {
                    return(
                        <option value={prop.value}>{prop.text}</option>
                    )
                })
            }
        </select>
        </>
    )
}

export default Select