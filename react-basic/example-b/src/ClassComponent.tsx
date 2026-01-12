import {Component} from "react";

//react에서 만든 Component 클래스를 상속해서 ClassComponent 만들기
// Component (name:string,email:string} -> props 에는 string 형식의 name 과 email만 저장할수 있다는 표시
class ClassComponent extends Component <{name:string, email:string}> { 
    render() {

        // const name = this.props.name 
        // const email = this.props.email
        const {name, email} = this.props; //props.email 은 email 변수에 props.name 은 name 변수에 저장

        return (
            <>
                <h2>클래스 컴포넌트</h2>
                <h3>이름 : {name}</h3>
                <h3>이메일 : {email}</h3>
            </>
        )

    }
}

export default ClassComponent // ClassComponent 를 외부에서 사용할 수 있도록 개방