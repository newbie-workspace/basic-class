

// export default function FunctionComponent2(props: {children : React.ReactNode}) {
//                                                     // children? : 이 변수는 없을 수도 있다. 를 표시
//     return (
//         <>
//             <h2>함수 컴포넌트 2</h2>
//             {
//                 props.children
//             }
//         </>
//     )

// }
export default function FunctionComponent2({children} : {children : React.ReactNode}) {
                                                    
    return (

        <>
            <h2>함수 컴포넌트 2</h2>
            {
                children
            }
        </>
        
    )

}