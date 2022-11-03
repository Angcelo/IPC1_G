import { Button, Card } from "react-bootstrap";

function Carta( { nombre, contrasenna, onClick } ) {
    return (
        <Card style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Img variant="top" src="https://cdn-icons-png.flaticon.com/512/16/16363.png" />
                <Card.Title>{nombre}</Card.Title>
                <Card.Text>
                    {contrasenna}
                </Card.Text>
                <Button variant="primary" onClick={onClick}>Ver</Button>
            </Card.Body>
        </Card>
    )
}

export default Carta;