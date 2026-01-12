//import Button from "./component/html/Button";
//import CheckBox from "./component/html/CheckBox";
//import Input from "./component/html/Input";
// import SvgClose from "./component/svg/SvgClose";
// import SvgPencil from "./component/svg/SvgPencil";
import { useState } from "react";
import TodoEditor from "./component/TodoEditor";
import TodoHeader from "./component/TodoHeader";
import TodoList from "./component/TodoList";

export default function App() {
//   const initData = [
//   {id:1, title:"rest", done:false},
//   {id:2, title:"rest2", done:false},
//   {id:3, title:"rest3", done:false}
// ]
  const [todos, setTodos] = useState<Todo[]>([])
  const addTodo = (title : string) => {
    const todo = {id : new Date().getTime(), title : title, done: false}
    //todos.push(todo)
    setTodos([...todos, todo]) // [todos[0], todos[1], ..., todos[n-1], todo]
  } 
  
  const toggleTodoState = (id:number) => {
    const tempTodos = todos.map( (todo) =>  todo.id === id ? { ...todo, done: !todo.done } : todo )
    setTodos(tempTodos)
  }

  const deleteTodo = (id:number) => {
    const tempTodos = todos.filter((todo) => todo.id !== id)
    setTodos(tempTodos)
  }

  return (
    <div className="todo">
      <TodoHeader />
      {/* 할 일 등록 */}
      <TodoEditor addTodo={addTodo}/>
      {/* 할 일 목록 */}
      <TodoList todos = {todos} toggleTodoState = {toggleTodoState} deleteTodo = {deleteTodo}/>
    </div>
  );
}
