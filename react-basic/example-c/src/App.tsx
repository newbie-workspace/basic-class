import { useState } from 'react'
import './App.css'
import ComponentStateVariable from './ComponentStateVariable'
import Decrease from './Decrease'
import Increase from './Increase'
import LocalStateVariable from './LocalStateVariable'

function App() {

  const [count, setCount] = useState(0) // 두 개 이상의 컴포넌트가 같은 값을 쓰려면 상위 컴포넌트에 선언되어야 함.

  return (
    <>
    <table>
      <tr>
        <td><LocalStateVariable /></td>
        <td><ComponentStateVariable /></td>
      </tr>
    </table>
    <hr />
    <table>
      <tr>
        <td><Increase setCount={setCount}/></td>
        <td><Decrease setCount={setCount}/></td>
      </tr>
      <tr>
        <th colSpan ={2}>{count}</th>        
      </tr>
    </table>
      
      
    </>
  )
}
export default App
