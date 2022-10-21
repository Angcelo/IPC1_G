import { useEffect, useState } from "react";
import { Card, CardGroup, Container } from "react-bootstrap";


function About() {

    const [usuarios, setUsuarios] = useState('');

    useEffect(() => {
        fetch('http://localhost:3030/usuarios').then(res => {
            if (res.ok) {
                return res.json();
            } else {
                return Promise.reject("Fallo en la consulta");
            }
        }).then(data => {
            console.log(data);
            setUsuarios(data.data);
        }).catch(err => {
            alert(err);
        })
    }, []);

    return (
        <Container>
            <h1>{localStorage.getItem('nombre')}</h1>
            <CardGroup>
                {usuarios && usuarios.map((usuario, index) => {
                    return (
                        <Card style={{ width: '18rem' }} key={index}>
                            <Card.Body>
                                <Card.Img variant="top" src={usuario.Img} />
                                <Card.Title>{usuario.nombre} {usuario.apellido}</Card.Title>
                                <Card.Text>
                                    {usuario.contrasenna}
                                    {usuario.email}
                                    {usuario.telefono}
                                </Card.Text>
                            </Card.Body>
                        </Card>
                    )
                })}
            </CardGroup>
        </Container >
    )
}

export default About;
