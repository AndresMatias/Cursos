const http = require('node:http') // protocolo HTTP
const { findAvailablePort } = require('./10.free-port.js') //En el archivo 10.free-ports-js obtenog un puerto libre

console.log(process.env)

const desiredPort = process.env.PORT ?? 3000 //Varaible de entorno process.env.PORT

const server = http.createServer((req, res) => {
  console.log('request received')
  res.end('Hola mundo')
})

findAvailablePort(desiredPort).then(port => { //En el archivo 10.free-ports-js obtenog un puerto libre
  server.listen(port, () => {
    console.log(`server listening on port http://localhost:${port}`)
  })
})
