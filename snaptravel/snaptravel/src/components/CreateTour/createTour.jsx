import React, { useState } from 'react'
import "./createtour.css"
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import axios from 'axios';

const CreateTour = () => {

    const [formData, setFormData] = useState({
        name: '',
        country: '',
        city: '',
        description: '',
        accomodation: '',
        duration: '',
        price: 1,
        activities: '',
        photourl: ''
    });

    const handleChange = (e) => {
        setFormData((prev) => ({ ...prev, [e.target.id]: e.target.value }));
      };
    
      const handleSubmit = async (e) => {
        e.preventDefault();
        console.log(formData);
        try {
            // Replace 'YOUR_API_ENDPOINT' with your actual API endpoint
            const response = await axios.post('http://localhost:8080/api/packages/', formData);

            if (response.status === 200) {
                // Show success alert
                alert('Data added successfully');
                // Clear form inputs to default values
                setFormData({
                    name: '',
                    country: '',
                    city: '',
                    description: '',
                    accomodation: '',
                    duration: '',
                    price: '',
                    activities: '',
                    photourl: ''
                });
            } else {
                console.log('Failed to add data');
            }
        } catch (error) {
            console.error('Error adding data', error);
        }
    };

   return (
        <section className='home-section'>
            <Form className='create-form' onSubmit={handleSubmit}>
                <Row className="mb-3 form-row">
                    <h2>Add Package</h2>
                    <Form.Group as={Col} controlId="name" >
                        <Form.Label>Package Name</Form.Label>
                        <Form.Control type="text" placeholder="Enter package name" onChange={handleChange}/>
                    </Form.Group>

                    <Form.Group as={Col} controlId="country" >
                        <Form.Label>Country</Form.Label>
                        <Form.Control type="text" placeholder="Enter country" onChange={handleChange}/>
                    </Form.Group>

                    <Form.Group as={Col} controlId="city" >
                        <Form.Label>City</Form.Label>
                        <Form.Control type="text" placeholder="Enter city" onChange={handleChange}/>
                    </Form.Group>

                    <Form.Group as={Col} controlId="description">
                        <Form.Label>Description</Form.Label>
                        <Form.Control type="text" placeholder="Description" onChange={handleChange}/>
                    </Form.Group>

                    <Form.Group as={Col} controlId="accomodation">
                        <Form.Label>Accomodation</Form.Label>
                        <Form.Control type="text" placeholder="Accomodation" onChange={handleChange}/>
                    </Form.Group>

                    <Form.Group as={Col} controlId="duration">
                        <Form.Label>Duration</Form.Label>
                        <Form.Control type="text" placeholder="Duration e.g. 3N 4D" onChange={handleChange}/>
                    </Form.Group>

                    <Form.Group as={Col} controlId="price">
                        <Form.Label>Price</Form.Label>
                        <Form.Control type="number" placeholder="Package price per person" onChange={handleChange}/>
                    </Form.Group>

                    <Form.Group as={Col} controlId="activities">
                        <Form.Label>Activities</Form.Label>
                        <Form.Control type="text" placeholder="Activities" onChange={handleChange}/>
                    </Form.Group>

                    <Form.Group as={Col} controlId="photourl">
                        <Form.Label>Photo Url</Form.Label>
                        <Form.Control type="text" placeholder="URL" onChange={handleChange}/>
                    </Form.Group>
                </Row>

                <Button variant="primary" type="submit" className='btn-createTour'>
                    Submit
                </Button>


            </Form>

            {/* <div id="show">
                package
            </div> */}

        </section>
    )
}

export default CreateTour
