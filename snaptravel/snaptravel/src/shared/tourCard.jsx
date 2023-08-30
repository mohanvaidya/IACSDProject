import React from 'react'
import { Link } from "react-router-dom";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import "../styles/tours.css"

const tourCard = ({ tour }) => {
    const { packId,
        name,
        description,
        accomodation,
        duration,
        price,
        activities,
        country,
        city,
        photourl } = tour;

    return (
        <section>
            <Card style={{ width: '18rem' }}>
                <Card.Img variant="top" src={photourl}
                    style={{ width: '18rem', height: '12rem' }} />
                <Card.Body className='card-body'>
                    <Card.Title>{name}</Card.Title>
                    <Card.Text>
                        <strong>Country :</strong> {country}
                    </Card.Text>
                    <Card.Text>
                        <strong>City :</strong> {city}
                    </Card.Text>
                    <Card.Text>
                    <strong>Description :</strong>{description}
                    </Card.Text>
                    <Card.Text>
                    <strong>Duration :</strong>{duration}
                    </Card.Text>
                    <Card.Text>
                    <strong>Accomodation :</strong>{accomodation}
                    </Card.Text>
                    <Card.Text>
                    <strong>Activities :</strong>{activities}
                    </Card.Text>
                    <Card.Text>
                    <strong>Price :</strong>{price}
                    </Card.Text>
                    <Link to={`/tours/${packId}`}>
                        <Button variant="primary">Book Now</Button>
                    </Link>

                </Card.Body>
            </Card>
        </section>

    )
}

export default tourCard
