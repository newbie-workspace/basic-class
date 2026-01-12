import { useState } from "react"

export default function ImageSelection() {

    const images = [1, 2, 3, 4, 5].map( (v) => `/public/assets/${v}.jpg` )
    const imgStyle = {
        width: "170px",
        height: "170px"        
    }
    const [imageSrc, setImageSrc] = useState(images[0])
    return(
        <>
            <table>

                <tr>
                    {
                        images.map( (v) => <td><img style={imgStyle} 
                                                    src={v} 
                                                    onClick={(e) => {
                                                        const element = e.target as HTMLImageElement
                                                        setImageSrc(element.src)
                                                    }}                              
                                                /></td> )
                    }
                </tr>

            </table>
            <img src={imageSrc} style={{width: "950px"}} alt="" />
        </>
    )

}