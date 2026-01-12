import { Link, NavLink, Outlet } from "react-router";
export default function RootLayout() {
    return (
        <>
            <header>Header</header>
            <nav>
                <Link to="/">Home</Link>
                &nbsp;|&nbsp;
                <NavLink to="/about" className={({ isActive }) => (isActive ? "active" : "")} >
                    About
                </NavLink>
                &nbsp;|&nbsp;
                <NavLink to="/team/team-agogo/group/csr1">
                    Team
                </NavLink>
                &nbsp;|&nbsp;                
                <NavLink to="/dashboard" style={({ isActive }) => ({ color: isActive ? "red" : "black" })} >
                    Dashboard
                </NavLink>
                &nbsp;|&nbsp;
                <NavLink to="/dashboard/settings">
                    {({ isActive }) => <span>settings({isActive && "selected"})</span>}
                </NavLink>
            </nav>
            <Outlet />
            <footer>Footer</footer>
        </>
    );
}