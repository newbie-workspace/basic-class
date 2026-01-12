// export default function FunctionComponent(props:{phone:string, age:number}) {

//     return (
//         <>
//             <h2>클래스 컴포넌트</h2>
//             <h3>phone : {props.phone}</h3>
//             <h3>age : {props.age}</h3>
            
//         </>
//     )

// }
export default function FunctionComponent(props:{phone:string, age:number}) {

    const {phone, age} = props;
    return (
        <>
            <h2>함수 컴포넌트</h2>
            <h3>phone : {phone}</h3>
            <h3>age : {age}</h3>
            <button onClick={ () => alert("[" + phone + "]" + "[" + age + "]")}>click</button>
            
        </>
    )

}
// export default function FunctionComponent({phone, age}:{phone:string, age:number}) { //전달인자 수준에서 destructuring

//     return (
//         <>
//             <h2>클래스 컴포넌트</h2>
//             <h3>phone : {phone}</h3>
//             <h3>age : {age}</h3>
            
//         </>
//     )

// }