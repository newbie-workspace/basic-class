import { useState } from "react"

export default function CurrencyExchange() {
    
    const [from, setFrom] = useState("won")
    const [to, setTo] = useState("dollar")
    const [fromValue, setFromValue] =useState("")
    const [toValue, setToValue] =useState("")

    const exchangeRate: Record<string,number> = { //Record<string,number> key는 string, value는 number인 json type

        "won_to_dollar" : 0.00068,
        "won_to_yen" : 0.11,
        "won_to_won" : 1,
        "yen_to_won" : 9.4,
        "yen_to_dollar" : 0.0064,
        "yen_to_yen" : 1,
        "dollar_to_dollar" : 1,
        "dollar_to_won" : 1467,
        "dollar_to_yen": 156

    }
    
    return(
        <>
            <table>
                <tbody>
                    <tr>
                        <td>
                            <select value={from} onChange={(e) => {
                                setFrom(e.target.value)
                            }}>
                                <option value = "won">won</option>
                                <option value = "dollar">dollar</option>
                                <option value = "yen">yen</option>
                            </select>
                            <br />
                            <input type="text" value={fromValue} onChange={(e) => {
                                setFromValue(e.target.value)
                            }}/>
                        </td>
                        <td><button 
                            onClick={() => {
                                //if(fromValue.length == 0) {
                                if(fromValue.length == 0 || isNaN(Number(fromValue)) == true) { //숫자로 변환할 수 없으면
                                    alert('값을 입력')
                                    return
                                }
                                const exchangeRateKey = `${from}_to_${to}`
                                setToValue((parseFloat(fromValue) * exchangeRate[exchangeRateKey]).toString())
                            }}> 변환 </button></td>
                        <td>
                            <select value={to} onChange={(e) => {
                                setTo(e.target.value)
                            }}>
                                <option value = "won">won</option>
                                <option value = "dollar">dollar</option>
                                <option value = "yen">yen</option>
                            </select>
                            <br />
                            <input type="text" value={toValue} readOnly />
                        </td>
                    </tr>
                </tbody>
            </table>
        </>
    )
}