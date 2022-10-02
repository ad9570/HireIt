import axios from 'axios';
import React from 'react';
import { useEffect } from 'react';
import { useState } from 'react';
import Dashboard from './Dashboard';


// import CustomDocument from './CustomDocument';

// global.Buffer = global.Buffer || require('buffer').Buffer; // Buffer 추가

const Admin = () => {
    const [statistics, setStatistics] = useState({});
    const [userList, setUserList] = useState([]);
    const [applyList, setApplyList] = useState([]);

    const getStatistics = () => {
        const statUrl = `${process.env.REACT_APP_SPRING_URL}api/statistics`;
        const userUrl = `${process.env.REACT_APP_SPRING_URL}api/userList`;
        const corpUrl = `${process.env.REACT_APP_SPRING_URL}api/corpApply`;

        axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`;
        axios.get(statUrl)
        .then(res => {
            setStatistics(res.data);
        })
        axios.get(userUrl)
        .then(res => {
            setUserList(res.data);
            console.log(res.data);
        })
        axios.get(corpUrl)
        .then(res => {
            setApplyList(res.data);
            console.log(res.data);
        })
    }

    const applyHandle = (num, corp_idx, name) => {
        const handleUrl = `${process.env.REACT_APP_SPRING_URL}api/applyHandle`;

        axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`;
        axios.post(handleUrl, {num, corp_idx})
        .then(res => {
            alert(`개인 회원 ${name}이 기업 회원으로 변경되었습니다.`)
        })
    }

    useEffect(() => {
        getStatistics();
    }, [applyList])

    return (
        <div>
            <Dashboard statistics={statistics} userList={userList} applyList={applyList} applyHandle={applyHandle}/>
        </div>
    );
};

export default Admin;