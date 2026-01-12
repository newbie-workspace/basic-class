import { useState } from "react";

export default function NumberGenerator() {

    const [numbers, setNumbers] = useState<number[]>([0, 0, 0, 0, 0, 0])
    const [average, setAverage] = useState(0)

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
                            {/*alert(numbers[0] + "/" + numbers[1] + "/" + numbers[2] + "/" + numbers[3] + "/" + numbers[4] + "/" + numbers[5])*/}
                            setNumbers(numbers2)

                            let total = 0
                            numbers2.forEach( (number) => total += number)
                            setAverage( Math.floor(total / numbers2.length))

                        }}>G e n e r a t e</button>

                    </td>
                </tr>
                <tr>
                    {
                        numbers.map((number, idx) => <td key={idx}>&nbsp;{number}&nbsp;</td>) 
                        // 동적으로 생성되는 요소는 고유한 key 속성 값을 지정해야 함
                    }                          
                    <td>Average : {average}</td>
                </tr>
            </table>
        </>
    )
}