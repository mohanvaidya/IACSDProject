import {React, useState, useEffect} from 'react'

import TourCard from '../shared/tourCard'
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import axios from 'axios';
// import tours from "../shared/demo_data"
import "../styles/tours.css"

const Tours = () => {

  const [tours, setTours] = useState([]);
  
  useEffect(() => {
    async function fetchTours() {
      try {
        // Replace 'YOUR_API_ENDPOINT' with your actual API endpoint
        const response = await axios.get('http://localhost:8080/api/packages/');
        setTours(response.data);
      } catch (error) {
        console.error('Error fetching tours', error);
      }
      
    }
    
    fetchTours();
  }, []);

  return (


    <div>
      <div className="search-tours">
        <div className="container-home">
          <label htmlFor="">Where you want to go</label>
          <input type="text" placeholder="Search Your location" />
        </div>
        <div className="container-home">
          <label htmlFor="">Country</label>
          <input type="text" placeholder='Country' />
        </div>
        {/* <div className="container">
              <label htmlFor="">Date</label>
              <input type="date" />
            </div> */}

        <button className='exp'>Search</button>
      </div>

      

      <Container className='card-container home-section'>
       
       
        {tours.map((tour) => (

          <TourCard tour={tour} />

        ))}

      </Container>
    </div>

  )
}

export default Tours
