import { useState } from "react"

export default function Practice2() {

    const [numValue, setNumValue] =useState("")
    return(
        <>
            <input type="text" value={numValue}/>
            
            <input type="button" value="2" 
                onClick={ (e) => {
                    const element = e.target as HTMLInputElement
                    setNumValue(numValue + parseInt(element.value))
                } 
            }/>
            <input type="button" value="+" 
                onClick={ (e) => {
                    const element = e.target as HTMLInputElement
                    setNumValue(numValue + element.value)
                } 
            }/>
            <input type="button" value="1" 
                onClick={ (e) => {
                    setNumValue(numValue + parseInt(e.target.value))
                } 
            }/>
            <button 
                onClick={ () => {
                    setNumValue(numValue)
                }
            }>test</button>
        </>
    )
}