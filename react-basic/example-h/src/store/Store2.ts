import { create } from "zustand";

interface CounterStoreState {
  count: number;
  increment: () => void;
  decrement: () => void;
  reset: () => void;
  resetIfEven: () => void;
}

// create : 전역 상태 저장소와 저장소의 데이터를 읽고 (get) 쓸 수 (set) 있는 함수를 만들어서 제공 
// 읽기 및 쓰기 함수를 사용해서 커스텀 상태 관리 로직을 구현해서 훅으로 반환
export const useCounterStore = create<CounterStoreState>((set, get) => ({
  count: 0,
  increment: () => set((state) => ({ count: state.count + 1 })), // 기존 상태 기반
  decrement: () => set((state) => ({ count: state.count - 1 })), // 기존 상태 기반
  reset: () => set({ count: 0 }), // 새 상태 직접 지정
  resetIfEven: () => {
    const { count } = get();
    if (count % 2 === 0) {
      set({ count: 0 });
    }
  },
}));
