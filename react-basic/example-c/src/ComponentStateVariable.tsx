import { useState } from "react"
export default function ComponentStateVariable() {

  const [count, setCount] = useState(0)
  // useState : React 가 관리하는 상태 변수 만들기 (이 컴포넌트 에서만)
  // 반드시 값의 변경은 setCount 함수를 사용해야 함 ( 직접 변수의 값을 변경할 수는 없다. )
  // 가상 Document Object Model(DOM) 을 이용하기 때문에 직접 변경 불가능.
  // 두 개 이상의 컴포넌트가 같은 값을 쓰려면 상위 컴포넌트에 선언되어야 함.
  return (
    <>
  
      <button onClick = { () => {
        // setCount(count + 1)
        setCount( (n) => n + 1) 
      }}>증가</button>
      <hr />
      <div>{count}</div>

    </>
  )
}