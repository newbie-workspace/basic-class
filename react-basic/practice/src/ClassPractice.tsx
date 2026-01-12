import {Component} from "react";

class ClassPractice extends Component <{name:string, email:string}> {
    render() {

        const {name, email} = this.props;

        return (
            <>
                <h1>test, test, test</h1>     
                <h2>{name} : {email}</h2>           
            </>
        )
    }
}
export default ClassPractice