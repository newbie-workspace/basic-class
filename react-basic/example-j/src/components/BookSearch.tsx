import axios from "axios"
import { useState } from "react"

export default function BookSearch() {

    const [books, setBooks] = useState("")
    const searchBook = async() => {
        //const url = "https://openapi.naver.com/v1/search/book.json"
        const url = "/naver/v1/search/book.json"
        const query = "리액트"
        const clientId = "jWSAH_Gp6qy5RZjx5rta"
        const clientSecret = "RjWlPUhnxI"
        const response = await axios.get(`${url}?query=${query}`, 
            {headers: {'X-Naver-Client-Id':clientId, 'X-Naver-Client-Secret': clientSecret}}
        )
        setBooks(JSON.stringify(response.data))
    }

    return( 
        <>
        <button onClick={searchBook}> 책 검색 </button>
        <hr />
        <div>
            {books ? books : "검색 버튼"}
        </div>
        </>
    )

}