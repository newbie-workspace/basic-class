// Omit<React.ComponentPropsWithRef<"input">, "type"> : <input> 객체의 모든 속성 중 type만 빼고 속성의 타입 반환
// <input> 객체의 모든 속성 타입 + "type" 속성을 "checkbox"로 제한하고 parentClassName 속성을 추가한 새로운 타입 반환
type CheckBoxProps = Omit<React.ComponentPropsWithRef<"input">, "type"> & {
  type?: "checkbox";
  parentClassName: string;
};

export default function CheckBox(props: CheckBoxProps) {
  const { parentClassName, children, ...rest } = props;
  return (
    <div className={parentClassName}>
      <input {...rest} />
      <label>{children}</label>
    </div>
  );
}