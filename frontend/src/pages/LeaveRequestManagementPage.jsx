import React from "react";
import { Routes, Route } from "react-router-dom";
import TopNavBarLeaveRequest from "../components/TopNavBarLeaveRequest";
import LeaveRequestPage from "./LeaveRequestPage";
// import LeaveRequestHistory from "./LeaveRequestHistory"; // Uncomment nếu cần

const LeaveRequestManagementPage = () => {
  return (
    <div style={{ marginTop: '60px'}}>
      {/* Top Navbar Leave Request */}
      <TopNavBarLeaveRequest />
      {/* Routes bên trong /leave-request */}
      <Routes>
        <Route path="new" element={<LeaveRequestPage />} />
        <Route path="" element={<LeaveRequestPage />} />
      </Routes>
    </div>
  );
};

export default LeaveRequestManagementPage;
