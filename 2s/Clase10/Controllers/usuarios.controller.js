const fs = require('fs');

exports.obtenerUsuarios = (req, res) => {
    try {
        const fileUsuarios = fs.readFileSync('./usuarios.json', 'utf8');
        const baseDatosUsuario = JSON.parse(fileUsuarios);
        res.status(200).json({
            mensaje: "Usuarios obtenidos correctamente",
            data: baseDatosUsuario.usuarios
        })
    } catch (error) {
        console.log(error);
        res.status(500).json({
            mensaje: "Error interno del servidor",
            data: null,
        });
    }
}

exports.registro = (req, res) => {
    try {
        const fileUsuarios = fs.readFileSync('./usuarios.json', 'utf8');
        const baseDatosUsuario = JSON.parse(fileUsuarios);
        const { nombre, contrasenna } = req.body;
        if (!nombre && !contrasenna) {
            return res.status(400).json({
                mensaje: "Debe ingresar un nombre y una contraseña",
                data: null,
            });
        }
        if (contrasenna.length < 8) {
            return res.status(400).json({
                mensaje: "La contraseña debe tener al menos 8 caracteres",
                data: null,
            });
        }
        const usuario = {
            id: baseDatosUsuario.currentId++,
            nombre,
            contrasenna
        }
        baseDatosUsuario.usuarios.push(usuario);
        const usuariosJSON = JSON.stringify(baseDatosUsuario);
        fs.writeFileSync('./usuarios.json', usuariosJSON);
        res.status(201).json({
            mensaje: "Usuario creado",
            data: usuario.nombre
        })
    } catch (error) {
        console.log(error);
        res.status(500).json({
            mensaje: "Error interno del servidor",
            data: null,
        });
    }
}

exports.login = (req, res) => {
    try {
        const fileUsuarios = fs.readFileSync('./usuarios.json', 'utf8');
        const baseDatosUsuario = JSON.parse(fileUsuarios);
        const { nombre, contrasenna } = req.body;
        if (!nombre || !contrasenna) {
            return res.status(400).json({
                mensaje: "Debe ingresar un nombre y una contraseña",
                data: null,
            });
        }
        const usuario = baseDatosUsuario.usuarios.find(usuario => usuario.nombre.toLowerCase() == nombre.toLowerCase());

        if (usuario) {
            if (usuario.contrasenna == contrasenna) {
                res.status(200).json({
                    mensaje: "Usuario logueado",
                    data: {
                        idUsuario: usuario.id,
                        nombre: usuario.nombre
                    }
                })
            } else {
                res.status(400).json({
                    mensaje: "Contraseña incorrecta",
                    data: null
                })
            }
        } else {
            res.status(400).json({
                mensaje: "Usuario no encontrado",
                data: null
            })
        }
    } catch (error) {
        console.log(error);
        res.status(500).json({
            mensaje: "Error interno del servidor",
            data: null,
        });
    }
}

exports.usuarioPorId = (req, res) => {
    try {
        const fileUsuarios = fs.readFileSync('./usuarios.json', 'utf8');
        const baseDatosUsuario = JSON.parse(fileUsuarios);
        const { id } = req.params;

        for (let i = 0; i < baseDatosUsuario.usuarios.length; i++) {
            if (baseDatosUsuario.usuarios[i].id == id) {
                res.status(200).json({
                    mensaje: "Usuario encontrado",
                    data: baseDatosUsuario.usuarios[i]
                })
                return;
            }
        }
    } catch (error) {
        console.log(error);
        res.status(500).json({
            mensaje: "Error interno del servidor",
            data: null,
        });
    }
}