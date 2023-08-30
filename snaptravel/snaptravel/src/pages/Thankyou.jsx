import React from 'react'
import { Button, Col, Container, Row } from 'react-bootstrap'
import { useState, useEffect } from 'react'
import axios from 'axios'
import { Link, useNavigate } from 'react-router-dom'
const Thankyou = () => {

    const bookId = Number(localStorage.getItem('bookingId'))
    const [booked, setBooked] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        async function fetchBooking() {
            try {

                // Replace 'YOUR_API_ENDPOINT' with your actual API endpoint
                const response = await axios.get(`http://localhost:8080/api/bookings/${bookId}`);
                setBooked(response.data);
                console.log(booked);
            } catch (error) {
                console.error('Error fetching tour by ID', error);
            }
            


        }

        fetchBooking();
    }, [bookId]);
    return (

        <>
            <section>
                <Container>
                    <Row>
                        <Col lg="12">
                            <div>
                                <h3>Your Booking is confirmed</h3><Link to="/home"><Button>Home</Button></Link>
                            </div>

                        </Col>
                        {/* {booked?<h3>hello</h3>:<h3>hii</h3> } */}
                        <Col lg='8' className='column'>
                            
                            {booked ? <div className='describe'>
                                <h4>{booked.custName}</h4>
                                <h4>Booking id : {booked.bookingId}</h4>
                                <h4>Invoice sent on : {booked.email}</h4>
                                <p>
                                    <strong>Amount :</strong> INR.{booked.totalCost}<br />
                                    
                                </p>

                            </div>: <div>Not booked</div>}
                        </Col>
                    </Row>
                </Container>
            </section>
        </>
    )
}

export default Thankyou
