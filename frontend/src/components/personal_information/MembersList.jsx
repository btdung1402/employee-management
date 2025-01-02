import React, { useState, useEffect, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import "../../../public/css/personal_information/MembersList.css";
import { getTeamMates } from "../../apis/api.js";
import { UserContext } from "./UserProvider.jsx";

const MembersList = () => {
    const navigate = useNavigate();
    const { user } = useContext(UserContext);
    const [teamMates, setTeamMates] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchTeamMates = async () => {
            try {
                const data = await getTeamMates();
                setTeamMates(data);
            } catch (err) {
                console.error("Failed to fetch team mates:", err);
                setError("Failed to load team mates. Please try again.");
            } finally {
                setLoading(false);
            }
        };

        fetchTeamMates();
    }, []);

    const handleRowClick = (id) => {
        if (id === user?.id) {
            navigate(`/personal-info/summary`);
        } else {
            navigate(`/profile/${id}/summary`);
        }
    };

    if (loading) {
        return <div className="content bg-white">Loading...</div>;
    }

    if (error) {
        return <div className="content bg-white text-danger">{error}</div>;
    }

    return (
        <div className="bg-white">
            <h4>Team Mates:</h4>
            {teamMates && teamMates.length > 0 ? (
                <table className="table table-bordered table-hover">
                    <thead className="table-light">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Email</th>
                        <th>Organization</th>
                        <th>Manager</th>
                    </tr>
                    </thead>
                    <tbody>
                    {teamMates.map((mate) => (
                        <tr key={mate.id} onClick={() => handleRowClick(mate.id)}>
                            <td>{mate.id}</td>
                            <td>{mate.name}</td>
                            <td>{mate.type}</td>
                            <td>{mate.emailCompany}</td>
                            <td>{mate.organizationName}</td>
                            <td>{mate.managerName}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            ) : (
                <p>No team mates available.</p>
            )}
        </div>
    );
};

export default MembersList;