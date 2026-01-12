import { useState } from "react"

export default function Exchange() {
    const [state, setState] = useState({
        wonIn : 0,
        dolIn : 0,
        dolOut : 0,
        wonOut : 0
    })
    const style = {
        border: "solid 2px",
        color: "red",
        marginTop: "30px",
        height: "80px"
    }
    return(

        <>
            <table>
                <tr>
                    <td>won</td>
                    <td rowSpan={5}><button style={style}
                    onClick={ () => {
                        setState({...state, dolOut : state.wonIn / 1457, wonOut : state.dolIn * 1457})
                    }}>&gt;&gt;</button></td>
                    <td>dollar</td>
                </tr>
                <tr>
                    <td><input type="text" value={state.wonIn}
                    onChange={ e => {
                        setState({...state, wonIn : parseInt(e.target.value)})
                    }}/></td>
                    <td><input type="text" value={state.dolOut}/></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>dollar</td>
                    <td>won</td>
                </tr>
                <tr>
                    <td><input type="text" value={state.dolIn}
                    onChange={ e => {
                        setState({...state, dolIn : parseInt(e.target.value)})
                    }}/></td>
                    <td><input type="text" value={state.wonOut}/></td>
                </tr>
            </table>
        </>

    )
}