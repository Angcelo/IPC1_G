const express = require('express');
const router = express.Router();
const { registro, login, usuarioPorId, obtenerUsuarios } = require('../controllers/usuarios.controller');

router.get('/', obtenerUsuarios);
router.post('/registro', registro);
router.post('/login', login);
router.get('/:id', usuarioPorId);

exports.router = router;