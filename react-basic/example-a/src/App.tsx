import './App.css'
function App() {
  const name:string = "John Doe" 
  const active:boolean = true;
  const style ={
    color: "red"
  }
  return ( //jsx 시작
    <> // 이 줄은 주석이 아님.
       {/* jsx 안의 영역에서 주석*/}
      <h4 className="blue-text">반환하는 내용의</h4>
      <h4 style={style}>최상위 요소는 한 개만 가능</h4>
      <input type="text" /> 
      <h2 />
      <input type="text" tabIndex={1} />
      <h2>Hello, {name}</h2>
      <h2>{active ? "활성 사용자" : "비활성사용자"}</h2>
      <div style={{fontSize:20,fontWeight:"bolder",backgroundColor:"lightgrey"}}>스타일적용</div>

      <div
       //여기서 javascript의 주석은?;
      >주석 특이 사항
      </div>
    </>
  )
  // 종료 태그 반드시 필요
  // 태그 안에 속성 이름 camel식 표기
  // 데이터 {} 안에
  // style={} 안에 json 객체 표현 {} => style={{d}}
  // 삼항연산자 {a ? b : c } a가 true 이면 b false 이면 c
}
export default App
