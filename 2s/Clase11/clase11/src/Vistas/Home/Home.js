import { useState } from 'react';
import { Container, Form } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import { useNavigate } from 'react-router-dom';

function Home() {
    const navigate = useNavigate();

    const [usuario, setUsuario] = useState('');
    const [contraseña, setContraseña] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        fetch('http://localhost:3030/login',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({nombre:usuario, contrasenna:contraseña})
        }).then(res => {
            if(res.ok){
                return res.json();
            }else {
                return Promise.reject("Fallo en el login");
            }
        }).then(data => {
            console.log(data);
            localStorage.setItem('nombre', data.data);
            alert("Login correcto");
            navigate('/about');
        }).catch(err => {
            alert(err);
        })
    }

    const irAbout = () => {
        navigate('/about');
    }

    return (
        <Container>
            <h1>Login</h1>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formBasicEmail">
                    <Form.Label>Usuario</Form.Label>
                    <Form.Control type="text" placeholder="Ingrese su usuario" onChange={(e)=>{
                        setUsuario(e.target.value);
                    }} />
                </Form.Group>
                <Form.Group controlId="formBasicPassword">
                    <Form.Label>Contraseña</Form.Label>
                    <Form.Control type="password" placeholder="Ingrese su contraseña" onChange={(e)=>{
                        setContraseña(e.target.value);
                    }} />
                </Form.Group>
                <Button variant="primary" type="submit">Ingresar</Button>
            </Form>
            <Button variant="primary" onClick={irAbout}>Ir a About</Button>
        </Container>
    )
}

export default Home;