const { createProxyMiddleware } = require('http-proxy-middleware');
const cors = require('cors');
const express = require('express');

const app = express();

app.use(cors({
  origin: [
    'http://127.0.0.1:5500',
    'http://localhost:5500'
  ],
  credentials: true
}));

app.use(
  '/api',
  createProxyMiddleware({
    target: 'https://openapi.naver.com',   // API you want to access
    changeOrigin: true,
    secure: false,
  })
);

app.use(
  '/api2',
  createProxyMiddleware({
    target: 'https://api.kcisa.kr',   // API you want to access
    changeOrigin: true,
    secure: false,
  })
);

app.use(
  '/api3',
  createProxyMiddleware({
    target: 'https://kosis.kr',   // API you want to access
    changeOrigin: true,
    secure: false,
  })
);


app.listen(3001, () => {
  console.log('Proxy server running on http://localhost:3001');
});
