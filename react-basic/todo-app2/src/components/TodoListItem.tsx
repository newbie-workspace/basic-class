import Button from "./html/Button";
import CheckBox from "./html/CheckBox";
import SvgClose from "./svg/SvgClose";
import SvgPencil from "./svg/SvgPencil";

export default function TodoListItem(
  props:{todo:Todo, toggleTodoState:(id:number) => void, deleteTodo:(id:number) => void}) {

  const { todo, toggleTodoState, deleteTodo } =  props

  return (
    <li className={`todo__item ${ todo.done && 'todo__item--complete' }`}>
      <div className="todo__checkbox-group">
        <CheckBox
          type="checkbox"
          parentClassName="todo__checkbox--group"
          className="todo__checkbox"
          checked={todo.done}
          onChange={ () => toggleTodoState(todo.id) }
        />
        <label>{todo.title}</label>
      </div>
      {/* 할 일을 수정할 때만 노출 (.todo__checkbox-group은 비노출) */}
      {/* <Input type="text" className="todo__modify-input" /> */}
      <div className="todo__button-group">
        <Button className="todo__action-button">
          <SvgPencil />
        </Button>
        <Button className="todo__action-button"
                onClick={ () => deleteTodo(todo.id) }>
          <SvgClose />
        </Button>
      </div>
    </li>

  )
}