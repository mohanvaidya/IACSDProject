import React from 'react'
import {Routes, Route, Navigate} from 'react-router-dom'
import Home from "../pages/Home";
import Tours from "../pages/Tours";
import TourDetails from "../pages/TourDetails";
import Login from "../pages/Login";
import Register from "../pages/Register";
import About from '../pages/About';
import Thankyou from '../pages/Thankyou';
import CreateTour from '../components/CreateTour/createTour'
import MyBookings from '../pages/MyBookings';
import Allbookings from '../pages/Allbookings';
import UserDetails from '../pages/UserDetails';

const Routers = () => {
  return (
    <Routes>
        <Route path='/' element={<Navigate to='/home'/>} />
        <Route path='/home'element={<Home/>}/>
        <Route path='/about'element={<About/>}/>
        <Route path='/tours'element={<Tours/>}/>
        <Route path='/tours/:id'element={<TourDetails/>}/>
        <Route path='/login'element={<Login/>}/>
        <Route path='/register'element={<Register/>}/>
        <Route path='/thankyou'element={<Thankyou/>}/>
        <Route path='/createtour' element={<CreateTour/>}/>
        <Route path='/booked' element={<MyBookings/>}/>
        <Route path='/allbookings' element={<Allbookings/>}/>
        <Route path='/userdetails' element={<UserDetails/>}/>

    </Routes>
  )
}

export default Routers
