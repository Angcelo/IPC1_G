const fs = require('fs');

exports.registro = (req, res) => {
    try {
        const fileJuegos = fs.readFileSync('./juegos.json', 'utf8');
        const baseDatosJuegos = JSON.parse(fileJuegos);
        const { nombre, precio, stock } = req.body;
        if (!nombre || !precio || !stock) {
            return res.status(400).json({
                mensaje: "Debe ingresar un nombre, un precio y un stock",
                data: null,
            });
        }
        const nuevoJuego = {
            id: baseDatosJuegos.currentId++,
            nombre,
            precio,
            stock,
        }
        baseDatosJuegos.juegos.push(nuevoJuego);
        fs.writeFileSync('./juegos.json', JSON.stringify(baseDatosJuegos));
        res.status(201).json({
            mensaje: "Juego creado exitosamente",
            data: nuevoJuego,
        });
    } catch (error) {
        res.status(500).json({
            mensaje: "Error al crear el juego",
            data: null,
        });
    }
}

exports.listar = (req, res) => {
    try {
        const fileJuegos = fs.readFileSync('./juegos.json', 'utf8');
        const baseDatosJuegos = JSON.parse(fileJuegos);
        res.status(200).json({
            mensaje: "Juegos listados",
            data: baseDatosJuegos.juegos,
        });
    } catch (error) {
        res.status(500).json({
            mensaje: "Error al listar los juegos",
            data: null,
        });
    }
}

exports.comprar = (req, res) => {
    try {
        const fileJuegos = fs.readFileSync('./juegos.json', 'utf8');
        const baseDatosJuegos = JSON.parse(fileJuegos);

        const { id } = req.params;
        const { precio, idUsuario } = req.body;

        const juego = baseDatosJuegos.juegos.find(juego => juego.id == id && juego.stock > 0);

        if (!juego) {
            return res.status(404).json({
                mensaje: "Juego no encontrado",
                data: null,
            });
        }
        if (juego.precio != precio) {
            return res.status(400).json({
                mensaje: "El precio ingresado no es correcto",
                data: null,
            });
        }
        juego.stock--;
        const fileCompras = fs.readFileSync('./compras.json', 'utf8');
        const baseDatosCompras = JSON.parse(fileCompras);
        const nuevaCompra = {
            idUsuario: idUsuario,
            idJuego: juego.id,
            nombre: juego.nombre,
            precio: juego.precio,
            fecha: new Date(),
        }
        baseDatosCompras.push(nuevaCompra);
        fs.writeFileSync('./compras.json', JSON.stringify(baseDatosCompras));
        fs.writeFileSync('./juegos.json', JSON.stringify(baseDatosJuegos));
        res.status(200).json({
            mensaje: "Compra realizada",
            data: nuevaCompra,
        });
    } catch (error) {
        console.log(error);
        res.status(500).json({
            mensaje: "Error al realizar la compra",
            data: null,
        });
    }
}

exports.buscarPorId = (req, res) => {
    try {
        const fileJuegos = fs.readFileSync('./juegos.json', 'utf8');
        const baseDatosJuegos = JSON.parse(fileJuegos);
        const { id } = req.params;
        const juego = baseDatosJuegos.juegos.find(juego => juego.id == id);
        if (!juego) {
            return res.status(404).json({
                mensaje: "Juego no encontrado",
                data: null,
            });
        }
        res.status(200).json({
            mensaje: "Juego encontrado",
            data: juego,
        });
    } catch (error) {
        res.status(500).json({
            mensaje: "Error al buscar el juego",
            data: null,
        });
    }
}