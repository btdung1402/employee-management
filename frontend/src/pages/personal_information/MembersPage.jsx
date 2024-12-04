import React, { useState, useEffect } from 'react';
import MembersList from "../../components/personal_information/MembersList.jsx";

const MembersPage = () => {

    return (
        <div className="content bg-white">
            <div className="row">
                <MembersList  />
            </div>
        </div>
    );
};

export default MembersPage;
