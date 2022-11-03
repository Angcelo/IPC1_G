const express = require('express');
const cors = require('cors');
const morgan = require('morgan');
const app = express();

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(morgan('dev'));

const { router: usuariosRouter } = require('./routes/usuarios.routes');
const { router: ventasRouter } = require('./routes/ventas.routes');

app.use('/usuarios', usuariosRouter);
app.use('/ventas', ventasRouter);

app.get("/", (req, res) => {
    res.status(200).json(
        {
            mensaje: "Bienvenido a la API",
            data: null
        }
    )
})

app.listen(3030, () => {
    console.log("Servidor corriendo en el puerto 3030");
})