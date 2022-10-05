import axios from 'axios';
import React from 'react';
import { useEffect } from 'react';
import { useState } from 'react';
import Admin from './Admin';
import Corp from './Corp';
import User from './User';

const MyPage = () => {
    const [userData, setUserData] = useState();

    const userRole = () => {
        const roleUrl = `${process.env.REACT_APP_SPRING_URL}api/user`;

        axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`;
        axios.get(roleUrl)
        .then(res => {
            setUserData(res.data);
        })
    }

    useEffect(() => {
        userRole();
    }, [])

    return (
        <div>
            {userData &&
                (userData.authorityDtoSet[0].authorityName === 'ROLE_ADMIN' ? <Admin/>
                : userData.authorityDtoSet[0].authorityName === 'ROLE_USER' ? <User/>
                : <Corp/>)
            }
        </div>
    );
};

export default MyPage;