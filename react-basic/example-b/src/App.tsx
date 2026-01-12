import './App.css'
import ClassComponent from './ClassComponent'
import ClassComponent2 from './ClassComponent2'
import FunctionComponent from './FunctionComponent'
import FunctionComponent2 from './FunctionComponent2'

function App() {
  return (
    
    <>
      <ClassComponent name="Bertram Tung" email="btung@schrecknet.vtm" />
      <hr />
      <ClassComponent2 />
      <hr />
      <FunctionComponent phone="123-1234-1234" age={22} />
      <hr />
      <FunctionComponent2>
        <p>jeanette</p>  
        <p>therese</p>
        <p>lacroix</p>
      </FunctionComponent2> 
    </>

  )
}

export default App
