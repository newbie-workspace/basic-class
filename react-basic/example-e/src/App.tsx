import './App.css'
import style from './App.module.css' // style : 변수 ??
import StyledComponent1 from './component/StyledComponent1'
import StyledComponent2 from './component/StyledComponent2'
import StyledComponent3 from './component/StyledComponent3'

function App() {
  
  return (
    <>
      <StyledComponent1 />
      <StyledComponent2 />
      <button className="btn">parent component button</button>
      <StyledComponent3 />
      <br />
      <button className={style.btn2}>parent component button2 </button>
    </>
  )

}

export default App
