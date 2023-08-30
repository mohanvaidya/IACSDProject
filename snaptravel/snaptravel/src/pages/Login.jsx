
import React, { useState } from 'react'

import "../styles/login.css"
import{Link, useNavigate} from 'react-router-dom';
import axios from 'axios';
import loginImg from "../assets/images/loginImg.jpg"
const Login = () => {
  const navigate = useNavigate();
  const [credentials, setCredentials] = useState({
    email: undefined,
    password: undefined,
  });
 
  const handleChange = (e) => {
    setCredentials((prev) => ({ ...prev, [e.target.id]: e.target.value }));
  };

  const handleClick = async (e) =>{
    e.preventDefault();
    console.log(credentials);
    // http://localhost:8080/api/users/login
    try {
      const response = await axios.post('http://localhost:8080/api/users/login', credentials);

      if (response.status === 200) {
        console.log('Login successful');
        // Store user role in local storage
        localStorage.setItem('userId', response.data.userId)
        localStorage.setItem('userRole', response.data.role);
        localStorage.setItem('userName', response.data.first_name);
        // Redirect to home page
        navigate("/")
        
      } else {
        console.log('Login failed');
      }
    } catch (error) {
      console.error('Error during login', error);
    }
  }

  return (
    <section className='home-section'>
      <div className="main-container" id="container">
        <div className="form-container log-in-container">
          <form action="#" onSubmit={handleClick}>
            <h1>Login</h1>
            <div className="social-container">
              {/* <a href="#" className="social"><i className="fa-brands fa-google-plus-g"></i></a> */}
              {/* <a href="#" className="social"><i className="fab fa fa-twitter fa-2x"></i></a> */}
            </div>
            
            <input type="email" placeholder="Email" id='email' onChange={handleChange}/>
            <input type="password" placeholder="Password" id='password' onChange={handleChange}/>
            <a href="#">Forgot your password?</a>
            <Link to='/register'>Create account</Link>
            <button className='login-button'>Log In</button>
          </form>
        </div>
        <div className="overlay-container">
          <div className="overlay">
            <div className="overlay-panel overlay-right">
              <img src={loginImg}/>
            </div>
          </div>
        </div>
      </div>
    </section>
  )
}

export default Login
