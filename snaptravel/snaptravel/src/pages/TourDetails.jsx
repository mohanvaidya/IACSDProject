import {React, useState, useEffect} from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import tours from "../shared/demo_data"
import "../styles/tours.css"
import { Container } from 'react-bootstrap';
import Booking from '../components/Booking/Booking';
import axios from 'axios';
import { Link } from 'react-router-dom';




const TourDetails = () => {
  
  const user=localStorage.getItem('userRole');
   
  const Navigate= useNavigate();
  
  
  const { id } = useParams();
  
  const [tour, setTour] = useState([]);

  useEffect(() => {
    async function fetchTourById() {
      try {
        
        // Replace 'YOUR_API_ENDPOINT' with your actual API endpoint
        const response = await axios.get(`http://localhost:8080/api/packages/${id}`);
        setTour(response.data);
      } catch (error) {
        console.error('Error fetching tour by ID', error);
      }
      console.log(id)
      console.log(tour)
      
      
    }

    fetchTourById();
  }, [id]);

  

  return (
    <>
      {user? <Container>
      <Row className='overview'>
        <Col lg='8' className='column'>
          <div className='package-overview'>
            <img src={tour.photourl} />

          </div>
          <div className='describe'>
             <h3>{tour.name}</h3>
             <h4>Country: {tour.country}</h4>
             <h4>City: {tour.city}</h4>
             <p>
              <strong>Price:</strong> INR.{tour.price} /per person<br/>
             <strong>Description:</strong> {tour.description}<br/>
             <strong>Duration:</strong> {tour.duration}<br/>
             <strong>Accomodation:</strong> {tour.accommodation}<br/>
             </p>
             
          </div>
        </Col>
        <Col lg="4">
          <Booking pack={tour}/>
        </Col>
      </Row>

    </Container>:<div> <h3>Please login first </h3> <Link to="/login"><button>Login</button></Link></div>}
    </>
    
  )
}

export default TourDetails
