import axios from "axios"
import { useState } from "react"

export default function NewsSearch() {

    const [news, setNews] = useState<newsObject[]>([])
    const searchNews = async() => {
        const url = "/naver/v1/search/news.json"
        const query = "음원 차트"
        const display = 8
        const sort = "sim"
        const clientId = "jWSAH_Gp6qy5RZjx5rta" // 보안 위험
        const clientSecret = "RjWlPUhnxI"       // 보안 위험
        const response = await axios.get(
            `${url}?query=${query}&display=${display}&sort=${sort}`, {headers: {'X-Naver-Client-Id':clientId, 'X-Naver-Client-Secret': clientSecret}}
        )
        setNews(response.data.items)
        

    }
    return(
        <>
        <button onClick={searchNews}>wefwef</button>
        <div>
            <table>
                
                <ul>
                    {
                        news.map((list, index) => (
                            <a href={list.link} target="_blank"><li key={index}>{list.title}</li></a>
                        )) 
                    }
                </ul>
                
            </table>
        </div>
        
        </>
    )
}