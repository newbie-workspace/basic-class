import { useState } from "react"

let timerId = 0 // rerendering 되더라도 변화가 없도록 밖에다가 선언

export default function Clock0() {
    const [dateTime, setDateTime] = useState(new Date())
    
    // useState : React 관리 영역에 변수와 함수를 만들고 배열 [변수, 함수] 로 리턴 -> const[a, b] 로 받음.
    return (
        
        <>
            <table>
                <tr>
                    <td>
                        {dateTime.toLocaleDateString()}&nbsp;&nbsp;{dateTime.toLocaleTimeString()}
                    </td>
                </tr>
                <tr>
                    <td>
                    <button onClick={ () => {
                        if(timerId != 0) {
                            return;
                        }
                        timerId = window.setInterval( () => {
                            setDateTime(new Date()) // dateTime 상태 변수 변경 => 화면 갱신
                        },1000)    
                    }}>ON</button>
                    <button onClick={ () => {
                        window.clearInterval(timerId)
                        timerId = 0
                    }}>OFF</button>
                    </td>
                </tr>
            </table>
        </>

    )
}