type CheckBoxProps = Omit<React.ComponentPropsWithRef<"input">, "type"> & {
  type?: "checkbox";
  parentClassName: string; // parentClassName 속성을 추가
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