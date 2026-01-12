import { useCounterStore } from "../store/Store";

export default function CountOutsideDisplay() {
   
    const count = useCounterStore((state) => state.count);
    
    return <h1>Outside Count: {count}</h1>;
}