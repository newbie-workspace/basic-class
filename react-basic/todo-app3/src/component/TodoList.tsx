// import Button from "./html/Button";
// import CheckBox from "./html/CheckBox";
// import SvgClose from "./svg/SvgClose";
// import SvgPencil from "./svg/SvgPencil";

import { useTodoStore } from "../store/TodoStore";
import TodoListEmptyItem from "./TodoListEmptyItem";
import TodoListItem from "./TodoListItem";

export default function TodoList() {
  
  const todos = useTodoStore((state) => state.todos)
  
    return (
      <ul className="todo__list">
        {/* 할 일 목록이 없을 때 */}
        {todos.length === 0 && <TodoListEmptyItem />}
        {/* 할 일 목록이 있을 때 */}
        {/* 할 일이 완료되면 .todo__item--complete 추가 */}
        {todos.length > 0 && todos.map((todo) => <TodoListItem todo={todo} />)}
      </ul>
    );
  }