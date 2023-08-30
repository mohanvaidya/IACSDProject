import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import axios from 'axios'
import registerImg from "../assets/images/Signup.jpg"
import "../styles/register.css"


const Register = () => {
  const [credentials, setCredentials] = useState({

    first_name: undefined,
    last_name: undefined,
    role:"CUSTOMER",
    email: undefined,
    password: undefined,
    contactNo: undefined

  });
  
  const navigate=useNavigate();

  const handleChange = (e) => {
    setCredentials((prev) => ({ ...prev, [e.target.id]: e.target.value }));
  };
  
  const handleClick = async (e) =>{
    e.preventDefault();
    console.log(credentials);
    try {
      const response = await axios.post('http://localhost:8080/user/', credentials);
  
      if (response.status === 201) {
        console.log('User registered successfully');
        navigate("/login")
      } else {
        console.log('Failed to register user');
      }
    } catch (error) {
      console.error('Error registering user', error);
    }
  }

  return (
    <section className='home-section'>
      <div className="main-container" id="container">
        <div className="form-container log-in-container">
          <form onSubmit={handleClick}>
            <h1>Sign up</h1>
            <input type="text" placeholder="First Name" id="first_name" onChange={handleChange}/>
            <input type="text" placeholder="Last Name" id="last_name" onChange={handleChange}/>
            <input type="email" placeholder="Email" id="email" onChange={handleChange}/>
            <input type="password" placeholder="Password" id="password" onChange={handleChange}/>
            <input type="text" placeholder="Phno" id="contactNo" onChange={handleChange}/>
            <button className='login-button'>Sign up</button>
            <text>Already have an account?<Link to="/login">Login here</Link></text>

          </form>
        </div>
        <div class="overlay-container">
          <div class="overlay">
            <div class="overlay-panel overlay-right">
              <img src={registerImg} />
            </div>
          </div>
        </div>
      </div>
    </section>
  )
}

export default Register;
