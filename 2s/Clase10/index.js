const express = require('express');
const cors = require('cors');
const morgan = require('morgan');
const app = express();
const fs = require('fs');

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(morgan('dev'));

app.get("/", (req, res) => {
    console.log(req.query);
    var file = fs.readFileSync('datos.txt', 'utf8');
    var data = JSON.parse(file);
    res.status(200).json(
        {
            mensaje: "Hola Mundo",
            data: data
        }
    )
})
    
app.post("/", (req, res) => {
    console.log(req.body)
    res.status(201).json({
        mensaje: "Creado con exito",
        data:
        {
            datos: "no hay datos"
        }
    })
    //Guardar datos
    var file = fs.createWriteStream('datos.txt');
    file.on('error', function(err) { /* error handling */ });
    file.write(JSON.stringify(req.body));
    file.end();
})

app.listen(3000, () => {
    console.log('Server is running on port 3000');
})