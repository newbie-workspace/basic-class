import { useState, type FormEvent } from "react";
import Button from "./html/Button";
import Input from "./html/Input";
import { useTodoStore } from "../store/TodoStore";

export default function TodoEditor() {

  //const { addTodo } = props => Zustand 이용해서 props 대체
  const addTodo = useTodoStore((state) => state.addTodo)
  const [title, setTitle] = useState("")
  const handleSubmit = (e: FormEvent) => {
    e.preventDefault() // 이 이벤트와 관련된 기본 동작 수행 막기 (여기서는 submit) 
    if (title.trim().length == 0) { alert("아무 것도 없는 todo 등록 불가"); return }
    addTodo(title)
    setTitle("")
  }
  return (
    <form className="todo__form" onSubmit={handleSubmit}>
      <div className="todo__editor">
        <Input
          type="text"
          value={title}
          onChange={e => setTitle(e.target.value)}
          className="todo__input"
          placeholder="Enter Todo List"
        />
        <Button className="todo__button" type="submit">
          Add
        </Button>
      </div>
    </form>
  )
}