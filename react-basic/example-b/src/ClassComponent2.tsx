import {Component} from "react";

//react에서 만든 Component 클래스를 상속해서 ClassComponent 만들기
class ClassComponent2 extends Component {

    render() {
        
        return (

            <>
                <h2>클래스 컴포넌트 2</h2>
                <button onClick={ () => alert("123456")}>누르기</button>
            </>

        )

    }

}

export default ClassComponent2 // ClassComponent 를 외부에서 사용할 수 있도록 개방