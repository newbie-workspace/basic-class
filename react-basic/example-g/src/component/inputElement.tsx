import { useState } from "react"

const InputElement = () => {
    
    const [userName, setUserName] = useState("")
    const [email, setEmail] = useState("")
    const [message, setMessage] = useState("")
    
    return(
        <>
            <input type="text" value={userName} 
            onChange={ (e) => {
                setUserName(e.target.value)
            } } />
            <br />
            <input type="text" value={email}
            onChange={ (e) => {
                setEmail(e.target.value)
            } } />
            <br />
            <button style={ {width: "100%", height: "40px", margin: "10px auto"} }
            onClick={ () => {
                setMessage(`[${userName}][${email}]`)
            } }>전송</button>
            <hr />
            <div> {message} </div>
        </>
    )
}

export default InputElement