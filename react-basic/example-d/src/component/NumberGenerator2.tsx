import { useState } from "react";

export default function NumberGenerator2() {

    const [numbersInfo, setNumbersInfo] = useState({numbers:[0,0,0,0,0,0], average: 0})

    return(
        <>
            <table>
                <tr>
                    <td colSpan = {7}>

                        <button onClick={ () => {

                            const numbers2 = new Array(6)
                            for (let i = 0; i < 6; i++) {
                                numbers2[i] = Math.floor(Math.random() * 45 + 1)
                                for ( let j = 0; j < i; j++) {
                                    if (numbers2[i] == numbers2[j]) {
                                        i--;
                                        break;
                                    }
                                }
                            }        
                            numbers2.sort( (a, b) => a - b)  
                            
                            let total = 0
                            numbers2.forEach( (number) => total += number)
                            const average = ( Math.floor(total / numbers2.length))

                            setNumbersInfo({numbers: numbers2, average: average})

                        }}>G e n e r a t e</button>

                    </td>
                </tr>
                <tr>
                    {
                        numbersInfo.numbers.map((number, idx) => <td key={idx}>&nbsp;{number}&nbsp;</td>) 
                        // 동적으로 생성되는 요소는 고유한 key 속성 값을 지정해야 함
                    }                          
                    <td>Average : {numbersInfo.average}</td>
                </tr>
            </table>
        </>
    )
}