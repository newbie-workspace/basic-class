import { create } from "zustand";

import {
  persist,
  subscribeWithSelector
} from "zustand/middleware";

import { immer }
  from "zustand/middleware/immer";

interface CounterStoreState {
  count: number;
  increment: () => void;
  decrement: () => void;
  reset: () => void;
  resetIfEven: () => void;
}

export const useCounterStore = create<CounterStoreState>()(
  
    subscribeWithSelector(
      persist(
        immer((set, get) => ({
          count: 0,
          increment: () => set((state) => { state.count += 1; }),
          decrement: () => set((state) => { state.count -= 1; }),
          reset: () => set((state) => { state.count = 0; }),
          resetIfEven: () => {
            const { count } = get();
            if (count % 2 === 0) {
              set((state) => (state.count = 0));
            }
          },
        })), // end of immer
        {
          name: "counter-store",
        }
      ) // end of persist
    ), // end of subscribeWithSelector
    
)
