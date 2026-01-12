import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode> {/* StrickMode : 안전한 환경에서 실행 */}
    <App />
  </StrictMode>,
)
