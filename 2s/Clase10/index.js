const express = require('express');
const cors = require('cors');
const morgan = require('morgan');
const app = express();
const fs = require('fs');

const usuarios = require('./usuarios.json');

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

app.post("/login",(req,res)=>{
    console.log(req.body);
    const {nombre, contrasenna} = req.body; 
    let file = fs.readFileSync('./usuarios.json', 'utf8');
    let usuarioJS = JSON.parse(file)
    for(let i = 0; i < usuarioJS.length; i++){
        if(usuarioJS[i].nombre.toLowerCase() == nombre.toLowerCase() && usuarioJS[i].contrasenna == contrasenna){
            res.status(200).json({
                mensaje: "Bienvenido",
                data: usuarioJS[i].nombre
            })
            return;
        } 
    }
    res.status(401).json({
        mensaje: "Usuario o contraseña incorrectos",
        data: null
    })
})

app.get("/usuarios", (req, res) => {
    let file = fs.readFileSync('./usuarios.json', 'utf8');
    let usuarioJS = JSON.parse(file)
    res.status(200).json({
        mensaje: "Usuarios",
        data: usuarioJS
    })
})

app.listen(3030, () => {
    console.log("Servidor corriendo en el puerto 3030");
})