// import type { ReactNode } from "react";

// Buttonprops = React.ComponentPropsWithRef<"button"> -> <button> 객체의 모든 속성에 대한 자료형(타입)을 반환하는 함수

type Buttonprops = React.ComponentPropsWithRef<"button">;

export default function Button(props: Buttonprops) {
// export default function Button(props: { children: ReactNode[], className: string, onClick: () => void}) {
  const { children, ...rest } = props;
  return (
    <button {...rest}>
      {children}
    </button>
  )
}