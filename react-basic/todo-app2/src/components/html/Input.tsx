// Omit<React.ComponentPropsWithRef<"input">, "type"> : <input> 객체의 모든 속성 중 type만 빼고 속성의 타입 반환
// <input> 객체의 모든 속성 타입 + "type" 속성을 "text"로 제한한 새로운 타입 반환
type Inputprops = Omit<React.ComponentPropsWithRef<"input">, "type"> & { type?: "text" }

export default function Input(props: Inputprops) {
  const { ...rest } = props
  return (
    <input {...rest} />
  )
}