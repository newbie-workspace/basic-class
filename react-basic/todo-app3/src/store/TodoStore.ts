import { create } from "zustand"
import { persist } from "zustand/middleware"
import { immer } from "zustand/middleware/immer"

interface TodoStoreState {
    todos:Todo[]
}

interface TodoStoreActions {
    addTodo:(title:string) => void
    toggleTodoState:(id:number) => void
    deleteTodo:(id:number) => void 
}

export const useTodoStore = create<TodoStoreState & TodoStoreActions>() (

    persist(    // 자동으로 local storage 에 저장 및 읽기 지원

        immer((set) => ({ // 불변성 지원 : 상태를 직접 변경할 수 있도록 도와주는 미들웨어

            todos:[],

            addTodo:(title) => set((state) => { // (title) => {state 를 사용해서 데이터 처리하는 코드}
                state.todos.push(
                    {id : new Date().getTime(), title : title, done: false}
                )
            }),
            
            toggleTodoState:(id) => set((state) => { // (id) => {state 를 사용해서 데이터 변경}
                state.todos = state.todos.map((todo) => 
                    todo.id === id ? {...todo, done:!todo.done} : todo)    
            }),
            
            deleteTodo:(id:number) => set((state) => {
                state.todos = state.todos.filter((todo) => todo.id !== id)
            }),

        })), // end of immer
        
        {
            name:"todos"
        }

    ) // end of persist

)