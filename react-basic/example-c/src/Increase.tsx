type f = (prevCount : number) => number  // number 형 전달인자 prevCount 를 받아서 number 값을 반환하는 함수 타입
// type 만들기. 자료형에 대한 별칭을 만드는

export default function Increase(props : {setCount : (arg0 : f) => void}) {
// 두 개 이상의 컴포넌트가 같은 값을 쓰려면 상위 컴포넌트에 선언되어야 함.
  return (
    <>
  
      <button onClick = { () => { 
        props.setCount( (prevCount) => prevCount + 1)
      }}>증가</button>
      <hr />
     
    </>
  )
}