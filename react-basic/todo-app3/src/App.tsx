//import Button from "./component/html/Button";
//import CheckBox from "./component/html/CheckBox";
//import Input from "./component/html/Input";
// import SvgClose from "./component/svg/SvgClose";
// import SvgPencil from "./component/svg/SvgPencil";
import TodoEditor from "./component/TodoEditor";
import TodoHeader from "./component/TodoHeader";
import TodoList from "./component/TodoList";

export default function App() {

  return (
    <div className="todo">
      <TodoHeader />
      {/* 할 일 등록 */}
      <TodoEditor />
      {/* 할 일 목록 */}
      <TodoList />
    </div>
  );
}
