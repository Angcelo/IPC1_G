import axios from "axios";
import { useEffect, useState } from "react";
import { Container, Row, Col, InputGroup, Form, Button } from "react-bootstrap";
import { FaSearch } from 'react-icons/fa';
import { toast } from "react-toastify";
import Carta from "./Carta";
import Mensajes from "./Mensajes";

function About() {

    const [usuarios, setUsuarios] = useState([]);
    const [busqueda, setBusqueda] = useState('');
    const [filtrados, setFiltrados] = useState('');
    const [backgroundColor, setBackgroundColor] = useState('white');

    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    useEffect(() => {
        axios.get('http://localhost:3030/usuarios').then(res => {
            console.log(res.data.data);
            setUsuarios(res.data.data);
        }).catch(err => {
            console.log(err);
            toast.error(err, {
                theme: "colored"
            });
        })
        // fetch('http://localhost:3030/usuarios').then(res => {
        //     if (res.ok) {
        //         return res.json();
        //     } else {
        //         return Promise.reject("Fallo en la consulta");
        //     }
        // }).then(data => {
        //     console.log(data);
        //     setUsuarios(data.data);
        // }).catch(err => {
        //     alert(err);
        // })
    }, []);

    useEffect(() => {
        console.log("Busqueda: " + busqueda);
    }, [busqueda]);

    const onClick = () => {
        setBackgroundColor('red');
    }

    const handleChange = (e) => {
        switch (filtrados) {
            case '1':
                fetch('http://localhost:3030/usuarios/' + busqueda).then(res => {
                    if (res.ok) {
                        return res.json();
                    } else {
                        return Promise.reject("Fallo en la consulta");
                    }
                }).then(data => {
                    console.log(data);
                    setUsuarios(data.data);
                    if (busqueda === '') {
                        setBackgroundColor('white');
                    } else if (data.data.length === 0) {
                        setBackgroundColor('white');
                    } else {
                        setBackgroundColor(data.data[0].background);
                    }
                }).catch(err => {
                    alert(err);
                })
                break;
            case '2':
                fetch('http://localhost:3030/usuarios/contrasenna/' + busqueda).then(res => {
                    if (res.ok) {
                        return res.json();
                    } else {
                        return Promise.reject("Fallo en la consulta");
                    }
                }).then(data => {
                    console.log(data);
                    setUsuarios(data.data);
                }
                ).catch(err => {
                    alert(err);
                })
                break;
            default:
                alert("Seleccione un filtro correcto");
                break;
        }
    };


    return (
        <Container style={{ backgroundColor: backgroundColor }}>

            <h1>{localStorage.getItem('nombre')}</h1>

            <Container className='FondoHome'>
                <Row>
                    <Col>
                        <InputGroup>
                            <Form.Control placeholder="Ingrese nombre"
                                onChange={(e) => {
                                    setBusqueda(e.target.value);
                                }} />
                            <Button variant="primary" id='botonBusqueda'
                                onClick={handleChange}>
                                <FaSearch></FaSearch>
                            </Button>
                        </InputGroup>
                    </Col>
                    <Col>
                        <Form.Select aria-label="Default select example"
                            onChange={(e) => { setFiltrados(e.target.value) }}>
                            <option value="-1">Tipo</option>
                            <option value="1">Seleccion</option>
                            <option value="2">Region</option>
                            <option value="3">Nombre Jugador</option>
                        </Form.Select>
                    </Col>
                </Row>
            </Container>

            <Container>
                <Row xs={1} md={2} lg={3} className="g-4">
                    {usuarios && usuarios.map((usuario, index) => {
                        return (
                            <Col key={index}>
                                <Carta
                                    nombre={usuario.nombre}
                                    contrasenna={usuario.contrasenna}
                                    onClick={onClick} />
                            </Col>
                        )
                    })}
                </Row>
            </Container>
            <Button variant="primary" onClick={() => {
                handleShow();
            }}>Ver Modal</Button>
            <Mensajes
                show={show} handleClose={handleClose}
                titulo="Mensaje de error"
                mensaje="Por favor espere mientras se soluciona"
            />
        </Container >
    )
}

export default About;
