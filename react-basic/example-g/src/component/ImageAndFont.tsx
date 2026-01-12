import asdf2 from "../assets/asdf2.jpg"
export default function ImageAndFont() {
    return(
        <>
            <h1 className="SF_HambakSnow">이미지와 폰트 적용 스타일</h1>
            <img src="/assets/asdf.jpg" alt="" />
            <br /><hr />
            <img src={asdf2} alt="" />
        </>
    )
}