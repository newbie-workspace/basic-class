export default function StyledComponent2() {

    const style = {
                    backgroundColor: 'black',
                    color: 'white',
                    fontSize: '16px',
                    padding: '10px'
    }

    return (
        <>
            <h1 
                style={style} // { css 가 아니라 json 객체 }
            >스타일이적용된요소</h1>
        </>
    )
    
}