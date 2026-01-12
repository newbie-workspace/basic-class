import axios from "axios"
import { useState } from "react"

export default function HttpRequestDemo() {

    const[post, setPost] = useState("")

    const clickHandler1 = () => {
        const id = Math.floor(Math.random() * 100 + 1)
        fetch(`https://jsonplaceholder.typicode.com/posts/${id}`)
           .then(response => response.json())
            .then(data => 
                setPost( JSON.stringify(data))
            )
    }

    const clickHandler2 = async () => {
        const id = Math.floor(Math.random() * 100 + 1)
        const response = await fetch(`https://jsonplaceholder.typicode.com/posts/${id}`)
        const data = await response.json()
        setPost(JSON.stringify(data))    
    }

    const clickHandler3 = () => {
        const id = Math.floor(Math.random() * 100 + 1)
        axios.get(`https://jsonplaceholder.typicode.com/posts/${id}`)
            .then(response => {
                setPost(JSON.stringify(response.data))
            })
    }

    const clickHandler4 = async () => {
        const id = Math.floor(Math.random() * 100 + 1)
        const response = await axios.get(`https://jsonplaceholder.typicode.com/posts/${id}`)
            setPost(JSON.stringify(response.data))
            
    }

    return(
        <>
            <button onClick={clickHandler1}> 데이터 가져오기 1 </button>
            <button onClick={clickHandler2}> 데이터 가져오기 2 </button>
            <button onClick={clickHandler3}> 데이터 가져오기 3 </button>
            <button onClick={clickHandler4}> 데이터 가져오기 4 </button>
            <hr />
            <div>
                {post ? post : "위 버튼을 클릭"}
            </div>
        </>
    )

}