import { Outlet } from "react-router";

export default function Dashboard() {
  return (
    <>
      <h1>Dashboard</h1>
      <Outlet /> {/* 하위 컴포넌트가 표시되는 영역, 중첩 컴포넌트 사용을 위해 필요 */}
    </>
  );
}
