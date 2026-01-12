import { useState } from "react"
import "./img.css"

export default function Practice() {

    const imgIndex:number[] = [1, 2, 3, 4, 5]
    const [num, setNum] = useState(1)

    return(
        <>
            <table>
            
                <tr>

                    {

                    imgIndex.map((n, idx) => 

                        <td key={idx} onClick={ () => {setNum(n)} }>

                            <img className="imgs" src={`/public/assets/${n}.jpg`} alt="" />

                        </td>

                    )}
                    
                </tr>
            </table>
            
            <hr /><hr />

            <img className="imgs" src={`/public/assets/${num}.jpg`} alt="" />
        </>
    )
}