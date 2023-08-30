import React, { useContext } from 'react'
import { Link, NavLink, useNavigate } from 'react-router-dom';
import "./header.css"


const nav__links = [
  {
    path: "/home",
    display: "Home",
  },

  {
    path: "/about",
    display: "About",
  },

  {
    path: "/tours",
    display: "Tours",
  },

  {
    path: "/booked",
    display: "My-Bookings",
  },
];

const admin_links = [
  {
    path: "/home",
    display: "Home",
  },

  {
    path: "/about",
    display: "About",
  },

  {
    path: "/tours",
    display: "Tours",
  },
  {
    path: "/createtour",
    display: "Create-Tour",
  },
  {
    path: "/allbookings",
    display: "All-Bookings",
  },
  {
    path: "/userdetails",
    display: "User-Details",
  },
];

const Header = () => {

  // const {user, dispatch} = useContext(AuthContext); 
  // const user = {
  //   name:"abhi",
  //   role:"user"
  // };

  // const logout = () => {
  //   dispatch({ type: "LOGOUT" });
  //   navigate("/");
  // };

  const user = localStorage.getItem("userRole");
  const userName = localStorage.getItem("userName");
  const navigate = useNavigate();
  const handleLogout = () => {
    localStorage.removeItem("userId");
    localStorage.removeItem("userRole");
    localStorage.removeItem("userName");
    localStorage.removeItem("bookingId");
    localStorage.removeItem("paymentId");
    // Redirect to login page or wherever you want after logout
    navigate("/");
  };

  return (
    <header className='header'>
      <div className='nav-wrapper'>
        <div className='logo'>
          <Link to="/"><h1>SnapTravel</h1></Link>
        </div>
        <div>
          <nav>
            {(user === "ADMIN" ? <ul className='nav-menu'>
              {admin_links.map((item, index) => (
                <li className='nav-item' key={index}>
                  <NavLink className="menu-link" to={item.path}>{item.display}</NavLink>
                </li>
              ))}
            </ul> : <ul className='nav-menu'>
              {nav__links.map((item, index) => (
                <li className='nav-item' key={index}>
                  <NavLink className="menu-link" to={item.path}>{item.display}</NavLink>
                </li>
              ))}
            </ul>)
            }

          </nav>
        </div>

        {user ? (user === "ADMIN" ? <div className='nav-buttons'><span><strong>{userName}</strong>(Admin)</span><button className='logout' onClick={handleLogout}>Logout</button></div> :
          <div className='nav-buttons'><span><strong>{userName}</strong>(Customer)</span><button className='logout' onClick={handleLogout}>Logout</button></div>
        ) :
          <div className='nav-buttons'>

            <button className='login'><Link to='/login'>Login</Link></button>
            <button className='signup'><Link to='/register'>Sign up</Link></button>

          </div>
        }

      </div>
    </header>


    // <header className='header'>
    //   <div className='nav-wrapper'>
    //     <div className='logo'>
    //       <Link to="/"><h1>SnapTravel</h1></Link>
    //     </div>
    //     <div>
    //       <nav>
    //         {user ? (
    //           <ul className='nav-menu'>
    //             {user === "ADMIN" ? (
    //               <>

    //                 {admin_links.map((item, index) => (
    //                   <li className='nav-item' key={index}>
    //                     <NavLink className="menu-link" to={item.path}>{item.display}</NavLink>
    //                   </li>
    //                 ))}
    //               </>
    //             ) : (
    //               <>
    //                 <li className='nav-item'>
    //                   <span className="menu-link">{userName}</span>
    //                 </li>
    //                 {nav__links.map((item, index) => (
    //                   <li className='nav-item' key={index}>
    //                     <NavLink className="menu-link" to={item.path}>{item.display}</NavLink>
    //                   </li>
    //                 ))}
    //               </>
    //             )}
    //             <li className='nav-item'>
    //                   <span >{userName} (ADMIN)</span>
    //                 </li>
    //             <li className='nav-item'>
    //               <button className='logout' onClick={handleLogout}>Logout</button>
    //             </li>
    //           </ul>
    //         ) : (
    //           <ul className='nav-menu'>
    //             <div className='nav-buttons'>

    //               <button className='login'><Link to='/login'>Login</Link></button>
    //               <button className='signup'><Link to='/register'>Sign up</Link></button>

    //             </div>
    //           </ul>
    //         )}
    //       </nav>
    //     </div>
    //   </div>
    // </header>

  )
}

export default Header
