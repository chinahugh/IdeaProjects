const express = require('express')
const path = require('path')
const app = express()

app.use(express.static(path.join(__dirname, '/')))


app.listen(80, function() {   //监听http://127.0.0.1:3000端口
    console.log("server start http://127.0.0.1:80/index.html");
});