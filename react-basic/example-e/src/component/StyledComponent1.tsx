export default function StyledComponent1() {
    return (
        <>
            <h1 
                style={{
                backgroundColor: 'blue',
                color: 'white',
                fontSize: '16px',
                padding: '10px'
                }} // { css 가 아니라 json 객체 }

            >스타일이적용된요소</h1>
        </>
    )
}