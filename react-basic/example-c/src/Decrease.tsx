
export default function Decrease(props : {setCount : React.Dispatch<React.SetStateAction<number>>}) {
// 두 개 이상의 컴포넌트가 같은 값을 쓰려면 상위 컴포넌트에 선언되어야 함.  
  return (
    <>
  
      <button onClick = { () => {  
        props.setCount( (prevCount) => prevCount - 1)
      }}>감소</button>
      <hr />
      
    </>
  )
}