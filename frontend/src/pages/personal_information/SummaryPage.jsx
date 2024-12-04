import React, { useState, useEffect } from 'react';
import Summary from "../../components/personal_information/Summary.jsx";

const SummaryPage = () => {

    return (
        <div className="content bg-white">
            <Summary />
        </div>
    );
};

// Pass the employee prop to WithSidebar HOC
export default SummaryPage;