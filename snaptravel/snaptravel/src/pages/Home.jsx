import React from 'react'
import layerimg from "../assets/images/layer.png"
import "../styles/home.css"
import Gallery from '../components/Gallery/Gallery'
import Service from '../components/Services/Service'


const Home = () => {
  return (
    <>
      <section id="hero" className='home-section'>
        <div className="background">
          <img className="bg" src={layerimg} alt="" />
        </div>
        <div className="content">
          <div className="title">
            <h1 className='tag'>TRAVEL TO EXPLORE</h1>
            <p>
              "Embark on a journey of limitless horizons with our travel website. Discover new destinations, immerse yourself in diverse cultures, and create memories that last a lifetime. Whether you're seeking the tranquility of serene landscapes or the thrill of urban exploration, our platform is your gateway to unforgettable experiences."
            </p>
          </div>
          <div className="search">
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

            <button className='exp'>Explore Now</button>
          </div>
        </div>
      </section>
      <section>
        <div className='gal-text'>
          <h3 >What we offer</h3>
        </div>
        <Service />
      </section>
      <section>
        <div className='gal-text'>
          <h3 >Gallery</h3>
        </div>

        <Gallery />
      </section>
    </>
  )
}

export default Home
