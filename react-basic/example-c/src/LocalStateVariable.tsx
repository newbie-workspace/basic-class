export default function LocalStateVariable() {

  let count :number = 0;

  return (
    <>

      <button onClick = { () => {
        count = count + 1
        console.log(count)
      }}>증가</button>
      <hr />
      <div>{count}</div>

    </>
  )
}