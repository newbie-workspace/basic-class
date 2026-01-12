import './App.css'
import Count from './components/Count'
import CountOutsideDisplay from './components/CountOutsideDisplay'
//import AutoSaveForm from './components/AutoSaveForm'
import LifeCycle from './components/LifeCycle'
import { useState } from 'react'

function App() {
  
  const [visible, setVisible] = useState(true)

  return (
    <>
      {visible && <LifeCycle />}
      <br />
      <button onClick = {() => setVisible(!visible)}>표시 전환</button>
      {/* <AutoSaveForm /> */}

      <hr />

      <Count />
      <CountOutsideDisplay />

    </>
  )
  
}

export default App
