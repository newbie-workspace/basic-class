import { Route } from "react-router"
import { Routes } from "react-router"
import RootLayout from "./pages/RootLayout"
import Home from "./pages/Home"
import About from "./pages/About"
import Dashboard from "./pages/Dashboard"
import Summary from "./pages/Summary"
import Settings from "./pages/Settings"
import './App.css'
import Team from "./pages/Team"

function App() {

  return (
    <>
      <Routes>
        <Route element={<RootLayout />}>
          <Route path="/" element={<Home />} />
          <Route path="about" element={<About />} />
          <Route path="team/:teamId/group/:groupId" element={<Team />} />
          <Route path="dashboard" element={<Dashboard />}>
            <Route index element={<Summary />} />
            <Route path="settings" element={<Settings />} />
          </Route>
          <Route path="*" element={<Home />} />
        </Route>
        
      </Routes>
    </>
  )

}

export default App
