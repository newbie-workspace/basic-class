import { useEffect, useState } from "react";

export default function LifeCycle() {

    const [count, setCount] = useState(0);
    
    useEffect(() => {
        console.log("Mounted");
    }, []); // 빈 배열을 사용하면 마운트 될 때 한 번만 실행

    useEffect(() => {
        console.log(`Updated : ${count}`);
    }, [count]); // 배열에포함된값중어느하나라도변경되면호출

    useEffect(() => {
        // useEffect함수에서반환되는함수는언마운트시점에호출됨
        return () => {
            console.log("Unmounted");
        };
    }, []);

    return (
        <>
            <h1>Count: {count} </h1>
            <button onClick={() => setCount((count) => count + 1)}>증가</button>
        </>
    );

}

