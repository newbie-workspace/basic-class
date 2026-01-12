import { useState } from "react"

const InputElement2 = () => {
    
    const [state, setState] = useState({
        userName : "",
        email : "",
        message : ""
    })

    return(
        <>
            <input type="text" value={state.userName} 
            onChange={ (e) => {
                //setUserName(e.target.value)
                // setState({
                //     userName : e.target.value,
                //     email : state.email,
                //     message : state.message
                // })
                // {...state} : {userName : state.userName, email : state.email, message : state.message}
                setState({...state, userName : e.target.value}) 
                } } />
            <br />
            <input type="text" value={state.email}
            onChange={ (e) => {
                setState({...state, email : e.target.value})
            } } />
            <br />
            <button style={ {width: "100%", height: "40px", margin: "10px auto"} }
            onClick={ () => {
                setState({...state, message : `[${state.userName}][${state.email}]`})
            } }>전송</button>
            <hr />
            <div> {state.message} </div>
        </>
    )
}

export default InputElement2