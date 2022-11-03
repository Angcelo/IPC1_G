const express = require('express');
const { listar, registro, comprar, buscarPorId } = require('../Controllers/ventas.controller');
const router = express.Router();

router.get('/', listar)
router.get('/:id', buscarPorId)
router.post('/comprar/:id', comprar )
router.post('/registro', registro);

exports.router = router;