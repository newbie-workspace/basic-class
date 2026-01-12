import { useEffect, useState } from "react"
import TodoEditor from "./components/TodoEditor"
import TodoHeader from "./components/TodoHeader"
import TodoList from "./components/TodoList"

function App() {

  const strTodos = localStorage.getItem('todos');
  const tempTodos:Todo[] = strTodos ? JSON.parse(strTodos) : []; // JSON.parse : string -> JSON Object
  const [todos, setTodos] = useState<Todo[]>(tempTodos);

  const addTodo = (title:string) => {
    const todo = { id: new Date().getTime(), title: title, done: false }
    //todos.push(todo)
    setTodos([...todos, todo]) // [todos[0], todos[1], ... todos[n-1], todo]
  }

  const toggleTodoState = (id:number) => {
    const tempTodos = todos.map( (todo) => todo.id === id ? { ...todo, done: !todo.done } : todo )
    setTodos(tempTodos)
  }

  const deleteTodo = (id:number) => {
    const tempTodos = todos.filter( (todo) => todo.id !== id )
    setTodos(tempTodos)
  }

  useEffect( () => {
    const strTodos = JSON.stringify(todos);// JSON.stringify : JSON Object -> string
    localStorage.setItem('todos', strTodos);
  }, [todos]);

  return (
    <div className="todo">
      <TodoHeader />
      {/* 할 일 등록 */}
      <TodoEditor addTodo={addTodo} />
      {/* 할 일 목록 */}
      <TodoList todos={todos} toggleTodoState={toggleTodoState} deleteTodo={deleteTodo} />
      
    </div>   
  )
}

export default App
