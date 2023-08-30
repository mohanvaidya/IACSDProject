import React, { useState } from 'react'
import "./booking.css"
import Button from 'react-bootstrap/Button';

import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import { Link, useNavigate } from 'react-router-dom';

import axios from 'axios';

const Booking = ({ pack }) => {

   const { price, name, packId } = pack;
 
   const navigate = useNavigate();

    const [booking, setBooking] = useState({
        custName: "",
        email: "",
        contactNo: "",
        travelers: 0,
        bookingDate: "",
        

    })

    const [selectedPaymentMethod, setSelectedPaymentMethod] = useState(null);
    const [paymentId, setPaymentId] = useState(null);

    const handleChange = (e) => {
        setBooking(
            (prev) => ({ ...prev, [e.target.id]: e.target.value }),
        );
    };

    const handlePaymentMethodChange = (e) => {
        setSelectedPaymentMethod(e.target.value);
    };
    
    const serviceCharge = 0.1 * Number(price * booking.travelers)
    const totalAmount = serviceCharge + booking.travelers * Number(price);

    const handleDoPayment = async () => {
        try {
            const currentDate = new Date().toISOString().split('T')[0]; // Get the current date in "YYYY-MM-DD" format

            
            const response = await axios.post('http://localhost:8080/api/payments/', {
                amount: totalAmount,
                paymentMethod: selectedPaymentMethod,
                paymentdate: currentDate, // Include the current date
            });

            
            setPaymentId(response.data.paymentId);
            localStorage.setItem('paymentId', response.data.paymentId);
 
            
        } catch (error) {
            console.error("Payment error:", error);
        }
    };
    
    const handleBook = async (e) => {
        e.preventDefault();
        if (paymentId && booking.custName && booking.email && booking.travelers && booking.bookingDate) {
            // All necessary values are populated, proceed to booking
            console.log(booking);
            // console.log( {
            //     custName: booking.custName,
            //     email: booking.email,
            //     travelers: booking.travelers,
            //     bookingDate: booking.bookingDate,
            //     totalCost: totalAmount,
            //     userId: localStorage.getItem('userId'), // Fetch user ID from local storage
            //     paymentId: paymentId, // Use the paymentId from state
            //     travelPackageId: packId, // Use the travel package ID from props
            //     contactNo: booking.contactNo,
            // });
            try {
                const response = await axios.post('http://localhost:8080/api/bookings/', {
                    custName: booking.custName,
                    email: booking.email,
                    travelers: booking.travelers,
                    bookingDate: booking.bookingDate,
                    totalCost: totalAmount,
                    userId: localStorage.getItem('userId'), // Fetch user ID from local storage
                    paymentId: paymentId, // Use the paymentId from state
                    travelPackageId: packId, // Use the travel package ID from props
                    contactNo: booking.contactNo,
                });
                // Handle success or error response here
                console.log("Booking response:", response.data);
                if(response.status===200){
                    localStorage.setItem('bookingId',response.data.bookingId)
                    navigate("/thankyou");
                }
                
            } catch (error) {
                console.error("Booking error:", error);
            }
        } else {
            console.error("Required booking information missing.");
        }
    };

    
    return (
        <div className='booking-form'>
            <Form >
                <Row className="mb-3">
                    <Form.Group as={Col} controlId="custName">
                        <Form.Label>Customer</Form.Label>
                        <Form.Control type="text" placeholder="Enter Name" onChange={handleChange} />
                    </Form.Group>
                    <Form.Group as={Col} controlId="email">
                        <Form.Label>Email</Form.Label>
                        <Form.Control type="email" placeholder="Email" onChange={handleChange} />
                    </Form.Group>

                    <Form.Group as={Col} controlId="contactNo">
                        <Form.Label>Phon no.</Form.Label>
                        <Form.Control type="text" placeholder="Phno" onChange={handleChange} />
                    </Form.Group>

                    <Form.Group as={Col} controlId="travelers">
                        <Form.Label>Number of travelers</Form.Label>
                        <Form.Control type="Number" placeholder="Enter number" onChange={handleChange} />
                    </Form.Group>

                    <Form.Group as={Col} controlId="bookingDate">
                        <Form.Label>Date of trip</Form.Label>
                        <Form.Control type="date" placeholder="Enter Date" onChange={handleChange} />
                    </Form.Group>
                    <strong>Total amount : Rs. {totalAmount}</strong>
                    <Form.Group as={Col} controlId="paymentMethod">
                        <Form.Label>Select Payment Method</Form.Label>
                        <div>
                            <Form.Check
                                inline
                                type="radio"
                                label="UPI"
                                value="UPI"
                                name="paymentMethod"
                                onChange={handlePaymentMethodChange}
                            />
                            <Form.Check
                                inline
                                type="radio"
                                label="CREDIT_CARD"
                                value="CREDIT_CARD"
                                name="paymentMethod"
                                onChange={handlePaymentMethodChange}
                            />
                            <Form.Check
                                inline
                                type="radio"
                                label="DEBIT_CARD"
                                value="DEBIT_CARD"
                                name="paymentMethod"
                                onChange={handlePaymentMethodChange}
                            />
                            <Form.Check
                                inline
                                type="radio"
                                label="NET_BANKING"
                                value="NET_BANKING"
                                name="paymentMethod"
                                onChange={handlePaymentMethodChange}
                            />
                        </div>
                    </Form.Group>
                    <Button variant="primary" onClick={handleDoPayment}>
                        Do Payment
                    </Button>
                </Row>
                <Button variant="primary" type="submit" onClick={handleBook}>
                    
                        {paymentId ? "Book" : "Complete Payment First"}
                    
                </Button>
                {/* <Button variant="primary" type="submit">
                    <Link to="/thankyou">
                        Book
                    </Link>
                </Button> */}
            </Form>
        </div>
    )
}

export default Booking
