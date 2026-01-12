import { useState } from "react"

export default function Clock() {
    
    const [date, setDate] = useState(new Date()) // useState(null)을 쓰면, type을 정하지 못함.
    const [timerId, setTimerId] = useState(0)
    return (
        <>
                <table>
                    <tr>
                        <td colSpan={2}>{date.toString()}</td>
                    </tr>
                    <tr>
                        <td><button onClick={ () => {
                            const timerId0 = window.setInterval( function() {
                                const currentDate = new Date()
                                setDate(currentDate)
                                setTimerId(timerId0)
                            }, 1000)    
                            
                        }}>ON</button></td>

                        <td><button onClick={ () => {
                            window.clearInterval(timerId)
                        }}>OFF</button></td>
                    </tr>
                </table>
            
        </>
    )
}