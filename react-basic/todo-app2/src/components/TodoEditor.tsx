import { useState, type FormEvent } from "react";
import Button from "./html/Button";
import Input from "./html/Input";

export default function TodoEditor(props:{addTodo:(title:string) => void}) {

  const { addTodo } = props;
  const [title, setTitle] = useState("")

  const handleSubmit = (event: FormEvent) => {
    event.preventDefault() // 이 이벤트와 관련된 기본 동작 수행 막기 (여기서는 submit)
    if (title.trim().length == 0) {
      alert('할 일을 입력하세요')
      return
    }
    addTodo(title)
    setTitle("")
  }

  return (
    <form className="todo__form" onSubmit={handleSubmit}>
      <div className="todo__editor">
        <Input
          type="text"
          value={title}
          onChange={ (event) => setTitle(event.target.value) }
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