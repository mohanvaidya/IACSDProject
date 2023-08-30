import React, { useState } from 'react'
import { Button, Table } from 'react-bootstrap'
import axios from 'axios'

const UserDetails = () => {
    
    const [users, setUsers] = useState([]);
    const handleClick = async (e) =>{
        const res= axios.get("http://localhost:8080/user/");
        
        const data= (await res).data;
        console.log(data)
        setUsers((await res).data)
    }
  return (
    <div>
      <Button onClick={handleClick}>Fetch Users</Button>
      <Table >
      <thead>
        <tr>
          <th>User id</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Role</th>
          <th>Contact </th>
        </tr>
      </thead>
      <tbody>
      {users.map((user, index) => (
        <tr key={index}>
            <td>{user.userId}</td>
            <td>{user.first_name}</td>
            <td>{user.last_name}</td>
            <td>{user.email}</td>
            <td>{user.role}</td>
            <td>{user.contactNo}</td>
        </tr>
      ))}
        
      </tbody>
    </Table>
    </div>
  )
}

export default UserDetails
