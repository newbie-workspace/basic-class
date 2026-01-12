// React.ComponentPropsWithRef<"button"> : <button> 객체의 모든 속성에 대한 타입 반환하는 함수
type Buttonprops = React.ComponentPropsWithRef<"button">

export default function Button(props: Buttonprops) {
  const { children, ...rest } = props
  return (
    <button {...rest}>
        {children}
    </button>
  )
}